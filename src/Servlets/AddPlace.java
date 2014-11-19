package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Connection.Add;
import Connection.ServiceProxy;

/**
 * Servlet implementation class SignUp
 */
public class AddPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlace() {
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
		Add place=new Add();
		int status;
		 try{			
			 	if(request.getParameter("pname").matches("^[a-zA-Z0-9 ]+$") && request.getParameter("cname").matches("^[a-zA-Z0-9 ]+$") && request.getParameter("address1").matches("^[a-zA-Z0-9 ]+$") && request.getParameter("address2").matches("^[a-zA-Z0-9 ]+$") &&  request.getParameter("phone").matches("^[0-9]+$") && request.getParameter("category").matches("^[a-zA-Z0-9 ]+$"))
			 	{place.setPlacename((String)request.getParameter("pname"));
			 	place.setAddress1((String)request.getParameter("address1"));
			 	place.setAddress2((String)request.getParameter("address2"));
			 	place.setCityname((String)request.getParameter("cname"));
			 	place.setCategory((String)request.getParameter("category"));
			 	place.setPhone((String)request.getParameter("phone"));
			 	HttpSession session = request.getSession();
			 	place.setUserid((int)session.getAttribute("userid") );
			 	proxy.setEndpoint("http://localhost:8080/SImpleMarketPlace/services/Service");
				status = proxy.addPlace(place);
				System.out.println("after Adding place "+status);
				//HttpSession session = request.getSession();
				if(status>0){
					System.out.println(request.getParameter("pname"));
					System.out.println("In addplace servlet");
					request.setAttribute("username",session.getAttribute("username"));
					request.getRequestDispatcher("/View/Mypage.jsp").forward(request, response);
				}
				else{
					//out.println(qdone);
					request.getRequestDispatcher("/View/AddPlace.jsp").forward(request,response);
				}
			 	}else{
			 		if(!request.getParameter("pname").matches("^[a-zA-Z0-9 ]+$"))
			 		{
			 			request.setAttribute("error1", "Provide a valid Placename");
			 			request.getRequestDispatcher("/View/AddPlace.jsp").forward(request,response);
			 		}
			 		if (!request.getParameter("cname").matches("^[a-zA-Z0-9 ]+$"))
			 		{
			 			request.setAttribute("error2", "Provide a valid Cityname");
			 			request.getRequestDispatcher("/View/AddPlace.jsp").forward(request,response);
			 		}
			 		if(!request.getParameter("address1").matches("^[a-zA-Z0-9 ]+$"))
			 		{
			 			request.setAttribute("error3", "Provide a valid address");
			 			request.getRequestDispatcher("/View/AddPlace.jsp").forward(request,response);
			 		}
			 		
			 		if(!request.getParameter("address2").matches("^[a-zA-Z0-9 ]+$"))
			 		{
			 			request.setAttribute("error4", "Provide a valid address");
			 			request.getRequestDispatcher("/View/AddPlace.jsp").forward(request,response);
			 		}
			 		if(!request.getParameter("phone").matches("^[0-9]+$"))
			 		{
			 			request.setAttribute("error5", "Provide a valid Phone Number");
			 			request.getRequestDispatcher("/View/AddPlace.jsp").forward(request,response);
			 		}
			 		if(!request.getParameter("category").matches("^[a-zA-Z0-9 ]+$"))
			 		{
			 			request.setAttribute("error6", "Provide a valid Category");
			 			request.getRequestDispatcher("/View/AddPlace.jsp").forward(request,response);
			 		}
			 	}
			 	}
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
