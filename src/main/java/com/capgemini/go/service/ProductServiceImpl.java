package com.capgemini.go.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.ui.PredefinedData;
import com.capgemini.go.controller.*;

public class ProductServiceImpl implements ProductService{
	Scanner s1=new Scanner(System.in);
	Scanner s2=new Scanner(System.in);
	Scanner s3=new Scanner(System.in);
	Map<String,ProductDTO> product1=new HashMap<String,ProductDTO>();
	Map<String,ProductDTO> product2=new HashMap<String,ProductDTO>();
	Map<String,ProductDTO> product3=new HashMap<String,ProductDTO>();
	List<ProductDTO> myproduct=new ArrayList<>();
	PredefinedData data;
	@Override
	public boolean addProduct(ProductDTO product) throws ProductException{
		
		if(product.getProductID().equals("")||product.getColour().equals("")||product.getDimension().equals("")||
				product.getPrice()==0.0||product.getProductCategory()==0||product.getQuantity()==0
				||product.getSpecifications().equals("")||product.getProductName().equals("")||product.getManufacturer().equals("")||
				((""+product.getProductID().charAt(0)).matches("^[a-zA-Z]")==false))
		{
			System.out.println("\nProduct ID should be Alphanumeric and Starts with an Alphabet\n");
			throw new ProductException();
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean deleteProduct(String productid) throws ProductException{
		
		data=PredefinedData.getInstance();
		int flag=0;
		product1.putAll(data.ProductData());
		if(product1.isEmpty())
			throw new ProductException();
		else 
		{
			
		for(Entry<String, ProductDTO> entry:product1.entrySet())
		{
			String productId2=entry.getKey();
			if(productId2.equals(productid))
			{
				flag=1;
				break;
			}
			 
		}
		}
		if(flag==1)
			return true;
		else
			return false;
			
			
	}

	@Override
	public boolean editProduct(ProductDTO product) throws ProductException{
		
		data=PredefinedData.getInstance();
		product2.putAll(data.ProductData());
		int flag=0;
		for(Entry<String,ProductDTO> entry:product2.entrySet()) {
			String productid=entry.getKey();
			 if(productid.equals(product.getProductID()))
			 {
				 flag=1;
				 break;
			 }
		}
		if(flag==1)
			return true;
		else
			return false;
	}

	@Override
	public List<ProductDTO> viewAllProduct() throws ProductException {
		product3.clear();
		myproduct.clear();
		data=PredefinedData.getInstance();
		if(data.ProductData().isEmpty())
			throw new ProductException();
		else
		{
		for(Entry<String, ProductDTO> entry:data.ProductData().entrySet()){
			ProductDTO product=entry.getValue();
			String productId=entry.getKey();
			product3.putIfAbsent(productId, product);
		}
		for(Entry<String, ProductDTO> entry:product3.entrySet()){
			ProductDTO product=entry.getValue();
			myproduct.add(product);
		}
		}
		return myproduct;
	}

}
