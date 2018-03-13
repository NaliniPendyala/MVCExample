package com.mvcexample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvcexample.model.UserAccount;
import com.mvcexample.service.UserAccountService;
@WebServlet(urlPatterns= {"/","/registration"})
public class UserAccountRegistration extends HttpServlet {
	
	private String views;
	
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
		userAccount.setRole("user");
		UserAccountService userAccountService = new UserAccountService();

		
		boolean flag = userAccountService.saveInfo(userAccount);
		
		if (flag)
			
			resp.sendRedirect(views+"/login.jsp");
		
		else
			req.getRequestDispatcher(views+"/registration.jsp").forward(req, resp);
		
		
		
		
		
		
		
		
		
		
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in service");
		
		  views=getServletContext().getInitParameter("views");
		
		if(request.getMethod().equalsIgnoreCase("get"))
		{
			doGet(request, response);
		}else
		{
			doPost(request, response);
		}
	}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	RequestDispatcher rd= req.getRequestDispatcher(views+"/registration.jsp");
	rd.forward(req, resp);
}
}
