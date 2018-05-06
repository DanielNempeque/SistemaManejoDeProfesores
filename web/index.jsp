<%-- 
    Document   : index
    Created on : 3/05/2018, 11:14:42 PM
    Author     : Daniel Nempeque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>

    <head>
        <title>Sistema de manejo de profesores</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- import cdns -->

        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

        <!-- fonts -->

        <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Orbitron:400,700" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- local css -->

        <link rel="stylesheet" href="public/css/animate.css">
        <link rel="stylesheet" href="public/css/style.css">
    </head>

    <body>
        <div>
            <img class="img-fluid  pos-relative top animated fadeIn" src="https://images.pexels.com/photos/33041/antelope-canyon-lower-canyon-arizona.jpg?auto=compress&bri=-20&crop=bottom&cs=tinysrgb&fit=crop&h=360&sharp=30&w=1400">

            <img src="public/img/logo-sabana-blanco.png" class="float-none center-block pos-absolute animated fadeIn timer-1 img-fluid ">
        </div>
        <%
            if (request.getAttribute("respuesta") != null) {
                out.print("<h2>" + request.getAttribute("respuesta") + "</h2>");
                request.setAttribute("respuesta", null);
            }
        %>
        <div class="col-md-3 float-none center-block padding-big">
            <form method="GET" action="login">
                <div class="form-group">
                    <label for="inputUser">Usuario o correo</label>
                    <input type="text" class="form-control" name="usr" id="inputUser" placeholder="Usuario">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Contraseña</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña" name="pass">
                </div>

                <button type="submit" class="btn btn-default center-block btn-login" onclick="window.location.href('main.html');">Iniciar sesión</button>
                <a href="main.jsp">Siguiente pagina</a>
            </form>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js" integrity="sha384-lZmvU/TzxoIQIOD9yQDEpvxp6wEU32Fy0ckUgOH4EIlMOCdR823rg4+3gWRwnX1M" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </body>

</html>

