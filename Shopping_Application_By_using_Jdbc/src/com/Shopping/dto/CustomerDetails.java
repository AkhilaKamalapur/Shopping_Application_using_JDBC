package com.Shopping.dto;

public class CustomerDetails
{
	private int Customer_Id ;
	private String   Customer_Name;
	private String Customer_Email_id;
	private long Customer_MobileNumber;
	private String Customer_Address;
	private String Customer_Gender;
	private String Customer_Password;
	
	
	public CustomerDetails() {
	
	}
	public int getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getCustomer_Email_id() {
		return Customer_Email_id;
	}
	public void setCustomer_Email_id(String customer_Email_id) {
		Customer_Email_id = customer_Email_id;
	}
	public long getCustomer_MobileNumber() {
		return Customer_MobileNumber;
	}
	public void setCustomer_MobileNumber(long customer_MobileNumber) {
		Customer_MobileNumber = customer_MobileNumber;
	}
	public String getCustomer_Address() {
		return Customer_Address;
	}
	public void setCustomer_Address(String customer_Address) {
		Customer_Address = customer_Address;
	}
	public String getCustomer_Gender() {
		return Customer_Gender;
	}
	public void setCustomer_Gender(String customer_Gender) {
		Customer_Gender = customer_Gender;
	}
	public String getCustomer_Password() {
		return Customer_Password;
	}
	public void setCustomer_Password(String customer_Password) {
		Customer_Password = customer_Password;
	}
	public CustomerDetails(int customer_Id, String customer_Name, String customer_Email_id, long customer_MobileNumber,
			String customer_Address, String customer_Gender, String customer_Password) {
		super();
		Customer_Id = customer_Id;
		Customer_Name = customer_Name;
		Customer_Email_id = customer_Email_id;
		Customer_MobileNumber = customer_MobileNumber;
		Customer_Address = customer_Address;
		Customer_Gender = customer_Gender;
		Customer_Password = customer_Password;
	}
	
	

}
