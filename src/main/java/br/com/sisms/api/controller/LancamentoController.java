package br.com.sisms.api.controller;

import br.com.sisms.api.filter.LancamentoFilter;
import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.AtendimentoDTO;
import br.com.sisms.api.model.dto.LancamentoDTO;
import br.com.sisms.api.model.dto.LancamentoTotalDTO;
import br.com.sisms.api.model.enums.MessageEnum;
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
    public ResponseEntity<Response<LancamentoDTO>> create(@Valid @RequestBody final LancamentoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Exclui um lançamento.")
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(new Response(MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Altera um lancamento.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<List<LancamentoDTO>>> update(@PathVariable final Long id, @Valid @RequestBody final LancamentoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna uma lista paginada de lançamentos por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<Page<LancamentoDTO>>> findByFilter(@RequestBody PageableFilter<LancamentoFilter> filter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(filter), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna um lançamento por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<AtendimentoDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findByIdWithPermission(id), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna o total de lançamentos por filtros.")
    @PostMapping(path = "/findTotalByFilter")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<LancamentoTotalDTO>> findTotalByFilter(@RequestBody PageableFilter<LancamentoFilter> filter) {
        return ResponseEntity.ok().body(new Response(service.findTotalByFilter(filter), MessageEnum.SUCESSO.toString()));
    }

}
