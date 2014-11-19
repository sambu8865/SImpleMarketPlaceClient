<!DOCTYPE html>
<html>
  <head>
       <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    <title>Add Place</title>
    <link rel='stylesheet' href='/stylesheets/style.css'/>
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
   
    $( "#category" ).autocomplete({
      source: availableTags
    });
   
  });
  </script>
  </head>
  <body>
  <% session.setAttribute("lastpage","/View/AddPlace.jsp"); %>
    <h1>Add the place details </h1>
<form action="AddPlace" method="post">
<div style="width:300%;font-size:300%;">
<input style="width:10%" type="text" name="pname" placeholder="Place Name"><font size="3" color="red">&nbsp&nbsp<% if(request.getAttribute("error1")!=null){%> <font color="red"> <%= request.getAttribute("error1") %></font><%} %><br>
<input style="width:10%" type="text" name="cname" placeholder="City Name/Zipcode"><font size="3" color="red">&nbsp&nbsp<% if(request.getAttribute("error2")!=null){%> <font color="red"> <%= request.getAttribute("error2") %></font><%} %><br>
<input style="width:10%" type="text" name="address1" placeholder="Address Line1"><font size="3" color="red">&nbsp&nbsp <% if(request.getAttribute("error3")!=null){%> <font color="red"> <%= request.getAttribute("error3") %></font><%} %><br>
<input style="width:10%" type="text" name="address2" placeholder="Address Line2"><font size="3" color="red">&nbsp&nbsp <% if(request.getAttribute("error4")!=null){%> <font color="red"> <%= request.getAttribute("error4") %></font><%} %><br>
<input style="width:10%" type="text" name="phone" placeholder="(555)-555-5555"><font size="3" color="red">&nbsp&nbsp <% if(request.getAttribute("error5")!=null){%> <font color="red"> <%= request.getAttribute("error5") %></font><%} %><br>
<input id="category" style="width:10%" type="text" name="category" placeholder="Category"><font size="3" color="red">&nbsp&nbsp <% if(request.getAttribute("error6")!=null){%> <font color="red"> <%= request.getAttribute("error6") %></font><%} %><br>
<button type="submit"  name="Submit">Submit</button>
</div>
</form>
 </body>
</html>