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

    <link href="assets/css/stylos.css" rel="stylesheet">

        <style>

        </style>

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
                </div>
            </div>
        </nav><br>
        <!--contenido-->
        <div>
            <h1>Hello, world!</h1>

		<form action="/home" method="post">
            <label for="autoSeleccionado" class="form-label">Auto</label>
           	<select class="form-select" aria-label="lista de autos" name="autoSeleccionado" id="autoSeleccionado">
			  <option value="0" selected>Seleccione su auto</option>
			  <c:forEach var="auto" items="${listaSelectAutos}">
			  	<option value="${auto.id}">${auto.marca} - ${auto.color}</option>
			  </c:forEach>
			</select>
            <br>
            <button type="submit" class="btn btn-outline-secondary">Filtrar Auto</button>
         </form>
            
            <br> <br>
            <h2>Lista de autos</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Marca</th>
                        <th scope="col">Color</th>
                        <th scope="col">USUARIO</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach  var="auto" items="${autos}">
                    	<tr>
                    		<td>${auto.id}</td>
                    		<td>${auto.marca}</td>
                    		<td>${auto.color}</td>
                    		<td>${auto.usuario.nombre} ${auto.usuario.apellido}</td>
                    	</tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>

        </div>


    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>

</html>