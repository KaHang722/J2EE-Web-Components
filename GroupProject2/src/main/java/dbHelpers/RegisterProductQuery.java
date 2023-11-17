package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import model.Users;

public class RegisterProductQuery {
	Connection con;
	
	public RegisterProductQuery() {
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

	public boolean registerProduct(int userId, String productName, String serialNo, String purchaseDate) {
        try {
        	
            // Perform the database insertion here
            String query = "INSERT INTO registered_products (userid, productid, serial_no, purchase_date) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, getProductIdByName(productName)); 
            preparedStatement.setString(3, serialNo);
            preparedStatement.setString(4, purchaseDate);
            preparedStatement.setInt(5, 0);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	private int getProductIdByName(String productName) {
		// TODO Auto-generated method stub
		 int productId = -1;
		 try {
	            String query = "SELECT productid FROM products WHERE product_name = ?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setString(1, productName);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                productId = resultSet.getInt("productid");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return productId;
	    }
	
	public boolean productExists(String productName) {
	    try {
	        String query = "SELECT COUNT(*) FROM products WHERE product_name = ?";
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        preparedStatement.setString(1, productName);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
