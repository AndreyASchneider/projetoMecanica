package persistencia;

import apoio.db.DBConnectionManager;
import apoio.db.DataBaseException;
import apoio.db.DuplicateKeyException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Filter;
import negocio.Funcionario;
import negocio.Peças;

public class PeçasDAOPostgreSQL implements PeçasDAO {

    private DBConnectionManager conexao;

    public PeçasDAOPostgreSQL() throws DataBaseException {
        this.conexao = new DBConnectionManager();
    }

    @Override
    public void criar(Peças p) throws DataBaseException, DuplicateKeyException {
        if (p != null) {

            // criar SQL string
            String sql = "insert into peças(quantidade, descriçao, preço) values ('" + p.getQuantidade() + "', '" + p.getDescriçao() + "', '" + p.getPreço() + "' );";

            try {
                conexao.runSQL(sql);
            } catch (DataBaseException ex) {
                throw new DuplicateKeyException();
            }
        }
    }

    @Override
    public void editar(Peças p) throws DataBaseException {
        if (p != null) {
            // criar SQL string
            String sql = "update peças set quantidade='" + p.getQuantidade() + "', descriçao='" + p.getDescriçao() + "', preço='" + p.getPreço() + "';";
            conexao.runSQL(sql);
        }
    }

    @Override
    public void apagar(Peças p) throws DataBaseException {
        if (p != null) {
            String sql = "delete from peças;";
            conexao.runSQL(sql);
        }
    }

    @Override
    public Peças ler(int id) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Peças> lerTudo() throws DataBaseException {
        ArrayList<Peças> list = new ArrayList();

        ResultSet rs = conexao.runQuerySQL("SELECT * FROM peças;");

        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int quantidade = rs.getInt("quantidade");
                    String descriçao = rs.getString("descriçao");
                    String preço = rs.getString("preço");
                    Peças c = new Peças(quantidade, descriçao, preço);
                    list.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Peças> lerComFiltro(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
