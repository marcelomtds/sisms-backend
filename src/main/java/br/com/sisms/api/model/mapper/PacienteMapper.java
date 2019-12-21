package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.PacienteDTO;
import br.com.sisms.api.model.entity.Paciente;
import br.com.sisms.api.model.request.PacienteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {SexoMapper.class, ProfissaoMapper.class, EnderecoMapper.class, ContatoMapper.class})
public interface PacienteMapper extends BaseMapper<Paciente, PacienteDTO> {

    @Mapping(source = "sexoId", target = "sexo.id")
    @Mapping(source = "profissaoId", target = "profissao.id")
    @Mapping(source = "enderecoId", target = "endereco.id")
    @Mapping(source = "enderecoCep", target = "endereco.cep")
    @Mapping(source = "enderecoLogradouro", target = "endereco.logradouro")
    @Mapping(source = "enderecoNumero", target = "endereco.numero")
    @Mapping(source = "enderecoComplemento", target = "endereco.complemento")
    @Mapping(source = "enderecoBairro", target = "endereco.bairro")
    @Mapping(source = "enderecoPontoReferencia", target = "endereco.pontoReferencia")
    @Mapping(source = "enderecoLocalidadeId", target = "endereco.localidade.id")
    @Mapping(source = "contatoId", target = "contato.id")
    @Mapping(source = "contatoCelular", target = "contato.celular")
    @Mapping(source = "contatoCelularRecado", target = "contato.celularRecado")
    @Mapping(source = "contatoResidencial", target = "contato.residencial")
    @Mapping(source = "contatoComercial", target = "contato.comercial")
    @Mapping(source = "contatoEmail", target = "contato.email")
    PacienteDTO toDTO(PacienteRequest request);

    @Mapping(source = "sexoId", target = "sexo.id")
    @Mapping(source = "profissaoId", target = "profissao.id")
    @Mapping(source = "enderecoId", target = "endereco.id")
    @Mapping(source = "enderecoCep", target = "endereco.cep")
    @Mapping(source = "enderecoLogradouro", target = "endereco.logradouro")
    @Mapping(source = "enderecoNumero", target = "endereco.numero")
    @Mapping(source = "enderecoComplemento", target = "endereco.complemento")
    @Mapping(source = "enderecoBairro", target = "endereco.bairro")
    @Mapping(source = "enderecoPontoReferencia", target = "endereco.pontoReferencia")
    @Mapping(source = "enderecoLocalidadeId", target = "endereco.localidade.id")
    @Mapping(source = "contatoId", target = "contato.id")
    @Mapping(source = "contatoCelular", target = "contato.celular")
    @Mapping(source = "contatoCelularRecado", target = "contato.celularRecado")
    @Mapping(source = "contatoResidencial", target = "contato.residencial")
    @Mapping(source = "contatoComercial", target = "contato.comercial")
    @Mapping(source = "contatoEmail", target = "contato.email")
    Paciente toEntity(PacienteRequest request);

}
