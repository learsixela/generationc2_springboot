package cl.generation.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Auto;
import cl.generation.web.models.Usuario;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{
	//logica de manipulacion de datos (CRUD+)
	
	Auto findByMarca(String marca);
	
	/**JPQL**/
	//obtener lista de autos por marca
	@Query("SELECT a FROM AUTO a WHERE a.marca = ?1")
	List<Auto> findAllByMarca(String marca);
	
	//query comun
	@Query(value="select * from autos a where a.marca = ?1", nativeQuery = true)
	List<Auto> findAllByMarcaComun(String marca);
	
	//JPQL lista de todos los autos de un usuario
	@Query("SELECT a FROM AUTO a WHERE a.usuario.id = ?1")
	List<Auto> findAllByUsuario(Long id);
	
	
	//obtener lista de autos por marca
	@Query("SELECT a FROM AUTO a WHERE a.marca = ?1 and a.color = ?2")
	List<Auto> findAllByMarcaAndColor(String marca, String color);
	
}
