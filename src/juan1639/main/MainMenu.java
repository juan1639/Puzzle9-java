package juan1639.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import juan1639.tablero.Board;

public class MainMenu extends JFrame {
	
	private JPanel panel;
	private JLabel titulo;
	private JButton botonJugar;
	
	public MainMenu() {
		
		settingsJFrame();
		crearPanel();
		crearEtiquetas();
		crearBotonJugar();
		botonJugar.addMouseListener(eventoBotonJugar());
	}

	public void settingsJFrame() {
		
		setSize(Settings.TILE_X * 3, Settings.TILE_Y * 3);
		setTitle(" [ P U Z Z L E  9 ]  Menu Principal");
		setLocationRelativeTo(null);
		setResizable(true);
		setMinimumSize(new Dimension(300, 300));
		
		//this.getContentPane().setBackground(Color.BLUE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void crearPanel() {
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.DARK_GRAY);
		this.getContentPane().add(panel);
	}
	
	public void crearEtiquetas() {
		
		int x = (int) ((Settings.TILE_X * 3) / 10);
		
		titulo = new JLabel(" P U Z Z L E  9 ");
		titulo.setBounds(x, (int) ((Settings.TILE_Y * 3) / 18),
				(int) ((Settings.TILE_X * 3) / 1.3), (int) ((Settings.TILE_Y * 3) / 7));
		
		titulo.setForeground(Color.GRAY);
		titulo.setFont(new Font("arial", 1, 30));
		panel.add(titulo);
	}
	
	public void crearBotonJugar() {
		
		botonJugar = new JButton();
		botonJugar.setFont(new Font("arial", Font.BOLD, 30));
		botonJugar.setText(" Jugar ");
		//botonNG.setSize((int) (goX / 1.3), (int) (goY / 8));
		botonJugar.setFocusable(true);
		//botonJugar.requestFocus();
		//botonNG.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true));
		botonJugar.setBounds((int) ((Settings.TILE_X * 3) / 3), (int) ((Settings.TILE_Y * 3) / 1.3), 180, 50);
		//botonNG.setOpaque(true);
		botonJugar.setForeground(Color.BLUE);
		botonJugar.setBackground(Color.CYAN);
		//botonNG.setBackground(Color.RED);
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
				//botonJugar.setForeground(Color.GREEN);
				botonJugar.setForeground(Settings.AMARILLO);
				botonJugar.setBackground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				botonJugar.setForeground(Color.BLUE);
				botonJugar.setBackground(Color.CYAN);
			}
		};
		
		return jugar;
	}
}
