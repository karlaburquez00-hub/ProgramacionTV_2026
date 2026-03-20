package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paaneles extends JFrame {

    public Paaneles() {
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Cambio dinámico de paneles");

        // Crear barra de menú
        JMenuBar barra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        JMenu ayuda = new JMenu("Ayuda");
        JMenu cuenta = new JMenu("Cuenta");

        // Opciones dentro de "Cuenta"
        JMenuItem acceder = new JMenuItem("Acceder");
        JMenuItem registrar = new JMenuItem("Registrar");

        // Acciones de menú que cambian paneles
        acceder.addActionListener(e -> router("login"));
        registrar.addActionListener(e -> router("registro"));

        cuenta.add(acceder);
        cuenta.add(registrar);

        barra.add(archivo);
        barra.add(ayuda);
        barra.add(cuenta);

        this.setJMenuBar(barra);

        // Iniciar en login
        router("login");

        this.setVisible(true);
    }

    // Método router: controla qué panel mostrar
    public void router(String target) {
        this.getContentPane().removeAll();

        if (target.equals("login"))
            this.login();

        if (target.equals("registro"))
            this.registro();

        this.repaint();
        this.revalidate();
    }

    // Panel de Login (fondo blanco)
    public void login() {
        JPanel login_container = new JPanel();
        login_container.setBounds(250, 100, 400, 400);
        login_container.setBackground(Color.WHITE);
        login_container.setLayout(null);

        JLabel tag_title = new JLabel("Bienvenido");
        tag_title.setBounds(125, 20, 150, 30);
        tag_title.setFont(new Font("Arial", Font.PLAIN, 22));
        tag_title.setHorizontalAlignment(JLabel.CENTER);
        login_container.add(tag_title);

        JLabel tag_email = new JLabel("Correo electrónico");
        tag_email.setBounds(61, 80, 150, 30);
        login_container.add(tag_email);

        JTextField email_input = new JTextField();
        email_input.setBounds(60, 110, 280, 40);
        login_container.add(email_input);

        JLabel tag_password = new JLabel("Contraseña");
        tag_password.setBounds(61, 160, 150, 30);
        login_container.add(tag_password);

        JPasswordField password = new JPasswordField();
        password.setBounds(60, 190, 280, 40);
        login_container.add(password);

        JButton access_btn = new JButton("Acceder");
        access_btn.setBounds(100, 250, 200, 40);
        login_container.add(access_btn);

        JButton goToRegister = new JButton("Ir a registro");
        goToRegister.setBounds(100, 300, 200, 30);
        goToRegister.addActionListener(e -> router("registro"));
        login_container.add(goToRegister);

        this.add(login_container);
    }

    // Panel de Registro (fondo anaranjado)
    public void registro() {
        JPanel rgs_container = new JPanel();
        rgs_container.setBounds(250, 100, 400, 400);
        rgs_container.setBackground(Color.ORANGE);
        rgs_container.setLayout(null);

        JLabel tag_title = new JLabel("Registrarse");
        tag_title.setBounds(125, 20, 150, 30);
        tag_title.setFont(new Font("Arial", Font.PLAIN, 22));
        tag_title.setHorizontalAlignment(JLabel.CENTER);
        rgs_container.add(tag_title);

        JLabel tag_email = new JLabel("Ingrese su email:");
        tag_email.setBounds(61, 80, 150, 30);
        rgs_container.add(tag_email);

        JTextField email_input = new JTextField();
        email_input.setBounds(60, 110, 280, 40);
        rgs_container.add(email_input);

        JLabel tag_password = new JLabel("Ingrese su contraseña:");
        tag_password.setBounds(61, 160, 180, 30);
        rgs_container.add(tag_password);

        JPasswordField password = new JPasswordField();
        password.setBounds(60, 190, 280, 40);
        rgs_container.add(password);

        JButton register_btn = new JButton("Registrar");
        register_btn.setBounds(100, 250, 200, 40);
        rgs_container.add(register_btn);

        JButton goToLogin = new JButton("Ir a login");
        goToLogin.setBounds(100, 300, 200, 30);
        goToLogin.addActionListener(e -> router("login"));
        rgs_container.add(goToLogin);

        this.add(rgs_container);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Paaneles().setVisible(true));
    }
}