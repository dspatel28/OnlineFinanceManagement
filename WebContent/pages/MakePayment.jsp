<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Details</title>
</head>
<%
	String msg = (String)request.getAttribute("msg");
	if (msg==null)
	{
		msg="";
	}
%>
<% 	
	User user = (User) request.getAttribute("user");
	List<OtherExpenses> expenses = (List<OtherExpenses>) request.getAttribute("expenses");
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
%>
<body>
<form>
<h2 align="center">Bill Details for Payment</h2>
<table align="center">
<tr>
<td>
<label for="type"><b>&nbsp;&nbsp;&nbsp;&nbsp;Type&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
</td>
<td>
<label for="amount"><b>&nbsp;&nbsp;&nbsp;&nbsp;Amount&nbsp;&nbsp;&nbsp;&nbsp;</b> </label>
</td>
<td>
<label for="amount"><b>&nbsp;&nbsp;&nbsp;&nbsp;Click here for Payment&nbsp;&nbsp;&nbsp;&nbsp;</b> </label>
</td>
</tr>

<% for(int i = 0; i < expenses.size(); i+=1) { %>
	<tr>      
		<td align="center"><%=expenses.get(i).getName()%></td>
    	<td align="center"><%=expenses.get(i).getAmount()%></td>
    	<td align="center"><a href="\OFM\UserRegistrationServlet?actionField=makePayment&id=<%=expenses.get(i).getId()%>&type=<%=expenses.get(i).getName()%>&userId=<%=user.getId()%>">Make Payment</a></td>
   	</tr>
<%}%>
<tr>
<td colspan="3">
<%=msg %>
</td>
</tr>

<tr>
<td align="center" colspan="3">
<a href="\OFM\UserRegistrationServlet?actionField=goToHome&userId=<%=user.getId()%>">Go To Home</a>
</td>
</tr>
</table>
</form>

</body>
</html>