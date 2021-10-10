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
