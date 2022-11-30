package cl.generation.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Usuario;
import cl.generation.web.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
// Logica de negocio del sistema web
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		
		//validar el usuario (email)
		
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public String eliminarUsuario(Long id) {
		Boolean existe = usuarioRepository.existsById(id);
		
		if(existe) {
			//elimino el usuario pasando el id (pk)
			usuarioRepository.deleteById(id);
		}else {
			return "Usuario no existe en la tabla";
		}
		
		existe = usuarioRepository.existsById(id);
		
		//si es distinto de nulo, no fue eliminado
		if(existe) {
			return "Usuario no eliminado";
		}
		
		return "El usuario fue eliminado";
	}

	@Override
	public String actualizarUsuario(Usuario usuario) {

		Boolean existe = usuarioRepository.existsById(usuario.getId());
		
		if(existe) {
			usuarioRepository.save(usuario);
			return "Usuario actualizado";
		}
		return "Usuario no actualizado";
	}

	@Override
	public Usuario obtenerUsuario(Long id) {
		//Optional<Usuario> user = usuarioRepository.findById(id);
		Boolean existe = usuarioRepository.existsById(id);
		
		if(existe) {
		Usuario user= usuarioRepository.findById(id).get();
			return user;
		}
		return null;
	}
	//listar todos los usuarios
	@Override
	public List<Usuario> obtenerListaUsuarios() {
		// obtener todos los usuarios
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> obtenerDatosUsuario(Long id) {
		Optional<Usuario> mensaje = usuarioRepository.findById(id);
		return mensaje;
	}


	
	

}
