<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.learnersacademy.bean.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 align="center">Student Details</h2>

	<%
		StudentBean bean = (StudentBean) request.getAttribute("stdObj");
	%>
	
	<table align="center">
		<tr>
			<td>SlNo:</td>
			<td><%=bean.getSlNo() %></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><%=bean.getFirstName() %></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><%=bean.getLastName() %></td>
		</tr>
	
	</table>

</body>
</html>