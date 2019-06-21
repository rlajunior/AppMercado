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

<div style="background-color:#534b91;color:#fff;padding:10px;font-size:20px;" class="header">
AppMercado
</div>
<div class="menu" style="border-bottom:1px solid #eee;padding:10px;background-color:#eee;">
	<form action="MenuController" method="post">
 		<button type="submit" class="btn btn-default" name="tela" value="loja">Loja</button>
 		<button type="submit" class="btn btn-default" name="tela" value="supervisor">Supervisor</button>
 		<button type="submit" class="btn btn-default" name="tela" value="eletronico">Eletronico</button>
 		<button type="submit" class="btn btn-default" name="tela" value="padaria">Padaria</button>
 	</form>
</div>
	<div class="container">
	
	<h3 style="border-bottom:1px dashed #eee;margin-bottom:10px;">Cadastrar Loja</h3>

		<div style="float:right;">
			  <form action="LojaController" method="get">
	   	 <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			</form>
		</div>
		<br>
	  <form action="LojaController" method="POST">
	  	
	  	 <div class="form-group">
	      <label for=nome>Nome </label>
	      <input type="text" class="form-control" id="nome" placeholder="Entre com o nome da Loja" name="nome">
	    </div>
	    <div class="form-group">
	      <label for="endereco">Endereço</label>
	      <input type="text" class="form-control" id="endereco" placeholder="Entre com o Endereço" name="endereco">
	    </div>
	    <div class="form-group">
	      <label for="bairro">Bairro</label>
	      <input type="text" class="form-control"  id="bairro" placeholder="Entre com o Bairro" name="bairro">
	    </div> 
	
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>