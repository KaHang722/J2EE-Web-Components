package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisteredProduct;
import model.Users;
import dbHelpers.DisplayRegisteredProductsQuery_U;

/**
 * Servlet implementation class DisplayRegisteredProductController
 */
@WebServlet("/DisplayRegisteredProduct")
public class DisplayRegisteredProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayRegisteredProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");

            DisplayRegisteredProductsQuery_U dq = new DisplayRegisteredProductsQuery_U();
            String table = "";

            // Execute the read and get the data in the table variable
            dq.doRead(user.getUserID()); // Pass the user's ID
            table = dq.getHTMLTable();

            request.setAttribute("table", table);
            request.getSession().setAttribute("errorMessage", "");
            String url = "/displayRegisteredProducts_U.jsp";

            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}


