<%@page import="negocios.supervisor"%>
<%@page import="negocios.Infantil"%>
<%@page import="modelo.Video"%>
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
			  <form action="supervisorController" method="get">
			    <button type="submit" class="btn btn-default">Cadastrar</button>
			    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			
				<hr>
			  </form>
				
				<%
				List<supervisor> lista = (List<supervisor>)request.getAttribute("lista");
			 	%> 
	
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>Duração</th>
			        <th>Pais</th>
			        <th>Visualizações</th>
			        <th>Investimento</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
				<%for(supervisor item : lista){%>
				<form action="supervisorController" method="post">
					<input type="hidden" name="idConta" value="<%=item.getId()%>">
			      <tr>
			        <td><%=item.getNome()%></td>
			        <td><%=item.getDuracao()%> minutos</td>
			        <td><%=item.getPais()%> anos</td>
			        <td><%=item.getVisualizacao()%></td>
			        <td><%=item.getInvestimento()%></td>
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