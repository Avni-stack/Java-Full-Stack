package com.tcs.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 Optional<Employee> findByLaptopId(Long laptopId); 
}



