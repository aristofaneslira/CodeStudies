package Algoritmos;

import java.awt.image.BufferedImage;

public class AlgoritmosCircunferencia {

	private Paint paint = new Paint();

	/**
	 * Algoritmo de desenho da Circunferencia do Ponto Médio
	 * @param raio
	 * @param bi
	 */
	public void CircPontoMedio(int coordX, int coordY, int raio, BufferedImage bi){
		int x = 0;
		int y = raio;
		double d = (5/4) - raio;
		
		PontoCirculo(coordX, coordY, x, y, bi);
		
		while (y > x){
			
			if (d < 0){   //ESCOLHE E
				d+= (2.0 * x) + 3.0;
			}
			
			else {   //ESCOLHE NE
				d+= (2.0 * (x - y)) + 5;
				y--;
			}
			
			x++;
			PontoCirculo(coordX, coordY, x, y, bi);
			
		}
	}
	
	//PLOTA 1 PIXEL EM CADA OITANTE
	public void PontoCirculo(int coordX, int coordY, int x, int y, BufferedImage bi){
		plotPixel(coordX, coordY, x, y, bi);
		plotPixel(coordX, coordY, y, x, bi);
		plotPixel(coordX, coordY, y, -x, bi);
		plotPixel(coordX, coordY, x, -y, bi);
		plotPixel(coordX, coordY, -x, -y, bi);
		plotPixel(coordX, coordY, -y, -x, bi);
		plotPixel(coordX, coordY, -y, x, bi);
		plotPixel(coordX, coordY, -x, y, bi);
		
	}
	

	/**
	 * Método de pintura de um ponto na tela de desenho recebida
	 * @param x
	 * @param y
	 * @param bi
	 */
	public void plotPixel (int coordX, int coordY, int x, int y, BufferedImage bi){
		try {
			bi.setRGB(x + coordX, coordY - y, 20);	
		} catch (Exception e) {
			//USUÁRIO ULTRAPASSOU OS LIMITES DAS COORDENADAS
			//NÃO FAZ NADA!
		}
		
	}
	
	/**
	 * Algoritmo de desenho da Circunferencia da Equação Explicita
	 * @param raio
	 * @param bi
	 */
	public void CircEquacaoExplicita(int raio, BufferedImage bi) {
		double raioAux = Math.pow(raio, 2);
		double xAux;
		double yAux;
		int y;
		
		for (int x = 0; x < raio; x++) {
			xAux = Math.pow(x, 2);
			
			yAux = Math.sqrt(raioAux - xAux);
			y = (int) Math.round(yAux);
			
			paint.plotPixel(x, y, bi);
			paint.plotPixel(-x, y, bi);
			paint.plotPixel( x, -y, bi);
			paint.plotPixel(-x, -y, bi);
			
		}
	}
	/**
	 * Algoritmo de desenho da Circunferencia do Método Trigonométrico
	 * @param raio
	 * @param bi
	 */
	public void CircMetodoTrigonometrico(int coordX, int coordY, int raio, BufferedImage bi) {
		int x;
		int y;
		for (int i = 0; i <= 45; i++) {
			x = (int)(raio*(Math.cos(i)));
			y = (int)(raio*(Math.sin(i)));
			PontoCirculo(coordX, coordY, x, y, bi);
		}
	}
	

}
