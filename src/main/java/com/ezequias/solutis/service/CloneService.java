package com.ezequias.solutis.service;

import com.ezequias.solutis.exception.CloneNaoEncontradoException;
import com.ezequias.solutis.exception.UnicidadeNomeExeption;
import com.ezequias.solutis.model.Clone;

public interface CloneService {

    Iterable<Clone> findAll();

    Clone findByNome(String nome) throws CloneNaoEncontradoException;

    Clone create(Clone clone) throws UnicidadeNomeExeption;

    Clone update(String nome, Clone clone) throws CloneNaoEncontradoException, UnicidadeNomeExeption;

    Clone remove(String nome) throws CloneNaoEncontradoException;


}
