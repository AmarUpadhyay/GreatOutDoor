package com.capgemini.go.service;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.capgemini.go.controller.ProductException;
import com.capgemini.go.dto.ProductDTO;

class ProductServiceImplTest {
	ProductService service=new ProductServiceImpl();
	@Test()
	void addProductServiceTest() throws ProductException {
		ProductDTO productTest=new ProductDTO("104M", 1678, "GREEN", "112*500*86", "Rubber", "Capgemini", 78, 102, "Tyre");
		Assertions.assertThrows(ProductException.class, ()->service.addProduct(productTest),"Throwing Exception "
				+ "because of invalid ProductID");
	}
	@Test
	void editProductServiceTest() throws ProductException{
		ProductDTO productTest=new ProductDTO("A104", 9087, "Blue", "100*500*200", "Plastic", "Capgemini", 20, 108, "Bottel");
		assertTrue(service.editProduct(productTest));
	}
	@Test
	void deleteProductServiceTest() throws ProductException{
		assertTrue(service.deleteProduct("A104"));
	}

}
