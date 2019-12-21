package br.com.sisms.api.exception;

import br.com.sisms.api.model.enums.MessageEnum;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3023263289769633172L;

    public ResourceNotFoundException() {
        super(MessageEnum.RECURSO_NAO_ENCONTRADO.toString());
    }

    public ResourceNotFoundException(final String message) {
        super(message);
    }

}
