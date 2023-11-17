package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.DisplayClaimsQuery;
import model.Users;

/**
 * Servlet implementation class DisplayClaimController
 */
@WebServlet("/DisplayClaim_C")
public class DisplayClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayClaimController() {
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
            
        	DisplayClaimsQuery dq = new DisplayClaimsQuery();
            String table = "";

            // Execute the read and get the data in the table variable
            dq.doRead(user.getUserID());
            table = dq.getHTMLTable();

            request.setAttribute("table", table);
            //request.setAttribute("errorMessage", "");
            request.getSession().setAttribute("errorMessage", "");
            String url = "/displayClaims_U.jsp";

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
		doGet(request, response);
	}

}
