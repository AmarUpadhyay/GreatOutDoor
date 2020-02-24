package com.capgemini.go.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

//import com.capgemini.go.dao.*;
import com.capgemini.go.dto.*;
import com.capgemini.go.service.ProductService;
import com.capgemini.go.service.ProductServiceImpl;
import com.capgemini.go.ui.PredefinedData;
public class ProductController {
	ProductService productservice=new ProductServiceImpl();
	List<ProductDTO> productlistadd=new ArrayList<>();
	List<ProductDTO> productlistview=new ArrayList<>();
	List<ProductDTO> productlistdelete=new ArrayList<>();
	List<ProductDTO> productlist2=new CopyOnWriteArrayList<>();
	Map<String,ProductDTO> productviewadd=new HashMap<>();
	Map<String,ProductDTO> productviewdelete=new HashMap<>();
	PredefinedData data;
	ProductDTO product;
	private static ProductController controller;
	public ProductController() {
		super();
	}
	public static ProductController getInstance() {
		if(controller==null) {
			controller=new ProductController();
		}
		return controller;
	}
	public String getAllProduct() throws ProductException{
		productlistview.clear();
		productlistview.addAll(productservice.viewAllProduct());
		System.out.println("\t\t\tProduct List\n");
		for(ProductDTO products:productlistview)
		{
			System.out.println(products);
		}
		
		return null;
		
	}
	public String addProduct(Map<String,ProductDTO> requestData) throws ProductException {
		productviewadd.clear();
		productlistadd.clear();
		data=PredefinedData.getInstance();
		productviewadd.putAll(data.ProductData());
		for(Entry<String, ProductDTO> entry:requestData.entrySet())
		{
			 product=entry.getValue();
			 String productid=entry.getKey();
			 productviewadd.put(productid, product);
		}
		if(productservice.addProduct(product)) {
			for(Entry<String,ProductDTO> entry:productviewadd.entrySet())
			{
				ProductDTO product1=entry.getValue();
				productlistadd.add(product1);
				
			}
			System.out.println("\t\t\tUpdated Product List:\n");
			for(ProductDTO products:productlistadd)
			{
				System.out.println(products);
			}
		return "Product Added";
		}
		else
			throw new ProductException();
	}
	public String editProduct(Map<String,ProductDTO> requestData) throws ProductException
	{
		productlist2.clear();
		String productid="";
		for(Entry<String, ProductDTO> entry:requestData.entrySet())
		{
			product=entry.getValue();
			 productid=entry.getKey();
			 System.out.println(productid);
		}
		if(productservice.editProduct(product))
			{
				productlist2.addAll(productservice.viewAllProduct());
				for(ProductDTO products1:productlist2)
				{
					if(productid.equals(products1.getProductID()))
					{
						int index=productlist2.indexOf(products1);
						productlist2.set(index, product);
					}
				}
				System.out.println("\t\t\tUpdated Product List\n");
				for(ProductDTO products2:productlist2)
				{
				 System.out.println(products2);
				}
				return "Product Edited";
				}
			else
				return "No such product is in the Product List Try Again!!";
			}
	public String deleteProduct(Map<String,ProductDTO> requestData) {
		productviewdelete.clear();
		productlistdelete.clear();
		data=PredefinedData.getInstance();
		productviewdelete.putAll(data.ProductData());
		for(Entry<String,ProductDTO> entry:productviewdelete.entrySet())
		{
			product=entry.getValue();
			productlistdelete.add(product);
		}
		for(Entry<String, ProductDTO> entry:requestData.entrySet())
		{
			String productId=entry.getKey();
				product=entry.getValue();
			try {
				if(productservice.deleteProduct(productId))
				{
					int index=productlistdelete.indexOf(product);
					productlistdelete.remove(index);
					System.out.println("Product Deleted\n");
					System.out.println("\t\t\tUpdated Product List:\n");
					for(ProductDTO products:productlistdelete)
					{
						System.out.println(products);
					}
				}
				else
					System.out.println("No such product is in the Product List Try Again!!");
			} catch (ProductException e) {
				
				  e.getMessage();
			}	 
		}
		return "Operation Completed";
	}
}
