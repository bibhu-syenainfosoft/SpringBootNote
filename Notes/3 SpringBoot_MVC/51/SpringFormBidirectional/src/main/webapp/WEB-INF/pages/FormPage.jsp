<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SYENA-INFOSOFT</h3>
<form:form action="save" method="post" modelAttribute="employee2">
	<pre>
		ID   : <form:input path="empId"/>
		NAME : <form:input path="empName"/>
		SAL  : <form:input path="empSal"/>
		PWD  : <form:password path="empPwd"/>
		GEN  : 
			<form:radiobutton path="empGen" value="Male"/> Male
			<form:radiobutton path="empGen" value="Female"/> Female
		
		DEPT : <form:select path="empDept">
					<form:option value="">-SELECT-</form:option>
					<form:option value="QA">QA</form:option>
					<form:option value="BA">BA</form:option>
					<form:option value="DEV">DEV</form:option>
				</form:select>
		ADDR: <form:textarea path="empAddr"/>
		
		LANGS: 
			<form:checkbox path="empLang" value="ENG"/> ENG
			<form:checkbox path="empLang" value="FRE"/> FRE
			<form:checkbox path="empLang" value="ITA"/> ITA
		
		PROJ : <form:select path="empProj" multiple="multiple">
					<form:option value="HTC">HTC</form:option>
					<form:option value="NIT">NIT</form:option>
					<form:option value="ORCL">ORCL</form:option>
					<form:option value="IBM">IBM</form:option>
				</form:select>
	

		        <button>Register</button>
	</pre>
</form:form>
</body>
</html>