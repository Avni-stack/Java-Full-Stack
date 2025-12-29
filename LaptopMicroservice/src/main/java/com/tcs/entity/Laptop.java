package com.tcs.entity;
import jakarta.persistence.*;

@Entity @Table(name = "laptop")
public class Laptop {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

  private String brand;
  private String model;

 @Column(name = "serial_number", unique = true)
 private String serialNumber;

 private String cpu;
 private Integer ramGb;
 private Double price;
public Laptop() {
	super();
}
public Laptop(String brand, String model, String serialNumber, String cpu, Integer ramGb, Double price) {
	super();
	this.brand = brand;
	this.model = model;
	this.serialNumber = serialNumber;
	this.cpu = cpu;
	this.ramGb = ramGb;
	this.price = price;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getSerialNumber() {
	return serialNumber;
}
public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
}
public String getCpu() {
	return cpu;
}
public void setCpu(String cpu) {
	this.cpu = cpu;
}
public Integer getRamGb() {
	return ramGb;
}
public void setRamGb(Integer ramGb) {
	this.ramGb = ramGb;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}

 
}
