package com.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//response pending if there are exception generates
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDAO daoObject = new AdminDAO();
		boolean authenticated;
		
		PrintWriter out = response.getWriter();
		
		try {
			authenticated = daoObject.getAuthentication(username, password);
			
			if (authenticated) {
				response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
			} else {
				response.setContentType("text/html");
				out.print("Invalid username or password");
				request.getRequestDispatcher("/login.jsp").include(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
