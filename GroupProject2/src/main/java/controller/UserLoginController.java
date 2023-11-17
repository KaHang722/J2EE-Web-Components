package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.UserLoginQuery;
import model.Users;
/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLogin")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
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
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
            return;
        }
        
        // Validate login credentials
        UserLoginQuery userLoginQuery = new UserLoginQuery();
        Users user = userLoginQuery.doLogin(username, password);

        if (user != null) {
            // Successful login
            // You can set user information in session and redirect to a dashboard page
        	int userID = userLoginQuery.getUserID(username);
        	user.setUserID(userID);
        	HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("userDashboard.jsp");
        } else {
            // Invalid login
            // You can display an error message on the login page
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
        }
    }

}
