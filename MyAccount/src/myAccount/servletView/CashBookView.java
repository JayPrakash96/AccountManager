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
import javax.servlet.http.HttpSession;

import myAccount.daos.Cash_bookDao;
import myAccount.pojos.Cash_book;


/**
 * Servlet implementation class CashBookController
 */
@WebServlet("/CashBookView")
public class CashBookView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashBookView() {
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
		out.println("<h1 align=\"center\" class=\"title\">My Cash Book</h1>");
		out.println("<form action =\"CashBookController\" method = \"Post\">");
	    out.println("<table width = \"100%\" border =\"0\" bgcolor =\"33C6F1\">\r\n" + 
	    		"       <tr >\r\n" + 
	    		"            <th rowspan=\"2\" \" > <h3>Cash Book </h3> </th>\r\n" + 
	    		"            <th> <h3>Date From </h3></th>\r\n" + 
	    		"            <th><h3> to </h3></th>\r\n" + 
	    		"            <th rowspan=\"2\"> <input type =\"submit\" name=\"show\" id =\"show\" value=\"Show\"> </th> \r\n" + 
	    		"       </tr>\r\n" + 
	    		"       \r\n" + 
	    		"       <tr>\r\n" + 
	    		"            <th> <input type=\"date\" name=\"date1\"id=\"date1\"value='"+s1+"'> </th>\r\n" + 
	    		"            <th> <input type=\"date\" name=\"date2\"id=\"date2\"value='"+s+"'> </th>\r\n" + 
	    		"       </tr> <br> <br>");
	    out.println("<input name=\"userid\" id=\"userid\"   type=\"hidden\">");	
	    
	    out.println("</table>");
		out.println("</form>");
		
		
	    
	    out.println("<table width=\"100%\" border =\"1\">\r\n" + 
	    		"       <tr>\r\n" + 
	    		"            <th>S.No.</th>\r\n" + 
	    		"            <th>Date </th>\r\n" + 
	    		"            <th>Amount</th>\r\n" + 
	    		"            <th>Pay/Receive </th>\r\n" + 
	    		"        </tr>");
	    
	    
	   @SuppressWarnings("unchecked")
	ArrayList<Cash_book> catList = (ArrayList<Cash_book>) request.getAttribute("catList");
		int sno=1;
		for (Cash_book cat : catList) {
			out.println("<tr>");

			out.println("<td>" +sno+ " </td>");
			out.println("<td>" +cat.getTran_date()+ " </td>");
			out.println("<td>" +cat.getAmount()+ " </td>");
			out.println("<td>" +cat.getOperation()+ " </td>");
			out.println("</tr>");
			sno++;
		}
		
		
		HttpSession session = request.getSession();
		int userid =(Integer)session.getAttribute("userid");
		 double balance = Cash_bookDao.closingBalance(userid);
		out.println(" <tr>");
		out.println("<th colspan=\"2\" > <h2> Closing Balance </h2> </th>");
		
		out.println("<td colspan=\"2\" ><h2> "+balance+"  </h2> </td> ");
		
		out.println("</tr>");
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
