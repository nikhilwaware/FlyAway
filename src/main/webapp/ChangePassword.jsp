<%@ page import="dao.AdminDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FlyAway</title>
<style type="text/css">
body{
background-color: #e6e6e6;
}
a{
text-decoration: none;
font-size: 22px;
color: #004d99;
}
</style>
</head>
<body>

	<h3>Update Password</h3>
	<%
		String username = request.getParameter("adminU");
		String password = request.getParameter("adminPass");
		AdminDAO flight = new AdminDAO();
		try {
		flight.changePassword(username, password);
		
		out.print("<h4 style='color:green'>Password Update Succesfully...</h4>");
		}
		catch(Exception e){
			out.print("<h3 style='color:red'>Failed to Update Password</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("adminChangePassword.html");
			rd.include(request, response);
		}
	%>

<a href="adminDashboard.html">Admin Dashboard</a>
</body>
</html>