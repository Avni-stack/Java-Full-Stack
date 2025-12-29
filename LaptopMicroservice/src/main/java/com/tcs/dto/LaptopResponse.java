package com.tcs.dto;

public record LaptopResponse(
		 Long id, String brand, String model, String serialNumber, String cpu, Integer ramGb, Double price
		) {}