<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Details</title>
</head>
<% 	
	User user = (User) request.getAttribute("user");
	List<Bank> banks = (List<Bank>) request.getAttribute("banks");
%>
<body>
<form action="\OFM\UserRegistrationServlet" method="post">
<h2 align="center"> Add Bank Transaction</h2>
<table align="center">

<tr>
<td colspan="2" align="right"><b> Welcome <%=user.getFirstName()%>  <%=user.getLastName()%>,</b></td>
</tr>

<tr>
<td>
<label for="bank">Bank</label>
</td>
<td>
<select name="bankId" id="bankId">
<% for(int i = 0; i < banks.size(); i+=1) { %>
	<option value="<%=banks.get(i).getId()%>"><%=banks.get(i).getAccountNumber()%> (<%=banks.get(i).getName()%>)</option>
<%}%>
</select>
</td>
</tr>

<tr>
<td>
<label for="amount">Transaction Amount</label>
</td>
<td>
<input type="text" name="amount" id="amount" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="transactionDate">Date of Transaction </label>
</td>
<td>
<input type="text" name="transactionDate" id="transactionDate" size="30" value=""/>
</td>
</tr>

<tr>
<td>
<label for="type"> Type of Payment </label>
</td>
<td>
<select name="type" id="type">
<option value="C">Credit </option>
<option value="D">Debit </option>
</select>
</td>
</tr>


<tr> <td colspan="2" align="center">
<input type="submit" name="button1" value="Add"/>
<input type="hidden" name="userId" id="userId" value="<%=user.getId()%>"/>
<input type="hidden" id="actionField" name="actionField" value="addTransaction"/>
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