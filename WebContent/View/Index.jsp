<!DOCTYPE html>
<html>
  <head>
    <title>Yelp</title>
    <link rel='stylesheet' href='/stylesheets/style.css' />
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
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
    var results=results;
    $( "#search" ).autocomplete({
      source: availableTags
    });
    $("#test").autocomplete({
    	source: results.username
    	});
  });
  </script>
    <h2><font color="blue">Welcome to Yelp</font></h2>
    <form action="Home" method="post">
    <div  style="position:relative;top:-40px;">
    <input name="username" type="text" placeholder="username" style="right:280px;position:absolute;">
    <input name="password" type="password" placeholder="password" style="right:80px;position:absolute;">
    <button style="right:10px;position:absolute;width:5em" id="home" name="signin" type="submit">Sign In</button>
    </div>
    </form>
    <form  action="/SImpleMarketPlaceClient/View/SignUp.jsp" method="post">
    <div>
    <button style="right:18px;position:absolute;width:5em"  name="signup" type="submit">SignUp</button>
    </div>
    </form>
    <div style="position:absolute;top:50px;right:200px;">
    <%if(request.getAttribute("error")!=null){ %>
    <font color="red"><%=request.getAttribute("error")%></font>
    <%} %>
    <% session.setAttribute("lastpage","/View/Index.jsp"); %>
    </div>
  </head>
  <body>
  <p><br>
  <form action="Search" method="post">
  <div class="ui-widget">
	  <input id="search" name="search" type="text" placeholder="search item" style="height:25px">
	  <input name="place" type="text" placeholder="place" style="height:25px">
	  <input name="submit" type="submit" value="search" style="height:30px">
  </div>
  </form>
  <div>
  <%if(request.getAttribute("searcherror")!=null){ %>
  <font color="red"><%= request.getAttribute("searcherror")%></font>
  <%} %>
  </div>
  </body>
</html>