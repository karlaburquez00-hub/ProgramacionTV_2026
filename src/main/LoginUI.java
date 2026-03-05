package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame {

    public LoginUI() {

        setTitle("User Login");
        setSize(420,520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Fondo azul
        JPanel fondo = new JPanel();
        fondo.setBounds(0,0,420,520);
        fondo.setBackground(new Color(30,60,140));
        fondo.setLayout(null);

        // Titulo
        JLabel titulo = new JLabel("User Login");
        titulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 28));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(130,40,200,40);
        fondo.add(titulo);

        // Subtitulo
        JLabel cuenta = new JLabel("My Account");
        cuenta.setFont(new Font("Arial", Font.BOLD, 26));
        cuenta.setForeground(new Color(255,170,70)); // naranja
        cuenta.setBounds(120,80,200,40);
        fondo.add(cuenta);

        // Texto usuario
        JLabel lblUser = new JLabel("Enter Your Username");
        lblUser.setForeground(Color.WHITE);
        lblUser.setFont(new Font("Arial",Font.BOLD,12));
        lblUser.setBounds(80,150,200,20);
        fondo.add(lblUser);

        // Campo usuario
        JTextField txtUser = new JTextField();
        txtUser.setBounds(80,175,250,30);
        fondo.add(txtUser);

        // Texto contraseña
        JLabel lblPass = new JLabel("Enter Your Password");
        lblPass.setForeground(Color.WHITE);
        lblPass.setFont(new Font("Arial",Font.BOLD,12));
        lblPass.setBounds(80,220,200,20);
        fondo.add(lblPass);

        // Campo contraseña
        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(80,245,250,30);
        fondo.add(txtPass);

        // Botón Login
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(150,310,120,40);
        btnLogin.setBackground(new Color(255,170,70)); // naranja
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Arial",Font.BOLD,16));
        btnLogin.setFocusPainted(false);

        // Hover
        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                btnLogin.setBackground(new Color(230,140,50));
            }
            public void mouseExited(MouseEvent e){
                btnLogin.setBackground(new Color(255,170,70));
            }
        });

        fondo.add(btnLogin);

        // Texto registro
        JLabel registro = new JLabel("Don't have an account?");
        registro.setForeground(Color.WHITE);
        registro.setBounds(140,360,200,20);
        fondo.add(registro);

        // Botón Sign Up
        JButton btnSign = new JButton("Sign Up");
        btnSign.setBounds(160,385,100,35);
        btnSign.setBackground(new Color(255,170,70));
        btnSign.setForeground(Color.WHITE);

        btnSign.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new SignUpUI();
            }
        });

        fondo.add(btnSign);

        add(fondo);
        setVisible(true);
    }

    public static void main(String[] args){
        new LoginUI();
    }
}


// Ventana de registro
class SignUpUI extends JFrame{

    public SignUpUI(){

        setTitle("Sign Up");
        setSize(650,420);
        setLocationRelativeTo(null);
        setLayout(null);

        // Panel izquierdo azul
        JPanel left = new JPanel();
        left.setBounds(0,0,260,420);
        left.setBackground(new Color(30,60,140));
        left.setLayout(null);

        JLabel company = new JLabel("COMPANY NAME");
        company.setForeground(new Color(255,170,70));
        company.setFont(new Font("Arial",Font.BOLD,20));
        company.setBounds(40,180,200,30);
        left.add(company);

        add(left);

        // Panel derecho
        JPanel right = new JPanel();
        right.setBounds(260,0,390,420);
        right.setBackground(Color.WHITE);
        right.setLayout(null);

        JLabel titulo = new JLabel("SIGN UP");
        titulo.setFont(new Font("Arial",Font.BOLD,22));
        titulo.setBounds(150,40,200,30);
        right.add(titulo);

        JLabel name = new JLabel("Full name");
        name.setBounds(60,100,100,20);
        right.add(name);

        JTextField txtName = new JTextField();
        txtName.setBounds(60,120,250,30);
        right.add(txtName);

        JLabel email = new JLabel("Email");
        email.setBounds(60,170,100,20);
        right.add(email);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(60,190,250,30);
        right.add(txtEmail);

        JLabel pass = new JLabel("Password");
        pass.setBounds(60,240,100,20);
        right.add(pass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(60,260,250,30);
        right.add(txtPass);

        JButton btn = new JButton("Sign Up");
        btn.setBounds(140,310,120,35);
        btn.setBackground(new Color(255,170,70));
        btn.setForeground(Color.WHITE);
        right.add(btn);

        add(right);

        setVisible(true);
    }
}