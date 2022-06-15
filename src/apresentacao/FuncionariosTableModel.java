
package apresentacao;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import negocio.Funcionario;


public class FuncionariosTableModel implements TableModel{
    
    private ArrayList<Funcionario> func;

    public FuncionariosTableModel(ArrayList<Funcionario> func) {
        this.func = func;
    }

    public ArrayList<Funcionario> getFunc() {
        return func;
    }

    public void setFunc(ArrayList<Funcionario> func) {
        this.func = func;
    }
    
    @Override
    public int getRowCount() {
        return func.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] vet = {"Nome", "CPF", "Funcao"};
        return vet[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
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
        Funcionario aux = func.get(rowIndex);
        Object[] vet = {aux.getNome(), aux.getCpf(), aux.getFuncao()};
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
