package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO {
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public UserDAO(){
        db = new DataBase();
    }
    
    public boolean insert(User usuario){
        if(db.open()){
            sql = "INSERT INTO tb_usuarios (us_nome, us_fone, us_email, us_cpf) VALUES (?,?,?,?)";
            try{
                ps = db.connection.prepareCall(sql);
                ps.setString(1, usuario.getNome());
                ps.setString(3, usuario.getFone());
                ps.setString(2, usuario.getEmial());
                ps.setString(4, usuario.getCpf());
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
    
    public boolean update(User us){
        if(db.open()){
            sql = "UPDATE tb_usuarios SET us_nome = ?, us_fone = ?, us_email = ? WHERE us_cpf = ?";
            try{
                ps = db.connection.prepareCall(sql);
                ps.setString(1, us.getNome());
                ps.setString(2, us.getFone());
                ps.setString(3, us.getEmial());
                ps.setString(4, us.getCpf());
                if(ps.executeUpdate() == 1){
                    ps.close();
                    db.close();
                    return true;
                }else{
                    return false;
                }
                
            }catch(SQLException error){
                System.out.println("ERRO: " + error);
            }
        }
        db.close();
        return false;
    }
    
    public boolean delete(User us){
        if(db.open()){
            sql = "DELETE FROM tb_usuarios WHERE us_cpf = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, us.getCpf());
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
    
    public List<User> selectAll() {
        if (db.open()) {
            List<User> uss = new ArrayList();
            sql = "SELECT * FROM tb_usuarios";
            try {
                ps = db.connection.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    User us = new User();
                    us.setId(rs.getInt(1));
                    us.setNome(rs.getString(2));
                    us.setFone(rs.getString(3));
                    us.setCpf(rs.getString(4));
                    us.setEmial(rs.getString(5));
                    uss.add(us);
                }
                rs.close();
                ps.close();
                db.close();
                return uss;
            } catch (SQLException error) {
                System.out.println("ERRO: " + error.toString());
            }
        }
        db.close();
        return null;
    }
    
    public User findByCpf(String cpf){
        if(db.open()){
            
            sql = "SELECT * FROM tb_usuarios WHERE us_cpf = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, cpf);
                rs = ps.executeQuery();
                while(rs.next()){
                    User us = new User();
                    us.setId(rs.getInt("us_id"));
                    us.setNome(rs.getString("us_nome"));
                    us.setFone(rs.getString("us_fone"));
                    us.setCpf(rs.getString("us_cpf"));
                    us.setEmial(rs.getString("us_email"));
                    rs.close();
                    ps.close();
                    db.close();
                    return us;
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
    
    public User selectById(int id){
        if(db.open()){
            sql = "SELECT * FROM tb_usuarios WHERE us_id = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while(rs.next()){
                    User us = new User();
                    us.setId(rs.getInt("us_id"));
                    us.setNome(rs.getString("us_nome"));
                    us.setFone(rs.getString("us_fone"));
                    us.setCpf(rs.getString("us_cpf"));
                    us.setEmial(rs.getString("us_email"));
                    rs.close();
                    ps.close();
                    db.close();
                    return us;
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
    
    
    
    public List<User> selectFilter(String filter) {
        if (db.open()) {
            List<User> users = new ArrayList();
            String filtro = "%" + filter + "%";
            sql = "SELECT * FROM tb_usuarios WHERE us_nome LIKE ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, filtro);
                rs = ps.executeQuery();
                while (rs.next()) {
                    User us = new User();
                    us.setFone(rs.getString("us_fone"));
                    us.setCpf(rs.getString("us_cpf"));
                    us.setEmial(rs.getString("us_email"));
                    users.add(us);
                }
                rs.close();
                ps.close();
                db.close();
                return users;
            } catch (SQLException error) {
                System.out.println("ERRO: " + error);
            }
        }
        db.close();
        return null;
    }
    
      
}
