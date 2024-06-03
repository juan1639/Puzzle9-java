package juan1639.main;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import juan1639.tablero.Board;

public class OptionPanePrePost {
	
	public static void preJuegoDialog() {

		int newGame;
		int gameoverPane;
		
		if (!Settings.isPreJuego() && !Settings.isPuzzleResuelto())
			return;
		
		if (Settings.isPreJuego()) {

			newGame = JOptionPane.showConfirmDialog(Board.panel, " COMENZAR PARTIDA ", "Play", JOptionPane.CLOSED_OPTION);

			if (newGame == JOptionPane.OK_OPTION) {
				Settings.setPreJuego(false);
				Settings.setEnJuego(true);
			}

		} else if (Settings.isPuzzleResuelto()) {

			gameoverPane = JOptionPane.showConfirmDialog(Board.panel, " VOLVER A JUGAR ? ", " ENHORABUENA! Puzzle Resuelto! ",
					JOptionPane.YES_NO_CANCEL_OPTION);

			if (gameoverPane == JOptionPane.NO_OPTION || gameoverPane == JOptionPane.CANCEL_OPTION) {

				Toolkit.getDefaultToolkit().beep();
				System.exit(0);

			} else if (gameoverPane == JOptionPane.YES_OPTION) {
				// "resets" para Nueva Partida...
				Settings.setPuzzleResuelto(false);
				Settings.setEnJuego(true);

				Board.sorteoInicialValores(true);
				Board.iniciarComponentesSwing();
			}
		}
	}
}
