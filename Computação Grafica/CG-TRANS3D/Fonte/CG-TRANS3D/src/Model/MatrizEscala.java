package Model;

import java.util.ArrayList;

public class MatrizEscala {
	
	private Matriz matrizEscala;
	
	/**
	 * Cria uma Matriz de Translação 2D
	 * @param tX
	 * @param tY
	 */
	public MatrizEscala(double sX, double sY) {
		matrizEscala = new Matriz(3, 3);
		
		// Adiciona a coluna 1 da matriz de Escala
		matrizEscala.adicionarNumero(sX, 0, 0);
		matrizEscala.adicionarNumero( 0, 1, 0);
		matrizEscala.adicionarNumero( 0, 2, 0);
		
		// Adiciona a coluna 2 da matriz de Escala
		matrizEscala.adicionarNumero( 0, 0, 1);
		matrizEscala.adicionarNumero(sY, 1, 1);
		matrizEscala.adicionarNumero( 0, 2, 1);
		
		// Adiciona a coluna 3 da matriz de Escala
		matrizEscala.adicionarNumero(0, 0, 2);
		matrizEscala.adicionarNumero(0, 1, 2);
		matrizEscala.adicionarNumero(1, 2, 2);
		
	}
	
	/**
	 * Cria uma Matriz de Translação 3D
	 * @param tX
	 * @param tY
	 * @param tZ
	 */
	public MatrizEscala(double sX, double sY, double sZ) {
		
		matrizEscala = new Matriz(4, 4);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizEscala.adicionarNumero(sX, 0, 0);
		matrizEscala.adicionarNumero( 0, 1, 0);
		matrizEscala.adicionarNumero( 0, 2, 0);
		matrizEscala.adicionarNumero( 0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizEscala.adicionarNumero( 0, 0, 1);
		matrizEscala.adicionarNumero(sY, 1, 1);
		matrizEscala.adicionarNumero( 0, 2, 1);
		matrizEscala.adicionarNumero( 0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizEscala.adicionarNumero( 0, 0, 2);
		matrizEscala.adicionarNumero( 0, 1, 2);
		matrizEscala.adicionarNumero(sZ, 2, 2);
		matrizEscala.adicionarNumero( 0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizEscala.adicionarNumero(0, 0, 3);
		matrizEscala.adicionarNumero(0, 1, 3);
		matrizEscala.adicionarNumero(0, 2, 3);
		matrizEscala.adicionarNumero(1, 3, 3);
				
	}
	
	public Matriz getMatriz() {
		return matrizEscala;
	}
	
	public void setMatrizEscala(Matriz matriz) {
		this.matrizEscala = matriz;
	}
	
	/**
	 * Adiciona a matriz de Escala no arraylist passado como parametro
	 * @param matrizes
	 */
	public void adicionarMatrizNaLista(ArrayList<Matriz> matrizes) {
		
		matrizes.add(matrizEscala);
		
	}
	
}
