<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set scope="request" var="lista" value="${funcionarios}" />
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de Gerenciamento</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="../resources/css/estilo.css" media="all" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="jumbotron col-md-6 text-center col-md-offset-3">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>NOME</th>
						<th>EMAIL</th>
						<th>LOGIN</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="f" items="${lista}">
						<tr>
							<td><a href="buscar?id=${f.id}">${f.id}</a></td>
							<td>${f.nmFunc}</td>
							<td>${f.email}</td>
							<td>${f.login}</td>
							<td><a href="excluir?id=${f.id}">Remover <span
									class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${msg ne null}">
				<p style="color: green;">${msg}</p>
			</c:if>
			<a href="../index.html">Voltar <span
									class="glyphicon glyphicon-send" aria-hidden="true"></span></a>
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- JS Bootstrap -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
		<script
		src="../resources/js/script.js"></script>
</body>
</html>