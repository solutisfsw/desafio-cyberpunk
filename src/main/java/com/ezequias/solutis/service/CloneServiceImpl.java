package com.ezequias.solutis.service;

import com.ezequias.solutis.exception.CloneNaoEncontradoException;
import com.ezequias.solutis.exception.UnicidadeNomeExeption;
import com.ezequias.solutis.model.Clone;
import com.ezequias.solutis.persistence.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Service
public class CloneServiceImpl implements CloneService {

    private CloneRepository provider;

    public CloneServiceImpl(CloneRepository provider) {
        this.provider = provider;
    }

    @Override
    public Iterable<Clone> findAll() {
        Iterable<Clone> listaClones = provider.findAll();
        return listaClones;
    }

    @Override
    public Clone findByNome(String nome) throws CloneNaoEncontradoException {
        Optional<Clone> clone = provider.findByNome(nome);
        return clone.orElseThrow(() -> new CloneNaoEncontradoException("Não existe clone com o nome '" + nome + "'"));
    }

    @Override
    public Clone create(Clone clone) throws UnicidadeNomeExeption {
        Optional<Clone> optional = provider.findByNome(clone.getNome());
        if (optional.isPresent()) {
            throw new UnicidadeNomeExeption("Já existe um clone cadastrado com o nome '" + clone.getNome() + "'");
        }
        return provider.save(clone);
    }

    @Override
    public Clone update(String nome, Clone clone) throws CloneNaoEncontradoException, UnicidadeNomeExeption {
        Optional<Clone> optional = provider.findByNome(nome);
        Clone cloneNew = optional.orElseThrow(() -> new CloneNaoEncontradoException("Não existe clone com o nome '" + nome + "'"));

        cloneNew.setNome(clone.getNome());
        cloneNew.setIdade(clone.getIdade());
        cloneNew.setDataCriacao(clone.getDataCriacao());
        cloneNew.setAdicionais(clone.getAdicionais());

        try {
            return provider.save(cloneNew);
        } catch (DataIntegrityViolationException c) {
            throw new UnicidadeNomeExeption(String.format("Este nome '%s' já está em uso", clone.getNome()));
        }

    }

    @Override
    public Clone remove(String nome) throws CloneNaoEncontradoException {
        Optional<Clone> optional = provider.findByNome(nome);
        Clone clone = optional.orElseThrow(() -> new CloneNaoEncontradoException("Não existe clone com o nome '" + nome + "'"));
        provider.delete(clone);
        return clone;
    }

}
