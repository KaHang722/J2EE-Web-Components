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
 * Servlet implementation class FetchDataServlet
 */
@WebServlet("/FetchDataServlet")
public class FetchDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchDataServlet() {
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
			
			String query = "Select * from login";
			
			statement=connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

			docType += "<HTML>\n" + "<HEAD><TITLE>Employees Data</TITLE> </HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
			 + "<table border=" + "1" + ">" + "<tr><th colspan=" + "3" + "><H1>Login Data</H1></th></tr>"
			 + "<tr><th>Username</th>" + "<th>Password</th>" + "<th>Email</th></tr>";

			while (resultSet.next()) {
			docType += "<tr>" + "<td>" + resultSet.getString(1) + "</td>"
			                      + "<td>" + resultSet.getString(2)
			            + "</td>" + "<td>" + resultSet.getString(3) + "</td>" 
			                      + "</tr>";
			}

			docType += "</table></BODY></HTML>";
			out.println(docType);
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
