INSERT INTO categoria_atendimento (id, descricao) VALUES (1, 'Drenagem Linfática');
INSERT INTO categoria_atendimento (id, descricao) VALUES (2, 'Fisioterapia');
INSERT INTO categoria_atendimento (id, descricao) VALUES (3, 'Reeducação Postural Global');
INSERT INTO categoria_atendimento (id, descricao) VALUES (4, 'Pilates');
INSERT INTO categoria_atendimento (id, descricao) VALUES (5, 'Massagem Relaxante');

INSERT INTO dia_semana (id, descricao) VALUES (1, 'Segunda - Feira');
INSERT INTO dia_semana (id, descricao) VALUES (2, 'Terça - Feira');
INSERT INTO dia_semana (id, descricao) VALUES (3, 'Quarta - Feira');
INSERT INTO dia_semana (id, descricao) VALUES (4, 'Quinta - Feira');
INSERT INTO dia_semana (id, descricao) VALUES (5, 'Sexta - Feira');
INSERT INTO dia_semana (id, descricao) VALUES (6, 'Sábado');
INSERT INTO dia_semana (id, descricao) VALUES (0, 'Domingo');

INSERT INTO forma_pagamento (id, descricao) VALUES (1, 'Dinheiro');
INSERT INTO forma_pagamento (id, descricao) VALUES (2, 'Cheque');
INSERT INTO forma_pagamento (id, descricao) VALUES (3, 'Cartão de Crédito');
INSERT INTO forma_pagamento (id, descricao) VALUES (4, 'Cartão de Débito');
INSERT INTO forma_pagamento (id, descricao) VALUES (5, 'Boleto');
INSERT INTO forma_pagamento (id, descricao) VALUES (6, 'Outros');

INSERT INTO perfil (id, descricao, role) VALUES (1, 'Administrador', 'ROLE_ADMINISTRADOR');
INSERT INTO perfil (id, descricao, role) VALUES (2, 'Usuário', 'ROLE_USUARIO');

INSERT INTO sexo (id, descricao) VALUES (1, 'Masculino');
INSERT INTO sexo (id, descricao) VALUES (2, 'Feminino');

INSERT INTO tipo_atendimento (id, descricao) VALUES (1, 'Sessão Avulsa');
INSERT INTO tipo_atendimento (id, descricao) VALUES (2, 'Pacote');

INSERT INTO tipo_lancamento (id, descricao) VALUES (1, 'Entrada');
INSERT INTO tipo_lancamento (id, descricao) VALUES (2, 'Saída');

INSERT INTO uf (id, descricao) VALUES (1, 'São Paulo');

INSERT INTO localidade (id, descricao, id_uf) VALUES (1, 'Trabiju', 1);

INSERT INTO endereco (id, bairro, cep, complemento, logradouro, numero, ponto_referencia, id_localidade)
VALUES (1, 'Centro', '14935000', '', 'Rua Manoel Rodrigues Fonseca', '81', 'Casa de esquina', 1);
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, numero, ponto_referencia, id_localidade)
VALUES (2, 'Centro', '14935000', '', 'Rua Manoel Rodrigues Fonseca', '81', 'Casa de esquina', 1);
INSERT INTO endereco (id, bairro, cep, complemento, logradouro, numero, ponto_referencia, id_localidade)
VALUES (3, 'Centro', '14935000', '', 'Rua Manoel Rodrigues Fonseca', '81', 'Casa de esquina', 1);

INSERT INTO contato (id, celular, celular_recado, comercial, email, residencial)
VALUES (1, '16997314845', '16997425677', '', 'marcelo.souza.81@hotmail.com', '');
INSERT INTO contato (id, celular, celular_recado, comercial, email, residencial)
VALUES (2, '16997314845', '16997425677', '', 'marcelo.souza.81@hotmail.com', '');
INSERT INTO contato (id, celular, celular_recado, comercial, email, residencial)
VALUES (3, '16997314845', '16997425677', '', 'marcelo.souza.81@hotmail.com', '');

INSERT INTO profissao (id, descricao) VALUES (1, 'Programador');

INSERT INTO usuario (id, ativo, cpf, data_nascimento, data_cadastro, imagem, nome_completo, rg, senha, id_contato, id_endereco, id_perfil, id_profissao, id_sexo)
VALUES (1, true, '36986634811', '1991-04-04', current_date, '', 'Administrador', '47851301X', '$2a$10$cYLM.qoXpeAzcZhJ3oXRLu9Slkb61LHyWW5qJ4QKvHEMhaxZ5qCPi', 1, 1, 1, 1, 1);
INSERT INTO usuario (id, ativo, cpf, data_nascimento, data_cadastro, imagem, nome_completo, rg, senha, id_contato, id_endereco, id_perfil, id_profissao, id_sexo)
VALUES (2, true, '32542626898', '1991-04-04', current_date, '', 'Usuário', '47851301X', '$2a$10$cYLM.qoXpeAzcZhJ3oXRLu9Slkb61LHyWW5qJ4QKvHEMhaxZ5qCPi', 1, 1, 2, 1, 1);

INSERT INTO paciente (id, ativo, cpf, data_nascimento, nome_completo, rg, id_contato, id_endereco, id_profissao, id_sexo)
VALUES (1, true, '36986634811', '1991-04-04', 'Osvaldo', '47851301X', 3, 3, 1, 1);