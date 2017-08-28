<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<!-- request.getParameter equivale ao $_POST e $_GET -->
		<p>Nome: <%= request.getParameter("nome") %> </p>
		<p>Email: <%= request.getParameter("email") %> </p>
		<p>Telefone: <%= request.getParameter("telefone") %> </p>
	</div>
	</main>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>