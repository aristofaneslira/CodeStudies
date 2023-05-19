package Operadores;

public class OperacaoCisalhamento implements Operador{
	private String nomeOperacao = "Cisalhamento";
	private String valoresOperacao;
	private double[][] operadorCisalhamento = new double[3][3];
	private double[][] operadorSemiFinal = new double[3][3];
	private OperacoesMatriz opMatriz = new OperacoesMatriz();
	
	/**
	 * Construtor - recebe fator de cisalhamento para montar o operador de cisalhamento, e as coordenadas
	 * do ponto fixo X e Y, necessários para a operação de translação
	 * @param CisX
	 * @param CisY
	 * @param pontoFixoX
	 * @param pontoFixoY
	 */
	public OperacaoCisalhamento(double CisX, double CisY, double pontoFixoX, double pontoFixoY){
		
	valoresOperacao = "a: "+ CisX + " b: " + CisY;
		
		
		//PREENCHE OPERADOR DE CISALHAMENTO
		operadorCisalhamento[0][0] = 1;
		operadorCisalhamento[0][1] = CisX;
		operadorCisalhamento[0][2] = 0; 
		operadorCisalhamento[1][0] = CisY;
		operadorCisalhamento[1][1] = 1;
		operadorCisalhamento[1][2] = 0; 
		operadorCisalhamento[2][0] = 0;
		operadorCisalhamento[2][1] = 0;
		operadorCisalhamento[2][2] = 1;
		
		// CRIA TRANSFORMAÇÕES DE TRANSLAÇÃO PARA ORIGEM E DE VOLTA AO PONTO INICIAL
		OperacaoTranslacao opTranslacaoOrigem = new OperacaoTranslacao(-pontoFixoX, -pontoFixoY);
		OperacaoTranslacao opTranslacaoVolta = new OperacaoTranslacao(pontoFixoX, pontoFixoY);
		
		//MULTIPLICA OPERADOR DE TRANSLACAO DE VOLTA AO PONTO INICIAL PELO OPERADOR CISALHAMENTO
		operadorSemiFinal = opMatriz.multiplicacaoOperadores(opTranslacaoVolta.getOperador(), operadorCisalhamento);
		
		//MULTIPLICA O RESULTADO DA OPERAÇÃO ANTERIOR PELO OPERADOR DE TRANSLAÇÃO PARA ORIGEM
		operadorCisalhamento = opMatriz.multiplicacaoOperadores(operadorSemiFinal, opTranslacaoOrigem.getOperador());
	
		
	}
	
	
	
	
	/**
	 * Retorna operador de Cisalhamenho
	 */
	@Override
	public double[][] getOperador() {
		return operadorCisalhamento;
	}
	
	/**
	 * Retorna nome da operação
	 */
	@Override
	public String getNomeOperacao() {
		return nomeOperacao;
	}
	/**
	 * Retorna valor dos fatores de cisalhamento
	 */
	@Override
	public String getValores() {
		return valoresOperacao;
	}

}
