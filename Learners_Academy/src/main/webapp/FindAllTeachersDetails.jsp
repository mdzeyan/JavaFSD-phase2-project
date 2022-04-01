<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.learnersacademy.bean.*" %>
<%@page import="java.util.List" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 align="center">All Student Details</h2>

	<%
		List <TeacherBean> list = (List<TeacherBean>) request.getAttribute("listOfStdObj");
	%>
	
	<table align="center" border="1">
	
		<tr>
			<td>SlNo:</td>
			<td>First Name:</td>
			<td>Last Name:</td>
		</tr>
		
		<%
			for(TeacherBean bean : list)
			{
		%>
		
			<tr>
				<td><%=bean.getSlNo() %></td>
			    <td><%=bean.getFirstName() %></td>
				<td><%=bean.getLastName() %></td>
			</tr>
		
		<%
			}
		%>
		
	</table>

</body>
</html>