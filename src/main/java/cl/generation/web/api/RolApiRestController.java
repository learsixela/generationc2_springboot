package cl.generation.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Rol;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.RolServiceImpl;

@RestController
public class RolApiRestController {
	@Autowired
	RolServiceImpl rolServiceImpl;
	
	@RequestMapping("/obtener/rol")
	public Rol obtenerUsuario(@RequestParam(value="id",required = true) Long id) {
		Rol rol = rolServiceImpl.obtenerRol(id);
		List<Usuario> usuarios= rol.getUsuarios();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNombre());
		}
		return rol;
	}

}
