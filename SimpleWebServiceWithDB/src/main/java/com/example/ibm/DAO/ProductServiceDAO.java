package com.example.ibm.DAO;

import java.util.List;

import com.example.ibm.model.Product;



public interface ProductServiceDAO {

	public List<Product> getAllProducts();
	
	public Product getProduct(int id);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(int id, Product product);
	
	public void deleteProduct(int id);
}
