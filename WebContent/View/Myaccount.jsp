<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Account Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='/stylesheets/style.css' />
</head>
<body>
<% session.setAttribute("lastpage","/View/Myaccount.jsp"); %>
<h1 style="color:blue;">Yelp</h1><br>
<form action="Home" method="post">
<h2 style="position:absolute;top:70px;right:120px;">
<input type="submit" value="Home" name="submit"></input></h2>
</form>
<div style="font-size:16px;">
<b>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
My Places<br><br>
</b>
<table br=1  border:2px style="width:80%">

<% 
 String[] pname=(String[])request.getAttribute("pname"); 
 int[] pid=(int[])request.getAttribute("pid"); 
 int[] review=(int[])request.getAttribute("review"); 
 String[] address=(String[])request.getAttribute("address"); 
 String [] phone=(String[])request.getAttribute("phone"); 
 if(pname!=null){ %>
<tr style="height:50px"><th>Place Name</th><th>Address</th><th>Phone</th><th>Review</th></tr>
<% for(int i=0;i<pname.length;i++) { %>
<tr>
<form action="DeletePlace" method="post">
<td id="pname" style="text-align:center;text-transform:capitalize"><%= pname[i] %></td>
<td style="text-align:center;"><%= address[i] %></td>
<td style="text-align:center;"><%= phone[i] %></td>
<td style="text-align:center;"><%= review[i] %><br><input type = "submit" name="Review" value = "Delete"/>
<input type="hidden" value="<%= pid[i] %>" name="placeid">
<input type="hidden" value="<%= pname[i] %>" name="placename">
</form>
</tr>
<% } %>
<% } else{ %>
<br>No records found</br>
<% } %>
</table><br>
</div>

<div>
<b><p style="font-size:16px;left:20px">My reviews</p></b>
</div>
<table  br=1  border:2px style="width:80%;position:relative;">
<% 
 String[] rpname=(String[])request.getAttribute("rpname"); 
 int[] rid=(int[])request.getAttribute("rid"); 
 int[] rreview=(int[])request.getAttribute("rreview"); 
 String[] raddress=(String[])request.getAttribute("raddress"); 
 String [] rcomment=(String[])request.getAttribute("rcomment"); 
 if(rpname!=null){ %>
<tr style="height:50px"><th>Place Name</th><th>Address</th><th>Comment</th><th>Review</th></tr>
<% for(int i=0;i<rpname.length;i++) { %>
<tr>
<form action="DeleteReview" method="post">
<td id="rpname" style="text-align:center;text-transform:capitalize"><%= rpname[i] %></td>
<td style="text-align:center;"><%= raddress[i] %></td>
<td style="text-align:center;"><%= rcomment[i] %></td>
<td style="text-align:center;"><%= rreview[i] %><br><input type = "submit" name="Review" value = "Delete"/>
<input type="hidden" value="<%= rid[i] %>" name="reviewid">
<input type="hidden" value="<%= rpname[i] %>" name="placename">
</form>
</tr>
<% } %>
<% } else{ %>
<br>No records found</br>
<% } %>
</table><br>

</body>
</html>