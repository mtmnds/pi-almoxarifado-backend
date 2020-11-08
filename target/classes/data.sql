-- Cadastro de Perfis
INSERT INTO PERFIL (ID, DESCRICAO, ATIVO) VALUES (1, 'Administrador', true);
INSERT INTO PERFIL (ID, DESCRICAO, ATIVO) VALUES (2, 'Gerente', true);
INSERT INTO PERFIL (ID, DESCRICAO, ATIVO) VALUES (3, 'Funcionário', true);
INSERT INTO PERFIL (ID, DESCRICAO, ATIVO) VALUES (4, 'Técnico', true);


-- Cadastro de Usuários
INSERT INTO USUARIO
(ID, NOME, CPF_CNPJ, EMAIL, SENHA, PERFIL_ID, ATIVO)
VALUES
(1, 'Administrador', '123456789-12', 'admin@admin.com', 'admin', 1, true);


-- Cadastro de Status de requisição
INSERT INTO STATUS_REQUISICAO (ID, DESCRICAO, ATIVO) VALUES (1, 'Pendente', true);
INSERT INTO STATUS_REQUISICAO (ID, DESCRICAO, ATIVO) VALUES (2, 'Atendida', true);
INSERT INTO STATUS_REQUISICAO (ID, DESCRICAO, ATIVO) VALUES (3, 'Cancelada', true);


-- Cadastro de Status de inventário
INSERT INTO STATUS_INVENTARIO (ID, DESCRICAO, ATIVO) VALUES (1, 'Em andamento', true);
INSERT INTO STATUS_INVENTARIO (ID, DESCRICAO, ATIVO) VALUES (2, 'Aprovado', true);
INSERT INTO STATUS_INVENTARIO (ID, DESCRICAO, ATIVO) VALUES (3, 'Cancelad0', true);


-- Cadastro de Tipo de inventário
INSERT INTO TIPO_INVENTARIO (ID, DESCRICAO, ATIVO) VALUES (1, 'Total', true);

-- Cadastro de Local de Estoque
INSERT INTO LOCALESTOQUE (ID, ATIVO, DESCRICAO, NOME) VALUES (1, true, 'Setor de Recebimento', 'Recebimento');
INSERT INTO LOCALESTOQUE (ID, ATIVO, DESCRICAO, NOME) VALUES (2, true, 'Setor de Recebimento', 'Pendente de alocação');
INSERT INTO LOCALESTOQUE (ID, ATIVO, DESCRICAO, NOME) VALUES (3, true, 'Setor de Estoque', 'Inventário');