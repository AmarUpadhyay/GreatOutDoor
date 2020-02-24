package com.capgemini.go.dto;

public class ProductDTO {
	private String productID;
	private double price;
	private String colour;
	private String dimension;
	private String specifications;
	private String manufacturer;
	private int quantity;
	private int productCategory;
	private String productName;
	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}
	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	/**
	 * @return the specifications
	 */
	public String getSpecifications() {
		return specifications;
	}
	/**
	 * @param specifications the specifications to set
	 */
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the productCategory
	 */
	public int getProductCategory() {
		return productCategory;
	}
	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "ProductDTO [productID=" + productID + ", price=" + price + ", colour=" + colour + ", dimension="
				+ dimension + ", specifications=" + specifications + ", manufacturer=" + manufacturer + ", quantity="
				+ quantity + ", productCategory=" + productCategory + ", productName=" + productName + "]";
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductDTO(String productID, double price, String colour, String dimension, String specifications,
			String manufacturer, int quantity, int productCategory, String productName) {
		super();
		this.productID = productID;
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specifications = specifications;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
	}
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
