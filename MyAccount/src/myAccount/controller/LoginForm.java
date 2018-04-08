package myAccount.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginForm
 */
@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForm() {
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
		PrintWriter out = response.getWriter();
		out.println("\r\n" + 
				"<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"	<!-- Meta tags -->\r\n" + 
				"	<title>General Registration  Form </title>\r\n" + 
				"	<meta name=\"keywords\" content=\"Login Form  \r\n" + 
				"	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\r\n" + 
				"	<meta charset=\"utf-8\">\r\n" + 
				"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"	\r\n" + 
				"	<!-- stylesheets -->\r\n" + 
				"	<link rel=\"stylesheet\" href=\"css/style1.css\" type=\"text/css\" media=\"all\">\r\n" + 
				"	\r\n" + 
				"	<!-- google fonts  -->\r\n" + 
				"	<link href=\"//fonts.googleapis.com/css?family=Alegreya+Sans:100,100i,300,300i,400,400i,500,500i,700,700i,800,800i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<div class=\"w3ls-banner\">\r\n" + 
				"	<div class=\"heading\">\r\n" + 
				"		<h1>My Account</h1>\r\n" + 
				"	</div>\r\n" + 
				"		<div class=\"container\">\r\n" + 
				"			<div class=\"heading\">\r\n" + 
				"				<h2>Please Enter Username and Password</h2>\r\n" + 
				"				<p>Fill the Login form below and submit.</p>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"agile-form\">\r\n" + 
				"				<form action=\"/MyAccount/LoginServlet\" method=\"post\">\r\n" + 
				"					<ul class=\"field-list\">\r\n" + 
				"					\r\n" + 
				"					<li class=\"name\">\r\n" + 
				"							<label class=\"form-label\"> Username <span class=\"form-required\"> * </span></label>\r\n" + 
				"							<div class=\"form-input add\">\r\n" + 
				"								<span class=\"form-sub-label\">\r\n" + 
				"									<input type=\"text\" name=\"username\" placeholder=\"Username\" required>\r\n" + 
				"								</span>\r\n" + 
				"								\r\n" + 
				"							</div>\r\n" + 
				"						</li>\r\n" + 
				"						\r\n" + 
				"						\r\n" + 
				"						<li class=\"name\">\r\n" + 
				"							<label class=\"form-label\"> Password <span class=\"form-required\"> * </span></label>\r\n" + 
				"							<div class=\"form-input add\">\r\n" + 
				"								<span class=\"form-sub-label\">\r\n" + 
				"									<input type=\"password\" name=\"password\" placeholder=\"Password\" required>\r\n" + 
				"								</span>\r\n" + 
				"								\r\n" + 
				"							</div>\r\n" + 
				"						</li>\r\n" +  
				"						\r\n" + 
				"					\r\n" + 
				"						\r\n" + 
				"					</ul>\r\n" + 
				"					<div class=\"submit_btn\">\r\n" + 
				"						<input type=\"submit\" value=\"Submit\">\r\n" + 
				"					</div>\r\n" + 
				 "                   <div class=\"submit_btn\">\r\n" + 
						"				  \r\n" + 
						"				<a href=\"RegistrationPage\">SignUp</a> </div>\r\n" + 
				"				</form>	\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
