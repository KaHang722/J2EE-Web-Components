package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.DisplayUsersQuery;

@WebServlet("/display_users")
public class Display_Users extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Display_Users() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DisplayUsersQuery dq = new DisplayUsersQuery();
            String table = "";
            String searchUserName = request.getParameter("searchUserName");

            if (searchUserName != null && !searchUserName.isEmpty()) {
                dq.doSearchByUserName(searchUserName);
            } else {
                dq.doRead(); // Load all registered products
            }
            table = dq.getHTMLTable();

            request.setAttribute("table", table);
            String url = "/display_users.jsp";

            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests if needed
    }
}
