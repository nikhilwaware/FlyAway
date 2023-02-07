<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
h3{
color : #004d99;
}
table {
  border-collapse: collapse;
  width: 50%;
  font-size: 22px;
}
th{
color : #ff33ff;
}
td{
color : #008000;
}
th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #99ebff;}
</style>
</head>
<body>

<h3>Master List of AirLines</h3>
<table>

	<tr>
	<th>Flight Number</th>
	<th>AirLines Name</th>
	</tr>
	
	<%
	String driver= application.getInitParameter("driver");
	String url = application.getInitParameter("url");
	String user = application.getInitParameter("username");
	String pass = application.getInitParameter("password");
	
	String sqlQuery ="select flightId,flightName from flightdetails";
	
	try{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement stmt = con.prepareStatement(sqlQuery);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){ %>
		
		<tr>
		<td><%= rs.getInt(1) %>	</td>
		<td><%= rs.getString(2) %></td>
		</tr>
	<% 	}
	} 
	catch(Exception e){
		out.println("<h4 style='color:red'>AirLines data does not Exists</h4>");	
	}
	
	%>

</table>
<a href="adminDashboard.html">Back</a>
</body>
</html>