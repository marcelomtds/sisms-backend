package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.UsuarioDTO;
import br.com.sisms.api.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {SexoMapper.class, ProfissaoMapper.class, EnderecoMapper.class, ContatoMapper.class, PerfilMapper.class, LocalidadeMapper.class})
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

    @Mapping(target = "sexoId", source = "sexo.id")
    @Mapping(target = "sexoDescricao", source = "sexo.descricao")
    @Mapping(target = "profissaoId", source = "profissao.id")
    @Mapping(target = "profissaoDescricao", source = "profissao.descricao")
    @Mapping(target = "perfilId", source = "perfil.id")
    @Mapping(target = "perfilDescricao", source = "perfil.descricao")
    @Mapping(target = "perfilRole", source = "perfil.role")
    @Mapping(target = "enderecoId", source = "endereco.id")
    @Mapping(target = "enderecoCep", source = "endereco.cep")
    @Mapping(target = "enderecoLogradouro", source = "endereco.logradouro")
    @Mapping(target = "enderecoNumero", source = "endereco.numero")
    @Mapping(target = "enderecoComplemento", source = "endereco.complemento")
    @Mapping(target = "enderecoBairro", source = "endereco.bairro")
    @Mapping(target = "enderecoPontoReferencia", source = "endereco.pontoReferencia")
    @Mapping(target = "enderecoLocalidadeId", source = "endereco.localidade.id")
    @Mapping(target = "enderecoLocalidadeDescricao", source = "endereco.localidade.descricao")
    @Mapping(target = "enderecoLocalidadeUFId", source = "endereco.localidade.uf.id")
    @Mapping(target = "enderecoLocalidadeUFDescricao", source = "endereco.localidade.uf.descricao")
    @Mapping(target = "contatoId", source = "contato.id")
    @Mapping(target = "contatoTelefone1", source = "contato.telefone1")
    @Mapping(target = "contatoTelefone2", source = "contato.telefone2")
    @Mapping(target = "contatoTelefone3", source = "contato.telefone3")
    @Mapping(target = "contatoTelefone4", source = "contato.telefone4")
    @Mapping(target = "contatoEmail", source = "contato.email")
    UsuarioDTO toDTO(Usuario entity);

    @Mapping(source = "sexoId", target = "sexo.id")
    @Mapping(source = "sexoDescricao", target = "sexo.descricao")
    @Mapping(source = "profissaoId", target = "profissao.id")
    @Mapping(source = "profissaoDescricao", target = "profissao.descricao")
    @Mapping(source = "perfilId", target = "perfil.id")
    @Mapping(source = "perfilDescricao", target = "perfil.descricao")
    @Mapping(source = "perfilRole", target = "perfil.role")
    @Mapping(source = "enderecoId", target = "endereco.id")
    @Mapping(source = "enderecoCep", target = "endereco.cep")
    @Mapping(source = "enderecoLogradouro", target = "endereco.logradouro")
    @Mapping(source = "enderecoNumero", target = "endereco.numero")
    @Mapping(source = "enderecoComplemento", target = "endereco.complemento")
    @Mapping(source = "enderecoBairro", target = "endereco.bairro")
    @Mapping(source = "enderecoPontoReferencia", target = "endereco.pontoReferencia")
    @Mapping(source = "enderecoLocalidadeId", target = "endereco.localidade.id")
    @Mapping(source = "enderecoLocalidadeDescricao", target = "endereco.localidade.descricao")
    @Mapping(source = "enderecoLocalidadeUFId", target = "endereco.localidade.uf.id")
    @Mapping(source = "enderecoLocalidadeUFDescricao", target = "endereco.localidade.uf.descricao")
    @Mapping(source = "contatoId", target = "contato.id")
    @Mapping(source = "contatoTelefone1", target = "contato.telefone1")
    @Mapping(source = "contatoTelefone2", target = "contato.telefone2")
    @Mapping(source = "contatoTelefone3", target = "contato.telefone3")
    @Mapping(source = "contatoTelefone4", target = "contato.telefone4")
    @Mapping(source = "contatoEmail", target = "contato.email")
    Usuario toEntity(UsuarioDTO dto);

}
