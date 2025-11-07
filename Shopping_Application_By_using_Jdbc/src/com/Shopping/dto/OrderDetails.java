package com.Shopping.dto;

import java.sql.Date;
import java.time.LocalDate;

public class OrderDetails
{

	private int Order_id;
	private int Customer_id;
	private int Product_id;
	private int Product_Quantity;
	private String Order_Address;
	private LocalDate Order_Date;
	public OrderDetails(int order_id, int customer_id, int product_id, int product_Quantity, String order_Address,
			LocalDate order_Date) {
		super();
		Order_id = order_id;
		Customer_id = customer_id;
		Product_id = product_id;
		Product_Quantity = product_Quantity;
		Order_Address = order_Address;
		Order_Date = order_Date;
	}
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public int getProduct_Quantity() {
		return Product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}
	public String getOrder_Address() {
		return Order_Address;
	}
	public void setOrder_Address(String order_Address) {
		Order_Address = order_Address;
	}
	public LocalDate getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(LocalDate localDate) {
		Order_Date = localDate;
	}
	

}
