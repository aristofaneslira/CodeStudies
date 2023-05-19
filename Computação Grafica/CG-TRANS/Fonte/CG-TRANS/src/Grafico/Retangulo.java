package Grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Retangulo {
	private Graphics graphics;
	
	
	/**
	 * Recebe coordenadas para a criação do retangulo, e tela para a pintura do mesmo
	 * @param xmin
	 * @param xmax
	 * @param ymin
	 * @param ymax
	 * @param bi
	 */
	public void desenharRetangulo(int xmin, int xmax, int ymin, int ymax, BufferedImage bi){
		graphics = bi.createGraphics();
		
		//gerando cor randomica
		Color color = new Color((int)(Math.random()*255),(int)(Math.random()*255), (int)(Math.random()*255));
	
		
		//desenhando bordas
		graphics.setColor(Color.BLACK);
		graphics.drawLine(xmin, ymin, xmax, ymin);
		graphics.drawLine(xmax, ymin, xmax, ymax);
		graphics.drawLine(xmax, ymax, xmin, ymax);
		graphics.drawLine(xmin, ymax, xmin, ymin);
		
		//preenchendo coluna
		int largura = Math.abs(xmax - xmin);
		int altura = Math.abs(ymax - ymin);
		graphics.setColor(color);
		graphics.fillRect(xmin+1, ymax+1, largura-1 , altura-1);
	}

}
