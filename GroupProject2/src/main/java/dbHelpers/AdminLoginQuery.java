package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Admin;

public class AdminLoginQuery {
	Connection con;
	
	public AdminLoginQuery() {
		
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

	public Admin doLogin(String userName, String password) {


		try {
            String query = "SELECT * FROM admin_users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Admin admin = new Admin();
                admin.setUserName(resultSet.getString("userName"));
                admin.setPassword(resultSet.getString("password"));
                // ... (Set other user properties)
                return admin;
            } else {
                return null; // Invalid login
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

	}

}
