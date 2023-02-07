<%@page import="model.AddFlight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FlyAway</title>
<style type="text/css">

body {
background-image: url('bg1.jpg');
background-repeat: no-repeat;
background-attachment:fixed;
text-align : left;
margin : 15px;
font-size: 20px;
}
</style>
</head>
<body>
<%
AddFlight admin = new AddFlight();
//String source = admin.getSource();
//String destination = admin.getDestination();
%>
<form action="Details.jsp">

 	<h4>Confirm Source and Destination</h4> 	
	<table>
	<tr>
	<td>Source </td>
	<td> <input id="src" type="text" name="src" placeholder="Enter source again"></td> 		
	</tr>
	
	<tr>
	<td>Destination </td>
	<td><input id="dest" type="text" name="dest" placeholder="Enter destination again"></td>  
	</tr>   
	
	<tr>
	<td>Enter Class</td>
	<td><input type="text" name="class" placeholder="ECO/BUS/PRE"></td>
	</tr>
	
	<tr>
	<td>Passenger Name</td>
	<td><input type="text" name="passName" placeholder="Passenger Name"></td>
	</tr>

	
	<tr>
	<td>Number of Passengers</td>
	<td><input type="text" name="passengers" placeholder="Number of Passengers"></td>
	</tr>
	
	<tr>
	<td></td>
	<td><input type="submit" value="Submit"></td>
	</tr>
	
	</table>
	
</form>
</body>
</html>