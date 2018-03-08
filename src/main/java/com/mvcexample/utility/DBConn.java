package com.mvcexample.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	public Connection getConnection() {
		try {
			
			Class.forName("org.h2.Driver");
			Connection conn= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/demo","sa","sa@123");
			
			return conn;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
}
