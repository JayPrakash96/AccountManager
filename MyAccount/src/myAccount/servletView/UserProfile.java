	package myAccount.servletView;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myAccount.daos.UsersDao;
import myAccount.pojos.*;
/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
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
		
		out.println("<script>");
		out.println("{");
		out.println("function mod(userid,username,password, name, address,mobile,email) {");
		out.println("document.getElementById(\"userid\").value = userid;");
		out.println("document.getElementById(\"username\").value = username;");
		out.println("document.getElementById(\"password\").value = password;");
		out.println("document.getElementById(\"name\").value = name;");
		out.println("document.getElementById(\"address\").value = address;");
		out.println("document.getElementById(\"mobile\").value = mobile;");
		out.println("document.getElementById(\"email\").value = email;");

		out.println("document.getElementById(\"update\").value = 'Save!';");
		out.println("document.getElementById(\"operation\").value = 'create';");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		
		
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("Header");
		rd.include(request, response);
		
		
		
		
		out.println("<div id=\"page\">");
		out.println("<div id=\"content\">");
		out.println("<div>");
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		String password=session.getAttribute("password").toString();
		System.out.println("Username :"+username+"/password :"+password);
		Users catList=UsersDao.authenticate(username,password);
		
             String name = catList.getName();
	        String username1 = catList.getUsername();
	        String password1 = catList.getPassword();
	        String address = catList.getAddress();
	        String mobile = catList.getMobile();
	        String email = catList.getEmail();
	        System.out.println(catList);
		
		out.println("<form action =\"UserProfileController\" method = \"Post\">\r\n" + 
				"<table width = \"100%\" border =\"0\" cellspacing =\"8\" cellpadding=\"8\">\r\n" + 
				"       <tr>\r\n" + 
				"            <th bgcolor=\"white\" colspan=\"4\"><h1> User Profile <h1> </th>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"        <td colspan=\"2\" > <h2>User Name :* </h2></td>\r\n" + 
				"        <th> <input type =\"text\" name=\"username\" id = \"username\" value='"+username1+"'required> </th>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"        <td colspan=\"2\" ><h2> Password :*</h2> </td>\r\n" + 
				"        <th> <input type =\"text\" name=\"password\" id = \"password\" value='"+password1+"'required> </th>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"        <td colspan=\"2\" ><h2> Name :*</h2> </td>\r\n" + 
				"        <th> <input type =\"text\" name=\"name\" id = \"name\" placeholder=\"Name\" value ='"+name+"'required> </th>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"        <td colspan=\"2\" > <h2>Address :* </h2></td>\r\n" + 
				"        <th> <input type =\"text\" name=\"address\" id = \"address\" placeholder=\"address\" value='"+address+"'required> </th>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"        <td colspan=\"2\" > <h2>Mobile No. :*</h2> </td>\r\n" + 
				"        <th> <input type =\"text\" name=\"mobile\" id = \"mobile\" placeholder=\"Mobile Number\" value='"+mobile+"'required> </th>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 			"        <td colspan=\"2\" ><h2> Email :*</h2></td>\r\n" + 
				"        <th> <input type =\"email\" name=\"email\" id = \"email\" placeholder=\"abc@mail.com\" value='"+email+"'required> </th>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>");

		out.println(" <th><input type =\"submit\" name=\"update\" id = \"update\" value=\"Update\"></th>");
		out.println(" <th><input type =\"reset\" name=\"cancel\" id = \"cancel\" value=\"Cancel\"></th>");
		out.println("</tr>");
		out.println("</form>");
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
	
