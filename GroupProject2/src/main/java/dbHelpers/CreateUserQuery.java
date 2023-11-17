package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Users;

public class CreateUserQuery {
	Connection con;
	
	public CreateUserQuery() {
		Properties props = new Properties();
		InputStream in;

		try {
			in = getClass().getResourceAsStream("dbConn.properties");
			props.load(in);
			in.close();
			String driver = props.getProperty("jdbc.driver");
			System.out.println(driver);
			if (driver != null) {
				Class.forName(driver);
			}

			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean doCreate(Users user) {

		String userName = user.getUserName();
		String password = user.getPassword();
		String cellphone = user.getCellphone();
		String email = user.getEmail();
		String name = user.getName();
		String address = user.getAddress();
		

		 try {
		        // Check if the username, cellphone, and email are already registered
		        String checkQuery = "SELECT * FROM users WHERE username = ? OR cellphone_no = ? OR email = ?";
		        PreparedStatement checkStatement = con.prepareStatement(checkQuery);
		        checkStatement.setString(1, userName);
		        checkStatement.setString(2, cellphone);
		        checkStatement.setString(3, email);
		        ResultSet resultSet = checkStatement.executeQuery();

		        if (resultSet.next()) {
		            //throw new SQLException("Username, cellphone, or email is already registered");
		        	return false;
		        } else {
		            // Insert the new user
		            String insertQuery = "INSERT INTO users(username, password, cellphone_no, email, name, address) VALUES (?,?,?,?,?,?)";
		            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		            preparedStatement.setString(1, userName);
		            preparedStatement.setString(2, password);
		            preparedStatement.setString(3, cellphone);
		            preparedStatement.setString(4, email);
		            preparedStatement.setString(5, name);
		            preparedStatement.setString(6, address);
		            preparedStatement.executeUpdate();
		            return true;
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }

	}

}
