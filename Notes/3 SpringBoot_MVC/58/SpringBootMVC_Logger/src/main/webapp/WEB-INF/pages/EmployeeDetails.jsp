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
	<c:forEach items="${list}" var="e"> <!-- List is comming from /all path Model attribute -->
		<tr>
			<td>${e.eid}</td>
			<td>${e.ename}</td>
			<td>${e.esal}</td>
			<td>${e.email}</td>
			<td>${e.dept}</td>
			<td>${e.hra}</td>
			<td>${e.da}</td>
			<td><a href="edit?eid=${e.eid}">EDIT</a></td>
			<td><a href="delete?eid=${e.eid}">DELETE</a></td>
		</tr>
	</c:forEach>
	</table>
	${message}<br>
	<c:if test="${!page.isFirst()}">
	<a href="?page=0">FIRST</a> &nbsp; &nbsp;
	</c:if>
	<c:if test="${page.hasPrevious()}">
	<a href="?page=${page.getNumber()-1}">Previous</a> &nbsp; &nbsp;
	</c:if>
	<c:forEach var="i" begin="0" end="${page.getTotalPages()-1}">
		<a href="?page=${i}">${i+1}</a> &nbsp; &nbsp;
		</c:forEach>
		<c:if test="${page.hasNext()}">
	<a href="?page=${page.getNumber()+1}">Next</a> &nbsp; &nbsp;
	</c:if>
		<c:if test="${!page.isLast()}">
	<a href="?page=${page.getTotalPages()-1}">LAST</a> &nbsp; &nbsp;
	</c:if>
		<hr>
</body>
</html> 