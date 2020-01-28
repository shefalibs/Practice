package com.example.ibm.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ibm.model.Product;

@Repository("productServiceDAO")
public class ProductServiceDAOImpl implements ProductServiceDAO {

		private JdbcTemplate jdbcTemplate;
		
		@Autowired
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		@Override
		public List<Product> getAllProducts(){
			List<Product> products = null;
			try {
				products = jdbcTemplate.query("SELECT * from products", new BeanPropertyRowMapper<Product>(Product.class));
			}
			catch(DataAccessException e) {
				e.printStackTrace();
			}
			return products;
		}
		
		@Override
		public Product getProduct(int id) {
			Product product = null;
			try {
				product = jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?", new Object[] { id },
						new BeanPropertyRowMapper<Product>(Product.class));
			}
			catch(DataAccessException e) {
				e.printStackTrace();
			}
			return product;
		}
		
		@Override
		public Product addProduct(Product product) {
			jdbcTemplate.update("INSERT INTO products (id, productName, price)VALUES (?,?,?)",
					new Object[] {product.getId(), product.getProductName(), product.getPrice()});
			return product;
		}
		
		@Override
		public Product updateProduct(int id, Product product) {
			jdbcTemplate.update("UPDATE products set productName = ?, price = ? where id = ?",
					new Object[] { product.getProductName(), product.getPrice(), product.getId()});
			return product;
		}
		
		@Override
		public void deleteProduct(int id) {
			jdbcTemplate.update("DELETE from products where id = ?", new Object[] { id });
			;
		}
}
