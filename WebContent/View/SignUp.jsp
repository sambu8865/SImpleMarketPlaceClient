<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up</title>
</head>
<body>
<% session.setAttribute("lastpage","/View/SignUp.jsp"); %>
<div><b><h2><font color="blue"> Sign Up for New Account </font></h2></b></div><br>
<form id="form1" method="post" action="SignUp" >  
<div>
       <input name="fullname" type="text" placeholder="Full Name"><span style="color:red"></span>&nbsp&nbsp<% if(request.getAttribute("error1")!=null){%> <font color="red"> <%= request.getAttribute("error1") %></font><%} %><br>
   <p> <input name="email" type="text" placeholder="Email"><span style="color:red"></span>&nbsp&nbsp<% if(request.getAttribute("error2")!=null){%> <font color="red"> <%= request.getAttribute("error2") %></font><%} %><br>
   <p> <input name="phonenumber" type="text"  maxlength="10" placeholder="Phone Number"><span style="color:red"></span>&nbsp&nbsp<% if(request.getAttribute("error3")!=null){%> <font color="red"> <%= request.getAttribute("error3") %></font><%} %><br>
   <p> <input name="password" type="password" placeholder="password"><span style="color:red"></span>&nbsp&nbsp<% if(request.getAttribute("error4")!=null){%> <font color="red"> <%= request.getAttribute("error4") %></font><%} %><br>
   <p> <button name="Submit" type="submit" value="Submit">Submit</button>
  </div>
</form> 

</body>
</html>