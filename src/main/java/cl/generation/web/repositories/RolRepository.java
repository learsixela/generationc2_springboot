package cl.generation.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	//List<Rol> findAll();
    
   // List<Rol> findByName(String name);
}
