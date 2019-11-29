<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Alumno</title>
</head>
<body>
<h1>Ficha de Alumno</h1>
	<table>
		<tr>
			<td width="100">Nombre:</td> <td>${alumno.nombre}</td>
		</tr>
		<tr>
			<td>DNI:</td> <td>${alumno.dni}</td>
		</tr>
		<tr>
			<td>E-Mail:</td> <td>${alumno.email}</td>
		</tr>
		<tr>
			<td>Becado:</td> <td>${alumno.becado}</td>
		</tr>
		<tr>
			<td>Asignaturas:</td> 
			<td>
				<c:forEach var="wAsign" items="${alumno.asignaturas}">
				<li>${wAsign}</li>
				</c:forEach>
			</td>
		</tr>
		
	</table>
		
</body>
</html>