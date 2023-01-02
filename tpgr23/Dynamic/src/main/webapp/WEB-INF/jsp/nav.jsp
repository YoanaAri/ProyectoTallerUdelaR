<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.Login"%>
<%@page import="service.*" %>
<nav class="navbar bg-light">
 		<div class="container-fluid">
	   		<a href="/DynamicTurismo.uy/home" class="navbar-brand titulos">Turismo.uy</a>
	   		<form class="d-flex" role="search">
	     			<input class="form-control me-2 menu" type="search" placeholder="Search" aria-label="Search">
	     			<button class="btn btn-outline-success" type="submit">Search</button>
	   		</form>
   		<%
   			//Fabrica fabrica = Fabrica.getInstance();
   			//IControladorUsuario ICU = fabrica.getIControladorUsuario();
			DtUsuario usr = (DtUsuario) session.getAttribute("usuario_logueado");
			if (usr == null) {
		%>
			<div>
	        	<!-- <a href="/servlets/Usuarios" class="entrada">Iniciar Sesion</a> -->
	        	<a href="/DynamicTurismo.uy/IniciarSesion" class="entrada">Iniciar Sesion</a>
	        	|
	        	<a href="/DynamicTurismo.uy/AltaUsuarioServlet" class="entrada">Registrarse</a>
	    	</div>
		<%
			}else {
		%>
			<div>
		 		<a href="/DynamicTurismo.uy/Usuarios?user=<%=usr.getNickname()%>" class="entrada"><%=usr.getName()%> <%=usr.getLastName()%></a>
         		|
         		<a href="/DynamicTurismo.uy/CerrarSesion" class="entrada">Cerrar Sesion</a>
            
        	</div>
	 	<%
			}
		%>
		</div>
</nav>