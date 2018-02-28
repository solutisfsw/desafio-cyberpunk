package com.solutis.clonaria.replicante.controller;

import java.util.List;

import com.solutis.clonaria.replicante.model.Clone;
import com.solutis.clonaria.replicante.service.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;



@Controller
@RequestMapping("cloneCentral")
public class CloneController {

	
	@Autowired
    private CloneService cloneService;

    @GetMapping("clone/{id}")
    public ResponseEntity<Clone> getCloneById(@PathVariable("id") Long id) {
        Clone article = cloneService.getCloneById(id);
        if(article == null){
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<>(article, HttpStatus.OK);
    }
    @GetMapping("todos")
    public ResponseEntity<List<Clone>> getAllClones() {
        List<Clone> list = cloneService.getAllClones();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("adicionar")
    public ResponseEntity<Void> addClone(@RequestBody Clone clone, UriComponentsBuilder builder) {
        cloneService.addClone(clone);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(clone.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteClone(@PathVariable("id") Long id) {
        cloneService.deleteClone(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
