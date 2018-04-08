package myAccount.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import myAccount.daos.IncomesDao;

import myAccount.pojos.Incomes;
import myAccount.daos.Cash_bookDao;
import myAccount.daos.Bank_bookDao;
import myAccount.pojos.*;
/**
 * Servlet implementation class IncomeController
 */
@WebServlet("/IncomeController")
public class IncomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeController() {
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
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		
		
		int inc_catid=0;
		if (request.getParameter("inc_catid") != null && request.getParameter("inc_catid").trim().length() > 0)
			inc_catid = Integer.parseInt(request.getParameter("category"));
		
		String inc_ac = request.getParameter("income");
		if (inc_ac == null) {
			inc_ac = new String();
		}
		
		double amount=0;
		if (request.getParameter("amount") != null && request.getParameter("amount").trim().length() > 0)
			amount = Double.parseDouble(request.getParameter("amount"));
		
		String receiveby = request.getParameter("receiveby");
		if (receiveby == null) {
			receiveby = new String();
		}
		
		String remark = request.getParameter("remark");
		if (remark == null) {
			remark = new String();
		}
		
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		
		String date = request.getParameter("date");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dt = null;
		try {
			dt = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (date == null) {
			date= new String();
		}

		      
				
				if (operation.equals("create")) { IncomesDao exp = new IncomesDao();
					Incomes cat = new Incomes(inc_ac,userid,inc_catid,amount,dt,receiveby,remark);
					exp.create(cat);
					
				}
				if(receiveby.equals("cash"))
				{
	
						Cash_bookDao exp1 = new Cash_bookDao();
						Cash_book cat1 = new Cash_book(inc_ac, dt, amount, userid,"receive");
						exp1.create(cat1);
				}
					if(receiveby.equals("bank")) {
		
						   Bank_bookDao exp2 = new Bank_bookDao();
						   Bank_book cat2 = new Bank_book(inc_ac, dt, amount, userid,"receive");
							exp2.create(cat2);
					}
				
				
				RequestDispatcher rd = request.getRequestDispatcher("IncomeView");
				rd.forward(request, response);
				}
	
				}

