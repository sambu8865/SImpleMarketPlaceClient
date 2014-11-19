package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.Add;
import Connection.Review;
import Connection.ServiceProxy;

/**
 * Servlet implementation class ReviewPlace
 */
@WebServlet("/ReviewPlace")
public class ReviewPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPlace() {
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
		Review[] reviews;
		 try{			
			 	HttpSession session = request.getSession();
			 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
				reviews = proxy.reviewgen(Integer.parseInt(request.getParameter("placeid")));
				if(reviews==null)
				{
					request.setAttribute("reviews",false); 
					request.getRequestDispatcher("/View/Postreview.jsp").forward(request, response);
				}else{		
					System.out.println();
					String[] rpname=new String[reviews.length];
					String[] raddress=new String[reviews.length];
					String[] rcomment=new String[reviews.length];
					int[] rid=new int[reviews.length];
					int[] rreview=new int[reviews.length];
					int i=0;
					for(Review review2:reviews)
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
				request.getRequestDispatcher("/View/Postreview.jsp").forward(request, response);
				}
				
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
