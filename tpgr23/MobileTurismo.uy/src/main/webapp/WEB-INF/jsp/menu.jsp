<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.Login"%>
<%@page import="service.*" %>
<%@page import="java.util.*"%>
<div class="d-flex mt-5 flex-row menu">
	            <ul class="ml-4 p-4  shadow2 ">
	            <%
	            DtUsuario usr = (DtUsuario) session.getAttribute("usuario_logueado");
				
				%>
	            	<li ><a href="/DynamicTurismo.uy/Usuarios?user=<%=usr.getNickname()%>"><h4 class="titulos">Mi Perfil</h4></a></li>
	            	 
	                %>
	                <li ><a href="/DynamicTurismo.uy/Inscripcion"><h4 class="titulos">Inscripcion Salida</h4></a></li>
	                <%
	          
	                %>
	                <li>
	                    <div class="pb-4">
	                        <h3 class="titulos">Departamentos</h3>
	                        <ul class="">
	                        	<% 
	                        	Set<String> departamentos = (Set<String>) session.getAttribute("departamentos");
	                        	if(departamentos != null){
	                        		for(String departamento: departamentos){
	                        	%>
	                            <li><a href="/DynamicTurismo.uy/ConsultaActividad?dep=<%=departamento%>" class="subtitulos"><%=departamento%></a></li>	
	                            <%
	                            } 
	                        	}
	                            %>                            
	                        </ul>
	                    </div>
	                </li>
	                <li>
	                    <div class="pb-4">
	                        <h3 class="titulos">Categorias</h3>
	                        <ul class="">
	                        	<% 
	                        	Set<String> categorias = (Set<String>) session.getAttribute("categorias");
	                        	if(categorias != null){
	                        	for(String categoria: categorias){
	                        	%>
	                            <li><a href="/DynamicTurismo.uy/ConsultaActividad?cat=<%=categoria%>" class="subtitulos"><%=categoria%></a></li>
	                            <%
	                            } 
	                        	}
	                            %> 	                
	                        </ul>
	                    </div>
	                </li>
	                <li ><a href="/DynamicTurismo.uy/Usuarios" class="titulos">Usuarios</a></li>
	                <li><a href="/DynamicTurismo.uy/ConsultaActividad" class="titulos">Actividades</a></li>
	                <li><a href="/DynamicTurismo.uy/ConsultaSalidaServlet" class="titulos">Salidas </a></li>
	            </ul>
	         </div>
		