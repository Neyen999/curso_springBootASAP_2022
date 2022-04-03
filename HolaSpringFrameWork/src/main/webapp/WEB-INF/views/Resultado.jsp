<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="container vh-100">
	
	<h2 class="text-center mb-5">Piedra Papel Tijera Lagarto Spock</h2>
	<div class="d-flex mb-2">
		<div class="w-50">
			<h3 class="text-center">La computadora eligió: ${computadora.getNombre()}</h3>
		</div>
		<div class="w-50">
			<h3 class="text-center">Tu elegiste: ${jugador.getNombre()}</h3>
		</div>
	</div>
	<br/>
	<br/>
	<div class="p-3 border border-primary rounded d-flex flex-column justify-content-center align-items-center">
		<h2 class="text-center m-0">El resultado es: </h2>
		<p class="text-center m-0">${resultado}</p>
	</div>
</body>
</html>