package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {


	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/flyaway";
	static String user = "root";
	static String pass = "Nikhil";
	

	
	
	
public boolean userLogin(String email,String password) {
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement stmt = con.prepareStatement("select * from userdetails where email=? and password=?");
			
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
}
