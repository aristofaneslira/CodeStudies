package Algoritmos;

public class RetasRecorte {
	private int X1;
	private int X2;
	private int Y1;
	private int Y2;
	
	/**
	 * Construtor - Recebe a coordenada dos extremos da reta
	 * @param X1
	 * @param Y1
	 * @param X2
	 * @param Y2
	 */
	public RetasRecorte(int X1, int Y1, int X2, int Y2){
		this.X1 = X1;
		this.Y1 = Y1;
		this.X2 = X2;
		this.Y2 = Y2;
	}

	/**
	 * Retorna a coordenada X1
	 * @return
	 */
	public int getX1() {
		return X1;
	}
	
	/**
	 * Recebe a nova coordenada X1 (recortada) e a substitui
	 * @param x1
	 */
	public void setX1(int x1) {
		X1 = x1;
	}
	/**
	 * Retorna a coordenada X2
	 * @return
	 */
	public int getX2() {
		return X2;
	}

	/**
	 * Recebe a nova coordenada X2 (recortada) e a substitui
	 * @param x2
	 */
	public void setX2(int x2) {
		X2 = x2;
	}
	/**
	 * Retorna a coordenada Y1
	 * @return
	 */
	public int getY1() {
		return Y1;
	}
	/**
	 * Recebe a nova coordenada Y1 (recortada) e a substitui
	 * @param y1
	 */
	public void setY1(int y1) {
		Y1 = y1;
	}
	/**
	 * Retorna a coordenada Y2
	 * @return
	 */
	public int getY2() {
		return Y2;
	}

	/**
	 * Recebe a nova coordenada Y2 (recortada) e a substitui
	 * @param y2
	 */
	public void setY2(int y2) {
		Y2 = y2;
	}
	
}
