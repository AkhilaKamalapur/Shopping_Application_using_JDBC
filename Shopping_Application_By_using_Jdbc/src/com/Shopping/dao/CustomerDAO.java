package com.Shopping.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Shopping.dto.CustomerDetails;
import com.Shopping.util.JDBCConnection;

public class CustomerDAO
{
	private static final String insert=" insert into Customer_details( Customer_Name, Customer_Email_id, Customer_MobileNumber, Customer_Address, Customer_Gender, Customer_Password)values(?,?,?,?,?,?)";
	private static final String select_all_customers="select *from a14_e_commerce.customer_details ";
	private static final String customer_Login="select*from customer_details where (Customer_Email_id=? or Customer_MobileNumber=?)and Customer_Password=? ";
	public boolean insertCustomerDetails(CustomerDetails customerdetails) {
		try {
			
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			preparedstatement.setString(1,customerdetails.getCustomer_Name());
			preparedstatement.setString(2,customerdetails.getCustomer_Email_id());
			preparedstatement.setLong(3,customerdetails.getCustomer_MobileNumber());
			preparedstatement.setString(4, customerdetails.getCustomer_Address());
			preparedstatement.setString(5, customerdetails.getCustomer_Gender());
			preparedstatement.setString(6, customerdetails.getCustomer_Password());
			int result=preparedstatement.executeUpdate();
			if(result!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}
	public List<CustomerDetails> selectAllCustomerDetails()
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(select_all_customers);
			ResultSet resultSet=preparedstatement.executeQuery();
			List<CustomerDetails> listofcustomers=new ArrayList<CustomerDetails>();
			while(resultSet.next())
			{
				CustomerDetails customerDetails=new CustomerDetails();
				customerDetails.setCustomer_Id(resultSet.getInt("Customer_Id"));
				customerDetails.setCustomer_Name(resultSet.getString("Customer_Name"));
				customerDetails.setCustomer_Email_id(resultSet.getString("Customer_Email_id"));
				customerDetails.setCustomer_MobileNumber(resultSet.getLong("Customer_MobileNumber"));
				customerDetails.setCustomer_Address(resultSet.getString("Customer_Address"));
				customerDetails.setCustomer_Gender(resultSet.getString("Customer_Gender"));
				customerDetails.setCustomer_Password(resultSet.getString("Customer_Password"));
				listofcustomers.add(customerDetails);
			}
			return listofcustomers;	
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	public CustomerDetails selectCustomerDetailsByusingEmailorMobileNoAndPassword(String emailidormobileno,String password)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(customer_Login);
			preparedstatement.setString(1, emailidormobileno);
			preparedstatement.setString(2, emailidormobileno);
			preparedstatement.setString(3, password);
			ResultSet resultSet=preparedstatement.executeQuery();
			if (resultSet.next()) {
				CustomerDetails customerDetails=new CustomerDetails();
				customerDetails.setCustomer_Id(resultSet.getInt("Customer_Id"));
				customerDetails.setCustomer_Name(resultSet.getString("Customer_Name"));
				customerDetails.setCustomer_Email_id(resultSet.getString("Customer_Email_id"));
				customerDetails.setCustomer_MobileNumber(resultSet.getLong("Customer_MobileNumber"));
				customerDetails.setCustomer_Address(resultSet.getString("Customer_Address"));
				customerDetails.setCustomer_Password(resultSet.getString("Customer_Password"));
//				customerDetails.setCustomer_Name(resultSet.getString("Customer_Name"));
				customerDetails.setCustomer_Gender(resultSet.getString("Customer_Gender"));
				return customerDetails;	
			} else
			{
				return null;
				
			}		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
