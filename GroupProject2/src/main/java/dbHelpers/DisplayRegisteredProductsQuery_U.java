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

import model.RegisteredProduct;
import model.Users;

public class DisplayRegisteredProductsQuery_U {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public DisplayRegisteredProductsQuery_U() {
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
        String sql = "SELECT r.*, p.product_name FROM registered_products r JOIN products p ON r.productid = p.productid WHERE r.userid = ?";
        st = con.prepareStatement(sql);
        st.setInt(1, userId);
        rs = st.executeQuery();
	}
	
	public String getHTMLTable() throws SQLException {
		String table = "";
		table +="<h1> Your Registered Products</h1>";
		table += "<table border=1>";
		table += "<tr><th>Registration Id</th><th>User Id</th><th>Product Id</th><th>Product Name</th><th>Serial No</th><th>Purchase Date</th><th>Number of Claims</th><th>Claim</th></tr>";
		while(this.rs.next()) {
			RegisteredProduct rp = new RegisteredProduct(); 
			 String productName = rs.getString("product_name");
			 int number_of_claim = rs.getInt("num_of_claims");
			rp.setRegistrationId(rs.getInt("registration_id"));
			rp.setUserId(rs.getInt("userid"));
			rp.setProductId(rs.getInt("productid"));
			rp.setSerialNo(rs.getString("serial_no"));
			rp.setPurchaseDate(rs.getDate("purchase_date"));
			
			table += "<tr>";
			table += "<td>";
			table += rp.getRegistrationId();
			table += "</td>";
			table += "<td>";
			table += rp.getUserId();
			table += "</td>";
			table += "<td>";
			table += rp.getProductId();
			table += "</td>";
			table += "<td>";
		    table += productName;
		    table += "</td>";
			table += "<td>";
			table += rp.getSerialNo();
			table += "</td>";
			table += "<td>";
			table += rp.getPurchaseDate();
			table += "</td>";
			table += "<td>";
			table += number_of_claim;
			table += "</td>";
			table += "<td>";
			table += "<a href=\"submitClaim.jsp\">Claim</a>";
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}

}
