<%@page import="negocio.Eletronico"%>
<%@page import="modelo.Produto"%>
<%@page import="java.util.List"%>
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
<title>Listar</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			  <form action="eletronicoController" method="get">
			    <button type="submit" class="btn btn-default">Cadastrar</button>
			    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			
				<hr>
			  </form>
				
				<%
				List<Eletronico> lista = (List<Eletronico>)request.getAttribute("lista");
			 	%> 
	
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>local</th>
			        <th>localRetirada</th>
			        <th>anoGarantia</th>
			        <th>possuiGarantia</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
				<%for(Eletronico item : lista){%>
				<form action="eletronicoControlle" method="post">
					<input type="hidden" name="idConta"value"<%=item.getId() %>">
			      <tr>
			        <td><%= item.getLocal()%></td>
			        <td><%=item.getLocaRetirada()%> </td>
			        <td><%=item.getAnoGarantia()%> </td>
			        <td><%=item.getPossuiGarantia()%></td>
			        <td>
			        	<button type="submit" class="btn btn-danger btn-xs">
			        		<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
			        	</button>
			        </td>
			      </tr>
			    </form>
				<%}%>	
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>