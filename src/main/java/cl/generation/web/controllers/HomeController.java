package cl.generation.web.controllers;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Auto;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.AutoServiceImpl;
import cl.generation.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	AutoServiceImpl autoServiceImpl;
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
//localhost:9080/home
	@GetMapping("")
	public String home(Model model, HttpSession session) {
		
		if(session.getAttribute("usuarioId")!=null) {
			
			//capturando variables de session
			String email = (String) session.getAttribute("usuarioEmail");
			Long usuarioId = (Long) session.getAttribute("usuarioId");
			
			//obtener y almacenar en variable
			List<Auto> listaAutos= autoServiceImpl.listarAutos();
			//pasar lista de autos al jsp
			model.addAttribute("autos", listaAutos);
			//lista para el selector
			List<Auto> listaSelectAutos= autoServiceImpl.listarAutos();
			model.addAttribute("listaSelectAutos", listaSelectAutos);
			
			Usuario usuario= usuarioServiceImpl.obtenerUsuario(usuarioId);
			
			model.addAttribute("usuarioNombre", usuario.getNombre());
			
			String foto = "";
			byte[] imagenFoto = (byte[]) usuario.getFoto();
			if(imagenFoto!= null) {
				foto = Base64.getEncoder().encodeToString(imagenFoto);
			}
			model.addAttribute("foto", foto);
			
			return "home.jsp";
			
		}else {
			return "redirect:/registro/login";
		}
		
		
	}
	
	//localhost:9080/home -> post, solo respondera a formularios
	@PostMapping("")
	public String filtrar(@RequestParam("autoSeleccionado") Long id, Model model) {
		List<Auto> listaAutos= new ArrayList<Auto>();//lista vacia
		Auto auto = autoServiceImpl.obtenerAuto(id);
		listaAutos.add(auto);//agrego el auto a la lista
		model.addAttribute("autos", listaAutos);//pasar lista de autos al jsp
		//lista para el selector
		List<Auto> listaSelectAutos= autoServiceImpl.listarAutos();
		model.addAttribute("listaSelectAutos", listaSelectAutos);
		return "home.jsp";
	}
	
	@PostMapping("/nav")
	public String filtrarNav(@RequestParam("marca") String marca, Model model) {
		List<Auto> listaAutos= new ArrayList<Auto>();//lista vacia
		Auto auto = autoServiceImpl.obtenerAutoNombre(marca);
		listaAutos.add(auto);//agrego el auto a la lista
		model.addAttribute("autos", listaAutos);//pasar lista de autos al jsp
		//lista para el selector
		List<Auto> listaSelectAutos= autoServiceImpl.listarAutos();
		model.addAttribute("listaSelectAutos", listaSelectAutos);
		return "home.jsp";
	}
}
