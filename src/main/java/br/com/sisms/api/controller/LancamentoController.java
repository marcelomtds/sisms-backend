package br.com.sisms.api.controller;

import br.com.sisms.api.filter.LancamentoFilter;
import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.LancamentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.request.LancamentoRequest;
import br.com.sisms.api.response.LancamentoResponse;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.LancamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Lançamento")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/lancamento")
public class LancamentoController {

    private final LancamentoService service;

    @ApiOperation(value = "Inclui um lançamento.")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<LancamentoDTO>> create(@Valid @RequestBody final LancamentoRequest request) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, request), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Exclui um lançamento.")
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(new Response(null, MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Altera um lancamento.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<List<LancamentoDTO>>> update(@PathVariable final Long id, @Valid @RequestBody final LancamentoRequest request) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, request), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna uma lista paginada de lançamentos por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<LancamentoResponse<Page<LancamentoDTO>>> findByFilter(@RequestBody PageableFilter<LancamentoFilter> filter) {
        return ResponseEntity.ok().body(new LancamentoResponse(service.findByFilter(filter), service.findTotalByFilter(filter), MessageEnum.SUCESSO.toString()));
    }

}
