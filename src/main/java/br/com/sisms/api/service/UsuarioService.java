package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.PreCadastroUsuarioDTO;
import br.com.sisms.api.model.dto.SenhaDTO;
import br.com.sisms.api.model.dto.UsuarioDTO;
import br.com.sisms.api.model.entity.Perfil;
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
import java.util.Optional;

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

    public UsuarioDTO create(final PreCadastroUsuarioDTO dto) {
        validateEqualsPasswords(dto.getSenha(), dto.getSenhaConfirmacao());
        validateDuplicityByCpf(dto.getCpf());
        final Usuario usuario = new Usuario();
        usuario.setCpf(dto.getCpf());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setPerfil(createPerfil(PerfilEnum.USUARIO.getPerfil()));
        return mapper.toDTO(repository.save(usuario));
    }

    public UsuarioDTO update(final Long id, final UsuarioDTO dtoSource) {
        validateResources(dtoSource);
        checkDate(dtoSource.getDataNascimento());
        validateContato(dtoSource);
        Optional<Usuario> entity = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0043.toString())));
        final UsuarioDTO dtoTarget = mapper.toDTO(entity.get());
        checkUserPermissionUpdate(dtoTarget);
        BeanUtils.copyProperties(dtoSource, dtoTarget, "id", "cpf", "ativo", "senha", "senhaConfirmacao", "contatoId", "enderecoId", "perfilId", "dataCadastro", "cadastroCompleto");
        dtoTarget.setCadastroCompleto(Boolean.TRUE);
        dtoTarget.setSenha(entity.get().getSenha());
        return mapper.toDTO(repository.save(mapper.toEntity(dtoTarget)));
    }

    public UsuarioDTO completeRegistration(final Long id, final UsuarioDTO dto) {
        validateRequiredPasswords(dto.getSenha(), dto.getSenhaConfirmacao());
        validateEqualsPasswords(dto.getSenha(), dto.getSenhaConfirmacao());
        return update(id, dto);
    }

    @Transactional(readOnly = true)
    public Usuario authenticationByCpf(final String cpf) {
        final Usuario usuario = repository.findByCpf(cpf);
        if (Objects.isNull(usuario)) {
            throw new BusinessException(MessageEnum.MSG0046.toString());
        }
        return usuario;
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
        final UsuarioDTO dto = findById(id);
        checkUserPermission(dto);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<UsuarioDTO> findByFilter(final PageableFilter<PacienteUsuarioFilter> filter) {
        filter.setOrderBy(StringUtils.isBlank(filter.getOrderBy()) ? "id" : filter.getOrderBy());
        final Pageable pageable = PageRequest.of(
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
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return repository.findByCpf(authentication.getName());
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    public UsuarioDTO activeOrInative(final Long id) {
        final UsuarioDTO dto = findById(id);
        if (getCurrentSessionUser().getId().equals(dto.getId())) {
            throw new BusinessException(MessageEnum.MSG0058.toString());
        }
        dto.setAtivo(BooleanUtils.negate(dto.getAtivo()));
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public UsuarioDTO updatePassword(final SenhaDTO dto) {
        validateEqualsPasswords(dto.getNovaSenha(), dto.getNovaSenhaConfirmacao());
        final Usuario sessionUser = getCurrentSessionUser();
        if (!passwordEncoder.matches(dto.getSenhaAtual(), sessionUser.getSenha())) {
            throw new BusinessException(MessageEnum.MSG0005.toString());
        }
        sessionUser.setSenha(passwordEncoder.encode(dto.getNovaSenha()));
        return mapper.toDTO(repository.save(sessionUser));
    }

    private void checkUserPermission(final UsuarioDTO usuarioDTO) {
        final Usuario usuario = getCurrentSessionUser();
        if (!usuarioDTO.getId().equals(usuario.getId()) && usuario.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            throw new AccessDeniedException(MessageEnum.MSG0036.toString());
        }
    }

    private void checkUserPermissionUpdate(final UsuarioDTO usuarioDTO) {
        final Usuario usuario = getCurrentSessionUser();
        if (!usuarioDTO.getId().equals(usuario.getId())) {
            throw new AccessDeniedException(MessageEnum.MSG0036.toString());
        }
    }

    private void validateContato(final UsuarioDTO dto) {
        if (StringUtils.isBlank(dto.getContatoCelular()) && StringUtils.isBlank(dto.getContatoCelularRecado())
                && StringUtils.isBlank(dto.getContatoResidencial()) && StringUtils.isBlank(dto.getContatoComercial())) {
            throw new BusinessException(MessageEnum.MSG0007.toString());
        }
    }

    private Perfil createPerfil(final Long id) {
        final Perfil perfil = new Perfil();
        perfil.setId(id);
        return perfil;
    }

    private void validateEqualsPasswords(final String senha, final String senhaConfirmacao) {
        if (!senha.equals(senhaConfirmacao)) {
            throw new BusinessException(MessageEnum.MSG0076.toString());
        }
    }

    private void validateRequiredPasswords(final String senha, final String senhaConfirmacao) {
        if (StringUtils.isBlank(senha)) {
            throw new BusinessException(MessageEnum.MSG0001.toString());
        }
        if (StringUtils.isBlank(senhaConfirmacao)) {
            throw new BusinessException(MessageEnum.MSG0002.toString());
        }
    }

    private void validateDuplicityByCpf(final String cpf) {
        if (Objects.nonNull(repository.findByCpf(cpf))) {
            throw new BusinessException(MessageEnum.MSG0006.toString());
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
