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

<h2 align="center">All Subject Details</h2>

	<%
		List <SubjectBean> list = (List<SubjectBean>) request.getAttribute("listOfStdObj");
	%>
	
	<table align="center" border="1">
	
		<tr>
			<td>SlNo:</td>
			<td>Subject Name:</td>
		</tr>
		
		<%
			for(SubjectBean bean : list)
			{
		%>
		
			<tr>
				<td><%=bean.getSlNo() %></td>
			    <td><%=bean.getSubjectName() %></td>
			</tr>
		
		<%
			}
		%>
		
	</table>

</body>
</html>