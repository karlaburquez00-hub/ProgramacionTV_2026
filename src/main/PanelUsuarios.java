package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PanelUsuarios extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    public PanelUsuarios() {

        setLayout(new BorderLayout());
        setBackground(new Color(233, 167, 167)); // Fondo rosado

        // =========================
        // TÍTULO
        // =========================
        JLabel titulo = new JLabel("Usuarios", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 36));
        titulo.setForeground(Color.BLACK);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titulo, BorderLayout.NORTH);

        // =========================
        // MODELO
        // =========================
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Solo lectura
            }
        };

        // Columnas como la imagen
        modelo.addColumn("No. Control");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Semestre");
        modelo.addColumn("Carrera");
        modelo.addColumn("Acciones");

        // =========================
        // DATOS REPETIDOS
        // =========================
        for (int i = 1; i <= 30; i++) {
            modelo.addRow(new Object[]{
                    "2023" + i,
                    "Nombre",
                    "Apellidos",
                    "correo@email.com",
                    "Semestre",
                    "Carrera",
                    "Acciones"
            });
        }

        // =========================
        // TABLA
        // =========================
        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Personalizar encabezado
        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 13));
        header.setBackground(Color.LIGHT_GRAY);
        header.setForeground(Color.BLACK);

        // =========================
        // SCROLL
        // =========================
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 40, 40, 40));

        add(scroll, BorderLayout.CENTER);
    }

    // =========================
    // MAIN
    // =========================
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Mi ventanita");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);
            frame.setLocationRelativeTo(null);

            frame.add(new PanelUsuarios());
            frame.setVisible(true);
        });
    }
}