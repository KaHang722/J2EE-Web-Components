package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.RegisteredProduct;

public class DisplayRegisteredProductsQuery {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public DisplayRegisteredProductsQuery() {
		
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
		String sql = "select * from registered_products";
		st = con.prepareStatement(sql);
		rs = st.executeQuery(sql);
	}
	
	public void doSearchByProductName(String productName) throws SQLException {
        String sql = "SELECT rp.*, p.product_name FROM registered_products rp " +
                     "INNER JOIN products p ON rp.productid = p.productid " +
                     "WHERE p.product_name LIKE ?";
        st = con.prepareStatement(sql);
        st.setString(1, "%" + productName + "%");
        rs = st.executeQuery();
    }
	
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<h1>Registered products List</h1>";
		table += "<table border=1>";
		table += "<tr><th>Registration Id</th><th>User Id</th><th>Product Id</th><th>Serial No</th><th>Purchase Date</th><th>Number of Claims</th></tr>";
		while(this.rs.next()) {
			RegisteredProduct rp = new RegisteredProduct(); 
			
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
			table += rp.getSerialNo();
			table += "</td>";
			table += "<td>";
			table += rp.getPurchaseDate();
			table += "</td>";
			table += "<td>";
			table += number_of_claim;
			table += "</td>";
			table += "</tr>";
		}
		return table;
	}
	
}
