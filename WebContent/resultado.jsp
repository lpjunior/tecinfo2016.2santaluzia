<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contato" value="${contatoCad}" scope="request" />
<!DOCTYPE>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Aula Java Web 01</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style>
main {
	margin-top: 2%;
}
</style>
</head>
<body>
	<main class="container">
	<div class="jumbotron col-md-6 text-center col-md-offset-3">
		<!-- EL - Expression Language -->
		<p>Nome: <c:out value="${contato.nome}"></c:out></p>
		<p>Email: <c:out value="${contato.email}"></c:out></p>
		<p>Telefone: <c:out value="${contato.telefone}"></c:out></p>
	</div>
	</main>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>