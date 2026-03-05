package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
					
public class Ventana extends JFrame {

	public Ventana() {

        // configuracion Ventana
        setTitle("Login");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // panel principal
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 450);
        panel.setBackground(new Color(30, 30, 60)); // azul oscuro
        panel.setLayout(null);
        add(panel);

        // titulo
        JLabel titulo = new JLabel("INICIAR SESIÓN");
        titulo.setBounds(90, 30, 220, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 22)); //tipo de letra
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

        // usuario(interfaz)
        JLabel lblUsuario = new JLabel("Nombre de Usuario:");
        lblUsuario.setBounds(50, 100, 200, 25);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14)); //tipo de letra
        panel.add(lblUsuario);

        // usuario
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(50, 130, 280, 30);
        panel.add(txtUsuario);

        //Boton contraseña
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 180, 200, 25);
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14)); //tipo de letra
        panel.add(lblPassword);

        // Contraseña
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(50, 210, 280, 30);
        panel.add(txtPassword);

        // boton "RECORDARME"
        JCheckBox recordar = new JCheckBox("Recordarme");
        recordar.setBounds(50, 260, 150, 25);
        recordar.setForeground(Color.WHITE);
        recordar.setBackground(new Color(30, 30, 60));
        panel.add(recordar);

        // boton acceder
        JButton btnAcceder = new JButton("ACCEDER");
        btnAcceder.setBounds(110, 310, 160, 40);
        btnAcceder.setBackground(new Color(28, 118, 210)); // azul
        btnAcceder.setForeground(Color.WHITE);
        btnAcceder.setFont(new Font("Arial", Font.BOLD, 16)); //tipo de letra
        btnAcceder.setFocusPainted(false);
        panel.add(btnAcceder);

        // accion del boton 
        btnAcceder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String usuario = txtUsuario.getText();
                String password = new String(txtPassword.getPassword());

                if (usuario.equals("Karla") && password.equals("12345")) {   //usuario y contraseña predeterminada
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });
        
        JPanel rgs_contaniner = new JPanel();
        rgs_contaniner.setBounds(400, 0, 400, 450);
        rgs_contaniner.setBackground(new Color(25, 42, 86));
        rgs_contaniner.setLayout(null);
        this.add(rgs_contaniner);

        JLabel tituloRegistro = new JLabel("REGISTRO");
        tituloRegistro.setBounds(90, 15, 220, 45);
        tituloRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        tituloRegistro.setOpaque(true);
        tituloRegistro.setBackground(new Color(30, 30, 30));
        tituloRegistro.setForeground(Color.WHITE);
        tituloRegistro.setFont(new Font("Arial", Font.BOLD, 24));
        rgs_contaniner.add(tituloRegistro);

        JLabel lblNombreReg = new JLabel("NOMBRE DE USUARIO:");
        lblNombreReg.setBounds(50, 75, 300, 28);
        lblNombreReg.setOpaque(true);
        lblNombreReg.setBackground(new Color(255, 200, 0));
        lblNombreReg.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreReg.setFont(new Font("Arial", Font.BOLD, 13));
        rgs_contaniner.add(lblNombreReg);

        JTextField txtNombreReg = new JTextField();
        txtNombreReg.setBounds(50, 108, 300, 28);
        txtNombreReg.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        rgs_contaniner.add(txtNombreReg);

        JLabel bio_tag = new JLabel("BIO");
        bio_tag.setBounds(50, 145, 300, 25);
        bio_tag.setHorizontalAlignment(SwingConstants.CENTER);
        bio_tag.setFont(new Font("Arial", Font.BOLD, 14));
        bio_tag.setForeground(Color.WHITE);
        rgs_contaniner.add(bio_tag);

        JTextArea bio_text = new JTextArea();
        bio_text.setBounds(50, 175, 300, 65);
        bio_text.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        rgs_contaniner.add(bio_text);

        JLabel preferencias = new JLabel("Preferencias");
        preferencias.setBounds(50, 250, 300, 25);
        preferencias.setHorizontalAlignment(SwingConstants.CENTER);
        preferencias.setFont(new Font("Arial", Font.BOLD, 14));
        preferencias.setForeground(Color.WHITE);
        rgs_contaniner.add(preferencias);

        JCheckBox opt_sweet = new JCheckBox("Dulces");
        opt_sweet.setBounds(50, 280, 90, 25);
        opt_sweet.setBackground(new Color(60, 180, 170));
        rgs_contaniner.add(opt_sweet);

        JCheckBox opt_salty = new JCheckBox("Salado");
        opt_salty.setBounds(155, 280, 90, 25);
        opt_salty.setBackground(new Color(60, 180, 170));
        rgs_contaniner.add(opt_salty);

        JCheckBox opt_healthy = new JCheckBox("Saludable");
        opt_healthy.setBounds(260, 280, 100, 25);
        opt_healthy.setBackground(new Color(60, 180, 170));
        rgs_contaniner.add(opt_healthy);

        JLabel terminosLabel = new JLabel("TÉRMINOS");
        terminosLabel.setBounds(50, 310, 300, 25);
        terminosLabel.setOpaque(true);
        terminosLabel.setBackground(new Color(255, 200, 0));
        terminosLabel.setHorizontalAlignment(SwingConstants.CENTER);
        terminosLabel.setFont(new Font("Arial", Font.BOLD, 14));
        rgs_contaniner.add(terminosLabel);

        JRadioButton accept_terms = new JRadioButton("Acepto los términos");
        accept_terms.setBounds(50, 340, 160, 25);
        accept_terms.setBackground(new Color(60, 180, 170));
        rgs_contaniner.add(accept_terms);

        JRadioButton reject_terms = new JRadioButton("No acepto los términos");
        reject_terms.setBounds(210, 340, 180, 25);
        reject_terms.setBackground(new Color(60, 180, 170));
        rgs_contaniner.add(reject_terms);

        ButtonGroup terms = new ButtonGroup();
        terms.add(accept_terms);
        terms.add(reject_terms);

        String[] colonias = {"Camino Real", "Arcoiris", "8 de Octubre"};
        JComboBox colonias_combos = new JComboBox(colonias);
        colonias_combos.setBounds(50, 370, 300, 28);
        colonias_combos.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        rgs_contaniner.add(colonias_combos);

        JButton register_btn = new JButton("Crear cuenta");
        register_btn.setBounds(50, 405, 300, 35);
        register_btn.setFont(new Font("Arial", Font.BOLD, 16));
        register_btn.setBackground(Color.WHITE);
        register_btn.setFocusPainted(false);
        register_btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        rgs_contaniner.add(register_btn);
        
        
        setVisible(true);
        
        
        this.repaint();
    }
	
	public static void main(String[] args) {
        new Ventana();
      }


}
