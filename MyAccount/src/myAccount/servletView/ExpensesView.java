package myAccount.servletView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import myAccount.pojos.*;
import myAccount.daos.Expenses_categoryDao;

/**
 * Servlet implementation class ExpensesController
 */
@WebServlet("/ExpensesView")
public class ExpensesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesView() {
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
		out.println("<script>");
		out.println(" document.getElementById(\"date\").valueAsDate = new Date();");
		out.println("</script>");
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
        //out.println("<h1 class=\"title\">My Expenses</h1>");
		
		
		//Starting point of content -->
		
				out.println("<form action =\"ExpensesController\" method = \"Post\">\r\n" + 
						"<table width = \"100%\"  border =\"0\" cellspacing =\"8\" cellpadding=\"8\">\r\n" + 
						"       <tr>\r\n" + 
						"            <th bgcolor =\"33C6F1\" colspan=\"4\"> <h2>Expense </h2> </th>\r\n" + 
						"        </tr>\r\n");
				
				out.println("<tr>\r\n" + 
						"        <td colspan=\"2\" > Expense : </td>\r\n" + 
						"        <th> <input type =\"text\" name=\"expenses\" id = \"expenses\" placeholder=\"expenses\" required> </th>\r\n" + 
						"        </tr>");
				
				
				HttpSession session = request.getSession();
				int userid = (Integer)session.getAttribute("userid");
				Expenses_categoryDao obj = new Expenses_categoryDao();
				ArrayList<Expenses_category> catlist = obj.findAll(userid);
				        out.println("<tr>");
						out.println(" <td colspan=\"2\" > Category : </td> "); 
						out.println(" <th> <Select name=\"category\" id=\"category\" ><br>");
						for(Expenses_category cat : catlist) {
						out.println("<option value=\" '" +cat.getExp_catid()+"'\"> "+cat.getExp_catname()+"<br></option>"); 
						}
						out.println("</Select> </th>\r\n" + 
						"        </tr>");
				
				
				out.println(" <tr>\r\n" + 
						"        <td colspan=\"2\" > Amount : </td>\r\n" + 
						"        <th> <input type =\"text\" name=\"amount\" id = \"amount\" placeholder=\"amount\" required> </th>\r\n" + 
						"        </tr>");
				
				//Payby selection list--
				out.println("<tr>\r\n" + 
						"        <td colspan=\"2\" > Pay By : </td>\r\n" + 
						"        <th> <Select name=\"payby\" id=\"payby\"required ><br>\r\n" + 
						"	         <option value=\"cash\"> Cash<br>\r\n" + 
						"	         <option value=\"bank\"> Bank <br>\r\n" + 
						"	</Select> </th>\r\n" + 
						"        </tr>");
				
				
				out.println("<tr>\r\n" + 
						"        <td colspan=\"2\" > Remark : </td>\r\n" + 
						"        <th> <input type =\"text\" name=\"remark\" id = \"remark\" placeholder=\"remark\"placeholder=\"remark\" required> </th>\r\n" + 
						"        </tr>");
				
				
				out.println("<tr>\r\n" + 
						"        <td colspan=\"2\" > Date : </td>\r\n" + 
						"        <th> <input type =\"date\" name=\"date\" id = \"date\" value=\"2018-03-22\"required > </th>\r\n" + 
						"        </tr>");
				
				
				out.println(" <tr>");
				
				out.println("<th colspan=\"1\"> <input type =\"submit\" name=\"submit\" id = \"submit\" value=\"submit\"> </th>");
				out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
				out.println("<input name=\"userid\" id=\"userid\"   type=\"hidden\">");	
				
				out.println("<th colspan=\"1\"> <input type =\"reset\" name=\"reset\" id = \"reset\" value=\"Cancel\"> </th>");
				
				out.println("</tr>");
				
				out.println("</table>\r\n" + 
						"</form>");
				
				//Ending of content-->
		
		
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
