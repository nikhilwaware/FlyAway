package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.UserDAO;
import model.AddFlight;


@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ServletContext context = getServletContext();
		String driver = context.getInitParameter("driver");
		String url = context.getInitParameter("url");
		String username = context.getInitParameter("username");
		String pass = context.getInitParameter("password");
		
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		AddFlight admin = new AddFlight();
		UserDAO userDao = new UserDAO();
		
		try {
			if(email != null && password != null) {
				if(userDao.userLogin(email, password)) {
					RequestDispatcher rd = request.getRequestDispatcher("payment.html");
					rd.forward(request, response);
				}
				else {
					out.print("<h3 style='color :red'>Invalid username or password...</h3>");
					RequestDispatcher rd = request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}
			}
			else {
				out.print("Please enter some input");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
		
	}


