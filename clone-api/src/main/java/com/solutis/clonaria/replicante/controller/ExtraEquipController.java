package com.solutis.clonaria.replicante.controller;

import com.solutis.clonaria.replicante.exception.CloneExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solutis.clonaria.replicante.service.ExtraEquipService;
import com.solutis.clonaria.replicante.model.ExtraEquip;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@Controller
@RequestMapping("extraEquip")
public class ExtraEquipController {
 @Autowired
    private ExtraEquipService extraEquipService;

    @GetMapping("{id}")
    public ResponseEntity<ExtraEquip> getExtraEquipById(@PathVariable("id") Long id) {
        return ResponseEntity.ok( extraEquipService.getExtraEquipById(id).orElseThrow(CloneExceptions::new));
    }
    @GetMapping
    public ResponseEntity<Iterable<ExtraEquip>> getAllArticles() {
        return ResponseEntity.ok(extraEquipService.getAllExtraEquip());
    }

}