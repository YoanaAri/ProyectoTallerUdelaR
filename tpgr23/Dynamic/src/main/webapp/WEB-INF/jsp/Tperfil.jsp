<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="../resources/styles.css">
        <script src="../resources/bootstrap.min.js"></script>
    </head>
    <body class="bg-gray-200">
	    <nav class="navbar bg-light">
	  		<div class="container-fluid">
	    		<a href="./Tindex.html" class="navbar-brand titulos">Turismo.uy</a>
	    		<form class="d-flex" role="search">
	      			<input class="form-control me-2 menu" type="search" placeholder="Search" aria-label="Search">
	      			<button class="btn btn-outline-success" type="submit">Search</button>
	    		</form>
	    		 <div class="">
                    <button class="entrada btnTexto" >Cerrar Sesion</button>           
                </div>
	 		</div>
		</nav>
        <div class="d-flex mt-5 flex-row">
        	<div class="menu">
	            <ul class="ml-4 p-4  shadow2">
	            	<li ><a href="./Tperfil.html"><h4 class="titulos">Mi Perfil</h4></a></li>
	            	<li ><a href="./Tinscripcion.html"><h4 class="titulos">Inscripcion Salida</h4></a></li>
	                <li>
	                    <div class="pb-4">
	                        <h3 class="titulos">Departamentos</h3>
	                        <ul class="">
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Montevideo</h4></a></li>
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Rocha</h4></a></li>
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Canelones</h4></a></li>
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Maldonado</h4></a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li>
	                    <div class="pb-4">
	                        <h3 class="titulos">Categorias</h3>
	                        <ul class="">
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Aventura y Deporte</h4></a></li>
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Campo y Naturaleza</h4></a></li>
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Cultura y Patrimonio</h4></a></li>
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Gastronomia</h4></a></li>
	                            <li><a href="./Tactividades.html"><h4 class="subtitulos">Turismo Playas</h4></a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li ><a href="./Tusuarios.html"><h4 class="titulos">Usuarios</h4></a></li>
	                <li><a href="#"><h4 class="titulos">Paquetes</h4></a></li>
	                <li><a href="./Tactividades.html"><h4 class="titulos">Actividades</h4></a></li>
	                <li><a href="./Tsalidas.html"><h4 class="titulos">Salidas</h4></a></li>
	            </ul>
            </div>
            <div class="w-full d-flex flex-column align-items-center">
            	<h1 class="titulos mb-8 align-self-center align-items-center">MI PERFIL</h1>
            	<div>
	                <div class="d-flex flex-row p-4 align-items-center">
	                    <img alt="degusta agosto" src="./img/usuario1.jpeg" class="actividades mr-3">
	                    <div class="d-flex flex-column">
	                    	<h4 class="subtitulos">Rosa María</h4>
	                   		<p> lachiqui / mirtha.legrand.ok@hotmail.com.ar <br> <b>Fecha de nacimiento:</b> 23/02/1927</p>
	                    </div>
	                </div>
	            <ul class="nav nav-tabs  shadow2" id="myTab" role="tablist">
					  <li class="nav-item" role="presentation">
					    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">Perfil</button>
					  </li>
					  <li class="nav-item" role="presentation">
					    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">Salidas</button>
					  </li>
				</ul>
				<div class="tab-content p-2" id="myTabContent">
		  			<div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
						<div class="d-flex flex-row">	
							<p><b>Nombre:</b> Rosa María </p>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen ml-2	" viewBox="0 0 16 16">
  								<path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
							</svg>
						</div>
						<div class="d-flex flex-row"> 
							<p><b>Apellido:</b> Martínez </p>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen ml-2" viewBox="0 0 16 16">
  								<path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
							</svg>
						</div>
						<div class="d-flex flex-row"> 
							<p><b>Fecha de Nacimiento:</b>23/02/1927 </p>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen ml-2" viewBox="0 0 16 16">
  								<path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
							</svg>
						</div>
							<p><b>Mail:</b> mirtha.legrand.ok@hotmail.com.ar</p>						
					</div>
					<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
						<div class="d-flex flex-row p-4">
                    		<img alt="degusta agosto" src="./img/comida2.jpg" class="actividades mr-3 secundarias">
                    		<div class="d-flex flex-column">
                    			<h4 class="subtitulos">Degusta Agosto</h4>
                   				<p><b>Dia:</b> 20/08/2022 <br> <b>Hora:</b> 17:00 <br> <b>Cantidad Turistas maxima:</b> 20</p>
                    			<a href="./Tsalida.html"><p class="entrada">Leer mas</p></a>
                    		</div>
                		</div>
					</div>
				</div>                  
	        	</div>       
            </div>
        </div>
    </body>
</html>