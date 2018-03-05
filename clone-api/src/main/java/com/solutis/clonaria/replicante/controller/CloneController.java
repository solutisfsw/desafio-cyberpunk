package com.solutis.clonaria.replicante.controller;

import java.util.List;

import javax.validation.Valid;

import com.solutis.clonaria.replicante.exception.CloneExceptions;
import com.solutis.clonaria.replicante.model.Clone;
import com.solutis.clonaria.replicante.service.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@Controller
@RequestMapping("cloneCentral")
public class CloneController {

	
	@Autowired
    private CloneService cloneService;

	@GetMapping("{id}")
    public ResponseEntity<Clone> getCloneById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cloneService.getCloneById(id).orElseThrow(CloneExceptions::new));
    }

 
	@GetMapping
    public ResponseEntity<Iterable<Clone>> getAllClones() {
        return ResponseEntity.ok(cloneService.getAllClones());
    }
	
	@PostMapping
    public ResponseEntity<Clone> addClone(@Valid @RequestBody Clone clone) {
        return new ResponseEntity<>(cloneService.addClone(clone), HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteClone(@PathVariable("id") Long id) {
        cloneService.deleteClone(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
