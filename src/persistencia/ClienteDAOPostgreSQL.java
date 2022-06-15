package persistencia;

import apoio.db.DuplicateKeyException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Filter;
import negocio.Cliente;
import apoio.db.DBConnectionManager;
import apoio.db.DataBaseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOPostgreSQL implements ClienteDAO {

    private DBConnectionManager conexao;

    public ClienteDAOPostgreSQL() throws DataBaseException {
        this.conexao = new DBConnectionManager();
    }

    @Override
    public void criar(Cliente cliente) throws DataBaseException, DuplicateKeyException {

        if (cliente != null) {

            // criar SQL string
            String sql = "insert into cliente(id, nome, cpf) values ('" + cliente.getId() + "', '" + cliente.getName() + "', '" + cliente.getCPF() + "' );";

            try {
                conexao.runSQL(sql);
            } catch (DataBaseException ex) {
                throw new DuplicateKeyException();
            }
        }
    }

    @Override
    public void editar(Cliente cliente) throws DataBaseException {
        if (cliente != null) {
            // criar SQL string
            String sql = "update cliente set nome='" + cliente.getName() + "', cpf='" + cliente.getCPF() + "' where id=" + cliente.getId() + ";";
            conexao.runSQL(sql);
        }
    }

    @Override
    public void apagar(Cliente cliente) throws DataBaseException {
        if (cliente != null) {
            // criar SQL string
            String sql = "delete from cliente where id=" + cliente.getId() + ";";

            conexao.runSQL(sql);
        }
    }

    @Override
    public Cliente ler(int id) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> lerTudo() throws DataBaseException {
        ArrayList<Cliente> list = new ArrayList();

        ResultSet rs = conexao.runQuerySQL("SELECT * FROM cliente;");

        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    Cliente c = new Cliente(id, nome, cpf);
                    list.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Cliente> lerComFiltro(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> lerComFiltro(String nome) {
        ArrayList<Cliente> list = new ArrayList();
        String sql = "SELECT * FROM cliente WHERE nome like '%" + nome + "%';";
        
        try {
            ResultSet rs = conexao.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nomecliente = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    Cliente c = new Cliente(id, nomecliente, cpf);
                    list.add(c);
                }
            }
        } catch (DataBaseException ex) {
            Logger.getLogger(ClienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

}
