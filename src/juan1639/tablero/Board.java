package juan1639.tablero;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import juan1639.entidades.CasillaSwing;
import juan1639.main.Settings;

public class Board extends JFrame {

	private static final Integer ANCHO_JFRAME = Settings.TILE_X * 3;
	private static final Integer ALTO_JFRAME = Settings.TILE_Y * 3;

	private static final Integer NUMERO_CASILLAS = Settings.NUMERO_CASILLAS;

	private static final Integer FILAS = Settings.FILAS;
	private static final Integer COLUMNAS = Settings.COLUMNAS;

	private static CasillaSwing[] arrayCasillas = new CasillaSwing[NUMERO_CASILLAS];
	private static ArrayList<Integer> sorteoArray = new ArrayList<>(Settings.NUMERO_CASILLAS);
	private static JPanel panel;

	public Board() {

		settingsJFrame();
		crearPanel();
		sorteoInicialValores();
		iniciarComponentesSwing();
	}

	private void settingsJFrame() {

		int ajusteX = 12, ajusteY = 34;

		setSize(ANCHO_JFRAME + ajusteX, ALTO_JFRAME + ajusteY);
		setTitle(" [ P U Z Z L E - 9 ]  By Juan Eguia");
		setLocationRelativeTo(null);
		setResizable(false);
		setMinimumSize(new Dimension(300, 300));
		// this.getContentPane().setBackground(Color.BLUE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void crearPanel() {

		panel = new JPanel();
		panel.setLayout(null);

		// panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
		panel.setBackground(Color.DARK_GRAY);
		this.getContentPane().add(panel);
	}

	public static void sorteoInicialValores() {

		Integer numeroRnd;

		for (int i = 0; i < Settings.NUMERO_CASILLAS; i++) {

			do {
				numeroRnd = (int) (Math.random() * Settings.NUMERO_CASILLAS);
			} while (sorteoArray.contains(numeroRnd));

			sorteoArray.add(numeroRnd);
		}

		System.out.println(sorteoArray);
	}

	public static void iniciarComponentesSwing() {
		// Dibujar el Tablero de Juego / Draw GameBoard

		int i = 0;
		for (int fila = 0; fila < FILAS; fila++) {
			for (int col = 0; col < COLUMNAS; col++) {
				
				CasillaSwing casilla = new CasillaSwing(sorteoArray.get(i), i, fila, col);
				arrayCasillas[i] = casilla;
				JButton casillaBoton = casilla.getCasillaBoton();
				panel.add(casillaBoton);
				i++;
			}
		}
	}
	
	public static void swapCasillaVaciaPorJugadaRealizada(Integer indiceVacia, Integer indice) {
		
		// Cambiar valor (Primitivos)
		arrayCasillas[indiceVacia].setValor(arrayCasillas[indice].getValor());
		arrayCasillas[indice].setValor(Settings.CASILLA_VACIA_INVISIBLE);
		
		// Cambios en el Board (Swing)
		arrayCasillas[indiceVacia].getCasillaBoton().setText(arrayCasillas[indiceVacia].getValor().toString());
		arrayCasillas[indiceVacia].getCasillaBoton().setVisible(true);
		
		arrayCasillas[indice].getCasillaBoton().setText(arrayCasillas[indice].getValor().toString());
		arrayCasillas[indice].getCasillaBoton().setVisible(false);
		
		panel.repaint();
		
		System.out.println("hecho swap");
		
		/*
		 * panel.remove(arrayCasillas[indice].getCasillaBoton());
		 * 
		 * arrayCasillas[indice] = new CasillaXO(fichaXO, indice, fila, columna);
		 * panel.add(arrayCasillas[indice].getCasillaBoton());
		 * 
		 * panel.repaint();
		 */
	}

	// Getters & Setters
	public static CasillaSwing[] getArrayCasillas() {
		return arrayCasillas;
	}

	public static void setArrayCasillas(CasillaSwing[] arrayCasillas) {
		Board.arrayCasillas = arrayCasillas;
	}
}
