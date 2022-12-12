package cl.generation.web.services;

import java.util.List;

import cl.generation.web.models.Auto;

public interface AutoService {
	public Auto guardarAuto(Auto auto);
	public List<Auto> listarAutos();
}
