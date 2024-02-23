<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SYENA-INFOSOFT</h3>
${emp}<br><br>
<b>Employee Id:</b>${emp.eid}<br>
<b>Employee Name:</b>${emp.ename}<br>
<b>Employee Salary:</b>${emp.esal}<br><br>
${list}<br>
${list[0]}<br><br>
<table border="1">
	<tr>
		<th>EmpId</th>
		<th>EmpName</th>
		<th>EmpSal</th>
	</tr>
	<c:forEach items="${empTable}" var="e">
		<tr>
			<td>${e.eid}</td>
			<td>${e.ename}</td>
			<td>${e.esal}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>