<%@page import="service.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="media/resources/styles.css">
<script src="media/resources/consultaDepOCat.js"></script>
</head>
<body class="bg-gray-200">
	<jsp:include page="/WEB-INF/jsp/nav.jsp" />
	<div class="d-flex mt-5 flex-row">
		<div class="menu">
			<jsp:include page="/WEB-INF/jsp/menu.jsp" />
		</div>
		<div style="width: 60%;"
			class="d-flex flex-column mt-3 p-4 align-content-center justify-self-center align-self-center shadow2 ">
			<div class="w-full d-flex flex-column">
				<%
				if ((request.getParameter("dep") != null) || (request.getParameter("cat") != null)) {
					Set<DataActividad> actividades = (Set<DataActividad>) request.getAttribute("actividades");
				%>
				<h1 class="titulos mb-8 align-self-center align-items-center">Actividades</h1>
				<%
				for (DataActividad actividad : actividades) {
				%>
				<div class="d-flex flex-row p-4">
					<img alt="degusta" src="media/img/degusta.jpg"
						class="actividades mr-3">
					<div>
						<h4><%=actividad.getName()%></h4>
						<p><%=actividad.getDescripcion()%></p>
						<a href="./ConsultaActividad?name=<%=actividad.getName()%>"><p
								class="entrada">Leer mas</p></a>
					</div>
				</div>
				<%
				}
				%>
				<%
				} else {
					
				List<String> departamentos = ((ListaString) request.getAttribute("departamentos")).getLista();
				List<String> categorias = ((ListaString) request.getAttribute("categorias")).getLista();
				%>
				<div class="w-6 d-flex flex-column">
					<h1 class="titulos mb-8 align-self-center align-items-center">
						Ver
						<%=request.getAttribute("ActOSal")%>
						por departamento o categoría:
					</h1>
					<div style="width: 60%;"
						class="d-flex flex-column mt-3 p-4 align-content-center justify-self-center align-self-center ">
						<div class="d-flex flex-row w-6 justify-content-around">
							<label for="departamento" class="form-label justify-self-start">Departamento
								<input onclick="eleccionCatODep()" type="radio" id="radioDep"
								name="user" value="departamento">
							</label> <label for="proveedor" class="form-label justify-self-end">Categoria
								<input onclick="eleccionCatODep()" type="radio" id="radioCat"
								name="user" value="departamento">
						</div>
					</div>
					<form class="d-flex flex-column">
						<label for="dep" class="form-label" id="textoDep" hidden="true">Departamento:
							<select class="form-control" id="departamentos" name="dep"
							hidden="true">
								<%
								for (String departamento : departamentos) {
								%>
								<option value="<%=departamento%>"><%=departamento%></option>
								<%
								}
								%>
						</select>
						</label> <label for="cat" class="form-label" id="textoCat" hidden="true">Categoria:
							<select class="form-control" id="categorias" name="cat"
							hidden="true">
								<%
								for (String categoria : categorias) {
								%>
								<option value="<%=categoria%>"><%=categoria%></option>
								<%
								}
								%>
						</select>
						</label> <label for="enviar" class="form-label m-3"> <input
							type="submit" class="form-control" id="botonDepOCat"
							hidden="true" value="Ver <%=request.getAttribute("ActOSal")%>"
							style="background-color: rgb(13, 148, 136); color: white;">
						</label>
					</form>
				</div>
				<%
				}
				%>

			</div>

		</div>
	</div>
</body>
</html>