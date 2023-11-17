package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.DisplayRegisteredProductsQuery;

@WebServlet("/display_registered_products")
public class Display_Registered_Products extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Display_Registered_Products() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	DisplayRegisteredProductsQuery dq = new DisplayRegisteredProductsQuery();
            String table = "";
            String searchProductName = request.getParameter("searchProductName");

            if (searchProductName != null && !searchProductName.isEmpty()) {
                dq.doSearchByProductName(searchProductName);
            } else {
                dq.doRead(); // Load all registered products
            }
            table = dq.getHTMLTable();

            request.setAttribute("table", table);
            //request.setAttribute("errorMessage", "");
            request.getSession().setAttribute("errorMessage", "");
            String url = "/display_registered_products.jsp";

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
