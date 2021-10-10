CREATE TABLE historico_utilizacao_credito
(
    id             BIGSERIAL     NOT NULL
        CONSTRAINT historico_utilizacao_credito_pkey
            PRIMARY KEY,
    data           DATE          NOT NULL,
    valor          NUMERIC(8, 2) NOT NULL,
    id_usuario     BIGINT        NOT NULL
        CONSTRAINT fk_historico_utilizacao_credito_usuario_id
            REFERENCES usuario (id),
    id_atendimento BIGINT
        CONSTRAINT fk_historico_utilizacao_credito_atendimento_id
            REFERENCES atendimento (id),
    id_pacote      BIGINT
        CONSTRAINT fk_historico_utilizacao_credito_pacote_id
            REFERENCES pacote (id),
    id_lancamento  BIGINT        NOT NULL
        CONSTRAINT fk_historico_utilizacao_credito_lancamento_id
            REFERENCES lancamento (id)
);