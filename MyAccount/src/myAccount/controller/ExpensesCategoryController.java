package myAccount.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myAccount.daos.Expenses_categoryDao;
import myAccount.pojos.Expenses_category;

/**
 * Servlet implementation class Expenses_categoryController
 */
@WebServlet("/ExpensesCategoryController")
public class ExpensesCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExpensesCategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int exp_catid = 0;
		if (request.getParameter("exp_catid") != null && request.getParameter("exp_catid").trim().length() > 0)
			exp_catid = Integer.parseInt(request.getParameter("exp_catid"));
		String exp_catname = request.getParameter("categoryname");
		if (exp_catname == null) {
			exp_catname = new String();
		}
		String exp_catdetails = request.getParameter("categorydetails");
		if (exp_catdetails == null) {
			exp_catdetails = new String();
		}

		HttpSession session =request.getSession();
		int userid=(Integer)session.getAttribute("userid");
		if (request.getParameter("userid") != null && request.getParameter("userid").trim().length() > 0)
			userid = Integer.parseInt(request.getParameter("userid"));

		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}

		Expenses_categoryDao catDao = new Expenses_categoryDao();

		if (operation.equals("create")) {
			Expenses_category cat = new Expenses_category(exp_catid, exp_catname, exp_catdetails, userid);
			catDao.create(cat);
		} else if (operation.equals("edit")) {
			Expenses_category cat = new Expenses_category(exp_catid, exp_catname, exp_catdetails, userid);
			catDao.edit(cat);
		} else if (operation.equals("remove")) {
			catDao.remove(exp_catid);
		}

		ArrayList<Expenses_category> catList = catDao.findAll(userid);
		System.out.println("Size:" + catList.size());
		request.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("ExpensesCategoryView");
		rd.forward(request, response);
	}

}
