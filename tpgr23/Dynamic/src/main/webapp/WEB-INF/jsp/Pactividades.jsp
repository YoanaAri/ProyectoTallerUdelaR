<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="../resources/styles.css">
        <link href="/dist/output.css" rel="stylesheet">
    </head>
    <body class="bg-gray-200">
	    <nav class="navbar bg-light">
	  		<div class="container-fluid">
	    		<a href="./Pindex.html" class="navbar-brand titulos">Turismo.uy</a>
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
	            	<li ><a href="./Pperfil.html"><h4 class="titulos">Mi Perfil</h4></a></li>
	            	<li ><a href="./ProvAltaActividad.html"><h4 class="titulos">Alta Actividad</h4></a></li>
	            	<li ><a href="./ProvAltaSalida.html"><h4 class="titulos">Alta Salida</h4></a></li>
	                <li>
	                    <div class="pb-4">
	                        <h3 class="titulos">Departamentos</h3>
	                        <ul class="">
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Montevideo</h4></a></li>
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Rocha</h4></a></li>
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Canelones</h4></a></li>
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Maldonado</h4></a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li>
	                    <div class="pb-4">
	                        <h3 class="titulos">Categorias</h3>
	                        <ul class="">
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Aventura y Deporte</h4></a></li>
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Campo y Naturaleza</h4></a></li>
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Cultura y Patrimonio</h4></a></li>
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Gastronomia</h4></a></li>
	                            <li><a href="./Pactividades.html"><h4 class="subtitulos">Turismo Playas</h4></a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li ><a href="./Pusuarios.html"><h4 class="titulos">Usuarios</h4></a></li>
	                <li><a href="#"><h4 class="titulos">Paquetes</h4></a></li>
	                <li><a href="./Pactividades.html"><h4 class="titulos">Actividades</h4></a></li>
	                <li><a href="./Psalidas.html"><h4 class="titulos">Salidas</h4></a></li>
	            </ul>
            </div>
            <div class="w-full d-flex flex-column">
            	<h1 class="titulos mb-8 align-self-center align-items-center">Actividades</h1>
                <div class="d-flex flex-row p-4">
                    <img alt="degusta" src="./img/degusta.jpg" class="actividades mr-3">
                    <div>
                    	<h4>Degusta</h4>
                   		<p>Festival gastronomico de productos locales de Rocha</p>
                    	<a href="./Pactividad.html"><p class="entrada">Leer mas</p></a>
                    </div>
                </div>
                 <div class="d-flex flex-row p-4">
                    <img alt="teatro con sabores" src="./img/teatro-con-sabores.jpg" class="actividades mr-3">
                    <div>
                    	<h4>Teatro con Sabores</h4>
                   		<p>En el mes aniversario del Club Deportivo Union de Rocha te invitamos a una merienda deliciosa</p>
                    	<a href="./Pactividad.html"><p class="entrada">Leer mas</p></a>
                    </div>
                </div>              
            </div>
        </div>
    </body>
</html>