<%-- 
    Document   : profesor
    Created on : 15/05/2018, 02:25:05 PM
    Author     : Daniel Nempeque
--%>

<%@page import="Gestion.GestionUsuario"%>
<%@page import="Modelo.Profesor"%>
<%@page import="Gestion.GestionProfesor"%>
<%@page import="Modelo.Escalafon"%>
<%@page import="Gestion.GestionEscalafon"%>
<%@page import="Modelo.AreaAcademica"%>
<%@page import="Gestion.GestionAreaAcademica"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Vinculacion"%>
<%@page import="Gestion.GestionVinculacion"%>
<%@page import="Modelo.Usuario"%>
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
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/cloudinary-jquery-file-upload/2.5.0/cloudinary-jquery-file-upload.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/cloudinary-jquery-file-upload/2.5.0/cloudinary-jquery-file-upload.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        <!-- fonts -->

        <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Orbitron:400,700" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- local css -->

        <link rel="stylesheet" href="public/css/animate.css">
        <link rel="stylesheet" href="public/css/profesor.css">
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
                    <li class="nav-item ">
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
                    request.setAttribute("respuesta", null);
                }
            %>   
            <ul class="nav nav-pills pills-bg">
                <%
                    if (us.getIdRol().equals("ADMON1") || us.getIdRol().equals("SECRET")) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="#nuevoProf" data-toggle="tab" id="current"> Nuevo profesor</a>
                </li>
                <%}%>
                <li class="nav-item">
                    <a class="nav-link" href="#busca" data-toggle="tab">Buscar profesor</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#modifica" data-toggle="tab">Modificar profesor</a>
                </li>
            </ul>

            <div class="tab-content">
                <%
                    GestionAreaAcademica area = new GestionAreaAcademica();
                    ArrayList<AreaAcademica> areas = area.listaAreas();
                    if (us.getIdRol().equals("ADMON1") || us.getIdRol().equals("SECRET")) {
                %>
                <div class="tab-pane fade margin-small" id="nuevoProf">
                    <form method="GET" action="crearProfesor">

                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="docNum">Id usuario</label>
                                <input class="form-control" id="docNum" type="text" name="idNum" placeholder="Id usuario">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="docNum">Vinculacion</label>
                                <select class="form-control" id="vinc" name="tipoVinc">
                                    <%
                                        GestionVinculacion vinc = new GestionVinculacion();
                                        ArrayList<Vinculacion> vinculaciones = vinc.listaVinculaciones();
                                        for (Vinculacion vi : vinculaciones) {
                                            out.print("<option>" + vi.getId() + "</option>");
                                        }

                                    %>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="docNum">Titulacion</label>
                                <select class="form-control" id="vinc" name="tipoTitu">
                                    <option>...</option>
                                    <option>...</option>
                                    <option>...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="docNum">Area academica</label>
                                <select class="form-control" id="vinc" name="tipoArea">
                                    <%                                        for (AreaAcademica ar : areas) {
                                            out.print("<option>" + ar.getId() + "</option>");
                                        }

                                    %>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="docNum">Escalafón</label>
                                <select class="form-control" id="vinc" name="esca">
                                    <%                                        GestionEscalafon esc = new GestionEscalafon();
                                        ArrayList<Escalafon> escalafones = esc.listarEscalafon();
                                        for (Escalafon es : escalafones) {
                                            out.print("<option>" + es.getId() + "</option>");
                                        }

                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="fechaingreso">Fecha ingreso</label>
                                <div class="center-block">
                                    <input id="fechaingreso" width="276" name="fechai">
                                </div>
                            </div>
                            <div class="form-group col-md-3">
                                <input type="checkbox" id="checkfechaegreso">
                                <label for="fechaegreso">Fecha egreso</label>
                                <div id="picker" class="display-none">
                                    <input id="fechaegreso" width="276" name="fechae">
                                </div>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="estado">Estado</label>
                                <select class="form-control" id="estado" name="estado">
                                    <option>Activo</option>
                                    <option>Inactivo</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <p>Foto</p>
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id=file required>
                                    <label class="custom-file-label" for="file">Foto</label>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-lg btn-success btn-mid">Crear profesor</button>
                    </form>
                </div>
                <%                    } else {

                    }
                %>                


                <div class="tab-pane fade margin-small" id="busca">
                    <table class="table">
                        <caption>Profesores</caption>
                        <thead class="thead-blue">
                            <tr class="color-white">
                                <th scope="col">#Codigo</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Tipo vinculacion</th>
                                <th scope="col">Fecha ingreso</th>
                                <th scope="col">Estado</th>
                            </tr>
                        </thead>
                        <tbody class="color-black">

                            <%
                                GestionProfesor gest = new GestionProfesor();
                                GestionUsuario gestus = new GestionUsuario();
                                if (request.getAttribute("filtro") == null || request.getAttribute("filtro").toString().equals("")) {
                                    ArrayList<Profesor> profesores = gest.listarProfesor();
                                    ArrayList<Usuario> usuarios = gestus.listarUsuarios();
                                    if (areas != null) {
                                        for (Usuario arus : usuarios) {
                                            for (Profesor pr : profesores) {
                                                out.print("<tr>");
                                                out.print("<td class='text-justify'>" + pr.getId() + "</td>");
                                                out.print("<td class='text-justify'>" + arus.getNombre() + arus.getApellido() + "</td>");
                                                out.print("<td class='text-justify'>" + pr.getVinculacion() + "</td>");
                                                out.print("<td class='text-justify'>" + pr.getFecha_ingreso() + "</td>");
                                                out.print("<td class='text-justify'>" + pr.getEstado() + "</td>");
                                                out.print("</tr>");
                                            }
                                        }
                                    }
                                } else if (request.getAttribute("filtro") != null && !request.getAttribute("filtro").toString().equals("")) {
                                    String filtro = request.getAttribute("filtro").toString();
                                    ArrayList<Profesor> profesores = gest.listarProfesor();
                                    if (areas != null) {
                                        for (Profesor pr : profesores) {
                                            out.print("<tr>");
                                            out.print("<td class='text-justify'>" + pr.getId() + "</td>");
                                            out.print("<td class='text-justify'>" + pr.getVinculacion() + "</td>");
                                            out.print("<td class='text-justify'>" + pr.getFecha_ingreso() + "</td>");
                                            out.print("<td class='text-justify'>" + pr.getEstado() + "</td>");
                                            out.print("</tr>");
                                        }
                                    }
                                }

                            %>
                        </tbody>
                    </table>
                </div> 
                <div class="tab-pane fade margin-small" id="modifica">

                </div>    
            </div>
        </div>



        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js" integrity="sha384-lZmvU/TzxoIQIOD9yQDEpvxp6wEU32Fy0ckUgOH4EIlMOCdR823rg4+3gWRwnX1M" crossorigin="anonymous"></script>
        <script src="public/js/datepicker.js"></script>
        <script src="public/js/profesor.js"></script>
    </body>

</html>
<% } else {
        response.sendRedirect("index.jsp");
    }
%>