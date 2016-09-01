package model;

public class Employee {
    
    private int id;
    private String nome, fone, email, cpf; 

    public Employee() {}

    public int getId() {
        return id;
    }

    public Employee(int id, String nome, String fone, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.cpf = cpf;
    }

    public Employee(String nome, String fone, String email, String cpf) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.cpf = cpf;
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
