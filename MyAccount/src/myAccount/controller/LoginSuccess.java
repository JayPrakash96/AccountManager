package myAccount.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSuccess
 */
@WebServlet("/LoginSuccess")
public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSuccess() {
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
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
		out.println("<title>Landscape by TEMPLATED</title>");
		out.println("<meta name=\"keywords\" content=\"\" />");
		out.println("<meta name=\"description\" content=\"\" />");
		out.println("<link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.println("</head>");
		out.println("<body>");
		
		
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("Header");
		rd.include(request, response);
		
		
		
		
		out.println("<div id=\"page\">");
		out.println("<div id=\"content\">");
		out.println("<div>");
		out.println("<h1 class=\"title\">Welcome to Our Website!</h1>");
		out.println(" <pre>");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		out.println(" ");
		
		out.println("</pre> ");
		
		out.println("</div>");
		out.println("<div class=\"twocols\">");
		out.println("</div>");
		out.println("</div>");
		
		
		
		
		
		
		rd=request.getRequestDispatcher("Sidebar");
		rd.include(request, response);
		

		rd=request.getRequestDispatcher("Footer");
		rd.include(request, response);
		
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	
		
	}
	}
