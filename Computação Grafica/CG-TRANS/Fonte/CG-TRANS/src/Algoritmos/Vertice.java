package Algoritmos;

public class Vertice {
	private int coordX;
	private int coordY;
	private int coordW;
	
	/**
	 * Construtor - recebe as coordenadas do vértice
	 * @param X
	 * @param Y
	 */
	public Vertice(int X, int Y){
		this.coordX = X;
		this.coordY = Y;
		this.coordW = 1;
	}

	/**
	 * Retorna a coordenada X do vértice
	 * @return
	 */
	public int getCoordX() {
		return coordX;
	}

	/**
	 * Retorna a coordenada Y do vértice
	 * @return
	 */
	public int getCoordY() {
		return coordY;
	}

	/**
	 * Retorna a coordenada W do vértice
	 * @return
	 */
	public int getCoordW() {
		return coordW;
	}
	

}
