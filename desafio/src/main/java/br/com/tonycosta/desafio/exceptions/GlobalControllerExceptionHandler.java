package br.com.tonycosta.desafio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<String> entidadeNaoEncontrada(EntidadeNaoEncontradaException e) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
}
