package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Users;

public class UserLoginQuery {
	Connection con;
	
	public UserLoginQuery() {
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

	public Users doLogin(String userName, String password) {


		try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Users user = new Users();
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                // ... (Set other user properties)
                return user;
            } else {
                return null; // Invalid login
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

	}
	
	public int getUserID(String username) {
	    int userID = 0;

	    try {
	        String query = "SELECT userid FROM users WHERE username = ?";
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        preparedStatement.setString(1, username);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            userID = resultSet.getInt("userid");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return userID;
	}

}
