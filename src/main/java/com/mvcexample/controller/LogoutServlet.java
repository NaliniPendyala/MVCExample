package com.mvcexample.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogoutServlet() {
        super();
    }
    private String views;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" in logout servlet service");
		
		  views=getServletContext().getInitParameter("views");
		
		if(request.getMethod().equalsIgnoreCase("get"))
		{
			doGet(request, response);
		}else
		{
			doPost(request, response);
		}
	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession  s= request.getSession();
		s.removeAttribute("ua");
		s.invalidate();
		response.sendRedirect(request.getServletContext().getContextPath()+"/Login");
		
	}

}
