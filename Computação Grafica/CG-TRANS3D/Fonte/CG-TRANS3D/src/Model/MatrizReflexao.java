package Model;

import java.util.ArrayList;

public class MatrizReflexao {

	private Matriz matrizReflexao;
	
	private ArrayList<Matriz> matrizesOperacoes;
	
	/**
	 * Cria uma Matriz de Reflexão
	 * @param a
	 * @param b
	 * @param c
	 */
	public MatrizReflexao(int a, int b, int c) {

		// Adiciona a coluna 1 da matriz de Translação
		matrizReflexao.adicionarNumero(a, 0, 0);
		matrizReflexao.adicionarNumero(0, 1, 0);
		matrizReflexao.adicionarNumero(0, 2, 0);
		matrizReflexao.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizReflexao.adicionarNumero(0, 0, 1);
		matrizReflexao.adicionarNumero(b, 1, 1);
		matrizReflexao.adicionarNumero(0, 2, 1);
		matrizReflexao.adicionarNumero(0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizReflexao.adicionarNumero(0, 0, 2);
		matrizReflexao.adicionarNumero(0, 1, 2);
		matrizReflexao.adicionarNumero(c, 2, 2);
		matrizReflexao.adicionarNumero(0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizReflexao.adicionarNumero(0, 0, 3);
		matrizReflexao.adicionarNumero(0, 1, 3);
		matrizReflexao.adicionarNumero(0, 2, 3);
		matrizReflexao.adicionarNumero(1, 3, 3);
		
	}
	
	public Matriz getMatriz() {
		return matrizReflexao;
	}
	
	public void setMatriz(Matriz matriz) {
		this.matrizReflexao = matriz;
	}
	
	/**
	 * Adiciona a matriz de Escala no arraylist passado como parametro
	 * @param matrizes
	 */
	public void adicionarMatrizNaLista(ArrayList<Matriz> matrizes) {
		
		matrizes.add(matrizReflexao);
		
	}
	
}
