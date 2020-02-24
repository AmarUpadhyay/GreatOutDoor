package com.capgemini.go.dto;

public class ProductMaster {
	private String id;
	private String password;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public ProductMaster(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public ProductMaster() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductMaster [id=" + id + ", password=" + password + "]";
	}
	

}
