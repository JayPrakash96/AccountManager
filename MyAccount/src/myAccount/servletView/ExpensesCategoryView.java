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

import myAccount.pojos.Expenses_category;

/**
 * Servlet implementation class ExpenseCategoryController
 */
@WebServlet("/ExpensesCategoryView")
public class ExpensesCategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesCategoryView() {
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
		
		out.println("function del(exp_catid) {");
		out.println("document.getElementById(\"exp_catid\").value = exp_catid;");
		out.println("document.getElementById(\"operation\").value = 'remove';");
		out.println("document.ExpensesCategory.submit();");
		out.println("}");
		out.println("function mod(exp_catid,exp_catname,exp_catdetails,userid) {");
		out.println("document.getElementById(\"exp_catid\").value = exp_catid;");
		out.println("document.getElementById(\"categoryname\").value = exp_catname;");
		out.println("document.getElementById(\"categorydetails\").value = exp_catdetails;");
		out.println("document.getElementById(\"userid\").value = userid;");
		out.println("document.getElementById(\"add\").value = 'Save!';");
		out.println("document.getElementById(\"operation\").value = 'edit';");
		out.println("}");
		
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
		
		
		//out.println("<h1 class=\"title\">My Expense Category</h1>");
		
		
		out.println("<form action =\"ExpensesCategoryController\" id =\"ExpensesCategory\" name=\"ExpensesCategory\" method = \"Post\">\r\n" + 
				"<table  width = \"100%\" border =\"0\" cellspacing =\"8\" cellpadding=\"8\">");
		
		out.println("<tr>\r\n" + 
				"            <th bgcolor =\"33C6F1\" colspan=\"4\"> <h2>Expense Category </h2> </th>\r\n" + 
				"        </tr>");
		
		out.println("<tr>\r\n" + 
				"        <td colspan=\"1\" > Category Name:* </td>\r\n" + 
				"        <th colspan=\"3\"> <input type =\"text\" name=\"categoryname\" id = \"categoryname\" placeholder=\"categoryname\" required> </th>\r\n" + 
				"        </tr>");
		
		out.println("<tr>\r\n" + 
				"        <td colspan=\"1\" > Category Details:* </td>\r\n" + 
				"        <th colspan=\"3\"> <textarea  rows =\"5\" cols =\"35\" requires =\"\" tabindex=\"2\"  name=\"categorydetails\" id = \"categorydetails\" placeholder=\"Category Details\"required></textarea> </th> \r\n" + 
				"        </tr>");
		
		out.println("<tr>"); 
	 out.println("<th colspan=\"1\"> <input type =\"submit\" name=\"add\" id = \"add\" value=\"add\"> </th>"); 
				out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
		out.println("<input name=\"exp_catid\" id=\"exp_catid\"   type=\"hidden\">");
		out.println("<input name=\"userid\" id=\"userid\"   type=\"hidden\">");	
		out.println("<th colspan=\"1\"> <input type =\"reset\" name=\"reset\" id = \"reset\" value=\"Cancel\"> </th>");
				out.println(" </tr>"); 
				
		
		
		
		
		
		
		
		
		
		out.println("</form>");
		out.println("</table>");
		
		//Content for dynamic page goes from here-->
		
		
        out.println("<table width=\"100%\" border =\"1\">");
		
		out.println(" <tr>\r\n" + 
				"        <th> Category Name </th>\r\n" + 
				"      \r\n" + 
				"        <th> Category Details </th>\r\n" + 
				"        \r\n" + 
				"        <th> Edit </th>\r\n" + 
				"        \r\n" + 
				"        <th> Delete </th>\r\n" + 
				"       \r\n" + 
				"        </tr>");
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Expenses_category> catList = (ArrayList<Expenses_category>) request.getAttribute("catList");
		for (Expenses_category cat : catList) {
			out.println("<tr>");
			out.println("<th>" + cat.getExp_catname() + "</th>");
			out.println("<th>" + cat.getExp_catdetails() + "</th>");
			out.println(
					"<td ><input  class=\"buttom\"  name=\"edit\" id=\"edit\" value=\"Edit!\" type=\"button\" "
					+ "onclick=\"mod('"+cat.getExp_catid()+"','"+cat.getExp_catname()+"','"+cat.getExp_catdetails()+"','"+cat.getUserid()+"');\"></td>");
			out.println(
					"<td ><input class=\"buttom\" name=\"delete\" id=\"delete\" value=\"Delete!\" type=\"button\" onclick=\"del('"+cat.getExp_catid()+"');\" ></td>");
			out.println("</tr>");
		}
		

		out.println("</table>");
		
		
		
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
