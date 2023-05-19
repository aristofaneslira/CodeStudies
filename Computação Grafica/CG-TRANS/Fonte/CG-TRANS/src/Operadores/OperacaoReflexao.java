package Operadores;

public class OperacaoReflexao implements Operador{
	
	private String nomeOperacao = "Reflexão";
	private String valoresOperacao;
	private double[][] operadorReflexao = new double[3][3];
	
	/**
	 * Construtor - Recebe variaveis do operador de reflexão para montá-lo e o nome do tipo de  operação de
	 * reflexão
	 * @param x
	 * @param y
	 * @param a
	 * @param b
	 * @param operacao
	 */
	public OperacaoReflexao(double x, double y, double a, double b, String operacao){
		
		valoresOperacao = operacao;
		
		//PREENCHE OPERADOR DE REFLEXÃO
		operadorReflexao[0][0] = x;
		operadorReflexao[0][1] = a; 
		operadorReflexao[0][2] = 0; 
		operadorReflexao[1][0] = b; 
		operadorReflexao[1][1] = y;
		operadorReflexao[1][2] = 0; 
		operadorReflexao[2][0] = 0;
		operadorReflexao[2][1] = 0;
		operadorReflexao[2][2] = 1;
		
	
	}
		
	/**
	 * Retorna operador de reflexão
	 */
	@Override
	public double[][] getOperador() {
		return this.operadorReflexao;
	}
	/**
	 * Retorna nome da operação
	 */
	@Override
	public String getNomeOperacao() {
		return this.nomeOperacao;
	}
	/**
	 * Retorna valor das variáveis de reflexão (Como não existe, retorna o nome da operação)
	 */
	@Override
	public String getValores() {
		return this.valoresOperacao;
	}

}
