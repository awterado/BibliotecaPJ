package model;

public class Locacao {
    
    private int id;
    private Employee employee;
    private User user;
    private Book book;

    public Locacao() {}

    public Locacao(int id, Employee employee, User user) {
        this.id = id;
        this.employee = employee;
        this.user = user;
    }

    public Locacao(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    
    
}
