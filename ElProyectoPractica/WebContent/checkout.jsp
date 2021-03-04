<%-- Página de confirmación del pedido --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.*, es.studium.practica.*"%>
<% String usuario=request.getParameter("usuario");  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<title>Confirmación</title>
</head>
<body>
	<div class="container">
		<div class="row text-right p-2 pt-3 mb-lg-2 mt-lg-2">
			<div class="col-12">
				<a href="/ElProyectoPractica/Deslogarse" class="btn btn-danger">Deslogarse</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				
			</div>
		</div>
		<div class="row">
			<div class="col-12 text-center">
				<h4 class="text-left">
					Bienvenido Usuario:
					<%if(usuario!=""){   %>
					<%=usuario %>
					<% } %>
				</h4>
				<h1 class="mt-3">Confirmacion</h1>
				<p class="mt-1">¿Confirma este pedido?</p>
			</div>
		</div>
		<div class="row text-center">
			<div class="col-12">
				<p>Has comprado los siguientes libros:</p>
			</div>
			<div class="col-12">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Título</th>
							<th scope="col">Autor</th>
							<th scope="col">Editorial</th>
							<th scope="col">Precio</th>
							<th scope="col">Cantidad</th>
						</tr>						
					</thead>
					<tbody>
					<%
						// Muestra los elementos del carrito
					ArrayList<ElementoPedido> cesta = (ArrayList<ElementoPedido>) session.getAttribute("carrito");
					for (ElementoPedido item : cesta) {
					%>
					<tr>
						<td><%=item.getTitulo()%></td>
						<td><%=item.getAutor()%></td>
						<td><%=item.getEditorial()%></td>
						<td><%=item.getPrecio()%> &euro;</td>
						<td><%=item.getCantidad()%></td>
					</tr>
					<%
						}					
					%>
					</tbody>
				</table>
			</div>
			<div class="col-12">
				<table class="table">
					<thead>
						<tr>
							<th colspan="2">Total</th>
						</tr>
						<tr>
							<th>Precio Total</th>
							<th>Cantidad Total</th>
						</tr>
					</thead>
					<tbody>
						<tr>							
							<th><%=request.getAttribute("precioTotal")%> &euro;</th>
							<th><%=request.getAttribute("cantidadTotal")%></th>
						</tr>
					</tbody>
				</table>
			</div>			
		</div>
		<div class="row text-center">
			<div class="col-6">
				<a class="btn btn-danger" href="/ElProyectoPractica/Carrito">Volver</a>
			</div>
			<div class="col-6">
				<a class="btn btn-primary" href="/ElProyectoPractica/EnviarPedido">Enviar</a>
			</div>
		</div>				
	</div>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

	
</body>
</html>