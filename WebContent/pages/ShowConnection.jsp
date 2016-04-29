<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ofm.beans.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connection Details</title>
</head>
<% 	
	User user = (User) request.getAttribute("user");
	List<Connection> connections = (List<Connection>) request.getAttribute("connections");
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
%>
<body>

<form>
<h2 align="center">Connection Details</h2>
<table align="center">

<tr>
<td colspan="4" align="right"><b> Welcome <%=user.getFirstName()%>  <%=user.getLastName()%>,</b></td>
</tr>

<tr>
<td>
<b>&nbsp;&nbsp;&nbsp;&nbsp;Registration Number&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td>
<td>
 <b>&nbsp;&nbsp;&nbsp;&nbsp;Type Of Connection&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td>
<td>
<b>&nbsp;&nbsp;&nbsp;&nbsp;Name Of Supplier&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td>
<td>
<b>&nbsp;&nbsp;&nbsp;&nbsp;Starting date of Connection&nbsp;&nbsp;&nbsp;&nbsp;</b>
</td>
</tr>

<% for(int i = 0; i < connections.size(); i+=1) { %>
	<tr>      
    	<td align="center"><a href="\OFM\UserRegistrationServlet?actionField=viewConnection&connectionId=<%=connections.get(i).getId()%>"><%=connections.get(i).getRegistrationNo()%></a></td>
    	<td align="center"><%=connections.get(i).getType()%></td>
    	<td align="center"><%=connections.get(i).getSupplierName()%></td>
    	<td align="center"><%=df.format(connections.get(i).getStartDate())%></td>
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