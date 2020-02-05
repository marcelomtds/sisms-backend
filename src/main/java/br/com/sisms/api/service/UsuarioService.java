package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.SenhaDTO;
import br.com.sisms.api.model.dto.UsuarioDTO;
import br.com.sisms.api.model.entity.Usuario;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.enums.PerfilEnum;
import br.com.sisms.api.model.filter.PacienteUsuarioFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.UsuarioMapper;
import br.com.sisms.api.repository.UsuarioRepository;
import br.com.sisms.api.util.Util;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final ProfissaoService profissaoService;
    private final SexoService sexoService;
    private final LocalidadeService localidadeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioService(final UsuarioRepository repository, final UsuarioMapper mapper, final ProfissaoService profissaoService, final SexoService sexoService, final LocalidadeService localidadeService) {
        this.repository = repository;
        this.mapper = mapper;
        this.profissaoService = profissaoService;
        this.sexoService = sexoService;
        this.localidadeService = localidadeService;
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findByCpf(final String cpf) {
        return mapper.toDTO(repository.findByCpf(cpf));
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findByCpfAndAtivoIsTrue(final String cpf) {
        return mapper.toDTO(repository.findByCpfAndAtivoIsTrue(cpf));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAllBirthdaysMonth() {
        return mapper.toDTO(repository.findAllBirthdaysMonth());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0043.toString())));
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findByIdWithPermission(final Long id) {
        UsuarioDTO dto = findById(id);
        checkUserPermission(dto);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> findByFilter(final PageableFilter<PacienteUsuarioFilter> filter) {
        filter.setOrderBy(StringUtils.isBlank(filter.getOrderBy()) ? "id" : filter.getOrderBy());
        Pageable pageable = PageRequest.of(
                filter.getCurrentPage(),
                filter.getPageSize(),
                Sort.Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        filter.setFilter(Objects.isNull(filter.getFilter()) ? new PacienteUsuarioFilter() : filter.getFilter());
        return repository.findByFilter(
                filter.getFilter().getNomeCompleto(),
                filter.getFilter().getCpf(),
                filter.getFilter().getAtivo(),
                filter.getFilter().getSexoId(),
                filter.getFilter().getLocalidadeId(),
                filter.getFilter().getUfId(),
                filter.getFilter().getCelular(),
                filter.getFilter().getCelularRecado(),
                filter.getFilter().getResidencial(),
                filter.getFilter().getComercial(),
                pageable).map(mapper::toDTO);
    }

    @Transactional(readOnly = true)
    public Usuario getCurrentSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return repository.findByCpf(authentication.getName());
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return mapper.toDTO(repository.findAll(Sort.by(Sort.Direction.ASC, "nomeCompleto")));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAllActive() {
        return mapper.toDTO(repository.findAllByAtivoIsTrueOrderByNomeCompletoAsc());
    }

    public UsuarioDTO activeOrInative(final Long id) {
        UsuarioDTO dto = findById(id);
        if (getCurrentSessionUser().getId().equals(dto.getId())) {
            throw new BusinessException(MessageEnum.MSG0058.toString());
        }
        dto.setAtivo(BooleanUtils.negate(dto.getAtivo()));
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public UsuarioDTO updatePassword(final SenhaDTO dto) {
        validateRequiredPasswords(dto.getNovaSenha(), dto.getNovaSenhaConfirmacao());
        UsuarioDTO sessionUserDTO = mapper.toDTO(getCurrentSessionUser());
        if (!passwordEncoder.matches(dto.getSenhaAtual(), sessionUserDTO.getSenha())) {
            throw new BusinessException(MessageEnum.MSG0005.toString());
        }
        sessionUserDTO.setSenha(passwordEncoder.encode(dto.getNovaSenha()));
        return mapper.toDTO(repository.save(mapper.toEntity(sessionUserDTO)));
    }

    public UsuarioDTO createOrUpdate(final Long id, final UsuarioDTO dtoSource) {
        validateResources(dtoSource);
        checkDate(dtoSource.getDataNascimento());
        validateTelefoneContato(dtoSource);
        Usuario entity;
        if (Objects.nonNull(id)) {
            UsuarioDTO dtoTarget = findById(id);
            checkUserPermissionUpdate(dtoTarget);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id", "cpf", "ativo", "senha", "senhaConfirmacao", "contatoId", "enderecoId", "perfilId", "dataCadastro");
            entity = mapper.toEntity(dtoTarget);
        } else {
            validateRequiredPasswords(dtoSource.getSenha(), dtoSource.getSenhaConfirmacao());
            dtoSource.setPerfilId(PerfilEnum.USUARIO.getPerfil());
            dtoSource.setSenha(passwordEncoder.encode(dtoSource.getSenha()));
            entity = mapper.toEntity(dtoSource);
        }
        validateDuplicityByCpf(entity);
        return mapper.toDTO(repository.save(entity));
    }

    private void checkUserPermission(final UsuarioDTO usuarioDTO) {
        Usuario usuario = getCurrentSessionUser();
        if (!usuarioDTO.getId().equals(usuario.getId()) && usuario.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            throw new AccessDeniedException(MessageEnum.MSG0036.toString());
        }
    }

    private void checkUserPermissionUpdate(final UsuarioDTO usuarioDTO) {
        Usuario usuario = getCurrentSessionUser();
        if (!usuarioDTO.getId().equals(usuario.getId())) {
            throw new AccessDeniedException(MessageEnum.MSG0036.toString());
        }
    }

    private void validateTelefoneContato(final UsuarioDTO dto) {
        if (StringUtils.isBlank(dto.getContatoCelular()) && StringUtils.isBlank(dto.getContatoCelularRecado())
                && StringUtils.isBlank(dto.getContatoResidencial()) && StringUtils.isBlank(dto.getContatoComercial())) {
            throw new BusinessException(MessageEnum.MSG0007.toString());
        }
    }

    private void validateDuplicityByCpf(final Usuario entity) {
        final UsuarioDTO dto = mapper.toDTO(repository.findByCpf(entity.getCpf()));
        if (Objects.nonNull(dto) && !dto.getId().equals(entity.getId())) {
            throw new BusinessException(MessageEnum.MSG0006.toString());
        }
    }

    private void validateRequiredPasswords(final String senha, final String senhaConfirmacao) {
        if (StringUtils.isBlank(senha)) {
            throw new BusinessException(MessageEnum.MSG0001.toString());
        }
        if (StringUtils.isBlank(senhaConfirmacao)) {
            throw new BusinessException(MessageEnum.MSG0002.toString());
        }
        if (!senha.equals(senhaConfirmacao)) {
            throw new BusinessException(MessageEnum.MSG0003.toString());
        }
    }

    private void checkDate(final LocalDate date) {
        if (Util.isCurrentDateBeforeDate(date)) {
            throw new BusinessException(MessageEnum.MSG0037.toString());
        }
    }

    private void validateResources(final UsuarioDTO dto) {
        profissaoService.findById(dto.getProfissaoId());
        sexoService.findById(dto.getSexoId());
        localidadeService.findById(dto.getEnderecoLocalidadeId());
    }

}
