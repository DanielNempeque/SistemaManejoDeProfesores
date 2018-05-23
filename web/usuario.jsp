<%-- 
    Document   : usuario
    Created on : 6/05/2018, 03:12:32 PM
    Author     : Daniel Nempeque
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Rol"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Gestion.GestionRol"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession session1 = request.getSession();
    Usuario us = (Usuario) session1.getAttribute("user");
    if (us != null) {
%>
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
        <link rel="stylesheet" href="public/css/usuario.css">
        <link rel="stylesheet" href="public/css/navbar.css">
    </head>

    <body>
        <!--navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-blue">
            <!--navbar brand-->
            <a class="navbar-brand" href="main.jsp">
                <img class="logo" src="public/img/logo-sabana-blanco.png">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--navbar items-->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="main.jsp">Inicio<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Elementos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="areasAcademicas.jsp">Areas académicas</a>
                            <a class="dropdown-item" href="areasInvestigacion.jsp">Areas investigación</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="vinculacion.jsp">Vinculación</a>
                            <a class="dropdown-item" href="titulacion.jsp">Titulación</a>
                            <a class="dropdown-item" href="escalafon.jsp">Escalafón</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="centroCosto.jsp">
                                Centros de costo</a>
                            <a class="dropdown-item" href="semilleros.jsp">Semilleros</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Operaciones
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="profesor.jsp">Profesor</a>
                            <a class="dropdown-item" href="gruposInvestigacion.jsp">Grupos de investigación</a>
                            <a class="dropdown-item" href="proyectos.jsp">Proyectos</a>
                            <a class="dropdown-item" href="usuario.jsp">Usuarios</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Informes</a>
                    </li>
                </ul>
                <!--navbar items right-->
                <form class="form-inline my-2 my-lg-0" method="GET" action="Logout">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Cerrar sesion</button>
                </form>
            </div>
        </nav>

        <!-- end navbar-->

        <div class="margin-all">
            <%
                if (request.getAttribute("respuesta") != null) {
                    out.print("<h2>" + request.getAttribute("respuesta") + "</h2>");
                    out.print("<h4>" +"Su contraseña temporal es: "+request.getAttribute("pass") + "</h4>");
                    request.setAttribute("respuesta", null);
                    request.setAttribute("pass", null);
                }
            %>            
            <ul class="nav nav-pills pills-bg">
                <li class="nav-item">
                    <a class="nav-link" href="#nuevoProf" data-toggle="tab" id="current"> Nuevo usuario</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#modifica" data-toggle="tab">Busca usuario</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane margin-small" id="nuevoProf">
                    <form method="GET" action="crearUsuario" id="newUsr">
                        <div class="form-row">
                            <div class="form-group col-md-8">
                                <label for="docide">Id usuario</label>
                                <input class="form-control" id="docide" type="text" name="docide" placeholder="id usuario">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="tipoUsr">Tipo usuario</label>
                                <select class="form-control" id="tipoDoc" name="tipoUsr">
                                    <%
                                        GestionRol gestionRol = new GestionRol();
                                        ArrayList<Rol> roles = gestionRol.listaRoles();
                                        if(roles != null){
                                            for(Rol rl : roles){
                                                out.print("<option>"+rl.getId()+"</option>");
                                            }
                                        }
                                    
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="docide">Username</label>
                                <input class="form-control" id="username" type="text" name="username" placeholder="id usuario">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-8">
                                <label for="docNum">Numero de documento</label>
                                <input class="form-control" id="docNum" type="text" name="docNum" placeholder="Numero de documento">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="docTipo">Tipo de documento</label>
                                <select class="form-control" id="docTipo" name="docTipo">
                                    <option>Cedula</option>
                                    <option>TI</option>
                                    <option>Pasaporte</option>
                                </select>
                            </div>

                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="nombres">Nombres</label>
                                <input class="form-control" id="nombres" type="text" name="nombres" placeholder="Nombres">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="apellidos">Apellidos</label>
                                <input class="form-control" id="apellidos" type="text" name="apellidos" placeholder="Apellidos">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="tel">Telefono</label>
                                <input class="form-control" id="tel" type="text" name="tel" placeholder="Telefono">
                            </div>
                            <div class="form-group col-md-6">
                                <input type="checkbox" id="checktelo">
                                <label for="telO">Otro telefono</label>
                                <input class="form-control" id="telO" type="text" name="tel2" placeholder="Otro" disabled>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="tel">e-mail Sabana</label>
                                <input class="form-control" id="e-sab" type="text" name="e-sab" placeholder="usuario@unisabana.edu.co">
                            </div>
                            <div class="form-group col-md-6">
                                <input type="checkbox" id="checkeo">
                                <label for="corro">Otro correo</label>
                                <input class="form-control" id="corro" type="text" name="corro" placeholder="usuario@example.com" disabled>
                            </div>
                        </div>
                        <button type="button" id="newbtn" class="btn btn-lg btn-warning btn-mid">Crear usuario</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="public/js/usuario.js"></script> 
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js" integrity="sha384-lZmvU/TzxoIQIOD9yQDEpvxp6wEU32Fy0ckUgOH4EIlMOCdR823rg4+3gWRwnX1M" crossorigin="anonymous"></script>

    </body>

</html>
<% } else {
        response.sendRedirect("index.jsp");
    }
%>