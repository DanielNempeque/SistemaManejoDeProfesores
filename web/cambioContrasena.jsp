<%-- 
    Document   : cambioContrasena
    Created on : 24/05/2018, 10:27:00 PM
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
        <div class="container" style="margin-top: 10%;">
            <div class="row text-center">
                <h2 class="text-center">Cambio de contraseña</h2>
            </div>
            <div class="margin-all">
                <form method="GET" action="cambiarContrase_a">
                    <div class="form-group">
                        <label for="inputUser">Usuario o correo</label>
                        <input type="text" class="form-control" name="name" id="inputUser" placeholder="mail">
                    </div>
                    <button type="submit" class="btn btn-default center-block btn-login">Olvide mi contraseña</button>
                </form>
            </div>
        </div>
    </body>
</html>
