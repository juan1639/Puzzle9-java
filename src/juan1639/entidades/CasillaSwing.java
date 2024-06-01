package juan1639.entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import juan1639.logica.RealizarJugada;
import juan1639.main.Settings;

public class CasillaSwing {

	private Integer valor, indice;
	private Integer fila, columna;
	private JButton casillaBoton;

	public CasillaSwing(Integer valor, Integer indice, Integer fila, Integer columna) {

		this.valor = valor;
		this.indice = indice;
		this.fila = fila;
		this.columna = columna;

		this.casillaBoton = crearCasillaBoton();
		this.casillaBoton.addMouseListener(eventoRaton());
	}

	// Cada casilla es un JButton para que sea "clickable" (o cualquier elemento
	// Swing)
	private JButton crearCasillaBoton() {

		int ancho = Settings.TILE_X;
		int alto = Settings.TILE_Y;
		int fontSize = (int) (alto / 1.2);
		// Color colorFicha = valor == Tablero.fichaX ? new Color(5, 80, 220) : new
		// Color(25, 190, 5);
		Color colorFicha = Settings.Colores.VERDE;

		casillaBoton = new JButton(this.valor.toString());
		// casillaBoton.setOpaque(true);
		// casillaBoton.setText(String.valueOf(this.indice));
		// casillaBoton.setText(this.valor.toString());
		casillaBoton.setFont(new Font("verdana", Font.BOLD, fontSize));
		casillaBoton.setEnabled(true);
		casillaBoton.setFocusable(false);
		casillaBoton.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true));
		casillaBoton.setBounds(this.columna * ancho, this.fila * alto, ancho, alto);
		casillaBoton.setForeground(colorFicha);

		if (this.valor == Settings.CASILLA_VACIA_INVISIBLE) {
			casillaBoton.setVisible(false);
		}

		return casillaBoton;
	}

	private MouseListener eventoRaton() {

		MouseListener oyenteRaton = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// System.out.println(e.getSource());
				realizarJugadaClick(valor, indice, fila, columna);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				casillaBoton.setForeground(Settings.Colores.VERDE_CLARO);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				casillaBoton.setForeground(Settings.Colores.VERDE);
			}
		};

		return oyenteRaton;
	}

	private void realizarJugadaClick(Integer valor, Integer indice, Integer fila, Integer columna) {

		RealizarJugada jugada = new RealizarJugada(valor, indice, fila, columna);
	}

	// Getters & Setters
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public JButton getCasillaBoton() {
		return casillaBoton;
	}

	public void setCasillaBoton(JButton casillaBoton) {
		this.casillaBoton = casillaBoton;
	}
}
