package apresentacao;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import negocio.Cliente;
import negocio.Usuario;

public class ClientesTableModel implements TableModel {

    private ArrayList<Cliente> clientes;
    private ArrayList<Usuario> usuarios;

    public ClientesTableModel(ArrayList<Cliente> clientes, ArrayList<Usuario> usuarios) {
        this.clientes = clientes;
        this.usuarios = usuarios;
    }

    ClientesTableModel(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] vet = {"Código", "Nome", "CPF"};
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        }
        if (columnIndex == 1) {
            return String.class;
        }
        if (columnIndex == 2) {
            return String.class;
        }

        return Integer.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente aux = clientes.get(rowIndex);
        String usu = "";
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (aux.getId() == this.usuarios.get(i).getId()) {
                usu = this.usuarios.get(i).getLogin();
            }
        }
        Object[] vet = {aux.getId(), aux.getName(), aux.getCPF()};
        return vet[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
