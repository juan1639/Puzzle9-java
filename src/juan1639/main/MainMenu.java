package juan1639.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
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
		setTitle(" [ P U Z Z L E  9 ]  Menu Principal");
		setLocationRelativeTo(null);
		setResizable(true);
		setMinimumSize(new Dimension(300, 300));

		// this.getContentPane().setBackground(Color.BLUE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void crearPanel() {

		panel = new JPanel(new GridLayout(3, 1));
		//panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		// panel.setBackground(Color.DARK_GRAY);
		this.getContentPane().add(panel);
	}

	public void crearEtiquetas() {
		
		String txt = "P U Z Z L E  9";
		int x = (int) (ANCHO_JFRAME / 2);

		titulo = new JLabel(txt, SwingConstants.CENTER);
		
		Font fuente = new Font("arial", Font.BOLD, 50);
		titulo.setFont(fuente);
		
		//FontMetrics fm = titulo.getFontMetrics(fuente);
		//int txtWidth = fm.stringWidth(txt);
		
		//titulo.setAlignmentX(SwingConstants.CENTER);
		
		/*
		 * titulo.setBounds(x - (int) (txtWidth / 2), (int) (ALTO_JFRAME / 10), (int)
		 * (ANCHO_JFRAME / 1.5), (int) (ALTO_JFRAME / 7));
		 */
		
		titulo.setForeground(Settings.AZUL);
		
		panel.add(titulo);
		//panel.add(titulo, BorderLayout.CENTER);
	}

	public void crearBotonJugar() {

		botonJugar = new JButton();
		
		botonJugar.setFont(new Font("arial", Font.BOLD, 30));
		botonJugar.setText("Jugar");
		// botonNG.setSize((int) (goX / 1.3), (int) (goY / 8));
		botonJugar.setFocusable(false);
		botonJugar.setBorder(null);
		// botonJugar.requestFocus();
		// botonNG.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true));
		
		/*
		 * botonJugar.setBounds((int) (ANCHO_JFRAME / 3), (int) (ALTO_JFRAME / 1.5),
		 * (int) (ANCHO_JFRAME / 2.5), (int) (ALTO_JFRAME / 7));
		 */
		
		// botonNG.setOpaque(true);
		botonJugar.setForeground(Settings.AZUL);
		botonJugar.setBackground(Settings.AZUL_CLARO);
		// botonNG.setBackground(Color.RED);
		panel.add(botonJugar);
	}

	public MouseListener eventoBotonJugar() {

		MouseListener jugar = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				dispose();

				Board tablero = new Board();
				tablero.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				// botonJugar.setForeground(Color.GREEN);
				botonJugar.setForeground(Settings.AMARILLO);
				botonJugar.setBackground(Settings.AZUL);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				botonJugar.setForeground(Settings.AZUL);
				botonJugar.setBackground(Settings.AZUL_CLARO);
			}
		};

		return jugar;
	}
}
