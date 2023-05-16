/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */
package lp2.lab08;

/**
 * Classe representando uma Peca de Domino.
 * 
 * @author Rodrigo
 *
 */

public class Peca {
	
	// Atributos da classe Peca.
	
	private int esquerda, direita;
	
	/**
	 * Contrutor de uma Peca de Domino.
	 * 
	 * @param esquerda
	 * 					Valor do lado esquerdo da Peca.
	 * @param direita
	 * 					Valor do lado direito da Peca
	 * @throws Exception
	 * 					Lanca excessao caso haja a tentativa de se criar uma peca com lado de valor maio que 6 ou menor que 0.
	 */
	
	public Peca(int esquerda, int direita) throws Exception {
		if (esquerda > 6 || esquerda < 0 || direita > 6 || direita < 0)
			throw new Exception("Uma peca de domino nao possui um lado de valor maior que 6 ou menor que 0.");
		
		this.esquerda = esquerda;
		this.direita = direita;
	}

	/**
	 * Metodo acessador do valor do lado esquerdo da Peca.
	 * 
	 * @return Retorna o valor do lado esquerdo da Peca.
	 */
	
	public int getEsquerda() {
		return esquerda;
	}
	
	/**
	 * Metodo acessador do valor do lado direito da Peca.
	 * 
	 * @return Retorna o valor do lado direito da Peca.
	 */

	public int getDireita() {
		return direita;
	}
	
	/**
	 * Metodo para saber o valor da peca (soma dos valores do lado esquerdo e direito.
	 * 
	 * @return Retorna O valor da Peca, ou seja, a soma dos seus dois lados.
	 */
	
	public int valorDePeca() {
		return getEsquerda() + getDireita();
	}
	
	/**
	 * Metodo para saber se um peca e compativel (se podem ser postas juntas no jogo). Exemplo |3 - 2| é compativel com |3 - 1| e |2 - 1| e não é compativel
	 * com |4 - 5|.
	 * 
	 * @param peca
	 * 				Peca a ser comarada com esta peca.
	 * @return Retorna true caso seja compativel e false caso contrario.
	 */
	
	public boolean compativelCom(Peca peca) {
		if (getDireita() == peca.getDireita() || getDireita() == peca.getEsquerda() ||
			getEsquerda() == peca.getDireita() || getEsquerda() == peca.getEsquerda())
			return true;
		return false;
	}
	
	/**
	 * Verifica se duas pecas sao iguais. Duas pecas sao iguas quando possuem os valores de ambos os lados iguais.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Peca))
			return false;
		Peca peca = (Peca) obj;
		return getEsquerda() == peca.getEsquerda() && getDireita() == peca.getDireita() ||
				getEsquerda() == peca.getDireita() && getDireita() == peca.getEsquerda();
	}
	
	/**
	 * Representacao de uma peca no formato de String.
	 * 
	 * @return retorna a peca no formato de uma string.
	 */
	
	@Override
	public String toString() {
		return "|" + getEsquerda() + " - " + getDireita() + "|";
	}
	
	/**
	 * Compara um peca a esta peca.
	 * 
	 * @param peca
	 * 				Peca a ser comparda com esta.
	 * @return Retorna a diferenca entre uma peca e esta peca..
	 */
	
	public int compareTo(Peca peca) {
		return valorDePeca() - peca.valorDePeca();
	}
}