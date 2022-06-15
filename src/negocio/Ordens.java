package negocio;

import java.util.ArrayList;

public class Ordens {

    private int id;
    private String funcionario;
    private String cliente;
    private String data_entrada;
    private String data_saida;
    private ArrayList<String> serviços;
    private ArrayList<String> descriçao_serviços;
    private int valor_total;

    public Ordens(String funcionario, String cliente, String data_entrada, String data_saida, ArrayList<String> serviços, ArrayList<String> descriçao_serviços, int valor_total) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.serviços = serviços;
        this.descriçao_serviços = descriçao_serviços;
        this.valor_total = valor_total;
    }

    public Ordens(int id, String funcionario, String cliente, String data_entrada, String data_saida, ArrayList<String> serviços, ArrayList<String> descriçao_serviços, int valor_total) {
        this.id = id;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.serviços = serviços;
        this.descriçao_serviços = descriçao_serviços;
        this.valor_total = valor_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public ArrayList<String> getServiços() {
        return serviços;
    }

    public void setServiços(ArrayList<String> serviços) {
        this.serviços = serviços;
    }

    public ArrayList<String> getDescriçao_serviços() {
        return descriçao_serviços;
    }

    public void setDescriçao_serviços(ArrayList<String> descriçao_serviços) {
        this.descriçao_serviços = descriçao_serviços;
    }

    public int getValor_total() {
        return valor_total;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

}
