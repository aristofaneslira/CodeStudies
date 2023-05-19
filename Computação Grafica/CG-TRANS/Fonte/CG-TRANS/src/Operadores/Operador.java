package Operadores;

public interface Operador {

	/**
	 * Retorna o Operador de transformação
	 * @return
	 */
	public double[][] getOperador();
	/**
	 * Retorna o nome da operação
	 * @return
	 */
	public String getNomeOperacao();
	/**
	 * Retorna o valor das variáveis da operação
	 * @return
	 */
	public String getValores();
	}
