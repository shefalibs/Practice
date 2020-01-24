package com.example.ibm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.ibm.bean.Product;




public class ProductService {

 static HashMap<Integer,Product> productIdMap=getProductIdMap();


 public ProductService() {
  super();

  if(productIdMap==null)
  {
   productIdMap=new HashMap<Integer,Product>();
  // Creating some objects of Country while initializing
   Product chairPro=new Product(1, "Chair",5000);
   Product tablePro=new Product(2, "Table",20000);
   Product fanPro=new Product(3, "Fan",8000);


   productIdMap.put(1,chairPro);
   productIdMap.put(2,tablePro);
   productIdMap.put(3,fanPro);
  }
 }

 public List<Product> getAllProducts()
 {
  List<Product> products = new ArrayList<Product>(productIdMap.values());
  return products;
 }

 public Product getProduct(int id)
 {
  Product product= productIdMap.get(id);
  return product;
 }
 public Product addProduct(Product product)
 {
  product.setId(getMaxId()+1);
  productIdMap.put(product.getId(), product);
  return product;
 }
 
 public Product updateProduct(Product product)
 {
  if(product.getId()<=0)
   return null;
  productIdMap.put(product.getId(), product);
  return product;

 }
 public void deleteProduct(int id)
 {
  productIdMap.remove(id);
 }

 public static HashMap<Integer, Product> getProductIdMap() {
  return productIdMap;
 }
 

 // Utility method to get max id
 public static int getMaxId()
 {   int max=0;
 for (int id:productIdMap.keySet()) {  
  if(max<=id)
   max=id;

 }  
 return max;
 }
}

