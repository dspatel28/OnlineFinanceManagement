<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Details</title>
</head>
<% 	
	User user = new User();
	user = (User) request.getAttribute("user");
%>
<body>
<form  action="\OFM\UserRegistrationServlet" method="post">
<h2 align="center">Add Bank Details</h2>
<table align="center">

<tr>
<td colspan="2" align="right"><b> Welcome <%=user.getFirstName()%>  <%=user.getLastName()%>,</b></td>
</tr>

<tr>
<td> <label for="name">Name of the Bank</label>
</td>
<td> <input type="text" name="name" id="name" size="30" value=""/>
</td>
</tr>
 
<tr>
<td>
<label for="branch">Branch</label>
</td>
<td>
<input type="text" name="branch" id="branch" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="accountNumber">Account Number</label>
</td>
<td>
<input type="text" name="accountNumber" id="accountNumber" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="accountOpenDate">Account Opening Date</label>
</td>
<td>
<input type="text" name="accountOpenDate" id="accountOpenDate" size="30" value="" />
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

<tr> <td align="right">
<input type="submit" name="button1" value="Add"/>
<input type="hidden" name="userId" id="userId" value="<%=user.getId()%>"/>
<input type="hidden" id="actionField" name="actionField" value="addBankDetails"/>
</td> 
<td>
<input type="reset" name="button2" value="Clear"/>
</td>
</tr>

<tr>
<td align="center" colspan="2">
<a href="\OFM\UserRegistrationServlet?actionField=goToHome&userId=<%=user.getId()%>">Go To Home</a>
</td>
</tr>

</table>
</form>
</body>
</html>