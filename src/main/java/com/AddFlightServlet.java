package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddFlight;
import dao.AdminDAO;



@WebServlet("/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("driver");
		String url = context.getInitParameter("url");
		String user = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		
		String flightId = request.getParameter("flightId");
		String flightname = request.getParameter("newflight");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int economy = Integer.parseInt(request.getParameter("eco"));
		int business = Integer.parseInt(request.getParameter("busi"));
		int premium = Integer.parseInt(request.getParameter("pre"));
		String days = request.getParameter("days");
			
		PrintWriter out = response.getWriter();
		
		try {
			insertUser(request,response);
			out.print("<body style = 'background-color : #66d9ff;'>");
			out.print("<h3>Flight Details Added Succesfully...</h3><br>");
			out.print("<h3><a href='addFlight.html'>Add Flight</a></h3>");
			out.print("</body>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private void insertUser(HttpServletRequest request,HttpServletResponse respones) throws SQLException,IOException{
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		String flightname = request.getParameter("newflight");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int economy = Integer.parseInt(request.getParameter("eco"));
		int business = Integer.parseInt(request.getParameter("busi"));
		int premium = Integer.parseInt(request.getParameter("pre"));
		String days = request.getParameter("days");
		AdminDAO f = new AdminDAO();
		AddFlight addAdmin = new AddFlight(flightId,flightname,source,destination,economy,business,premium,days);
		
		f.addFlightDetails(addAdmin);
		
	}
}
