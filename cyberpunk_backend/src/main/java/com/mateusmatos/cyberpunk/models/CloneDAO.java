package com.mateusmatos.cyberpunk.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface CloneDAO extends CrudRepository<Clone, Long> {

	  public Clone findByNome(String nome);

	}
