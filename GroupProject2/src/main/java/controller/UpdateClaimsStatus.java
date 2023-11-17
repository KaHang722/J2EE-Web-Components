package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbHelpers.ClaimsQuery;
/**
 * Servlet implementation class UpdateClaimsStatus
 */
@WebServlet("/UpdateClaimsStatus")
public class UpdateClaimsStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClaimsStatus() {
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
		try {
            String claimIdStr = request.getParameter("claimId");
            int claimId = Integer.parseInt(claimIdStr);
            String updateStatus = request.getParameter("updateStatus");

            // Perform database update with new status for the specified claimId
            ClaimsQuery dq = new ClaimsQuery();
            dq.updateClaimsStatus(claimId, updateStatus);
            // Redirect back to the display page
            response.sendRedirect(request.getContextPath() + "/display_claims");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
