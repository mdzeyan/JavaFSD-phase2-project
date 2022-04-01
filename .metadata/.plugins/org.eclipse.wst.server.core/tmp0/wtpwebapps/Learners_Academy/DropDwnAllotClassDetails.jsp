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

	<h2 align="center">Drop Down List</h2>
	
	
	<%
		List <ClassBean> list = (List<ClassBean>) request.getAttribute("listOfStdObj");
	%>
	
	<hr>
	
	<br><br>
	
	<div align="center">
	
		<label>Select Teacher</label>
		<select>
		
			
			
			<%
			  for(ClassBean bean : list)
			  {
		    %>
		      <option value="<%=bean.getAllocatedSubject() %>"><%=bean.getAllocatedTeacher() %></option>
		    <%
			  }
		    %>
		
		</select>
	
	</div>
	
	<br><br>
	
	<div align="center">
	
		<label>Select Class</label>
		<select>
		
			
			
			<%
			  for(ClassBean bean : list)
			  {
		    %>
		      <option value="<%=bean.getAllocatedSubject() %>"><%=bean.getAllocatedClass() %></option>
		    <%
			  }
		    %>
		
		</select>
	
	</div>

</body>
</html>