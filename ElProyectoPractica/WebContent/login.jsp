<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String error =request.getParameter("error");
String mensajeError=""; 
if(error!=null){
	switch(error){
	case "01":
		mensajeError="No ha escrito un login";
		break;
	case "02":
		mensajeError="No ha escrito una contraseña";
		break;
	case "03":
		mensajeError="La contraseña no se ha escrito correctamente";
		break;
	case "04":
		mensajeError="Se han producido errores de servicios";
		break;
	case "05":
		mensajeError="No se tiene permiso para acceder";
		break;
	case "06":
		mensajeError="No se ha guardado de la Session";
		break;
	}
}
%>   
    
 
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<title>Los Libros Hueones</title>
</head>
<body>
	<div class="container">
		<div class="row text-center p-2 mb-lg-2 mt-lg-2">
			<div class="col-12">
				<h1>Logueate</h1>
			</div>
		</div>
		<form method="get" action="LoginFuncionamiento">
		<div class="row p-2 mb-lg-2 mt-lg-2">
			<div class="form-group col-12 mt-3 col-md-6 col-lg-6">
				<label for="loginElegido">Login</label> 
				<input type="text" placeholder="lolM2K" class="form-control" name="loginElegido" id="loginElegido">
			</div>
			<div class="form-group col-12 mt-3 col-md-6 col-lg-6">
				<label for="passwordElegido">Password</label> 
				<input type="password" placeholder="********" class="form-control" name="passwordElegido" id="passwordElegido">
			</div>
			<div class="col-12 col-md-6 col-xl-6 mt-3 text-center">
				<input type="submit" class="btn btn-success"/>
			</div>
			<div class="col-12 col-md-6 col-xl-6 mt-3 text-center">
				<input type="reset" class="btn btn-danger"/>
			</div>
		</div>		
		
		<div class="row text-center p-2 mb-lg-2 mt-lg-2" id="respuesta">
		<% 	if(mensajeError!=""){ %>
			<div class="col-12">
					<%=mensajeError%>
			</div>
		<% } %>
		</div>
		</form>
	</div>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>