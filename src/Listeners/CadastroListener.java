package Listeners;

import Models.DAOProdutos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroListener implements ActionListener {

    private JTextField input_nome;
    private JTextField input_marca;
    private JTextField input_modelo;
    private JTextField input_preco;
    private JDialog tela;

    public CadastroListener(JTextField input_nome, JTextField input_marca, JTextField input_modelo, JTextField input_preco) {
        this.input_nome = input_nome;
        this.input_marca = input_marca;
        this.input_modelo = input_modelo;
        this.input_preco = input_preco;
        this.tela = null;
    }

    public CadastroListener(JDialog tela, JTextField input_nome, JTextField input_marca, JTextField input_modelo, JTextField input_preco) {
        this.input_nome = input_nome;
        this.input_marca = input_marca;
        this.input_modelo = input_modelo;
        this.input_preco = input_preco;
        this.tela = tela;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        DAOProdutos dao = DAOProdutos.getInstance();
        dao.save(input_nome.getText(), input_marca.getText(), input_modelo.getText(), input_preco.getText());
        System.out.println("Salvo com sucesso!");
        this.tela.dispose();
    }
}
