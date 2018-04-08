package myAccount.controller;

import java.io.IOException;
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
@WebServlet("/CashBookController")
public class CashBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashBookController() {
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
		
		HttpSession session= request.getSession();
		int userid =(Integer)session.getAttribute("userid");
		
		
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		
		String date1 = request.getParameter("date1");
		if(date1 == null) {
			Date date = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
		    date1 = df.format(date);}
		
		String date2 = request.getParameter("date2");
		if(date2 == null) {
			java.util.Date dt = new java.util.Date();
		    date2 = df.format(dt);}
		
		Cash_bookDao cash =	new Cash_bookDao();
		
		
		ArrayList<Cash_book> list = cash.findAllDateWise(date1, date2, userid);
		request.setAttribute("catList", list);
		RequestDispatcher rd = request.getRequestDispatcher("CashBookView");
		rd.forward(request, response);
		
	}

}
