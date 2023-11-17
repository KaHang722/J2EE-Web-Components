package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;
import model.Claims;
import dbHelpers.SubmitClaimQuery;

@WebServlet("/SubmitClaim")
public class SubmitClaimController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SubmitClaimController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        int registrationId = 0;
        try {
            registrationId = Integer.parseInt(request.getParameter("registrationId"));
        } catch (NumberFormatException e) {
            showError(request, response, "Invalid Registration ID.");
            return;
        }

        String description = request.getParameter("description");

        if (description == null || description.trim().isEmpty()) {
            showError(request, response, "Description is required.");
            return;
        }

        Claims claim = new Claims();
        claim.setRegistrationId(registrationId);
        claim.setDateOfClaim(new Date());
        claim.setDescription(description);
        claim.setStatus("Pending");

        SubmitClaimQuery submitClaimQuery = new SubmitClaimQuery();

        int numClaims;
        try {
            numClaims = submitClaimQuery.getNumOfClaims(registrationId);
            if (numClaims < 3) {
                boolean success = submitClaimQuery.submitClaim(claim, user.getUserID());
                if (success) {
                    response.sendRedirect("userDashboard.jsp");
                } else {
                    showError(request, response, "Failed to submit the claim.");
                }
            } else {
                showError(request, response, "Maximum number of claims reached for this product.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showError(request, response, "An error occurred while processing the claim.");
        }
    }

    private void showError(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
    }
}
