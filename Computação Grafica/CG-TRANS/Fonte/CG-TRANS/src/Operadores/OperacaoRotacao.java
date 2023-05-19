package Operadores;


public class OperacaoRotacao implements Operador{
	
	private String nomeOperacao = "Rota豫o";
	private String valoresOperacao;
	private double[][] operadorRotacao = new double[3][3];
	private double[][] operadorSemiFinal = new double[3][3];
	private OperacoesMatriz opMatriz = new OperacoesMatriz();
	
	public OperacaoRotacao(double angulo, double pontoFixoX, double pontoFixoY){
		
		valoresOperacao = "혂gulo: " + angulo+"�";
		
		angulo = Math.toRadians(angulo);
		double senAngulo = Math.sin(angulo);
		double cosAngulo = Math.cos(angulo);
	
		
		//PREENCHE OPERADOR DE ROTA플O
		operadorRotacao[0][0] = cosAngulo;
		operadorRotacao[0][1] = -senAngulo;
		operadorRotacao[0][2] = 0;
		operadorRotacao[1][0] = senAngulo;
		operadorRotacao[1][1] = cosAngulo;
		operadorRotacao[1][2] = 0; 
		operadorRotacao[2][0] = 0;
		operadorRotacao[2][1] = 0;
		operadorRotacao[2][2] = 1;
		
	
		// CRIA TRANSFORMA합ES DE TRANSLA플O PARA ORIGEM E DE VOLTA AO PONTO INICIAL
		OperacaoTranslacao opTranslacaoOrigem = new OperacaoTranslacao(-pontoFixoX, -pontoFixoY);
		OperacaoTranslacao opTranslacaoVolta = new OperacaoTranslacao(pontoFixoX, pontoFixoY);
		
		//MULTIPLICA OPERADOR DE TRANSLACAO DE VOLTA AO PONTO INICIAL PELO OPERADOR ROTA플O
		operadorSemiFinal = opMatriz.multiplicacaoOperadores(opTranslacaoVolta.getOperador(), operadorRotacao);
		
		//MULTIPLICA O RESULTADO DA OPERA플O ANTERIOR PELO OPERADOR DE TRANSLA플O PARA ORIGEM
		operadorRotacao = opMatriz.multiplicacaoOperadores(operadorSemiFinal, opTranslacaoOrigem.getOperador());
		System.out.print("----OPERADOR ROTA플O----");
		opMatriz.imprimeMatriz(operadorRotacao);
		System.out.println();
		System.out.println("---FIM OPERADOR ROTA플O---");
	}
	
	@Override
	public double[][] getOperador() {
		return this.operadorRotacao;
	}

	@Override
	public String getNomeOperacao() {
		return this.nomeOperacao;
	}

	@Override
	public String getValores() {
		return this.valoresOperacao;
	}

}
