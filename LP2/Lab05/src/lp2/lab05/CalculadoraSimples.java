package lp2.lab05;

/**
 * Classe que representa uma calculadora simples.
 * 
 * @author Rodrigo
 *
 */

public class CalculadoraSimples {
	
	private int memoria;
	
	/**
	 * Construtor de uma calculadora simples.
	 */
	
	public CalculadoraSimples() {
		memoria = 0;
	}
	
	/**
	 * Realiza uma soma.
	 * 
	 * @param i
	 * 			Valor inteiro.
	 * @param j
	 * 			Valor inteiro.
	 * @return Resultado da soma entre i e j.
	 */

	public int soma(int i, int j) {
		return i + j;
	}
	
	/**
	 * Realiza uma subtracao.
	 * 
	 * @param i
	 * 			Valor inteiro.
	 * @param j
	 * 			Valor inteiro.
	 * @return Resultado da subtracao entre i e j.
	 */

	public int subtracao(int i, int j) {
		return i - j;
	}
	
	/**
	 * Realiza uma multiplicacao.
	 * 
	 * @param i
	 * 			Valor inteiro.
	 * @param j
	 * 			Valor inteiro.
	 * @return Resultado da multiplicacao entre i e j.
	 */
	
	public int multiplicacao(int i, int j) {
		return i * j;
	}
	
	/**
	 * Realiza uma divisao.
	 * 
	 * @param i
	 * 			Valor inteiro.
	 * @param j
	 * 			Valor inteiro.
	 * @return Resultado da divisao de i por j ou -1 se j for igual a 0.
	 */

	public int divisao(int i, int j) {
		if (j == 0)
			return -1;
		return i / j;
	}
	
	/**
	 * Armazena um valor na memoria
	 * 
	 * @param i
	 * 			Valor inteiro.
	 */

	public void memorySave(int i) {
		memoria = i;
	}
	
	/**
	 * Recupera um valor salvo na memoria.
	 * 
	 * @return Valor salvo na memoria.
	 */
	
	public int memoryRecovery() {
		return memoria;
	}
	
	/**
	 * Limpa a memoria.
	 */
	
	public void memoryClean() {
		memoria = 0;
	}
	
	/**
	 * Soma i ao valor existente na memoria.
	 * 
	 * @param i
	 * 			Valor inteiro.
	 */
	
	public void memoryMais(int i) {
		memoria += i;
	}
}
