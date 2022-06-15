
CREATE TABLE usuario (
    id SERIAL NOT NULL,
    login varchar(45) NOT NULL,
    senha varchar(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cliente (
    id int NOT NULL,
    nome varchar(45) NOT NULL,
    cpf varchar(14) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES usuario(id)
);

CREATE TABLE carro (
    modelo varchar(45) NOT NULL,
    ano int NOT NULL,
    placa varchar(45) NOT NULL,
    proprietario int NOT NULL,
    PRIMARY KEY (placa),
    FOREIGN KEY (proprietario) REFERENCES cliente(id)
);

CREATE TABLE funcionario (
    nome varchar(45) NOT NULL,
    cpf varchar(45) NOT NULL,
    funcao varchar(45) NOT NULL,
    PRIMARY KEY (cpf)
);

CREATE TABLE peças (
    quantidade int NOT NULL,
    descriçao varchar(100) NOT NULL,
    preço varchar(45) NOT NULL
);

CREATE TABLE ordens (
    id SERIAL NOT NULL,
    funcionario varchar(45) NOT NULL,
    cliente varchar(45) NOT NULL,
    data_entrada varchar(45) NOT NULL,
    data_saida varchar(45) NOT NULL,
    serviços character varying,
    descriçao_serviços character varying,
    valor_total int NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO usuario(login, senha) VALUES ('Admin', 'e3afed0047b08059d0fada10f400c1e5');
INSERT INTO usuario(login, senha) VALUES ('Andrey', '9cbf8a4dcb8e30682b927f352d6559a0');
INSERT INTO usuario(login, senha) VALUES ('Bernardo', '9cbf8a4dcb8e30682b927f352d6559a0');
INSERT INTO usuario(login, senha) VALUES ('Carlos', '9cbf8a4dcb8e30682b927f352d6559a0');
INSERT INTO usuario(login, senha) VALUES ('Diego', '9cbf8a4dcb8e30682b927f352d6559a0');

INSERT INTO cliente(id, nome, cpf) VALUES (1, 'Administrador do Teste', '117.432.600-08');
INSERT INTO cliente(id, nome, cpf) VALUES (2, 'Andrey Antonio Schneider', '040.731.190-44');
INSERT INTO cliente(id, nome, cpf) VALUES (3, 'Bernardo Schneider', '142.127.710-71');
INSERT INTO cliente(id, nome, cpf) VALUES (4, 'Carlos Magno', '067.483.530-17');
INSERT INTO cliente(id, nome, cpf) VALUES (5, 'Diego Carvalho', '301.358.050-07');

INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('VW Fusca', 'ITM9652', '1978', 1);
INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('GM Celta', 'ABC1234', '2003', 2);
INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('FORD Fiesta', 'CMN4587', '2010', 3);
INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('RENAULT Sandero', 'POA2535', '2014', 4);
INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('CITROEN Xsara', 'TMN0C00', '2007', 5);

INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Thiago Costa', '091.169.500-11', 'Mecânico');
INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Italo Pereira', '183.502.890-07', 'Mecânico');
INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Raul Teixeira', '871.878.610-36', 'Mecânico');
INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Jader Schmidt', '526.209.170-93', 'Auxiliar Mecânico');
INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Ana Júlia', '494.988.990-70', 'Secretário');

INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Thiago Costa', 'ITM9652', '20/05/2022', '21/05/2022', '{[Suspensão]}', '{"[1 Amortecedor Dianteiro]"}', 860);
INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Italo Pereira', 'ABC1234', '23/05/2022', '23/05/2022', '{[Elétrica]}', '{"[1 Lampada Farol]"}', 45);
INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Raul Teixeira', 'CMN4587', '23/05/2022', '24/05/2022', '{[Motor]}', '{"[1 Cabeçote Motor","8 Valvulas]"}', 2740);
INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Jader Schmidt', 'POA2535', '24/05/2022', '27/05/2022', '{[Lataria]}', '"{[1 Maçaneta Porta]"}', 335);
INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Thiago Costa', 'TMN0C00', '27/05/2022', '28/05/2022', '{[Escapamento,Suspensão]}', '{"[1 Silencioso Intermediario","2 Coxim Amortecedor Dianteiro","2 Kit Bat/Sanf]"}', 666);
