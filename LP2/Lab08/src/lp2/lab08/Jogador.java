/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */

package lp2.lab08;

import java.util.*;

/**
 * Classe que representa um jogador de domino.
 * 
 * @author Rodrigo
 *
 */

public class Jogador {
	
	// Atributos do Jogador
	
	private String nome;
	private int estrategia;
	/*
	 * private final int ESTRATEGIA_MAIS_SE_REPETE = 1, ESTRATEGIA_MENOS_SE_REPETE = 0;
	 * não entendi a finalidade disso.
	 */
	private List<Peca> maoDoJogador;
	
	/**
	 * Construtor de um Jogador.
	 * 
	 * @param nome
	 * 				String do nome do jogador.
	 * @param estrategia
	 * 				Estrategia a ser usada pelo jogador.
	 * @throws Exception
	 * 				Lanca excecao caso o valor que representa as estrategias seja diferente de 0 ou 1.
	 */

	public Jogador(String nome, int estrategia) {
		this.nome = nome;
		this.estrategia = estrategia;
		maoDoJogador = new ArrayList<Peca>();
	}
	
	/**
	 * Metodo acessador para o nome do Jogador.
	 * 
	 * @return Retorna o nome do Jogador.
	 */

	public String getNome() {
		return nome;
	}
	
	/**
	 * Simula que o jogador pega uma peca do domino.
	 * 
	 * @param peca
	 * 				Peca returada do domino.
	 */

	public void adicionaPeca(Peca peca) {
		maoDoJogador.add(peca);
	}
	
	/**
	 * Metodo para acessar quantas pecas o jogador tem na mao.
	 * 
	 * @return Retorna a quantidade de pecas que o jogador tem na mao.
	 */
	
	public int pecasNaMao() {
		return maoDoJogador.size();
	}
	
	/**
	 * Metodo acessador da estrategia do jogador.
	 * 
	 * @return Retorna a estrategia do jogador. 
	 */
	
	public int getEstrategia() {
		return estrategia;
	}
	
	/**
	 * Metodo que faz com que o jogador jogue uma peca.
	 * 
	 * @param mesa
	 * 				Mesa onde sera jogada a peca.
	 * @return Retorna true caso o jogador jogue uma peca e false se ele passar a vez.
	 * @throws Exception
	 */

	public boolean joga(Mesa mesa) throws Exception {
		Iterator<Peca> it = maoDoJogador.iterator();
		
		while (it.hasNext()) {
			Peca peca = it.next();
			if (peca.getEsquerda() == mesa.getOpcaoEsquerda() || peca.getDireita() == mesa.getOpcaoEsquerda()) {
				mesa.addPecaNaEsquerda(peca);
				return maoDoJogador.remove(peca);
			}
			else if (peca.getEsquerda() == mesa.getOpcaoDireita() || peca.getDireita() == mesa.getOpcaoDireita()) {
				mesa.addPecaNaDireita(peca);
				return maoDoJogador.remove(peca);
			}
			else continue;
		}
		return false;
	}
	
	/**
	 * Retorna informaçoes do jogador e as pecas que tem em mao numa String.
	 */
	
	@Override
	public String toString() {
		String infoJogador = "Nome: " + getNome() + "\nMao: ";
		Iterator<Peca> it = maoDoJogador.iterator();
		while (it.hasNext()) {
			infoJogador += it.next();
		}
		return infoJogador;
	}
}