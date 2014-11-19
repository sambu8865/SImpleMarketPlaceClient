<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link rel='stylesheet' href='/stylesheets/style.css' />
</head>
<body>
<% session.setAttribute("lastpage","/View/Search.jsp"); %>
<h1 style="color:blue;">Yelp</h1><br>
<div style="font-size:16px;">
<b>
<%= request.getAttribute("category") %> results in <%=request.getAttribute("cityname")%> </b>
</div>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
<table  br=1  border:2px style="width:80%">
<% String[] pname=(String[])request.getAttribute("pname"); 
int[] pid=(int[])request.getAttribute("pid"); 
 int[] review=(int[])request.getAttribute("review"); 
 String[] address=(String[])request.getAttribute("address"); 
 String [] phone=(String[])request.getAttribute("phone"); 
 if(pname!=null){ %>
<tr style="height:50px"><th>Place Name</th><th>Address</th><th>Phone</th><th>Review</th></tr>
<% for(int i=0;i<pname.length;i++) { %>
<tr>
<form action="ReviewPlace" method="post">
<td id="pname" style="text-align:center;text-transform:capitalize"><%= pname[i] %></td>
<td style="text-align:center;"><%= address[i] %></td>
<td style="text-align:center;"><%= phone[i] %></td>
<td style="text-align:center;"><%= review[i] %><br><input type = "submit" name="Review" value = "Review"/>
<input type='hidden' value="<%= pid[i] %>" name='placeid'>
<input type='hidden' value="<%= pname[i] %>" name='placename'>
</form>
</tr>
<% } %>
<% } else{ %>
<br>No records found</br>
<% } %>

</table>

  </body>
</html>