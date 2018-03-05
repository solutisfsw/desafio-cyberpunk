package com.br.cyberpunk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.cyberpunk.model.EquipAdicionais;

@Repository
public interface EquipRepository extends JpaRepository<EquipAdicionais, Long> {

}
