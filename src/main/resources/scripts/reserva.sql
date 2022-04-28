-- Cria a tabela período
CREATE TABLE IF NOT EXISTS public.periodo
(
    id bigint NOT NULL,
    descricao CHARACTER VARYING(50) NOT NULL,
    CONSTRAINT periodo_pkey PRIMARY KEY (id)
);

-- Adiciona as opções na tabela período
INSERT INTO periodo (id, descricao) VALUES (1, 'Manhã');
INSERT INTO periodo (id, descricao) VALUES (2, 'Tarde');
INSERT INTO periodo (id, descricao) VALUES (3, 'Noite');

-- Cria as colunas na tabela reserva
ALTER TABLE reserva
    ADD COLUMN paciente_nome_completo CHARACTER VARYING(200),
    ADD COLUMN telefone CHARACTER VARYING(20),
	ADD COLUMN horario TIME WITHOUT TIME ZONE,
	ADD COLUMN id_categoria_atendimento BIGINT
        CONSTRAINT fk_reserva_categoria_atendimento_id
            REFERENCES categoria_atendimento (id),
    ADD COLUMN id_dia_semana BIGINT
            CONSTRAINT fk_reserva_dia_semana_id
                REFERENCES dia_semana (id),
	ADD COLUMN id_periodo BIGINT
        CONSTRAINT fk_reserva_periodo_id
            REFERENCES periodo (id);

-- Replica o nome do paciente da reserva (reserva.paciente.nome) para a coluna paciente_nome_completo na tabela reserva
DO
$do$
    DECLARE
        reg_reserva RECORD;
    BEGIN
        FOR reg_reserva IN SELECT pac.nome_completo AS pac_nome_completo, res.id AS res_id
                              FROM reserva AS res
                                       INNER JOIN paciente AS pac ON pac.id = res.id_paciente
            LOOP
                RAISE NOTICE 'paciente: % - ID da reserva: %', reg_reserva.pac_nome_completo, reg_reserva.res_id;
                UPDATE reserva
                SET paciente_nome_completo = reg_reserva.pac_nome_completo
                WHERE id = reg_reserva.res_id;
            END LOOP;
    END
$do$;

-- Adiciona obrigatoriedade na coluna paciente_nome_completo
ALTER TABLE reserva ALTER COLUMN paciente_nome_completo SET NOT NULL;

-- Remove a coluna id_paciente na tabela reserva
ALTER TABLE reserva
    DROP COLUMN id_paciente;