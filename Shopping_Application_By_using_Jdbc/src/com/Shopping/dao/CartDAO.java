package com.Shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Shopping.dto.CartDetails;
import com.Shopping.util.JDBCConnection;

public class CartDAO 
{
	private static final String insert="insert into cart_details( Product_id, Customer_id, Product_Quantity) values(?,?,?)";
	public boolean insertCartDetails(CartDetails cartDetails) {
		
		try {
			Connection connection = JDBCConnection.forMySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setInt(1,cartDetails.getCustomer_id());
			preparedStatement.setInt(2, cartDetails.getProduct_id());
			preparedStatement.setInt(3, cartDetails.getProduct_Quantity());
			int result=preparedStatement.executeUpdate();
			if (result!=0) {
				return true;
				
			} else {
				return false;

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
