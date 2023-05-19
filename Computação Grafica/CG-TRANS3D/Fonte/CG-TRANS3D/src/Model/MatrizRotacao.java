package Model;

import java.util.ArrayList;

public class MatrizRotacao {
	
	private Matriz matrizRotacao;
	
	/**
	 * Cria a Matriz de Rotação 3D de acordo com o eixo passado como parametro
	 * @param angulo
	 * @param eixo
	 */
	public MatrizRotacao(double angulo, String eixo) {
		
		switch (eixo) {
		case "x":
			criaMatrizRotacaoEmX(angulo);
			
			break;
		case "y":
			matrizRotacaoEmY(angulo);
			
			break;
		case "z":
			matrizRotacaoEmZ(angulo);
			
			break;

		default:
			break;
		}
		
	}
	
	/**
	 * Cria uma matriz de Rotação no Eixo X
	 * @param angulo
	 */
	private void criaMatrizRotacaoEmX(double angulo) {
		
		// Converte o angulo de Graus para Radiano
		angulo = Math.toRadians(angulo);
		
		// Calcula o Seno e o Cosseno do Angulo convertido em Radianos
		double senO = Math.sin(angulo);
		double cosO = Math.cos(angulo);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizRotacao.adicionarNumero(1, 0, 0);
		matrizRotacao.adicionarNumero(0, 1, 0);
		matrizRotacao.adicionarNumero(0, 2, 0);
		matrizRotacao.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizRotacao.adicionarNumero(   0, 0, 1);
		matrizRotacao.adicionarNumero(cosO, 1, 1);
		matrizRotacao.adicionarNumero(senO, 2, 1);
		matrizRotacao.adicionarNumero(   0, 3, 1);

		// Adiciona a coluna 3 da matriz de Translação
		matrizRotacao.adicionarNumero(    0, 0, 2);
		matrizRotacao.adicionarNumero(-senO, 1, 2);
		matrizRotacao.adicionarNumero( cosO, 2, 2);
		matrizRotacao.adicionarNumero(    0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 3);
		matrizRotacao.adicionarNumero(0, 1, 3);
		matrizRotacao.adicionarNumero(0, 2, 3);
		matrizRotacao.adicionarNumero(1, 3, 3);
		
	}
	
	/**
	 * Cria uma matriz de Rotação no Eixo Y
	 * @param angulo
	 */
	private void matrizRotacaoEmY(double angulo) {
		
		// Converte o angulo de Graus para Radiano
		angulo = Math.toRadians(angulo);
		
		// Calcula o Seno e o Cosseno do Angulo convertido em Radianos
		double senO = Math.sin(angulo);
		double cosO = Math.cos(angulo);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizRotacao.adicionarNumero( cosO, 0, 0);
		matrizRotacao.adicionarNumero(    0, 1, 0);
		matrizRotacao.adicionarNumero(-senO, 2, 0);
		matrizRotacao.adicionarNumero(    0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 1);
		matrizRotacao.adicionarNumero(1, 1, 1);
		matrizRotacao.adicionarNumero(0, 2, 1);
		matrizRotacao.adicionarNumero(0, 3, 1);

		// Adiciona a coluna 3 da matriz de Translação
		matrizRotacao.adicionarNumero(senO, 0, 2);
		matrizRotacao.adicionarNumero(   0, 1, 2);
		matrizRotacao.adicionarNumero(cosO, 2, 2);
		matrizRotacao.adicionarNumero(   0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 3);
		matrizRotacao.adicionarNumero(0, 1, 3);
		matrizRotacao.adicionarNumero(0, 2, 3);
		matrizRotacao.adicionarNumero(1, 3, 3);
		
	}
	
	/**
	 * Cria uma matriz de Rotação no Eixo Z
	 * @param angulo
	 */
	private void matrizRotacaoEmZ(double angulo) {
		// Converte o angulo de Graus para Radiano
		angulo = Math.toRadians(angulo);
		
		// Calcula o Seno e o Cosseno do Angulo convertido em Radianos
		double senO = Math.sin(angulo);
		double cosO = Math.cos(angulo);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizRotacao.adicionarNumero(cosO, 0, 0);
		matrizRotacao.adicionarNumero(senO, 1, 0);
		matrizRotacao.adicionarNumero(   0, 2, 0);
		matrizRotacao.adicionarNumero(   0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizRotacao.adicionarNumero(-senO, 0, 1);
		matrizRotacao.adicionarNumero( cosO, 1, 1);
		matrizRotacao.adicionarNumero(    0, 2, 1);
		matrizRotacao.adicionarNumero(    0, 3, 1);

		// Adiciona a coluna 3 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 2);
		matrizRotacao.adicionarNumero(0, 1, 2);
		matrizRotacao.adicionarNumero(1, 2, 2);
		matrizRotacao.adicionarNumero(0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 3);
		matrizRotacao.adicionarNumero(0, 1, 3);
		matrizRotacao.adicionarNumero(0, 2, 3);
		matrizRotacao.adicionarNumero(1, 3, 3);
		
	}
	
	public Matriz getMatriz() {
		return matrizRotacao;
	}
	
	public void setMatriz(Matriz matrizRotacao) {
		this.matrizRotacao = matrizRotacao;
	}
	
	/**
	 * Adiciona a matriz de Rotação no arraylist passado como parametro
	 * @param matrizes
	 */
	public void adicionarMatrizNaLista(ArrayList<Matriz> matrizes) {
		matrizes.add(matrizRotacao);
		
	}
	
}
