package Operadores;

public interface Operador {

	/**
	 * Retorna o Operador de transforma��o
	 * @return
	 */
	public double[][] getOperador();
	/**
	 * Retorna o nome da opera��o
	 * @return
	 */
	public String getNomeOperacao();
	/**
	 * Retorna o valor das vari�veis da opera��o
	 * @return
	 */
	public String getValores();
	}
