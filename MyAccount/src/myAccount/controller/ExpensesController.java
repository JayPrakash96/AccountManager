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

import myAccount.daos.Bank_bookDao;
import myAccount.daos.Cash_bookDao;
import myAccount.daos.ExpensesDao;
import myAccount.pojos.Bank_book;
import myAccount.pojos.Cash_book;
import myAccount.pojos.Expenses;


/**
 * Servlet implementation class ExpenseController
 */
@WebServlet("/ExpensesController")
public class ExpensesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesController() {
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
		
		
		int exp_catid=0;
		if (request.getParameter("exp_catid") != null && request.getParameter("exp_catid").trim().length() > 0)
			exp_catid = Integer.parseInt(request.getParameter("category"));
		
		String exp_ac = request.getParameter("expenses");
		if (exp_ac == null) {
			exp_ac = new String();
		}
		
		double amount=0;
		if (request.getParameter("amount") != null && request.getParameter("amount").trim().length() > 0)
			amount = Double.parseDouble(request.getParameter("amount"));
		
		String payby = request.getParameter("payby");
		if (payby == null) {
			payby = new String();
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

		ExpensesDao exp = new ExpensesDao();
				
				if (operation.equals("create")) {
					Expenses cat = new Expenses(exp_ac,userid,exp_catid,amount,dt,payby,remark);
					exp.create(cat);
				}
				if(payby.equals("cash")){
					
		
							Cash_bookDao exp1 = new Cash_bookDao();
							Cash_book cat1 = new Cash_book(exp_ac, dt, amount, userid,"pay");
							exp1.create(cat1);
					}
						if(payby.equals("bank")) {
			
							   Bank_bookDao exp2 = new Bank_bookDao();
							   Bank_book cat2 = new Bank_book(exp_ac, dt, amount, userid,"pay");
								exp2.create(cat2);
						}
				
				RequestDispatcher rd = request.getRequestDispatcher("ExpensesView");
				rd.forward(request, response);
	}

}
