package Model;

import java.awt.image.BufferedImage;

public class AlgoritmoReta {
	
	/**
	 * Desenha uma reta usando o Algoritmo DDA
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param bufferedimage
	 */
	public void desenharDDA(int x1, int y1, int x2, int y2, BufferedImage bufferedimage){
		
		int length;
		float x, y, xInc, yInc;
		
		length = Math.abs(x2-x1);
		if (Math.abs(y2-y1) > length) {
			length = Math.abs(y2-y1);
		}
		
		// Define o incremento em X
		xInc = (float)(x2-x1)/length;
		// Define o incremento em Y
		yInc = (float)(y2-y1)/length;
		
		x = x1;
		y = y1;
		
		// Desenha o primeiro Pixel
		Pixel.setPixel(Math.round(x), Math.round(y), bufferedimage);
		
		for (int i = 0; i < length; i++) {
			x += xInc;
			y += yInc;
			
			Pixel.setPixel(Math.round(x), Math.round(y), bufferedimage);
			
		}
		
	}
	
	/**
	 * Desenha uma reta usando o Algoritmo do Ponto Medio
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param bufferedImage
	 */
	public void desenharPontoMedio(int x1, int y1, int x2, int y2, BufferedImage bufferedImage){
		int dx, dy, incE, incNE, d, x, y;
		
		dx = Math.abs(x2 - x1);
		dy = Math.abs(y2 - y1);
		
		x = x1;
		y = y1;
		
		Pixel.setPixel(x, y, bufferedImage);
		
		// 1º Quadrante
		if((x1 < x2)&&(y1 <= y2)){
			
			if(dx >= dy){
				d = 2*dy - dx;
				incE = 2*dy;
				incNE = 2*(dy - dx);
				
				while (x < x2) {
					if (d <= 0) {
						d = d + incE;
						x = x + 1;
					} else {
						d = d + incNE;
						x = x + 1;
						y = y + 1;
					}
					
					Pixel.setPixel(x, y, bufferedImage);
					
				}
				
			} else if(dx < dy){
				d = dy - 2*dx;
				incE = 2*(dy - dx);
				incNE = 2*(-dx);
				
				while (y < y2) {
					if (d < 0) {
						d = d + incE;
						x = x + 1;
						y = y + 1;
						
					} else {
						d = d + incNE;
						y = y + 1;
					}
					
					Pixel.setPixel(x, y, bufferedImage);
					
				}
			}
			
		// 2º Quadrante
		} else if((x1 >= x2) && (y1 < y2)){
			if(dx <= dy ){
				d = dy - 2*dx;
				incE = 2*(dy - dx);
				incNE = 2*(-dx);
								
				while (y < y2) {
					if (d < 0) {
						d = d + incE;
						x = x - 1;
						y = y + 1;
						
					} else {
						d = d + incNE;
						y = y + 1;
					}
					
					Pixel.setPixel(x, y, bufferedImage);
					
				}
				
			} else if(dx > dy){
				d = 2*dy - dx;
				incE = 2*dy;
				incNE = 2*(dy - dx);
				
				while (x > x2) {
					if (d <= 0) {
						d = d + incE;
						x = x - 1;
						
					} else {
						d = d + incNE;
						x = x - 1;
						y = y + 1;
					}
					
					Pixel.setPixel(x, y, bufferedImage);
					
				}
				
			}
			
		// 3º Quadrante
		}else if((x1 > x2)&&(y1 >= y2)){
			if(dx >= dy){
				d = 2*dy - dx;
				incE = 2*dy;
				incNE = 2*(dy - dx);
				
				while (x > x2) {
					if (d <= 0) {
						d = d + incE;
						x = x - 1;
						
					} else {
						d = d + incNE;
						x = x - 1;
						y = y - 1;
					}
					
					Pixel.setPixel(x, y, bufferedImage);
					
				}
				
			} else if(dx < dy){
				d = dy - 2*dx;
				incE = 2*(dy - dx);
				incNE = 2*(-dx);
				
				while (y > y2) {
					if (d < 0) {
						d = d + incE;
						x = x - 1;
						y = y - 1;
						
					} else {
						d = d + incNE;
						y = y - 1;
					}
					
					Pixel.setPixel(x, y, bufferedImage);
					
				}
				
			}
			
		// 4º Quadrante
		} else if((x1 <= x2) && (y1 > y2)){
			if(dx <= dy){
				d = dy - 2*dx;
				incE = 2*(dy - dx);
				incNE = 2*(-dx);
				
				while (y > y2) {
					if (d < 0) {
						d = d + incE;
						x = x + 1;
						y = y - 1;
						
					} else {
						d = d + incNE;
						y = y - 1;
					}
					
					Pixel.setPixel(x, y, bufferedImage);
					
				}
				
			} else if(dx > dy){
				d = 2*dy - dx;
				incE = 2*dy;
				incNE = 2*(dy - dx);
				
				while (x < x2) {
					if (d <= 0) {
						d = d + incE;
						x = x + 1;
						
					} else {
						d = d + incNE;
						x = x + 1;
						y = y - 1;
					}
					
					Pixel.setPixel(x, y, bufferedImage);
					
				}
			}
		}
	}
	
}
