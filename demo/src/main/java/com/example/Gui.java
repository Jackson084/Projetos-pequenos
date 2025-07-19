package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gui implements ActionListener{
    JTextField text;
    JTextField text2;
    public  Gui(){
        // Criação da janea
        JFrame janela = new JFrame("Cadastro de Cliente");
        janela.setSize(900, 600);
        janela.setTitle("Cadastro de Cliente");
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setLayout(null);

        // Criação dos campos de botão
        JButton botao = new JButton("Cadastrar");
        botao.setBounds(350, 300, 200, 50);
        botao.setFont(new Font("arial", Font.ROMAN_BASELINE, 20));
        botao.setForeground(new Color(250, 250, 250));
        botao.setBackground(new Color(8, 8, 8));
        janela.add(botao);
        botao.addActionListener(this);

        // Criação dos campos de Label
        JLabel  tela = new JLabel("num1");
        tela.setBounds(350, 100, 200, 50);
        tela.setFont(new Font("arial", Font.ROMAN_BASELINE, 20));
        janela.add(tela);

         JLabel  tela2 = new JLabel("num2");
        tela2.setBounds(350, 195, 200, 50);
        tela2.setFont(new Font("arial", Font.ROMAN_BASELINE, 20));
        janela.add(tela2);
        // Criação dos campos de texto
        text = new JTextField();
        text.setBounds(350, 150, 200, 50);
        text.setFont(new Font("arial", Font.ROMAN_BASELINE, 20));
        text.requestFocus();
        janela.add(text);

        text2 = new JTextField();
        text2.setBounds(350, 230, 200, 50);
        text2.setFont(new Font("arial", Font.ROMAN_BASELINE, 20));
        text2.requestFocus();
        janela.add(text2);

        janela.setVisible(true);

//JOptionPane.showMessageDialog(null, "Você clicou no botão!");

    }   
    @Override
    public void actionPerformed(ActionEvent e) {
        Integer num1 = Integer.parseInt(text.getText());
        Integer num2 = Integer.parseInt(text2.getText());
        int resultado = num1 + num2;
        JOptionPane.showMessageDialog(null, "A soma é: " + resultado);
       
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}


// area de codigos jogados 
/*
 * JFrame janela = new JFrame("Cadastro de Cliente");
        janela.setVisible(true);
        janela.setSize(900, 600);
        janela.setTitle("Cadastro de Cliente");
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setLayout(null);

        JButton botao = new JButton("Cadastrar");
        botao.setBounds(350, 250, 200, 50);
        botao.setFont(new Font("arial", Font.ROMAN_BASELINE, 20));
        botao.setForeground(new Color(250, 250, 250));
        botao.setBackground(new Color(8, 8, 8));
        janela.add(botao);
        botao.addActionListener(this);

        JLabel  tela = new JLabel("janela1");
        tela.setBounds(350, 100, 200, 50);
        tela.setFont(new Font("arial", Font.ROMAN_BASELINE, 20));
        janela.add(tela);
 */