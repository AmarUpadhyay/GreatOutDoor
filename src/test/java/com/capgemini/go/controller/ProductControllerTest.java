package com.capgemini.go.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.capgemini.go.dto.ProductDTO;

class ProductControllerTest {
	ProductController controller=new ProductController();
	@Test
	void getAllProductTest() throws ProductException {
		String actual=controller.getAllProduct();
		assertNull(actual);
	}
	@Test
	void editProductTest() throws ProductException{
		ProductDTO testProduct=new ProductDTO("A104", 1678, "GREEN", "112*500*86", "Rubber", "TATA", 78, 102, "Tyre");
		Map<String,ProductDTO> testProductDetails=new HashMap<String,ProductDTO>();
		testProductDetails.put(testProduct.getProductID(), testProduct);
		String actualeditMessage=controller.editProduct(testProductDetails);
		String expectededitMessage="Product Edited";
		assertEquals(actualeditMessage,expectededitMessage);
	}
	@Test
	void addProductTest() throws ProductException {
		ProductDTO testProduct1=new ProductDTO("C109", 1678, "GREEN", "112*500*86", "Rubber", "TATA", 78, 102, "Tyre");
		Map<String,ProductDTO> testProductDetails1=new HashMap<String,ProductDTO>();
		testProductDetails1.put(testProduct1.getProductID(), testProduct1);
		String actualeditMessage=controller.addProduct(testProductDetails1);
		String expectededitMessage="Product Added";
		assertEquals(actualeditMessage,expectededitMessage);
	}

}
