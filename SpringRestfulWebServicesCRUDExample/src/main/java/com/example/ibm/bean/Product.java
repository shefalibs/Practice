package com.example.ibm.bean;

public class Product{
	
	int id;
	String productName;	
	long price;
	
	public Product() {
		super();
	}
	public Product(int i, String productName,long price) {
		super();
		this.id = i;
		this.productName = productName;
		this.price=price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}	
	
}


