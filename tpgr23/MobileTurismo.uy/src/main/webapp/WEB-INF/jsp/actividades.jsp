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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<script src="media/resources/consultaDepOCat.js"></script>
 <script type="text/javascript">

   function changeFunc() {
	   console.log("cambio");
    var selectBox = document.getElementById("departamentos");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    alert(selectedValue);
   }

  </script>
</head>
<body class="bg-gray-200">
	<jsp:include page="/WEB-INF/jsp/nav.jsp" />
	<div class="d-flex mt-5 justify-content-center">
	
		<!-- <div style="width: 70%"
			class="d-flex flex-column mt-3 p-4 align-content-center shadow2 "> -->
			<div class="w-full d-flex flex-column">
				<%
				List<String> departamentos = ((ListaString) request.getAttribute("departamentos")).getLista();
				List<String> categorias = ((ListaString) request.getAttribute("categorias")).getLista();
				%>
				<div class="w-6 d-flex flex-column p-4">
					<h1 class="titulos mb-8 align-self-center align-items-center">
						<%=request.getAttribute("ActOSal")%>
					</h1>
					<form class="d-flex flex-row">
						<label for="dep" class="form-label" id="textoDep">
							<select class="form-control m-0" style="width: 100%" id="departamentos" name="dep" onchange="submit" type="submit">
							  <option value="" selected disabled hidden>Departamentos</option>
								<%
								for (String departamento : departamentos) {
								%>
								<option value="<%=departamento%>"><%=departamento%></option>
								<%
								}
								%>
							</select>
						</label> 
						<label for="enviar" class="form-label align-self-end"> 
							<button class="btn"><i class="fa fa-search"></i></button>
						</label>
					</form>
					<form class="d-flex flex-row">
						<label for="cat" class="form-label" id="textoCat">
							<select class="form-control m-0" style="width: 100%" id="categorias" name="cat" onchange="submit" type="submit">
							  <option value="" selected disabled hidden>Categorias</option>
								<%
								for (String categoria : categorias) {
								%>
								<option value="<%=categoria%>"><%=categoria%></option>
								<%
								}
								%>
							</select>
						</label> 
						<label for="enviar" class="form-label align-self-end"> 
							<button class="btn"><i class="fa fa-search"></i></button>
						</label>
					</form>
				</div>
				
				<!-- //////////////// -->
			<%
				if ((request.getParameter("dep") != null) || (request.getParameter("cat") != null)) {
					Set<DataActividad> actividades = (Set<DataActividad>) request.getAttribute("actividades");
				%>
					<!-- <h1 class="titulos mb-8 align-self-center align-items-center">Actividades</h1> -->
					<%
					for (DataActividad actividad : actividades) {
					%>
					<div class="d-flex flex-column p-4">
						<img alt="degusta" src="media/img/degusta.jpg"
							class="actividades mr-3">
						<div>
							<h4><%=actividad.getName()%></h4>
							<%-- <p><%=actividad.getDescripcion()%></p> --%>
							<a href="./ConsultaActividad?name=<%=actividad.getName()%>"><p
									class="entrada">Leer más</p></a>
						</div>
					</div>
					<%
					}
				}
					%>
	
			<!-- //////////////// -->

			</div>

		</div>
	</div>
</body>
</html>