package main;

import javax.swing.*;
import java.awt.*;

public class Dibujo extends JFrame {

    public Dibujo() {
        setTitle("Dibujo de una Casa");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // ===== FONDO =====
        // Cielo
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 600, 300);

        // Suelo
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, 300, 600, 200);

        // ===== CASA =====
        // Pared
        g.setColor(Color.YELLOW);
        g.fillRect(200, 200, 200, 150);

        // ===== TECHO (Triángulo) =====
        g.setColor(Color.RED);
        int[] xPoints = {180, 300, 420};
        int[] yPoints = {200, 120, 200};
        g.fillPolygon(xPoints, yPoints, 3);

        // ===== PUERTA =====
        g.setColor(new Color(139, 69, 19));
        g.fillRect(270, 250, 60, 100);

        // Perilla
        g.setColor(Color.BLACK);
        g.fillOval(315, 300, 10, 10);

        // ===== VENTANA =====
        g.setColor(Color.WHITE);
        g.fillRect(220, 240, 50, 50);

        // Divisiones ventana
        g.setColor(Color.BLACK);
        g.drawLine(245, 240, 245, 290);
        g.drawLine(220, 265, 270, 265);

        // ===== CHIMENEA =====
        g.setColor(Color.GRAY);
        g.fillRect(350, 140, 30, 60);

        // ===== CERCO =====
        g.setColor(new Color(222, 184, 135));
        for (int i = 0; i < 600; i += 30) {
            g.fillRect(i, 270, 20, 80);
        }
    }

    public static void main(String[] args) {
       Dibujo ventana = new Dibujo();
        ventana.setVisible(true);
    }
}