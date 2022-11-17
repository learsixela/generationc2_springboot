package cl.generation.web.services;

import java.util.List;
import java.util.Optional;

import cl.generation.web.models.Usuario;

public interface UsuarioService {
	//definir metodos para crud usuario
	public Usuario guardarUsuario(Usuario usuario);
	public String eliminarUsuario(Long id);
	public String actualizarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(Long id);
	public Optional<Usuario> obtenerDatosUsuario(Long id);
	public List<Usuario> obtenerListaUsuarios();
}
