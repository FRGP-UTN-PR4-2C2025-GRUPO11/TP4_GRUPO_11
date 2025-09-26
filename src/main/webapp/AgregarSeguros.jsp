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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<a href="Inicio.jsp">Inicio</a> |
	<a href="ServletSeguros?addSeguro=1">Agregar Seguros</a> |
	<a href="ServletListar?listar=1">Listar Seguros</a>
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
	<form action="ServletSeguros" method="get" class="formularioSeguro">
	
		<div class="formulario_field">
			<label>Id Seguro:</label> 
			<span><b><%=daoSeguro.proximoIdSeguro()%></b></span>
		</div>
		
		<div class="formulario_field">
			<label for="description">Descripción:</label> 
			<input type="text" name="description" required />
		</div>
		
		
		<div class="formulario_field">
		<label for="typeSeguro">Tipo de Seguro:</label>
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
		</div>
		
		<div class="formulario_field">
			<label for="constoContratacion">Consto contratación:</label> 
			<input type="number" name="constoContratacion" required min="1" step="0.01" />
		</div>
		
		<div class="formulario_field">
			<label for="maxConstoAsegurado">Consto Máximo Asegurado:</label>
			<input type="number" name="maxConstoAsegurado" required min="1" step="0.01" />
		</div>
		
		<div class="formulario_field">
    		<input type="submit" value="Aceptar" name="btnSend" />
		</div>

		<br><br>
		<% 
		int filas = 0;
		if(request.getAttribute("cantFilas") != null)
		filas = (int)request.getAttribute("cantFilas"); 
		%>
  	    
		<%
		if(filas== 1){ 
		%>
		Seguro agregado correctamente
		<%
		}
		%>
	</form>
</body>
</html>
