package Model;

import java.util.ArrayList;


public class Matriz {
	private double[][] matriz;
	
	private int numeroLinhas;
	private int numeroColunas;
	
	/**
	 * Cria Matriz determinando a quantidade de linhas e colunas
	 * @param linhas
	 * @param colunas
	 */
	public Matriz(int linhas, int colunas) {
		this.matriz = new double[linhas][colunas];
		this.numeroLinhas = linhas;
		this.numeroColunas = colunas;
		
	}
	
	/**
	 * Cria Matriz a partir de um ArrayList de Vertices
	 * @param vertices
	 */
	public Matriz(ArrayList<Vertice> vertices) {
		int linhas;
		if (vertices.get(0).getCoordenadaZ() == null) {
			linhas = 3;
		} else {
			linhas = 4;
		}
		
		int colunas = vertices.size();
		
		this.matriz = new double[linhas][colunas];
		this.numeroLinhas = linhas;
		this.numeroColunas = colunas;
		
		// Adicionando os vertices na matriz Homogenea
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				if (i == 0) {
					// Se estiver na Primeira Linha (Linha 0), adiciona as coordenadas X
					adicionarNumero(vertices.get(j).getCoordenadaX(), i, j);
					
				} else if (i == 1) {
					// Se estiver na Segunda Linha (Linha 1), adiciona as coordenadas Y
					adicionarNumero(vertices.get(j).getCoordenadaY(), i, j);
					
				} else {
					// Se o objeto for um vertice 2D adiciona a Terceira linha o valor da coordenada W
					if (linhas == 3) {
						// Se estiver na Terceira Linha (Linha 2), adiciona as coordenadas W
						adicionarNumero(vertices.get(j).getCoordenadaW(), i, j);
						
					} else if (linhas == 4) {
						// Se o objeto for um vertice 3D adiciona a Terceira linha o valor da coordenada Z
						if (i == 2) {
							// Se estiver na Terceira Linha (Linha 2), adiciona as coordenadas z
							adicionarNumero(vertices.get(j).getCoordenadaZ(), i, j);
							
						} else {
							// Se estiver na Quarta Linha (Linha 3), adiciona as coordenadas W
							adicionarNumero(vertices.get(j).getCoordenadaW(), i, j);
							
						}
					}
				}
			}
		}
		
	}
	
	public double[][] getMatriz() {
		return matriz;
	}
	
	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}
	
	public int getNumeroLinhas() {
		return numeroLinhas;
	}
	
	public void setNumeroLinhas(int numeroLinhas) {
		this.numeroLinhas = numeroLinhas;
	}
	
	public int getNumeroColunas() {
		return numeroColunas;
	}
	
	public void setNumeroColunas(int numeroColunas) {
		this.numeroColunas = numeroColunas;
	}
	
	/**
	 * Adiciona um numero na matriz
	 * @param numero
	 * @param linha
	 * @param coluna
	 */
	public void adicionarNumero(double numero, int linha, int coluna){
		matriz[linha][coluna] = numero;
		
	}
	
	/**
	 * Retorna um array de inteiros com os itens da linha selecionada
	 * @param numerolinha
	 * @return
	 */
	public double[] getLinha(int numerolinha) {
		double[] matrizLinha = new double[numeroColunas];
		
		for (int i = 0; i < numeroColunas; i++) {
			matrizLinha[i] = matriz[numerolinha][i];
			
		}
		return matrizLinha;
		
	}
	
	/**
	 * Soma a matriz pela matrizM
	 * @param matrizM
	 */
	public void somarMatrizPor(Matriz matrizM) {
		Matriz matrizAuxiliar;
		if ((matrizM.getNumeroColunas() == numeroColunas) & (matrizM.getNumeroLinhas() == numeroLinhas)) {
			matrizAuxiliar = new Matriz(numeroLinhas, numeroColunas);
			
			double auxiliar;
			for (int i = 0; i < numeroLinhas; i++) {
				for (int j = 0; j < numeroColunas; j++) {
					auxiliar = matrizM.getMatriz()[i][j] + matriz[i][j];
					matrizAuxiliar.adicionarNumero(auxiliar, i, j);
				}
			}
			
			matriz = matrizAuxiliar.getMatriz();
			
		}
		
	}
	
	/**
	 * Subtrai a matriz pela matrizM
	 * @param matrizM
	 */
	public void subtrairMatrizPor(Matriz matrizM) {
		Matriz matrizAuxiliar;
		if ((matrizM.getNumeroColunas() == numeroColunas) & (matrizM.getNumeroLinhas() == numeroLinhas)) {
			matrizAuxiliar = new Matriz(numeroLinhas, numeroColunas);
			
			double auxiliar;
			for (int i = 0; i < numeroLinhas; i++) {
				for (int j = 0; j < numeroColunas; j++) {
					auxiliar = matriz[i][j] - matrizM.getMatriz()[i][j];
					matrizAuxiliar.adicionarNumero(auxiliar, i, j);
				}
			}
			
			matriz = matrizAuxiliar.getMatriz();
		}
	}
	
	/**
	 * Multiplica a Matriz pela matrizM
	 * @param matrizM
	 */
	public void multiplicarMatrizPor(Matriz matrizM){
		Matriz matrizAuxiliar;
		if (matrizM.getNumeroColunas() == numeroLinhas) {
			matrizAuxiliar = new Matriz(numeroLinhas, numeroColunas);
			
			double auxiliar;
			for (int i = 0; i < numeroLinhas; i++) {
				for (int j = 0; j < numeroColunas; j++) {
					auxiliar = 0;
					for (int k = 0; k < matrizM.getNumeroColunas(); k++) {
						auxiliar += matrizM.getMatriz()[i][k] * matriz[k][j];
					}
					matrizAuxiliar.adicionarNumero(auxiliar, i, j);
				}
			}
			
			matriz = matrizAuxiliar.getMatriz();
			
		}
		
	}
	
}

