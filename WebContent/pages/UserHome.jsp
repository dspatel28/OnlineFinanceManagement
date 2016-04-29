<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
</head>
<% 	
	User user = new User();
	user = (User) request.getAttribute("user");
%>

<%
	String msg = (String)request.getAttribute("msg");
	if (msg==null)
	{
		msg="";
	}
%>
<body>
<form>
<h2 align="center">Online Finance Management</h2>
<table align="center">
<tr>
<td><b> Welcome <%=user.getFirstName()%>  <%=user.getLastName()%>,</b></td>
</tr>
<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewPersonalDetails&userId=<%=user.getId()%>">Update Personal Details</a>
</td> 
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewAddBank&userId=<%=user.getId()%>">Add Bank Details</a>
</td>
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewBanks&userId=<%=user.getId()%>">Update Bank Details</a>
</td>
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewAddConnection&userId=<%=user.getId()%>">Add Connection</a>
</td> 
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewConnections&userId=<%=user.getId()%>">Update Connection</a>
</td>
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewAddBill&userId=<%=user.getId()%>">Add Bill</a>
</td>
</tr>

<tr>
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewAddPurchase&userId=<%=user.getId()%>">Add Other Expenses</a>
</td> 
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewMakePayment&userId=<%=user.getId()%>">Make Payment</a>
</td> 
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewAddTransaction&userId=<%=user.getId()%>">Add Bank transaction</a>
</td> 
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=viewAccountSummary&userId=<%=user.getId()%>">View Account Summary</a>
</td> 
</tr>

<tr> 
<td>
<a href="\OFM\UserRegistrationServlet?actionField=logout&userId=<%=user.getId()%>">Logout</a>
</td> 
</tr>

<tr> 
<td>
<%= msg%>
</td> 
</tr>
</table>
</form>
</body>
</html>