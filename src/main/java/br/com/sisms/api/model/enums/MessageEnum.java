package br.com.sisms.api.model.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum MessageEnum {

    MSG0001("O campo senha é obrigatório."),
    MSG0002("O campo senha confirmação é obrigatório."),
    MSG0003("As senhas não coincidem."),
    MSG0004("A senha deve conter no mínimo 6 caracteres."),
    MSG0005("A senha atual está incorreta."),
    SUCESSO(Codigo.SUCESSO),
    USUARIO_BLOQUEADO(Codigo.USUARIO_BLOQUEADO),
    REGISTRO_JA_CADASTRADO(Codigo.REGISTRO_JA_CADASTRADO),
    CAMPOS_INVALIDOS(Codigo.CAMPOS_INVALIDOS),
    CAMPOS_INCONSISTENTES(Codigo.CAMPOS_INCONSISTENTES),
    CPF_JA_CADASTRADO(Codigo.CPF_JA_CADASTRADO),
    USUARIO_SEM_PERMISSAO(Codigo.USUARIO_SEM_PERMISSAO),
    CPF_INVALIDO(Codigo.CPF_INVALIDO),
    DATA_NASCIMENTO_MAIOR_ATUAL(Codigo.DATA_NASCIMENTO_MAIOR_ATUAL),
    ERRO_INESPERADO(Codigo.ERRO_INESPERADO),
    ALTERAR_PACOTE_ENCERRADO(Codigo.ALTERAR_PACOTE_ENCERRADO),
    RECURSO_NAO_ENCONTRADO(Codigo.RECURSO_NAO_ENCONTRADO),
    USUARIO_NAO_AUTENTICADO(Codigo.USUARIO_NAO_AUTENTICADO),
    UF_NAO_ENCONTRADA(Codigo.UF_NAO_ENCONTRADA),
    OUTRA_MEDIDA_NAO_ENCONTRADA(Codigo.OUTRA_MEDIDA_NAO_ENCONTRADA),
    PERFIL_NAO_ENCONTRADO(Codigo.PERFIL_NAO_ENCONTRADO),
    USUARIO_NAO_ENCONTRADO(Codigo.USUARIO_NAO_ENCONTRADO),
    PACIENTE_NAO_ENCONTRADO(Codigo.PACIENTE_NAO_ENCONTRADO),
    ATENDIMENTO_NAO_ENCONTRADO(Codigo.ATENDIMENTO_NAO_ENCONTRADO),
    PACOTE_NAO_ENCONTRADO(Codigo.PACOTE_NAO_ENCONTRADO),
    CPF_SENHA_NAO_COINCIDEM(Codigo.CPF_SENHA_NAO_COINCIDEM),
    LANCAMENTO_NAO_ENCONTRADO(Codigo.LANCAMENTO_NAO_ENCONTRADO),
    DATA_HORA_PRE_POS_ATENDIMENTO_INTERVALO(Codigo.DATA_HORA_PRE_POS_ATENDIMENTO_INTERVALO),
    DATA_HORA_PRE_ATENDIMENTO_MAIOR_ATUAL(Codigo.DATA_HORA_PRE_ATENDIMENTO_MAIOR_ATUAL),
    LOCALIDADE_NAO_ENCONTRADA(Codigo.LOCALIDADE_NAO_ENCONTRADA),
    PROFISSAO_NAO_ENCONTRADA(Codigo.PROFISSAO_NAO_ENCONTRADA),
    FORMA_PAGAMENTO_NAO_ENCONTRADA(Codigo.FORMA_PAGAMENTO_NAO_ENCONTRADA),
    CATEGORIA_ATENDIMENTO_NAO_ENCONTRADA(Codigo.CATEGORIA_ATENDIMENTO_NAO_ENCONTRADA),
    CATEGORIA_LANCAMENTO_NAO_ENCONTRADA(Codigo.CATEGORIA_LANCAMENTO_NAO_ENCONTRADA),
    SEXO_NAO_ENCONTRADO(Codigo.SEXO_NAO_ENCONTRADO),
    PERMISSAO_CRIAR_PACOTE(Codigo.PERMISSAO_CRIAR_PACOTE),
    TIPO_ATENDIMENTO_NAO_ENCONTRADO(Codigo.TIPO_ATENDIMENTO_NAO_ENCONTRADO),
    DATA_HORA_POS_ATENDIMENTO_OBRIGATORIO(Codigo.DATA_HORA_POS_ATENDIMENTO_OBRIGATORIO),
    PERIODO_DATA_INVALIDO(Codigo.PERIODO_DATA_INVALIDO),
    ATIVAR_INATIVAR_PROPRIO_USUARIO(Codigo.ATIVAR_INATIVAR_PROPRIO_USUARIO);

    private final String codigo;

    @Override
    public String toString() {
        return codigo;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class Codigo {
        public static final String SUCESSO = "Operação realizada com sucesso.";
        public static final String USUARIO_BLOQUEADO = "Usuário bloqueado. Contate o administrador do sistema informando o ocorrido.";
        public static final String USUARIO_SEM_PERMISSAO = "Usuário sem permissão para essa operação.";
        public static final String CAMPOS_INVALIDOS = "A requisição possui campo(s) inválido(s).";
        public static final String CAMPOS_INCONSISTENTES = "A requisição possui campo(s) inconsistênte(s).";
        public static final String REGISTRO_JA_CADASTRADO = "Esse registro já existe na base de dados.";
        public static final String RECURSO_NAO_ENCONTRADO = "Recurso não encontrado.";
        public static final String CPF_JA_CADASTRADO = "Esse CPF já existe na base de dados.";
        public static final String CPF_INVALIDO = "Número de cpf inválido.";
        public static final String ERRO_INESPERADO = "Ocorreu um erro inesperado. Contate o administrador do Sistema.";
        public static final String USUARIO_NAO_AUTENTICADO = "Usuário não autenticado.";
        public static final String UF_NAO_ENCONTRADA = "UF não encontrada.";
        public static final String SEXO_NAO_ENCONTRADO = "Sexo não encontrado.";
        public static final String TIPO_ATENDIMENTO_NAO_ENCONTRADO = "Tipo de atendimento não encontrado.";
        public static final String PACIENTE_NAO_ENCONTRADO = "Paciente não encontrado.";
        public static final String DATA_NASCIMENTO_MAIOR_ATUAL = "A data de nascimento não pode ser maior que a data atual.";
        public static final String OUTRA_MEDIDA_NAO_ENCONTRADA = "Outra medida não encontrado.";
        public static final String PERFIL_NAO_ENCONTRADO = "Perfil não encontrado.";
        public static final String ATENDIMENTO_NAO_ENCONTRADO = "Atendimento não encontrado.";
        public static final String PACOTE_NAO_ENCONTRADO = "Pacote não encontrado.";
        public static final String LANCAMENTO_NAO_ENCONTRADO = "Lançamento não encontrado.";
        public static final String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado.";
        public static final String PROFISSAO_NAO_ENCONTRADA = "Profissão não encontrada.";
        public static final String LOCALIDADE_NAO_ENCONTRADA = "Localidade não encontrada.";
        public static final String FORMA_PAGAMENTO_NAO_ENCONTRADA = "Forma de pagamento não encontrada.";
        public static final String CATEGORIA_ATENDIMENTO_NAO_ENCONTRADA = "Categoria de atendimento não encontrada.";
        public static final String CATEGORIA_LANCAMENTO_NAO_ENCONTRADA = "Categoria de lançamento não encontrada.";
        public static final String CPF_SENHA_NAO_COINCIDEM = "O cpf e/ou senha não coincidem no sistema.";
        public static final String ATIVAR_INATIVAR_PROPRIO_USUARIO = "Não é possível ativar/inativar o próprio usuário.";
        public static final String DATA_HORA_PRE_POS_ATENDIMENTO_INTERVALO = "A data/hora do pré-atendimento não pode ser maior que a data/hora do pós-atendimento.";
        public static final String DATA_HORA_PRE_ATENDIMENTO_MAIOR_ATUAL = "A Data/Hora do pré-atendimento não pode ser maior que a Data/Hora atual.";
        public static final String DATA_HORA_POS_ATENDIMENTO_OBRIGATORIO = "O campo data em pós-atendimento é obrigatório.";
        public static final String PERIODO_DATA_INVALIDO = "A data início não pode ser maior que a data fim.";
        public static final String ALTERAR_PACOTE_ENCERRADO = "Não é possível alterar um pacote encerrado.";
        public static final String PERMISSAO_CRIAR_PACOTE = "Não é possível criar um novo pacote para esse paciente com essa categoria de atendimento porque existe um pacote em aberto criado por outro usuário.";

    }
}
