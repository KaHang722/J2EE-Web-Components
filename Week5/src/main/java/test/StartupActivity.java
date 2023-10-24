package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartupActivity
 */
@WebServlet("/StartupActivity")
public class StartupActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartupActivity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement statement=null;
		Connection connection=null;
		ResultSet ts = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {			
			String db_KaHang = "jdbc:mysql://localhost:3306/oct5-kahangchan";
			String db_username = "root";
			String db_password = "123456";
			
			connection = DriverManager.getConnection(db_KaHang, db_username, db_password);
			System.out.println("Connection done");
			
			String[]users = new String[]{"John","Kay", "Ken"};
			String[]password = new String[]{"12345","54321", "98765"};
			String[]email = new String[]{"a@a.com","b@b.com", "c@c.com"};
					
			
			
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO login values(?,?,?)");
			
			for(int i=0; i<3; i++) {
				prepareStatement.setString(1, users[i]);
				prepareStatement.setString(2, password[i]);
				prepareStatement.setString(3, email[i]);
				prepareStatement.addBatch(); 
				
			}
			
			prepareStatement.executeBatch();
			
			System.out.println("Data record has been entered into database");
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
