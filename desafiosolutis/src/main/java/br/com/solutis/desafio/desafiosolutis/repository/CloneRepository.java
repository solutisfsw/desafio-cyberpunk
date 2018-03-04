package br.com.solutis.desafio.desafiosolutis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.solutis.desafio.desafiosolutis.models.Clone;

@Repository
public interface CloneRepository extends JpaRepository<Clone, Integer>{

}
