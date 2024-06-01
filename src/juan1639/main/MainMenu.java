package juan1639.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import juan1639.tablero.Board;

public class MainMenu extends JFrame {

	private JPanel panel;
	private JLabel titulo;
	private JButton botonJugar;

	private final static Integer ANCHO_JFRAME = Settings.TILE_X * 3;
	private final static Integer ALTO_JFRAME = Settings.TILE_Y * 2;

	public MainMenu() {

		settingsJFrame();
		crearPanel();
		crearEtiquetas();
		crearBotonJugar();
		botonJugar.addMouseListener(eventoBotonJugar());
	}

	public void settingsJFrame() {

		setSize(ANCHO_JFRAME, ALTO_JFRAME);
		setTitle(" [ P U Z Z L E - 9 ]  Menu Principal");
		setLocationRelativeTo(null);
		setResizable(false);
		setMinimumSize(new Dimension(300, 200));
		setVisible(true);
		// this.getContentPane().setBackground(Color.BLUE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void crearPanel() {

		panel = new JPanel(new BorderLayout(0, 0));
		//panel.setLayout(null);
		
		crearBotonJugar();
		
		// panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		panel.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().add(panel);
	}

	public void crearEtiquetas() {

		String txt = "P U Z Z L E - 9";
		// int x = (int) (ANCHO_JFRAME / 2);

		titulo = new JLabel(txt);
		titulo.setFont(new Font("verdana", Font.BOLD, 55));

		// FontMetrics fm = titulo.getFontMetrics(fuente);
		// int txtWidth = fm.stringWidth(txt);
		
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		/*
		 * titulo.setBounds(x - (int) (txtWidth / 2), (int) (ALTO_JFRAME / 10), (int)
		 * (ANCHO_JFRAME / 1.5), (int) (ALTO_JFRAME / 7));
		 */

		titulo.setForeground(Settings.Colores.AZUL);
		// etiquetaGO.setOpaque(true);

		panel.add(titulo);
		// panel.add(titulo, BorderLayout.CENTER);
	}

	public void crearBotonJugar() {
		
		botonJugar = new JButton("Play");
		
		botonJugar.setFont(new Font("verdana", Font.BOLD, 45));
		// botonNG.setSize((int) (goX / 1.3), (int) (goY / 8));
		botonJugar.setFocusable(false);
		botonJugar.setBorder(null);
		//botonJugar.setMargin();
		botonJugar.setBorder(BorderFactory.createEmptyBorder(
				(int) (ALTO_JFRAME / 12), 0, (int) (ALTO_JFRAME / 12), 0));
		
		// botonJugar.requestFocus();
		// botonNG.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true));

		/*
		 * botonJugar.setBounds((int) (ANCHO_JFRAME / 3), (int) (ALTO_JFRAME / 1.5),
		 * (int) (ANCHO_JFRAME / 2.5), (int) (ALTO_JFRAME / 7));
		 */

		// botonNG.setOpaque(true);
		botonJugar.setForeground(Settings.Colores.AZUL_CLARO);
		
		//panel.add(botonJugar);
		panel.add(botonJugar, BorderLayout.SOUTH);
	}

	public MouseListener eventoBotonJugar() {

		MouseListener jugar = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();

				Board tablero = new Board();
				tablero.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				botonJugar.setForeground(Settings.Colores.AMARILLO);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonJugar.setForeground(Settings.Colores.AZUL_CLARO);
			}
		};

		return jugar;
	}
}
