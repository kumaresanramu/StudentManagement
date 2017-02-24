<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loginpage</title>
<link href="login.css" rel="stylesheet" type="text/css">
<script>
function validateForm() {
    var x = document.forms["myForm"]["uname"].value;
    var y = document.forms["myForm"]["psw"].value;
    if ((x == null || x == "")) {
        alert("Name must be filled out");
        return false;
    }
    else if ((y == null || y == "")) {
    	 alert("password must be filled out");
    	 return false;
	}
}
</script>

</head>
<body>

<div class="city">
 <center><div class="imgcontainer">
    <img src="https://upload.wikimedia.org/wikipedia/en/thumb/c/cc/Ace-logo.svg/1280px-Ace-logo.svg.png" alt="Avatar" height="100" width="100">
  </div></center>
<p>This login is only for college employees.this website is used for maintain student student records </p> 
<h1 style="color:green;"><b>description</b></h1>
  <p>A rapidly changing world is one of the biggest challenges facing today's graduates. New technologies, new working practices and changes in tastes and fashions require graduates who are equipped with flexible attitudes. AEC provides students with the skills to succeed.
AEC, a Co-Educational institution was established in the year 1993. The college is spread out on serene sylvan settings on the Chittor - Cuddalore national highway, providing a holistic environment, ideal for dedicated study with discipline, away from the hustle and bustle of the modern cities...</p>
 </div>

<div class="city">
  
 <form name="myForm" method="post" action="loginServlet" onsubmit="return validateForm()">
<center><div class="imgcontainer">
    <img src="http://www.iconskid.com/images/3/login-iconpng-3068.png" height="100" width="100">
  </div></center>

  
<center><h1 style="color:blue;"><b>AdminLogin</b></h1></center>
  <center><div class="container">
    <label><b>Username </b></label>
    <input type="text"  name="uname" >
  </div>

  <div class="container">
    <label><b>Password </b></label>
    <input type="password" name="psw" >
	 </div>
 <div class="container">
    <button type="submit">Login</button>
    </div></center>

  <div class="container" style="background-color:#f1f1f1">
   <a href="signup.jsp"> <button type="button" class="cancelbtn">signup</button></a>
    <span class="psw">Forgot <a href="signup.jsp">password?</a></span>
  </div>
  </form>
  </div>

</body>
</html>