package br.com.sisms.api.exception;

import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity badCredentialsException(BadCredentialsException e, WebRequest request) {
        return handleExceptionInternal(e, new Response(MessageEnum.MSG0046.toString()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity accessDeniedException(AccessDeniedException e, WebRequest request) {
        return handleExceptionInternal(e, new Response(MessageEnum.MSG0036.toString()), new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity resourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        return handleExceptionInternal(e, new Response(e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity businessException(BusinessException e, WebRequest request) {
        return handleExceptionInternal(e, new Response(e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(e, new Response(MessageEnum.MSG0035.toString(), getErrors(e)), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private List<String> getErrors(MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
    }

}
