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

import myAccount.pojos.Expenses;
import myAccount.pojos.Incomes;

/**
 * Servlet implementation class BalanceSheetController
 */
@WebServlet("/BalanceSheetView")
public class BalanceSheetView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceSheetView() {
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
		
		

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dt = new java.util.Date();
		String s = df.format(dt);
		
		Date date = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
		String s1 = df.format(date);
		
		
				out.println("<form action =\"BalanceSheetController\" method = \"Post\">\r\n" + 
						"<table width = \"100%\" border =\"0\" bgcolor =\"33C6F1\"cellspacing =\"8\" cellpadding=\"8\">\r\n" + 
						"       <tr>\r\n" + 
						"            <th colspan=\"3\" > <h1> Balance Sheet </h1></th>\r\n" + 
						"        </tr>\r\n" + 
						"        <tr>    \r\n" + 
						"            <th > Date From </th>\r\n" + 
						"            <th> to </th>\r\n" + 
						"            <th rowspan=\"2\"> <input type =\"submit\" name=\"show\" id =\"show\" value=\"Show\"> </th> \r\n" + 
						"       </tr>\r\n" + 
						"       \r\n" + 
						"       <tr>\r\n" + 
						"            <th> <input type=\"date\" name=\"date1\"id=\"date1\"value='"+s1+"'> </th>\r\n" + 
						"            <th> <input type=\"date\" name=\"date2\"id=\"date2\"value='"+s+"'> </th>\r\n" + 
						"       </tr><br><br>  ");
				
				 out.println("<input name=\"userid\" id=\"userid\"   type=\"hidden\">");	
				    
				    out.println("</table>");
					out.println("</form>");
				
				out.println("<table width=\"100%\" border =\"0\" cellspacing=\"5\">\r\n" + 
						"       <tr>\r\n" + 
						"           <th>\r\n" + 
						"               \r\n" + 
						"             <table width =\"100%\" border = \"1\" >\r\n" + 
						"                 <tr>\r\n" + 
						"                    <th  bgcolor =\"33C6F1\"colspan = \"3\"> <h2> Incomes </h2> </th>\r\n" + 
						"                 </tr>\r\n" + 
						"                 <tr>\r\n" + 
						"                    <th colspan =\"2\" > <h3>Incomes </h1></th>\r\n" + 
						"                    <th> <h3>Amount</h3> </th>\r\n" + 
						"                      \r\n" + 
						"                 </tr>");
				
				

				@SuppressWarnings("unchecked")
				ArrayList<Incomes> catList2 = (ArrayList<Incomes>)request.getAttribute("catList1");
				double total = 0;
				for (Incomes cat : catList2) {
			    
					 out.println("<tr>");
					 
					 out.println("<td colspan=\"2\"> " +cat.getInc_ac() +" </td> ");
					 out.println("<td> " +cat.getAmount() +" </td> ");
					
					 out.println("</tr>");
				   total +=cat.getAmount();     
				
				}
				
				
				out.println("<tr>");
				out.println("<th colspan =\"2\"><h2>  Total </h2> </th>");
				//Dynamic data Alert!
				out.println("<th> <h2> "+total+" </h2> </th>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</th>");
				
				
				out.println("<th>\r\n" + 
						"              <table width =\"100%\" border = \"1\" >\r\n" + 
						"                 <tr>\r\n" + 
						"                    <th colspan=\"3\" bgcolor =\"33C6F1\"> <h2> Expenses </h2> </th>\r\n" + 
						"                 </tr>\r\n" + 
						"                 <tr>\r\n" + 
						"                    <th colspan =\"2\"><h3> Expenses </h3> </th>\r\n" + 
						"                    <th> <h3>Amount </h3></th>\r\n" + 
						"                      \r\n" + 
						"                 </tr>");
				
	@SuppressWarnings("unchecked")
	ArrayList<Expenses> catList = (ArrayList<Expenses>)request.getAttribute("catList");
				double total1=0;
				for (Expenses cat : catList) {
			    
					 out.println("<tr>");
					 
					 out.println("<td colspan=\"2\"> " +cat.getExp_ac() +" </td> ");
					 out.println("<td> " +cat.getAmount() +" </td> ");
					 out.println("</tr>");
					 total1+=cat.getAmount();
				     
				
				}
						
						
						out.println("<tr>");
						out.println("<th colspan =\"2\"> <h2> Total </h2> </th>");
						
						out.println("<th> <h2> "+total1+" </h2></th>");
						out.println("</tr>");
						
						out.println("<tr>");
						out.println("<th><h2> Gross Profit : </h2>");
						out.println("<th colspan=\"2\"><h2> "+(total-total1)+" </h2> </th>");
						out.println("</tr>");
						
						out.println("</table>");
						out.println("</th>");
				
						
						
						
						out.println("</table>"); 
								
				
				
				//End of content
		
		
		
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
