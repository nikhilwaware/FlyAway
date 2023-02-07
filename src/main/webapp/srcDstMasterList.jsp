<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
#navBar{
position: fixed;
top : 20px;
right : 50px;
}
</style>
</head>
<body>

<h3>Master List of Source and Destination</h3>
<table>
	<tr>
		<th>Source</th>
		<th>Destination</th>
	</tr>
<%
String driver= application.getInitParameter("driver");
String url = application.getInitParameter("url");
String user = application.getInitParameter("username");
String pass = application.getInitParameter("password");

String sqlQuery = "select source,destination from flightdetails";

try{
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url,user,pass);
	PreparedStatement stmt = con.prepareStatement(sqlQuery);
	
	ResultSet rs = stmt.executeQuery();	
	while(rs.next()){
	%>
	
	<tr>
		<td><%= rs.getString(1) %></td>
		<td><%= rs.getString(2) %></td>
	</tr>

<%}
	
}	
catch(Exception e){
out.println("<h4 style='color:red'>Source and Destination data does not Exists</h4>");	
}
%>

</table>
<a href="adminDashboard.jsp">Back</a>
</body>
</html>