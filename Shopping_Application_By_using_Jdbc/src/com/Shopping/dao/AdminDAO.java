package com.Shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Shopping.dto.Admin;
import com.Shopping.dto.CustomerDetails;
import com.Shopping.util.JDBCConnection;

public class AdminDAO 
{
	private static final String insert=" insert into admin(Admin_Email_id,Admin_Password,Admin_Role)values(?,?,?)";
	private static final String admin_Login="select*from admin where Admin_Email_id=? and Admin_Password=? ";
	public boolean insertAdmin(Admin adminDetails) {
		try {
			
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			
			preparedstatement.setString(1,adminDetails.getAdmin_Email_id());
			preparedstatement.setString(2,adminDetails.getAdmin_Password());
			preparedstatement.setString(3,adminDetails.getAdmin_Role());
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
	
	public Admin selectAdminByusingEmailorMobileNoAndPassword(String emailid,String password)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(admin_Login);
			preparedstatement.setString(1, emailid);
			preparedstatement.setString(2, password);
			ResultSet resultSet=preparedstatement.executeQuery();
			if (resultSet.next()) {
				Admin adminDetails=new Admin();
				adminDetails.setAdmin_Email_id(resultSet.getString("Admin_Email_id"));
				adminDetails.setAdmin_Password(resultSet.getString("Admin_Password"));	
				return adminDetails;
				
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
