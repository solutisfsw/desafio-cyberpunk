package br.com.tonycosta.desafio.web;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tonycosta.desafio.domain.Clone;
import br.com.tonycosta.desafio.events.RecursoCriadoEvent;
import br.com.tonycosta.desafio.services.CloneService;
import br.com.tonycosta.desafio.validators.CloneValidator;

@RestController
@RequestMapping("/api/clones")
public class CloneResource {
	
	@Autowired
	private CloneService service;
	@Autowired
	private ApplicationEventPublisher publisher;
	@Autowired
	private CloneValidator validator;

	@GetMapping
	public Page<Clone> buscaPaginada(@PageableDefault(page=0, size=20, sort="nome") Pageable pageable, 
			@RequestParam(defaultValue="") String q) {
		
		return service.lista(pageable, q);
	}
	
	@PostMapping
	public ResponseEntity<?> salva(@Valid @RequestBody Clone clone, BindingResult bindingResult, HttpServletResponse response) {
		validator.validate(clone, bindingResult);
		
		if(bindingResult.hasErrors()) 
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
				
		service.salva(clone);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clone.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clone);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clone> buscaPorId(@PathVariable Long id) {
		Clone clone = service.buscaPorId(id);
		
		return ResponseEntity.ok(clone);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Clone> buscaPorNome(@PathVariable String nome) {
		Clone clone = service.buscaPorNome(nome);
		
		return ResponseEntity.ok(clone);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edita(@PathVariable Long id, @Valid @RequestBody Clone clone, BindingResult bindingResult) {
		clone.setId(id);
		validator.validate(clone, bindingResult);		

		if(bindingResult.hasErrors())
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		
		service.edita(clone, id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		service.remove(id);
	}
}
