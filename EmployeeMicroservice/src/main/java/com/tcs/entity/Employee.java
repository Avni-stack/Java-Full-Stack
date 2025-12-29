package com.tcs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="Employee")
public class Employee {

	@Id
       private long id;
       private String ename;
       private String edept;
       @Column (name="elaptopId", unique=true)
       private int elaptopId;
       
       public Employee() {
   		super();
   	}

	public Employee(String ename, String edept, int elaptopid) {
		super();
		this.ename = ename;
		this.edept = edept;
		this.elaptopid = elaptopid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEdept() {
		return edept;
	}

	public void setEdept(String edept) {
		this.edept = edept;
	}

	public int getElaptopid() {
		return elaptopid;
	}

	public void setElaptopid(int elaptopid) {
		this.elaptopid = elaptopid;
	}
       
       
}
