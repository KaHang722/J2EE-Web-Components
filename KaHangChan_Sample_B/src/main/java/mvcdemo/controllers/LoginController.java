package mvcdemo.controllers;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcdemo.model.Authenticator;
import java.sql.Connection;
import mvcdemo.model.User;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;

		Authenticator authenticator = new Authenticator();
		try {
			String result = authenticator.authenticate(getConnection(), username, password);
			if (result.equals("success")) {
				rd = request.getRequestDispatcher("/success.jsp");
				User user = new User(username, password);
				request.setAttribute("user", user);
			} else {
				rd = request.getRequestDispatcher("/error.jsp");
			}
		} catch (Exception e) {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	private Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?serverTimezone=EST5EDT", "root",
				"123456");
		return conn;

	}
}