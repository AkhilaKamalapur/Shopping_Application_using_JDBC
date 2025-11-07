package com.Shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Shopping.dto.OrderDetails;
import com.Shopping.util.JDBCConnection;

public class OrderDAO 
{
	private static final String insert=" insert into order_details(Customer_id, Product_id, Product_Quantity, Order_Address, Order_Date)values(?,?,?,?,?)";
	public boolean insertOrderDetails(OrderDetails orderDetails) {
		try {
			
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			preparedstatement.setInt(1, orderDetails.getCustomer_id());
			preparedstatement.setInt(2, orderDetails.getProduct_id());
			preparedstatement.setInt(3,orderDetails.getProduct_Quantity());
			preparedstatement.setString(4, orderDetails.getOrder_Address());
			preparedstatement.setDate(5,Date.valueOf(orderDetails.getOrder_Date()));
			
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
