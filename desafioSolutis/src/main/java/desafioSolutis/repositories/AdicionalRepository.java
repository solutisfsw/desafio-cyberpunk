package desafioSolutis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import desafioSolutis.models.Adicional;

public interface AdicionalRepository extends CrudRepository<Adicional, Long>  {

	List<Adicional> findAll();
	
	@Query(value="SELECT * FROM adicional RIGHT JOIN clone ON adicional.id_clone = clone.id", nativeQuery=true)
	List<Adicional> findAllJoin();

	@Query(value="SELECT * FROM adicional WHERE id_clone = :idClone ", nativeQuery=true)
	Adicional findByIdClone(@Param("idClone") Long idClone);
}
