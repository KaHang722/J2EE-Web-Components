package test;

import java.io.*;
import java.net.InetAddress;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class WarmupActivity
 */
@WebServlet("/WarmupActivity")
public class WarmupActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarmupActivity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

		InetAddress addr = InetAddress.getLocalHost();

		// Getting IPAddress of localhost - getHostAddress return IP Address
		// in textual format
		String ipAddress = addr.getHostAddress();
		System.out.println("IP address of my computer: " + ipAddress);

		// Hostname
		String hostname = addr.getHostName();
		System.out.println("Name of my computer: " + hostname);

		out.println(docType + "<HTML>\n" + "<HEAD><TITLE>WarmUp Activity</TITLE></HEAD>\n" + "<BODY>\n"
		 + "<H1>IP address of my computer: " + ipAddress + "</H1>\n" + "<H1>Name of my computer: " + hostname
		 + "</H1>\n" + "</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
