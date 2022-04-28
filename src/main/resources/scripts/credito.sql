-- Cria o menu da funcionalidade crédito
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (36, 'Crédito', 'fa fa-money', '/credito', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (37, 'Buscar', 'fa fa-search', null, 36);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (38, 'Cadastrar', 'fa fa-plus', '/incluir', 36);

-- Altera a quantidade de caracteres da coluna descrição
ALTER TABLE forma_pagamento ALTER COLUMN descricao TYPE CHARACTER VARYING(50);

-- Adiciona opção de forma de pagamento
INSERT INTO forma_pagamento (id, descricao) VALUES (7, 'Utilização de Crédito');

-- Adiciona opções de tipo de lançamento
INSERT INTO tipo_lancamento (id, descricao) VALUES (3, 'Entrada de Crédito');
INSERT INTO tipo_lancamento (id, descricao) VALUES (4, 'Utilização de Crédito');

-- Cria a coluna id_paciente na tabela lançamento
ALTER TABLE lancamento
    ADD COLUMN id_paciente BIGINT
        CONSTRAINT fk_lancamento_paciente_id
            REFERENCES paciente (id);

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