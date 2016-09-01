package view;

import controller.EmployeeCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Employee;

public class EmployeeDel extends JPanel {
    
    private JLabel lbNome, lbFone, lbEmail, lbCpf;
    private JTextField tfNome, tfFone, tfEmial, tfCpf;
    private JButton btDel, btVerificar;
    
    public EmployeeDel() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);
        lbNome = new JLabel("Nome:");
        lbCpf = new JLabel("CPF:");
        lbFone = new JLabel("Fone:");
        lbEmail = new JLabel("Email:");
        tfNome = new JTextField();
        tfNome.setEnabled(false);
        tfCpf = new JTextField();
        tfFone = new JTextField();
        tfFone.setEnabled(false);
        tfEmial = new JTextField();
        tfEmial.setEnabled(false);
        btDel = new JButton("Excluir");
        btVerificar = new JButton("Verificar");
        
        lbNome.setBounds(30, 30, 80, 25);
        tfNome.setBounds(100, 30, 200, 25);
        lbCpf.setBounds(360, 30, 84, 25);
        tfCpf.setBounds(440, 30, 120, 25);
        lbFone.setBounds(30, 75, 80, 25);
        tfFone.setBounds(100, 75, 200, 25);
        lbEmail.setBounds(30, 120, 80, 25);
        tfEmial.setBounds(100, 120, 200, 25);
        btDel.setBounds(30, 165, 100, 25);
        btVerificar.setBounds(135, 165, 100, 25);
        
        add(lbNome);
        add(tfNome);
        add(lbCpf);
        add(tfCpf);
        add(lbFone);
        add(tfFone);
        add(lbEmail);
        add(tfEmial);
        add(btDel);
        add(btVerificar);
        
    }

    private void setEvents() {
        btVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeCTRL c = new EmployeeCTRL();
                Employee f = new Employee();
                f = c.acharPotCpf((tfCpf.getText()));
                if(f == null){
                    JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
                }else{
                    tfNome.setText(f.getNome());
                    tfFone.setText(f.getFone());
                    tfEmial.setText(f.getEmail());
                    
                }
                
                
            }
        });
        
        btDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeCTRL c = new EmployeeCTRL();
                if (c.remover(tfCpf.getText())) {
                    JOptionPane.showMessageDialog(null, "Funcionário excluido!");
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário não excluido!");
                }
                
            }
        });
    }
    
}
