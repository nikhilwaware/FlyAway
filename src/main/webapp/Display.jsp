<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
body {

margin : 15px;
font-size: 22px;
background-color: #e6e6e6;
}
table {
  border-collapse: collapse;
  width: 100%;
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
a{
text-decoration: none;
color : #004d99;
}
</style>
</head>
<body>
<a href="index.html">Home Page</a>
<h3>Flights List</h3>
 <div id="">
	<table>
		<tr>
				<th>FlightId</th>
				<th>FlightName</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Economy</th>
				<th>Business</th>
				<th>Premium</th>
				<th>Days</th>
			</tr>
		
		<%String driver=application.getInitParameter("driver");
		  String url = application.getInitParameter("url");
		  String username = application.getInitParameter("username");
		  String password = application.getInitParameter("password");
		  String source = "Mumbai";
		 // String destination="Delhi";
			try{
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement stmt = con.prepareStatement("select * from flightdetails");
				ResultSet rs = stmt.executeQuery();	
				
			 	while(rs.next()) {
					out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"
							+rs.getInt(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getInt(7)+"</td><td>"+rs.getString(8));
					out.print("<td></td></tr>");
					
							}
			}
			
			  
			catch(Exception e){
				out.print(e.getMessage());
			}%>
			
			
	</table>
	
</div>
<a href="adminDashboard.html">Back</a>
<div id="navBar">
	<a href="adminChangePassword.html">Change Password</a>
</div>
</body>
</html>