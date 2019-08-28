<%@page import="com.admin.dao.AdminDAO"%>
<%@page import="com.admin.model.UserPOJO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Expires", "0");
	response.setDateHeader("Expires", -1);
	
	HttpSession hs = request.getSession();
	try {
		if (hs == null || hs.getAttribute("username") == null) {
			hs.invalidate();
			response.sendRedirect("./login");
			return;
		}
	} catch (Exception e) {
		response.sendRedirect("./login");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/dashboard.css">
    <title>Dashboard</title>
</head>
<body>
	<%
		AdminDAO adminDaoObject = new AdminDAO();
		ArrayList<UserPOJO> contents = new ArrayList<UserPOJO>();
		contents = adminDaoObject.getDetails();
		
		final int COLUMNS = 4;
    	int rows = contents.size();
    	// int counter = 0;
	%>
	<div class="header">
		<table>
			<tr>
				<td><a href="${pageContext.request.contextPath}/HomeServlet" class="myButton">Home</a></td>
				<td><a href="${pageContext.request.contextPath}/AddUserServlet" class="myButton">+User</a></td>
				<td><a href="${pageContext.request.contextPath}/AddBonusServlet" class="myButton">Bonus</a></td>
				<td><a href="${pageContext.request.contextPath}/LogoutServlet" class="myButton">Logout</a></td>
			</tr>
		</table>
    </div>
    <div class="layout">
        <table>
            <tr>
                <th>Username</th>
                <th>Joining Date</th>
                <th>Salary</th>
            </tr>
            <%
				for(int i = 0; i < rows; i++) {
			%>
				<tr>
					<td><%=contents.get(i).getUsername()%></td>
					<td><%=contents.get(i).getJoiningdate()%></td>
					<td><%=contents.get(i).getSalary()%></td>
				</tr>
			<% } %>	
        </table>
    </div>
</body>
</html>