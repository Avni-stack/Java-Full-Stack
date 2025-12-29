package com.tcs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.dto.EmployeeRequest;
import com.tcs.dto.EmployeeResponse;
import com.tcs.dto.EmployeeWithLaptopResponse;
import com.tcs.service.EmployeeService;

@RestController @RequestMapping("/api/employees") @Validated
public class EmployeeController
{
 private final EmployeeService svc;
 public EmployeeController(EmployeeService svc) { this.svc = svc; }

 @PostMapping 
 public ResponseEntity<EmployeeResponse> create(@RequestBody @Validated EmployeeRequest req) 
 { 
	 return ResponseEntity.ok(svc.create(req)); 
	 }
 @GetMapping("/{id}") 
 public ResponseEntity<EmployeeResponse> get(@PathVariable Long id) 
 { 
	 return ResponseEntity.ok(svc.get(id)); 
	 }
 @PutMapping("/{id}") 
 public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @RequestBody @Validated EmployeeRequest req) 
 { 
	 return ResponseEntity.ok(svc.update(id, req)); 
	 }
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) 
 { svc.delete(id); return ResponseEntity.noContent().build(); }

 @PutMapping("/{id}/assign-laptop/{laptopId}")
 public ResponseEntity<EmployeeResponse> assignLaptop(@PathVariable Long id, @PathVariable Long laptopId) 
 {
     return ResponseEntity.ok(svc.assignLaptop(id, laptopId));
 }

 @GetMapping("/{id}/with-laptop")
 public ResponseEntity<EmployeeWithLaptopResponse> withLaptop(@PathVariable Long id) 
 {
     return ResponseEntity.ok(svc.getWithLaptop(id));
 }
}

