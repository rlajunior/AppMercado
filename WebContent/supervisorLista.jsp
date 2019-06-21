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
		
			<h3 style="border-bottom:1px dashed #eee;margin-bottom:10px;">Listagem de Supervisores</h3>

		<div style="float:right;">
			  <form action="SupervisorController" method="get">
			   
			    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			</form>
		</div>
		
		
			
				<%
				List<Supervisor> lista = (List<Supervisor>)request.getAttribute("lista");
			 	%> 
			
			<% if (lista != null && lista.size() > 0){ %>
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome do Supervisor</th>
			        <th>email</th>
			        <th>Ano de entrada na empresa</th>
			        <th>Ações</th>
		
			      </tr>
			    </thead>
			    <tbody>
				<%for(Supervisor item : lista){%>
			      <tr>
			        <td><%= item.getNome()%></td>
			        <td><%= item.getEmail()%></td>
			       	<td><%= item.getAnoEntrada()%></td>
			        <td>
			        <a href="ExcluirSupervisorController?id=<%= item.getIdSupervisor() %>" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Remover</a>
			        </td>
			      </tr>
				<%}%>	
			    </tbody>
			</table>
			
			<%}else{%>	
				<div class="alert alert-warning" style="margin-top:70px;">
				Não existem supervisores cadastrados
				</div>			
			<%}%>	
		</div>

</body>
</html>