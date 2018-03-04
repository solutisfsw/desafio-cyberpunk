package com.desafio.angular.repositories;

import com.desafio.angular.models.Clone;
import org.springframework.data.repository.CrudRepository;

public interface CloneRepository extends CrudRepository<Clone, String> {
    @Override
    Clone findOne(String id);

    @Override
    void delete(Clone deleted);
}
