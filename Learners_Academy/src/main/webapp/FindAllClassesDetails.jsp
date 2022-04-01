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

<h2 align="center">All Class Details</h2>

	<%
		List <AddClassBean> list = (List<AddClassBean>) request.getAttribute("listOfStdObj");
	%>
	
	<table align="center" border="1">
	
		<tr>
			<td>SlNo:</td>
			<td>Class Name:</td>
		</tr>
		
		<%
			for(AddClassBean bean : list)
			{
		%>
		
			<tr>
				<td><%=bean.getSlNo() %></td>
			    <td><%=bean.getClassName() %></td>
			</tr>
		
		<%
			}
		%>
		
	</table>

</body>
</html>