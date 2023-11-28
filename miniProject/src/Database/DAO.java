package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {	
	public Connection con;
	public DAO(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
				
			con = DriverManager.getConnection(url,"root","als1tn2!@");
			System.out.println("[DB]Connected");
			}
		catch(ClassNotFoundException e) {
			e.getMessage();
			}
		catch(SQLException e){
	        e.getMessage();
	        }  
	}

}
