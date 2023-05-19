package Algoritmos;

public class Vertice {
	private int coordX;
	private int coordY;
	private int coordW;
	
	/**
	 * Construtor - recebe as coordenadas do v�rtice
	 * @param X
	 * @param Y
	 */
	public Vertice(int X, int Y){
		this.coordX = X;
		this.coordY = Y;
		this.coordW = 1;
	}

	/**
	 * Retorna a coordenada X do v�rtice
	 * @return
	 */
	public int getCoordX() {
		return coordX;
	}

	/**
	 * Retorna a coordenada Y do v�rtice
	 * @return
	 */
	public int getCoordY() {
		return coordY;
	}

	/**
	 * Retorna a coordenada W do v�rtice
	 * @return
	 */
	public int getCoordW() {
		return coordW;
	}
	

}
