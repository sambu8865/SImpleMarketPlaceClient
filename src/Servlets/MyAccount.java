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
import javax.websocket.Session;

import Connection.Place;
import Connection.Review;
import Connection.ServiceProxy;

/**
 * Servlet implementation class SignUp
 */
public class MyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAccount() {
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
		Place[] qdone;
		Review[] review1;
		 try{	
			 System.out.println("Inside Myaccount servlet");
			 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
				
				System.out.println("after getting places ");
				HttpSession session = request.getSession();
				qdone=proxy.userplaces((int)session.getAttribute("userid"));
				if(qdone==null)
				{
					request.setAttribute("places",false); 
					//request.getRequestDispatcher("/View/Search.jsp").forward(request, response);
				}else{		
					System.out.println();
					String[] pname=new String[qdone.length];
					String[] address=new String[qdone.length];
					String[] phone=new String[qdone.length];
					int[] review=new int[qdone.length];
					int[] pid=new int[qdone.length];
					int i=0;
					for(Place place1:qdone)
					{
						pname[i]=place1.getPlacename();
						pid[i]=place1.getPlaceid();
						address[i]=place1.getAddress();
						phone[i]=place1.getPhone();
						review[i]=place1.getReview();
						i++;
					}
					request.setAttribute("pname",pname);
					request.setAttribute("pid",pid);
					request.setAttribute("address",address);
					request.setAttribute("phone",phone);
					request.setAttribute("review",review);
					request.setAttribute("places",true);
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }

		 try{	
			 System.out.println("Inside Myaccount review servlet");
			 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
				System.out.println(" getting reviews ");
				HttpSession session = request.getSession();
				review1=proxy.reviews((int)session.getAttribute("userid"));
				if(review1==null)
				{
					request.setAttribute("reviews",false); 
					request.getRequestDispatcher("/View/MyAccount.jsp").forward(request, response);
				}else{		
					System.out.println();
					String[] rpname=new String[review1.length];
					String[] raddress=new String[review1.length];
					String[] rcomment=new String[review1.length];
					int[] rid=new int[review1.length];
					int[] rreview=new int[review1.length];
					int i=0;
					for(Review review2:review1)
					{
						rpname[i]=review2.getPlacename();
						rid[i]=review2.getReviewid();
						raddress[i]=review2.getAddress();
						rcomment[i]=review2.getComment();
						rreview[i]=review2.getReview();
						i++;
					}
					request.setAttribute("rpname",rpname);
					request.setAttribute("rid",rid);
					request.setAttribute("raddress",raddress);
					request.setAttribute("rcomment",rcomment);
					request.setAttribute("rreview",rreview);
					request.setAttribute("reviews",true);
				request.getRequestDispatcher("/View/Myaccount.jsp").forward(request, response);
				}
				
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }

	}

}
