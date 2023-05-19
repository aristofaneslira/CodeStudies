package Model;

import java.util.ArrayList;

public class MatrizTranslacao {
	
	private Matriz matrizTranslacao;
	
	/**
	 * Cria uma Matriz de Translação 2D
	 * @param tX
	 * @param tY
	 */
	public MatrizTranslacao(double tX, double tY) {
		matrizTranslacao = new Matriz(3, 3);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizTranslacao.adicionarNumero(1, 0, 0);
		matrizTranslacao.adicionarNumero(0, 1, 0);
		matrizTranslacao.adicionarNumero(0, 2, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizTranslacao.adicionarNumero(0, 0, 1);
		matrizTranslacao.adicionarNumero(1, 1, 1);
		matrizTranslacao.adicionarNumero(0, 2, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizTranslacao.adicionarNumero(tX, 0, 2);
		matrizTranslacao.adicionarNumero(tY, 1, 2);
		matrizTranslacao.adicionarNumero( 1, 2, 2);
		
	}
	
	/**
	 * Cria uma Matriz de Translação 3D
	 * @param tX
	 * @param tY
	 * @param tZ
	 */
	public MatrizTranslacao(double tX, double tY, double tZ) {
		
		matrizTranslacao = new Matriz(4, 4);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizTranslacao.adicionarNumero(1, 0, 0);
		matrizTranslacao.adicionarNumero(0, 1, 0);
		matrizTranslacao.adicionarNumero(0, 2, 0);
		matrizTranslacao.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizTranslacao.adicionarNumero(0, 0, 1);
		matrizTranslacao.adicionarNumero(1, 1, 1);
		matrizTranslacao.adicionarNumero(0, 2, 1);
		matrizTranslacao.adicionarNumero(0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizTranslacao.adicionarNumero(0, 0, 2);
		matrizTranslacao.adicionarNumero(0, 1, 2);
		matrizTranslacao.adicionarNumero(1, 2, 2);
		matrizTranslacao.adicionarNumero(0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizTranslacao.adicionarNumero(tX, 0, 3);
		matrizTranslacao.adicionarNumero(tY, 1, 3);
		matrizTranslacao.adicionarNumero(tZ, 2, 3);
		matrizTranslacao.adicionarNumero( 1, 3, 3);
		
	}
	
	public Matriz getMatriz() {
		return matrizTranslacao;
	}
	
	public void setMatriz(Matriz matriz) {
		this.matrizTranslacao = matriz;
	}
	
	/**
	 * Adiciona a matriz de Translação no arraylist passado como parametro
	 * @param matrizes
	 */
	public void adicionarMatrizNaLista(ArrayList<Matriz> matrizes) {
		
		matrizes.add(matrizTranslacao);
		
	}
	
}
