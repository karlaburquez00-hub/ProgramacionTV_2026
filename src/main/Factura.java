package main;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Factura extends JFrame{
	public Factura() {
		
		setTitle("Factura en Java - NetBeans - ArrayList y POO");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		  Color azul = new Color(0, 102, 153);

		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.setBackground(Color.WHITE);
		
		//=======================
		//ENCABEZADO
		//========================
		  JPanel header = new JPanel();
	        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
	        header.setBackground(azul);
	        header.setBorder(new EmptyBorder(10, 10, 10, 10));

	        JLabel titulo = new JLabel("Factura en Java - NetBeans - ArrayList y POO");
	        titulo.setForeground(Color.WHITE);
	        titulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
	        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

	        JLabel subtitulo = new JLabel("[Sin Base de datos]");
	        subtitulo.setForeground(Color.WHITE);
	        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

	        header.add(titulo);
	        header.add(subtitulo);

	        panelPrincipal.add(header);
	        
	       //============================
	      // DATOS DEL CLIENTE
	     //==============================
	        JPanel panelCliente = new JPanel(new GridLayout(2, 4, 10, 5));
	        panelCliente.setBorder(new TitledBorder("Datos del cliente"));

	        panelCliente.add(new JLabel("Documento:"));
	        panelCliente.add(new JTextField("123456"));

	        panelCliente.add(new JLabel("Nombres:"));
	        panelCliente.add(new JTextField("Jhon Doe"));

	        panelCliente.add(new JLabel("Dirección:"));
	        panelCliente.add(new JTextField("Calle 1 # 123"));

	        panelCliente.add(new JLabel("Teléfono:"));
	        panelCliente.add(new JTextField("5554433"));

	        panelPrincipal.add(panelCliente);
	        
	     //===========================
	     //DATOS DE FACTURA
	    //============================
	        JPanel panelFactura = new JPanel(new GridLayout(1, 4, 10, 5));
	        panelFactura.setBorder(new TitledBorder("Datos de factura:"));
	        
	        panelFactura.add(new JLabel("Nº Factura:"));
	        panelFactura.add(new JTextField("1"));
	        
	        panelFactura.add(new JLabel("Fecha:"));
	        panelFactura.add(new JTextField("21/03/2026"));
	        
	        panelPrincipal.add(panelFactura);
	        
	      //==========================
	     // BOTONES SUPERIORES
	    //============================
	        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));

	        JButton btnVerLista = new JButton("Ver listado de facturas");
	        JButton btnAgregar = new JButton("Añadir");
	        JButton btnEliminar = new JButton("Eliminar");

	        panelBotones.add(btnVerLista);
	        panelBotones.add(btnAgregar);
	        panelBotones.add(btnEliminar);

	        panelPrincipal.add(panelBotones);

	        // =========================
	        // TABLA
	        // =========================
	        String[] columnas = {"Producto", "Cantidad", "Valor", "Sub Total"};

	        Object[][] datos = {
	                {"Agua", 2, 500, 1000.0},
	                {"Cereal", 5, 1000, 5000.0},
	                {"Leche", 2, 300, 600.0}
	        };

	        JTable tabla = new JTable(new DefaultTableModel(datos, columnas));
	        JScrollPane scroll = new JScrollPane(tabla);
	        scroll.setPreferredSize(new Dimension(600, 150));

	        panelPrincipal.add(scroll);

	        // =========================
	        // TOTALES
	        // =========================
	        JPanel panelTotales = new JPanel(new GridLayout(4, 3, 10, 5));
	        panelTotales.setBorder(new EmptyBorder(10, 10, 10, 10));

	        panelTotales.add(new JLabel("SubTotal:"));
	        panelTotales.add(new JLabel("6600.0"));
	        panelTotales.add(new JLabel(""));

	        panelTotales.add(new JLabel("% Descuento:"));
	        panelTotales.add(new JTextField("5"));
	        panelTotales.add(new JLabel("Valor descontado: 330.0"));

	        panelTotales.add(new JLabel("IVA 19%:"));
	        panelTotales.add(new JLabel("1254.0"));
	        panelTotales.add(new JLabel(""));

	        panelTotales.add(new JLabel("Total Factura:"));
	        panelTotales.add(new JLabel("7524.0"));
	        panelTotales.add(new JLabel(""));

	        panelPrincipal.add(panelTotales);

	        // =========================
	        // BOTONES INFERIORES
	        // =========================
	        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	        JButton btnFinalizar = new JButton("Finalizar factura");
	        JButton btnLimpiar = new JButton("Limpiar");

	        panelInferior.add(btnFinalizar);
	        panelInferior.add(btnLimpiar);

	        panelPrincipal.add(panelInferior);
	        
	        //=====================
	       //EVENTOS
	      //======================
	       
	       //Finalizar Evento
	        btnFinalizar.addActionListener(e -> {
	            JOptionPane.showMessageDialog(
	                    this,
	                    "La factura se ha realizado con éxito!",
	                    "Información",
	                    JOptionPane.INFORMATION_MESSAGE
	            );
	        });

	        // Evento Añadir producto
	        btnAgregar.addActionListener(e -> {

	            JDialog dialog = new JDialog(this, "Añadir nuevo producto", true);
	            dialog.setSize(350, 200);
	            dialog.setLayout(new GridLayout(4, 2, 5, 5));

	            dialog.add(new JLabel("Nombre:"));
	            JTextField txtNombre = new JTextField();
	            dialog.add(txtNombre);

	            dialog.add(new JLabel("Cantidad:"));
	            JTextField txtCantidad = new JTextField();
	            dialog.add(txtCantidad);

	            dialog.add(new JLabel("Valor:"));
	            JTextField txtValor = new JTextField();
	            dialog.add(txtValor);

	            JButton btnAgregarProd = new JButton("Agregar");
	            JButton btnCerrar = new JButton("Cerrar");

	            dialog.add(btnAgregarProd);
	            dialog.add(btnCerrar);

	            btnCerrar.addActionListener(ev -> dialog.dispose());

	            dialog.setLocationRelativeTo(this);
	            dialog.setVisible(true);
	        });
	        
	        add(panelPrincipal);
	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);

	    }
	    
	         public static void main(String[]args) {
	    	 SwingUtilities.invokeLater(Factura::new);
	     }
	
}