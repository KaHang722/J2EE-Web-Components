package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	
	private Connection conn;
	
	public UserDao(Connection conn){
		this.conn = conn;
	}
	
	public boolean authenticate(String username, String password) throws Exception {
		String sql = "select * from user where username = ? and password = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		return rs.next();
	}

}
