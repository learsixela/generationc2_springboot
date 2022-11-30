package cl.generation.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@RestController
public class UsuarioApiRestController {
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@RequestMapping("/guardar/usuario")
	public String guardarUsuario(@RequestBody Usuario usuario) {
		//http://localhost:8080/guardar/usuario
		/*
		 	{
			"nombre":"Mijail",
			"correo":"a@a.cl",
			"password": "secret"
			}
		 */
		Boolean resultado = usuarioServiceImpl.guardarUsuario(usuario);
		if(resultado) {//si es verdadero
			return "Insertado correctamente"; //enviar a una vista
		}else {
			return "Error la crear usuario";
		}
	}
	
	@RequestMapping("/eliminar/usuario")
	public String eliminarUsuario(@RequestParam(value="id",required = false) Long id) {
		//llamando el metodo eliminar en el service
		/*String respuesta = usuarioServiceImpl.eliminarUsuario(id);
		return respuesta;*/
		return usuarioServiceImpl.eliminarUsuario(id);
	}

	@RequestMapping("/actualizar/usuario")
	public String actualizarUsuario(@RequestBody Usuario usuario) {
		//validacion logica
		if(usuario.getId()!=null) {
			String mensaje =  usuarioServiceImpl.actualizarUsuario(usuario);
			return mensaje;
		}
		return "No se actualizara ningun usuario";
	}
	
	@RequestMapping("/obtener/usuario")
	public Usuario obtenerUsuario(@RequestParam(value="id",required = true) Long id) {
		
		return usuarioServiceImpl.obtenerUsuario(id);
	}
	// ahora obtenemos el usuario a partir del id
		// http://localhost:8080/obtenerdato/usuario
		@RequestMapping("/obtenerdato/usuario")
		public Optional<Usuario> obtenerDatosUsuario(@RequestParam(value = "id", required = true) Long id) {
				
			return usuarioServiceImpl.obtenerDatosUsuario(id);
		}
		
	//listar todos los usuarios
	@GetMapping("/listar/usuarios")
	public List<Usuario> obtenerListaUsuarios(){
		return usuarioServiceImpl.obtenerListaUsuarios();
	}
}
