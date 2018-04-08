package myAccount.servlet.design;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sidebar
 */
@WebServlet("/Sidebar")
public class Sidebar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sidebar() {
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
		out.println("<div id=\"sidebar\">");
		out.println("<div id=\"news\" class=\"boxed\">");
		out.println("<h2 class=\"title\">Masters</h2>");
		out.println("<div class=\"content\">");
		out.println("<ul>");
		out.println("<li class=\"first\">");
		out.println("<p><a href=\"ExpensesCategoryController\">Expenses Category</a></p>");
		out.println("</li>");
		out.println("<li>");
		out.println("<p><a href=\"IncomeCategoryController\">Income Category</a></p>");
		out.println("</li>");
		out.println("<li>");
		out.println("<p><a href=\"ExpensesView\">Expenses</a></p>");
		out.println("</li>");
		out.println("<li>");
		out.println("<p><a href=\"IncomeView\">Income </a></p>");
		out.println("</li>");
		out.println("<li>");
		out.println("<p><a href=\"CashBookController\">Cash Book</a></p>");
		out.println("</li>");
		out.println("<li>");
		out.println("<p><a href=\"DayBookController\">Day Book</a></p>");
		out.println("</li>");
		out.println("<li>");
		out.println("<p><a href=\"BankBookController\">Bank Book</a></p>");
		out.println("</li>");
		out.println("<li>");
		out.println("<p><a href=\"BalanceSheetController\">Balance Sheet</a></p>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("</div>");
		
		
	}

}
