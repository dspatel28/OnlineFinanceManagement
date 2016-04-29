<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="ofm.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Other Expenses</title>
</head>
<% 	
	User user = (User) request.getAttribute("user");
%>
<body>
<form action="\OFM\UserRegistrationServlet" method="post">
<h2 align="center">Add Other Expenses</h2>
<table align="center">

<tr>
<td colspan="2" align="right"><b> Welcome <%=user.getFirstName()%>  <%=user.getLastName()%>,</b></td>
</tr>

<tr>
<td>
<label for="name">Title for Expense</label>
</td>
<td>
<input type="text" name="name" id="name" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="description"> Description </label>
</td>
<td>
<input type="text" name="description" id="description" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="amount"> Amount </label>
</td>
<td>
<input type="text" name="amount" id="amount" size="30" value=""/>
</td>
</tr>

<tr><td align="center" colspan="2">
<input type="submit" name="button1" value="Add"/>
<input type="hidden" name="userId" id="userId" value="<%=user.getId()%>"/>
<input type="hidden" id="actionField" name="actionField" value="addPurchase"/>
<input type="reset" name="button2" value="Clear"/>
</td> </tr>

<tr>
<td align="center" colspan="2">
<a href="\OFM\UserRegistrationServlet?actionField=goToHome&userId=<%=user.getId()%>">Go To Home</a>
</td>
</tr>

</table>
</form>
</body>
</html>