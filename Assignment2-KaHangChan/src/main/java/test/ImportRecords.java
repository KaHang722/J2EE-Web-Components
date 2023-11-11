package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImportRecords
 */
@WebServlet("/ImportRecords")
public class ImportRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			
			String db_KaHang = "jdbc:mysql://localhost:3306/as2-kahangchan";
			String username = "root";
			String password = "123456";
			
			Connection connection = DriverManager.getConnection(db_KaHang, username, password);
			System.out.println("Connection done");
			
			Statement statement = connection.createStatement();
			
			String[] sqlStatements = {
				    "INSERT INTO emp VALUES ('1', 'Shane', 'IT', 'Programmer')",
				    "INSERT INTO emp VALUES ('2', 'Peter', 'Financial', 'Analyst')",
				    "INSERT INTO emp VALUES ('3', 'John', 'Sale', 'Assistant')",
				    "INSERT INTO emp VALUES ('4', 'Sam', 'IT', 'Programmer')",
				    "INSERT INTO emp VALUES ('5', 'Sammy', 'Financial', 'Analyst')",
				    "INSERT INTO emp VALUES ('6', 'Katie', 'Sale', 'Assistant')",
				    "INSERT INTO emp VALUES ('7', 'James', 'IT', 'Programmer')",
				    "INSERT INTO emp VALUES ('8', 'Tim', 'Financial', 'Analyst')",
				    "INSERT INTO emp VALUES ('9', 'David', 'Sale', 'Assistant')",
				    "INSERT INTO emp VALUES ('10', 'Iris', 'IT', 'Programmer')"
				};

				int batchSize = 10; 
				int count = 0;

				for (String sql : sqlStatements) {
				    statement.addBatch(sql);

				    if (++count % batchSize == 0) {
				        statement.executeBatch();
				    }
				}

				// Execute the remaining batch
				if (count % batchSize != 0) {
				    statement.executeBatch();
				}

			
			System.out.println("Query executed successfully");
			
			connection.close();
			
		} catch (Exception e) {
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
