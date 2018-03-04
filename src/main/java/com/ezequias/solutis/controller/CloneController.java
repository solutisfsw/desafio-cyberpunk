package com.ezequias.solutis.controller;

import com.ezequias.solutis.exception.CloneNaoEncontradoException;
import com.ezequias.solutis.exception.UnicidadeNomeExeption;
import com.ezequias.solutis.exception.ValidacaoFieldException;
import com.ezequias.solutis.model.Clone;
import com.ezequias.solutis.persistence.CloneRepository;
import com.ezequias.solutis.service.CloneService;
import com.ezequias.solutis.service.CloneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cyberpunk/clones")
public class CloneController {

    @Autowired
    CloneRepository repository;

    @Autowired
    private CloneService service = new CloneServiceImpl(repository);

    @GetMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<Iterable<Clone>> findAll() {
        Iterable<Clone> object = service.findAll();
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public ResponseEntity<Clone> findByNome(@PathVariable("nome") String nome) throws CloneNaoEncontradoException {
        return new ResponseEntity<>(service.findByNome(nome), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Clone> create(@RequestBody @Valid Clone clone, BindingResult result) throws UnicidadeNomeExeption, ValidacaoFieldException {
        if (result.hasErrors()) {
            throw new ValidacaoFieldException(result.getFieldErrors());
        }
        Clone object = service.create(clone);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{nome}", produces = "application/json")
    public ResponseEntity<Clone> update(@PathVariable("nome") String nome, @RequestBody @Valid Clone clone, BindingResult result) throws UnicidadeNomeExeption, CloneNaoEncontradoException, ValidacaoFieldException {
        if (result.hasErrors()) {
            throw new ValidacaoFieldException(result.getFieldErrors());
        }
        Clone object = service.update(nome, clone);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{nome}")
    public ResponseEntity<Clone> remove(@PathVariable("nome") String nome) throws CloneNaoEncontradoException {
        Clone clone = service.remove(nome);
        return new ResponseEntity<>(clone, HttpStatus.OK);
    }


    @ExceptionHandler({ValidacaoFieldException.class})
    public ResponseEntity<Erro> handleValidacaoFildsException(ValidacaoFieldException e) {
        return new ResponseEntity<>(new Erro(e.cleanMensagem()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UnicidadeNomeExeption.class})
    public ResponseEntity<Erro> handleUnicidadeNomeException(UnicidadeNomeExeption e) {
        return new ResponseEntity<>(new Erro(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CloneNaoEncontradoException.class})
    public ResponseEntity<Erro> handleCloneNaoEncontradoException(CloneNaoEncontradoException e) {
        return new ResponseEntity<>(new Erro(e), HttpStatus.NOT_FOUND);
    }

    class Erro {
        private final List<ModelMap> errors;

        public Erro(Exception err) {
            this.errors = getModelMap(err);
        }

        public Erro(List<ModelMap> err) {
            this.errors = err;
        }

        private List<ModelMap> getModelMap(Exception error) {
            List<ModelMap> list = new ArrayList<>();
            ModelMap map = new ModelMap();
            map.put("defaultMessage", error.getMessage());
            map.put("tipo", true);
            list.add(map);
            return list;
        }

        public List<ModelMap> getErrors() {
            return errors;
        }
    }

}
