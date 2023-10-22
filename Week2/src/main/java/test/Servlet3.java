package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private long modTime;
	private int[] numbers = new int[10];
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Round to nearest second (i.e, 1000 milliseconds)
				modTime = System.currentTimeMillis() / 1000 * 1000;

				for (int i = 0; i < numbers.length; i++) {
					numbers[i] = randomNum();
				}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String title = "Your Lottery Numbers";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

		out.println(
				docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
						+ "<H1 ALIGN=CENTER>" + title + "</H1>\n" + "<B>Based upon extensive research of "
						+ "astro-illogical trends, psychic farces, " + "and detailed statistical claptrap, "
						+ "we have chosen the " + numbers.length + " best lottery numbers for you.</B>" + "<OL>");

		for (int i = 0; i < numbers.length; i++) {
			out.println(" <LI>" + numbers[i]+"</LI>");
		}

		out.println("</OL>" + "</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public long getLastModified(HttpServletRequest request) {
		return (modTime);
	}

	// A random int from 0 to 99.
	private int randomNum() {
		return ((int) (Math.random() * 100));
	}

}
