package com.clones.desafios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceIntenalServerError extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceIntenalServerError(){
		super();
	}
	public ResourceIntenalServerError(String message, Throwable cause){
		super(message, cause);
	}
}
