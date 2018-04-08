package myAccount.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myAccount.daos.UsersDao;
import myAccount.pojos.*;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
//		ArrayList<Users> user  = UsersDao.findAll();
//		request.setAttribute("list", user);
//		@SuppressWarnings("unchecked")
//		ArrayList<Users> catList = (ArrayList<Users>) request.getAttribute("list");
//		for (Users cat : catList) {
//			String name1 = cat.getUsername();
//		}
		
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile_number");
		String email = request.getParameter("email");
		if (name != null  && password != null && firstname != null && address != null && mobile != null && email != null) {
			 
			Users c = new Users(name, password, firstname,address,mobile,email);
			UsersDao cd = new UsersDao();
			cd.create(c);
		}
		response.sendRedirect("LoginForm");
	}
	
}


