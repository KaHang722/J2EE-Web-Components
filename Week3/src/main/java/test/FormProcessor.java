package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormProcessor
 */
@WebServlet("/FormProcessor")
public class FormProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormProcessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String comments = request.getParameter("comments");
		String meals[] = request.getParameterValues("meal");
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(docType + "<HTML>\n<HEAD><TITLE>Activity - Week3</TITLE></HEAD>\n<BODY>\n");

	    if (name == null || name.isEmpty()) {
	        out.println("<H1>Please enter valid name.</H1>\n");
	    } else {
	        out.println("<H1>Name: " + name + "</H1>\n");
	    }

	    if (email == null || email.isEmpty()) {
	        out.println("<H1>Please enter valid email.</H1>\n");
	    } else {
	        out.println("<H1>Email: " + email + "</H1>\n");
	    }

	    if (gender == null || gender.isEmpty()) {
	        out.println("<H1>Please select your gender.</H1>\n");
	    } else {
	        out.println("<H1>Gender: " + gender + "</H1>\n");
	    }

	    if (age == null || age.isEmpty()) {
	        out.println("<H1>Please select your age.</H1>\n");
	    } else {
	        out.println("<H1>Age: " + age + "</H1>\n");
	    }

	    if (comments == null || comments.isEmpty()) {
	        out.println("<H1>Please enter your comments.</H1>\n");
	    } else {
	        out.println("<H1>Comments: " + comments + "</H1>\n");
	    }

	    if (meals == null || meals.length == 0) {
	        out.println("<H1>Please select at least one meal.</H1>\n");
	    } else {
	        out.println("<H1>Meal:</H1>\n");
	        for (String meal : meals) {
	            out.println("<H3>" + meal + "</H3>\n");
	        }
	    }

	    out.println("</BODY>\n</HTML>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
