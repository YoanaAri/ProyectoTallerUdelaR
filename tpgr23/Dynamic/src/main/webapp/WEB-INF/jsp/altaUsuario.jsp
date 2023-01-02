<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="media/resources/styles.css">
    	<script src="media/resources/radioButton.js"></script>
        <!-- <link href="../resources/output.css" rel="stylesheet"> -->
    </head>
    <body class="bg-gray-200">
    
    
    
	    <jsp:include page="/WEB-INF/jsp/nav.jsp"/>
		
		<div class="d-flex ">
		<%
		Boolean errorNick = "errorNick".equals(request.getAttribute("error"));
		Boolean errorCorreo = "errorCorreo".equals(request.getAttribute("error"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String nick = request.getParameter("nickname");
		String correo = request.getParameter("correo");
		String fechaNac = request.getParameter("fechaNac");

		%>
			<div class="d-flex mt-5 flex-row menu">
	        	<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
	         </div>
		
			<div style="width: 60%;" class="d-flex flex-column mt-5 p-4 align-content-center justify-self-center align-self-center shadow2 ">
            	<form class="d-flex flex-column">
            	<%if (errorNick){ %>
            	<label style="font-size: 3rem"" class="form-label">Error: Ya existe un usuario con ese Nick
	            	</label>
	            	<%} %>
	            	<form class="d-flex flex-column">
            	<%if (errorCorreo){ %>
            	<label style="font-size: 3rem"" class="form-label">Error: Ya existe un usuario con ese correo
	            	</label>
	            	<%} %>
            	<h3 class="titulos">Registrarse</h3>
            	
            	<form onsubmit ="return validateForm()" class="d-flex flex-column" method="POST" >
            	
	            	<label for="nombre" class="form-label">Nombre:
	    				<input name="nombre" type="text" class="form-control" id="nombre" <%if (nombre != null){ %>value=<%=nombre%><%} %> required>
	            	</label>
	            	
	            	<label for="apellido" class="form-label">Apellido:
	    				<input name="apellido" type="text" class="form-control" id="apellido" <%if (apellido != null){ %>value=<%=apellido%><%} %> required>
	            	</label>
	            	
	            	<label for="imagen" class="form-label">Avatar:</label>
	            		<input name="imagen" type="file" id="imagen" name="imagen" accept="image/png, image/jpeg">
	            	
	            	
	            	<label for="nickname" class="form-label mt-2">Nickname:
	    				<input name="nickname" type="text" class="form-control" id="nickname" <%if (nick != null){ %>value=<%=nick%><%} %> required>
	            	</label>
	            	
	            	<label for="correo" class="form-label">Correo electronico:
	    				<input name="correo" type="email" class="form-control" id="correo" <%if (correo != null){ %>value=<%=correo%><%} %> required>
	            	</label>
	            	
	            	<label for="password" class="form-label">Contraseña:
	    				<input name="password" type="password" class="form-control" id="password" onkeyup='check();' required>
	            	</label>
	            	
	            	<label for="passwordcon" class="form-label">Confirme la contraseña:
	    				<input name="passwordcon" type="password" class="form-control" id="passwordcon" onkeyup='check();' required>
	    				<span id='message'></span>
	            	</label>
            	
            		<label for="fechaNac" class="form-label">Fecha de nacimiento:
	    				<input name="fechaNac" type="date" class="form-control" id="fechaNac" <%if (fechaNac != null){ %>value=<%=fechaNac%><%} %> required>
	            	</label>
            	
            		<div class="d-flex flex-row w-full justify-content-around">
            			<label for="turista" class="form-label justify-self-start">Turista:
            				<input onchange="habilitacion()" type="radio"  id="turista" name="user" value="turista" required>
            			</label>
            			<label for="proveedor" class="form-label justify-self-end">Proveedor:
            				<input onchange="habilitacion()" type="radio"  id="proveedor" name="user" value="proveedor" required>
            			</label>
            		</div>
            		
            		
            		
            		
            		<label id="labelNacionalidad" for="nacionalidad" class="form-label" hidden="true">Nacionalidad:
	    				<input name="nacionalidad" type="text" class="form-control" id="nacionalidad">
	            	</label>
	            	
	            	
	            	
	            	<label id="labelDescripcion" for="descripcion" class="form-label" hidden="true">Descripcion:
	    				<textarea name="descripcion" class="form-control" rows="3" id="descripcion"></textarea>
	            	</label>
            	
            		<label id="labelLink" for="link" class="form-label" hidden="true">Link:
	    				<input name="link" type="url" class="form-control" id="link">
	            	</label>
	            	
	            	
            		
            		<label for="enviar" class="form-label m-3">
            			
            			<input type="submit" class="form-control" id="enviar" value="Registrarse" style="background-color: rgb(13 148 136); color:black;">
            		</label>
            	</form>
		
		</div>
		
       
    </body>
</html>
