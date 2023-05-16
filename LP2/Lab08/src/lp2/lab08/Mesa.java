/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */
package lp2.lab08;

import java.util.*;

/**
 * Clase que representa uma Mesa de domino.
 * 
 * @author Rodrigo
 *
 */

public class Mesa {
	
	// Atributos da classe.
	
	private final int MESA_VAZIA = 0;
	private List<Peca> ladoEsquerdoDaMesa, ladoDireitoDaMesa;
	private int opcaoEsquerda, opcaoDireita;
	
	/**
	 * Construtor de um objeto Mesa.
	 */
	
	public Mesa() {
		ladoEsquerdoDaMesa = new ArrayList<Peca>();
		ladoDireitoDaMesa = new ArrayList<Peca>();
	}
	
	/**
	 * Metodo para adicionar uma Peca no lado esquerdo da Mesa.
	 * 
	 * @param peca
	 * 				Um objeto Peca a ser posto na Mesa.
	 * @return
	 * 				Retorna true se a Peca for adicionada e false caso contrario.
	 * @throws Exception
	 * 				Lanca uma excessao se houver a tentativa de jogar uma Peca incompativel com a Peca do lado esquerdo da mesa.
	 */
	
	public boolean addPecaNaEsquerda(Peca peca) throws Exception {
		
		// Verifica se a Peca a ser posta e a primeira Peca do jogo.
		
		if (numPecasJogadas() == MESA_VAZIA) {
			ladoEsquerdoDaMesa.add(peca);
			opcaoEsquerda = peca.getEsquerda();
			opcaoDireita = peca.getDireita();
			return true;
		}
		
		// Se nao for a primeira Peca do jogo,
		
		else {
			
			// verifica se e valido adicionar aquela Peca deste lado da Mesa.
			
			if (peca.getEsquerda() != opcaoEsquerda && peca.getDireita() != opcaoEsquerda)
				throw new Exception("Tentativa de realizar um movimento invalido.");
			
			if (peca.getDireita() == opcaoEsquerda) {
				ladoEsquerdoDaMesa.add(peca);
				opcaoEsquerda = peca.getEsquerda();
				return true;
			}
			else if (peca.getEsquerda() == opcaoEsquerda) {
				ladoEsquerdoDaMesa.add(girarPeca(peca));
				opcaoEsquerda = peca.getDireita();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo para adicionar uma Peca no lado direito da Mesa.
	 * 
	 * @param peca
	 * 				Um objeto Peca a ser posto na Mesa.
	 * @return
	 * 				Retorna true se a Peca for adicionada e false caso contrario.
	 * @throws Exception
	 * 				Lanca uma excessao se houver a tentativa de jogar uma Peca incompativel com a Peca do lado direito da mesa.
	 */
	
	public boolean addPecaNaDireita(Peca peca) throws Exception {
		
		// Verifica se a Peca a ser posta e a primeira Peca do jogo.
		
		if (numPecasJogadas() == MESA_VAZIA) {
			ladoDireitoDaMesa.add(peca);
			opcaoEsquerda = peca.getEsquerda();
			opcaoDireita = peca.getDireita();
			return true;
		}
		
		// Se nao for a primeira Peca do jogo,
		
		else {
			
			// verifica se e valido adicionar aquela Peca deste lado da Mesa.
			
			if (peca.getDireita() != opcaoDireita && peca.getEsquerda() != opcaoDireita)
				throw new Exception("Tentativa de realizar um movimento invalido.");
			
			if (peca.getEsquerda() == opcaoDireita) {
				ladoDireitoDaMesa.add(peca);
				opcaoDireita = peca.getDireita();
				return true;
			}
			else if (peca.getDireita() == opcaoDireita) {
				ladoDireitoDaMesa.add(girarPeca(peca));
				opcaoDireita = peca.getEsquerda();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo para acessar quantas Pecas ja foram jogadas.
	 * 
	 * @return Retorna o numero de pecas postas na mesa.
	 */
	
	public int numPecasJogadas() {
		return ladoDireitoDaMesa.size() + ladoEsquerdoDaMesa.size();
	}
	
	/**
	 * Opcao do lado esquerdo da mesa.
	 * 
	 * @return Retorna a opcao do lado esquerdo da mesa.
	 */
	
	public int getOpcaoEsquerda() {
		return opcaoEsquerda;
	}
	
	/**
	 * Opcao do lado direito da mesa.
	 * 
	 * @return Retorna a opcao do lado direito da mesa.
	 */
	
	public int getOpcaoDireita() {
		return opcaoDireita;
	}
	
	/**
	 * Representacao da mesa como String.
	 * 
	 * @return Retorna uma String com as pecas ja jogadas na Mesa, se alguma peca tiver sido posta na mesa.
	 */
	
	@Override
	public String toString() {
		String ladoEsquerdo = "", ladoDireito = "";
		Collections.reverse(ladoEsquerdoDaMesa);
		for (Peca peca : ladoEsquerdoDaMesa) {
			ladoEsquerdo += peca;
		}
		for (Peca peca2 : ladoDireitoDaMesa) {
			ladoDireito += peca2;
		}
		return ladoEsquerdo + ladoDireito;
	}
	
	/**
	 * Metodo que gira uma Peca compativel com o lado da Mesa que se quer jogar.
	 * 
	 * Uma peca pode ser compativel com o lado da mesa que se queira jogar, mas colocar |6 - 6||6 - 5| não e a mesma coisa de colocar
	 * |6 - 6||5 - 6|. Apesar de serem as mesmas pecas (apenas numa posicao incompativel) a inversao da posicao provoca um efeito
	 * indesejavel ao jogo.
	 * 
	 * @param pecaAGirar
	 * 					Peca a ser girada.
	 * @return Retorna uma peca girada. Ex.: |0 - 1| = |1 - 0|, apenas sua posicao foi invertida.
	 * @throws Exception 
	 */
	
	private Peca girarPeca(Peca pecaAGirar) throws Exception {
		Peca pecaGirada = new Peca(pecaAGirar.getDireita(), pecaAGirar.getEsquerda());
		return pecaGirada;
	}
}