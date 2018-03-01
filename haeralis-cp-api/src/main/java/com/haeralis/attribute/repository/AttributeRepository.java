package com.haeralis.attribute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haeralis.attribute.model.Attribute;

/**
 * Simulador de repositório para Atributos
 * @author Haeralis (GledsonMotta)
 *
 */
public interface AttributeRepository extends JpaRepository<Attribute, Long> {

	List<Attribute> findByName(String name);
}
