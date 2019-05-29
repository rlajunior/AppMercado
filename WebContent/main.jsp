<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Inicial</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
  <form action="MenuController" method="post">
		<div class="jumbotron">
			<div class="container">
				<ul class="list-group">
				  <li class="list-group-item">
				  		<button type="submit" class="btn btn-default" name="tela" value="esporte">Padaria</button>
				  </li>
				  <li class="list-group-item">
				  		<button type="submit" class="btn btn-default" name="tela" value="documentario">Eletronico</button>
				  </li>
				  <li class="list-group-item">
				  		<button type="submit" class="btn btn-default" name="tela" value="monetizacao">Produto</button>
				  </li>
				</ul>
			</div>
		</div>
  </form>
</body>
</html>