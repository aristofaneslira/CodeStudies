/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */
package lp2.lab08;

import org.junit.*;

public class DominoTest {
	Domino domino;
	Jogador jogador;

	@Before
	public void setUp() throws Exception {
		domino = new Domino();
		jogador = new Jogador("Rodrigo", 1);
	}

	@Test
	public void testaDomino() {
		Assert.assertEquals(28, domino.numeroDePecas());
		domino.baralhar();
		Assert.assertEquals(28, domino.numeroDePecas());
		
		jogador.adicionaPeca(domino.pegaPeca());
		Assert.assertEquals(27, domino.numeroDePecas());
	}

}
