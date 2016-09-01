package controller;

import dao.BookDAO;
import java.util.List;
import model.Book;

public class BookCTRL {
    
    private BookDAO dao; 
    
    public BookCTRL(){
        dao = new BookDAO();
    }
    
    public boolean adcionar( int id, String titulo, String editor, String autor, String ano, String descricao){
        Book bk = new Book();
        bk.setId(id);
        bk.setTitulo(titulo);
        bk.setEditora(editor);
        bk.setAutor(autor);
        bk.setAno(ano);
        bk.setDescricao(descricao);
        return dao.insert(bk);
    }
    
    public boolean atualizar(int id, String titulo, String editor, String autor, String descricao, String ano){
        Book bk = new Book();
        bk.setId(id);
        bk.setTitulo(titulo);
        bk.setEditora(editor);
        bk.setAutor(autor);
        bk.setDescricao(descricao);
        bk.setAno(ano);
        return dao.update(bk);
    }
    
    public boolean remove(int id){
        Book bk = new Book();
        bk.setId(id);
        return dao.delete(bk);
    }
    
    public Book listarPorId(int id){
        Book bk = new Book();
        bk.setId(id);
        bk = dao.seletcById(id);
        if(bk == null){
            return null;
        }else{
            return bk;
        }
    }
    
    public List<Book> listar(){
        return dao.selectAll();
    }
    
    public List<Book> listarPorNome(String filter){
        if(filter == null){
            return null;
        }else{
            return dao.selectFilter(filter);
        }
    }
}
