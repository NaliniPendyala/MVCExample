package com.mvcexample.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvcexample.model.UserAccount;
import com.mvcexample.service.UserAccountService;
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public LoginController() {
        super();
      }
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserAccountService uas= new UserAccountService();
	
	String username;
	String password;
	 username= request.getParameter("username");
	 password= request.getParameter("password");
	UserAccount ua = uas.getUser(username, password);
	 
	if(ua!=null)
	{
		
		HttpSession session= request.getSession();
		session.setAttribute("ua", ua);
		
		if (ua.getRole().equalsIgnoreCase("admin"))
			response.sendRedirect("admin.jsp");
		else
		response.sendRedirect("display.jsp");
	}
	
	else {
		
		RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
		request.setAttribute("errormessage", "Please enter correct username or password");
		rd.forward(request, response);
	}
	}
	
	 
	 
	
	}


