package com.clones.desafios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clones.desafios.model.Clone;

public interface CloneRepository extends JpaRepository<Clone, Long>{
	@Query("select case when count(c.nome) > 0 then true else false end from Clone c where nome = :nome")
	Boolean buscaPeloNome(@Param("nome") String nome);
}
