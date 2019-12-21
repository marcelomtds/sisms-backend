package br.com.sisms.api.controller;

import br.com.sisms.api.filter.AtendimentoFilter;
import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.AtendimentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.AtendimentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Atendimento")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/atendimento", produces = MediaType.APPLICATION_JSON_VALUE)
public class AtendimentoController {

    private final AtendimentoService service;

    @ApiOperation(value = "Inclui um atendimento.")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<AtendimentoDTO>> create(@Valid @RequestBody final AtendimentoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Altera um atendimento.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<AtendimentoDTO>> update(@PathVariable final Long id, @Valid @RequestBody final AtendimentoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna uma lista paginada de atendimentos por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<Page<AtendimentoDTO>>> findByFilter(@RequestBody final PageableFilter<AtendimentoFilter> filter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(filter), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna a quantidade de atendimentos realizados por sessão e filtros.")
    @GetMapping(path = "/findTotalBySession/{pacienteId}/{categoriaAtendimentoId}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<Long>> findTotalBySession(@PathVariable final Long pacienteId, @PathVariable final Long categoriaAtendimentoId) {
        return ResponseEntity.ok().body(new Response(service.findTotalBySession(pacienteId, categoriaAtendimentoId), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna a quantidade de atendimentos realizados por pacote e filtros.")
    @GetMapping(path = "/findTotalByPackage/{pacienteId}/{pacoteId}/{categoriaAtendimentoId}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<Long>> findTotalByPackage(@PathVariable final Long pacienteId, @PathVariable final Long pacoteId, @PathVariable final Long categoriaAtendimentoId) {
        return ResponseEntity.ok().body(new Response(service.findTotalByPackage(pacienteId, pacoteId, categoriaAtendimentoId), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna um atendimento por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<AtendimentoDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findByIdWithPermission(id), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna uma lista de atendimentos pelo id do pacote.")
    @GetMapping(path = "/findByPackage/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<List<AtendimentoDTO>>> findByPackage(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findByPacote(id), MessageEnum.SUCESSO.toString()));
    }

}