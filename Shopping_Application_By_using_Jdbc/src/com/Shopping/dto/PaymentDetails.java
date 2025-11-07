package com.Shopping.dto;

import java.sql.Date;
import java.time.LocalDate;

public class PaymentDetails 
{

	private int Payment_id;
	private int Customer_Id;
	private int Product_id;
	private String payment_type;
	private String Payment_Status;
	private double amount;
	private LocalDate Payment_Date;
	public int getPayment_id() {
		return Payment_id;
	}
	public void setPayment_id(int payment_id) {
		Payment_id = payment_id;
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getPayment_Status() {
		return Payment_Status;
	}
	public void setPayment_Status(String payment_Status) {
		Payment_Status = payment_Status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		amount = amount;
	}
	public LocalDate getPayment_Date() {
		return Payment_Date;
	}
	public void setPayment_Date(LocalDate localDate) {
		Payment_Date = localDate;
	}
	public PaymentDetails(int payment_id, int customer_Id, int product_id, String payment_type, String payment_Status,
			double amount, LocalDate payment_Date) {
		super();
		Payment_id = payment_id;
		Customer_Id = customer_Id;
		Product_id = product_id;
		this.payment_type = payment_type;
		Payment_Status = payment_Status;
		amount = amount;
		Payment_Date = payment_Date;
	}
	public PaymentDetails() {
		// TODO Auto-generated constructor stub
	}
	
	

}
