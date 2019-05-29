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
	  <form action="DocumentarioController" method="get">
	    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
	
		<hr>
	  </form>
	  <form action="DocumentarioController" method="POST">
	
	    <div class="form-group">
	      <label for="nome">Nome:</label>
	      <input type="text" class="form-control" id="nome" placeholder="Entre com o nome" name="nome">
	    </div>
	
	    <div class="form-group">
	      <label for="duracao">Duração:</label>
	      <input type="text" class="form-control" id="duracao" placeholder="Entre com o duração" name="duracao">
	    </div>
	
	    <div class="form-group">
	      <label for="faixaEtaria">Pais:</label>
	      <input type="text" class="form-control" id="pais" placeholder="Entre com o pais" name="pais">
	    </div>

	    <div class="form-group">
	      <label for="visualizacoes">Visualizações:</label>
	      <input type="text" class="form-control" id="visualizacoes" placeholder="Entre com as visualizações" name="visualizacoes">
	    </div>
	
	    <div class="form-group">
	      <label for="avaliacao">Investimento:</label>
	      <input type="text" class="form-control" id="investimento" placeholder="Entre com o investimento" name="ivnestimento">
	    </div>
	
	    <button type="submit" class="btn btn-success">Cadastrar</button>
	  </form>
	</div>
</div>
</body>
</html>