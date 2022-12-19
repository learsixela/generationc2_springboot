        <nav class="navbar navbar-expand-lg bg-nav">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">${param.tituloNav}</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/home">Home</a>
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
	                                <c:if test="${param.foto!=''}">
	                                	<img alt="" src="data:image/jpeg;base64,${param.foto}" alt="${param.usuarioNombre}" style="width: 50px;height: 50px;border-radius:50%">
	                                </c:if>
	                                <c:if test="${param.foto==''}">
	                                	${param.usuarioNombre}
	                                </c:if>
	                                
	                            </a>
	                         <ul class="dropdown-menu">
	                        <li><a class="dropdown-item" href="/usuario/editar">Editar</a></li>
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