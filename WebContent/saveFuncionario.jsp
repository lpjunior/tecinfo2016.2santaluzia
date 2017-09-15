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
			<legend>Gerenciamento de Funcionários</legend>
			<form action="prd/cadastrar" method="post">
				<div class="form-group">
					<label for="id_nome">Nome do Funcionario</label> <input type="text"
						class="form-control" name="nmproduto" id="id_nome"
						placeholder="Informe o nome">
				</div>
				<div class="form-group">
					<label for="id_email">E-mail do Funcionario</label> <input
						type="email" class="form-control" name="email" id="id_email"
						placeholder="Informe o e-mail">
				</div>
				<div class="form-group">
					<label for="id_login">Login do Funcionario</label> <input
						type="text" class="form-control" name="login" id="id_login"
						placeholder="Informe o login">
				</div>
				<c:if test="${funcionario eq null}">
					<div class="form-group">
						<label for="id_senha">Senha do Funcionario</label> <input
							type="password" class="form-control" name="senha" id="id_senha"
							placeholder="Informe a senha">
					</div>
				</c:if>
				<button type="submit" class="btn btn-default btn-block">Enviar</button>
			</form>
		</fieldset>
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