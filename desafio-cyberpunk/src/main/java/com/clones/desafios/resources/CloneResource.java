package com.clones.desafios.resources;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.clones.desafios.model.Clone;
import com.clones.desafios.services.CloneService;

@RestController
@CrossOrigin("${origem-permitida}")
public class CloneResource {
	@Autowired
	private CloneService cloneService;

	@GetMapping("/clones")
	public List<Clone> listar() {
		return cloneService.listarTodos();
	}

	@PostMapping("/clones")
	@ResponseBody
	public ResponseEntity<?> adicionar(@RequestBody @Valid Clone clone, RedirectAttributes model) {
		Boolean encontrado = cloneService.consultaNome(clone.getNome());
		if (!encontrado) {
			cloneService.salvar(clone);
			return ResponseEntity.ok(clone);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}

	@DeleteMapping(path = { "/clones/{id}" })
	public void deletar(@PathVariable("id") Long id) {
		cloneService.deletar(id);
	}

	@PutMapping("/clones")
	public Clone atualizar(@RequestBody @Valid Clone clone) {
		return cloneService.atualizar(clone);
	}

}