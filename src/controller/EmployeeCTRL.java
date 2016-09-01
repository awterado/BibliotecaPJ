package controller;

import dao.EmployeeDAO;
import java.util.List;
import model.Employee;

public class EmployeeCTRL {
    
    private EmployeeDAO dao;
    
    public EmployeeCTRL(){
        dao = new EmployeeDAO();
    }
    
    public boolean adcionar(String nome, String fone, String cpf, String email){
        Employee fun = new Employee();
        fun.setNome(nome.toUpperCase());
        fun.setFone(fone);
        fun.setCpf(cpf);
        fun.setEmail(email);
        return dao.insert(fun);
    }
    
    public boolean atualizar( String nome, String fone, String email, String cpf ){
        Employee fun = new Employee();
        fun.setNome(nome.toUpperCase());
        fun.setFone(fone);
        fun.setEmail(email);
        fun.setCpf(cpf);
        return dao.update(fun);
    }
    
    public boolean remover(String cpf){
        Employee fun = new Employee();
        fun.setCpf(cpf);
        return dao.delete(fun);
    }
    
    public Employee acharPotCpf(String cpf){
        Employee fun = new Employee();
        fun.setCpf(cpf);
        fun = dao.findByCpf(cpf);
        if(fun == null){
            return null;
        }else{
            return fun;
        }
    }
    
    public Employee acharPorId(int id){
        Employee fun = new Employee();
        fun.setId(id);
        fun = dao.selectById(id);
        if(fun == null){
            return null;
        }else{
            return fun;
        }
    }
    
    public List<Employee> listar(){
        return dao.selectAll();
    }
    
    public List<Employee> listarPorNome(String filter){
        if(filter == null){
            return null;
        }else{
            return dao.selectFilter(filter);
        }
    }
    
}
