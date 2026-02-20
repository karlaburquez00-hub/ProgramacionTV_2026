package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {

	public Ventana() {
		
		this.setVisible(true);
		this.setSize(500, 500);
		//this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(200,200));
		this.setMaximumSize(new Dimension(800,800));
		
		this.setLocationRelativeTo(null);
		this.setTitle("Hola");
		
		this.setLayout(null);
		
		
		//this.setBackground(Color.red);
		//this.setOpacity(1);
		
		this.getContentPane().setBackground(Color.yellow);
		
        //this.setBounds(200,200,500,500);
		
		//AÑADIENDO ELEMENTOS
		JLabel tag_title = new JLabel();
		tag_title.setText("Bienvenido");
		tag_title.setSize(100.100);
		tag_title.setLocation(0,0);
		tag_title.setOpaque(true);
		this.getTitle().setFont(new Font("Arial",Font.PLAIN,22));
		tag_title.setVerticalAlignment(JLabel.CENTER);
		tag_title.setHorizontalAlignment(JLabel.CENTER);
		this.add(tag_title);
		
	}
}