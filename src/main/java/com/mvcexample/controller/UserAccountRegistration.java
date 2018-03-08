package com.mvcexample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvcexample.model.UserAccount;
import com.mvcexample.service.UserAccountService;
@WebServlet("/registration")
public class UserAccountRegistration extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name, username, password;
		
		name= req.getParameter("name");
		username= req.getParameter("username");
		password= req.getParameter("password");
		
		UserAccount userAccount = new UserAccount();
		userAccount.setName(name);
		userAccount.setUsername(username);
		userAccount.setPassword(password);
		UserAccountService userAccountService = new UserAccountService();

		
		boolean flag = userAccountService.saveInfo(userAccount);
		
		if (flag)
			
			resp.sendRedirect("login.jsp");
		
		else
			req.getRequestDispatcher("registration.jsp").forward(req, resp);
		
		
		
		
		
		
		
		
		
		
	}
	

}
