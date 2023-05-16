// Rodrigo Santos Salviano.

package lp2.lab06;

import java.util.*;

/**
 * Classe que representa um comite eleitoral.
 * 
 * @author Rodrigo
 *
 */

public class Apudador {
	List<UrnaEletronica> urnas;
	
	/**
	 * Construtor de um Apurador.
	 * 
	 * @param urnas
	 * 				Array de UrnaEletronica.
	 * @throws Exception
	 * 				Lanca execessao se houver urnas repetidas.
	 */
	
	public Apudador(UrnaEletronica[] urnas) throws Exception {
		this.urnas = new ArrayList<UrnaEletronica>();
		for (UrnaEletronica urna : urnas) {
			if (! (this.urnas.contains(urna)))
				this.urnas.add(urna);
			else
				throw new Exception("Tentativa de apurar uma mesma urna duas vezes.");
		}
	}
	
}
