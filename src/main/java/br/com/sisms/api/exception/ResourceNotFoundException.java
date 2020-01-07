package br.com.sisms.api.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3023263289769633172L;

    public ResourceNotFoundException(final String message) {
        super(message);
    }

}
