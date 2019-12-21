package br.com.sisms.api.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -5224443769327788027L;

	public BusinessException(String message) {
		super(message);
	}

}
