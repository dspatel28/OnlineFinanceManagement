<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Summary</title>
</head>
<% 	
	User user = (User) request.getAttribute("user");
	List<OtherExpenses> expenses = (List<OtherExpenses>) request.getAttribute("expenses");
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
%>
<body>
<form>
<h2 align="center">Account Summary</h2>
<table align="center">

<tr>
<td colspan="5" align="right"><b> Welcome <%=user.getFirstName()%>  <%=user.getLastName()%>,</b></td>
</tr>

<tr>
<td>
<label for="type"><b>&nbsp;&nbsp;&nbsp;&nbsp;Type&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
</td>
<td>
<label for="dueDate"><b>&nbsp;&nbsp;&nbsp;&nbsp;Due Date&nbsp;&nbsp;&nbsp;&nbsp;</b> </label>
</td>
<td>
<label for="amount"><b>&nbsp;&nbsp;&nbsp;&nbsp;Amount&nbsp;&nbsp;&nbsp;&nbsp;</b> </label>
</td>
<td>
<label for="paid"><b>&nbsp;&nbsp;&nbsp;&nbsp;Paid?&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
</td>
<td>
<label for="paymentDate"><b>&nbsp;&nbsp;&nbsp;&nbsp;Payment Date&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
</td>
</tr>

<% for(int i = 0; i < expenses.size(); i+=1) { %>
	<tr>      
		<td align="center"><%=expenses.get(i).getName()%></td>
    	<td align="center"><%=df.format(expenses.get(i).getPaymentDate())%></td>
    	<td align="center"><%=expenses.get(i).getAmount()%></td>
    	<td align="center"><%
    			String paid = "";
    			if(expenses.get(i).getPaid()) 
    			{
    				paid = "Yes";
    			} 
    			else 
    			{
    				paid = "No";
    			}%><%=paid%></td>
    	<td align="center"><%=df.format(expenses.get(i).getPaymentDate())%></td>
   	</tr>
<%}%>

<tr>
<td align="center" colspan="5">
<a href="\OFM\UserRegistrationServlet?actionField=goToHome&userId=<%=user.getId()%>">Go To Home</a>
</td>
</tr>


</table>
</form>
</body>
</html>