package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.CreateUserQuery;
import model.Users;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserController() {
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
		String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String cellphone = request.getParameter("cellphone");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        Users user = new Users();
        user.setUserName(userName);
        user.setPassword(password);
        user.setCellphone(cellphone);
        user.setEmail(email);
        user.setName(name);
        user.setAddress(address);
        
        String validationErrors = "";
        if (userName == null || userName.isEmpty()|| password == null || 
        		password.isEmpty() || cellphone == null || cellphone.isEmpty() || 
        		email == null || email.isEmpty()|| name == null || name.isEmpty() ||
        		address == null || address.isEmpty()) {
            validationErrors += "All Fields are required.<br>";
        }
        

        if (!validationErrors.isEmpty()) {
            // Display validation errors
            request.setAttribute("validationErrors", validationErrors);
            request.getRequestDispatcher("createUser.jsp").forward(request, response);
            return;
        }

        
        CreateUserQuery create = new CreateUserQuery();

        boolean registrationSuccess = create.doCreate(user);
        if (registrationSuccess) {
            // Registration successful, redirect to login page
            response.sendRedirect("userLogin.jsp");
        } else {
            // Registration failed, display error message and stay on create user page
            request.setAttribute("errorMessage", "Username, cellphone, or email is already registered");
            request.getRequestDispatcher("createUser.jsp").forward(request, response);
        }
	}

}
