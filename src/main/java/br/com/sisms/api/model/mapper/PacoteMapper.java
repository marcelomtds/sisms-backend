package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.PacoteDTO;
import br.com.sisms.api.model.entity.Pacote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {PacienteMapper.class, UsuarioMapper.class, CategoriaLancamentoMapper.class})
public interface PacoteMapper extends BaseMapper<Pacote, PacoteDTO> {

    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "pacienteNomeCompleto", target = "paciente.nomeCompleto")
    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "usuarioNomeCompleto", target = "usuario.nomeCompleto")
    @Mapping(source = "categoriaAtendimentoId", target = "categoriaAtendimento.id")
    @Mapping(source = "categoriaAtendimentoDescricao", target = "categoriaAtendimento.descricao")
    Pacote toEntity(PacoteDTO dto);

    @Mapping(target = "pacienteId", source = "paciente.id")
    @Mapping(target = "pacienteNomeCompleto", source = "paciente.nomeCompleto")
    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "usuarioNomeCompleto", source = "usuario.nomeCompleto")
    @Mapping(target = "categoriaAtendimentoId", source = "categoriaAtendimento.id")
    @Mapping(target = "categoriaAtendimentoDescricao", source = "categoriaAtendimento.descricao")
    PacoteDTO toDTO(Pacote entity);

}
