package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserProcess
 */
@WebServlet("/UserProcess")
public class UserProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProcess() {
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String zip = request.getParameter("zip");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpw = request.getParameter("confirmpw");
		String musics[] = request.getParameterValues("music");
		String notifications = request.getParameter("notifications");
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
		String cssTag="<link rel='stylesheet' type='text/css' href='./userprocess.css'>";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(docType + "<HTML>\n<HEAD><TITLE>Activity - Week3</TITLE>"+ cssTag +"</HEAD>\n<BODY>\n");
		
		if (fname == null || fname.isEmpty() ||
		    lname == null || lname.isEmpty() ||
		    email == null || email.isEmpty() ||
		    zip == null || zip.isEmpty() ||
		    username == null || username.isEmpty() ||
		    password == null || password.isEmpty() ||
		    confirmpw == null || confirmpw.isEmpty() ||
		    musics == null || musics.length == 0 ||
		    notifications == null || notifications.isEmpty()) {
		    out.println("<H1>Please fill in all fields.</H1>\n");
		}else {
			out.println("<H1>Thank you for joining our mailing list</H1>\n"+
						"<p>Here is the information that you entered:</p>\n"+
						"<table>"+
						  "<tr>"+
						    "<td id=\"fname\">First name:</td>"+
						    "<td>" + fname + "</td>" +
						  "</tr>"+
						  "<tr>"+
						    "<td id=\"lname\">Last name:</td>"+
						    "<td>" + lname + "</td>" +
						  "</tr>"+
						  "<tr>"+
						    "<td id=\"email\">Email:</td>"+
						    "<td>" + email + "</td>" +
						  "</tr>"+
						  "<tr>"+
						    "<td id=\"zip\">Zip code:</td>"+
						    "<td>" + zip + "</td>" +
						  "</tr>"+
						  "<tr>"+
						    "<td id=\"username\">Username name:</td>"+
						    "<td>" + username + "</td>" +
						  "</tr>"+
						  "<tr>"+
						    "<td id=\"pw\">Password:</td>"+
						    "<td>" + password + "</td>" +
						  "</tr>"+
						  "<tr>"+
						    "<td id=\"music\">Favourite music:</td>"+
						  "<td>");
			for (String music : musics) {
				out.println(music);}
			out.println("</td>"+
						"</tr>"+
						"<tr>"+
						  "<td id=\"notifications\">Receive special sale</br> notification:</td>"+
						  "<td>"+notifications+ "</td>"+
						"</tr>"+
						"</table>");
            out.println("</BODY>\n</HTML>");
		}
	}
}


