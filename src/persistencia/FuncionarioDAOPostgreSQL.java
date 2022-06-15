package persistencia;

import apoio.db.DBConnectionManager;
import apoio.db.DataBaseException;
import apoio.db.DuplicateKeyException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Filter;
import negocio.Funcionario;

public class FuncionarioDAOPostgreSQL implements FuncionarioDAO {

    private DBConnectionManager conexao;

    public FuncionarioDAOPostgreSQL() throws DataBaseException {
        this.conexao = new DBConnectionManager();
    }

    @Override
    public void criar(Funcionario fun) throws DataBaseException, DuplicateKeyException {
        if (fun != null) {

            // criar SQL string
            String sql = "insert into funcionario(nome, cpf, funcao) values ('" + fun.getNome() + "', '" + fun.getCpf() + "', '" + fun.getFuncao() + "');";

            try {
                conexao.runSQL(sql);
            } catch (DataBaseException ex) {
                throw new DuplicateKeyException();
            }
        }
    }

    @Override
    public void editar(Funcionario fun) throws DataBaseException {
        if (fun != null) {
            // criar SQL string
            String sql = "update funcionario set nome='" + fun.getNome() + "', funcao='" + fun.getFuncao() + "' where cpf='" + fun.getCpf() + "';";
            conexao.runSQL(sql);
        }
    }

    @Override
    public void apagar(Funcionario fun) throws DataBaseException {
        if (fun != null) {
            // criar SQL string
            String sql = "delete from funcionario where cpf='" + fun.getCpf() + "';";
            conexao.runSQL(sql);
        }
    }

    @Override
    public Funcionario ler(int id) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Funcionario> lerTudo() throws DataBaseException {
        ArrayList<Funcionario> list = new ArrayList();

        ResultSet rs = conexao.runQuerySQL("SELECT * FROM funcionario;");

        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String funcao = rs.getString("funcao");
                    Funcionario c = new Funcionario(nome, cpf, funcao);
                    System.out.println("adicionando novo funcionario");
                    list.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Funcionario> lerComFiltro(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
