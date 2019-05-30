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
	  <form action="EletronicoController" method="get">
	    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
	
		<hr>
	  </form>
	  <form action="EletronicoController" method="POST">
	
	    <div class="form-group">
	      <label for="local">local:</label>
	      <input type="text" class="form-control" id="local" placeholder="Entre com o Locals" name="local">
	    </div>
	
	    <div class="form-group">
	      <label for="localRetirada">localretirada:</label>
	      <input type="text" class="form-control" id="localRetirada" placeholder="Entre com local Retirada" name="localRetirada">
	    </div>
	
	    <div class="form-group">
	      <label for="anoGarantia">anogarantia:</label>
	      <input type="text" class="form-control" id="anoGarantia" placeholder="Entre com que ano vai a garantia" name="anoGarantia">
	    </div>
	
	    <div class="form-group">
	      <label for="possuiGarantia">possuigarantia:</label>
	      <input type="text" class="form-control" id="possuiGarantia" placeholder="Possui Garantia" name="possuiGarantia">
	    </div>
	
	    <button type="submit" class="btn btn-success">Cadastrar</button>
	  </form>
	</div>
</div>
</body>
</html>