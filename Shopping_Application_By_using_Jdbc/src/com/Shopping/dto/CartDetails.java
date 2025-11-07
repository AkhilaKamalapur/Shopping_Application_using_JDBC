package com.Shopping.dto;

public class CartDetails 
{
	
	private int Cart_id;
	private int Product_id;
	private int Customer_id;
	private int Product_Quantity;
	public CartDetails(int cart_id, int product_id, int customer_id, int product_Quantity) {
		super();
		Cart_id = cart_id;
		Product_id = product_id;
		Customer_id = customer_id;
		Product_Quantity = product_Quantity;
	}
	public CartDetails() {
		// TODO Auto-generated constructor stub
	}
	public int getCart_id() {
		return Cart_id;
	}
	public void setCart_id(int cart_id) {
		Cart_id = cart_id;
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public int getProduct_Quantity() {
		return Product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}
	
	
	

}
