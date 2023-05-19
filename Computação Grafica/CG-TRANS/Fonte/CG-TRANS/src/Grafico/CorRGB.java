package Grafico;

import java.awt.Color;

public class CorRGB {
	private int red;
	private int green;
	private int blue;
	private Color cor;
	
	/**
	 * Construtor, recebe o valor das intensidades
	 * @param red
	 * @param green
	 * @param blue
	 */
	public CorRGB(int red, int green, int blue ){
		this.red = red;
		this.green = green;
		this.blue = blue;
		//cria cor
		this.cor = new Color(red, green, blue);
	}

	/**
	 * Retorna intensidade vermelha
	 * @return
	 */
	public int getRed() {
		return red;
	}
	
	/**
	 * Retorna intensidade verde
	 * @return
	 */
	public int getGreen() {
		return green;
	}
	/**
	 * Retorna intensidade azul
	 * @return
	 */
	public int getBlue() {
		return blue;
	}

	/**
	 * Retorna objeto do tipo Color
	 * @return
	 */
	public Color getCor() {
		return cor;
	}
	
	
}
