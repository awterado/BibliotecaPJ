package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Principal extends JFrame {
    
    private static Principal frame;
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnUsuarios, mnLivros, mnFuns, mnLocacao;
    private JMenuItem miCadastrarU, miEditarU, miExcluirU, miSair;
    private JMenuItem miCadastrarL, miEditarL, miExcluirL;
    private JMenuItem miCadastrarF, miEditarF, miExcluirF;
    private JMenuItem miLocacao;
    
    
    public Principal() {
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnUsuarios = new JMenu("Usuários");
        mnLivros = new JMenu("Livros");
        mnFuns = new JMenu("Funcionários");
        mnLocacao = new JMenu("Locação");
        miCadastrarU = new JMenuItem("Cadastrar Usuário");
        miCadastrarF = new JMenuItem("Cadastrar Funcionários");
        miCadastrarL = new JMenuItem("Cadastrar Livros");
        miEditarU = new JMenuItem("Editar Usuário");
        miEditarF = new JMenuItem("Editar Funcionários");
        miEditarL = new JMenuItem("Editar Livros");
        miExcluirU = new JMenuItem("Excluir Usuário");
        miExcluirF = new JMenuItem("Excluir Funcionários");
        miExcluirL = new JMenuItem("Excluir Livros");
        miLocacao = new JMenuItem("Fazer locação");
        miSair = new JMenuItem("Sair");
        
        
        mnUsuarios.add(miCadastrarU);
        mnUsuarios.add(miEditarU);
        mnUsuarios.add(miExcluirU);
        mnLivros.add(miCadastrarL);
        mnLivros.add(miEditarL);
        mnLivros.add(miExcluirL);
        mnFuns.add(miCadastrarF);
        mnFuns.add(miEditarF);
        mnFuns.add(miExcluirF);
        mnLocacao.add(miLocacao);
        mnArquivo.add(miSair);
        
        mnBarra.add(mnLocacao);
        mnBarra.add(mnUsuarios);
        mnBarra.add(mnLivros);
        mnBarra.add(mnFuns);
        mnBarra.add(mnArquivo);
        setJMenuBar(mnBarra);
    }
    
    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        miCadastrarU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserUI cadastrar = new UserUI();
                contentPane.removeAll();
                contentPane.add(cadastrar);
                contentPane.validate();
            }
        });
        
        miEditarU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserEdUI editar = new UserEdUI();
                contentPane.removeAll();
                contentPane.add(editar);
                contentPane.validate();
            }
        });
        
        miExcluirU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDel excluir = new UserDel();
                contentPane.removeAll();
                contentPane.add(excluir);
                contentPane.validate();
            }
        });
        
        miCadastrarF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeUI cadastrar = new EmployeeUI();
                contentPane.removeAll();
                contentPane.add(cadastrar);
                contentPane.validate();
            }
        });
        
        miEditarF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeEdit editar = new EmployeeEdit();
                contentPane.removeAll();
                contentPane.add(editar);
                contentPane.validate();
            }
        });
        
        miExcluirF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeDel excluir = new EmployeeDel();
                contentPane.removeAll();
                contentPane.add(excluir);
                contentPane.validate();
            }
        });
        
        miCadastrarL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookUI cadastrar = new BookUI();
                contentPane.removeAll();
                contentPane.add(cadastrar);
                contentPane.validate();
            }
        });
        
        miEditarL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookEdit editar = new BookEdit();
                contentPane.removeAll();
                contentPane.add(editar);
                contentPane.validate();
            }
        });
        
        miExcluirL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDel excluir = new BookDel();
                contentPane.removeAll();
                contentPane.add(excluir);
                contentPane.validate();
            }
        });
        
        miLocacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocUI alugar = new LocUI();
                contentPane.removeAll();
                contentPane.add(alugar);
                contentPane.validate();
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new Principal();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (tela.width - frame.getSize().width) / 2;
                int y = (tela.height - frame.getSize().height) / 2;
                frame.setLocation(x, y);
                frame.setVisible(true);
            }
        });
    }
    
}
