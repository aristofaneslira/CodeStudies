package Model;

public class Vertice {
	
	private Integer coordenadaX;
	private Integer coordenadaY;
	private Integer coordenadaZ;
	private Integer coordenadaW;
	
	
	/**
	 * Cria um vertice para coordenadas 2D com os valores de x, y e z
	 * @param x
	 * @param y
	 */
	public Vertice(Integer x, Integer y){
		this.coordenadaX = x;
		this.coordenadaY = y;
		this.coordenadaW = 1;
	}
	
	/**
	 * Cria um vertice para coordenadas 3D com os valores de x, y e z
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vertice(Integer x, Integer y, Integer z){
		this.coordenadaX = x;
		this.coordenadaY = y;
		this.coordenadaZ = z;
		this.coordenadaW = 1;
	}
	
	/**
	 * Cria um vertice para coordenadas 3D com os valores de x, y, z e w
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */
	public Vertice(Integer x, Integer y, Integer z, Integer w){
		this.coordenadaX = x;
		this.coordenadaY = y;
		this.coordenadaZ = z;
		this.coordenadaW = w;
	}
	
	public Integer getCoordenadaX() {
		return coordenadaX;
	}
	
	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	
	public Integer getCoordenadaY() {
		return coordenadaY;
	}
	
	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	public Integer getCoordenadaZ() {
		return coordenadaZ;
	}
	
	public void setCoordenadaZ(int coordenadaZ) {
		this.coordenadaZ = coordenadaZ;
	}
	
	public Integer getCoordenadaW() {
		return coordenadaW;
	}
	
	public void setCoordenadaW(int coordenadaW) {
		this.coordenadaW = coordenadaW;
	}
	
}
