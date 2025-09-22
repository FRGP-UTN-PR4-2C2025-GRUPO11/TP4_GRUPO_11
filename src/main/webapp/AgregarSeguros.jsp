<%@ page import="entidad.*"%>
<%@ page import="dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<a href="Inicio.jsp">Inicio</a> |
	<a href="">Agregar Seguros</a> |
	<a href="ListarSeguro">Listar Seguros</a>
	<hr>
	<h3>Agregar Seguro</h3>

	<!-- FORMULARIO PARA AGREGAR UN SEGURO -->
	<%
	DaoSeguro daoSeguro = new DaoSeguro();
	ArrayList<TipoSeguro> listTypes = null;
	

	if (request.getAttribute("listTipos") != null) {
		listTypes = (ArrayList<TipoSeguro>) request.getAttribute("listTipos"); 
	}
	%>
	<form action="" method="">
		<div class="formulario_field">
			<label>Id Seguro:</label> <label><b><%=daoSeguro.proximoIdSeguro()%></b></label>
		</div>
		<div class="formulario_field">
			<label for="description">Descripción:</label> <input type="text"
				name="description" required />
		</div>
		<select name="typeSeguro" id="typeSeguro">
			<option value="-1">-- Seleccionar --</option>
			<%
			if (listTypes != null) {
				for (TipoSeguro type : listTypes) {
			%>
			<option value="<%=type.getId()%>">
				<%=type.getDescripcion()%>
			</option>
			<%
			}
			}
			%>
		</select>
		<div class="formulario_field">
			<label for="constoContratacion">Consto contratación:</label> <input
				type="number" name="constoContratacion" required min="1" />
		</div>
		<div class="formulario_field">
			<label for="maxConstoAsegurado">Consto Máximo Asegurado:</label> <input
				type="number" name="maxConstoAsegurado" required min="1" />
		</div>
		<input type="submit" value="Enviar" name="btnSend" />
	</form>
</body>
</html>