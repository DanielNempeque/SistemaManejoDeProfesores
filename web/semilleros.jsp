<%-- 
    Document   : semilleros
    Created on : 6/05/2018, 02:37:47 PM
    Author     : Daniel Nempeque
--%>

<%@page import="Modelo.Usuario"%>
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
        <link rel="stylesheet" href="public/css/vinculacion.css">
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
                    <li class="nav-item dropdown active">
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
                    <li class="nav-item dropdown">
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
        <img class="img" src="public/img/Circuit-Wallpaper.jpg">
        <div class="margin-all pos-absolute float-none">
            <h2>
                Gestion de semilleros
            </h2>
            <p>
                Facultad de ingenieria
            </p>
        </div>
        <div class="margin-sides">
            <table class="table">
                <caption>Lista de semilleros</caption>
                <thead class="thead-blue">
                    <tr class="color-white">
                        <th scope="col">#Codigo</th>
                        <th scope="col">Semilleros</th>
                    </tr>
                </thead>
                <tbody class="color-black">
                    <tr>
                        <th scope="row">1</th>
                        <td>Planta</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Investigacion</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Catedra</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class=" margin-bottom">
            <ul class="nav nav-pills pills-bg">
                <li class="nav-item">
                    <a class="nav-link" href="#nueva" data-toggle="tab">Nuevo semillero</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#modifica" data-toggle="tab">Modificar semilleros</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#elimina" data-toggle="tab">Eliminar semilleros</a>
                </li>
            </ul>
            <div class="tab-content">
                <div id="nueva" class="tab-pane fade">
                    <form class="margin-sides">
                        <div class="row">
                            <div class="col">
                                <label for="inCod">Codigo:</label>
                                <input type="text" class="form-control" placeholder="Codigo" id="inCod">
                            </div>
                            <div class="col">
                                <label for="inNom">Nombre sermillero:</label>
                                <input type="text" class="form-control" placeholder="Nombre semillero" id="inNom">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="titular">Profesor lider</label>
                            <select class="form-control" id="titular">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                        <br>
                        <button type="button" class="btn btn-lg btn-success btn-mid">Nuevo semillero</button>
                    </form>
                </div>

                <div id="modifica" class="tab-pane fade">
                    <form class="margin-sides">
                        <div class="row">
                            <div class="col">
                                <label for="inCod">Codigo:</label>
                                <input type="text" class="form-control" placeholder="Codigo" id="inCod">
                            </div>
                            <div class="col">
                                <label for="inNom">Nombre semillero:</label>
                                <input type="text" class="form-control" placeholder="Nombre semillero" id="inNom">
                            </div>
                        </div>
                        <br>
                        <button type="button" class="btn btn-lg btn-warning btn-mid">Modificar semillero</button>
                    </form>

                </div>

                <div id="elimina" class="tab-pane fade">
                    <form class="margin-sides">
                        <div class="row">
                            <div class="col">
                                <label for="inCod">Codigo:</label>
                                <input type="text" class="form-control" placeholder="Codigo" id="inCod">
                            </div>
                        </div>
                        <br>
                        <button type="button" class="btn btn-lg btn-danger btn-mid">Eliminar semillero</button>
                    </form>

                </div>
            </div>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js" integrity="sha384-lZmvU/TzxoIQIOD9yQDEpvxp6wEU32Fy0ckUgOH4EIlMOCdR823rg4+3gWRwnX1M" crossorigin="anonymous"></script>
    </body>

</html>
<% } else {
        response.sendRedirect("index.jsp");
    }
%>


