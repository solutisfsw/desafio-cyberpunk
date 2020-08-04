package com.haeralis.attribute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeralis.attribute.model.AttributeType;

/**
 * Simulador de repositório para tipos de Atributos
 * @author Haeralis (GledsonMotta)
 *
 */
public interface AttributeTypeRepository extends JpaRepository<AttributeType, Long> {

}
