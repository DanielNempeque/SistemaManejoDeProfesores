<%-- 
    Document   : validacionContraseña
    Created on : 28/05/2018, 08:57:54 PM
    Author     : Daniel Nempeque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Sistema de manejo de profesores</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- import cdns -->

        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


        <!-- fonts -->

        <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Orbitron:400,700" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- local css -->

        <link rel="stylesheet" href="public/css/animate.css">
        <link rel="stylesheet" href="public/css/titulacion.css">
        <link rel="stylesheet" href="public/css/navbar.css">
    </head>
    <body>
        <div class="container" style="margin-top: 10%;">
            <%
                if (request.getAttribute("respuesta") != null) {
                    out.print("<h2>" + request.getAttribute("respuesta") + "</h2>");
                    request.setAttribute("respuesta", null);                   
                }
                
            %>
            <div class="row text-center">
                <h2 class="text-center">Cambio de contraseña</h2>
            </div>
            <div class="margin-all">
                <form method="GET" action="nuevaCon" id="cambioForm">
                    <h4>ID </h4>
                    <input type="text" class="form-control" name="ide" id="ide" placeholder="Id usuario">
                    <h4>Codigo </h4>
                    <input type="text" class="form-control" name="codigo" id="codigo" placeholder="Codigo">
                    <h4>Nueva contraseña</h4>
                    <label for="con1">Contraseña</label>
                    <input type="password" class="form-control" name="con1" id="con1" placeholder="contraseña">
                    <label for="con2">Contraseña</label>
                    <input type="password" class="form-control" name="con2" id="con2" placeholder="confirmar contraseña">
                    <br>
                    <button type="button" class="btn btn-info center-block btn-login" id="cambio">Cambiar contraseña</button>
                    <a href="index.jsp">volver</a>
                </form>
            </div>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js" integrity="sha384-lZmvU/TzxoIQIOD9yQDEpvxp6wEU32Fy0ckUgOH4EIlMOCdR823rg4+3gWRwnX1M" crossorigin="anonymous"></script>
        <script src="public/js/cambio.js"></script>
    </body>
</html>
