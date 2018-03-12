package com.mvcexample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.mvcexample.model.UserAccount;
import com.mvcexample.service.UserAccountService;
@WebFilter("/registration")
public class RegistrationFilter implements Filter{

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		
		
		String name= req.getParameter("name");
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		boolean validate=true;
		boolean userExists= false;
		if (name.trim().length()<=0) {
			
			req.setAttribute("nameMessage","Please enter valid name");
			validate=false;
		}
		
		
		
if (username.trim().length()<=0) {
			
			req.setAttribute("unameMessage","Please enter valid username");
			validate=false;
	}
else {
	UserAccountService ua = new UserAccountService();
	
	
	if(ua.checkUsername(username))
	{
		userExists=true;
		req.setAttribute("usernameExists", "Username Already Exists");
	}
}
			
if (password.trim().length()<=0) {
	
	req.setAttribute("pwdMessage","Please enter valid password");
	validate=false;
}
	if(validate && !userExists)
		
	filter.doFilter(req,res);
	else
		
	{
		RequestDispatcher rd= req.getRequestDispatcher("registration.jsp");
		rd.forward(req,res);
		
	}
		
	}

	
	
	
}
