package apoio.db;

import apoio.splash.SplashPanel;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.sql.Statement;

public class GeradorBanco {

    public static boolean createDB() throws SQLException, DataBaseException, InterruptedException {
        boolean ok = false;

        DBConnectionManager conn = new DBConnectionManager("jdbc:postgresql://localhost:5432/", "postgres", "postgres");
        Statement stmt = conn.getConnection().createStatement();

        String sql = ("CREATE DATABASE mecanica;");

        if (stmt.execute(sql)) {
            System.out.println("Sei lá, nunca cai aqui!");
        } else {
            SplashPanel s = new SplashPanel();
            s.setVisible(true);
            createUsuario();
            sleep(1800);
            createCliente();
            sleep(1800);
            createCarro();
            sleep(1800);
            createFuncionario();
            sleep(1800);
            createPeças();
            sleep(1800);
            createOrdens();
            System.out.println("Database criado!");
            ok = true;
        }

        return ok;
    }

    public static void createUsuario() throws SQLException, DataBaseException, InterruptedException {
        try {
            DBConnectionManager conn = new DBConnectionManager();
            Statement stmt = conn.getConnection().createStatement();

            String sql = "CREATE TABLE usuario (\n"
                    + "id SERIAL NOT NULL,\n"
                    + "login varchar(45) NOT NULL,\n"
                    + "senha varchar(45) NOT NULL,\n"
                    + "PRIMARY KEY (id));"
                    + "INSERT INTO usuario(login, senha) VALUES ('Admin', 'e3afed0047b08059d0fada10f400c1e5');\n"
                    + "INSERT INTO usuario(login, senha) VALUES ('Andrey', '9cbf8a4dcb8e30682b927f352d6559a0');\n"
                    + "INSERT INTO usuario(login, senha) VALUES ('Bernardo', '9cbf8a4dcb8e30682b927f352d6559a0');\n"
                    + "INSERT INTO usuario(login, senha) VALUES ('Carlos', '9cbf8a4dcb8e30682b927f352d6559a0');\n"
                    + "INSERT INTO usuario(login, senha) VALUES ('Diego', '9cbf8a4dcb8e30682b927f352d6559a0');";

            if (stmt.execute(sql)) {
                System.out.println("xxx");
            } else {
                System.out.println("Tabela usuários criada!");
            }

        } catch (Exception e) {
            createDB();
            createUsuario();
        }
    }

    public static void createCliente() throws SQLException, DataBaseException, InterruptedException {
        try {
            DBConnectionManager conn = new DBConnectionManager();
            Statement stmt = conn.getConnection().createStatement();

            String sql = "CREATE TABLE cliente (\n"
                    + "id int NOT NULL,\n"
                    + "nome varchar(45) NOT NULL,\n"
                    + "cpf varchar(14) NOT NULL,\n"
                    + "PRIMARY KEY (id),\n"
                    + "FOREIGN KEY (id) REFERENCES usuario(id));"
                    + "INSERT INTO cliente(id, nome, cpf) VALUES (1, 'Administrador do Teste', '117.432.600-08');\n"
                    + "INSERT INTO cliente(id, nome, cpf) VALUES (2, 'Andrey Antonio Schneider', '040.731.190-44');\n"
                    + "INSERT INTO cliente(id, nome, cpf) VALUES (3, 'Bernardo Schneider', '142.127.710-71');\n"
                    + "INSERT INTO cliente(id, nome, cpf) VALUES (4, 'Carlos Magno', '067.483.530-17');\n"
                    + "INSERT INTO cliente(id, nome, cpf) VALUES (5, 'Diego Carvalho', '301.358.050-07');";

            if (stmt.execute(sql)) {
                System.out.println("xxx");
            } else {
                System.out.println("Tabela clientes criada!");
            }

        } catch (Exception e) {
            createDB();
            createCliente();
        }
    }

    public static void createCarro() throws SQLException, DataBaseException, InterruptedException {
        try {
            DBConnectionManager conn = new DBConnectionManager();
            Statement stmt = conn.getConnection().createStatement();

            String sql = "CREATE TABLE carro (\n"
                    + "modelo varchar(45) NOT NULL,\n"
                    + "ano int NOT NULL,\n"
                    + "placa varchar(45) NOT NULL,\n"
                    + "proprietario int NOT NULL,\n"
                    + "PRIMARY KEY (placa),\n"
                    + "FOREIGN KEY (proprietario) REFERENCES cliente(id));"
                    + "INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('VW Fusca', 'ITM9652', '1978', 1);\n"
                    + "INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('GM Celta', 'ABC1234', '2003', 2);\n"
                    + "INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('FORD Fiesta', 'CMN4587', '2010', 3);\n"
                    + "INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('RENAULT Sandero', 'POA2535', '2014', 4);\n"
                    + "INSERT INTO carro(modelo, placa, ano, proprietario) VALUES ('CITROEN Xsara', 'TMN0C00', '2007', 5);";

            if (stmt.execute(sql)) {
                System.out.println("xxx");
            } else {
                System.out.println("Tabela carros criada!");
            }

        } catch (Exception e) {
            createDB();
            createCarro();
        }
    }

