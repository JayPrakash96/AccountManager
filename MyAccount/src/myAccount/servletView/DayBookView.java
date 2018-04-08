package myAccount.servletView;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myAccount.pojos.*;
/**
 * Servlet implementation class DayBookController
 */
@WebServlet("/DayBookView")
public class DayBookView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DayBookView() {
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
		
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dt = new java.util.Date();
		String s = df.format(dt);
		
		Date date = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
		String s1 = df.format(date);
		
		out.println("<div id=\"page\">");
		out.println("<div id=\"content\">");
		out.println("<div>");
		out.println("<h1 align=\"center\" class=\"title\">My Day Book</h1>");
		out.println("<form action =\"DayBookController\" method = \"Post\">");
		    out.println("<table width = \"100%\" border =\"0\" bgcolor =\"33C6F1\">\r\n" + 
		    		"       <tr>\r\n" + 
		    		"            <th rowspan=\"2\" \"> <h2>Day Book </h2> </th>\r\n" + 
		    		"            <th> <h2> Date From </h2> </th>\r\n" + 
		    		"            <th> <h2>to </h2> </th>\r\n" + 
		    		"            <th rowspan=\"2\"> <input type =\"submit\" name=\"show\" id =\"show\" value=\"Show\"> </th> \r\n" + 
		    		"       </tr>\r\n" + 
		    		"       \r\n" + 
		    		"       <tr>\r\n" + 
		    		"            <th> <input type=\"date\" name=\"date1\"id=\"date1\"value='"+s1+"' required> </th>\r\n" + 
		    		"            <th> <input type=\"date\" name=\"date2\"id=\"date2\"value='"+s+"' required> </th>\r\n" + 
		    		"       </tr> <br> <br>");
		    
		    
		    out.println("<input name=\"userid\" id=\"userid\"   type=\"hidden\">");	
		    
		    out.println("</table>");
			out.println("</form>");
			
			
			
		    out.println("<table width=\"100%\" border =\"1\">\r\n" + 
		    		"       <tr>\r\n" + 
		    		"            <th> <h3> S.No. </h3></th>\r\n" + 
		    		"            <th> <h3>Account Name </h3> </th>\r\n" + 
		    	           
		    		"            <th> <h3>Date </h3></th>\r\n" +
		    		"            <th> <h3>Amount </h3></th>\r\n" +
		    		"            <th> <h3>Pay/Receive </h3></th>\r\n" + 
		    		"            <th><h3>Remark</h3> </th>\r\n" + 
		    		"           </tr>");
		    
		    
		out.println(" <tr>\r\n" + 
				"        \r\n" + 
				"            <td bgcolor =\"33C6F1\" colspan = \"6\"><h2 > Expenses <h2> </td>\r\n" + 
				"        </tr>");  
		
		@SuppressWarnings("unchecked")
		ArrayList<Expenses> catList = (ArrayList<Expenses>)request.getAttribute("catList");
		int sno=1;
		for (Expenses cat : catList) {
	    
			 out.println("<tr>");
			 out.println("<td> " +sno +" </td> ");
			 out.println("<td> " +cat.getExp_ac() +" </td> ");
			 out.println("<td> " +cat.getTran_date() +" </td> ");
			 out.println("<td> " +cat.getAmount() +" </td> ");
			 out.println("<td> " +cat.getPayby() +" </td> ");
			 out.println("<td bgcolor =\"33C6F1\"> " +cat.getRemark() +" </td> ");
			 out.println("</tr>");
		     sno++;
		
		}
		
		out.println(" <tr>\r\n" + 
				"        \r\n" + 
				"            <td  bgcolor =\"33C6F1\"colspan = \"6\" > <h2 >Incomes <h2> </td>\r\n" + 
				"        </tr>");
		
		@SuppressWarnings("unchecked")
		ArrayList<Incomes> catList2 = (ArrayList<Incomes>)request.getAttribute("catList1");
		int sno1=1;
		for (Incomes cat : catList2) {
	    
			 out.println("<tr>");
			 out.println("<td> " +sno1 +" </td> ");
			 out.println("<td> " +cat.getInc_ac() +" </td> ");
			 out.println("<td> " +cat.getTran_date() +" </td> ");
			 out.println("<td> " +cat.getAmount() +" </td> ");
			 out.println("<td> " +cat.getReceiveby() +" </td> ");
			 out.println("<td bgcolor =\"33C6F1\"> " +cat.getRemark() +" </td> ");
			 out.println("</tr>");
		     sno1++;
		
		}
		
		    
		 
		out.println("</table>"); 
				
		
		//End of dynamic content		    
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
