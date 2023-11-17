package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ProductQuery;


/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/UpdatingProduct")
public class UpdatingProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatingProduct() {
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
		String id = request.getParameter("id");
        String name = request.getParameter("name");
        String model = request.getParameter("model");
       
        int idInt = Integer.parseInt(id);
        
        ProductQuery update = new ProductQuery();

        boolean updateSuccess = false;
		try {
			updateSuccess = update.doUpdate(idInt, name, model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        if (updateSuccess) {
            // Registration successful, redirect to login page
        	request.setAttribute("errorMessage", "Update sucessful");
            response.sendRedirect("update_products");
            
        	
        } else {
            // Registration failed, display error message and stay on create user page
            request.setAttribute("errorMessage", "Update NOT sucessful");
            //request.getRequestDispatcher("update_products").forward(request, response);
            response.sendRedirect("update_products");
        }
	}

}
