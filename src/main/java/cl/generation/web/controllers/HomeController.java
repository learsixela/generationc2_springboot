package cl.generation.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.generation.web.models.Auto;
import cl.generation.web.services.AutoServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	AutoServiceImpl autoServiceImpl;
	
//localhost:8080/home
	@GetMapping("")
	public String home(Model model) {
		
		//obtener y almacenar en variable
		List<Auto> listaAutos= autoServiceImpl.listarAutos();
		//pasar lista de autos al jsp
		model.addAttribute("autos", listaAutos);
		
		
		
		return "home.jsp";
	}
}
