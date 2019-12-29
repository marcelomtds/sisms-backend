package br.com.sisms.api.response;

import br.com.sisms.api.model.dto.LancamentoTotalDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LancamentoResponse<T> {

    public LancamentoResponse(final T result, final LancamentoTotalDTO total, final String message, final List<String> errors) {
        this.result = result;
        this.total = total;
        this.message = message;
        this.errors = errors;
    }

    private T result = (T) new Object();
    private LancamentoTotalDTO total = new LancamentoTotalDTO();
    private String message = StringUtils.EMPTY;
    private List<String> errors = new ArrayList<>();

}
