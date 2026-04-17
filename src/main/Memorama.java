package main;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Memorama {

	private JFrame frame;

	// SOLO 4 PARES = 8 CARTAS
	private List<String> valores = new ArrayList<>(Arrays.asList(
			"A","A","B","B","C","C","D","D"
	));

	private ArrayList<JButton> botones = new ArrayList<>();

	private int movimientos = 0;
	private int pares = 0;
	private int segundos = 0;

	private JLabel lblMovimientos;
	private JLabel lblPares;
	private JLabel lblTiempo;

	private JButton primeraCarta = null;
	private JButton segundaCarta = null;

	private Timer timerOcultar;
	private Timer timerTiempo;

	private boolean pausado = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memorama window = new Memorama();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Memorama() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		// ===== PANEL SUPERIOR =====
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(119, 188, 253));
		panelSuperior.setLayout(new GridLayout(1, 3));

		lblMovimientos = new JLabel("Movimientos: 0");
		lblMovimientos.setHorizontalAlignment(SwingConstants.CENTER);

		lblPares = new JLabel("Pares: 0");
		lblPares.setHorizontalAlignment(SwingConstants.CENTER);

		lblTiempo = new JLabel("Segundos: 0");
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);

		panelSuperior.add(lblMovimientos);
		panelSuperior.add(lblPares);
		panelSuperior.add(lblTiempo);

		frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);

		// ===== TABLERO 4x2 =====
		JPanel panelTablero = new JPanel();
		panelTablero.setBackground(new Color(171, 250, 255));
		panelTablero.setLayout(new GridLayout(2, 4, 5, 5));

		Collections.shuffle(valores);

		for (int i = 0; i < 8; i++) {

			JButton boton = new JButton("");
			boton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 28));

			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pausado) return;

					JButton btn = (JButton) e.getSource();
					revelarCarta(btn);
				}
			});

			botones.add(boton);
			panelTablero.add(boton);
		}

		frame.getContentPane().add(panelTablero, BorderLayout.CENTER);

		// ===== PANEL INFERIOR =====
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(247, 239, 127));

		JButton btnReiniciar = new JButton("Reiniciar");
		JButton btnPausa = new JButton("Pausa");

		btnReiniciar.addActionListener(e -> reiniciarJuego());
		btnPausa.addActionListener(e -> pausarJuego(btnPausa));

		panelInferior.add(btnReiniciar);
		panelInferior.add(btnPausa);

		frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		// ===== TIMER OCULTAR =====
		timerOcultar = new Timer(1000, e -> ocultarCartas());
		timerOcultar.setRepeats(false);

		// ===== TIMER TIEMPO =====
		timerTiempo = new Timer(1000, e -> {
			segundos++;
			lblTiempo.setText("Segundos: " + segundos);
		});
		timerTiempo.start();
	}

	private void revelarCarta(JButton btn) {

		int indice = botones.indexOf(btn);

		if (btn.getText().equals("") && btn != primeraCarta) {

			btn.setText(valores.get(indice));

			if (primeraCarta == null) {
				primeraCarta = btn;
			}
			else {
				segundaCarta = btn;
				movimientos++;
				lblMovimientos.setText("Movimientos: " + movimientos);

				compararCartas();
			}
		}
	}

	private void compararCartas() {

		if (primeraCarta.getText().equals(segundaCarta.getText())) {

			pares++;
			lblPares.setText("Pares: " + pares);

			primeraCarta.setEnabled(false);
			segundaCarta.setEnabled(false);

			primeraCarta = null;
			segundaCarta = null;

			if (pares == 4) { // SOLO 4 PARES
				timerTiempo.stop();
				JOptionPane.showMessageDialog(frame,
						"¡Felicidades!\nTerminaste en "
						+ segundos + " segundos\n"
						+ movimientos + " movimientos");
			}

		} else {
			timerOcultar.start();
		}
	}

	private void ocultarCartas() {
		primeraCarta.setText("");
		segundaCarta.setText("");
		primeraCarta = null;
		segundaCarta = null;
	}

	private void reiniciarJuego() {

		Collections.shuffle(valores);

		for (JButton btn : botones) {
			btn.setText("");
			btn.setEnabled(true);
		}

		movimientos = 0;
		pares = 0;
		segundos = 0;

		lblMovimientos.setText("Movimientos: 0");
		lblPares.setText("Pares: 0");
		lblTiempo.setText("Segundos: 0");

		primeraCarta = null;
		segundaCarta = null;

		timerTiempo.restart();
	}

	private void pausarJuego(JButton btn) {

		pausado = !pausado;

		if (pausado) {
			timerTiempo.stop();
			btn.setText("Continuar");
		} else {
			timerTiempo.start();
			btn.setText("Pausa");
		}
	}
}