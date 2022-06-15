package apresentacao;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import negocio.Peças;

public class PeçasTableModel implements TableModel {

    private ArrayList<Peças> peças;

    public PeçasTableModel(ArrayList<Peças> peças) {
        this.peças = peças;
    }

    public ArrayList<Peças> getPeças() {
        return peças;
    }

    public void setPeças(ArrayList<Peças> peças) {
        this.peças = peças;
    }

    @Override
    public int getRowCount() {
        return peças.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] vet = {"Quantidade", "Descrição", "Preço Un."};
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
        
        return String.class;
         
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Peças aux = peças.get(rowIndex);
        Object[] vet = {aux.getQuantidade(), aux.getDescriçao(), aux.getPreço()};
        return vet[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
