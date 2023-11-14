package mvcdemo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator {
 
	public String authenticate(Connection conn, String username, String password) throws SQLException {
		
		PreparedStatement checkStatement = conn
				.prepareStatement("SELECT * from `user` WHERE `username` = ? AND `password`=?" );
		checkStatement.setString(1, username);
		checkStatement.setString(2, password);
		ResultSet rs = checkStatement.executeQuery();
		if (rs.next()) {
			return "success";
		}
		return "failure";
	}
}