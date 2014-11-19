<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
    <title>Yelp</title>
      <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    <link rel='stylesheet' href='/stylesheets/style.css' />
    <div style="position:absolute;top:40px;right:50px">
    <form action="SignOut" method="post">
   <b><font color="blue"> Hi <span style="text-transform:capitalize;"></span><%= session.getAttribute("username") %></font></b>
    <button name="signout" type="submit">Signout</button> 
    </form>
    </div>
    <div style="position:absolute;top:65px;right:50px">
   <form action="/SImpleMarketPlaceClient/View/AddPlace.jsp">
    <button name="add" type="submit">Add Place</button>
    </form>
    </div>
    <%if(request.getAttribute("lastlogin")!=null){ %>
   <div style="position:absolute;top:90px;right:50px">
    <i>Last Logged in @ <%= request.getAttribute("lastlogin") %></i>
    </div>
    <%} %>
    <div style="position:absolute;top:65px;right:130px">
    <form action='MyAccount' method="post">
    <button name="MyAccount" type="submit">My Account</button>
    </form>
    </div>
    <script>
  $(function() {
    var availableTags = [
      "Restaurants",
      "Food",
      "Shopping",
      "nightlife",
      "Japanese",
      "Coffee & Tea",
      "Chinese",
      "Bars",
      "Beauty & Spas",
      "Automotive",
      "Home Services",
      "Health & Medical",
      "Local Serices",
      "Hotels & Travel",
      "Professional Services",
      "Real Estate",
      "Education",
      "Financial Services",
      "Active Life",
      "Arts & Entertainment",
      "Religious Organizations",
      "Public Services"
    ];
   
    $( "#search" ).autocomplete({
      source: availableTags
    });
   
  });
  </script>
  </head>
  <body>
  <% session.setAttribute("lastpage","/View/Mypage.jsp"); %>
  <p><br>
  <form action="Search" method="post">
  <div class="ui-widget">
  		<div style="color:blue;font-size:200%;top:-40px;position:relative;">Yelp</div>
	  <input id="search" name="search" type="text" placeholder="search item" style="height:25px">
	  <input name="place" type="text" placeholder="city name or zipcode" style="height:25px">
	  <input name="search1" type="submit" value="search" style="height:30px">
  </div>	
  </form>
  <% if(request.getAttribute("searcherror")!=null) {%>
  <font color="red"><%=request.getAttribute("searcherror") %></font>
  <%} %>
  </body>
</html>