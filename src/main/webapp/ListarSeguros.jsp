<%@page import="entidad.*" %>
<%@page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP4 | Servlets</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="content">

	<a href="Inicio.jsp">Inicio</a> |
	<a href="ServletSeguros?addSeguro=1">Agregar Seguros</a> |
	<a href="ServletListar?listar=1">Listar Seguros</a>
	<hr>


<h1>"Tipo de seguros en la base de datos"</h1>
<form method="POST" action="">
Búsqueda por tipos de seguros: 
<select name="tipoSeguro">
<option selected value="1">Seguro de Casas</option>
<option value="2">Seguro de Vida</option>
<option value="3">Seguro de Motos</option>
</select>
<input type="submit" name="btnFiltrar" value="Filtrar">
</form>
<br>



<% 
ArrayList<Seguro> seguros = null;
if (request.getAttribute("listaSeguros") != null)
{
	seguros = (ArrayList<Seguro>) request.getAttribute("listaSeguros");
}

	if( seguros != null)
	{
%>

<table id="tablaSeguros">
<tr>
	<th>ID<br>Seguro</th><th>Descripción Seguro</th><th>Descripción<br>Tipo Seguro</th><th>Costo<br>Contratación</th><th>Costo<br>Asegurado</th>
</tr>
<% 
		for(Seguro seguro: seguros)
		{
			%>
			<tr>
				<td style="text-align: center"><%= seguro.getIdSeguro() %></td>
				<td style="width: 300px"><%= seguro.getDescripcion() %></td>
				<td><%= seguro.getIdTipodescripcion() %></td>
				<td style="text-align: right"><%= seguro.getCostoContrato() %></td>
				<td style="text-align: right"><%= seguro.getCostoAsegurado() %></td>
			</tr>
			<% 
		}
	}
%>

</table>

</div>

</body>
</html>