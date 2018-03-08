package com.mvcexample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mvcexample.model.UserAccount;
import com.mvcexample.utility.DBConn;

public class UserAccountService {
private Connection conn;
	public UserAccountService(){
		 conn= new DBConn().getConnection();
		
		 		 	 
	}

	public boolean saveInfo(UserAccount ua) {
		boolean flag= true;
			try {
				PreparedStatement ps= conn.prepareStatement("insert into AccountInfo (name, username, password) values (?,?,?)");
				ps.setString(1, ua.getName());
				ps.setString(2, ua.getUsername());
				ps.setString(3, ua.getPassword());
				int i= ps.executeUpdate();
				if (i>0)
						return flag;
				else
				{
				flag=false;	
				return flag;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			
		
	}
	
	
	
	
}
