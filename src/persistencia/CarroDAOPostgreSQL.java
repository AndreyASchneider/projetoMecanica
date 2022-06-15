package persistencia;

import apoio.db.DBConnectionManager;
import apoio.db.DataBaseException;
import apoio.db.DuplicateKeyException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Carro;

public class CarroDAOPostgreSQL implements CarroDAO {

    private DBConnectionManager conexao;

    public CarroDAOPostgreSQL() throws DataBaseException {
        this.conexao = new DBConnectionManager();
    }

    @Override
    public void criar(Carro carro) throws DataBaseException, DuplicateKeyException {
        if (carro != null) {

            // criar SQL string
            String sql = "insert into carro(modelo, ano, placa, proprietario) values ('" + carro.getModelo() + "', '" + carro.getAno() + "', '" + carro.getPlaca() + "', '" + carro.getProprietario() + "' );";

            try {
                conexao.runSQL(sql);
            } catch (DataBaseException ex) {
                throw new DuplicateKeyException();
            }
        }
    }

    @Override
    public void editar(Carro carro) throws DataBaseException {
        if (carro != null) {
            // criar SQL string
            String sql = "update carro set modelo='" + carro.getModelo() + "', ano='" + carro.getAno() + "', proprietario='" + carro.getProprietario() + "' where placa= '" + carro.getPlaca() + "' ;";
            conexao.runSQL(sql);
        }
    }

    @Override
    public void apagar(Carro carro) throws DataBaseException {
        if (carro != null) {
            // criar SQL string
            String sql = "delete from carro where placa= '" + carro.getPlaca() + "' ;";

            conexao.runSQL(sql);
        }
    }

    @Override
    public Carro ler(int id) throws DataBaseException { 
        return null;
    }
    
    public Carro ler() throws DataBaseException {
        return null;
    }

    @Override
    public ArrayList<Carro> lerTudo() throws DataBaseException {
        ArrayList<Carro> list = new ArrayList();

        ResultSet rs = conexao.runQuerySQL("SELECT * FROM carro;");

        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String modelo = rs.getString("modelo");
                    int ano = rs.getInt("ano");
                    String placa = rs.getString("placa");
                    int proprietario = rs.getInt("proprietario");
                    Carro c = new Carro(modelo, ano, placa, proprietario);
                    list.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Carro> lerComFiltro(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Carro> lerComFiltro(String anocar) {
        int anoint = Integer.parseInt(anocar);
        ArrayList<Carro> list = new ArrayList();
        String sql = "SELECT * FROM carro WHERE ano >='" + anoint + "';";
        
        try {
            ResultSet rs = conexao.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String modelo = rs.getString("modelo");
                    int ano = rs.getInt("ano");
                    String placa = rs.getString("placa");
                    int proprietario = rs.getInt("proprietario");
                    Carro c = new Carro(modelo, ano, placa, proprietario);
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
