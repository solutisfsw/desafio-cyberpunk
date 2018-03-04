package com.desafio.angular.controllers;

import com.desafio.angular.models.Clone;
import com.desafio.angular.repositories.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloneController {

    @Autowired
    CloneRepository cloneRepository;

    @RequestMapping(method=RequestMethod.GET, value="/clones")
    public Iterable<Clone> clone() {
        return cloneRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/clones")
    public Clone save(@RequestBody Clone clone) {
        cloneRepository.save(clone);

        return clone;
    }

    @RequestMapping(method=RequestMethod.GET, value="/clones/{id}")
    public Clone show(@PathVariable String id) {
        return cloneRepository.findOne(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/clones/{id}")
    public Clone update(@PathVariable String id, @RequestBody Clone clone) {
        Clone c = cloneRepository.findOne(id);
        if(clone.getName() != null)
            c.setName(clone.getName());
        if(clone.getIdade() != null)
            c.setIdade(clone.getIdade());
        if(clone.getData_criacao() != null)
            c.setData_criacao(clone.getData_criacao());
          cloneRepository.save(c);
        return clone;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/clones/{id}")
    public String delete(@PathVariable String id) {
        Clone clone = cloneRepository.findOne(id);
        cloneRepository.delete(clone);

        return "";
    }
}
