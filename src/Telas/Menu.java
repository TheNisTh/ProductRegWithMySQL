package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.DAOProdutos;
import Models.Produto;

public class Menu extends JFrame {

private DAOProdutos dao;
    public Menu(){
        this.dao = DAOProdutos.getInstance();
        this.initializer();
        this.setExtendedState(NORMAL);
        
    }
    private void initializer(){
        JPanel panel = new JPanel();
        JPanel panel_botoes = new JPanel();

        //layouts
        panel.setLayout(new BorderLayout(5,5));

        this.setBounds(0,0, 600,300 );
        this.setPreferredSize(new Dimension(600,300));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Programa");
        JMenuItem menuCadastrar = new JMenuItem("Cadastrar");
        JMenuItem menuSair = new JMenuItem("Sair");

        menuCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDeCadastro c = new TelaDeCadastro();
            }
        });

        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        JButton btn_novo = new JButton("Novo");
        JButton btn_apagar = new JButton("Apagar");
        JButton btn_sair = new JButton("Sair");

        btn_novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDeCadastro c = new TelaDeCadastro();
            }
        });

        btn_sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        panel_botoes.setLayout(new GridLayout(6,1,5,5));
        panel_botoes.add(btn_novo);
        panel_botoes.add(btn_apagar);
        panel_botoes.add(btn_sair);

        JLabel label_title = new JLabel("Cadastro de Funcionários");
        panel.add(label_title,BorderLayout.PAGE_START);
        panel.add(panel_botoes,BorderLayout.LINE_END);
        
        JList<Produto> lista = new JList<>();
        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setModel(dao.list());
        lista.setVisibleRowCount(-1);
        
        JScrollPane scroll_lista = new JScrollPane(lista);
        panel.add(scroll_lista, BorderLayout.CENTER);
        
        menu.add(menuCadastrar);
        menu.addSeparator();
        menu.add(menuSair);

        menuBar.add(menu);

        this.setJMenuBar(menuBar);

        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setTitle("Cadastro de Funcionários");
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
