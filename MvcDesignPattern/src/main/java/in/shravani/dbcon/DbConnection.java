package in.shravani.dbcon;
import java.sql.*;
public class DbConnection {

public static Connection getConnection() {
	// TODO Auto-generated method stub
	Connection con=null;
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_db","root","pass123");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
