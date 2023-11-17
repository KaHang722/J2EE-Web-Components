package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Date;
import java.util.ArrayList;
import model.Admin;
import model.UserReportData;

public class ViewReportQuery {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public ViewReportQuery() {
		
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
		String sql = "SELECT u.userid, u.username, p.product_name, rp.serial_no, rp.purchase_date, rp.num_of_claims, c.claim_id, c.date_of_claim, c.description, c.status " +
                "FROM users u " +
                "JOIN registered_products rp ON u.userid = rp.userid " +
                "JOIN products p ON rp.productid = p.productid " +
                "LEFT JOIN claims c ON rp.registration_id = c.registration_id " +
                "ORDER BY u.userid, rp.registration_id, c.claim_id";
		st = con.prepareStatement(sql);
		rs = st.executeQuery(sql);
	}
	
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<h1>Report</h1>";
		table += "<table border=1>";
		table += "<tr><th>User Id</th><th>Username</th><th>Product Name</th><th>Serial No</th><th>Purchase Date</th><th>Number of Claims</th><th>Claim ID</th><th>Date of Claims</th><th>Claim Description</th><th>Claim Status</th></tr>";
		while(this.rs.next()) {
			UserReportData ur = new UserReportData();
			
			ur.setUserId(rs.getInt("u.userid"));
			ur.setUserName(rs.getString("u.username"));
			ur.setProductName(rs.getString("p.product_name"));
			ur.setSerialNo(rs.getString("rp.serial_no"));
            ur.setPurchaseDate(rs.getDate("rp.purchase_date"));
            ur.setNumClaims(rs.getInt("rp.num_of_claims"));
            ur.setClaimId(rs.getInt("c.claim_id"));
            ur.setDateOfClaim(rs.getDate("c.date_of_claim"));
            ur.setDescription(rs.getString("c.description"));
            ur.setClaimStatus(rs.getString("c.status"));
			
			table += "<tr>";
			table += "<td>";
			table += ur.getUserId();
			table += "</td>";
			table += "<td>";
			 table += ur.getUserName();
	            table += "</td>";
	            table += "<td>";
	            table += ur.getProductName();
	            table += "</td>";
	            table += "<td>";
	            table += ur.getSerialNo();
	            table += "</td>";
	            table += "<td>";
	            table += ur.getPurchaseDate();
	            table += "</td>";
	            table += "<td>";
	            table += ur.getNumClaims();
	            table += "</td>";
	            table += "<td>";
	            table += ur.getClaimId();
	            table += "</td>";
	            table += "<td>";
	            table += ur.getDateOfClaim();
	            table += "</td>";
	            table += "<td>";
	            table += ur.getDescription();
	            table += "</td>";
	            table += "<td>";
	            table += ur.getClaimStatus();
	            table += "</td>";
	            table += "</tr>";
		}
		return table;
	}
	
	
		
	}


