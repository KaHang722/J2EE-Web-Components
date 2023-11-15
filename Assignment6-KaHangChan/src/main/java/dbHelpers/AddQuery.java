package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import model.Friends;

public class AddQuery {
	Connection con;
	
	public AddQuery() {
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

	public void doAdd(Friends friend) {

		String name = friend.getFriendName();
		String email = friend.getEmailAddress();
		int age = friend.getAge();
		String color = friend.getFavoriteColor();

		try {

			String query = "insert into friends(friendName, age, emailAddress, favoriteColor) values (?,?,?,?)";

			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(4, color);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
