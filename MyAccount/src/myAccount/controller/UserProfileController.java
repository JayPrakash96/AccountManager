package myAccount.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myAccount.daos.*;
import myAccount.pojos.*;

/**
 * Servlet implementation class UserProfileController
 */
@WebServlet("/UserProfileController")
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileController() {
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
		HttpSession req = request.getSession();
		Integer userid = (Integer) req.getAttribute("userid");
		
		String username = request.getParameter("username");
		if (username == null) {
			username = new String();
		}
		String password = request.getParameter("password");
		if (password == null) {
			password = new String();
		}
		String name = request.getParameter("name");
		if (name == null) {
		  name = new String();
		}
		String address = request.getParameter("address");
		if (address == null) {
			address = new String();
		}
		String mobile = request.getParameter("mobile");
		if (mobile == null) {
			mobile = new String();
		}
		String email = request.getParameter("email");
		if (email == null) {
			email = new String();
		}
		
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}
		Users cat = new Users(userid, username, password,name,address,mobile,email);
		UsersDao catDao = new UsersDao();
		catDao.edit(cat);
		//response.sendRedirect("UserProfile");
		RequestDispatcher rd = request.getRequestDispatcher("UserProfile");
    	rd.forward(request, response);
		
//
//		if (operation.equals("create")) {
//			Users cat = new Users(uid, username, password,name,address,mobile,email);
//			catDao.create(cat);
//		} else if (operation.equals("edit")) {
//			Users cat = new Users(uid, username, password,name,address,mobile,email);
//			catDao.edit(cat);
//		} else if (operation.equals("remove")) {
//			catDao.remove(uid);
//		} 

		
	}
	}


