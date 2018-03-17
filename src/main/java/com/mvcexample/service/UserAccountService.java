package com.mvcexample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mvcexample.model.UserAccount;

public class UserAccountService {
private Connection conn;
private EntityManager manager;

	public UserAccountService(){

		EntityManagerFactory entityMgrFac=Persistence.createEntityManagerFactory("demoPersistence");
		
		manager = entityMgrFac.createEntityManager();
		System.out.println(manager);
	}

	
	public boolean saveInfo(UserAccount ua) {
		boolean flag= true;
			/*try {
								
				PreparedStatement ps= conn.prepareStatement("insert into AccountInfo (name, username, password,role) values (?,?,?,'user')");
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
			}*/
		
		System.out.println(ua);
		try {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(ua);
		transaction.commit();
		manager.close();
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	
	public UserAccount  getUser (String username , String password) {
 		
 		try {
 		EntityTransaction transaction= manager.getTransaction();
 		transaction.begin();
      //ua=manager.find(UserAccount.class,username);
 		TypedQuery<UserAccount> query= manager.createQuery("from UserAccount where username=:uname and password=:pword",UserAccount.class);
 	    query.setParameter("uname", username);
 	    query.setParameter("pword", password);
 	    return query.getSingleResult();
 		
 		}catch (Exception e) {
			// TODO: handle exception
 			return null;
		}
 		
 		/*
 		ua= manager.createQuery("from UserAccount where username=:uname and password=:pword",UserAccount.class)
 				.setParameter("uname", username)
 				.setParameter("pword", password)
 				.getSingleResult();*/
 	
 		

		/*
 		try {
 			
 			ResultSet rs=null;
 			PreparedStatement ps= conn.prepareStatement("select * from AccountInfo where username=? and password=?");
 			ps.setString(1,username);
 			ps.setString(2,username);
 			rs=ps.executeQuery();
 		
 			if(rs.next())
 					{
 				ua= new UserAccount();
 				ua.setName(rs.getString("name"));
 				ua.setPassword(rs.getString("password"));
 				ua.setUsername(rs.getString("username"));
 				ua.setRole(rs.getString("role"));
 				return ua;
 					}
 			else {
 				return null;
 			}
 						
 			
 		}catch(Exception e)
 		{
 		e.printStackTrace();
 		return null;
 		}
 			*/
    
	}
	
	public boolean checkUsername(String username) {
		
	
		try {
	PreparedStatement ps= conn.prepareStatement("select * from AccountInfo where username=?");
	
	ps.setString(1, username);
	ResultSet rs= ps.executeQuery();
	if(rs.next())
	{
		return true;
	}
	else
		
		return false;
	
	
		}catch(Exception e)
		{
		return false;	
		}
	
	
		
	}
	
}
