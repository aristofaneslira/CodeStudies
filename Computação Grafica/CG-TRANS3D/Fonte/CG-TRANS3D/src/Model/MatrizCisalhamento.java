package Model;

import java.util.ArrayList;

public class MatrizCisalhamento {

	private Matriz matrizCisalhamento;
	
	/**
	 * Cria uma Matriz de Cisalhamento 3D
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 */
	public MatrizCisalhamento(double a, double b, double c, double d, double e, double f) {
		
		matrizCisalhamento = new Matriz(4, 4);

		// Adiciona a coluna 1 da matriz de Translação
		matrizCisalhamento.adicionarNumero(1, 0, 0);
		matrizCisalhamento.adicionarNumero(a, 1, 0);
		matrizCisalhamento.adicionarNumero(b, 2, 0);
		matrizCisalhamento.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizCisalhamento.adicionarNumero(c, 0, 1);
		matrizCisalhamento.adicionarNumero(1, 1, 1);
		matrizCisalhamento.adicionarNumero(d, 2, 1);
		matrizCisalhamento.adicionarNumero(0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizCisalhamento.adicionarNumero(e, 0, 2);
		matrizCisalhamento.adicionarNumero(f, 1, 2);
		matrizCisalhamento.adicionarNumero(1, 2, 2);
		matrizCisalhamento.adicionarNumero(0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizCisalhamento.adicionarNumero(0, 0, 3);
		matrizCisalhamento.adicionarNumero(0, 1, 3);
		matrizCisalhamento.adicionarNumero(0, 2, 3);
		matrizCisalhamento.adicionarNumero(1, 3, 3);
		
	}
	
	public Matriz getMatriz() {
		return matrizCisalhamento;
	}
	
	public void setMatriz(Matriz matriz) {
		this.matrizCisalhamento = matriz;
	}
	
	/**
	 * Adiciona a matriz de Translação no arraylist passado como parametro
	 * @param matrizes
	 */
	public void adicionarMatrizNaLista(ArrayList<Matriz> matrizes) {
		
		matrizes.add(matrizCisalhamento);
		
	}
	
}
