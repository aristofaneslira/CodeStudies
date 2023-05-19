package Operadores;

public class OperacaoReflexao implements Operador{
	
	private String nomeOperacao = "Reflex�o";
	private String valoresOperacao;
	private double[][] operadorReflexao = new double[3][3];
	
	/**
	 * Construtor - Recebe variaveis do operador de reflex�o para mont�-lo e o nome do tipo de  opera��o de
	 * reflex�o
	 * @param x
	 * @param y
	 * @param a
	 * @param b
	 * @param operacao
	 */
	public OperacaoReflexao(double x, double y, double a, double b, String operacao){
		
		valoresOperacao = operacao;
		
		//PREENCHE OPERADOR DE REFLEX�O
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
	 * Retorna operador de reflex�o
	 */
	@Override
	public double[][] getOperador() {
		return this.operadorReflexao;
	}
	/**
	 * Retorna nome da opera��o
	 */
	@Override
	public String getNomeOperacao() {
		return this.nomeOperacao;
	}
	/**
	 * Retorna valor das vari�veis de reflex�o (Como n�o existe, retorna o nome da opera��o)
	 */
	@Override
	public String getValores() {
		return this.valoresOperacao;
	}

}
