package com.cyberpunk.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;

import com.cyberpunk.Entidade.Clone;

@Service
public interface RepositorioDeClones extends JpaRepository<Clone, Long>{

}
