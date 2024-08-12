package com.learning.dao;

import java.util.List;

import com.learning.entities.Product;

public interface ProductDAO {
	boolean addProduct(Product p);
	List<Product> getAllProducts();
	boolean deleteProductById(int id);

}
