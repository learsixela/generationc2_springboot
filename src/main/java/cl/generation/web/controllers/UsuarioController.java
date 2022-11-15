package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	//http://localhost:8080/usuario/
	@RequestMapping("/")
	public String getUsuario() {
		System.out.println("metodo de obtener usuario");
		return "index.jsp";
	}
	//http://localhost:8080/usuario/home
	@RequestMapping("/home")
	public String home() {
		System.out.println("en el metodo home");
		return "home";
	}
	
	//htps://localhost:8080/usuario/isra/palma
	@RequestMapping("/isra/palma")
	public String ipalma() {
		System.out.println("en el metodo de israel");
		return "";
	}
}
