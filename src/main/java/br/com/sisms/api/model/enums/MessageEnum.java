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
    MSG0027("Atendimento não encontrado."),
    MSG0028("Operação realizada com sucesso."),
    MSG0029("Usuário bloqueado. Contate o administrador do sistema informando o ocorrido."),
    MSG0030("Essa categoria de lançamento já existe na base de dados."),
    MSG0031("Essa cidade já existe na base de dados."),
    MSG0032("Essa outra medida já existe na base de dados."),
    MSG0033("Essa profissão já existe na base de dados."),
    MSG0034("Esse estado já existe na base de dados."),
    MSG0035("A requisição possui campo(s) inválido(s)."),
    MSG0036("Usuário sem permissão para essa operação."),
    MSG0037("A data de nascimento não pode ser maior que a data atual."),
    MSG0038("Não é possível alterar um pacote encerrado."),
    MSG0039("Usuário não autenticado."),
    MSG0040("UF não encontrada."),
    MSG0041("Outra medida não encontrado."),
    MSG0042("Perfil não encontrado."),
    MSG0043("Usuário não encontrado."),
    MSG0044("Paciente não encontrado."),
    MSG0045("Pacote não encontrado."),
    MSG0046("O cpf e/ou senha não coincidem no sistema."),
    MSG0047("Lançamento não encontrado."),
    MSG0048("A data/hora do pré-atendimento não pode ser maior que a data/hora do pós-atendimento."),
    MSG0049("Localidade não encontrada."),
    MSG0050("Profissão não encontrada."),
    MSG0051("Forma de pagamento não encontrada."),
    MSG0052("Categoria de atendimento não encontrada."),
    MSG0053("Categoria de lançamento não encontrada."),
    MSG0054("Sexo não encontrado."),
    MSG0055("Não é possível criar um novo pacote para esse paciente com essa categoria de atendimento porque existe um pacote em aberto criado por outro usuário."),
    MSG0056("Tipo de atendimento não encontrado."),
    MSG0057("O campo data em pós-atendimento é obrigatório."),
    MSG0058("Não é possível ativar/inativar o próprio usuário."),
    MSG0059("Dia da semana não encontrado."),
    MSG0060("Registro da agenda não encontrado."),
    MSG0061("O horário inicial não pode ser maior que o horário final."),
    MSG0064("Categoria de exame não encontrada."),
    MSG0065("Essa categoria de exame já existe na base de dados."),
    MSG0066("Exame não encontrado."),
    MSG0074("Reserva não encontrada."),
    MSG0075("Esse paciente já está cadastrado na reserva."),
    MSG0076("As senhas não coincidem."),
    MSG0077("CPF inválido."),
    MSG0078("O número máximo de atendimento para esse pacote já foi atingido."),
    MSG0079("O campo quantidade de sessão não pode ser menor do que a quantidade de atendimentos já realizados."),
    MSG0080("A somatória do(s) valor(es) do histórico de pagamento ultrapassa o valor do pacote."),
    MSG0081("O valor informado é menor que a somatória do(s) valor(es) lançado(s) para esse pacote. Informe um valor maior ou igual a %s."),
    MSG0082("Não é possível excluir pacote que contém atendimento(s)."),
    MSG0083("Não é possível excluir pacote que contém lançamento(s)."),
    MSG0084("O valor informado é maior do que o valor do saldo disponível."),
    MSG0086("Não é possível excluir esse lançamento pois o saldo do paciente ficará negativo."),
    MSG0087("Com o valor informado o paciente ficará com o saldo negativo. Informe um valor maior ou igual a R$ %s.");

    private final String codigo;

    @Override
    public String toString() {
        return String.format(codigo);
    }

    public String messageWithParameters(final String... parameters) {
        return String.format(codigo, parameters);
    }

}
