package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertFormRecords
 */
@WebServlet("/InsertFormRecords")
public class InsertFormRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFormRecords() {
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			
			String db_KaHang = "jdbc:mysql://localhost:3306/as2-kahangchan";
			String username = "root";
			String password = "123456";
			
			Connection connection = DriverManager.getConnection(db_KaHang, username, password);
			
			String empNo = request.getParameter("empNo");
			String empName = request.getParameter("empName");
			String department = request.getParameter("department");
            String jobTitle = request.getParameter("jobTitle");
            
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO emp VALUES(?,?,?,?)");
            stmt.setString(1, empNo);
            stmt.setString(2, empName);
            stmt.setString(3, department);
            stmt.setString(4, jobTitle);
            
            
            stmt.executeUpdate(); 
            System.out.println("Query executed successfully");
            connection.close();
            
            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

