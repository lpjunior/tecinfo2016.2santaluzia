<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Gerenciamento de Produtos</legend>
			<form action="prd/cadastrar" method="post">
				<div class="form-group">
					<label for="id_nome">Nome do Produto</label> <input type="text"
						class="form-control" name="nmproduto" id="id_nome"
						placeholder="Informe o nome">
				</div>
				<div class="form-group">
					<label for="id_preco">Preço do Produto</label> <input type="number"
						class="form-control" name="preco" id="id_preco"
						placeholder="Informe o preço">
				</div>
				<div class="form-group">
					<label for="id_qtd">Quantidade do Produto</label> <input
						type="number" class="form-control" name="quantidade" id="id_qtd"
						placeholder="Informe a quantidade">
				</div>
				<div class="form-group">
					<label for="id_descproduto">Descrição do Produto</label>
					<textarea class="form-control" rows="3" name="descproduto" id="id_descproduto"
						placeholder="Informe a descrição"></textarea>
				</div>
				<button type="submit" class="btn btn-default btn-block">Enviar</button>
			</form>
		</fieldset>
		<a href="index.html" class="btn btn-warning">Voltar <span
									class="glyphicon glyphicon-send" aria-hidden="true"></span></a>
	</div>

	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- JS Bootstrap -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>