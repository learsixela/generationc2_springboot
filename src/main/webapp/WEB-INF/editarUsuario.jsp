<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    </head>

<body>
    <div class="container">
        <!--navegacion -->
        <nav class="navbar navbar-expand-lg bg-nav">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                Dropdown
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                    </ul>
                    <form action="/home/nav" method="post" class="d-flex" role="search">
                        <input class="form-control me-2" name="marca" type="search" placeholder="Search" aria-label="Search" >
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	                    <li class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
	                                aria-expanded="false">
	                                <c:if test="${foto!=''}">
	                                	<img alt="" src="data:image/jpeg;base64,${foto}" alt="${usuarioNombre}" style="width: 50px;height: 50px;border-radius:50%">
	                                </c:if>
	                                <c:if test="${foto==''}">
	                                	${usuarioNombre}
	                                </c:if>
	                                
	                            </a>
	                         <ul class="dropdown-menu">
	                        <li><a class="dropdown-item" href="#">Editar</a></li>
	                        <li><a class="dropdown-item" href="#">Another action</a></li>
	                        <li>
	                            <hr class="dropdown-divider">
	                        </li>
	                        <li><a class="dropdown-item" href="/registro/logout">Logout</a></li>
	                    </ul>
	                    </li>
                    </ul>
                </div>
            </div>
        </nav><br>
        <!--contenido-->
        <div>
            <h1>Actualizar datos de perfil</h1>

		<form action="/usuario/editar" method="post" enctype="multipart/form-data">
				<input type="hidden" value="${usuario.id}" name="id">
		        <label for="nombre" class="form-label">Nombre:</label>
		        <input type="text" class="form-control" value="${usuario.nombre}" name="nombre" placeholder="Ingresa nombre">
		        <br>
		        <label for="apellido" class="form-label">Apellido:</label>
		        <input type="text" class="form-control" value="${usuario.apellido}" name="apellido" placeholder="Ingresa apellido">
		        <br>
		        <label for="nick" class="form-label">Nick:</label>
		        <input type="text" class="form-control" value="${usuario.nick}" name="nick" placeholder="Ingresa Nick">
		        <br>
		        <label for="pass" class="form-label">Password:</label>
		        <input type="password" class="form-control"  name="pass" placeholder="Ingrese password">
		        <br>
		        <label for="pass2" class="form-label">Confirme Password:</label>
		        <input type="password" class="form-control" id="pass2" name="pass2" placeholder="Ingrese password">
		        <br>
		        <label for="foto" class="form-label">Foto:</label>
		        <input type="file" class="form-control" value="${usuario.foto}" name="foto" placeholder="cargar foto">
		        <br>
		        <input type="submit" class="btn btn-outline-primary btn-lg" value="Actualizar">
		     
		    </form>
           
			
        </div>


    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>

</html>