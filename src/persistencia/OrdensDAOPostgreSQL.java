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
import negocio.Ordens;
import negocio.Peças;

public class OrdensDAOPostgreSQL implements OrdensDAO {

    private DBConnectionManager conexao;

    OrdensDAOPostgreSQL() throws DataBaseException {
        this.conexao = new DBConnectionManager();
    }

    @Override
    public void criar(Ordens ordem) throws DataBaseException, DuplicateKeyException {
        if (ordem != null) {

            // criar SQL string
            String sql = "insert into ordens(funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total) values ('" + ordem.getFuncionario() + "', '" + ordem.getCliente() + "', '" + ordem.getData_entrada() + "', '" + ordem.getData_saida() + "', '{" + ordem.getServiços() + "}', '{" + ordem.getDescriçao_serviços() + "}', '" + ordem.getValor_total() + "');";

            System.out.println(sql);

            try {
                conexao.runSQL(sql);
            } catch (DataBaseException ex) {
                throw new DuplicateKeyException();
            }
        }
    }

    @Override
    public void editar(Ordens ordem) throws DataBaseException {
        if (ordem != null) {
            // criar SQL string
            String sql = "update ordens set funcionario='" + ordem.getFuncionario() + "', cliente='" + ordem.getCliente() + "', data_entrada='" + ordem.getData_entrada() + "', data_saida='" + ordem.getData_saida() + "', seviços='" + ordem.getServiços() + "', descriçao_serviços='" + ordem.getDescriçao_serviços() + "', valor_total='" + ordem.getValor_total() + "' where id=" + ordem.getId() + ";";
            conexao.runSQL(sql);
        }
    }

    @Override
    public void apagar(Ordens a) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ordens ler(int id) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Ordens> lerTudo() throws DataBaseException {
        ArrayList<Ordens> list = new ArrayList();

        ResultSet rs = conexao.runQuerySQL("SELECT * FROM ordens;");

        try {
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String funcionario = rs.getString("funcionario");
                    String cliente = rs.getString("cliente");
                    String data_entrada = rs.getString("data_entrada");
                    String data_saida = rs.getString("data_saida");
                    ArrayList serviços = (ArrayList) rs.getArray("serviços");
                    ArrayList descriçao_serviços = (ArrayList) rs.getArray("descriçao_serviços");
                    int valor_total = rs.getInt("valor_total");
                    Ordens c = new Ordens(id, funcionario, cliente, data_entrada, data_saida, serviços, descriçao_serviços, valor_total);
                    list.add(c);
                }
            }
        } catch (SQLException ex) {
            throw new DataBaseException(ex.getMessage());
        }
        return list;
    }

    @Override
    public ArrayList<Ordens> lerComFiltro(Filter filter) throws DataBaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Ordens> lerComFiltro(String datamin, String datamax) {
        ArrayList<Ordens> list = new ArrayList();
        String sql = "SELECT id, funcionario, cliente, data_entrada, data_saida, valor_total FROM ordens WHERE data_entrada >= '" + datamin + "' AND data_saida <= '" + datamax + "';";

        try {
            ResultSet rs = conexao.runQuerySQL(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String funcionario = rs.getString("funcionario");
                    String cliente = rs.getString("cliente");
                    String data_entrada = rs.getString("data_entrada");
                    String data_saida = rs.getString("data_saida");
                    int valor_total = rs.getInt("valor_total");
                    Ordens o = new Ordens(id, funcionario, cliente, data_entrada, data_saida, null, null, valor_total);
                    list.add(o);
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
