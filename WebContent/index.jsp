<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Aula Java Web 01</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
	<style>
		main {
			margin-top: 2%;
		}
	</style>
</head>
<body>
	<main class="container">
		<div class="jumbotron col-md-6 text-center col-md-offset-3">
			<h1>Hello World</h1>
			<!-- Scriptlets -->
			<% //<?php
				out.println("<h2>Programando em Java EE</h2>");
			 //?> %>
			 
			 <!-- 
			 	<?php ?> - bloco de código
			 	<?= $nome ?> - saída de dados
			  -->
			  
			  <h3><%= "Primeira aula Java Web" %></h3>
		</div>
	</main>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>