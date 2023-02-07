package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.AddFlight;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Search() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("driver");
		String url = context.getInitParameter("url");
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		
		PrintWriter out = response.getWriter();
		AdminDAO admin = new AdminDAO();
		AddFlight addAdmin = new AddFlight();
		

		try {
			
			addAdmin=admin.searchSourceDestination(source, destination);
			
			if(source!= null && destination!= null){
			
				admin.searchSourceDestination(source, destination);
			out.println("<body style='background-color : #e6e6e6; font-size : 40px; margin-top:30px'>");
			out.println("<a href='index.html'>Back</a>");
			out.print("<form action='PasengerDetails.jsp'>");
			out.print("<table><tr><th>FlightId</th><th>FlightName</th><th>Source</th><th>Destination</th>"
					+"<th>Economy</th><th>Business</th><th>Premium</th><th>Days</th></tr>");
			out.print("<tr><td>"+addAdmin.getFlightId()+"</td><td>"+addAdmin.getFlightName()+" </td><td> "+addAdmin.getSource()+"</td><td>"
					+addAdmin.getDestination()+"</td><td>"+addAdmin.getEconomy()+"</td><td>"+addAdmin.getBusiness()+"</td><td>"+addAdmin.getPremium()+"</td><td>"+addAdmin.getDays()+"</td>");
			out.print("<td><input type='submit' value='Book Now'></td></tr>");
			out.print("</table></form></body>");
			}
			else {
				out.println("<h4 style='color:red'>No Flights Found on this route</h4>");
						
			}	
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
