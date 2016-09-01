package view;

import controller.BookCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Book;

public class BookUI extends JPanel {
    
    private JLabel lbTitulo, lbEditora, lbAutor, lbAno, lbDescricao, lbId;
    private JTextField tfTitulo, tfEditora, tfAutor, tfAno, tfId;
    private JTextArea taDescricao; 
    private JScrollPane scrollPane;
    private JButton btCadastrar;    
    public BookUI() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);
        lbId = new JLabel("ID do lívro:");
        lbTitulo = new JLabel("Título:");
        lbEditora = new JLabel("Editora:");
        lbAutor = new JLabel("Autor:");
        lbAno = new JLabel("Ano:");
        lbDescricao = new JLabel("Descrição:");
        tfId = new JTextField();
        tfTitulo = new JTextField();
        tfEditora = new JTextField();
        tfAutor = new JTextField();
        tfAno = new JTextField();
        taDescricao = new JTextArea(5,20);
        btCadastrar = new JButton("Cadastrar");
        scrollPane = new JScrollPane(taDescricao);
        
        lbId.setBounds(330, 30, 80, 25);
        tfId.setBounds(400, 30, 80, 25);
        lbTitulo.setBounds(30, 30, 80, 25);
        tfTitulo.setBounds(100, 30, 200, 25);
        lbEditora.setBounds(30, 75, 80, 25);
        tfEditora.setBounds(100, 75, 200, 25);
        lbAutor.setBounds(30, 120, 80, 25);
        tfAutor.setBounds(100, 120, 200, 25);
        lbAno.setBounds(30, 165, 80, 25);
        tfAno.setBounds(100, 165, 200, 25);
        lbDescricao.setBounds(30, 210, 80, 25);
        scrollPane.setBounds(100, 210, 300, 150);
        btCadastrar.setBounds(100, 390, 100, 25);
//        .setBounds(100, 210, 200, 25);
//        .setBounds(30, 255, 100, 25);
        

        add(lbId);
        add(tfId);
        add(lbTitulo);
        add(tfTitulo);
        add(lbEditora);
        add(tfEditora);
        add(lbAutor);
        add(tfAutor);
        add(lbAno);
        add(tfAno);
        add(lbDescricao);
        add(btCadastrar);
        add(scrollPane);
        
    }

    private void setEvents() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookCTRL c = new BookCTRL();
                if (c.adcionar(Integer.parseInt(tfId.getText()), tfTitulo.getText(), tfEditora.getText(),tfAutor.getText(), tfAno.getText(), taDescricao.getText())) {
                    Book b = new Book();
                    JOptionPane.showMessageDialog(null, "Lívro cadastrado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lívro não cadastrado!");
                }
                
            }
        });
    }
    
}
