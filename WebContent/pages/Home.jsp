<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Finance Management</title>
</head>

<%
	String msg = (String)request.getAttribute("msg");
	if (msg==null)
	{
		msg="";
	}
%>
<body>
<form action="\OFM\LoginServlet" method="post">
<br/><br/><br/><br/><br/><br/><br/><br/><br/>
<table align="center">
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
			<label for="password1"> Password</label>
		</td>
		<td>
			<input type="password" name="password" id="password" size="30" value=""/>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" name="button1" value="Login"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<%= msg %>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="\OFM\UserRegistrationServlet?actionField=viewHome" >New User Registration</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>