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

INSERT INTO periodo (id, descricao) VALUES (1, 'Manhã');
INSERT INTO periodo (id, descricao) VALUES (2, 'Tarde');
INSERT INTO periodo (id, descricao) VALUES (3, 'Noite');

INSERT INTO forma_pagamento (id, descricao) VALUES (1, 'Dinheiro');
INSERT INTO forma_pagamento (id, descricao) VALUES (2, 'Boleto');
INSERT INTO forma_pagamento (id, descricao) VALUES (3, 'Cartão de Crédito');
INSERT INTO forma_pagamento (id, descricao) VALUES (4, 'Cartão de Débito');
INSERT INTO forma_pagamento (id, descricao) VALUES (5, 'Cheque');
INSERT INTO forma_pagamento (id, descricao) VALUES (6, 'Outros');
INSERT INTO forma_pagamento (id, descricao) VALUES (7, 'Utilização de Crédito');

INSERT INTO perfil (id, descricao, role) VALUES (1, 'Administrador', 'ROLE_ADMINISTRADOR');
INSERT INTO perfil (id, descricao, role) VALUES (2, 'Usuário', 'ROLE_USUARIO');

INSERT INTO sexo (id, descricao) VALUES (1, 'Masculino');
INSERT INTO sexo (id, descricao) VALUES (2, 'Feminino');

INSERT INTO tipo_atendimento (id, descricao) VALUES (1, 'Sessão Avulsa');
INSERT INTO tipo_atendimento (id, descricao) VALUES (2, 'Pacote');

INSERT INTO tipo_lancamento (id, descricao) VALUES (1, 'Entrada');
INSERT INTO tipo_lancamento (id, descricao) VALUES (2, 'Saída');
INSERT INTO tipo_lancamento (id, descricao) VALUES (3, 'Entrada de Crédito');
INSERT INTO tipo_lancamento (id, descricao) VALUES (4, 'Utilização de Crédito');

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (1, 'Agenda', 'fa fa-calendar', '/agenda', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (2, 'Gerenciar', 'fa fa-pencil', '/gerenciar', 1);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (3, 'Reserva', 'fa fa-hourglass-2', '/reserva', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (4, 'Buscar', 'fa fa-search', null, 3);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (5, 'Cadastrar', 'fa fa-plus', '/incluir', 3);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (6, 'Usuário', 'fa fa-users', '/usuario', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (7, 'Buscar', 'fa fa-search', null, 6);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (8, 'Cadastrar', 'fa fa-plus', '/incluir', 6);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (9, 'Paciente', 'fa fa-user', '/paciente', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (10, 'Buscar', 'fa fa-search', null, 9);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (11, 'Cadastrar', 'fa fa-plus', '/incluir', 9);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (12, 'Drenagem Linfática', 'fa fa-line-chart', '/atendimento/drenagem', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (13, 'Buscar', 'fa fa-search', null, 12);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (14, 'Cadastrar', 'fa fa-plus', '/incluir', 12);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (15, 'Fisioterapia', 'fa fa-wheelchair', '/atendimento/fisioterapia', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (16, 'Buscar', 'fa fa-search', null, 15);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (17, 'Cadastrar', 'fa fa-plus', '/incluir', 15);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (18, 'RPG', 'fa fa-heartbeat', '/atendimento/rpg', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (19, 'Buscar', 'fa fa-search', null, 18);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (20, 'Cadastrar', 'fa fa-plus', '/incluir', 18);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (21, 'Pilates', 'fa fa-child', '/atendimento/pilates', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (22, 'Buscar', 'fa fa-search', null, 21);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (23, 'Cadastrar', 'fa fa-plus', '/incluir', 21);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (24, 'Massagem Relaxante', 'fa fa-leaf', '/atendimento/massagem-relaxante', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (25, 'Buscar', 'fa fa-search', null, 24);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (26, 'Cadastrar', 'fa fa-plus', '/incluir', 24);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (27, 'Exame', 'fa fa-plus-square', '/exame', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (28, 'Buscar', 'fa fa-search', null, 27);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (29, 'Cadastrar', 'fa fa-plus', '/incluir', 27);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (30, 'Pacote', 'fa fa-suitcase', '/pacote', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (31, 'Buscar', 'fa fa-search', null, 30);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (32, 'Cadastrar', 'fa fa-plus', '/incluir', 30);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (33, 'Controle de Caixa', 'fa fa-dollar', '/controle-caixa', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (34, 'Buscar', 'fa fa-search', null, 33);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (35, 'Cadastrar Saída', 'fa fa-plus', '/saida', 33);

INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (36, 'Crédito', 'fa fa-money', '/credito', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (37, 'Buscar', 'fa fa-search', null, 36);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (38, 'Cadastrar', 'fa fa-plus', '/incluir', 36);

INSERT INTO uf (id, descricao) VALUES (1, 'São Paulo');

INSERT INTO localidade (id, descricao, id_uf) VALUES (1, 'Trabiju', 1);

INSERT INTO endereco (id, bairro, cep, complemento, logradouro, numero, ponto_referencia, id_localidade)
VALUES (1, 'Centro', '14935000', 'Casa A', 'Rua Manoel Rodrigues Fonseca', '81', 'Casa de Esquina', 1);

INSERT INTO contato (id, celular, celular_recado, comercial, residencial, email)
VALUES (1, '16997425677', '16997314845', null, null, 'gloria.cezarino@hotmail.com');

INSERT INTO profissao (id, descricao) VALUES (1, 'Fisioterapeuta');

INSERT INTO usuario (id, ativo, cpf, data_nascimento, data_cadastro, imagem, nome_completo, rg, senha, id_contato, id_endereco, id_perfil, id_profissao, id_sexo, cadastro_completo)
VALUES (1, true, '32542626898', '1984-09-15', current_date, null, 'Glória Anastacia Cezarino', '407755160', '$2a$10$cYLM.qoXpeAzcZhJ3oXRLu9Slkb61LHyWW5qJ4QKvHEMhaxZ5qCPi', 1, 1, 1, 1, 2, true);