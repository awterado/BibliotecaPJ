package view;

import controller.UserCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.User;

public class UserEdUI extends JPanel {
    
    private JLabel lbNome, lbFone, lbEmail, lbCpf;
    private JTextField tfNome, tfFone, tfEmial, tfCpf;
    private JButton btEditar, btVerificar;
    
    public UserEdUI() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);
        lbNome = new JLabel("Nome:");
        lbCpf = new JLabel("CPF");
        lbFone = new JLabel("Fone:");
        lbEmail = new JLabel("Email:");
        tfNome = new JTextField();
        tfNome.setEnabled(false);
        tfCpf = new JTextField();
        tfFone = new JTextField();
        tfFone.setEnabled(false);
        tfEmial = new JTextField();
        tfEmial.setEnabled(false);
        btEditar = new JButton("Editar");
        btVerificar = new JButton("Verificar");
        
        lbNome.setBounds(30, 30, 80, 25);
        tfNome.setBounds(100, 30, 200, 25);
        lbCpf.setBounds(360, 30, 84, 25);
        tfCpf.setBounds(440, 30, 120, 25);
        lbFone.setBounds(30, 75, 80, 25);
        tfFone.setBounds(100, 75, 200, 25);
        lbEmail.setBounds(30, 120, 80, 25);
        tfEmial.setBounds(100, 120, 200, 25);
        btEditar.setBounds(30, 165, 100, 25);
        btVerificar.setBounds(135, 165, 100, 25);
        
        add(lbNome);
        add(tfNome);
        add(lbCpf);
        add(tfCpf);
        add(lbFone);
        add(tfFone);
        add(lbEmail);
        add(tfEmial);
        add(btEditar);
        add(btVerificar);
        
    }

    private void setEvents() {
        btVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCTRL c = new UserCTRL();
                User u = new User();
                u = c.acharPotCpf((tfCpf.getText()));
                if(u == null){
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado");
                }else{
                    tfNome.setEnabled(true);
                    tfNome.setText(u.getNome());
                    tfFone.setEnabled(true);
                    tfFone.setText(u.getFone());
                    tfEmial.setEnabled(true);
                    tfEmial.setText(u.getEmial());
                    
                }
                
                
            }
        });
        
        btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCTRL c = new UserCTRL();
                if (c.atualizar( tfNome.getText(), tfFone.getText(), tfEmial.getText(), tfCpf.getText())) {
                    JOptionPane.showMessageDialog(null, "Usuario editado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não editado!");
                }
                
            }
        });
    }
    
}
