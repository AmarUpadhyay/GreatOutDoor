package com.capgemini.go.ui;
import com.capgemini.go.controller.*;
import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.dto.ProductMaster;
import com.capgemini.go.service.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class ProductServiceExecutor {
	private PredefinedData data;
	ProductService service;
	private ProductController controller;
	private List<ProductMaster> mylist=new ArrayList<>();
	private ProductMaster productmaster=new ProductMaster();
	private ProductDTO product=new ProductDTO();
	Map<String,ProductDTO> product1=new HashMap<String,ProductDTO>();
	Map<String,ProductDTO> product2=new HashMap<String,ProductDTO>();
	public  void productServiceExecutor() throws ProductException {
		data=PredefinedData.getInstance();
		controller=ProductController.getInstance();
		Scanner s1=new Scanner(System.in);
		Scanner s2=new Scanner(System.in);
		Scanner s3=new Scanner(System.in);
		while(true)
		{
		System.out.println("Login as\n1:Admin\n2:Product Master\n3:User\n");
		int input1=s1.nextInt();
		switch(input1) {
			case 1:System.out.println("Add the ProductMaster:Enter the details :\n "
				+ "Enter Id: \n");
				
			productmaster.setId(s2.nextLine());
				
				System.out.println("Enter password");
		
				productmaster.setPassword(s2.nextLine());
				
				mylist=data.setProductMasterData(productmaster.getId(), productmaster.getPassword());
				System.out.println("Enter 0 to see Product Master Data");
				if(s1.nextInt()==0)
				{
					for(ProductMaster productmaster1:mylist) {
						System.out.println(productmaster1);
					}
				}
				else
					break;
				break;
			case 2:
					System.out.println("Choose the operation:\n1:Add Product\n2:Delete Product"
					+ "\n3:Edit Product\n4:Show Product List\n");
					int input2=s1.nextInt();
					switch(input2) {
					case 1:product1.clear();
						   System.out.println("Enter the Product details\n");
						   System.out.println("1:Enter the productID:\n");
						   product.setProductID(s2.nextLine());
						   System.out.println("2:Enter the price:\n");
						   product.setPrice(s3.nextDouble());
						   System.out.println("3:Enter the colour:\n");
						   product.setColour(s2.nextLine());
						   System.out.println("4:Enter the dimension:\n");
						   product.setDimension(s2.nextLine());
						   System.out.println("5:Enter the specifications:\n");
						   product.setSpecifications(s2.nextLine());
						   System.out.println("6:Enter the Manufacturer:\n");
						   product.setManufacturer(s2.nextLine());
						   System.out.println("7:Enter the Quantity:\n");
						   product.setQuantity(s1.nextInt());
					       System.out.println("8:Enter the Product Category:\n");
						   product.setProductCategory(s1.nextInt());
						   System.out.println("9:Enter the Product Name:\n");
						   product.setProductName(s2.nextLine());
						   product1.put(product.getProductID(), product);
						   System.out.println(controller.addProduct(product1));
						   break;
					case 2:product1.clear();
						   product2.clear();
						   product1.putAll(data.ProductData());
						   System.out.println("Enter the product id:\n");
				           String newproductId=s2.nextLine();
						   for(Entry<String, ProductDTO> entry:product1.entrySet())
							{
							String productId=entry.getKey();
							ProductDTO productvalue=entry.getValue();
							if(productId.equals(newproductId))
								{
									product2.put(productId, productvalue);
									break;
								}
							}
							System.out.println(controller.deleteProduct(product2));
							break;
					 case 3:product2.clear();
						    System.out.println("Enter the Product details\n");
					        System.out.println("1:Enter the productID:\n");
					        product.setProductID(s2.nextLine());
					        System.out.println("2:Enter the price:\n");
					        product.setPrice(s3.nextDouble());
					        System.out.println("3:Enter the colour:\n");
					        product.setColour(s2.nextLine());
					        System.out.println("4:Enter the dimension:\n");
					        product.setDimension(s2.nextLine());
					        System.out.println("5:Enter the specifications:\n");
					         product.setSpecifications(s2.nextLine());
					        System.out.println("6:Enter the Manufacturer:\n");
					        product.setManufacturer(s2.nextLine());
					        System.out.println("7:Enter the Quantity:\n");
					        product.setQuantity(s1.nextInt());
				            System.out.println("8:Enter the Product Category:\n");
					        product.setProductCategory(s1.nextInt());
					        System.out.println("9:Enter the Product Name:\n");
					        product.setProductName(s2.nextLine());
					        product2.put(product.getProductID(), product);
					        System.out.println(controller.editProduct(product2));
						 	break;
					 case 4:controller.getAllProduct();
					 		break;
					 default:System.out.println("Invalid Input");
					 		break;
					}
					break;
				default:System.out.println("Invalid Input");
				break;
				}
		if(input1==0)
			break;
		}
		s1.close();
		s2.close();
		s3.close();
	}
	
}
