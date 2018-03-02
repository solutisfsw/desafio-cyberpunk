package repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import model.Clone;

public interface CloneRepository extends CrudRepository<Clone, Long> {

	
	List<Clone> findAll();
	
	Clone findById(Long id);
}
