package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.filter.AtendimentoFilter;
import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.AtendimentoDTO;
import br.com.sisms.api.model.entity.Atendimento;
import br.com.sisms.api.model.entity.TipoAtendimento;
import br.com.sisms.api.model.entity.Usuario;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.enums.PerfilEnum;
import br.com.sisms.api.model.enums.TipoAtendimentoEnum;
import br.com.sisms.api.model.mapper.AtendimentoMapper;
import br.com.sisms.api.repository.AtendimentoRepository;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository repository;
    private final AtendimentoMapper mapper;
    private final UsuarioService usuarioService;
    private final ImagemAtendimentoService imagemAtendimentoService;
    private final PreAtendimentoOutraMedidaService preAtendimentoOutraMedidaService;
    private final PosAtendimentoOutraMedidaService posAtendimentoOutraMedidaService;
    private final PacoteService pacoteService;
    private final PacienteService pacienteService;
    private final CategoriaAtendimentoService categoriaAtendimentoService;
    private final OutraMedidaService outraMedidaService;

    public AtendimentoDTO createOrUpdate(final Long id, final AtendimentoDTO dtoSource) {
        validateResources(dtoSource);
        validatePeriod(dtoSource.getPreAtendimentoData(), dtoSource.getPosAtendimentoData(), MessageEnum.DATA_HORA_PRE_POS_ATENDIMENTO_INTERVALO.toString());
        Atendimento entity;
        if (Objects.nonNull(id)) {
            AtendimentoDTO dtoTarget = findByIdWithPermission(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id", "tipoAtendimentoId", "numero", "pacoteId", "pacienteId", "usuarioId", "preAtendimentoId", "posAtendimentoId", "categoriaAtendimentoId");
            imagemAtendimentoService.deleteAllByAtendimentoId(id);
            preAtendimentoOutraMedidaService.deleteAllByPreAtendimentoId(dtoTarget.getPreAtendimentoId());
            if (Objects.nonNull(dtoTarget.getPosAtendimentoId())) {
                posAtendimentoOutraMedidaService.deleteAllByPosAtendimentoId(dtoTarget.getPosAtendimentoId());
            }
            entity = mapper.toEntity(dtoTarget);
        } else {
            dtoSource.setUsuarioId(usuarioService.getCurrentSessionUser().getId());
            entity = mapper.toEntity(dtoSource);
            entity.setTipoAtendimento(checkTipoAtendimento(entity));
            if (entity.getTipoAtendimento().getId().equals(TipoAtendimentoEnum.PACOTE.getTipoAtendimento())) {
                entity.setNumero(repository.findTotalByPackage(entity.getPaciente().getId(), entity.getPacote().getId(), entity.getCategoriaAtendimento().getId()) + 1L);
            } else {
                entity.setNumero(repository.findTotalBySession(entity.getPaciente().getId(), entity.getCategoriaAtendimento().getId()) + 1L);
            }
        }
        if (entity.getTipoAtendimento().getId().equals(TipoAtendimentoEnum.SESSAO.getTipoAtendimento())) {
            entity.setPacote(null);
        }
        entity.getImagens().forEach(imagem -> {
            imagem.setId(null);
            imagem.setAtendimento(entity);
        });
        if (!ObjectUtils.isEmpty(entity.getPreAtendimento().getPreAtendimentoOutrasMedidas())) {
            entity.getPreAtendimento().getPreAtendimentoOutrasMedidas().forEach(item -> {
                item.setId(null);
                outraMedidaService.findById(item.getOutraMedida().getId());
                item.setPreAtendimento(entity.getPreAtendimento());
            });
            entity.getPosAtendimento().getPosAtendimentoOutrasMedidas().forEach(item -> {
                item.setId(null);
                outraMedidaService.findById(item.getOutraMedida().getId());
                item.setPosAtendimento(entity.getPosAtendimento());
            });
        }
        if (entity.getAberto()) {
            entity.setPosAtendimento(null);
        } else {
            validadeDatePosAtendimento(entity.getPosAtendimento().getData());
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public Long findTotalBySession(final Long pacienteId, final Long categoriaAtendimentoId) {
        return repository.findTotalBySession(pacienteId, categoriaAtendimentoId);
    }

    @Transactional(readOnly = true)
    public Long findTotalByPackage(final Long pacienteId, final Long pacoteId, final Long categoriaAtendimentoId) {
        return repository.findTotalByPackage(pacienteId, pacoteId, categoriaAtendimentoId);
    }

    @Transactional(readOnly = true)
    public Page<AtendimentoDTO> findByFilter(final PageableFilter<AtendimentoFilter> filter) {
        filter.setOrderBy(StringUtils.isBlank(filter.getOrderBy()) ? "id" : filter.getOrderBy());
        Pageable pageable = PageRequest.of(
                filter.getCurrentPage(),
                filter.getPageSize(),
                Sort.Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        filter.setFilter(Objects.isNull(filter.getFilter()) ? new AtendimentoFilter() : filter.getFilter());
        validatePeriod(filter.getFilter().getPreAtendimentoData(), filter.getFilter().getPosAtendimentoData(), MessageEnum.DATA_HORA_PRE_POS_ATENDIMENTO_INTERVALO.toString());
        Usuario user = usuarioService.getCurrentSessionUser();
        if (user.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            filter.getFilter().setUsuarioId(user.getId());
        }
        return repository.findByFilter(
                filter.getFilter().getTipoAtendimentoId(),
                filter.getFilter().getPacienteId(),
                filter.getFilter().getUsuarioId(),
                filter.getFilter().getPreAtendimentoData(),
                filter.getFilter().getPosAtendimentoData(),
                filter.getFilter().getAberto(),
                filter.getFilter().getCategoriaAtendimentoId(),
                pageable).map(mapper::toDTO);
    }

    @Transactional(readOnly = true)
    public AtendimentoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG00027.toString())));
    }

    @Transactional(readOnly = true)
    public AtendimentoDTO findByIdWithPermission(final Long id) {
        AtendimentoDTO dto = findById(id);
        checkUserPermission(dto);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<AtendimentoDTO> findByPacote(final Long id) {
        return mapper.toDTO(repository.findByPacote(id));
    }

    private void validatePeriod(final LocalDateTime startDateTime, final LocalDateTime endDateTime, final String message) {
        if (Objects.nonNull(startDateTime) && Objects.nonNull(endDateTime) && Util.isInvalidPeriod(startDateTime, endDateTime)) {
            throw new BusinessException(message);
        }
    }

    private void validateResources(final AtendimentoDTO dto) {
        if (Objects.nonNull(dto.getPacoteId())) {
            pacoteService.findById(dto.getPacoteId());
        }
        pacienteService.findById(dto.getPacienteId());
        categoriaAtendimentoService.findById(dto.getCategoriaAtendimentoId());
    }

    private void validadeDatePosAtendimento(LocalDateTime date) {
        if (Objects.isNull(date)) {
            throw new BusinessException(MessageEnum.DATA_HORA_POS_ATENDIMENTO_OBRIGATORIO.toString());
        }
    }

    private void checkUserPermission(final AtendimentoDTO atendimentoDTO) {
        Usuario usuario = usuarioService.getCurrentSessionUser();
        if (!atendimentoDTO.getUsuarioId().equals(usuario.getId()) && usuario.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            throw new AccessDeniedException(MessageEnum.USUARIO_SEM_PERMISSAO.toString());
        }
    }

    private TipoAtendimento checkTipoAtendimento(final Atendimento atendimento) {
        TipoAtendimento tipoAtendimento = new TipoAtendimento();
        if (Objects.nonNull(atendimento.getPacote()) && Objects.nonNull(atendimento.getPacote().getId())) {
            tipoAtendimento.setId(TipoAtendimentoEnum.PACOTE.getTipoAtendimento());
        } else {
            tipoAtendimento.setId(TipoAtendimentoEnum.SESSAO.getTipoAtendimento());
        }
        return tipoAtendimento;
    }

}
