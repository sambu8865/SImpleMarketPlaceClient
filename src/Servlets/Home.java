package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.Place;
import Connection.ServiceProxy;

/**
 * Servlet implementation class SignUp
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		int qdone;	
		proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
		 try{	
			 	System.out.println("Inside Home");
			 	HttpSession session = request.getSession();
			 	System.out.println(session.getAttribute("username"));
			 	if(session.getAttribute("username")!=null)
			 	{
			 		System.out.println("username"+session.getAttribute("username"));
			 		System.out.println("username"+session.getAttribute("userid"));
			 		String lastlogin=proxy.lastLogin((int)session.getAttribute("userid"));
			 		request.setAttribute("lastlogin",lastlogin);
			 		request.setAttribute("username",session.getAttribute("username"));
					request.setAttribute("places",true);
			 		request.getRequestDispatcher("/View/Mypage.jsp").forward(request, response);
			 	}
			 	else
			 	{
			 	System.out.println("Outside ");
			 	if(request.getParameter("username").matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			 			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") && request.getParameter("password").matches("^[a-zA-Z0-9]+$"))
			 	{
			 	String username = request.getParameter("username");
			 	String password = request.getParameter("password");
				qdone = proxy.signIn(username,password);
				System.out.println("after getting places ");
				if(qdone==0){
					request.setAttribute("places",false);
					request.setAttribute("error","Username or Password is wrong");
					request.getRequestDispatcher("/View/Index.jsp").forward(request, response);
				}
				else{		
					session.setAttribute("userid", qdone);
					session.setAttribute("username",proxy.getusername(session.getAttribute("userid").toString()));
					String lastlogin=proxy.lastLogin((int)session.getAttribute("userid"));
					//out.println(qdone);//Displaying the message on the servlet itself.
					request.setAttribute("username",session.getAttribute("username"));
					request.setAttribute("lastlogin",lastlogin);
					request.setAttribute("places",true);
					request.getRequestDispatcher("/View/Mypage.jsp").forward(request, response);
				}
		 }else{
			 request.setAttribute("error", "Provide a valid Email id and Password");
			 request.getRequestDispatcher("/View/Index.jsp").forward(request, response);
		 }
			 	}}
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
