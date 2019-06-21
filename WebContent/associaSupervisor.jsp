<%@page import="negocio.Loja"%>
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
	
		<div class="container">
			  <form action="AssociaSupervisorController" method="get">
			  
			  	<h2>${loja.nome}</h2>
			  
			    <button style="float:right;margin-top:-40px;" type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			
				<hr>
			  </form>
				
				<%
				List<Supervisor> listaAssociados = (List<Supervisor>)request.getAttribute("listaAssociados");	
				List<Supervisor> lista = (List<Supervisor>)request.getAttribute("lista");	
			 	%> 
	
			<% String idLoja = (String)request.getAttribute("idLoja"); %>
			<div class="jumbotron" <% if (listaAssociados == null || listaAssociados.size() == 0){ out.println("style=\"display:none;\""); } %>>
			<h3>Supervisores associados</h3>
			
			
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome do Supervisor</th>
			        <th>email</th>
			        <th>Ano de entrada na empresa</th>
			        <th></th>
			        
			      </tr>
			    </thead>
			    <tbody>
				<%for(Supervisor item : listaAssociados){%>
			      <tr>
			        <td><%= item.getNome()%></td>
			        <td><%= item.getEmail()%></td>
			       	<td><%= item.getAnoEntrada()%></td>
			        <td>
			        
			        <form action = "AssociaSupervisorController" method = "post" >
			       		 <button type="submit" class="btn btn-default" name="op" value="desassociar">Desassociar</button>
			       		  <input type="hidden" name="idSupervisor" value="<%=item.getIdSupervisor()%>">
			       		 <input type="hidden" name="idLoja" value="<%=idLoja%>"/>
			       	</form>
			        
			        </td>
			      <%}%>	
			    </tbody>
			</table>
			</div>
			
			
			<% if (listaAssociados == null || listaAssociados.size() == 0){ %>
			<br><br><br>
			
			<div class="jumbotron" <% if (lista == null || lista.size() == 0){ out.println("style=\"display:none;\""); } %>>
			<h3>Supervisor não associados</h3>
			
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome do Supervisor</th>
			        <th>email</th>
			        <th>Ano de entrada na empresa</th>
			        <th>Associa Supervisor</th>
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
			       	<form action = "AssociaSupervisorController" method = "post" >
			       		 <button type="submit" class="btn btn-default" name="op" value="associar">Associar</button>
			       		  <input type="hidden" name="idSupervisor" value="<%=item.getIdSupervisor()%>">
			       		 <input type="hidden" name="idLoja" value="<%=idLoja%>"/>
			       	</form>
			        </td>
			      </tr>
			    <%}%>	
			    </tbody>
			</table>
			
			<a href="supervisorDetalhe.jsp?idLoja=<%=idLoja%>">Não encontrei o supervisor</a>
			<% } %>
		</div>
	</div>
</body>
</html>