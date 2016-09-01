package view;

import controller.LocCTRL;
import controller.UserCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.User;

public class LocUI extends JPanel {
    
    private JLabel lbUserCpf, lbFunId, lbLivroId, lbLocId, lbUserId;
    private JTextField tfUserCpf, tfFunId, tfLivrosId, tfLocId, tfUserId;
    private JButton btCadastrar, btVerificar;    
    public LocUI() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);
        lbUserCpf = new JLabel("CPF do Usuário:");
        lbFunId = new JLabel("ID do funcionario:");
        lbLivroId = new JLabel("ID do Livro:");
        lbLocId = new JLabel("ID da locação:");
        lbUserId = new JLabel("ID do usuário:");
        tfUserCpf = new JTextField();
        tfFunId = new JTextField();
        tfLivrosId = new JTextField();
        tfLocId = new JTextField();
        tfUserId = new JTextField();
        tfUserId.setEnabled(false);
        btCadastrar = new JButton("Cadastrar");
        btVerificar = new JButton("Verificar");
        
        lbUserId.setBounds(30, 30, 120, 25);
        tfUserId.setBounds(150, 30, 80, 25);
        lbUserCpf.setBounds(400, 30, 120, 25);
        tfUserCpf.setBounds(500, 30, 120, 25);
        lbLivroId.setBounds(30, 75, 120, 25);
        tfLivrosId.setBounds(150, 75, 200, 25);
        lbLocId.setBounds(30, 120, 120, 25);
        tfLocId.setBounds(150, 120, 200, 25);
        lbFunId.setBounds(30, 165, 120, 25);
        tfFunId.setBounds(150, 165, 200, 25);
        btCadastrar.setBounds(30, 210, 100, 25);
        btVerificar.setBounds(150, 210, 100, 25);
//        .setBounds(100, 210, 200, 25);
//        .setBounds(30, 255, 100, 25);
        
        add(lbUserCpf);
        add(tfUserCpf);
        add(lbLivroId);
        add(tfLivrosId);
        add(lbLocId);
        add(tfLocId);
        add(lbFunId);
        add(tfFunId);
        add(lbUserId);
        add(tfUserId);
        add(btCadastrar);
        add(btVerificar);
        
        
        tfLocId.setText(Integer.toString(aleatorio()));
        
    }
    
    private int aleatorio(){
        int i = (int) (Math.random() * 10000);
        return i;
    }

    private void setEvents() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocCTRL c = new LocCTRL();
                if (c.add(Integer.parseInt(tfLocId.getText()), Integer.parseInt(tfUserId.getText()), Integer.parseInt(tfFunId.getText()))) {
                    System.out.println("merda");
                    c.inserirBook(Integer.parseInt(tfLocId.getText()), Integer.parseInt(tfLivrosId.getText()));
                    JOptionPane.showMessageDialog(null, "Locação feita com susseso!");
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
                
                
                
                tfUserCpf.setText("");
                tfUserId.setText("");
                tfLocId.setText("");
                tfLocId.setText(Integer.toString(aleatorio()));
                tfFunId.setText("");
                tfLivrosId.setText("");
                
            }
        });
        
        btVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCTRL c = new UserCTRL();
                User u = new User();
                u = c.acharPotCpf((tfUserCpf.getText()));
                if(u == null){
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado");
                }else{
                    tfUserId.setText(Integer.toString(u.getId()));
                }
            }
        });
    }
    
}