    public static void createFuncionario() throws SQLException, DataBaseException, InterruptedException {
        try {
            DBConnectionManager conn = new DBConnectionManager();
            Statement stmt = conn.getConnection().createStatement();

            String sql = "CREATE TABLE funcionario (\n"
                    + "nome varchar(45) NOT NULL,\n"
                    + "cpf varchar(45) NOT NULL,\n"
                    + "funcao varchar(45) NOT NULL,\n"
                    + "PRIMARY KEY (cpf));"
                    + "INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Thiago Costa', '091.169.500-11', 'Mecânico');\n"
                    + "INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Italo Pereira', '183.502.890-07', 'Mecânico');\n"
                    + "INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Raul Teixeira', '871.878.610-36', 'Mecânico');\n"
                    + "INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Jader Schmidt', '526.209.170-93', 'Auxiliar Mecânico');\n"
                    + "INSERT INTO funcionario(nome, cpf, funcao) VALUES ('Ana Júlia', '494.988.990-70', 'Secretário');";

            if (stmt.execute(sql)) {
                System.out.println("xxx");
            } else {
                System.out.println("Tabela funcionários criada!");
            }

        } catch (Exception e) {
            createDB();
            createFuncionario();
        }
    }

    public static void createPeças() throws SQLException, DataBaseException, InterruptedException {
        try {
            DBConnectionManager conn = new DBConnectionManager();
            Statement stmt = conn.getConnection().createStatement();

            String sql = "CREATE TABLE peças (\n"
                    + "quantidade int NOT NULL,\n"
                    + "descriçao varchar(100) NOT NULL,\n"
                    + "preço varchar(45) NOT NULL);";

            if (stmt.execute(sql)) {
                System.out.println("xxx");
            } else {
                System.out.println("Tabela peças criada!");
            }

        } catch (Exception e) {
            createDB();
            createPeças();
        }
    }

    public static void createOrdens() throws SQLException, DataBaseException, InterruptedException {
        try {
            DBConnectionManager conn = new DBConnectionManager();
            Statement stmt = conn.getConnection().createStatement();

            String sql = "CREATE TABLE ordens (\n"
                    + "id SERIAL NOT NULL,\n"
                    + "funcionario varchar(45) NOT NULL,\n"
                    + "cliente varchar(45) NOT NULL,\n"
                    + "data_entrada varchar(45) NOT NULL,\n"
                    + "data_saida varchar(45) NOT NULL,\n"
                    + "serviços character varying,\n"
                    + "descriçao_serviços character varying,\n"
                    + "valor_total int NOT NULL,\n"
                    + "PRIMARY KEY (id));"
                    + "INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Thiago Costa', 'ITM9652', '20/05/2022', '21/05/2022', '{[Suspensão]}', '{\"[1 Amortecedor Dianteiro]\"}', 860);\n"
                    + "INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Italo Pereira', 'ABC1234', '23/05/2022', '23/05/2022', '{[Elétrica]}', '{\"[1 Lampada Farol]\"}', 45);\n"
                    + "INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Raul Teixeira', 'CMN4587', '23/05/2022', '24/05/2022', '{[Motor]}', '{\"[1 Cabeçote Motor\",\"8 Valvulas]\"}', 2740);\n"
                    + "INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Jader Schmidt', 'POA2535', '24/05/2022', '27/05/2022', '{[Lataria]}', '\"{[1 Maçaneta Porta]\"}', 335);\n"
                    + "INSERT INTO ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) VALUES ('Thiago Costa', 'TMN0C00', '27/05/2022', '28/05/2022', '{[Escapamento,Suspensão]}', '{\"[1 Silencioso Intermediario\",\"2 Coxim Amortecedor Dianteiro\",\"2 Kit Bat/Sanf]\"}', 666);";

            if (stmt.execute(sql)) {
                System.out.println("xxx");
            } else {
                System.out.println("Tabela ordens criada!");
            }

        } catch (Exception e) {
            createDB();
            createOrdens();
        }
    }

}
