package br.com.sisms.api.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MessageEnum {

    MSG0001("O campo senha é obrigatório."),
    MSG0002("O campo senha confirmação é obrigatório."),
    MSG0003("As novas senhas não coincidem."),
    MSG0005("A senha atual está incorreta."),
    MSG0006("Esse cpf já existe na base de dados."),
    MSG0007("É necessário informar pelo menos um telefone de contato."),
    MSG0008("A data início não pode ser maior que a data fim."),
    MSG0009("Tipo de lançamento não encontrado."),
    MSG00027("Atendimento não encontrado."),
    MSG00028("Operação realizada com sucesso."),
    MSG00029("Usuário bloqueado. Contate o administrador do sistema informando o ocorrido."),
    MSG00030("Essa categoria de lançamento já existe na base de dados."),
    MSG00031("Essa cidade já existe na base de dados."),
    MSG00032("Essa outra medida já existe na base de dados."),
    MSG00033("Essa profissão já existe na base de dados."),
    MSG00034("Esse estado já existe na base de dados."),
    MSG00035("A requisição possui campo(s) inválido(s)."),
    MSG00036("Usuário sem permissão para essa operação."),
    MSG00037("A data de nascimento não pode ser maior que a data atual."),
    MSG00038("Não é possível alterar um pacote encerrado."),
    MSG00039("Usuário não autenticado."),
    MSG00040("UF não encontrada."),
    MSG00041("Outra medida não encontrado."),
    MSG00042("Perfil não encontrado."),
    MSG00043("Usuário não encontrado."),
    MSG00044("Paciente não encontrado."),
    MSG00045("Pacote não encontrado."),
    MSG00046("O cpf e/ou senha não coincidem no sistema."),
    MSG00047("Lançamento não encontrado."),
    MSG00048("A data/hora do pré-atendimento não pode ser maior que a data/hora do pós-atendimento."),
    MSG00049("Localidade não encontrada."),
    MSG00050("Profissão não encontrada."),
    MSG00051("Forma de pagamento não encontrada."),
    MSG00052("Categoria de atendimento não encontrada."),
    MSG00053("Categoria de lançamento não encontrada."),
    MSG00054("Sexo não encontrado."),
    MSG00055("Não é possível criar um novo pacote para esse paciente com essa categoria de atendimento porque existe um pacote em aberto criado por outro usuário."),
    MSG00056("Tipo de atendimento não encontrado."),
    MSG00057("O campo data em pós-atendimento é obrigatório."),
    MSG00058("Não é possível ativar/inativar o próprio usuário."),
    MSG00059("Dia da semana não encontrado."),
    MSG00060("Registro da agenda não encontrado."),
    MSG00061("O horário inicial não pode ser maior que o horário final."),
    MSG00064("Categoria de exame não encontrada."),
    MSG00065("Essa categoria de exame já existe na base de dados.");

    private final String codigo;

    @Override
    public String toString() {
        return codigo;
    }

}
