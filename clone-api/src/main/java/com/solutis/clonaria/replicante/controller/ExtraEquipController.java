package com.solutis.clonaria.replicante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solutis.clonaria.replicante.service.ExtraEquipService;
import com.solutis.clonaria.replicante.model.ExtraEquip;

@Controller
@RequestMapping("extraEquip")
public class ExtraEquipController {
	@Autowired
    private ExtraEquipService extraEquipService;

    @GetMapping("extraEquip/{id}")
    public ResponseEntity<ExtraEquip> getCloneById(@PathVariable("id") Long id) {
        ExtraEquip extraEquip = extraEquipService.getExtraEquipById(id);
        return new ResponseEntity<>(extraEquip, HttpStatus.OK);
    }
    @GetMapping("todos")
    public ResponseEntity<List<ExtraEquip>> getAllArticles() {
        List<ExtraEquip> list = extraEquipService.getAllExtraEquip();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
