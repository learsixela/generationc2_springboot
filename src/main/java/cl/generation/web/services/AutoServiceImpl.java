package cl.generation.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Auto;
import cl.generation.web.models.Usuario;
import cl.generation.web.repositories.AutoRepository;

@Service
public class AutoServiceImpl implements AutoService{
	@Autowired
	AutoRepository autoRepository;
	@Override
	public Auto guardarAuto(Auto auto) {
		return autoRepository.save(auto);
	}
	@Override
	public Auto obtenerAuto(Long id) {
		return autoRepository.findById(id).get();
	}
	
	@Override
	public List<Auto> listarAutos() {
		return autoRepository.findAll();
	}
	
	@Override
	public Auto obtenerAutoNombre(String marca) {
		
		return autoRepository.findByMarca(marca);
	}
	public void eliminarAuto(Long id) {
		autoRepository.deleteById(id);
	}
	@Override
	public List<Auto> findAllByUsuario(Long id) {
		return autoRepository.findAllByUsuario(id);
	}


	
}
