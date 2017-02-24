<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>signup</title>
<link href="login.css" rel="stylesheet">
<script >
function validateForm() {
    var x = document.forms["myForm"]["user"].value;
    var y = document.forms["myForm"]["pass1"].value;
    var z = document.forms["myForm"]["pass2"].value;
   
    if ((x == null || x == "")) {
        alert("Name must be filled out");
        return false;
    }
    else if ((y == null || y == "")) {
    	 alert("password must be filled out");
    	 return false;
	}
    else if ((z == null || z != y)) {
   	 alert("password must be same");
   	 return false;
	}
    
	}

</script>
</head>
<body>
<form name="myForm" method="post" action="SignupServlet" onsubmit="return validateForm()">

 <h1 style="color:green;"><b>Admin signup:</b></h1>
	<center><div class="imgcontainer">
    <img src="http://previews.123rf.com/images/faysalfarhan/faysalfarhan1605/faysalfarhan160504742/57292278-Sign-up-member-icon-glossy-cyan-blue-round-button-Stock-Photo.jpg" alt="Avatar" height="100" width="100">
  </div></center>
	<p>Username: <input type="text" name="user" size="20"></p>
	<p>Password: <input type="password" name="pass1" size="20"></p>
	<p>Re-type password: <input type="password" name="pass2" size="20"></p><hr>	
	<p>First name: <input type="text" name="firstname" size="20"></p>
	<p>Last name: <input type="text" name="lastname" size="20"></p>	
	 <br />
    <input type="radio" name="gender" value="M" /> Male
    <br />
    <input type="radio" name="gender" value="F" /> Female
    <br />
    <center><input type="submit" name="sub" value="Submit"></center>
		
   
 
</form>

</body>
</html>