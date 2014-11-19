package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.Add;
import Connection.ServiceProxy;

/**
 * Servlet implementation class SignUp
 */
public class DeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReview() {
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
		int status;
		 try{			
			 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
			 	int reviewid=Integer.parseInt(request.getParameter("reviewid"));
				status = proxy.deleteReview(reviewid);
				System.out.println("after deleting place "+status);
				HttpSession session = request.getSession();
				if(status>0){
					System.out.println(request.getAttribute("pname"));
					System.out.println("In addplace servlet");
					request.setAttribute("username",session.getAttribute("username"));
					request.getRequestDispatcher("MyAccount").forward(request, response);
				}
				else{
					//out.println(qdone);
					request.getRequestDispatcher("MyAccount").forward(request,response);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
