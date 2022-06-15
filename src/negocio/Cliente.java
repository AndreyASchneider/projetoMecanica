package negocio;

public class Cliente {
    private int id;
    private String name;
    private String CPF;
    

    public Cliente(int id, String name, String CPF) {
        this.id = id;
        this.name = name;
        this.CPF = CPF;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public String toString(){
        return this.name;
    }

}
