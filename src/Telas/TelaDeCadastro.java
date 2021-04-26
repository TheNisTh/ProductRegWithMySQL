package Telas;

import Listeners.CadastroListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDeCadastro extends JDialog {

    public TelaDeCadastro(){
        this.initializer();
        this.setModal(true);
        this.setVisible(true);
    }

    private void initializer(){
        JPanel panel = new JPanel();

        //layout para grid de 5 linhas e duas colunas conforme feito no mockup.
        GridLayout grid = new GridLayout(5,2,5,5);
        panel.setLayout(grid);


        JLabel label_nome = new JLabel("Nome: ");
        JLabel label_marca = new JLabel("Marca: ");
        JLabel label_modelo = new JLabel("Modelo: ");
        JLabel label_preco = new JLabel("Preço: ");

        JTextField input_marca = new JTextField();
        JTextField input_nome = new JTextField();
        JTextField input_modelo = new JTextField();
        JTextField input_preco = new JTextField();

        JButton button_cadastrar = new JButton("Cadastrar");
        JButton button_cancelar = new JButton("Cancelar");

        //Eventos
        button_cadastrar.addActionListener(new CadastroListener(this,input_nome, input_marca, input_modelo, input_preco));
        button_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });

        panel.add(label_nome);
        panel.add(input_nome);
        panel.add(label_marca);
        panel.add(input_marca);
        panel.add(label_modelo);
        panel.add(input_modelo);
        panel.add(label_preco);
        panel.add(input_preco);
        panel.add(button_cadastrar);
        panel.add(button_cancelar);


        this.setBounds(0,0,400,200);
        this.add(panel);
        this.setPreferredSize(new Dimension(400,200));

        this.setLocationRelativeTo(null);

        this.setTitle("Cadastro de Produtos");
        this.pack();

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
