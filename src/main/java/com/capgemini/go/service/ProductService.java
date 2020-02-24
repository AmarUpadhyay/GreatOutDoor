package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.controller.ProductException;
import com.capgemini.go.dto.ProductDTO;

public interface ProductService {
	boolean addProduct(ProductDTO product) throws ProductException ;
	boolean deleteProduct(String productid) throws ProductException;
	boolean editProduct(ProductDTO product) throws  ProductException;
	List<ProductDTO> viewAllProduct() throws ProductException;
	
}
