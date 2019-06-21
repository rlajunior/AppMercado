<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AppMercado</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<%
	boolean invalido = false;
	if(request.getAttribute("invalido") != null){
		invalido = (Boolean)request.getAttribute("invalido");
	}
	%>

<div style="background-color:#534b91;color:#fff;padding:10px;font-size:20px;" class="header">
AppMercado
</div>

	<div class="container" style="width:400px;">
		<h2>Autenticação</h2>
	  	<hr>
	  	<%if(invalido){%>
		<div class="container">
		  <div class="alert alert-danger">
		    <strong>Problema!</strong> Usuário não encontrato!!!
		  </div>
		</div>
	  	<%}%>
	  
		<form action="AcessoController" method="post">
		  <div class="form-group">
		    <label for="email">E-mail</label>
		    <input type="email" class="form-control" id="email" placeholder="Entre com o e-mail" name="email">
		  </div>
		
		  <div class="form-group">
		    <label for="senha">Senha</label>
		    <input type="password" class="form-control" id="senha" placeholder="Entre com a senha" name="senha">
		  </div>
		
		  <button type="submit" style="float:right;" class="btn btn-primary">Entrar</button>
		</form>
	</div>

</body>
</html>
