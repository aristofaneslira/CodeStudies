/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */

package lp2.lab08;

import org.junit.*;

import org.junit.Before;
import org.junit.Test;

public class JogadorTest {
	Jogador jogador;
	Domino domino;
	Mesa mesa;
	
	@Before
	public void setUp() throws Exception {
		jogador = new Jogador("Rodrigo", 0);
		mesa = new Mesa();
	}

	@Test
	public void testJoga() throws Exception {
		jogador.adicionaPeca(new Peca(6, 2));
		jogador.adicionaPeca(new Peca(6, 5));
		
		Assert.assertEquals(2, jogador.pecasNaMao());

		mesa.addPecaNaEsquerda(new Peca(6, 6));
		
		Assert.assertTrue(jogador.joga(mesa));
		Assert.assertEquals(2, mesa.numPecasJogadas());
		System.out.println(mesa);
		
		Assert.assertTrue(jogador.joga(mesa));
		System.out.println(mesa);
		
		
		
	}

}
