package com.ezequias.solutis.persistence;

import com.ezequias.solutis.model.Clone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CloneRepository extends CrudRepository<Clone, Long> {

    @Query("SELECT bean FROM Clone bean WHERE bean.nome = :nome")
    Optional<Clone> findByNome(@Param("nome") String nome);

}
