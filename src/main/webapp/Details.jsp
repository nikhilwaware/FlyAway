<%@page import="dao.AdminDAO"%>
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
h3{
color :#003d99;
}
td{
font-size: 24px;
color : white;
}
input{
background-color: white;
border: 1px solid blue;
color : blue;
}
</style>
</head>
<body>

<form action="userRegistration.html">
	<%
		
		AddFlight admin = new AddFlight();
		AdminDAO flight = new AdminDAO();
		
		String source = request.getParameter("src");
		String destination = request.getParameter("dest");
		String travelClass = request.getParameter("class");
		String passengerName = request.getParameter("passName");
		int traveller = Integer.parseInt(request.getParameter("passengers"));
		int totalFare=0;
		
		//based on travelClass and number of traveler entered, it will show the totalFare 
		if(travelClass.equalsIgnoreCase("economy")  ){
		totalFare = flight.getClass(source, destination,traveller);
		}
		else if(travelClass.equalsIgnoreCase("business")){
			totalFare = flight.getBusinesClass(source, destination, traveller);
			
		}
		else if(travelClass.equalsIgnoreCase("premium")){
			totalFare = flight.getPremiumClass(source, destination, traveller);
		}
	%>
	<h3>Journey Details</h3>
	<table>
	<tr>
	<td>Source</td> 
	<td>:<%= source %></td>
	</tr>
	<tr>
	<td>Destination</td>
	<td>:<%= destination %></td>
	</tr>
	<tr>
	<td>Class</td>
	<td>: <%= travelClass %></td>
	</tr>
	<tr>
	<td>Name of Passenger</td>
	<td>: <%= passengerName %></td>
	</tr>
	<tr>
	<td>Number Of Traveler </td>
	<td>:<%= traveller %></td>
	</tr>
	
	<tr>
	<td>Total Fare </td>
	<td>:<%= totalFare %></td>
	</tr>
	<tr>
	
	<td></td>
	<td><input type="submit" value="Confirm">

	</tr>
	
	</table>
	
	
</form>
</body>
</html>