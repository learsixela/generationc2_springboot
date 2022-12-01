package cl.generation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	/*
	 http://localhost:8080/registro/usuario GET -> desplegar el jsp
	 http://localhost:8080/registro/usuario POST -> capturar los datos en el controlador

     http://localhost:8080/registro/login GET -> desplegar el login.jsp
     http://localhost:8080/registro/login POST -> capturar los datos(email y pasword)  en el controlador
	 */
	
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	//http://localhost:8080/registro/usuario
	//capturar la url y 
	@GetMapping("/usuario")
	public String mostrarFormulario() {
		//desplegar el jsp (controlador)
		return "registro.jsp";
	}
	
	//llenamos el formulario (vista)
	//enviamos el formulario (vista) al controllador
	//capturar la url http://localhost:8080/registro/usuario
	
	@PostMapping("/usuario")
	//capturar los parametros @RequestParam
	public String guardarFormulario(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("nick") String nick,
			@RequestParam("correo") String correo,
			@RequestParam("pass") String pass,
			@RequestParam("pass2") String pass2,
			Model model
			) {
		//equals es para comparar String; == 
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
			Boolean resultado = usuarioServiceImpl.guardarUsuario(usuario);
			if(resultado) {//si es verdadero
				model.addAttribute("msgOk", "Registro exitoso");
				return "login.jsp"; //enviar a una vista
			}else {
				model.addAttribute("msgError" ,"Email ya registrado" );
				return "registro.jsp";
			}	
		}else {//pasword distintos
			model.addAttribute("msgError" ,"Password distintos" );
			return "registro.jsp";
		}
		
		
	}
	
	
	//desplegar el jsp http://localhost:8080/registro/login
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	//capturar el email y password
	@PostMapping("/login")
	public String ingresoUsuario(@RequestParam("email") String email,
			@RequestParam("pass") String pass,
			Model model) {
		//System.out.println(email +" "+pass);
		//llamando al metodo
		Boolean resultadoLogin = usuarioServiceImpl.ingresoUsuario(email, pass);
		
		if(resultadoLogin) {//resultadoLogin == true, login correcto
			//ir a una ruta interna http://localhost:8080/home
			return "redirect:/home";
		}else {
			model.addAttribute("msgError", "Por favor verifica tus datos ingresados");
			return "login.jsp";
		}

	}
	
	
	
	
	
	
	
	
	
	
}
