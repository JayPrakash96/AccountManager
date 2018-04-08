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

import myAccount.pojos.Income_category;

/**
 * Servlet implementation class IncomeCategoryController
 */
@WebServlet("/IncomeCategoryView")
public class IncomeCategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeCategoryView() {
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
		
		out.println("function del(inc_catid) {");
		out.println("document.getElementById(\"inc_catid\").value = inc_catid;");
		out.println("document.getElementById(\"operation\").value = 'remove';");
		out.println("document.IncomeCategory.submit();");
		out.println("}");
		out.println("function mod(inc_catid,inc_catname,inc_catdetails,userid) {");
		out.println("document.getElementById(\"inc_catid\").value = inc_catid;");
		out.println("document.getElementById(\"categoryname\").value = inc_catname;");
		out.println("document.getElementById(\"categorydetails\").value = inc_catdetails;");
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
		//out.println("<h1 class=\"title\">My Income Category</h1>");
		
		
		out.println("<form action =\"IncomeCategoryController\" id =\"IncomeCategory\" name=\"IncomeCategory\" method = \"Post\">\r\n" + 
				"<table  width = \"100%\" border =\"0\" cellspacing =\"8\" cellpadding=\"8\">");
		
		out.println("<tr>\r\n" + 
				"            <th bgcolor =\"33C6F1\" colspan=\"4\"> <h2>Income Category </h2> </th>\r\n" + 
				"        </tr>");
		
		out.println("<tr>\r\n" + 
				"        <td colspan=\"1\" > Category Name:* </td>\r\n" + 
				"        <th colspan=\"3\"> <input type =\"text\" name=\"categoryname\" id = \"categoryname\" placeholder=\"categoryname\"required> </th>\r\n" + 
				"        </tr>");
		
		out.println("<tr>\r\n" + 
				"        <td colspan=\"1\" > Category Details:* </td>\r\n" + 
				"        <th colspan=\"3\"> <textarea  rows =\"5\" cols =\"35\" required  tabindex=\"2\"  name=\"categorydetails\" id = \"categorydetails\" placeholder=\"Category Details\"></textarea> </th> \r\n" + 
				"        </tr>");
		
		out.println("<tr>"); 
	 out.println("<th colspan=\"1\"> <input type =\"submit\" name=\"add\" id = \"add\" value=\"add\"> </th>"); 
				out.println("<input name=\"operation\" id=\"operation\"  value=\"create\" type=\"hidden\">");
		out.println("<input name=\"inc_catid\" id=\"inc_catid\"   type=\"hidden\">");
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
		ArrayList<Income_category> catList = (ArrayList<Income_category>) request.getAttribute("catList");
		for (Income_category cat : catList) {
			out.println("<tr>");
			out.println("<th>" + cat.getInc_catname() + "</th>");
			out.println("<th>" + cat.getInc_catdetails() + "</th>");
			out.println(
					"<td ><input  class=\"buttom\"  name=\"edit\" id=\"edit\" value=\"Edit!\" type=\"button\" "
					+ "onclick=\"mod('"+cat.getInc_catid()+"','"+cat.getInc_catname()+"','"+cat.getInc_catdetails()+"','"+cat.getUserid()+"');\"></td>");
			out.println(
					"<td ><input class=\"buttom\" name=\"delete\" id=\"delete\" value=\"Delete!\" type=\"button\" onclick=\"del('"+cat.getInc_catid()+"');\" ></td>");
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
