<%@page import="negocio.Supervisor"%>
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
			  <form action="SupervisorController" method="get">
			    <button type="submit" class="btn btn-default">Cadastrar</button>
			    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			
				<hr>
			  </form>
				
				<%
				List<Supervisor> lista = (List<Supervisor>)request.getAttribute("lista");
			 	%> 
	
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome do Supervisor</th>
			        <th>email</th>
			        <th>Ano de entrada na empresa</th>
			        <th>ativo</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
				<%for(Supervisor item : lista){%>
			      <tr>
			        <td><%= item.getNome()%></td>
			        <td><%= item.getEmail()%></td>
			       	<td><%= item.getAnoEntrada()%></td>
			        <td>
		        		<a href="ExcluirSupervisorController?id=<%= item.getId() %>" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
			        </td>
			      </tr>
				<%}%>	
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>