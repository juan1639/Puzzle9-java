package juan1639.logica;

import juan1639.tablero.Board;

public class RealizarJugada {
	
	private Integer valor;
	private Integer indice;
	private Integer fila;
	private Integer columna;
	
	public RealizarJugada(Integer valor, Integer indice, Integer fila, Integer columna) {
		super();
		this.valor = valor;
		this.indice = indice;
		this.fila = fila;
		this.columna = columna;
		
		checkVecinos();
	}
	
	public RealizarJugada() {}
	
	public void checkVecinos() {
		
		// Check Si hay vecino ARRIBA
		if (fila - 1 >= 0 && fila - 1 <= 1) {
			
			Board.getArrayCasillas();
			System.out.println(Board.getArrayCasillas()[indice].getValor());
		}
		
		// Check Si hay vecino DERECHA
		if (columna + 1 >= 1 && columna + 1 <= 2) {
			
			Board.getArrayCasillas();
			System.out.println(Board.getArrayCasillas()[indice].getValor());
		}
		
		// Check Si hay vecino ABAJO
		if (fila + 1 >= 1 && fila + 1 <= 2) {
			
			Board.getArrayCasillas();
			System.out.println(Board.getArrayCasillas()[indice].getValor());
		}
		
		// Check Si hay vecino IZQUIERDA
		if (columna - 1 >= 0 && columna - 1 <= 1) {
			
			Board.getArrayCasillas();
			System.out.println(Board.getArrayCasillas()[indice].getValor());
		}
	}
}
