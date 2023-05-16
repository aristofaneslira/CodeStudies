/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */

package lp2.lab08;

import java.util.*;

/**
 * Classe que representa um Domino.
 * 
 * @author Aristofanes
 *
 */

public class Domino {
	
	// Atributos da classe Domino.
	
	private List<Peca> domino;
	final private int[] lados = {0, 1, 2, 3, 4, 5, 6};
	
	/**
	 * Construtor de um Domino.
	 * 
	 * @throws Exception
	 * 					Relanca a excessao do construtor de Peca.
	 */
	
	public Domino() throws Exception {
		domino = new ArrayList<Peca>();
		for (int i = 0; i < lados.length; i++) {
			for (int j = 0; j < lados.length; j++) {
				if (! domino.contains(new Peca(lados[i], lados[j])))
					domino.add(new Peca(lados[i], lados[j]));
			}
		}
	}
	
	/**
	 * Metodo para saber o numero de pecas do domino.
	 * 
	 * @return Retorna a quantidade atual de pecas do domino.
	 */
	
	public int numeroDePecas() {
		return domino.size();
	}
	
	/**
	 * Metodo que baralha (traca) o domino.
	 * 
	 */
	
	public void baralhar(){
		Random ran = new Random();

		for(int i = 0; i < numeroDePecas(); i++){
			int posicao = ran.nextInt(numeroDePecas());
			Peca temp = domino.get(i);
			domino.set(i, domino.get(posicao));
			domino.set(posicao, temp);
		}
	}
	
	/**
	 * Metodo que pega uma peca do domino e, retornando-a, remove a peca do domino.
	 * 
	 * @return Retorna a peca removida do domino.
	 */
	
	public Peca pegaPeca() {
		if (numeroDePecas() == 0)
			return null;
		return domino.remove(numeroDePecas() - 1);
	}
	
	/**
	 * Metodo que permite iterar sobre o domino.
	 * 
	 * @return Retorna um iterador do domino.
	 */
	
	public Iterator<Peca> iterator() {
		return domino.iterator();
	}
	
	/**
	 * Informacoes do domino numa String.
	 */
	
	@Override
	public String toString() {
		return "Domino comum, contendo 28 pecas.";
	}
}