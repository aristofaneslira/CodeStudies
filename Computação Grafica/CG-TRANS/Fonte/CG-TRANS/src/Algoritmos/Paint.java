package Algoritmos;

import java.awt.image.BufferedImage;

public class Paint {
	public int Xinit = 300;
	public int Yinit = 300;

	/**
	 * Método de pintura que desloca o ponto de origem para o centro da imagem
	 * @param x
	 * @param y
	 * @param bi
	 */
	public void plotPixel (int x, int y, BufferedImage bi){
		try {
			bi.setRGB(x + Xinit, Yinit - y, 20);	
		} catch (Exception e) {
			//USUÁRIO ULTRAPASSOU OS LIMITES DAS COORDENADAS
			//NÃO FAZ NADA!
		}
		
	}
	
}
