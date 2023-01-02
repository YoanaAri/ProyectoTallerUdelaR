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
    	 <jsp:include page="/WEB-INF/jsp/nav.jsp"/>	
    	 <div class="d-flex mt-5 flex-row">
        	<div class="menu">
    			<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
    		</div>    
	    <% 
	    	String departamento = (String)request.getAttribute("departamento");
	        DataActividad acti = (DataActividad)request.getAttribute("actividad"); 
	    	List<DtSalida> salidas = ((DataMapSalida) request.getAttribute("salidas")).getSalidas();
	    	boolean finalizable = (boolean) request.getAttribute("finalizable");
	    %>
            <div class="w-full d-flex flex-column align-items-center ">
            	<h1 class="titulos mb-8 align-self-center align-items-center mb-5">ACTIVIDAD</h1>
            	<div class="d-flex flex-row justify-content-around w-full">   
	            	<div class="d-flex flex-column p-4 mr-5">
                    	<img alt="degusta" src="media/img/degusta.jpg" class="actividades mr-3">
                    	<div>
                    		<h4 class="subtitulos"><%= acti.getName() %></h4>
                   			<p>
                   				<%= acti.getDescripcion() %><br>
                   				<b>Ciudad: </b> <%=acti.getCiudad() %><br>
	                    		<b>Duración: </b> <%=acti.getDuracion() %><br>
	                    		<b>Costo: </b> <%=acti.getCosto() %><br>
                   			</p>
                    	</div>                    
                	</div>
                	<div>
                		<h3 Class="importantes mb-3">Salidas</h3>
                		<%
                		for(DtSalida salida: salidas){ 
                		%>
                		<div class="d-flex flex-row">
	                		 <img alt="degusta" src="media/img/comida1.jpeg" class="secundarias mr-3 mb-3">
	                		 <a href="././ConsultaSalidaServlet?nombreActividad=<%= acti.getName() %>&nombreSalida=<%=salida.getNombre()%>&nombreDepartamento=<%=departamento%>&salidaDesdeActividad=true" class="align-self-center"><h4 class="subtitulos"><%=salida.getNombre() %></h4></a>
                		</div>        
                		<%
                		} 
                		%>        	
                		
                		<% 
                		List<DataActividad> listaActi = (List<DataActividad>) request.getAttribute("ListaActividadesF");
                		if(finalizable){
                			boolean esActiProv = false;
                			for(DataActividad activ: listaActi){
                				if(activ.getName().equals(acti.getName())){
                					esActiProv = true;
                				}
                			}
                			if (esActiProv) {
                			%>	
                		<a href="././ConsultaActividad?finalizarActividad=<%= acti.getName() %> "> Finalizar actividad.</a>
                		<% } 
                		}%>
                    </div>           	
                </div>       
            </div>
        </div>
    </body>
