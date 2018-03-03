package br.com.clone.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.clone.exception.CloneAlreadyExistException;
import br.com.clone.exception.CloneNotFoundExcption;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	//Clone
	
	@ExceptionHandler(CloneNotFoundExcption.class)
	public ResponseEntity<ErrorDetails> handlerCloneNotFoundException(CloneNotFoundExcption e, 
			HttpServletRequest request){
		
		e.printStackTrace();
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus((long)4041);
		error.setTitle("Clone not found");
		error.setMessage(e.getMessage());
		error.setUrl("http://error.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(CloneAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerCloneAlreadyExistException(CloneAlreadyExistException e, 
			HttpServletRequest request){
		
		e.printStackTrace();
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus((long)4091);
		error.setTitle("Clone already exist");
		error.setMessage(e.getMessage());
		error.setUrl("http://error.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
		
	}

}
