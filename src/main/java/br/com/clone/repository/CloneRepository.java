package br.com.clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clone.model.Clone;

@Repository
public interface CloneRepository extends JpaRepository<Clone, Long>{



}
