package com.example.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ibm.DAO.ProductServiceDAO;
import com.example.ibm.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductServiceDAO productServiceDAO;
	
	@Override
	//@Transactional 
	public List<Product> getAllProducts(){
		List<Product> products =productServiceDAO.getAllProducts();
		return products;	
	}
	
	@Override
	//@Transactional
	public Product getProduct(int id) {
		Product product = productServiceDAO.getProduct(id);
		return product;
	}
	
	@Override
	//@Transactional
	public Product addProduct(Product product) {
		productServiceDAO.addProduct(product);
		return product;
	}
	
	@Override
	//@Transactional
	public Product updateProduct(int id, Product product) {
		productServiceDAO.updateProduct(id, product);
		return product;
	}
	
	@Override
	//@Transactional
	public void deleteProduct(int id) {
		productServiceDAO.deleteProduct(id);
	}
}
