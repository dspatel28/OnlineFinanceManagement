<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String msg = (String)request.getAttribute("msg");
	if (msg==null)
	{
		msg="";
	}
%>
<body>
<form  action="\OFM\UserRegistrationServlet" method="post">
<h2 align="center"> Personal Details</h2>
<table align="center">
<tr>
<td>
<label for="firstName"> First Name</label>
</td>
<td>
<input type="text" name="firstName" id="firstName" size="30" value=""/>
</td>
</tr>

<tr>
<td> 
<label for="lastName"> Last Name</label>
</td>
<td>
<input type="text" name="lastName" id="lastName" size="30" value=""/>
</td>
</tr>

<tr>
<td> 
<label for="userName"> User Name</label>
</td>
<td>
<input type="text" name="userName" id="userName" size="30" value=""/>
</td>
</tr>

<tr>
<td> 
<label for="password"> Password</label>
</td>
<td>
<input type="password" name="password" id="password" size="30" value=""/>
</td>
</tr>

<tr>
<td> 
<label for="cpassword"> Confirm Password</label>
</td>
<td>
<input type="password" name="cpassword" id="cpassword" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="contactNo"> Contact Number</label>
</td>
<td>
<input type="text" name="contactNo" id="contactNo" size="30" value=""/>
</td>
</tr>


<tr>
<td>
<label for="emailAddress"> Email Address</label>
</td>
<td>
<input type="text" name="emailAddress" id="emailAddress" size="30" value=""/>
</td>
</tr>


<tr>
<td>
<label for="addressLine1"> Address Line-1</label>
</td>
<td>
<input type="text" name="addressLine1" id="addressLine1" size="30" value=""/>
</td>
</tr>


<tr>
<td>
<label for="addressLine2"> Address Line-2</label>
</td>
<td>
<input type="text" name="addressLine2" id="addressLine2" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="city"> City</label>
</td>
<td>
<input type="text" name="city" id="city" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="state"> State </label>
</td>
<td>
<input type="text" name="state" id="state" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="country"> Country</label>
</td>
<td>
<input type="text" name="country" id="country" size="30" value=""/>
</td>
</tr>


<tr>
<td>
<label for="zipcode"> ZipCode </label>
</td>
<td>
<input type="text" name="zipcode" id="zipcode" size="30" value=""/>
</td>
</tr>

<tr>
<td  align="right">
<input type="submit" name="button1" value="Register"/>
<input type="hidden" id="actionField" name="actionField" value="register"/>
</td>
<td>&nbsp; &nbsp; 
<input type="reset" name="button2" value="Clear"/>
</td>
</tr>

<tr>
<td colspan="2">
<%= msg %>
</td>
</tr>

<tr>
<td align="center" colspan="2">
<a href="\OFM">Go To Login Page</a>
</td>
</tr>

</table>
</form>
</body>
</html>