package cl.generation.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
			final @RequestParam("foto") MultipartFile foto,
			Model model
			) throws IOException {
		//equals es para comparar String; == 
		if(pass.equals(pass2)) {
			//foto
			byte[] imagenFoto = foto.getBytes();
			
			//instanciar un objeto usuario
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setCorreo(correo);
			usuario.setPassword(pass);
			usuario.setNick(nick);
			usuario.setPassword2(pass2);
			usuario.setFoto(imagenFoto);
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
			Model model,
			HttpSession session) {
		//System.out.println(email +" "+pass);
		//llamando al metodo
		Boolean resultadoLogin = usuarioServiceImpl.ingresoUsuario(email, pass);
		
		if(resultadoLogin) {//resultadoLogin == true, login correcto
			
			Usuario usuario = usuarioServiceImpl.obtenerUsuarioEmail(email);
			
			//guardar informacion en session
			session.setAttribute("usuarioId", usuario.getId());
			session.setAttribute("usuarioEmail", email);
			session.setAttribute("usuarioRol", usuario.getRoles());
			session.setAttribute("usuarioNombre", usuario.getNombre()+" " + usuario.getApellido());
			session.setAttribute("foto", usuario.getFoto());
			
			//ir a una ruta interna http://localhost:8080/home
			return "redirect:/home";
		}else {
			model.addAttribute("msgError", "Por favor verifica tus datos ingresados");
			return "login.jsp";
		}

	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("usuarioId")!=null) {
			session.invalidate();
		}
		
		return "redirect:/registro/login";
	}
	
}
