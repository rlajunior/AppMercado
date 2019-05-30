<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Criar</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
	  <form action="SupervisorController" method="get">
	    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
	
		<hr>
	  </form>
	  <form action="SupervisorController" method="POST">
	
	    <div class="form-group">
	      <label for="nome">nome:</label>
	      <input type="text" class="form-control" id="nome" placeholder="Entre com o nome" name="nome">
	    </div>
	
	    <div class="form-group">
	      <label for="email">email:</label>
	      <input type="text" class="form-control" id="email" placeholder="Entre com o email" name="email">
	    </div>
	
	    <div class="form-group">
	      <label for="anoEntrada">anoEntrada:</label>
	      <input type="text" class="form-control" id="anoEntrada" placeholder="Entre com ano de entrada" name="anoEntrada">
	    </div>
	    
	    <div class="form-group">
	      <label for="ativo">ativo:</label>
	      <input type="text" class="form-control" id="ativo" placeholder="Usuario esta Ativo" name="ativo">
	    </div>
	
	    <button type="submit" class="btn btn-success">Cadastrar</button>
	  </form>
	</div>
</div>
</body>
</html>