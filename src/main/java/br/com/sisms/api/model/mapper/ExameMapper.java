package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.ExameDTO;
import br.com.sisms.api.model.entity.Exame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {PacienteMapper.class, CategoriaExameMapper.class, AnexoExameMapper.class})
public interface ExameMapper extends BaseMapper<Exame, ExameDTO> {

    @Mapping(target = "pacienteId", source = "paciente.id")
    @Mapping(target = "pacienteNomeCompleto", source = "paciente.nomeCompleto")
    @Mapping(target = "categoriaExameId", source = "categoriaExame.id")
    @Mapping(target = "categoriaExameDescricao", source = "categoriaExame.descricao")
    ExameDTO toDTO(Exame entity);

    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "pacienteNomeCompleto", target = "paciente.nomeCompleto")
    @Mapping(source = "categoriaExameId", target = "categoriaExame.id")
    @Mapping(source = "categoriaExameDescricao", target = "categoriaExame.descricao")
    Exame toEntity(ExameDTO dto);

}
