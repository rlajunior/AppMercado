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
</body>
</html>
