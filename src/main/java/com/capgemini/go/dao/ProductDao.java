package com.capgemini.go.dao;
import java.util.List;

import com.capgemini.go.dto.*;
public interface ProductDao {
	boolean addProduct(ProductDTO product) ;
	boolean deleteProduct(String productid);
	boolean editProduct(ProductDTO product);
	List<ProductDTO> viewAllProduct(); 
}