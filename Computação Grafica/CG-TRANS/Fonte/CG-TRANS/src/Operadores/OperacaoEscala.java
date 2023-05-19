package Operadores;

public class OperacaoEscala implements Operador{

	private String nomeOperacao = "Escala";
	private String valoresOperacao;
	private double[][] operadorEscala = new double[3][3];
	private double[][] operadorSemiFinal = new double[3][3];
	private OperacoesMatriz opMatriz = new OperacoesMatriz();
	
	/**
	 * Construtor - recebe os fatores de escala SX e SY para montar o operador de escala e
	 * as coordenadas do ponto fixo X e Y, necessários para a operação de translação
	 * @param sx
	 * @param sy
	 * @param pontoFixoX
	 * @param pontoFixoY
	 */
	public OperacaoEscala(double sx, double sy, double pontoFixoX, double pontoFixoY){
		
		valoresOperacao = "Sx: "+ sx + " Sy: " + sy;
		
		//PREENCHE OPERADOR DE ESCALA INICIAL
		operadorEscala[0][0] = sx;
		operadorEscala[0][1] = 0;
		operadorEscala[0][2] = 0; 
		operadorEscala[1][0] = 0;
		operadorEscala[1][1] = sy;
		operadorEscala[1][2] = 0; 
		operadorEscala[2][0] = 0;
		operadorEscala[2][1] = 0;
		operadorEscala[2][2] = 1;
		
		// CRIA TRANSFORMAÇÕES DE TRANSLAÇÃO PARA ORIGEM E DE VOLTA AO PONTO INICIAL
		OperacaoTranslacao opTranslacaoOrigem = new OperacaoTranslacao(-pontoFixoX, -pontoFixoY);
		OperacaoTranslacao opTranslacaoVolta = new OperacaoTranslacao(pontoFixoX, pontoFixoY);
		
		//MULTIPLICA OPERADOR DE TRANSLACAO DE VOLTA AO PONTO INICIAL PELO OPERADOR ESCALA
		operadorSemiFinal = opMatriz.multiplicacaoOperadores(opTranslacaoVolta.getOperador(), operadorEscala);
		
		//MULTIPLICA O RESULTADO DA OPERAÇÃO ANTERIOR PELO OPERADOR DE TRANSLAÇÃO PARA ORIGEM
		operadorEscala = opMatriz.multiplicacaoOperadores(operadorSemiFinal, opTranslacaoOrigem.getOperador());
	
	}
	
	
	/**
	 * Retorna operador de Escala
	 */
	@Override
	public double[][] getOperador() {
		return operadorEscala;
	}
	/**
	 * Retorna nome da operação
	 */
	@Override
	public String getNomeOperacao() {
		return nomeOperacao;
	}
	/**
	 * Retorna valor dos fatores de Escala
	 */
	@Override
	public String getValores() {
		return valoresOperacao;
	}

}
