package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		ResultSet rs = null;
		
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
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			connection = DriverManager.getConnection(db_KaHang, db_username, db_password);
			System.out.println("Connection done");
			
			String query = "Select * from login where username='"+username+"' AND password='"+password+"'";
			
			statement=connection.createStatement();
			
			rs = statement.executeQuery(query);
			
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

			docType += "<HTML>\n" + "<HEAD><TITLE>Login DAta</TITLE> </HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n";
			out.println(docType);
			
			if (rs.next()) {
				out.println("Login is successful");
			}else {
				out.println("Login is failed");
			}
			
		}catch (Exception e) {
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
