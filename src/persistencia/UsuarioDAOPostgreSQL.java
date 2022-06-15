
package persistencia;

import apoio.db.DBConnectionManager;
import apoio.db.DataBaseException;
import apoio.db.DuplicateKeyException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Filter;
import negocio.Usuario;

public class UsuarioDAOPostgreSQL implements UsuarioDAO{

    private DBConnectionManager conexao;
    
    public UsuarioDAOPostgreSQL() throws DataBaseException{
        this.conexao = new DBConnectionManager();
    }

    @Override
    public void criar(Usuario user) throws DataBaseException, DuplicateKeyException {
        if (user != null) {
            // criar SQL string
            String sql = "insert into usuario(login, senha) values ('" + user.getLogin()+ "', '" + user.getSenha()+ "' );";

            try {
                conexao.runSQL(sql);
            } catch (DataBaseException ex) {
                throw new DuplicateKeyException();
            }
        }
    }

    @Override
    public void editar(Usuario user) throws DataBaseException {
        if (user != null) {
            // criar SQL string
            String sql = "update usuario set login='" + user.getLogin() + "', senha='" + user.getSenha() + "' where id=" + user.getId() + ";";
            System.out.println(sql);
            conexao.runSQL(sql);
        }
    }

    @Override
    public void apagar(Usuario user) throws DataBaseException {
        if (user != null) {
            // criar SQL string
            String sql = "delete from usuario where id=" + user.getId() + ";";

            conexao.runSQL(sql);
        }
    }

    @Override
    public Usuario ler(int id) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> lerTudo() throws DataBaseException {
        ArrayList<Usuario> list = new ArrayList();

        ResultSet rs = conexao.runQuerySQL("SELECT * FROM usuario;");

        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String login = rs.getString("login");
                    String senha = rs.getString("senha");
                    Usuario c = new Usuario(id, login, senha);
                    list.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Usuario> lerComFiltro(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
