package controller;

import dao.BookDAO;
import dao.EmployeeDAO;
import dao.LocDAO;
import dao.UserDAO;
import model.Book;
import model.Employee;
import model.Locacao;
import model.User;

public class LocCTRL {
    
    private LocDAO ldao;
    private UserDAO udao;
    private EmployeeDAO edao;
    private BookDAO bdao;
    
    public LocCTRL(){
        ldao = new LocDAO();
        udao = new UserDAO();
        edao = new EmployeeDAO();
        bdao = new BookDAO();
    }
    
    
    public boolean add(int id, int userId, int funId){
        Locacao loc = new Locacao();
        User u = new User();
        Employee e = new Employee();
        loc.setId(id);
        u = udao.selectById(userId);
        u.setId(userId);
        e = edao.selectById(funId);
        e.setId(funId);
        loc.setUser(u);
        loc.setEmployee(e);
        return ldao.insert(loc);
    }
    
    public boolean remove(int id){
        Locacao loc  = new Locacao();
        loc.setId(id);
        return ldao.delete(loc);
    }
    
    public Locacao buscarLoc(int id){
        Locacao loc = new Locacao();
        loc.setId(id);
        loc = ldao.selectLoc(id);
        if(loc == null){
            return null;
        }else{
            return loc;
        }
    }
    
    public boolean inserirBook(int locId, int bookId){
        Locacao loc = new Locacao();
        Book book = new Book();
        book = bdao.seletcById(bookId);
        book.setId(bookId);
        loc.setBook(book);
        loc.setId(locId);
        return ldao.insertBk(loc);
    }
    
}
