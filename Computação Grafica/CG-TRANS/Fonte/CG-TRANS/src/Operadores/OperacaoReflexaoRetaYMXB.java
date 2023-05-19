package Operadores;

public class OperacaoReflexaoRetaYMXB implements Operador{

	private String nomeOperacao = "Reflex. Y=mx+b";
	private String valoresOperacao;
	private double[][] operadorSemiFinal = new double[3][3];
	private double[][] operadorReflexao = new double[3][3];
	private double[][] operadorRotacaoNegativa = new double[3][3];
	private double[][] operadorRotacaoPositiva = new double[3][3];
	private OperacoesMatriz opMatriz = new OperacoesMatriz();

	/**
	 * Construtor, recebe o valor da vari�bel M e B passados pelo usu�rio para montar
	 * o operador de Reflex�o
	 * @param m
	 * @param b
	 */
	public OperacaoReflexaoRetaYMXB(double m, double b){
		
		valoresOperacao = "m: "+m+" b: "+b;
		double cos0 = 1 / Math.sqrt(Math.pow(m, 2) +1);
		double sen0 = m / Math.sqrt(Math.pow(m, 2) +1);
		
		//CRIA OPERADORES DE TRANSLA��O (ORIGEM E DE VOLTA)
		OperacaoTranslacao translacaoVolta = new OperacaoTranslacao(0, b);
		OperacaoTranslacao translacaoOrigem = new OperacaoTranslacao(0, -b);
		
		//PREENCHE OPERADOR DE ROTA��O NEGATIVA
		operadorRotacaoNegativa[0][0] = cos0;
		operadorRotacaoNegativa[0][1] = sen0;
		operadorRotacaoNegativa[0][2] = 0;
		operadorRotacaoNegativa[1][0] = -sen0;
		operadorRotacaoNegativa[1][1] = cos0;
		operadorRotacaoNegativa[1][2] = 0; 
		operadorRotacaoNegativa[2][0] = 0;
		operadorRotacaoNegativa[2][1] = 0;
		operadorRotacaoNegativa[2][2] = 1;
		
		//PREENCHE OPERADOR DE ROTA��O POSITIVA
		operadorRotacaoPositiva[0][0] = cos0;
		operadorRotacaoPositiva[0][1] = -sen0;
		operadorRotacaoPositiva[0][2] = 0;
		operadorRotacaoPositiva[1][0] = sen0;
		operadorRotacaoPositiva[1][1] = cos0;
		operadorRotacaoPositiva[1][2] = 0; 
		operadorRotacaoPositiva[2][0] = 0;
		operadorRotacaoPositiva[2][1] = 0;
		operadorRotacaoPositiva[2][2] = 1;
		
		//CRIA OPERA��O DE REFLEXAO EM TORNO DE X
		OperacaoReflexao opReflexaoEmX = new OperacaoReflexao(1, -1, 0, 0, "X");
		
		//OPERA��O DE MULTIPLICA��O (INVERSA) ENTRE OS OPERADORES
		operadorSemiFinal = opMatriz.multiplicacaoOperadores(translacaoVolta.getOperador(), operadorRotacaoPositiva);
		operadorReflexao = opMatriz.multiplicacaoOperadores(operadorSemiFinal, opReflexaoEmX.getOperador());
		operadorSemiFinal = opMatriz.multiplicacaoOperadores(operadorReflexao, operadorRotacaoNegativa);
		operadorReflexao = opMatriz.multiplicacaoOperadores(operadorSemiFinal, translacaoOrigem.getOperador());	
		//------------- OPERADOR DE REFLEX�O EM TORNO DA RETA Y=MX+B CRIADO ---------------//
	}
	
	
	/**
	 * Retorna operador de reflex�o em torno da reta Y=mx+b
	 */
	@Override
	public double[][] getOperador() {
		return operadorReflexao;
	}
	/**
	 * Retorna nome da opera��o
	 */
	@Override
	public String getNomeOperacao() {
		return nomeOperacao;
	}
	/**
	 * Retorna valor das vari�veis de reflex�o
	 */
	@Override
	public String getValores() {
		return valoresOperacao;
	}

}
