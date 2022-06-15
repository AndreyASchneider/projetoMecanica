package negocio;

public class Carro {
    private String modelo;
    private int ano;
    private String placa;
    private int proprietario;

    public Carro(String modelo, int ano, String placa, int proprietario) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.proprietario = proprietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }
     
}
