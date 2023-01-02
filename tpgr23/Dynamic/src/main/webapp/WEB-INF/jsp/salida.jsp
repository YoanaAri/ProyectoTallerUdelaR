
<%@ page import= "service.DepartamentoService" %>
<%@ page import= "service.DepartamentoServiceService" %>
<%@ page import= "service.UsuarioService" %>
<%@ page import= "service.UsuarioServiceService" %>
<%@ page import= "service.DtUsuario" %>
<%@ page import= "service.DtSalida" %>
<%@ page import= "service.DtTurista" %>

<%@ page import="java.time.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
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
    	<jsp:include page="/WEB-INF/jsp/nav.jsp"/>	
    	 <div class="d-flex mt-5 flex-row">
        	<div class="menu">
    			<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
    		</div>    
    	<% 	DtSalida salida = (DtSalida) request.getAttribute("salida"); 
    		LocalDateTime hoy = (LocalDateTime) request.getAttribute("hoy");
    		DateTimeFormatter formatoOutput = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm");
    	%>
			<div style="width: 60%;" class="d-flex flex-column mt-5 p-4 align-content-center justify-self-center align-self-center shadow2 ">
            	
            	<h3 class="align-items-center"> <%=salida.getNombre() %></h3>
            	
            	<div>
            		
            		<img class="img-thumbnail" style="width:395px; height:267px;" src="https://s3.amazonaws.com/turismorocha/operadores/1/med/bahia-resto-053888900-1458674720.JPG" alt="Imagen salida turistica">
	            	
            	</div>
            	
            	<div class="d-flex flex-column mt-3">
            	
            		<p> <b>Fecha de salida: </b> <%=salida.getSalida().getFechaString() %></p>
	            	<p> <b>Cantidad máxima de turistas: </b> <%= salida.getCupos() %> </p>
	            	<p> <b>Lugar de salida: </b> <%=salida.getSalida().getLugarSalida() %></p>
            		<p> <b>Fecha de alta: </b> <%=salida.getFechaAltaString() %> </p>
            	</div>
            	
            	<div class="d-flex flex-column align-items-end">
            	
            		
            		<% 	DtUsuario user = (DtUsuario) request.getSession().getAttribute("usuario");
            			
            		if ( user!=null && (user.getClass() == DtTurista.class) && (salida.getCuposRestantes()!=0) && (hoy.isAfter(LocalDateTime.parse(salida.getSalida().getFechaString())))) {
            			%>
            			<a href="./Tinscripcion.html" class="entrada">Inscribirse a esta salida</a>
            			<% } %>
            		   		
            		<a href="/DynamicTurismo.uy/ConsultaActividad?name=<%=request.getAttribute("nombreAct")%>&dep=<%=request.getAttribute("nombreDep")%>">Consultar actividad turística.</a>
            		
            	</div>
            	
            </div> 
		
		</div>
		
       
    </body>
</html>
