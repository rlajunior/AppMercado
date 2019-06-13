<%@page import="negocio.Loja"%>
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
			  <form id="formZoado" action="LojaController">
			    <button type="submit" class="btn btn-default">Cadastrar</button>
			    <button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			
				<hr>
			  </form>
				
				<%
				List<Loja> lista = (List<Loja>)request.getAttribute("lista");
			 	%> 
	
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome da Loja</th>
			        <th>Endere�o</th>
			        <th>Supervisor</th>
			        <th>Bairro</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
				<%for(Loja item : lista){%>
					<input type="hidden" name="idConta"value"<%=item.getIdLoja()%>">
			      <tr>
			        <td><%= item.getNome()%></td>
			        <td><%= item.getEndereco()%></td>
			        <td>
						<button onclick="Deletar()">Deletar</button>
						<button onclick="Editar()">Editar</button>
			        </td>
			     	<td><%= item.getBairro()%></td>		     
			        <td>
			        </td>
			      </tr>
			    <%}%>	
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">

function Deletar() {
	
	var objeto = document.getElementById('formZoado');
	
	objeto.attr('method', 'delete');
	
	
}

function Editar() {
	
	var objeto = document.getElementById('formZoado');

	objeto.attr('method', 'get');
	
	
}

</script>