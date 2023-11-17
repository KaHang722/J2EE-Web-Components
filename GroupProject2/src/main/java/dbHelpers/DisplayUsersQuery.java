package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Users;

public class DisplayUsersQuery {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public DisplayUsersQuery() {
		
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

	public void doRead() throws SQLException {
		// READ your Data and save it in ResultSet
		String sql = "select * from users";
		st = con.prepareStatement(sql);
		rs = st.executeQuery(sql);
	}
	
	public void doSearchByUserName(String username) throws SQLException {
        String sql = "SELECT * FROM users " +
                     "WHERE username LIKE ?";
        st = con.prepareStatement(sql);
        st.setString(1, "%" + username + "%");
        rs = st.executeQuery();
    }
	
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<h1>Users List</h1>";
		table += "<table border=1>";
		table += "<tr><th>User Id</th><th>User Name</th><th>Password</th><th>Phone no.</th><th>Email</th><th>Name</th><th>Address</th></tr>";
		while(this.rs.next()) {
			Users user = new Users(); 
			
			user.setUserID(rs.getInt("userid"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setCellphone(rs.getString("cellphone_no"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setAddress(rs.getString("address"));
			
			
			table += "<tr>";
			table += "<td>";
			table += user.getUserID();
			table += "</td>";
			table += "<td>";
			table += user.getUserName();
			table += "</td>";
			table += "<td>";
			table += user.getPassword();
			table += "</td>";
			table += "<td>";
			table += user.getCellphone();
			table += "</td>";
			table += "<td>";
			table += user.getEmail();
			table += "</td>";
			table += "<td>";
			table += user.getName();
			table += "</td>";
			table += "<td>";
			table += user.getAddress();
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

}
