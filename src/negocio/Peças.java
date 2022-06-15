package negocio;

public class Peças {

    private int quantidade;
    private String descriçao;
    private String preço;

    public Peças(int quantidade, String descriçao, String preço) {
        this.quantidade = quantidade;
        this.descriçao = descriçao;
        this.preço = preço;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescriçao() {
        return descriçao;
    }

    public void setDescriçao(String descriçao) {
        this.descriçao = descriçao;
    }

    public String getPreço() {
        return preço;
    }

    public void setPreço(String preço) {
        this.preço = preço;
    }

}
