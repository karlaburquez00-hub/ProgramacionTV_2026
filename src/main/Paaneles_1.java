package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paaneles_1 extends JFrame {

    public Paaneles_1() {
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Cambio dinámico de paneles");

        // Crear barra de menú
        JMenuBar barra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        JMenu ayuda = new JMenu("Ayuda");
        JMenu cuenta = new JMenu("Cuenta");

        // Ítems del menú
        JMenuItem iniciarSesion = new JMenuItem("Acceder");
        JMenuItem registrarse = new JMenuItem("Registrar");

        // Eventos del menú
        iniciarSesion.addActionListener(e -> router("login"));
        registrarse.addActionListener(e -> router("registro"));

        cuenta.add(iniciarSesion);
        cuenta.add(registrarse);

        barra.add(archivo);
        barra.add(ayuda);
        barra.add(cuenta);

        this.setJMenuBar(barra);

        // Iniciar en login
        router("login");

        this.setVisible(true);
    }

    // Método router
    public void router(String target) {
        this.getContentPane().removeAll();

        if (target.equals("login"))
            this.login();

        if (target.equals("registro"))
            this.registro();

        this.repaint();
        this.revalidate();
    }

    // Panel Login
    public void login() {
        JPanel login_container = new JPanel();
        login_container.setBounds(250, 100, 400, 400);
        login_container.setBackground(Color.WHITE);
        login_container.setLayout(null);

        JLabel tag_title = new JLabel("Ingresa al panel administrador");
        tag_title.setBounds(50, 20, 300, 30);
        tag_title.setFont(new Font("Arial", Font.BOLD, 18));
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

        JCheckBox recordar = new JCheckBox("Recordar contraseña");
        recordar.setBounds(60, 230, 200, 30);
        login_container.add(recordar);

        JButton access_btn = new JButton("Acceder");
        access_btn.setBounds(100, 280, 200, 40);
        access_btn.setBackground(new Color(255,170,70)); // naranja institucional
        access_btn.setForeground(Color.WHITE);
        login_container.add(access_btn);

        JLabel noCuenta = new JLabel("¿Aún no tienes cuenta?");
        noCuenta.setBounds(100, 330, 200, 30);
        login_container.add(noCuenta);

        JButton crearBtn = new JButton("Crea una aquí");
        crearBtn.setBounds(120, 360, 160, 30);
        crearBtn.setBackground(new Color(30,60,140)); // azul institucional
        crearBtn.setForeground(Color.WHITE);
        login_container.add(crearBtn);

        this.add(login_container);
    }

    // Panel Registro
    public void registro() {
        JPanel rgs_container = new JPanel();
        rgs_container.setBounds(250, 100, 400, 400);
        rgs_container.setBackground(new Color(255,140,0)); // naranja fuerte
        rgs_container.setLayout(null);

        JLabel tag_title = new JLabel("Registrarse");
        tag_title.setBounds(125, 20, 150, 30);
        tag_title.setFont(new Font("Arial", Font.BOLD, 22));
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

        JCheckBox terminos = new JCheckBox("Acepto los términos");
        terminos.setBounds(60, 230, 200, 30);
        rgs_container.add(terminos);

        JLabel olvidaste = new JLabel("¿Olvidó su contraseña?");
        olvidaste.setBounds(60, 260, 200, 30);
        olvidaste.setForeground(Color.BLUE);
        rgs_container.add(olvidaste);

        JButton register_btn = new JButton("ACCEDER");
        register_btn.setBounds(80, 300, 120, 40);
        register_btn.setForeground(Color.RED);
        rgs_container.add(register_btn);

        JButton irLogin = new JButton("Ir al login");
        irLogin.setBounds(220, 300, 120, 40);
        irLogin.setForeground(Color.RED);
        rgs_container.add(irLogin);

        this.add(rgs_container);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Paaneles_1().setVisible(true));
    }
}