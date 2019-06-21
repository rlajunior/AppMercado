<%@page import="modelo.Produto"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
	
		<h3 style="border-bottom:1px dashed #eee;margin-bottom:10px;">Listagem de Lojas</h3>

		<div style="float:right;">
			<form action="LojaController" method="get">
		  		<button type="submit" class="btn btn-default" name="op" value="cadastrar">Cadastrar</button>
				<button type="submit" class="btn btn-default" name="op" value="back">Voltar</button>
			</form>
		</div>
		
		<% if (request.getParameter("mensagemSucesso") != null ) { %>
		<div class="alert alert-success" style="margin-top:70px;">Loja cadastrada com sucesso!</div>
		
		<% } %>
		
		<% if (request.getParameter("msgSupervisorCadastrado") != null ) { %>
		<div class="alert alert-success" style="margin-top:70px;">Supervisor cadastrado com sucesso!</div>
		
		<% } %>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome da Loja</th>
					<th>Endereço</th>
					<th>Bairro</th>
					<th>Nome do Supervisor</th>
					<th>Quantidade de Produtos</th>
					<th>Ações</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Loja item : (List<Loja>)request.getAttribute("lista")) {
				%>
				<input type="hidden" name="idConta"value"<%=item.getIdLoja()%>">
				<tr>
					<td><%=item.getNome()%></td>
					<td><%=item.getEndereco()%></td>
					<td><%=item.getBairro()%></td>
					<td><%=item.getSupervisor() != null ? item.getSupervisor().getNome() : "---"%>

					</td>
					<td><%=item.getQtdProdutos()%></td>
					<td><a class="btn btn-default"
						href="AssociaProdutoController?idLoja=<%=item.getIdLoja()%>">Gerenciar
							Produtos</a></td>
					<td>
						<%
							if (item.getSupervisor() != null) {
						%>


						<form action="AssociaSupervisorController" method="post">
							<button type="submit" class="btn btn-danger" name="op"
								value="desassociar">Remover Supervisor</button>
							<input type="hidden" name="idSupervisor"
								value="<%=item.getSupervisor().getIdSupervisor()%>"> <input
								type="hidden" name="idLoja" value="<%=item.getIdLoja()%>" />
						</form> <%
 	} else {
 %> <a class="btn btn-default"
						href="AssociaSupervisorController?idLoja=<%=item.getIdLoja()%>">Cadastrar
							Supervisor</a> <%
 	}
 %>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>
</script>