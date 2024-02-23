
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SYENA-INFOSOFT</h3>
<form action="register" method="post">
	<pre>
	 Employee Id:     <input type="number" name="eid">
	 Employee Name:   <input type="text" name="ename">
	 Employee Salary: <input type="number" name="esal">
	 GEN  : <input type="radio" name="empGen" value="Female" /> Female      <input type="radio" name="empGen" value="Male" /> Male

    DEPT :  <select name="empDept">
			<option value="">-SELECT-</option>
			<option value="DEV">DEV</option>
			<option value="QA">QA</option>
			<option value="BA">BA</option>
		    </select> 

    ADDR :  <textarea name="empAddr"></textarea>

    LANGS: <input type="checkbox" name="empLang" value="ENG" /> ENG    <input type="checkbox" name="empLang" value="HIN" /> HIN    <input type="checkbox" name="empLang" value="TEL" /> TEL    <input type="checkbox" name="empLang" value="TAM" /> TAM
	
    PROJ:
	        <select name="empProj" multiple>
			<option value="HTC">HTC</option>
			<option value="NIT">NIT</option>
			<option value="XYZ">XYZ</option>
			<option value="ORCL">ORCL</option>
			<option value="SEM">SEM</option>
	        </select>				

    COLOR:  <input type="color" name="empColor"/>
    DATE :  <input type="date" name="empDte"/>
    TIME :  <input type="time" name="empTme"/>
    FILE :  <input type="file" name="empFile"/>

		<button>Register</button>
	</pre>
</form>
</body>
</html>