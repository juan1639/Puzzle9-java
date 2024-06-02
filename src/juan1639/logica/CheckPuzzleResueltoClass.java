package juan1639.logica;

import juan1639.entidades.CasillaSwing;
import juan1639.tablero.Board;

public class CheckPuzzleResueltoClass {

	public static Boolean checkBoard() {

		CasillaSwing[] board = Board.getArrayCasillas();
		int index = 1;

		for (var casilla : board) {

			if (casilla.getValor() != index) {
				return false;
			}

			index++;
		}
		// Si llega hasta aqui True = Puzzle ordenado (todos los index=valor)
		return true;
	}
}
