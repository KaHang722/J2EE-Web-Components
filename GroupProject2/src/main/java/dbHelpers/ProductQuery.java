package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Products;

public class ProductQuery {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public ProductQuery() {
		
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
		String sql = "select * from products";
		st = con.prepareStatement(sql);
		rs = st.executeQuery(sql);
	}
	
	public String getHTMLTable() throws SQLException {
		String table = "";
		table += "<h3>Products List</h3>";
		table += "<table border=1>";
		table += "<tr><th>Product Id</th><th>Product Name</th><th>Model</th></tr>";
		while(this.rs.next()) {
			Products product = new Products(); 
			
			product.setProductID(rs.getInt("productid"));
			product.setProductName(rs.getString("product_name"));
			product.setModel(rs.getString("model"));
			
			table += "<tr>";
			table += "<td>";
			table += product.getProductID();
			table += "</td>";
			table += "<td>";
			table += product.getProductName();
			table += "</td>";
			table += "<td>";
			table += product.getModel();
			table += "</td>";
			
			table += "</tr>";
		}
		return table;
	}

	public boolean doUpdate(int id, String name, String model) throws SQLException{
		
		String updateQuery = "UPDATE products SET product_name = ?, model = ? WHERE productid = ?";
        
        try {
        	st = con.prepareStatement(updateQuery);
            st.setString(1, name);
            st.setString(2, model);
            st.setInt(3, id);
            
            int rowsUpdated = st.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("Product information updated successfully!");
                return true;
            } else {
                System.out.println("No rows were updated.");
                return false;
            }
        }finally{
        	 if (st != null) {
                 st.close();
             }
        }
	}
	
	public boolean doInsert(int id, String name, String model) throws SQLException{
		
		String insertQuery = "INSERT INTO products (productid, product_name, model) VALUES (?, ?, ?)";

	    try {
	        st = con.prepareStatement(insertQuery);
	        st.setInt(1, id);
	        st.setString(2, name);
	        st.setString(3, model);

	        int rowsInserted = st.executeUpdate();

	        if (rowsInserted > 0) {
	            System.out.println("Product inserted successfully!");
	            return true;
	        } else {
	            System.out.println("No rows were inserted.");
	            return false;
	        }
	    } finally {
	        if (st != null) {
	            st.close();
	        }
	    }
	}
	
	public boolean doDelete(int id) throws SQLException{
		
		String deleteQuery = "DELETE FROM products WHERE productid = ?";

	    try {
	        st = con.prepareStatement(deleteQuery);
	        st.setInt(1, id);

	        int rowsDeleted = st.executeUpdate();

	        if (rowsDeleted > 0) {
	            System.out.println("Product deleted successfully!");
	            return true;
	        } else {
	            System.out.println("No rows were deleted.");
	            return false;
	        }
	    } finally {
	        if (st != null) {
	            st.close();
	        }
	    }
		
	}
	
}
