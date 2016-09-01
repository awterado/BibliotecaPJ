package controller;

import dao.UserDAO;
import java.util.List;
import model.User;

public class UserCTRL {
    
    private UserDAO dao;
    
    public UserCTRL(){
        dao = new UserDAO();
    }
    
    public boolean adcionar(String nome, String fone, String emial, String cpf){
        User us = new User();
        us.setNome(nome.toUpperCase());
        us.setFone(fone);
        us.setEmial(emial);
        us.setCpf(cpf);
        return dao.insert(us);
    }
    
    public boolean atualizar(String nome, String fone, String emial, String cpf){
        User us = new User();
        us.setNome(nome.toUpperCase());
        us.setFone(fone);
        us.setEmial(emial);
        us.setCpf(cpf);
        return dao.update(us);
    }
    
    public boolean remover(String cpf){
        User us = new User();
        us.setCpf(cpf);
        return dao.delete(us);
    }
    
    public User acharPotCpf(String cpf){
        User us = new User();
        us.setCpf(cpf);
        us = dao.findByCpf(cpf);
        if(us == null){
            return null;
        }else{
            return us;
        }
    }
    
    public User acharPorId(int id){
        User us = new User();
        us.setId(id);
        us = dao.selectById(id);
        if(us == null){
            return null;
        }else{
            return us;
        }
    }
    
    public List<User> listar(){
        return dao.selectAll();
    }
    
    public List<User> listarPorNome(String filter){
        if(filter == null){
            return null;
        }else{
            return dao.selectFilter(filter);
        }
    }
}
