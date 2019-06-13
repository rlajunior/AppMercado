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
	  <form action="LojaController" method="get">
	    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
	
		<hr>
	  </form>
	  <form action="LojaController" method="POST">
	  	
	  	 <div class="form-group">
	      <label for=nome>Nome da Loja:</label>
	      <input type="text" class="form-control" id="nome" placeholder="Entre com o nome da Loja" name="nome">
	    </div>
	    <div class="form-group">
	      <label for="endereco">Endere�o:</label>
	      <input type="text" class="form-control" id="endereco" placeholder="Entre com o Endere�o" name="endereco">
	    </div>
	    <div class="form-group">
	      <label for="bairro">Bairro:</label>
	      <input type="text" class="form-control"  id="bairro" placeholder="Entre com o Bairro" name="bairro">
	    </div> 
	
	    <button type="submit" class="btn btn-success">Cadastrar</button>
	  </form>
	</div>
</div>
</body>
</html>