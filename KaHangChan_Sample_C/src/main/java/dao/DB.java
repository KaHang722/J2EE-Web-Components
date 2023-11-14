package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static Connection connection;
	
	private DB() {
		
	}
	
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/db1", "root", "123456");
		}
		return connection;
	}

	
	
}
