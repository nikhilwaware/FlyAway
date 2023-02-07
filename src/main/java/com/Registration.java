package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddFlight;
import dao.AdminDAO;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("driver");
		String url = context.getInitParameter("url");
		String username = context.getInitParameter("username");
		String pass = context.getInitParameter("password");
		PrintWriter out = response.getWriter();
		
		//Grabing values from html page
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int mobileNo = Integer.parseInt(request.getParameter("mbl_no"));
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,pass);
			PreparedStatement stmt = con.prepareStatement("insert into userdetails values(?,?,?,?,?)");
			
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, email);
			stmt.setString(4, password);
			stmt.setInt(5, mobileNo);
			
			stmt.executeUpdate();
			stmt.close();con.close();
			
			out.println("<h3 style='color:green'>User Added Succesfully...</h3>");
			response.sendRedirect("payment.html");
		} catch (Exception e) {
			out.println("<h4 style='color:red'>Failed to add User</h4>");
			out.println("<a href='userRegistration.html'>Try Again</a>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
