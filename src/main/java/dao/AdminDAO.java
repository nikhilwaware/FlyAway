package dao;
import model.AddFlight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/flyaway";
	static String user = "root";
	static String pass = "Nikhil";
	
	//method to add flight details
public void addFlightDetails(AddFlight addAdmin) throws SQLException{
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/flyaway";
		String user = "root";
		String pass = "Nikhil";
		String insertQuery="insert into flightdetails values(?,?,?,?,?,?,?,?)";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement stmt = con.prepareStatement(insertQuery);
			
			stmt.setInt(1, addAdmin.getFlightId());
			stmt.setString(2, addAdmin.getFlightName());
			stmt.setString(3, addAdmin.getSource());
			stmt.setString(4, addAdmin.getDestination());
			stmt.setInt(5, addAdmin.getEconomy());
			stmt.setInt(6, addAdmin.getBusiness());
			stmt.setInt(7, addAdmin.getPremium());
			stmt.setString(8, addAdmin.getDays());
			stmt.executeUpdate();
			stmt.close();con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

//method to search source and destination
public static AddFlight searchSourceDestination(String source, String Destination) {
	AddFlight addAdmin = null;
	
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement stmt = con.prepareStatement("select * from flightdetails where source=? and destination=?");
		
		stmt.setString(1, source);
		stmt.setString(2, Destination);
		
		ResultSet rs= stmt.executeQuery();
		
		while(rs.next()) {
			int flightId = rs.getInt("flightId");
			String flightName = rs.getString("flightName");
			String src = rs.getString("source");
			String dest = rs.getString("destination");
			int economy = rs.getInt("economy");
			int business = rs.getInt("business");
			int premium = rs.getInt("premium");
			String days = rs.getString("days");
			addAdmin = new AddFlight(flightId,flightName,source,Destination,economy,business,premium,days);
//			System.out.println(flightId + ":"+flightName+":"+src+":"+dest+":"+economy+":"+business+":"+premium+":"+days);
			
			addAdmin.setFlightId(rs.getInt(1));
			addAdmin.setFlightName(rs.getString(2));
			addAdmin.setSource(rs.getString(3));
			addAdmin.setDestination(rs.getString(4));
			addAdmin.setEconomy(rs.getInt(5));
			addAdmin.setBusiness(rs.getInt(6));
			addAdmin.setPremium(rs.getInt(7));
			addAdmin.setDays(rs.getString(8));
//			System.out.println(flightId + ":"+flightName+":"+src+":"+dest+":"+economy+":"+business+":"+premium);
			
			
		}
	}catch (Exception e) {
		System.out.println(e.getMessage());
		
	}
	
	return addAdmin;
}


//method to get economy class fare
public int getClass(String source,String destination,int traveler) {
	int totalFare;
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement stmt = con.prepareStatement("select economy from flightdetails where source=? and destination=?");
		
		stmt.setString(1, source);
		stmt.setString(2, destination);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			AddFlight admin = new AddFlight();
			int eco=rs.getInt(1);
			
			admin.setEconomy(eco);
			totalFare = traveler*rs.getInt(1);
	
			return totalFare;
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	return 0;
}


//method to get business class fare
public int getBusinesClass(String source,String destination,int traveler) {
	int totalFare;
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement stmt = con.prepareStatement("select business from flightdetails where source=? and destination=?");
		
		stmt.setString(1, source);
		stmt.setString(2, destination);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			AddFlight admin = new AddFlight();
			int business=rs.getInt(1);
			
			admin.setBusiness(business);
			totalFare = traveler*rs.getInt(1);
	
			return totalFare;
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	return 0;
}

//method to get premium class fare
public int getPremiumClass(String source,String destination,int traveler) {
	int totalFare;
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement stmt = con.prepareStatement("select premium from flightdetails where source=? and destination=?");
		
		stmt.setString(1, source);
		stmt.setString(2, destination);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			AddFlight admin = new AddFlight();
			int pre=rs.getInt(1);
			
			admin.setPremium(pre);
			totalFare = traveler*rs.getInt(1);
	
			return totalFare;
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	return 0;
}

//method for admin login
public boolean adminLogin(String email,String password) {
	
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement stmt = con.prepareStatement("select * from admin where email=? and password=?");
		
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



//method to update admin password
public boolean changePassword(String email,String password) {
	
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement stmt = con.prepareStatement("update admin set password=? where email=?");
		
		stmt.setString(1, password);
		stmt.setString(2, email);
		
		stmt.executeUpdate();
		stmt.close();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}

	return false;
}


}
