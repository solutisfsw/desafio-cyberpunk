package com.clones.desafios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clones.desafios.model.Elemento;

public interface ElementoRepository extends JpaRepository<Elemento, Long> {
	//@Query("select m from Membro m fetch join Clone where c.clone_id = :id")
//	/List<Membro> buscarMembros(long id);

}
