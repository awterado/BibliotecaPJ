package model;

public class User {
    
    private int id;
    private String nome, emial;
    private String fone, cpf;

    public User() {}

    public User(String nome, String emial, String fone, String cpf) {
        this.nome = nome;
        this.emial = emial;
        this.fone = fone;
        this.cpf = cpf;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "User{" + "ID DO USUÁRIO: " + id + '}';
    }
    
    
    
}
