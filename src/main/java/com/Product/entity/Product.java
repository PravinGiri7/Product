package com.Product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private int pid;
	private double version;
	private String name;
	private double price;
	public int getProductid() {
		return pid;
	}
	public void setProductid(int productid) {
		this.pid = productid;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", version=" + version + ", name=" + name + ", price=" + price + "]";
	}	
}
