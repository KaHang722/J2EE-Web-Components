package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import dbHelpers.ReadQuery;
import model.Friends;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String ageStr = request.getParameter("age");
		String color = request.getParameter("color");

		// Perform server-side form validation
		String errorMessage = null;
		if (name.isEmpty() || address.isEmpty() || ageStr.isEmpty() || color.isEmpty()) {
			errorMessage = "All fields are required.";
		} else {
			try {
				int age = Integer.parseInt(ageStr);
				if (age < 0) {
					errorMessage = "Age must be a positive number.";
				}
			} catch (NumberFormatException e) {
				errorMessage = "Age must be a valid number.";
			}
		}

		if (errorMessage != null) {
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request, response);
			return;
		}

		Friends friend = new Friends();

		friend.setFriendName(name);
		friend.setEmailAddress(address);
		friend.setAge( Integer.parseInt(ageStr));
		friend.setFavoriteColor(color);

		AddQuery add = new AddQuery();

		add.doAdd(friend);

		try {
			ReadQuery rq = new ReadQuery();
			String table = "";

			// Execute the read and get the data in the table variable
			rq.doRead();
			table = rq.getHTMLTable();

			request.setAttribute("table", table);
			String url = "/read.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


