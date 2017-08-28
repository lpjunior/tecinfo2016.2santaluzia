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
	/*propriedade, são os 'elementos' que utilizamos para tratar o css.
	exemplo.. margin-top, float, display*/
	margin-top: 2%;
}
</style>
</head>
<body>
	<main class="container">
	<div class="jumbotron col-md-6 text-center col-md-offset-3">
		<fieldset>
			<legend>Cadastro de Contatos</legend>
			<!-- JSP - Java Server Pages (As páginas do Java) -->
			<form class="col-md-10 col-md-offset-1" action="cadastrar" method="post">
				<div class="form-group">
					<label for="id_nome">Nome</label> <input type="text"
						class="form-control" id="id_nome" name="nome" placeholder="Nome">
				</div>
				<div class="form-group">
					<label for="id_email">Email</label> <input type="email"
						class="form-control" id="id_email" name="email" placeholder="Email">
				</div>
				<div class="form-group">
					<label for="id_telefone">Telefone</label> <input type="tel"
						class="form-control" id="id_telefone" name="telefone" placeholder="Telefone">
				</div>
				<button type="submit" class="btn btn-success btn-block">Enviar</button>
			</form>
		</fieldset>
	</div>
	</main>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>