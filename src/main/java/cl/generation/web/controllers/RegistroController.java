package cl.generation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	//http://localhost:8080/registro/usuario
	//capturar la url y 
	@RequestMapping("/usuario")
	public String mostrarFormulario() {
		//desplegar el jsp (controlador)
		return "registro.jsp";
	}
	
	//llenamos el formulario (vista)
	//enviamos el formulario (vista) al controllador
	//capturar la url http://localhost:8080/registro/formulario
	
	@RequestMapping("/formulario")
	//capturar los parametros @RequestParam
	public String guardarFormulario(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("nick") String nick,
			@RequestParam("correo") String correo,
			@RequestParam("pass") String pass,
			@RequestParam("pass2") String pass2,
			Model model
			) {
		
		if(pass.equals(pass2)) {
			//instanciar un objeto usuario
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setCorreo(correo);
			usuario.setPassword(pass);
			usuario.setNick(nick);
			usuario.setPassword2(pass2);
			//enviar a base datos
			usuarioServiceImpl.guardarUsuario(usuario);
			
			
			return "index.jsp"; //enviar a una vista
		}else {
			model.addAttribute("msgError" ,"Password distintos" );
			return "registro.jsp";
		}
		
		
	}
	
	
	
	
}
