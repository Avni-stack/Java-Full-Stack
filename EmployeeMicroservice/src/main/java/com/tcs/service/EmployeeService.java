package com.tcs.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.dto.EmployeeRequest;
import com.tcs.dto.EmployeeResponse;
import com.tcs.dto.EmployeeWithLaptopResponse;
import com.tcs.dto.LaptopDto;
import com.tcs.entity.Employee;
import com.tcs.repository.EmployeeRepository;

@Service @Transactional
public class EmployeeService {
 private final EmployeeRepository repo;
 private final LaptopClient laptopClient;

 public EmployeeService(EmployeeRepository repo, LaptopClient laptopClient) {
     this.repo = repo; this.laptopClient = laptopClient;
 }

 public EmployeeResponse create(EmployeeRequest req) {
     Employee e = new Employee();
     e.setName(req.name()); e.setDepartment(req.edept());
     e.setLaptopId(null);
     repo.save(e);
     return toDto(e);
 }

 public EmployeeResponse get(Long id) {
     Employee e = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found: " + id));
     return toDto(e);
 }

 public EmployeeResponse update(Long id, EmployeeRequest req) {
     Employee e = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found: " + id));
     e.setName(req.name()); e.setEmail(req.email()); e.setDepartment(req.department());
     return toDto(e);
 }

 public void delete(Long id) 
 { 
	 repo.deleteById(id); 
 }
 
 
 public EmployeeResponse assignLaptop(Long employeeId, Long laptopId) 
 {
     Employee e = repo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found: " + employeeId));

     // Validate laptop exists in Laptop service
     LaptopDto laptop = laptopClient.getLaptop(laptopId);
     if (laptop == null || laptop.id() == null) throw new RuntimeException("Laptop not found: " + laptopId);

     // Ensure not already assigned elsewhere
     repo.findByLaptopId(laptopId).ifPresent(existing -> 
     {
         if (!existing.getId().equals(employeeId)) 
         {
             throw new RuntimeException("Laptop already assigned to employeeId=" + existing.getId());
         }
     });

     e.setLaptopId(laptopId);
     return toDto(e);
 }


 public EmployeeWithLaptopResponse getWithLaptop(Long employeeId) 
 {
     Employee e = repo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found: " + employeeId));
     LaptopDTO laptop = (e.getLaptopId() != null) ? laptopClient.getLaptop(e.getLaptopId()) : null;
     return new EmployeeWithLaptopResponse(toDto(e), laptop);
 }

 private EmployeeResponse toDto(Employee e) 
 {
     return new EmployeeResponse(e.getId(), e.getName(), e.getEmail(), e.getDepartment(), e.getLaptopId());
 }
}


