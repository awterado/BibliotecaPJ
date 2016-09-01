package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Book;
public class BookDAO {
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public BookDAO(){
        db = new DataBase();
    }
    
    public boolean insert(Book bk){
        if(db.open()){
            sql = "INSERT INTO tb_livros ( liv_id, liv_titulo, liv_editora, liv_autor, liv_ano, liv_descricao) VALUES (?,?,?,?,?,?)";
            try{
                ps = db.connection.prepareCall(sql);
                ps.setInt(1, bk.getId());
                ps.setString(2, bk.getTitulo());
                ps.setString(3, bk.getEditora());
                ps.setString(4, bk.getAutor());
                ps.setString(5, bk.getAno());
                ps.setString(6, bk.getDescricao());
                if(ps.executeUpdate()== 1){
                    ps.close();
                    db.close();
                    return true;
                }
            }catch(SQLException error){
                System.out.println("ERRO: " + error);
            }
        }
        db.close();
        return false;
    }
    
    public boolean update(Book bk){
        if(db.open()){
            sql = "UPDATE tb_livros SET liv_titulo = ?, liv_editora = ?, liv_autor = ?, liv_ano = ?,  liv_descricao = ? WHERE liv_id = ?";
            try{
                ps = db.connection.prepareCall(sql);
                ps.setString(1, bk.getTitulo());
                ps.setString(2, bk.getEditora());
                ps.setString(3, bk.getAutor());
                ps.setString(4, bk.getAno());
                ps.setString(5, bk.getDescricao());
                ps.setInt(6, bk.getId());
                if(ps.executeUpdate() == 1){
                    ps.close();
                    db.close();
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao editar usuário");
                    return false;
                }
                
            }catch(SQLException error){
                System.out.println("ERRO: " + error);
            }
        }
        db.close();
        return false;
    }
    
    public boolean delete(Book bk){
        if(db.open()){
            sql = "DELETE FROM tb_livros WHERE liv_id = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, bk.getId());
                if (ps.executeUpdate() == 1) {
                    ps.close();
                    db.close();
                    return true;
                }
            }catch(SQLException error){
                System.out.println("ERRO: " + error);
            }
        }
        db.close();
        return false;
    }
    
    public Book seletcById(int id){
        if(db.open()){
            sql = "SELECT * FROM tb_livros WHERE liv_id = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    Book bk = new Book();
                    bk.setId(rs.getInt("liv_id"));
                    bk.setTitulo(rs.getString("liv_titulo"));
                    bk.setEditora(rs.getString("liv_editora"));
                    bk.setAutor(rs.getString("liv_autor"));
                    bk.setAno(rs.getString("liv_ano"));
                    bk.setDescricao(rs.getString("liv_descricao"));
                    rs.close();
                    ps.close();
                    db.close();
                    return bk;
                }
                rs.close();
                ps.close();
            }catch(SQLException error){
                System.out.println("ERRO: " + error);
            }
        }
        db.close();
        return null;
    }
    
    public List<Book> selectAll() {
        if (db.open()) {
            List<Book> bks = new ArrayList();
            sql = "SELECT * FROM tb_livros";
            try {
                ps = db.connection.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Book bk = new Book();
                    bk.setId(rs.getInt(1));
                    bk.setTitulo(rs.getString(2));
                    bk.setEditora(rs.getString(3));
                    bk.setAutor(rs.getString(4));
                    bk.setAno(rs.getString(5));
                    bk.setDescricao(rs.getString(6));
                    bks.add(bk);
                }
                rs.close();
                ps.close();
                db.close();
                return bks;
            } catch (SQLException error) {
                System.out.println("ERRO: " + error.toString());
            }
        }
        db.close();
        return null;
    }
    
    public List<Book> selectFilter(String filter) {
        if (db.open()) {
            List<Book> bks = new ArrayList();
            String filtro = "%" + filter + "%";
            sql = "SELECT * FROM tb_livros WHERE liv_titulo LIKE ? OR liv_autor LIKE ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, filtro);
                ps.setString(2, filtro);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Book bk = new Book();
                    bk.setId(rs.getInt(1));
                    bk.setTitulo(rs.getString(2));
                    bk.setAutor(rs.getString(3));
                    bks.add(bk);
                }
                rs.close();
                ps.close();
                db.close();
                return bks;
            } catch (SQLException error) {
                System.out.println("ERRO: " + error.toString());
            }
        }
        db.close();
        return null;
    }
    
}
