package com.solutis.clones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.clones.model.Clone;

public interface CloneRepository extends JpaRepository<Clone, Long> {

}
