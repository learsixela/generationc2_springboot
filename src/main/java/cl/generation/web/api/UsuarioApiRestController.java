package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@RestController
public class UsuarioApiRestController {
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@RequestMapping("/guardar/usuario")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		//http://localhost:8080/guardar/usuario
		/*
		 	{
			"nombre":"Mijail",
			"correo":"a@a.cl",
			"password": "secret"
			}
		 */
		
		return usuarioServiceImpl.guardarUsuario(usuario);// "Usuario guardado";
	}
	
}
