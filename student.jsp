<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student</title>
<link href="login.css" rel="stylesheet">
</head>
<script>
function validateForm() {
    var x = document.forms["myForm"]["name"].value;
    var y = document.forms["myForm"]["age"].value;
    var z = document.forms["myForm"]["address"].value;
    var a = document.forms["myForm"]["phno"].value;
    var b = document.forms["myForm"]["eid"].value;
    var c = document.forms["myForm"]["stdno"].value;
    if ((x == null || x == "")) {
        alert("Name must be filled out");
        return false;
    }
    else if ((y == null || y == "")) {
    	 alert("age must be filled out");
    	 return false;
	}
    else if ((z == null || z == "")) {
   	 alert("address must be filled out");
   	 return false;
	}
    else if ((a == null || a == "")) {
      	 alert("phoneno id must be filled out");
      	 return false;
   	}
    else if ((b == null || b == "")) {
     	 alert("email id id must be filled out");
     	 return false;
  	}
    else if ((c == null || a == "")) {
     	 alert("studentno must be filled out");
     	 return false;
  	}
}
</script>
<body>
<form name="myForm" method="post" action="StudentServlet" onsubmit="return validateForm()">
 <center><div class="imgcontainer">
    <img src="http://www.gbscampuscare.in/Images/Student.png" alt="Avatar" height="100" width="100">
  </div></center>
<h1 style="color:green;"><b>Enter Student Details:</b></h1>
  <div class="container">
  
    <label><b>student name:</b></label>
    <input type="text"  name="name"   >
 </div>
  <div class="container">
  
    <label><b>Age:</b></label>
    <input type="number"  name="age"  >
 </div>
  <div class="container">
    <label><b>address:</b></label>
    <input type="text"  name="address"   >
</div>
  <div class="container">
    <label><b>phone no:</b></label>
    <input type="number"  name="phno" >
   
    </div>
	<div class="container">
    <label><b>emailId</b></label>
    <input type="text"  name="eid"   value="">
   
    </div>
   
   <div class="container">
    <label><b>student no</b></label>
    <input type="text"  name="stdno"  value="">
   
    </div>
    <br />
    <input type="radio" name="gender" value="M" /> Male
    <br />
    <input type="radio" name="gender" value="F" /> Female
    <br />

   <center> <div class="clearfix">
      <button type="submit" class="signupbtn">Submit</button></div></center>
 
</form>
</body>
</html>