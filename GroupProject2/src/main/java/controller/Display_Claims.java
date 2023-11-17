package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ClaimsQuery;

@WebServlet("/display_claims")
public class Display_Claims extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Display_Claims() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ClaimsQuery dq = new ClaimsQuery();
            String table = "";

            // Execute the read and get the data in the table variable
            dq.doRead();
            table = dq.getHTMLTable();

            request.setAttribute("table", table);
            //request.setAttribute("errorMessage", "");
            request.getSession().setAttribute("errorMessage", "");
            String url = "/display_claims.jsp";

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
