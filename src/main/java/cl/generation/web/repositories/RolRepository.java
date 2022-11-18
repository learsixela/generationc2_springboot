package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
