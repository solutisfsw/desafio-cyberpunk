package br.com.clone.exception;

public class CloneNotFoundExcption extends RuntimeException {
	
	private static final long serialVersionUID = 1l;
	
	public CloneNotFoundExcption(String mensagem) {
		super(mensagem);
	}
	
	public CloneNotFoundExcption(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	

}
