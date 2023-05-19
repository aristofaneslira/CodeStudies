package Grafico;

public class DadosGrafico {
	
	private String dado;
	private int valor;
	private double porcentagem;
	
	/**
	 * Construtor, recebe os dados do gráfico
	 * @param dado
	 * @param valor
	 * @param porcentagem
	 */
	public DadosGrafico(String dado, int valor, double porcentagem) {
		this.dado = dado;
		this.valor = valor;
		this.porcentagem = porcentagem;
		
	}
	/**
	 * Retorna o nome do dado
	 * @return
	 */
	public String getDado() {
		return dado;
	}
	
	/**
	 * Retorna o valor (frequencia) dos dados
	 * @return
	 */
	public int getValor() {
		return valor;
	}
	
	/**
	 * Retorna a porcentagem dos dados
	 * @return
	 */
	public double getPorcentagem() {
		return porcentagem;
	}
	
}

