<%@page import="negocio.Padaria"%>
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
		
			<h3 style="border-bottom:1px dashed #eee;margin-bottom:10px;">Listagem de Produtos (Padaria)</h3>

		<div style="float:right;">
			    	  <form action="PadariaController" method="get">
			    <button type="submit" class="btn btn-default">Cadastrar</button>
			    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			</form>
		</div>
		
		
		<br>
			

				<%
				List<Padaria> lista = (List<Padaria>)request.getAttribute("lista");
			 	%> 
	<% if (lista != null && lista.size() >0){ %>
			<table class="table table-striped">
			    <thead>
			      <tr>
			        
				 	<th>Nome do produto</th>
		 			<th>Peso do produto</th>
		 			<th>Valor do produto</th>
			        <th>Departamento</th>
			        <th>Local de retirada do produto</th>
			        <th>Nome Atendente</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
				<%for(Padaria item : lista){%>
				<input type="hidden" name="idConta"value"<%=item.getIdProduto()%>">
			      <tr>
			        <td><%= item.getNome()%></td>
			        <td><%= item.getPeso()%></td>
			        <td><%= item.getValor()%></td>
			        <td><%= item.getLocalDepartamento()%></td>
			        <td><%= item.getLocaRetirada()%></td>
			        <td><%= item.getNomeAtendente()%></td>
			        <td>
			       		<a href="ExcluirPadariaController?id=<%= item.getIdProduto() %>" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Remover</a>
			        </td>
			      </tr>
			  	<%}%>	
			    </tbody>
			</table>
			<% }else { %>
				<div class="alert alert-warning" style="margin-top:70px">Não existem produtos(padaria) cadastrados.</div>
			<% } %>
		</div>

</body>
</html>