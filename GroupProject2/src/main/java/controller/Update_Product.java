package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ProductQuery;

@WebServlet("/update_products")
public class Update_Product extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Update_Product() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductQuery dq = new ProductQuery();
            String table = "";

            // Execute the read and get the data in the table variable
            dq.doRead();
            table = dq.getHTMLTable();

            request.setAttribute("table", table);
            //request.setAttribute("errorMessage", "");
            request.getSession().setAttribute("errorMessage", "");
            String url = "/update_products.jsp";

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
