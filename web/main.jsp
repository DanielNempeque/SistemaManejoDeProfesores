<%-- 
    Document   : main
    Created on : 3/05/2018, 11:12:50 PM
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
				<li class="nav-item active">
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
						<a class="dropdown-item" href="centroCosto.jsp">
							<div class="dropdown-divider"></div>
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
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Informes</a>
				</li>
			</ul>
			<!--navbar items right-->
			<form class="form-inline my-2 my-lg-0">
				<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Cerrar sesion</button>
			</form>
		</div>
	</nav>

	<!-- end navbar-->

	<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="public/img/edificio d.jpg" alt="First slide">
				<div class="carousel-caption d-none d-md-block">
					<h4>Evento 1</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.
					</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="public/img/edificio d.jpg" alt="First slide" alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="public/img/edificio d.jpg" alt="First slide" alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
	    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    		<span class="sr-only">Previous</span>
	  	</a>
		<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    		<span class="carousel-control-next-icon" aria-hidden="true"></span>
    		<span class="sr-only">Next</span>
  		</a>
	</div>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js" integrity="sha384-lZmvU/TzxoIQIOD9yQDEpvxp6wEU32Fy0ckUgOH4EIlMOCdR823rg4+3gWRwnX1M" crossorigin="anonymous"></script>
</body>

</html>

