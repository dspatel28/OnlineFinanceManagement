<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Details</title>
</head>
<% 	
	User user = (User) request.getAttribute("user");
	List<Bank> banks = (List<Bank>) request.getAttribute("banks");
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
%>
<body>
<form>
<h2 align="center">Bank Details</h2>
<table align="center">


<tr>
<td colspan="4" align="right"><b> Welcome <%=user.getFirstName()%>  <%=user.getLastName()%>,</b></td>
</tr>

<tr>
<td>
<b>&nbsp;&nbsp;&nbsp;&nbsp;Name of the Bank&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td>
<td>
 <b>&nbsp;&nbsp;&nbsp;&nbsp;Branch of the Bank&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td>
<td>
<b>&nbsp;&nbsp;&nbsp;&nbsp;Account Number&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td>
<td>
<b>&nbsp;&nbsp;&nbsp;&nbsp;Account Opening Date&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td>
</tr>

<% for(int i = 0; i < banks.size(); i+=1) { %>
	<tr>      
    	<td align="center"><a href="\OFM\UserRegistrationServlet?actionField=viewBank&bankId=<%=banks.get(i).getId()%>"><%=banks.get(i).getName()%></a></td>
    	<td align="center"><%=banks.get(i).getBranch()%></td>
    	<td align="center"><%=banks.get(i).getAccountNumber()%></td>
    	<td align="center"><%=df.format(banks.get(i).getAccountOpenDate())%></td>
   	</tr>
<%}%>

<tr>
<td align="center" colspan="4">
<a href="\OFM\UserRegistrationServlet?actionField=goToHome&userId=<%=user.getId()%>">Go To Home</a>
</td>
</tr>

</table>
</form>
</body>
</html>