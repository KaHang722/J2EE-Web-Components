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
 * Servlet implementation class ProcessFormData
 */
@WebServlet("/ProcessFormData")
public class ProcessFormData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessFormData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reportNo = request.getParameter("reportNo");
		String reportDesc = request.getParameter("reportDesc");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			
			String db_KaHang = "jdbc:mysql://localhost:3306/myinfo";
			String username = "root";
			String password = "123456";
			
			Connection connection = DriverManager.getConnection(db_KaHang, username, password);
			System.out.println("Connection done");
			
			Statement statement = connection.createStatement();
			
			String query = "INSERT INTO report_KaHang VALUES ('" + reportNo + "','" + reportDesc + "')";
			
			statement.executeUpdate(query);
			
			System.out.println("Query executed successfully");
			
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
