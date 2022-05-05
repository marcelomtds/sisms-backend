-- Cria o menu da funcionalidade relatório
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (39, 'Relatório', 'fa fa-bar-chart', '/relatorio', null);
INSERT INTO menu (id, descricao, icone, rota, id_menu) VALUES (40, 'Quantidade de Atendimento por Período', 'fa fa-search', '/atendimento-periodo', 39);