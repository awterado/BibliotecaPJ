package model;

public class Book {
    
    private int id;
    private String titulo, editora, autor, descricao, ano;

    public Book() {}

    public Book(int id, String titulo, String editora, String autor, String descricao, String ano) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autor = autor;
        this.descricao = descricao;
        this.ano = ano;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    
    
}
