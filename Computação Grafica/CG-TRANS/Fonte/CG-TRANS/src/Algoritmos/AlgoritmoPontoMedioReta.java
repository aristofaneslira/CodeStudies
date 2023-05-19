package Algoritmos;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AlgoritmoPontoMedioReta {
	private Paint paint = new Paint();
	private ArrayList<Integer> pontosX = new ArrayList<>(); 
	private ArrayList<Integer> pontosY = new ArrayList<>();
	
	/**
	 * Retorna lista de coordenadas X para o JTable de Coordenadas
	 * @return
	 */
	public ArrayList<Integer> getPontosX(){
		return this.pontosX;
	}
	
	/**
	 * Retorna lista de coordenadas Y para o JTable de Coordenadas
	 * @return
	 */
	public ArrayList<Integer> getPontosY(){
		return this.pontosY;
	}
	
	
	
		/**
		 * Algoritmo do Ponto Medio da Reta (para todos os oitantes)
		 * @param x1
		 * @param y1
		 * @param x2
		 * @param y2
		 * @param bi
		 */
		public void MidPointReta(int x1, int y1, int x2, int y2, BufferedImage bi){  
			int dx, dy, incE, incNE, d, x, y;
			
			pontosX.clear();
	        pontosY.clear();
	        
			dx = Math.abs(x2 - x1);
			dy = Math.abs(y2 - y1);
			
			x = x1;
			y = y1;	
			
			//pinta o primeiro pixel
			paint.plotPixel(x,  y, bi);
			//adiciona nos arraylists(Jtable)
			pontosX.add(Math.round(x));
		    pontosY.add(Math.round(y));
			
		    //Condicao para o primeiro Oitante
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

						
						paint.plotPixel(x, y, bi);
						//adiciona nos arraylists(Jtable)
						pontosX.add(Math.round(x));
					    pontosY.add(Math.round(y));
					}
					
				//Condição para o Segundo Oitante
				}else if(dx < dy){
					
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
						
						paint.plotPixel(x, y, bi);
						//adiciona nos arraylists(Jtable)
						pontosX.add(Math.round(x));
					    pontosY.add(Math.round(y));

					}
					
				}
				
				
				
			//Condição para o terceiro oitante	
			}else if((x1 >= x2)&&(y1 < y2)){						
				
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
						
						paint.plotPixel(x, y, bi);
						//adiciona nos arraylists(Jtable)
						pontosX.add(Math.round(x));
					    pontosY.add(Math.round(y));
					}
					
				//Condição para o quarto oitante
				}else if(dx > dy){
					
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
						
						paint.plotPixel(x, y, bi);
						//adiciona nos arraylists(Jtable)
						pontosX.add(Math.round(x));
					    pontosY.add(Math.round(y));
					}
					
				}
			
			//Condição para o quinto oitante
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
						
						paint.plotPixel(x, y, bi);
						//adiciona nos arraylists(Jtable)
						pontosX.add(Math.round(x));
					    pontosY.add(Math.round(y));
					}
					
				//Condição para o sexto oitante	
				}else if(dx < dy){
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
						
						paint.plotPixel(x, y, bi);
						//adiciona nos arraylists(Jtable)
						pontosX.add(Math.round(x));
					    pontosY.add(Math.round(y));
					}
					
				}
			//Condição para o sétimo oitante
			}else if((x1 <= x2)&&(y1 > y2)){					
				
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
						
						paint.plotPixel(x, y, bi);
						//adiciona nos arraylists(Jtable)
						pontosX.add(Math.round(x));
					    pontosY.add(Math.round(y));
					}
					
				//Condição para o oitavo oitante	
				}else if(dx > dy){
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
						
						paint.plotPixel(x, y, bi);
						//adiciona nos arraylists(Jtable)
						pontosX.add(Math.round(x));
					    pontosY.add(Math.round(y));
					}
					
				}
				
			}
			
		}

}
