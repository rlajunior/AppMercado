<%@page import="modelo.Produto"%>
<%@page import="negocio.Loja"%>
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

<style>

.panelBox{

	padding:10px;
	padding-left:30px;
	padding-right:30px;
	background-color:#eee;
	border-radius:20px;
	margin-top:60px;

}



</style>

</head>
<body>
	<div
		style="background-color: #534b91; color: #fff; padding: 10px; font-size: 20px;"
		class="header">AppMercado</div>
	<div class="menu"
		style="border-bottom: 1px solid #eee; padding: 10px; background-color: #eee;">
		<form action="MenuController" method="post">
			<button type="submit" class="btn btn-default" name="tela"
				value="loja">Loja</button>
			<button type="submit" class="btn btn-default" name="tela"
				value="supervisor">Supervisor</button>
			<button type="submit" class="btn btn-default" name="tela"
				value="eletronico">Eletronico</button>
			<button type="submit" class="btn btn-default" name="tela"
				value="padaria">Padaria</button>
		</form>
	</div>



	<div class="container">

		<h3 style="margin-bottom: 10px;">${loja.nome}</h3>
		<h4 style="border-bottom: 1px dashed #eee; margin-bottom: 10px;font-weight: italic !important;color:#ccc;">Associar
			Produtos</h4>

		<div style="float: right;">
			<form action="AssociaProdutoController" method="get">
				<button style="float: right;" type="submit"
					class="btn btn-default" name="op" value="back">Voltar</button>
			</form>
		</div>

		<%
			List<Produto> lista = (List<Produto>) request.getAttribute("lista");
			List<Produto> listaAssociados = (List<Produto>) request.getAttribute("listaAssociados");
		%>

		<%
			String idLoja = (String) request.getAttribute("idLoja");
		%>
		<div class="panelBox"
			<%if (listaAssociados == null || listaAssociados.size() == 0) {
				out.println("style=\"display:none;\"");
			}%>>
			<h3>Produtos associados</h3>


			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome do produto</th>
						<th>Peso do produto</th>
						<th>Valor do produto</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Produto item : listaAssociados) {
					%>

					<tr>
						<td><%=item.getNome()%></td>
						<td><%=item.getPeso()%></td>
						<td><%=item.getValor()%></td>

						<td>

							<form action="AssociaProdutoController" method="post">
								<button type="submit" class="btn btn-danger" name="op"
									value="desassociar">Desassociar</button>
								<input type="hidden" name="idProduto"
									value="<%=item.getIdProduto()%>"> <input type="hidden"
									name="idLoja" value="<%=idLoja%>" />
							</form>

						</td>

					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		
		

		<div class="panelBox"
			<%if (lista == null || lista.size() == 0) {
				out.println("style=\"display:none;\"");
			}%>>
			<h3>Produtos para serem associados</h3>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome do produto</th>
						<th>Peso do produto</th>
						<th>Valor do produto</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Produto item : lista) {
					%>

					<tr>
						<td><%=item.getNome()%></td>
						<td><%=item.getPeso()%></td>
						<td><%=item.getValor()%></td>
						<td>
							<form action="AssociaProdutoController" method="post">
								<button type="submit" class="btn btn-default" name="op"
									value="associar">Associar</button>
								<input type="hidden" name="idProduto"
									value="<%=item.getIdProduto()%>"> <input type="hidden"
									name="idLoja" value="<%=idLoja%>" />
							</form>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>