package com.clones.desafios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clones.desafios.model.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {

}
