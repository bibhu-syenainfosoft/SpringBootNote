<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<h3>WELCOME TO SYENA-INFOSOFT</h3>
<h4>Employee Details:</h4>
<table border="1">
	<tr>
		<th>EmpId</th>
		<th>EmpName</th>
		<th>EmpSal</th>
		<th>EmpMail</th>
		<th>EmpDept</th>
		<th>hra</th>
		<th>da</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${lstEmp}" var="e">
		<tr>
			<td>${e.eid}</td>
			<td>${e.ename}</td>
			<td>${e.esal}</td>
			<td>${e.email}</td>
			<td>${e.dept}</td>
			<td>${e.hra}</td>
			<td>${e.da}</td>
			<td><a href="edit?eid=${e.eid}">Edit</a></td>
			<td><a href="delete?eid=${e.eid}">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	${message}
</body>
</html> 