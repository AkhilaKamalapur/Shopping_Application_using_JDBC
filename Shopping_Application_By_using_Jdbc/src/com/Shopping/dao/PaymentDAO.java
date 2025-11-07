package com.Shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Shopping.dto.CustomerDetails;
import com.Shopping.dto.PaymentDetails;
import com.Shopping.util.JDBCConnection;

public class PaymentDAO 
{
	private static final String insert=" insert into payment_details(Customer_Id, Product_id, payment_type, Payment_Status, Amount, Payment_Date)values(?,?,?,?,?,?)";
	public boolean insertPaymentDetails(PaymentDetails paymentDetails) {
		try {
			
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			preparedstatement.setInt(1, paymentDetails.getCustomer_Id());
			preparedstatement.setInt(2, paymentDetails.getProduct_id());
			preparedstatement.setString(3, paymentDetails.getPayment_type());
			preparedstatement.setString(4, paymentDetails.getPayment_Status());
			preparedstatement.setDouble(5, paymentDetails.getAmount());
			preparedstatement.setDate(6, Date.valueOf(paymentDetails.getPayment_Date()));
			
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

}
