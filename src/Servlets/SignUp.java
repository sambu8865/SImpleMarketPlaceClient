package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String qdone;	
		 try{			
			 if(request.getParameter("fullname").matches("^[a-zA-Z ]+$") && request.getParameter("email").matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") && request.getParameter("phonenumber").matches("^[0-9]+$") && request.getParameter("password").matches("^[a-zA-Z0-9]+$"))
			 {
			 	String fullname = request.getParameter("fullname");
			 	String email = request.getParameter("email");
			 	String phonenumber = request.getParameter("phonenumber");
			 	String password = request.getParameter("password");
			 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
				qdone = proxy.signUp(fullname,email,phonenumber,password);
				System.out.println("after signing "+qdone);
				HttpSession session = request.getSession();
				if(qdone.substring(0,4).equals("true")){
					System.out.println(qdone);
					System.out.println(qdone.substring(4));
					session.setAttribute("userid",qdone.substring(4));
					System.out.println("userid:"+session.getAttribute("userid"));
					session.setAttribute("username",proxy.getusername(session.getAttribute("userid").toString()));
					out.println("WELCOME to Simple Market Place "+session.getAttribute("username").toString());
					//out.println(qdone);//Displaying the message on the servlet itself.
					request.setAttribute("username",session.getAttribute("username"));
					request.getRequestDispatcher("/View/Mypage.jsp").forward(request, response);
				}
				else{
					out.println("<font color=\"red\">"+qdone+"</font>");
					out.println("\n <a href=\"SignUp.jsp\"><br>Go back to SignUp again</a>");
				}
			 }
			 else{
				 if(!request.getParameter("fullname").matches("^[a-zA-Z ]+$"))
				 {
					request.setAttribute("error1","Invalid Name");
					request.getRequestDispatcher("/View/SignUp.jsp").forward(request,response);
				 }
				 if(!request.getParameter("email").matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
				 {
					 request.setAttribute("error2","Invalid email");
						request.getRequestDispatcher("/View/SignUp.jsp").forward(request,response); 
				 }
			     if(!request.getParameter("phonenumber").matches("^[0-9]+$"))
			     {
			    	 request.setAttribute("error3","Invalid Phone Number");
						request.getRequestDispatcher("/View/SignUp.jsp").forward(request,response);
			     }
			     if(!request.getParameter("password").matches("^[a-zA-Z0-9]+$"))
			     {
			    	 request.setAttribute("error4","Invalid password");
						request.getRequestDispatcher("/View/SignUp.jsp").forward(request,response);
			     }
			 }
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
