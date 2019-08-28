package com.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDAO;
import com.admin.model.UserPOJO;

@WebServlet("/AddDetailsServlet")
public class AddDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String joiningdate = request.getParameter("joiningdate");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		System.out.println(username + " " + password + " " + joiningdate + " " + salary);
		
		UserPOJO user = new UserPOJO();
		user.setUsername(username);
		user.setJoiningdate(joiningdate);
		user.setSalary(salary);
		user.setPassword(password);
		
		AdminDAO daoObject = new AdminDAO();
		try {
			daoObject.setEmployee(user);
		} catch (Exception e) {
			System.out.println("AddDetailsServletException\n");
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
	}

}
