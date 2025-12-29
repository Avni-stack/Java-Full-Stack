package com.tcs.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.dto.LaptopRequest;
import com.tcs.dto.LaptopResponse;
import com.tcs.entity.Laptop;
import com.tcs.repository.LaptopRepository;

import java.util.List;

@Service @Transactional
public class LaptopService {
 private final LaptopRepository repo;
 public LaptopService(LaptopRepository repo) { this.repo = repo; }

 public LaptopResponse create(LaptopRequest req) {
     Laptop l = new Laptop();
     l.setBrand(req.brand()); l.setModel(req.model()); l.setSerialNumber(req.serialNumber());
     l.setCpu(req.cpu()); l.setRamGb(req.ramGb()); l.setPrice(req.price());
     repo.save(l);
     return toDto(l);
 }
 public LaptopResponse get(Long id) {
     Laptop l = repo.findById(id).orElseThrow(() -> new RuntimeException("Laptop not found: " + id));
     return toDto(l);
 }
 public List<LaptopResponse> getAll() {
     return repo.findAll().stream().map(this::toDto).toList();
 }
 public LaptopResponse update(Long id, LaptopRequest req) {
     Laptop l = repo.findById(id).orElseThrow(() -> new RuntimeException("Laptop not found: " + id));
     l.setBrand(req.brand()); l.setModel(req.model()); l.setSerialNumber(req.serialNumber());
     l.setCpu(req.cpu()); l.setRamGb(req.ramGb()); l.setPrice(req.price());
     return toDto(l);
 }
 public void delete(Long id) { repo.deleteById(id); }

 private LaptopResponse toDto(Laptop l) {
     return new LaptopResponse(l.getId(), l.getBrand(), l.getModel(), l.getSerialNumber(), l.getCpu(), l.getRamGb(), l.getPrice());
 }
}
