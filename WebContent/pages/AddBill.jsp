<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Details</title>
</head>
<% 	
	User user = (User) request.getAttribute("user");
	List<Connection> connections = (List<Connection>) request.getAttribute("connections");
%>
<body>
<form action="\OFM\UserRegistrationServlet" method="post">
<h2 align="center">Add Bill Details</h2>
<table align="center">

<tr>
<td colspan="2" align="right"><b> Welcome <%=user.getFirstName()%>  <%=user.getLastName()%>,</b></td>
</tr>

<tr>
<td>
<label for="type"> Type of Connection</label>
</td>
<td>
<select name="type" id="type">

<% for(int i = 0; i < connections.size(); i+=1) { %>
	<option value="<%=connections.get(i).getId()%>"><%=connections.get(i).getType()%> (<%=connections.get(i).getSupplierName()%>)</option>
<%}%>
</select>
</td>
</tr>

<tr>
<td>
<label for="billAmount">Bill Amount</label>
</td>
<td>
<input type="text" name="billAmount" id="billAmount" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="dueDate"> Due date of Payment</label>
</td>
<td>
<input type="text" name="dueDate" id="dueDate" size="30" value=""/>
</td>
</tr>

<tr> 
<td align="center" colspan="2">
<input type="submit" name="button1" value="Add"/>
<input type="hidden" name="userId" id="userId" value="<%=user.getId()%>"/>
<input type="hidden" id="actionField" name="actionField" value="addBill"/>
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