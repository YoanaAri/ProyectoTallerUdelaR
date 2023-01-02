<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.Login"%>
<%@page import="service.*" %>
<!--Navbar-->
<script>
function myFunction() {
	  var x = document.getElementById("myLinks");
	  if (x.style.display === "block") {
	    x.style.display = "none";
	  } else {
	    x.style.display = "block";
	  }
	}
</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Top Navigation Menu -->
<div class="topnav p-1 d-flex flex-row justify-content-between">
  <!-- Navigation links (hidden by default) -->
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
  <a href="/MobileTurismo.uy/home" class="active titulos py-1 px-2">Turismo.uy</a>
</div>
  <div id="myLinks" style="display: none;">
  	<ul class="pl-3">
	    <li> <a href="/MobileTurismo.uy/ConsultaActividad">Ver Actividades Turísticas</a> </li>
	    <li> <a href="/MobileTurismo.uy/ConsultaSalidaServlet">Ver Salidas</a> </li>
	    <li> <a href="/MobileTurismo.uy/CerrarSesion">Salir</a> </li>
  	</ul>
  </div>