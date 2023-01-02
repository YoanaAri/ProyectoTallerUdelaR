<%@page import="service.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="media/resources/styles.css">
        <!-- <link href="../resources/output.css" rel="stylesheet"> -->
	</head>
	<body class="bg-gray-200">
		<jsp:include page="/WEB-INF/jsp/nav.jsp" />
		
		<div class="d-flex ">
			<%
			List<String> departamentos = (List<String>) request.getAttribute("departamentos");
			List<String> actividades = (List<String>) request.getAttribute("actividades");
			String dep =(String) request.getAttribute("dep");
			String act =(String) request.getAttribute("act");
			request.setAttribute("dep", dep);
			request.setAttribute("act", act);
			String error =(String) request.getAttribute("error");
			Boolean existeSal = ("SalYaExiste".equals(error));
			Boolean fechasSal = ("errorEnFechas".equals(error));
			String nombre = request.getParameter("nombre");
			//String fechaAlta = request.getParameter("fechaAlta");
			String fechaSalida = request.getParameter("fechaSalida");
			String lugarSalida = request.getParameter("lugarSalida");
			String cantTuristas = request.getParameter("cant");


			%>
			<div class="d-flex mt-5 flex-row menu">
				<jsp:include page="/WEB-INF/jsp/menu.jsp" />
			</div>
	
			<div style="width: 60%;" class="d-flex flex-column mt-3 p-4 align-content-center justify-self-center align-self-center shadow2 ">
	
				<h1 class="titulos mb-8 align-self-center align-items-center">Alta
					de salida turística.</h1>
				<form class="d-flex flex-column">
				<%if ("SalYaExiste".equals(error)){ %>
            	<label style="font-size: 3rem"" class="form-label">Error: Ya existe una salida turística con ese nombre.
	            	</label>
	            	<%} else if (fechasSal) {%>
	            	
	            	<label style="font-size: 3rem"" class="form-label">Error: La fecha de alta no puede ocurrir antes que la fecha de salida
	            	</label>
	            	<%} %>
				<%
				if (actividades == null && nombre == null) {
				%>
	
					<label for="dep" class="form-label">Departamento:
	    				<select class="form-control" id="dep" name="dep" required> 
	    					<%for(String departamento: departamentos){
	    						%>
	    					<option value="<%=departamento%>"><%= departamento %></option>
	    					<%} %>
	    				</select>

	            	</label>
					<label for="enviar" class="form-label m-3">
            			<input type="submit" class="form-control" id="enviar" value="Seleccionar Departamento" style="background-color: rgb(13 148 136); color:white;">
            		</label>
					<%
					} else {
					%>
	
					<label for="dep" class="form-label">Actividad:
	    				<select class="form-control" id="dep" name="act" required> 
	    					<%for(String actividad: actividades){
	    						%>
	    					<option value="<%=actividad%>"><%=actividad%></option>
	    					<%} %>
	    				</select>

	            	</label>
	            	<label for="nombre" class="form-label">Nombre: 
	            		<input type="text" class="form-control" id="nombre" name="nombre" <%if (nombre != null){ %>value=<%=nombre%><%} %> required>
					</label>
					<label for="fechaSalida" class="form-label">Fecha de salida: 
						<input type="datetime-local" class="form-control"id="fechaSalida" name="fechaSalida" <%if (fechaSalida != null){ %>value=<%=fechaSalida%><%} %> required>
					</label> 
					<label for="salida" class="form-label">Lugar de salida:
						<input type="text" class="form-control" id="salida" name="lugarSalida" <%if (lugarSalida != null){ %>value=<%=lugarSalida%><%} %> required>
					</label> 
					<label for="cant" class="form-label">Cantidad de turistas:
						<input type="number" class="form-control" id="cant" name="cant" <%if (cantTuristas != null){ %>value=<%=cantTuristas%><%} %> required>
					</label> 
					<label for="imagen" class="form-label">Imagen:</label> <input
						type="file" id="imagen" name="imagen"
						accept="image/png, image/jpeg"> 
					<input type="hidden" id="mode" name="dep" value="<%=dep%>">
					<label for="enviar" class="form-label m-3">
            			<input type="submit" class="form-control" id="enviar" value="Registrar Actividad" style="background-color: rgb(13 148 136); color:white;">
            		</label>
	
				</form>
	
			</div>
			<%
			}
			%>
	
		</div>
	
	
	</body>
</html>
