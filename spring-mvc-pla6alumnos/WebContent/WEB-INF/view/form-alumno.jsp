<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Alumnos</title>
<style>
.error {
color: red;
}
</style>
</head>
<body> 
	<form:form action="mostraralumno" modelAttribute="alumno">
	<table>
		<tr>
			<td width="100">Nombre:</td> <td><form:input path="nombre" size="60" maxlength="60"/></td>
			<td><form:errors path="nombre" cssClass="error" /> </td>
			
		</tr>
		<tr>
			<td>DNI:</td> <td><form:input path="dni" size="11" maxlength="9" /></td>
			<td><form:errors path="dni" cssClass="error" /> </td>
		</tr>
		<tr>
			<td>E-Mail:</td> <td><form:input path="email" size="60" maxlength="60"/></td>
			<td><form:errors path="email" cssClass="error" /> </td>
		</tr>
		<tr>
			<td>Becado:</td> 
			<td> <form:radiobuttons path="becado"
				items="${alumno.listaBecados}" />
			</td>
			<td><form:errors path="becado" cssClass="error" /> </td>
		</tr>
		<tr>
			<td>Asignaturas</td>
			<td><form:checkboxes path="asignaturas"
				items="${alumno.listaAsignaturas}" />
			</td>
			<td><form:errors path="asignaturas" cssClass="error" /> </td>
		</tr> 
	</table>
	    		
		<input type="submit">
	
	</form:form>
</body>
</html>