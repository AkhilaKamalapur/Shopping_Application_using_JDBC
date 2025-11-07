package com.Shopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnection 
{
	public static Connection forMySQLConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection connection=
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/a14_e_commerce?user=root&&password=root");

	}

}
