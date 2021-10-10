-- Cria a table que armazena o histórico de utilização de crédito
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

-- Cria a coluna credito na tabela lancamento e atualiza os registros
ALTER TABLE lancamento
    ADD COLUMN credito BOOLEAN DEFAULT false;

UPDATE lancamento
SET credito = FALSE
WHERE credito IS NULL;

ALTER TABLE lancamento
    ALTER COLUMN credito SET NOT NULL;

ALTER TABLE lancamento
    ADD COLUMN id_paciente BIGINT
        CONSTRAINT fk_lancamento_paciente_id
            REFERENCES paciente (id);

-- Cria o menu Crédito
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (36, 'Crédito', 'fa fa-money', '/credito', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (37, 'Buscar', 'fa fa-search', null, 36);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (38, 'Cadastrar', 'fa fa-plus', '/incluir', 36);

-- Replica o id do paciente do atendimento (lancamento.atendimento.paciente.id) para a coluna id_paciente na tabela lancamento
DO
$do$
    DECLARE
        reg_lancamento RECORD;
    BEGIN
        FOR reg_lancamento IN SELECT lanc.id AS lanc_id, pac.id as pac_id
                              FROM lancamento AS lanc
                                       INNER JOIN atendimento AS at ON at.id = lanc.id_atendimento
                                       INNER JOIN paciente AS pac ON pac.id = at.id_paciente
            LOOP
                RAISE NOTICE 'id_lancamento: % - id_paciente: %', reg_lancamento.lanc_id, reg_lancamento.pac_id;
                UPDATE lancamento AS lanc
                SET id_paciente = reg_lancamento.pac_id
                WHERE lanc.id = reg_lancamento.lanc_id;
            END LOOP;
    END
$do$;

-- Replica o id do paciente do pacote (lancamento.pacote.paciente.id) para a coluna id_paciente na tabela lancamento
DO
$do$
    DECLARE
        reg_lancamento RECORD;
    BEGIN
        FOR reg_lancamento IN SELECT lanc.id AS lanc_id, pac.id as pac_id
                              FROM lancamento AS lanc
                                       INNER JOIN pacote AS paco ON paco.id = lanc.id_pacote
                                       INNER JOIN paciente AS pac ON pac.id = paco.id_paciente
            LOOP
                RAISE NOTICE 'id_lancamento: % - id_paciente: %', reg_lancamento.lanc_id, reg_lancamento.pac_id;
                UPDATE lancamento AS lanc
                SET id_paciente = reg_lancamento.pac_id
                WHERE lanc.id = reg_lancamento.lanc_id;
            END LOOP;
    END
$do$;