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
         <jsp:include page='template/navbar.jsp'>
             <jsp:param name='tituloNav' value='Sistema Web' />
             <jsp:param name='foto' value='${foto}' />
             <jsp:param name='usuarioNombre' value='${param.usuarioNombre}' />
         </jsp:include>
         
        <!--contenido-->
        <div>
            <h1>Hello, world!</h1>
		<img alt="" src="data:image/jpeg;base64,${foto}" alt="${param.usuarioNombre}" style="width: 200px;height: 200px;border-radius:50%">
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