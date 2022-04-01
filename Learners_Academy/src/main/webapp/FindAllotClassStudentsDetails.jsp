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

<h2 align="center">Allocated Class Details</h2>

	<%
		List <ClassBean> list = (List<ClassBean>) request.getAttribute("listOfStdObj");
	%>
	
	<table align="center" border="1">
	
		<tr>
			<td>SlNo:</td>
			<td>Allocated Teacher:</td>
			<td>Allocated Subject:</td>
			<td>Allocated Class:</td>
		</tr>
		
		<%
			for(ClassBean bean : list)
			{
		%>
		
			<tr>
				<td><%=bean.getSlNo() %></td>
			    <td><%=bean.getAllocatedTeacher()%></td>
			    <td><%=bean.getAllocatedSubject()%></td>
			    <td><%=bean.getAllocatedClass()%></td>
			</tr>
		
		<%
			}
		%>
		
	</table>

</body>
</html>