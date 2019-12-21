package br.com.sisms.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {

    public Response(final String message) {
        this.message = message;
    }

    public Response(final T result, final String message) {
        this.result = result;
        this.message = message;
    }

    public Response(final T result, final String message, final List<String> errors) {
        this.result = result;
        this.message = message;
        this.errors = errors;
    }

    public Response(final String message, final List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    private T result = (T) new Object();
    private String message = StringUtils.EMPTY;
    private List<String> errors = new ArrayList<>();

}
