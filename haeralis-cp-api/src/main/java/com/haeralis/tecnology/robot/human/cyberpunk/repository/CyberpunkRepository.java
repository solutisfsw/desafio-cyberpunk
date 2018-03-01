package com.haeralis.tecnology.robot.human.cyberpunk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeralis.tecnology.robot.human.cyberpunk.model.CyberpunkHumanRobot;

/**
 * Repository simulator for Cyberpunk Model
 * @author Haeralis (GledsonMotta)
 *
 */
public interface CyberpunkRepository extends JpaRepository<CyberpunkHumanRobot, Long> {
	
	List<CyberpunkHumanRobot> findAllByOrderByIdAscParentIdAscVersionAsc();
	
	List<CyberpunkHumanRobot> findById(Long id);
	
	List<CyberpunkHumanRobot> findByparentId(Long parentId);
	
	List<CyberpunkHumanRobot> findByName(String name);
	
	List<CyberpunkHumanRobot> findByNameAndIdNot(String name, Long id);
	
	List<CyberpunkHumanRobot> findByIdNotNull();
	
	List<CyberpunkHumanRobot> findByParentIdIsNull();
	
	List<CyberpunkHumanRobot> findByParentIdNotNullOrderByIdAscParentIdAscVersionAsc();
	
	CyberpunkHumanRobot findTopByParentIdOrderByVersionDesc(Long parentId);
}
