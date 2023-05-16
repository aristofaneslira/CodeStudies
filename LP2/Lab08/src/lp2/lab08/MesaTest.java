/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */
package lp2.lab08;

import org.junit.*;

public class MesaTest {
	Mesa mesa;

	@Before
	public void setUp() throws Exception {
		mesa = new Mesa();
	}

	@Test
	public void testaAddPecaNaEsquerda() {
		try {
			Assert.assertTrue(mesa.addPecaNaEsquerda(new Peca(6, 6)));
			Assert.assertTrue(mesa.addPecaNaDireita(new Peca(6, 5)));
			mesa.addPecaNaEsquerda(new Peca(4, 4)); // Ao tentar jogar uma peca nao compativel retorna uma excecao.
		}catch (Exception e) {
			Assert.assertEquals("Tentativa de realizar um movimento invalido.", e.getMessage());
		}
	}
		
	@Test
	public void testaAddPecaNaDireita() {
		try {
			Assert.assertTrue(mesa.addPecaNaDireita(new Peca(6, 6)));
			Assert.assertTrue(mesa.addPecaNaEsquerda(new Peca(5, 6)));
			mesa.addPecaNaDireita(new Peca(4, 4));
		}catch (Exception e) {
			Assert.assertEquals("Tentativa de realizar um movimento invalido.", e.getMessage());
		} 
	}
	
	@Test
	public void testaPecasJogadas() throws Exception {
		Assert.assertEquals(0, mesa.numPecasJogadas());
		mesa.addPecaNaDireita(new Peca(6, 6));
		mesa.addPecaNaEsquerda(new Peca(6, 0));
		Assert.assertEquals(2, mesa.numPecasJogadas());
	}
}


