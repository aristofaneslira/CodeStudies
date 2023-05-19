package Model;

import java.util.ArrayList;

public class OperacoesMatrizes {
	
	private ArrayList<Matriz> matrizes = new ArrayList<Matriz>();
	private Matriz matrizResultante;
	
	/**
	 * Adiciona a Matriz passada como parametro na lista de matrizes
	 * @param matriz
	 */
	public void adicionarMatriz(Matriz matriz) {
		
		matrizes.add(matriz);
		
	}
	
	/**
	 * Multiplica as matrizes para obter a matriz Operadora
	 * @return
	 */
	public Matriz calcularMatrizes() {
		
		// Define o primeiro elemento
		matrizResultante = matrizes.get(matrizes.size()-1);
		
		for (int i = matrizes.size()-2; i >= 0; i--) {
			// Multiplica a matriz "i" pela matriz "i+1"
			matrizes.get(i).multiplicarMatrizPor(matrizes.get(i+1));
			
			
			matrizResultante = matrizes.get(i);
			
		}
		
		return matrizResultante;
	}
	
}
