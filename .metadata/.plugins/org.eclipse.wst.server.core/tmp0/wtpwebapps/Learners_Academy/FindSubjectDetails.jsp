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

<h2 align="center">Subject Details</h2>

	<%
		SubjectBean bean = (SubjectBean) request.getAttribute("stdObj");
	%>
	
	<table align="center">
		<tr>
			<td>SlNo:</td>
			<td><%=bean.getSlNo() %></td>
		</tr>
		<tr>
			<td>Subject Name:</td>
			<td><%=bean.getSubjectName() %></td>
		</tr>
	
	</table>

</body>
</html>