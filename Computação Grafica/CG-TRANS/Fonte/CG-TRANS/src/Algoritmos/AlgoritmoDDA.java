package Algoritmos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AlgoritmoDDA {
	
	private Paint paint = new Paint();
	private ArrayList<Integer> pontosX = new ArrayList<>(); 
	private ArrayList<Integer> pontosY = new ArrayList<>();
	
	/**
	 * Recebe as coordenadas dos pontos extremos da reta e desenha a mesma
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param bi
	 */
	public void DDA(int x1, int y1, int x2, int y2, BufferedImage bi){
        pontosX.clear();
        pontosY.clear();
		
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
        paint.plotPixel(Math.round(x), Math.round(y), bi);
        pontosX.add(Math.round(x));
        pontosY.add(Math.round(y));
        for (int i = 0; i < length; i++) {
            x += xInc;
            y += yInc;
            paint.plotPixel(Math.round(x), Math.round(y), bi);
            pontosX.add(Math.round(x));
            pontosY.add(Math.round(y));
            
        }
        
    }
	
	/**
	 * Retorna as coordenadas do eixo X
	 * @return
	 */
	public ArrayList<Integer> getPontosX(){
		return this.pontosX;
	}
	
	/**
	 * Retorna as coordenadas do eixo Y
	 * @return
	 */
	public ArrayList<Integer> getPontosY(){
		return this.pontosY;
	}
	
	
}
