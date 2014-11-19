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
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		HttpSession session = request.getSession();
		 try{	
			 System.out.println("Inside search");
			 	if(request.getParameter("search").matches("^[a-zA-Z0-9 ]+$") && request.getParameter("place").matches("^[a-zA-Z0-9 ]+$") )
			 	{
			 	String category = request.getParameter("search");
			 	String cityname = request.getParameter("place");
			 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
				qdone = proxy.places(category,cityname);
				System.out.println("after getting places ");
				if(qdone==null)
				{	request.setAttribute("places",false); 
				request.setAttribute("category",category);
				request.setAttribute("cityname",cityname);
					request.getRequestDispatcher("/View/Search.jsp").forward(request, response);
				}else{		
					System.out.println();
					//request.setAttribute("place",qdone);
					//session.setAttribute("userid",qdone.substring(4));
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
					request.setAttribute("category",category);
					request.setAttribute("cityname",cityname);
					request.setAttribute("places",true);
					request.getRequestDispatcher("/View/Search.jsp").forward(request, response);
				}
			 	}
				else{
					if(session.getAttribute("userid")==null){
					request.setAttribute("searcherror", "Invalid Search Options");
					request.getRequestDispatcher("/View/Index.jsp").forward(request,response);
					}
					else{
							request.setAttribute("searcherror", "Invalid Search Options");
							request.getRequestDispatcher("/View/Mypage.jsp").forward(request,response);
					}
				}
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
