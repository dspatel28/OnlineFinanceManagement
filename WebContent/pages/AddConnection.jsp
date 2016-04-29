<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connection Details</title>
</head>
<% 	
	User user = new User();
	user = (User) request.getAttribute("user");
%>
<body>
<form action="\OFM\UserRegistrationServlet" method="post">
<h2 align="center">Add Connection</h2>
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
<option value="gas">Gas</option>
<option value="electricity">Electricity</option>
<option value="phone">Phone</option>
<option value="internet">Internet</option>
</select>
</td>
</tr>

<tr>
<td>
<label for="supplierName"> Name Of Supplier</label>
</td>
<td>
<input type="text" name="supplierName" id="supplierName" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="startDate"> Starting date of connection</label>
</td>
<td>
<input type="text" name="startDate" id="startDate" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="registrationNo"> Registration Number</label>
</td>
<td>
<input type="text" name="registrationNo" id="registrationNo" size="30" value=""/>
</td>
</tr>

<tr><td align="center" colspan="2">
<input type="submit" name="button1" value="Add"/>
<input type="hidden" name="userId" id="userId" value="<%=user.getId()%>"/>
<input type="hidden" id="actionField" name="actionField" value="addConnection"/>


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