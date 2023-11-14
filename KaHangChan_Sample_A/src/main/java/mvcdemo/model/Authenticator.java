package mvcdemo.model;

import java.sql.*;

public class Authenticator {

	public String authenticate(String username, String password) {
		
		String result = "failure";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

			String sqlQuery = "select * from db1.USER where username = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, username);
			ps.setString(2, password);
						
			System.out.print(sqlQuery);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {

				if ((resultSet.getString(1).equalsIgnoreCase(username)) && (resultSet.getString(2).equals(password))) {
					result = "success";
				} else {
					result = "failure";
				}
			}

			resultSet.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}
}