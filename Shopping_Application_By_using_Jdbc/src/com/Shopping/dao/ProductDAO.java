package com.Shopping.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Shopping.dto.CustomerDetails;
import com.Shopping.dto.ProductDetails;
import com.Shopping.util.JDBCConnection;

public class ProductDAO 
{

	private final String insert=" insert into product_details( Product_Name, Product_Brand, Product_Price, Product_M_F_Date, Product_Ex_Date, Product_Quantity, Product_Category, Product_Discount\n"
			+ ")values(?,?,?,?,?,?,?,?)";
	private static final String select_all_products="select *from a14_e_commerce.Product_details ";
	
	public boolean insertProductDetails(ProductDetails productDetails) {
		
		 
		try {
		   Connection connection = JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			preparedstatement.setString(1, productDetails.getProduct_Name());
			preparedstatement.setString(2, productDetails.getProduct_Brand());
			preparedstatement.setDouble(3, productDetails.getProduct_Price());
			preparedstatement.setDate(4, productDetails.getProduct_M_F_Date());
			preparedstatement.setDate(5, productDetails.getProduct_Ex_Date());
			preparedstatement.setInt(6, productDetails.getProduct_Quantity());
			preparedstatement.setString(7, productDetails.getProduct_Category());
			preparedstatement.setDouble(8, productDetails.getProduct_Discount());
			int result=preparedstatement.executeUpdate();
			if(result !=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean insertMorethanOneProduct(List<ProductDetails> listofproducts) {
		try {
			Connection connection = JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			for(ProductDetails productDetails : listofproducts)
			{
				preparedstatement.setString(1, productDetails.getProduct_Name());
				preparedstatement.setString(2, productDetails.getProduct_Brand());
				preparedstatement.setDouble(3, productDetails.getProduct_Price());
				preparedstatement.setDate(4, productDetails.getProduct_M_F_Date());
				preparedstatement.setDate(5, productDetails.getProduct_Ex_Date());
				preparedstatement.setInt(6, productDetails.getProduct_Quantity());
				preparedstatement.setString(7, productDetails.getProduct_Category());
				preparedstatement.setDouble(8, productDetails.getProduct_Discount());	
			}
			   preparedstatement.addBatch();
		      int[] results=preparedstatement.executeBatch();
		      if (results.length!=0) {
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
	
	public List<ProductDetails> getAllProductDetails()
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(select_all_products);
			ResultSet resultSet=preparedstatement.executeQuery();
			List<ProductDetails> listofproducts=new ArrayList<ProductDetails>();
			if(resultSet.isBeforeFirst()) {
			while(resultSet.next())
			{
				ProductDetails productDetails=new ProductDetails();
				productDetails.setProduct_id(resultSet.getInt("Product_id"));
				productDetails.setProduct_Name(resultSet.getString("Product_Name"));
				productDetails.setProduct_Brand(resultSet.getString("Product_Brand"));
				productDetails.setProduct_Price(resultSet.getDouble("Product_Price"));
				productDetails.setProduct_M_F_Date(resultSet.getDate("Product_M_F_Date"));
				productDetails.setProduct_Ex_Date(resultSet.getDate("Product_Ex_Date"));
				productDetails.setProduct_Quantity(resultSet.getInt("Product_Quantity"));
				productDetails.setProduct_Category(resultSet.getString("Product_Category"));
				productDetails.setProduct_Discount(resultSet.getDouble("Product_Discount"));
				
				
				listofproducts.add(productDetails);
			}
			return listofproducts;
			
		}
			else
			{
				return null;
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	
	
	
	
	
	
	
	
	
	

	
}
