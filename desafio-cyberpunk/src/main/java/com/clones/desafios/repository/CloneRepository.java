package com.clones.desafios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clones.desafios.model.Clone;

public interface CloneRepository extends JpaRepository<Clone, Long>{

}
