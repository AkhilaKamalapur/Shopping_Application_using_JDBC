package com.Shopping.dto;

import java.sql.Date;

public class ProductDetails
{
	
	private int Product_id;
	private String Product_Name;
	private String Product_Brand;
	private double Product_Price;
	private Date Product_M_F_Date;
	private Date Product_Ex_Date;
	private int Product_Quantity;
	private String Product_Category;
	private double Product_Discount;
	
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public String getProduct_Brand() {
		return Product_Brand;
	}
	public void setProduct_Brand(String product_Brand) {
		Product_Brand = product_Brand;
	}
	public double getProduct_Price() {
		return Product_Price;
	}
	public void setProduct_Price(double product_Price) {
		Product_Price = product_Price;
	}
	public Date getProduct_M_F_Date() {
		return Product_M_F_Date;
	}
	public void setProduct_M_F_Date(Date product_M_F_Date) {
		Product_M_F_Date = product_M_F_Date;
	}
	public Date getProduct_Ex_Date() {
		return Product_Ex_Date;
	}
	public void setProduct_Ex_Date(Date product_Ex_Date) {
		Product_Ex_Date = product_Ex_Date;
	}
	public int getProduct_Quantity() {
		return Product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}
	public String getProduct_Category() {
		return Product_Category;
	}
	public void setProduct_Category(String product_Category) {
		Product_Category = product_Category;
	}
	public double getProduct_Discount() {
		return Product_Discount;
	}
	public void setProduct_Discount(double product_Discount) {
		Product_Discount = product_Discount;
	}
	public ProductDetails(int product_id, String product_Name, String product_Brand, double product_Price,
			Date product_M_F_Date, Date product_Ex_Date, int product_Quantity, String product_Category,
			double product_Discount) {
		super();
		Product_id = product_id;
		Product_Name = product_Name;
		Product_Brand = product_Brand;
		Product_Price = product_Price;
		Product_M_F_Date = product_M_F_Date;
		Product_Ex_Date = product_Ex_Date;
		Product_Quantity = product_Quantity;
		Product_Category = product_Category;
		Product_Discount = product_Discount;
	}
	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
