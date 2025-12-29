package com.tcs.dto;

public record LaptopRequest(
 String brand,
 String model,
 String serialNumber,
 String cpu,
 Integer ramGb,
 Double price
) {}

