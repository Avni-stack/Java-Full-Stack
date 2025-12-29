package com.tcs.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.tcs.dto.LaptopRequest;
import com.tcs.dto.LaptopResponse;
import com.tcs.service.LaptopService;

import java.util.List;

@RestController @RequestMapping("/api/laptops") @Validated
public class LaptopController {
 private final LaptopService svc;
 public LaptopController(LaptopService svc) { this.svc = svc; }

 @PostMapping public ResponseEntity<LaptopResponse> create(@RequestBody @Validated LaptopRequest req) { return ResponseEntity.ok(svc.create(req)); }
 @GetMapping("/{id}") public ResponseEntity<LaptopResponse> get(@PathVariable Long id) { return ResponseEntity.ok(svc.get(id)); }
 @GetMapping public ResponseEntity<List<LaptopResponse>> all() { return ResponseEntity.ok(svc.getAll()); }
 @PutMapping("/{id}") public ResponseEntity<LaptopResponse> update(@PathVariable Long id, @RequestBody @Validated LaptopRequest req) { return ResponseEntity.ok(svc.update(id, req)); }
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { svc.delete(id); return ResponseEntity.noContent().build(); }
}


