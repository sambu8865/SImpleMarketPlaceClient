<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.5.js"></script>
   <script>
      function countChar(val) {
        var len = val.value.length;
        if (len >= 200) {
          val.value = val.value.substring(0, 200);
        } else {
          $('#charNum').text(200 - len);
        }
      };
      </script>
<title>Post Review</title>
<link rel='stylesheet' href='/stylesheets/style.css' />
</head>
<body>
<% session.setAttribute("lastpage","/View/Postreview.jsp"); %>
<h1 style="color:blue;">Yelp Reviews</h1><br>
<div style="font-size:16px;">
<form  action="ReviewPost" method="post">
<div id="hide">
<input type="text" name="username" placeholder="username"></input>
<input type="password" name="password" placeholder="password"></input><br>
<div style="font-size:12px;color:red"></div><br><br>
</div>
<b>Provide the reviews for <span style="text-transform:capitalize;"><%= request.getParameter("placename") %></span>  </b>
<input type="radio" name="score" value="1">1</input>
<input type="radio" name="score" value="2">2</input>
<input type="radio" name="score" value="3">3</input>
<input type="radio" name="score" value="4">4</input>
<input type="radio" name="score" value="5">5</input><br>
<%if(request.getAttribute("error1")!=null){ %><font color="red"><%=request.getAttribute("error1") %></font><%} %><br><br>
<textarea id="comments" name="comments" cols="50" rows="5" onkeyup="countChar(this)">
Enter your comments here...
</textarea><br>
<%if(request.getAttribute("error2")!=null){ %><font color="red"><%=request.getAttribute("error2") %></font><%} %>
<div id="charNum"></div>
<input type='hidden' value=<%= request.getParameter("placeid") %> name="placeid">
<input type="hidden" value<%= request.getParameter("placename") %> name="placeid">
<input type='submit' value='submit'><br><br>
</form>
</div>
<script>
if(<%= session.getAttribute("userid") %>){	
	var div1=document.getElementById('hide');
	div1.style.visibility='hidden';
	}
</script>


<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
<table  br=1  border:2px style="width:80%">

</table>
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
<td id="rpname" style="text-align:center;text-transform:capitalize"><%= rpname[i] %></td>
<td style="text-align:center;"><%= raddress[i] %></td>
<td style="text-align:center;"><%= rcomment[i] %></td>
<td style="text-align:center;"><%= rreview[i] %><br>
</tr>
<% } %>
<% } else{ %>
<br>No records found</br>
<% } %>
</table><br>


</body>
</html>