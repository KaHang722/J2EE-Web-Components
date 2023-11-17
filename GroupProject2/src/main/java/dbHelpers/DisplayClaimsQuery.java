package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;

import model.Claims;
import model.Users;

public class DisplayClaimsQuery {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public DisplayClaimsQuery() {
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
	
	public void doRead(int userId) throws SQLException {
        // READ your Data and save it in ResultSet
        String sql = "SELECT c.*, p.product_name FROM claims c JOIN registered_products r ON c.registration_id=r.registration_id JOIN products p ON r.productid = p.productid WHERE r.userid = ?";
        st = con.prepareStatement(sql);
        st.setInt(1, userId);
        rs = st.executeQuery();
	}
	
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<h1>Your Claims</h1>";
		table += "<table border=1>";
		table += "<tr><th>Claim Id</th><th>Registration Id</th><th>Product Name</th><th>Date of Claim</th><th>Description</th><th>Status</th></tr>";
		while(this.rs.next()) {
			Claims c = new Claims(); 
			 String productName = rs.getString("product_name");
			
			c.setClaimId(rs.getInt("claim_id"));
			c.setRegistrationId(rs.getInt("registration_id"));
			c.setDateOfClaim(rs.getDate("date_of_claim"));
			c.setDescription(rs.getString("description"));
			c.setStatus(rs.getString("status"));
			
			table += "<tr>";
			table += "<td>";
			table += c.getClaimId();
			table += "</td>";
			table += "<td>";
			table += c.getRegistrationId();
			table += "</td>";
			table += "<td>";
		    table += productName;
		    table += "</td>";
			table += "<td>";
			table += c.getDateOfClaim();
			table += "</td>";
			table += "<td>";
			table += c.getDescription();
			table += "</td>";
			table += "<td>";
			table += c.getStatus();
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

}
