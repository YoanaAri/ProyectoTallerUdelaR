<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="service.*"%>
<%@ page import="java.time.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.util.*"%>
    <!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="media/resources/styles.css">
        <script src="media/resources/bootstrap.min.js"></script>
    </head>
    <body class="bg-gray-200">
	    <jsp:include page="/WEB-INF/jsp/nav.jsp"/>
        <div class="d-flex mt-5 flex-row">
        	<div class="menu">
	            <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
            </div>
            <div class="w-full d-flex flex-column align-items-center">
            	<h1 class="titulos mb-8 align-self-center align-items-center">USUARIO</h1>
            	<div>
	                <div class="d-flex flex-row p-4 align-items-center">
	                    <img alt="avatar usuario" src="media/img/usuario1.jpeg" class="actividades mr-3">
	                    <div class="d-flex flex-column">
	                    <%
	            			DateTimeFormatter formatoOutput = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm");
	                    	boolean esPerfil = (boolean) request.getAttribute("mi_perfil");
	                    	
	                    	DtUsuario user = (DtUsuario) request.getAttribute("usuario");
	                    	boolean hola = user !=null;
	                    	//if(!esPerfil){      		
	                    
	                    %>
	                                     
	                    
	                    	<h4 class="subtitulos"><%=user.getName() %></h4>
	                   		<p> 
	                   			<%=user.getNickname() %> / <%=user.getMail() %> <br> 
	                   			<b>Fecha de nacimiento:</b> <%=user.getDateString() %></p>
	                    </div>
	                </div>
	            <ul class="nav nav-tabs  shadow2" id="myTab" role="tablist">
					  <li class="nav-item" role="presentation">
					    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">Perfil</button>
					  </li>
					  <%
					  	if(user.getClass() == DtTurista.class){
					  		System.out.println("0000000000000000");
					  		System.out.println(user.getName());
					  	
					  %>
						  <li class="nav-item" role="presentation">
						    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">Salidas</button>
						  </li>
					  <%
					  		if(esPerfil){
					  			System.out.println("es perfil");	
					  		
					  %>
							  <li class="nav-item" role="presentation">
								<button class="nav-link" id="messages-tab" data-bs-toggle="tab" data-bs-target="#messages" type="button" role="tab" aria-controls="messages" aria-selected="false">Inscripciones</button>					  
							  </li>
					  <%
					  		}
					  	}
					  	else{
					  %>
						  <li class="nav-item" role="presentation">
						    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">Actividades</button>
						  </li>
					  <%
					  }
					  %>	  
				</ul>
				<div class="tab-content p-2" id="myTabContent">
					<div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
						<p>
						<%
						System.out.println("llega hasta aca");
						%>
							<b>Nombre:</b> <%=user.getName() %> <br>
							<b>Apellido:</b> <%=user.getLastName() %> <br>
							<b>Fecha de Nacimiento:</b><%=user.getDateString() %><br> 
							<b>Mail:</b><%=user.getMail() %><br>
							<%							
							if(user.getClass() == DtTurista.class){
								DtTurista turista = (DtTurista) user;
							%>
								<b>Nacionalidad:</b> <%=turista.getNacionalidad() %>
			
							<%}
							else{
								DtProveedor proveedor = (DtProveedor) user;
							%>
								<b>Descripcion: </b> <%=proveedor.getDescripcionGeneral() %> <br>
								<b>Link: </b> <%=proveedor.getLink() %>
							<%
							}							
							%>								
						</p>
					</div>
					<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
							<%
					  			if(user.getClass() == DtTurista.class){
					  				List<DtSalida> salidas = (List<DtSalida>) request.getAttribute("salidas");
		        					for(DtSalida salida: salidas){  
					  				
					  		%>
						<div class="d-flex flex-row p-4">
		                    		<img alt="degusta agosto" src="media/img/comida2.jpg" class="actividades mr-3 secundarias">
		                    		<div class="d-flex flex-column">		                    		
		                    			<h4 class="subtitulos"><%=salida.getNombre() %></h4>
		                   				<p>
		                   					<b>Dia y hora:</b> <%=salida.getSalida().getFechaString() %> <br>
		                   					<b>Cantidad Turistas maxima:</b> <%=salida.getCupos() %>
		                   				</p>
                    					<a href="/DynamicTurismo.uy/ConsultaSalidaServlet?nombreSalida=<%=salida.getNombre() %>&nombreUsuario=<%=user.getNickname()%>"><p class="entrada">Leer mas</p></a>						
                    				</div>
                    	</div> 
                    				<%
                    				}
					  			}else{
					  				List<DataActividad> actividades = (List<DataActividad>) (((DataMapActividad) request.getAttribute("actividades")).getActividades());
					  				for(DataActividad actividad: actividades){ 			
                    				%>
                    				<div class="d-flex flex-row p-4">
                    					<img alt="degusta agosto" src="media/img/comida2.jpg" class="actividades mr-3 secundarias">
                    					<div class="d-flex flex-column">
	                    					<h4 class="subtitulos"><%=actividad.getName() %></h4>
	                    					<p>
	                    						<b>Descripcion: </b> <%=actividad.getDescripcion() %><br>
	                    						<b>Cidudad: </b> <%=actividad.getCiudad() %><br>
	                    						<b>Duracion: </b> <%=actividad.getDuracion() %><br>
	                    						<b>Costo: </b> <%=actividad.getCosto() %><br>
	                    						<b>Estado: </b> <%=actividad.getEstado() %><br>
	                    						
	                    					</p>
	                    					<a href="/DynamicTurismo.uy/ConsultaActividad?name=<%=actividad.getName() %>"><p class="entrada">Leer mas</p></a>						
                    					</div>
                    				</div>
                    				<%
                    				}
					  			} 
					  			%>
                				</div>
                   			<%
                   			
                   			if(esPerfil && user.getClass() == DtTurista.class){
                   				List<DtInscripcion> inscripciones = (List<DtInscripcion>) request.getAttribute("inscripciones");
                   			%>
                   				<div class="tab-pane" id="messages" role="tabpanel" aria-labelledby="messages-tab" tabindex="0">
                   				<%
                   				for(DtInscripcion inscripcion: inscripciones){
                   				%>
	                   				<div class="d-flex flex-column p-4">                   				                				
                   						<h4 class="subtitulos">Inscripción <%=inscripcion.getSalidaTuristica().getNombre() %></h4>
                   						<br>
	                    					<p>
	                    						<b>Cantidad de Inscriptos: </b> <%=inscripcion.getCantidadInscriptos() %><br>
	                    						<b>Fecha de Inscripcion </b> <%=inscripcion.getFechaInscripcionString() %><br>
	                    						<b>Costo: </b> <%=inscripcion.getCosto()%><br>
	                    						<b>Cantidad de Inscriptos: </b> <%=inscripcion.getCantidadInscriptos() %><br>
	                    					</p>	                    					                   				
                   					</div>
                   				<%	
                   				}
                   				
                   				%>
                   		
                   				</div>                   				                  				
                			</div>
                   				
                   				<%
                   				} 
		                  		%>
					       
            </div>
        </div>
    </body>
</html>