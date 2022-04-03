<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Juego de Piedra Papel Tijera Lagarto Spock</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="container">
	<h1>Elige una opcion</h1>
	<form method="get" action="http://localhost:8080/HolaSpringFrameWork/resolverJuego">
		<select name="selOpcion">
			<c:forEach items="${opciones}" var="opcion">
				<option value="${opcion.getNumero()}">${opcion.getNumero()}- ${opcion.getNombre()}</option>
			</c:forEach>
		</select>
		<button class="btn btn-secondary" type="submit">Enviar</button>
	</form>
</body>
</html>