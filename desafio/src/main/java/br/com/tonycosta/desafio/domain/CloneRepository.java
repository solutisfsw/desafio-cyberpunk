package br.com.tonycosta.desafio.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloneRepository extends JpaRepository<Clone, Long> {

	Page<Clone> findByNomeContainingIgnoreCase(Pageable pageable, String q);

	Clone findByNomeIgnoreCase(String nome);
}
