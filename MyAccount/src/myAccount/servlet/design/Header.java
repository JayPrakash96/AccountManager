package myAccount.servlet.design;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Header
 */
@WebServlet("/Header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<div id=\"header\">");
		out.println("<div id=\"logo\">");
		out.println("<h1><a href=\"EmptyServlet\"> My Account </a></h1>");
		out.println("</div>");
		out.println("<div id=\"menu\">");
		out.println("<ul>"); 
		out.println("<li class=\"active\"><a href=\"EmptyServlet\">Home</a></li>");
		out.println("<li><a href=\"UserProfile\">Profile</a></li>");
		out.println("<li><a href=\"#\">Support</a></li>");
		out.println("<li><a href=\"#\">About</a></li>");
		out.println("<li><a href=\"LogoutServlet\">Logout</a></li>");
//		out.println("<li class=\"active\">");
//		out.println("<form action=\"LogoutServlet\" method=\"post\">"); 
//		out.println("<input type=\"submit\" value=\"Logout\" >");
//		out.println("</form>");
//		out.println("</li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("</div>");
	}

}
