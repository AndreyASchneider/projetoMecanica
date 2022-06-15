package apoio.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {

    private Connection connection;
    private ResultSet rs;

    private String url;
    private String user;
    private String password;

    private String scriptPath;

    public DBConnectionManager() {
        this.url = "jdbc:postgresql://localhost:5432/mecanica";
        this.user = "postgres";
        this.password = "postgres";
    }

    public DBConnectionManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void connectDataBase() throws DataBaseException {
        this.connection = null;
        try {
            if (user == null || user.isEmpty()) {
                Connection c = DriverManager.getConnection(url);
                this.connection = c;
            } else {
                Connection c = DriverManager.getConnection(this.url, this.user, this.password);
                this.connection = c;
            }
        } catch (SQLException ex) {
            /*
            if (GeradorBanco.gerarBancoDados()){
                System.out.println("O banco foi criado agora!");
            } else {
                System.out.println("O banco já existe!");
            }*/
            throw new DataBaseException("A conexão com o banco de dados falhou");
        }
    }

    /**
     * *
     * Abre e fecha uma conexão com o banco de dados. Realiza um teste conexão
     * com o banco.
     *
     * @throws DataBaseException
     */
    public void connectionTest() throws DataBaseException {
        try {
            connectDataBase();
            this.connection.close();
            this.connection = null;
        } catch (DataBaseException ex) {
            throw new DataBaseException("O teste de conexão com o banco de dados falhou");
        } catch (SQLException ex) {
            throw new DataBaseException("O teste de conexão com o banco de dados falhou");
        }
    }

    public void runSQL(String sql) throws DataBaseException {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                this.connectDataBase();
            }
            executeSQL(sql);
        } catch (SQLException ex) {
            throw new DataBaseException("Erro na execução de uma instrução SQL");
        }
    }

    public Connection getConnection() throws DataBaseException {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                this.connectDataBase();
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        } catch (DataBaseException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return connection;
    }

    public ResultSet runQuerySQL(String sql) throws DataBaseException {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                this.connectDataBase();
            }
            this.rs = executeQuerySQL(sql);
        } catch (SQLException ex) {
            throw new DataBaseException("Erro em runQuerySQL");
        }
        return rs;
    }

    public ResultSet executeQuerySQL(String sql) throws DataBaseException {
        Statement stm;
        try {
            stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            this.rs = rs;
        } catch (NullPointerException ex) // se a variável connection estiver null
        {
            throw new DataBaseException("Falha na execução da consulta SQL 1");
        } catch (SQLException ex) {
            throw new DataBaseException("Falha na execução da consulta SQL 2");
        }
        return rs;
    }

    public ResultSet getResultSet() {
        return rs;
    }

    public void closeConnection() throws DataBaseException {
        try {
            connection.close();
        } catch (NullPointerException ex) // se a variável connection estiver null
        {
            throw new DataBaseException("Ocorreu um erro ao fechar a conexão com o banco");
        } catch (SQLException ex) {
            throw new DataBaseException("Ocorreu um erro ao fechar a conexão com o banco");
        }
    }

    public void executeSQL(String sql) throws DataBaseException {
        Statement stm;
        try {
            stm = connection.createStatement();
            stm.executeUpdate(sql);
        } catch (NullPointerException ex) // se a variável connection estiver null
        {
            throw new DataBaseException("Falha na execução da instrução SQL (NullPointer)");
        } catch (SQLException ex) {
            throw new DataBaseException("Falha na execução da instrução SQL");
        }
    }

    public void runScritpSQL() throws DataBaseException {
        if (!this.scriptPath.isEmpty()) {
            InputStream is = getClass().getResourceAsStream(this.scriptPath);
            this.runScritpSQL(is);
        } else {
            throw new DataBaseException("Caminho do script SQL não foi definido");
        }
    }

    public void runScritpSQL(InputStream is) throws DataBaseException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            String sql = "";
            String linha = bufferedReader.readLine();
            while (linha != null) {
                // pular comentários
                if ((linha.length() > 0 && (linha.charAt(0) == '#' || linha.charAt(0) == '-')) || linha.length() == 0) {
                    linha = bufferedReader.readLine();
                    continue;
                }
                sql += " " + linha.trim();

                //comando está completo (encontrou o ;)
                if (sql.charAt(sql.length() - 1) == ';') {
                    try {
                        this.executeSQL(sql.trim());
                        sql = "";
                    } catch (DataBaseException ex) {
                        bufferedReader.close();
                        throw new DataBaseException(ex.getMessage() + ": " + sql.trim());
                    }

                }
                linha = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException ex) {
            throw new DataBaseException("Falha na execução do script SQL");
        }
    }

}
