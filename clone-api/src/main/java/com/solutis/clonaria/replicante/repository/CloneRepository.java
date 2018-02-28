package com.solutis.clonaria.replicante.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.com.solutis.clonaria.replicante.repository.Query;
import com.solutis.clonaria.replicante.model.Clone;


public interface CloneRepository extends CrudRepository<Clone, Long> {
	Clone findByNome(String nome);
}
