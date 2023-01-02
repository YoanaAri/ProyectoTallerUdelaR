<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="service.*"%>
<%@page import="java.util.*"%>
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
            <div class="w-full d-flex flex-column align-items-center">
            	<h1 class="titulos mb-8 align-self-center align-items-center">Usuarios</h1>
            	<div>
            	<%
				  	List<DtUsuario> usuarios = (List<DtUsuario>) request.getAttribute("usuarios");
		        	for(DtUsuario usuario: usuarios){  
			     %>
				     <div class="d-flex flex-row p-4">
				     	<img alt="avatar usuario" src="media/img/usuario1.jpeg" class="actividades mr-3">
				     	<div class="d-flex flex-column">
				     		<h4 class="subtitulos"><%=usuario.getNickname() %></h4>
				     		
				     		<p>
				     			<b>Nombre: </b> <%=usuario.getName() %> <br>
				     		 	<b>Apellido: </b> <%=usuario.getLastName() %> <br> 
				     		 	<b>Mail: </b><%= usuario.getMail() %>
				     		</p>
				     		<a href="/DynamicTurismo.uy/Usuarios?user=<%=usuario.getNickname()%>" class="entrada">Leer mas</a>	                    		
				     	</div>
				     </div>	                
	                <%
	                }
	                %>             
	                
	             </div>       
            </div>
        </div>
    </body>
</html>