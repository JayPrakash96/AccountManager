package myAccount.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationPage
 */
@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationPage() {
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
				"		<!DOCTYPE html>\r\n" + 
				"		<html lang=\"en\">\r\n" + 
				"		<head>\r\n" + 
				"			<!-- Meta tags -->\r\n" + 
				"			<title>General Registration  Form </title>\r\n" + 
				"			<meta name=\"keywords\" content=\"General Application Form Responsive widget, Flat Web Templates, Android Compatible web template, \r\n" + 
				"			Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\r\n" + 
				"			<meta charset=\"utf-8\">\r\n" + 
				"			<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"			<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"			\r\n" + 
				"			<!-- stylesheets -->\r\n" + 
				"			<link rel=\"stylesheet\" href=\"css/style1.css\" type=\"text/css\" media=\"all\">\r\n" + 
				"			\r\n" + 
				"			<!-- google fonts  -->\r\n" + 
				"			<link href=\"//fonts.googleapis.com/css?family=Alegreya+Sans:100,100i,300,300i,400,400i,500,500i,700,700i,800,800i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"		</head>\r\n" + 
				"		<body>\r\n" + 
				"			<div class=\"w3ls-banner\">\r\n" + 
				"			<div class=\"heading\">\r\n" + 
				"				<h1>Registration Form</h1>\r\n" + 
				"			</div>\r\n" + 
				"				<div class=\"container\">\r\n" + 
				"					<div class=\"heading\">\r\n" + 
				"						<h2>Please Enter Your Details</h2>\r\n" + 
				"						<p>Fill the Registeration form below and submit.</p>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"agile-form\">\r\n" + 
				"						<form  action=\"/MyAccount/RegistrationServlet\" method=\"post\">\r\n" + 
				"							<ul class=\"field-list\">\r\n" + 
				"							\r\n" + 
				"							<li class=\"name\">\r\n" + 
				"									<label class=\"form-label\"> Username <span class=\"form-required\"> * </span></label>\r\n" + 
				"									<div class=\"form-input add\">\r\n" + 
				"										<span class=\"form-sub-label\">\r\n" + 
				"											<input type=\"text\" name=\"username\"id=\"username\" placeholder=\"Username\" required>\r\n" + 
				"										</span>\r\n" + 
				"										\r\n" + 
				"									</div>\r\n" + 
				"								</li>\r\n" + 
				"								\r\n" + 
				"								\r\n" + 
				"								<li class=\"name\">\r\n" + 
				"									<label class=\"form-label\"> Password <span class=\"form-required\"> * </span></label>\r\n" + 
				"									<div class=\"form-input add\">\r\n" + 
				"										<span class=\"form-sub-label\">\r\n" + 
				"											<input type=\"password\" name=\"password\" id =\"password\" placeholder=\"Password\" required>\r\n" + 
				"										</span>\r\n" + 
				"										\r\n" + 
				"									</div>\r\n" + 
				"								</li>\r\n" + 
				"							\r\n" + 
				"							\r\n" + 
				"								<li class=\"name\">\r\n" + 
				"									<label class=\"form-label\"> Name <span class=\"form-required\"> * </span></label>\r\n" + 
				"									<div class=\"form-input add\">\r\n" + 
				"										<span class=\"form-sub-label\">\r\n" + 
				"											<input type=\"text\" name=\"firstname\" id=\"firstname\" placeholder=\"Name\" required>\r\n" + 
				"										</span>\r\n" + 
				"										\r\n" + 
				"										\r\n" + 
				"									</div>\r\n" + 
				"								</li>\r\n" + 
				"								\r\n" + 
				"								<li> \r\n" + 
				"									<label class=\"form-label\">\r\n" + 
				"									   Address\r\n" + 
				"									   <span class=\"form-required\"> * </span>\r\n" + 
				"									</label>\r\n" + 
				"									<div class=\"form-input add\">\r\n" + 
				"										\r\n" + 
				"										<span class=\"form-sub-label\">\r\n" + 
				"											<input type=\"text\" name=\"address\"id=\"address\"placeholder=\"Address\" required>\r\n" + 
				"										</span>\r\n" + 
				"										\r\n" + 
				"									</div>\r\n" + 
				"								</li>\r\n" + 
				"								\r\n" + 
				"								<li> \r\n" + 
				"									<label class=\"form-label\"> Phone Number <span class=\"form-required\"> * </span></label>\r\n" + 
				"									<div class=\"form-input\">\r\n" + 
				"										<input type=\"text\" name=\"mobile_number\" id=\"mobile_number\"placeholder=\"Phone Number\" required >\r\n" + 
				"									</div>\r\n" + 
				"								</li>\r\n" + 
				"								\r\n" + 
				"								<li> \r\n" + 
				"									<label class=\"form-label\"> E-Mail Address <span class=\"form-required\"> * </span></label>\r\n" + 
				"									<div class=\"form-input\">\r\n" + 
				"										<input type=\"email\" name=\"email\"id=\"email\"placeholder=\"Mail@example.com\" required>\r\n" + 
				"									\r\n" + 
				"									</div>\r\n" + 
				"								</li>\r\n" + 
				"								\r\n" + 
				"							\r\n" + 
				"								\r\n" + 
				"							</ul>\r\n" + 
				"							<div class=\"submit_btn\">\r\n" + 
				"								<input type=\"submit\" name =\"submit\" id =\"submit\"value=\"Submit\">\r\n" + 
				"							</div>\r\n" +
				
				         "                     <div class=\"submit_btn\">\r\n" + 
						"								<input type=\"reset\" name =\"reset\" id =\"reset\"value=\"Cancel\">\r\n" + 
						"							</div>\r\n"+
				            "                <div class=\"submit_btn\">\r\n" + 
							"				  \r\n" + 
							"				<a  href=\"LoginForm\">SignIn</a> </div>\r\n" + 
				"						</form>	\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</body>\r\n" + 
				"		</html> ");
	
		
		
	}

}
