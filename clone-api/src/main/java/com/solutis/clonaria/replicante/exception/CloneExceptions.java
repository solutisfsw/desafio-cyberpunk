package com.solutis.clonaria.replicante.exception;

public class CloneExceptions extends RuntimeException{
	public CloneExceptions() {
        super();
    }
    public CloneExceptions(String message, Throwable cause) {
        super(message, cause);
    }
    public CloneExceptions(String message) {
        super(message);
    }
    public CloneExceptions(Throwable cause) {
        super(cause);
    }
}
