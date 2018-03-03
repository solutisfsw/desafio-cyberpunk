package br.com.clone.exception;

public class CloneAlreadyExistException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CloneAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public CloneAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	

}
