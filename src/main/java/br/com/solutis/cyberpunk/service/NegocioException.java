package br.com.solutis.cyberpunk.service;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String msg) {
		super(msg);
	}
	
}
