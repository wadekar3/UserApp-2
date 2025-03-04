<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="App2.test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	String msg = (String) request.getAttribute("msg");
	out.println("Page belongs to Admin : " + ab.getfName() + "<br>");
	out.println(msg);
	%>
	<a href="Employee.html">AddEmployee</a>
	<a href="view">ViewAllEmployees</a>
	<a href="logout">Logout</a>

</body>
</html>