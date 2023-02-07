package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO; 


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("adminU");
		String password = request.getParameter("adminPass");
		AdminDAO flight = new AdminDAO();
		PrintWriter out = response.getWriter();
		if(email != null && password != null) {
			
			if(flight.adminLogin(email, password)) {
		
			response.sendRedirect("adminDashboard.html");
			}
			else {
				out.print("<h4 style='color:red'>Invalid usesrname or password</h4>");
				RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
				rd.include(request, response);
			}
		}
		else {
			out.print("Enter some input..");
			response.sendRedirect("adminLogin.jsp");
		}
	}

}
