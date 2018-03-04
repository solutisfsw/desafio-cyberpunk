package com.fabrica.resource;

import com.fabrica.model.Clone;
import com.fabrica.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin("${origem-permitida}")
// Tag/expressão para permitir o acesso de outras origens(Pode ser alterada em application.properties
public class CloneResource {

    Date dataAtual = new Date();

    @Autowired
    private CloneRepository cloneRepository;


    //Método que retorna a lista de clones
    @GetMapping("/clone")
    public List<Clone> listar()
    {
        return cloneRepository.findAll();
    }
    //Método para inserir um clone
    @PostMapping("/clone")
    public Clone clonar (@RequestBody @Valid Clone clone)
    {
        clone.setData(dataAtual);
        return cloneRepository.save(clone);
    }
    //Método que altera um clone
    @PutMapping("/clone")
    public Clone atualizar(@RequestBody @Valid Clone clone) {
        return cloneRepository.save(clone);
    }
    //Método para exclusão de um clone
    @DeleteMapping(path= {"/clone/{id}"})
    public void deletar(@PathVariable("id") Long id) {
        cloneRepository.delete(id);
    }



}
