package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Friends;

public class ReadQuery {
	Connection conn;
	ResultSet rs;
	PreparedStatement st;
	
	public ReadQuery() throws Exception {
		 conn = DB.getConnection();
	}
	
	public void doRead() throws SQLException {
		
		String sql = "select * from friends";
		st = conn.prepareStatement(sql);
		rs = st.executeQuery(sql);		
	}
	
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<table border=1>";
		while(this.rs.next()) {
			Friends friend = new Friends(); // Change this object creation and add the data by using appropriate constructor
			
			friend.setFriendID(rs.getInt("friendID"));
			friend.setFriendName(rs.getString("friendName"));
			friend.setAge(rs.getInt("age"));
			friend.setEmailAddress(rs.getString("emailAddress"));			
			friend.setFavoriteColor(rs.getString("favoriteColor"));
			
					
			table += "<tr>";
			table += "<td>";
			table += friend.getFriendID();
			table += "</td>";
			table += "<td>";
			table += friend.getFriendName();
			table += "</td>";
			table += "<td>";
			table += friend.getEmailAddress();
			table += "</td>";
			table += "<td>";
			table += friend.getAge();
			table += "</td>";
			table += "<td>";
			table += friend.getFavoriteColor();
			table += "</td>";
			table += "<td>";
			table += "<a href='Delete?friendID=" + friend.getFriendID() + "'>Delete</a>";
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

}
