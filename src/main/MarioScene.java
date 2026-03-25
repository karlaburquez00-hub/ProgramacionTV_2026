package main;

import javax.swing.*;
import java.awt.*;

public class MarioScene extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // === CIELO ===
        g.setColor(new Color(135, 206, 235)); // Azul claro
        g.fillRect(0, 0, getWidth(), getHeight());

        // === SUELO (bloques repetidos) ===
        int brickSize = 40;
        for (int x = 0; x < getWidth(); x += brickSize) {
            for (int y = getHeight() - 120; y < getHeight(); y += brickSize) {
                g.setColor(new Color(181, 101, 29)); // Marrón
                g.fillRect(x, y, brickSize, brickSize);

                g.setColor(Color.BLACK);
                g.drawRect(x, y, brickSize, brickSize);
            }
        }

        // === ARBUSTO ===
        g.setColor(new Color(34, 139, 34));
        g.fillOval(80, getHeight() - 180, 80, 60);
        g.fillOval(110, getHeight() - 200, 80, 70);
        g.fillOval(140, getHeight() - 180, 80, 60);

        // === BLOQUES (edificios) ===
        // Rosa
        g.setColor(new Color(233, 150, 122));
        g.fillRect(200, getHeight() - 300, 150, 180);
        g.setColor(Color.BLACK);
        g.drawRect(200, getHeight() - 300, 150, 180);

        // Azul
        g.setColor(new Color(100, 149, 237));
        g.fillRect(300, getHeight() - 350, 150, 230);
        g.setColor(Color.BLACK);
        g.drawRect(300, getHeight() - 350, 150, 230);

        // === TUBERÍA ===
        // Cuerpo
        g.setColor(new Color(0, 128, 0));
        g.fillRect(550, getHeight() - 250, 80, 130);

        // Boca
        g.setColor(new Color(0, 180, 0));
        g.fillRect(530, getHeight() - 280, 120, 40);

        g.setColor(Color.BLACK);
        g.drawRect(550, getHeight() - 250, 80, 130);
        g.drawRect(530, getHeight() - 280, 120, 40);

        // === BLOQUE VERDE DERECHO ===
        g.setColor(new Color(0, 200, 100));
        g.fillRect(750, getHeight() - 280, 150, 160);
        g.setColor(Color.BLACK);
        g.drawRect(750, getHeight() - 280, 150, 160);

        // === BLOQUES MISTERIOSOS ===
        drawQuestionBlock(g, 100, 100);
        drawQuestionBlock(g, 300, 50);
        drawQuestionBlock(g, 350, 50);
        drawQuestionBlock(g, 800, 120);
    }

    // Método auxiliar para dibujar bloques con "?"
    private void drawQuestionBlock(Graphics g, int x, int y) {
        g.setColor(new Color(255, 140, 0));
        g.fillRect(x, y, 50, 50);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, 50, 50);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("?", x + 18, y + 32);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mario Mundo 1-1");
        MarioScene panel = new MarioScene();

        frame.add(panel);
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}