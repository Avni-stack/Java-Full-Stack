package com.tcs.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "laptop-service", url = "${laptop.service.url}")
public interface LaptopClient {
 @GetMapping("/api/laptops/{id}")
 LaptopDto() getLaptop(@PathVariable("id") Long id);
}
