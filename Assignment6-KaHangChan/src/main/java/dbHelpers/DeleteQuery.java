package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import model.Friends;

public class DeleteQuery {
	Connection con;
	
	public DeleteQuery() {
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

	public void doDelete(int friendID) throws SQLException {
        String sql = "DELETE FROM friends WHERE friendID = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, friendID);
            st.executeUpdate();
        }
    }
}
