package apresentacao;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import negocio.Carro;
import negocio.Cliente;

public class CarrosTableModel implements TableModel {

    private ArrayList<Carro> carros;
    private ArrayList<Cliente> clientes;

    public CarrosTableModel(ArrayList<Carro> carros, ArrayList<Cliente> clientes) {
        this.carros = carros;
        this.clientes = clientes;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }
    @Override
    public int getRowCount() {
        return carros.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] vet = {"Modelo", "Ano", "Placa", "Proprietario"};
        return vet[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        }
        if (columnIndex == 1) {
            return Integer.class;
        }
        if (columnIndex == 2) {
            return String.class;
        }
        if (columnIndex == 3) {
            return Integer.class;
        }

        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carro aux = carros.get(rowIndex);
        String cli = "";
        for (int i = 0; i < this.clientes.size(); i++) {
            if (aux.getProprietario() == this.clientes.get(i).getId()) {
                cli = this.clientes.get(i).getName();
            }
        }
        Object[] vet = {aux.getModelo(), aux.getAno(), aux.getPlaca(), cli};
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
