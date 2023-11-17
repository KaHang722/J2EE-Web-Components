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

public class SubmitClaimQuery {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public SubmitClaimQuery() {
		
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

	public boolean submitClaim(Claims claim, int userId) throws SQLException {
        String insertClaimQuery = "INSERT INTO claims (registration_id, date_of_claim, description, status) VALUES (?, ?, ?, ?)";
        String updateRegisteredProductQuery = "UPDATE registered_products SET num_of_claims = num_of_claims + 1 WHERE registration_id = ?";

        try (PreparedStatement insertStatement = con.prepareStatement(insertClaimQuery);
             PreparedStatement updateStatement = con.prepareStatement(updateRegisteredProductQuery)) {

            con.setAutoCommit(false);

            insertStatement.setInt(1, claim.getRegistrationId());
            insertStatement.setDate(2, new java.sql.Date(claim.getDateOfClaim().getTime()));
            insertStatement.setString(3, claim.getDescription());
            insertStatement.setString(4, claim.getStatus());

            updateStatement.setInt(1, claim.getRegistrationId());

            insertStatement.executeUpdate();
            updateStatement.executeUpdate();

            con.commit();
            return true;
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
	
	public int getNumOfClaims(int registrationId) throws SQLException {
	    int numClaims = 0;

	    String query = "SELECT num_of_claims FROM registered_products WHERE registration_id = ?";
	    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	        preparedStatement.setInt(1, registrationId);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            numClaims = resultSet.getInt("num_of_claims");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return numClaims;
	}
	
}
