package org.juanfsrv.cyberpunk.repository;

import java.util.List;

import org.juanfsrv.cyberpunk.entity.AdicionalEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdicionalRepository extends CrudRepository<AdicionalEntity, Integer> {
	
	public List<AdicionalEntity> findById(int id);

}
