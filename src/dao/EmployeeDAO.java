package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Employee;

public class EmployeeDAO {
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public EmployeeDAO(){
        db = new DataBase();
    }
    
    public boolean insert(Employee fun){
        if(db.open()){
            sql = "INSERT INTO tb_funcionarios (fun_nome, fun_fone, fun_email, fun_cpf) VALUES (?,?,?,?)";
            try{
                ps = db.connection.prepareCall(sql);
                ps.setString(1, fun.getNome());
                ps.setString(2, fun.getFone());
                ps.setString(3, fun.getEmail());
                ps.setString(4, fun.getCpf());
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
    
    public boolean update(Employee fun){
        if(db.open()){
            sql = "UPDATE tb_funcionarios SET fun_nome = ?, fun_fone = ?, fun_email = ? WHERE fun_cpf = ?";
            try{
                ps = db.connection.prepareCall(sql);
                ps.setString(1, fun.getNome());
                ps.setString(2, fun.getFone());
                ps.setString(3, fun.getEmail());
                ps.setString(4, fun.getCpf());
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
    
    public boolean delete(Employee fun){
        if(db.open()){
            sql = "DELETE FROM tb_funcionarios WHERE fun_cpf = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, fun.getCpf());
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
    
    public Employee findByCpf(String cpf){
        if(db.open()){
            
            sql = "SELECT * FROM tb_funcionarios WHERE fun_cpf = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, cpf);
                rs = ps.executeQuery();
                while(rs.next()){
                    Employee fun = new Employee();
                    fun.setNome(rs.getString("fun_nome"));
                    fun.setFone(rs.getString("fun_fone"));
                    fun.setCpf(rs.getString("fun_cpf"));
                    fun.setEmail(rs.getString("fun_email"));
                    rs.close();
                    ps.close();
                    db.close();
                    return fun;
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
    
    public Employee selectById(int id){
        if(db.open()){
            sql = "SELECT * FROM tb_funcionarios WHERE fun_id = ?";
            try{
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while(rs.next()){
                    Employee fun = new Employee();
                    fun.setId(rs.getInt("fun_id"));
                    fun.setNome(rs.getString("fun_nome"));
                    fun.setFone(rs.getString("fun_fone"));
                    fun.setCpf(rs.getString("fun_cpf"));
                    fun.setEmail(rs.getString("fun_email"));
                    rs.close();
                    ps.close();
                    db.close();
                    return fun;
                }
                rs.close();
                ps.close();
            }catch(SQLException error){
                
            }
        }
        db.close();
        return null;
    }
    
    
    public List<Employee> selectAll() {
        if (db.open()) {
            List<Employee> funs = new ArrayList();
            sql = "SELECT * FROM tb_funcionarios";
            try {
                ps = db.connection.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Employee fun = new Employee();
                    fun.setId(rs.getInt(1));
                    fun.setNome(rs.getString(2));
                    fun.setFone(rs.getString(3));
                    fun.setCpf(rs.getString(4));
                    fun.setEmail(rs.getString(5));
                    funs.add(fun);
                }
                rs.close();
                ps.close();
                db.close();
                return funs;
            } catch (SQLException error) {
                System.out.println("ERRO: " + error.toString());
            }
        }
        db.close();
        return null;
    }
    
    public List<Employee> selectFilter(String filter) {
        if (db.open()) {
            List<Employee> funs = new ArrayList();
            String filtro = "%" + filter + "%";
            sql = "SELECT * FROM tb_funcionarios WHERE fun_nome LIKE ? OR fun_fone LIKE ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, filtro);
                ps.setString(2, filtro);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Employee fun = new Employee();
                    fun.setId(rs.getInt(1));
                    fun.setNome(rs.getString(2));
                    fun.setFone(rs.getString(3));
                    fun.setCpf(rs.getString(4));
                    fun.setEmail(rs.getString(5));
                    funs.add(fun);
                }
                rs.close();
                ps.close();
                db.close();
                return funs;
            } catch (SQLException error) {
                System.out.println("ERRO: " + error.toString());
            }
        }
        db.close();
        return null;
    }
    
}
