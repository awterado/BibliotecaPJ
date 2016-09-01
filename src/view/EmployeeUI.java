package view;

import controller.EmployeeCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmployeeUI extends JPanel {
    
    private JLabel lbNome, lbFone, lbCpf, lbEmail;
    private JTextField tfNome, tfFone, tfCpf, tfEmial;
    private JButton btCadastrar;
    
    public EmployeeUI() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);
        lbNome = new JLabel("Nome:");
        lbFone = new JLabel("Fone:");
        lbCpf = new JLabel("CPF:");
        lbEmail = new JLabel("Email:");
        tfNome = new JTextField();
        tfFone = new JTextField();
        tfCpf = new JTextField();
        tfEmial = new JTextField();
        btCadastrar = new JButton("Cadastrar");
        
        lbNome.setBounds(30, 30, 80, 25);
        tfNome.setBounds(100, 30, 200, 25);
        lbFone.setBounds(30, 75, 80, 25);
        tfFone.setBounds(100, 75, 200, 25);
        lbCpf.setBounds(30, 120, 80, 25);
        tfCpf.setBounds(100, 120, 200, 25);
        lbEmail.setBounds(30, 165, 80, 25);
        tfEmial.setBounds(100, 165, 200, 25);
        btCadastrar.setBounds(30, 210, 100, 25);
//        .setBounds(100, 210, 200, 25);
//        .setBounds(30, 255, 100, 25);
        
        add(lbNome);
        add(tfNome);
        add(lbFone);
        add(tfFone);
        add(lbCpf);
        add(tfCpf);
        add(lbEmail);
        add(tfEmial);
        add(btCadastrar);
        
    }

    private void setEvents() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeCTRL c = new EmployeeCTRL();
                //DEVE SEGUIR A ORDEM DO CTRL
                if (c.adcionar(tfNome.getText(),tfFone.getText(), tfCpf.getText(), tfEmial.getText())) {
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!");
                    JOptionPane.showMessageDialog(null, tfFone.getText().length());
                }
                
            }
        });
    }
    
}
