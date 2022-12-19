package cl.generation.web.controllers;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.generation.web.models.Rol;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

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
	
	@RequestMapping("/rol")
	public Rol obtenerRol() {
		Rol rol = new Rol();
		rol.setNombre("ADMIN");
		rol.setDescripcion("Administra el sistema");
		System.out.println("");
		return rol;
	}
	
	@GetMapping("/editar")
	public String editarUsuario(Model model, HttpSession session) {
		
		if(session.getAttribute("usuarioId")!=null) {
			Long usuarioId = (Long) session.getAttribute("usuarioId");
			Usuario usuario= usuarioServiceImpl.obtenerUsuario(usuarioId);
			model.addAttribute("usuario", usuario);
			String foto = "";
			byte[] imagenFoto = (byte[]) usuario.getFoto();
			if(imagenFoto!= null) {
				foto = Base64.getEncoder().encodeToString(imagenFoto);
			}
			model.addAttribute("foto", foto);
			model.addAttribute("usuarioNombre", usuario.getNombre());
		}
		
		return "editarUsuario.jsp";
	}
	
	@PostMapping("/editar")
	public String guardarUsuario(@RequestParam("id") Long id,
			@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("nick") String nick,
			@RequestParam("pass") String pass,
			@RequestParam("pass2") String pass2,
			final @RequestParam("foto") MultipartFile foto,
			HttpSession session,
			Model model
			,RedirectAttributes redirectAttr
			) throws IOException {
		
		if(session.getAttribute("usuarioId")!=null) {
			byte[] imagenFoto = foto.getBytes();
			
			//instanciar un objeto usuario
			Usuario usuario= usuarioServiceImpl.obtenerUsuario(id);
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setPassword(pass);
			usuario.setNick(nick);
			usuario.setFoto(imagenFoto);
			//enviar a base datos
			String resultado = usuarioServiceImpl.actualizarUsuario(usuario);
			System.out.println(resultado);
			redirectAttr.addAttribute("usuario", usuario);
			return "redirect:/home";
		}
		
		return "editarUsuario.jsp";
	}
	
	
}
