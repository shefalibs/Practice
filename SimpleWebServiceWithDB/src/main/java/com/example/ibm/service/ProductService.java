package com.example.ibm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ibm.model.Product;


public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product getProduct(int id);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(int id, Product product);
	
	public void deleteProduct(int id);

}
