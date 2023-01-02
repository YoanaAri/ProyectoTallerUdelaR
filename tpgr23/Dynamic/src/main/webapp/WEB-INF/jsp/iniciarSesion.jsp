<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="media/resources/styles.css">
       <!--  <link href="/dist/output.css" rel="stylesheet">  -->
    </head>
    <body class="bg-gray-200">
	    <jsp:include page="/WEB-INF/jsp/nav.jsp"/>
        <div class="d-flex mt-5 flex-row">
            <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
            
            <div class="w-full d-flex flex-row align-items-center justify-content-center">
                <form class="d-flex flex-column shadow2 p-5 align-self-center align-items-center" method="POST">
                    <h1 class="titulos mb-8">Iniciar Sesion en Turismo.uy</h1>
                    <p class="mb-2 subtitulos">Usuario</p>
                    <input class=" border w-full py-2  pl-9 pr-3  form-control" placeholder="Mail o Nickname" type="text" name="usuario"/>
                    <p class="mt-4 mb-2 subtitulos">Contraseña</p>
                    <input class=" border w-full py-2  pl-9 pr-3 form-control" placeholder="Contraseña" type="password" name="password"/>
                    <button  class="botones mt-4"> Iniciar Sesion</button>
                    <a href="/DynamicTurismo.uy/AltaUsuarioServlet" class="entrada align-self-end">Registrarse</a>
                </form>
            </div>
        </div>
    </body>
</html>