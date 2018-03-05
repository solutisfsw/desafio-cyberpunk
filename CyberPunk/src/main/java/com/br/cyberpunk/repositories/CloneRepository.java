package com.br.cyberpunk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.cyberpunk.model.Clone;

@Repository
public interface CloneRepository extends JpaRepository<Clone, Long> {
	Clone findById(Long id);
			@Transactional(readOnly=true)
	Clone findByNome(String nome);
}
