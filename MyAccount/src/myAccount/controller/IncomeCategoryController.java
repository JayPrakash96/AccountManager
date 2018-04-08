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

import myAccount.daos.Income_categoryDao;
import myAccount.pojos.Income_category;

/**
 * Servlet implementation class IncomeCategoryController
 */
@WebServlet("/IncomeCategoryController")
public class IncomeCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeCategoryController() {
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
		int inc_catid = 0;
		if (request.getParameter("inc_catid") != null && request.getParameter("inc_catid").trim().length() > 0)
			inc_catid = Integer.parseInt(request.getParameter("inc_catid"));
		String inc_catname = request.getParameter("categoryname");
		if (inc_catname == null) {
			inc_catname = new String();
		}
		String inc_catdetails = request.getParameter("categorydetails");
		if (inc_catdetails == null) {
			inc_catdetails = new String();
		}

		HttpSession session =request.getSession();
		int userid=(Integer)session.getAttribute("userid");
		if (request.getParameter("userid") != null && request.getParameter("userid").trim().length() > 0)
			userid = Integer.parseInt(request.getParameter("userid"));

		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}

		Income_categoryDao catDao = new Income_categoryDao();

		if (operation.equals("create")) {
			Income_category cat = new Income_category(inc_catid, inc_catname, inc_catdetails, userid);
			catDao.create(cat);
		} else if (operation.equals("edit")) {
			Income_category cat = new Income_category(inc_catid, inc_catname, inc_catdetails, userid);
			catDao.edit(cat);
		} else if (operation.equals("remove")) {
			catDao.remove(inc_catid);
		}

		ArrayList<Income_category> catList = catDao.findAll();
		System.out.println("Size:" + catList.size());
		request.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("IncomeCategoryView");
		rd.forward(request, response);
	}

	}


