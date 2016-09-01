package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Book;
import model.Locacao;
import model.User;

public class LocDAO {
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public LocDAO(){
        db = new DataBase();
    }
    
    public boolean insert(Locacao loc){
        if(db.open()){
            sql = "INSERT INTO tb_locacao (loc_id, loc_us_id, loc_fun_id) VALUES (?, ?, ?)";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, loc.getId());
                ps.setInt(2, loc.getUser().getId());
                ps.setInt(3, loc.getEmployee().getId());
                if(ps.executeUpdate() == 1){
                    ps.close();
                    return true;
                }
                ps.close();
            }catch(SQLException error){
                System.out.println("ERRO: " + error);
            }catch(NullPointerException error){
                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatorios!" + error);
            }catch(NumberFormatException error){
                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatorios!" + error);
            }
        }
        db.close();
        return false;
    }
    
    public boolean insertBk(Locacao loc){
        if(db.open()){
            sql = "INSERT INTO tb_loc_book (lbk_loc_id, lbk_liv_id) VALUES (?, ?)";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, loc.getBook().getId());
                ps.setInt(2, loc.getId());
                if(ps.executeUpdate() == 1){
                    ps.close();
                    return true;
                }
                ps.close();
            }catch(SQLException error){
                System.out.println("ERRO: " + error);
            }
        }
        db.close();
        return false;
    }
    
    public boolean delete(Locacao loc){
        if(db.open()){
            sql = "DELETE FROM tb_locacao WHERE loc_id = ?";
            try{
                db.connection.prepareStatement(sql);
                ps.setInt(1, loc.getId());
            }catch(SQLException error){
                System.out.println("EEEO: " + error);
            }
        }
        return false;
    }
    
    public Locacao selectLoc(int id){
        if(db.open()){
            sql = "SELECT * FROM tb_usuarios JOIN tb_locacao ON us_id = loc_us_id JOIN tb_loc_book ON loc_id = lbk_loc_id JOIN tb_livros ON liv_id = lbk_liv_id WHERE loc_id = ?";
            try{
                db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    Book bk = new Book();
                    Locacao loc = new Locacao();
                    User us = new User();
                    
                    bk.setTitulo(rs.getString("lic_titulo"));
                    loc.setId(rs.getInt("loc_id"));
                    us.setNome(rs.getString("us_nome"));
                    
                    rs.close();
                    ps.close();
                    db.close();
                    
                    return loc;
                }
            }catch(SQLException error){
                System.out.println("ERRO: " + error);
            }
        }
        db.close();
        return null;
    }
    
}
