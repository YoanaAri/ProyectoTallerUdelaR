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
    </head>
    <body class="bg-gray-200">
		<jsp:include page="/WEB-INF/jsp/nav.jsp" />
		<div class="d-flex ">
		<% 
		List<String> departamentos = (List<String>) request.getAttribute("departamentos");
		String proveedor = (String) request.getAttribute("proveedor");
		List<String> categorias = (List<String>) request.getAttribute("categorias");
		String error = (String) request.getAttribute("error");
		Boolean errorEx = (error != null);
		String dep = request.getParameter("dep");
		String prov = request.getParameter("dep");
		String name =(String) request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String duracion = request.getParameter("duracion");
		String costo = request.getParameter("costo");
		String ciudad = request.getParameter("ciudad");
		//String fecha = request.getParameter("fecha");

		%>
			<div class="d-flex mt-5 flex-row menu">
				<jsp:include page="/WEB-INF/jsp/menu.jsp" />
			</div>
			<div style="width: 60%;" class="d-flex flex-column mt-3 p-4 align-content-center justify-self-center align-self-center shadow2 ">
            	
            	<h1 class="titulos mb-8 align-self-center align-items-center">Alta de actividad turística</h1>
            	
            	<form class="d-flex flex-column">
            	<%if ("ActYaExiste".equals(error)){ %>
            	<label style="font-size: 3rem"" class="form-label">Error: Ya existe una actividad con ese nombre.
	            	</label>
	            	<%} %>
            		<label for="dep" class="form-label">Departamento:
	    				<select class="form-control" id="dep" name="dep" required> 
	    					<%for(String departamento: departamentos){
	    						%>
	    					<option value="<%=departamento%>" <%if(errorEx && dep.equals(departamento)) {%>selected="selected"<%}%>><%= departamento %></option>
	    					<%} %>
	    				</select>

	            	</label>
	            	<input type="hidden" id="mode" name="prov" value="<%=proveedor%>">
	            	
	            	</label>
            	
            		<label for="nombre" class="form-label">Nombre:
	    				<input type="text" class="form-control" name="nombre" <%if (name != null){ %>value=<%=name%><%} %> required>
	            	</label>
	            	
	            	<label for="descripcion" class="form-label">Descripcion:
	    				<textarea class="form-control" rows="3" name="descripcion"  required><%if (descripcion != null){ %><%=descripcion%><%} %></textarea>
	            	</label>
            	
            		<label for="duracion" class="form-label">Duracion:
	    				<input type="number" class="form-control" name="duracion" <%if (duracion != null){ %>value=<%=duracion%><%} %> required>
	            	</label>
	            	
	            	<label for="costo" class="form-label">Costo:
	    				<input type="number" class="form-control" name="costo" <%if (costo != null){ %>value=<%=costo%><%} %> required>
	            	</label>
	            	
	            	<label for="ciudad" class="form-label">Ciudad:
	    				<input type="text" class="form-control" name="ciudad" <%if (ciudad != null){ %>value=<%=ciudad%><%} %> required>
	            	</label>
	            	
	            	<%-- <label for="ciudad" class="form-label">Fecha:
	    				<input type="date" class="form-control" name="fecha" <%if (fecha != null){ %>value=<%=fecha%><%} %> required>
	            	</label> --%>
	            	
	            	<label for="imagen" class="form-label">Imagen:</label>
	            		<input type="file" id="imagen" name="imagen" accept="image/png, image/jpeg">
            		
            		<div class="d-flex flex-column justify-content-between mt-3 p-2 border border-secondary rounded">
            			
            			<div > Categorias:</div>
            			
            			<div class="d-flex flex-row justify-content-around flex-wrap"> 
            				<% for(String categoria: categorias) {%>
            				<div class="form-check"> 
            			
							  <input class="form-check-input" type="checkbox" value="true" name="<%=categoria%>">
							  <label class="form-check-label" for="flexCheckDefault">
							    <%=categoria %>
							  </label>
							</div>
							<%} %>	

            			</div>
            			
            		
            		</div>
            		
            		<label for="enviar" class="form-label m-3">
            			<input type="submit" class="form-control" id="enviar" style="background-color: rgb(13 148 136); color:white;">
            		</label>
            		
            	</form>
            	
            </div> 
		
		</div>
		
       
    </body>
</html>