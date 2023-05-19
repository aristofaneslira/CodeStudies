package Algoritmos;

import java.awt.image.BufferedImage;

public class AlgoritmoElipse {
	private Paint paint = new Paint();
	
	/**
	 * Desenha uma Elipse por meio do método do Ponto Médio
	 * @param a
	 * @param b
	 * @param bi
	 */
	public void elipsePM(int a, int b, BufferedImage bi) {
		int x, y;
		double d1, d2;
		
		// Valores iniciais
		x = 0;
		y = b;
		d1 = Math.pow(b, 2) - (Math.pow(a, 2) * b) + Math.pow(a, 2)/ 4.0;
		
		// Usa a simetria de ordem 4
		elipsePontos(x, y, bi);
		
		while (Math.pow(a, 2) * (y - 0.5) > Math.pow(b, 2) * (x + 1)) {
			// Região 1
			if (d1 < 0) {
				d1 += Math.pow(b, 2) * (2*x + 3);
				x++;
			} else {
				d1 += Math.pow(b, 2) * (2*x + 3) + Math.pow(a, 2) * (-2*y + 2);
				x++;
				y--;
			}
			
			elipsePontos(x, y, bi);
			
		}
		
		d2 = Math.pow(b, 2) * (x + 0.5) * (x + 0.5) + Math.pow(a, 2) * (y - 1) * (y - 1) - Math.pow(a, 2) * Math.pow(b, 2);
		
		while (y > 0) {
			// Região 2
			if (d2 < 0) {
				d2 += Math.pow(b, 2) * (2 * x + 2) + Math.pow(a, 2) * (-2 * y + 3);
				x++;
				y--;
			} else {
				d2 += Math.pow(a, 2) * (-2 * y + 3);
				y--;
			}
			
			elipsePontos(x, y, bi);
			
		}
		
	}
	
	/**
	 * Simetria de Ordem 4 para Elipse
	 * @param x
	 * @param y
	 * @param bi
	 */
	private void elipsePontos(int x, int y, BufferedImage bi) {
		paint.plotPixel( x, y, bi);
		paint.plotPixel( x,-y, bi);
		paint.plotPixel(-x, y, bi);
		paint.plotPixel(-x,-y, bi);
		
	}
	
}
