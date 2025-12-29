package com.tcs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order20")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private Long productId;
    private Integer quantity;
    private Double totalPrice;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Long productId, Integer quantity, Double totalPrice) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
    // Getters & Setters
}