package br.com.sisms.api.response;

import br.com.sisms.api.model.dto.LancamentoDTO;
import br.com.sisms.api.model.dto.LancamentoTotalResultDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@AllArgsConstructor
public class LancamentoResponse<T> {

    private T body;
    private LancamentoTotalResultDTO total;
    private String message;

}
