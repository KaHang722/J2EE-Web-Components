package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private static Connection conn;
	
	public static Connection getConnection() throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myinfo", "root", "123456");
		}
		return conn;
	}

}
