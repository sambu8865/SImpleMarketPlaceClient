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
@WebServlet("/ReviewPost")
public class ReviewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPost() {
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
		Review reviews=new Review();
		int status;
		System.out.println("Inside Review post");
		int qdone;
		 try{			
			 	HttpSession session = request.getSession();
			 	if(session.getAttribute("userid")==null)
			 	{
			 		String username = request.getParameter("username");
				 	String password = request.getParameter("password");
				 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
					qdone = proxy.signIn(username,password);
					System.out.println("after getting places ");
					if(qdone==0){
						System.out.println("here");
						request.setAttribute("placeid",request.getParameter("placeid"));
						request.setAttribute("placename",request.getParameter("placename")); 
						request.getRequestDispatcher("ReviewPlace").forward(request, response);
					}
					else{
						System.out.println("here1");
						session.setAttribute("userid", qdone);
						session.setAttribute("username",proxy.getusername(session.getAttribute("userid").toString()));
						//out.println(qdone);//Displaying the message on the servlet itself.
						request.setAttribute("username",session.getAttribute("username"));
						request.setAttribute("places",true);
						//request.getRequestDispatcher("/View/Mypage.jsp").forward(request, response);
					}
			 	}
			 if(session.getAttribute("userid")!=null)
			 {
				if(request.getParameter("score")!=null && request.getParameter("comments").matches("^[A-Za-z0-9 ._]*[A-Za-z0-9][A-Za-z0-9 ._]*$") )
				{
				System.out.println("here2");
			 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
			 	reviews.setReview(Integer.parseInt(request.getParameter("score")));
			 	reviews.setUserid((int)session.getAttribute("userid"));
			 	reviews.setComment(request.getParameter("comments"));
			 	reviews.setPlaceid(Integer.parseInt(request.getParameter("placeid")));
				status = proxy.reviewPlace(reviews);
				if(status>0)
				{
					System.out.println("Review posted"); 
					request.getRequestDispatcher("/View/Mypage.jsp").forward(request, response);
				}else{		
					System.out.println("Review not posted");
					request.getRequestDispatcher("/View/Mypage.jsp").forward(request, response);
				}
				}else
				{
					if(request.getParameter("score")==null)
					{
						request.setAttribute("error1", "Select a score");
						request.getRequestDispatcher("/View/Postreview.jsp").forward(request,response);
					}
					else if(request.getParameter("comments")==null)
					{
						request.setAttribute("error2", "Please post a comment");
						request.getRequestDispatcher("/View/Postreview.jsp").forward(request,response);
					}
					else if(!request.getParameter("comments").matches("^[A-Za-z0-9 ._]*[A-Za-z0-9][A-Za-z0-9 ._]*$") )
					{
						request.setAttribute("error2", "Not a valid character");
						request.getRequestDispatcher("/View/Postreview.jsp").forward(request,response);
					}
				}
				
		 }
			 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
