<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="App2.test.AdminBean,App2.test.EmployeeBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>) session.getAttribute("alist");
	out.println("Page belongs to Admin : " + ab.getfName() + "<br>");
	if (al.size() == 0) {
		out.println("No Employees Available...<br>");
	} else {
		Iterator<EmployeeBean> it = al.iterator();
		while (it.hasNext()) {
			EmployeeBean eb = (EmployeeBean) it.next();
			out.println(eb.geteId() + "&nbsp&nbsp" + eb.geteName() + "&nbsp&nbsp" + eb.geteDesg() + "&nbsp&nbsp"
			+ eb.getbSal() + "&nbsp&nbsp" + eb.getHra() + "&nbsp&nbsp" + eb.getDa() + "&nbsp&nbsp" + eb.getTotSal()
			+ "<a href='edit?eid=" + eb.geteId() + "'> Edit </a>" + "<a href='delete?eid=" + eb.geteId()
			+ "'>Delete</a>" + "<br>");
		}
	}
	%>
	<a href="logout">Logout</a>

</body>
</html>