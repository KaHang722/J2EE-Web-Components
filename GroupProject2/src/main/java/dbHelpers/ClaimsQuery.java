package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Claims;

public class ClaimsQuery {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public ClaimsQuery() {
		
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
		String sql = "select * from claims";
		st = con.prepareStatement(sql);
		rs = st.executeQuery(sql);
	}
	
	public void updateClaimsStatus(int claimId, String newStatus) throws SQLException {
        String sql = "UPDATE claims SET status = ? WHERE claim_id = ?";
        st = con.prepareStatement(sql);
        st.setString(1, newStatus);
        st.setInt(2, claimId);
        st.executeUpdate();
    }
	
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<h1>Claims List</h1>";
		table += "<table border=1>";
		table += "<tr><th>Claim Id</th><th>Registration Id</th><th>Date of Claim</th><th>Description</th><th>Status</th><th>Update Status</th></tr>";
		while(this.rs.next()) {
			Claims claims = new Claims(); 
			
			claims.setClaimId(rs.getInt("claim_id"));
			claims.setRegistrationId(rs.getInt("registration_id"));
			claims.setDateOfClaim(rs.getDate("date_of_claim"));
			claims.setDescription(rs.getString("description"));
			claims.setStatus(rs.getString("status"));
			
			table += "<tr>";
			table += "<td>";
			table += claims.getClaimId();
			table += "</td>";
			table += "<td>";
			table += claims.getRegistrationId();
			table += "</td>";
			table += "<td>";
			table += claims.getDateOfClaim();
			table += "</td>";
			table += "<td>";
			table += claims.getDescription();
			table += "</td>";
			table += "<td>";
			table += claims.getStatus();
			table += "</td>";
			table += "<td>";
	        table += "<form action='UpdateClaimsStatus' method='post'>";
	        table += "<select name='updateStatus'>";
	        table += "<option value='Approved'>Approved</option>";
	        table += "<option value='Rejected'>Rejected</option>";
	        table += "</select>";
	        table += "<input type='hidden' name='claimId' value='" + claims.getClaimId() + "'>";
	        table += "<input type='submit' value='Submit'>";
	        table += "</form>";
	        table += "</td>";
			table += "</tr>";
		}
		return table;
	}
	
}
