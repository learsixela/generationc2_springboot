package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {
//http://localhost:8080/registro/usuario
	
	//capturar la url y 
	@RequestMapping("/usuario")
	public String mostrarFormulario() {
		//desplegar el jsp (controlador)
		return "registro.jsp";
	}
	
	
	
	//llenamos el formulario (vista)
	//enviamos el formulario (vista) al controllador
	//capturar la url,
	//capturar los parametros
	//enviar a base datos
	
}
