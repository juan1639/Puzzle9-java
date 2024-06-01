package juan1639.main;

import java.awt.Color;

public class Settings {
	
	// Size de cada casilla (X, O) = 180px
	public static final Integer TILE_X = 180;
	public static final Integer TILE_Y = 180;
	
	public static final Integer FILAS = 3;
	public static final Integer COLUMNAS = 3;
	
	public static final Integer NUMERO_CASILLAS = 9;
	public static final Integer CASILLA_VACIA_INVISIBLE = 0;
	
	public class Colores {
		
		public static final Color NEGRO = new Color(1, 1, 1);
		public static final Color AMARILLO = new Color(245, 235, 1);
		public static final Color BLANCO = new Color(247, 247, 247);
		public static final Color AZUL = new Color(9, 115, 190);
		public static final Color AZUL_CLARO = new Color(9, 215, 190);
		public static final Color VERDE = new Color(50, 195, 9);
		public static final Color VERDE_CLARO = new Color(175, 235, 9);
	}
}
