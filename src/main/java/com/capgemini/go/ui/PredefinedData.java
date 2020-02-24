package com.capgemini.go.ui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.dto.ProductMaster;
import com.capgemini.go.dto.User;


public class PredefinedData{
	private List<ProductMaster> productMaster=new ArrayList<>();
	private Map<String,ProductDTO> productDTO=new HashMap<String,ProductDTO>();
	private static PredefinedData data;
	public PredefinedData() {
		super();
	}
	public static PredefinedData getInstance() {
		if(data==null) {
			data=new PredefinedData();
		}
		return data;
	}
	ProductDTO p1=new ProductDTO("A104", 1200.0, "RED", "110*20*56", "metal", "TATA", 20, 101, "Sqrue");
	ProductDTO p2=new ProductDTO("B206", 1000.0, "BLUE", "112*250*86", "metal", "TATA", 78, 102, "Driver");
	public Map<String,ProductDTO> ProductData() {
		productDTO.put(p1.getProductID(),p1);
		productDTO.put(p2.getProductID(),p2);
		return productDTO;
	}
	public List<ProductMaster> setProductMasterData(String id,String pass) {
		ProductMaster pm=new ProductMaster(id,pass);
		
		productMaster.add(new ProductMaster("amar","upadhyay"));
		productMaster.add(new ProductMaster("anubhav","sharma"));
		productMaster.add(pm);
		return productMaster;
	}
	public List<User> setUser(){
		List<User> user=new ArrayList<>();
		user.add(new User("shri","apple"));
		user.add(new User("anmol","kite"));
		return user;
	}
}
