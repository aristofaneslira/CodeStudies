package Operadores;



public class OperacaoTranslacao implements Operador{
	private String nomeOperacao = "Translação";
	private String valoresOperacao;
	private double[][] operadorTranslacao = new double[3][3];
	

	/**
	 * Construtor, recebe os fatores de translação e monta o operador
	 * @param tx
	 * @param ty
	 */
	public OperacaoTranslacao(double tx, double ty){
		
		valoresOperacao = "Tx: "+ tx + " Ty: " + ty;
		
		
		//PREENCHE OPERADOR DE TRANSLACAO
		operadorTranslacao[0][0] = 1;
		operadorTranslacao[0][1] = 0;
		operadorTranslacao[0][2] = tx; //tx
		operadorTranslacao[1][0] = 0;
		operadorTranslacao[1][1] = 1;
		operadorTranslacao[1][2] = ty; //ty
		operadorTranslacao[2][0] = 0;
		operadorTranslacao[2][1] = 0;
		operadorTranslacao[2][2] = 1;
		
	}


	/**
	 * Retorna Operador de Translação
	 */
	@Override
	public double[][] getOperador() {
		return operadorTranslacao;
	}

	/**
	 * Retorna nome da Operação
	 */
	@Override
	public String getNomeOperacao() {
		return nomeOperacao;
	}

	
	/**
	 * Retorna valor dos fatores de Translação
	 */
	@Override
	public String getValores() {
		return valoresOperacao;
	}

	
	
}
