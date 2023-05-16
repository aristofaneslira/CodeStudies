/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */

package lp2.lab08;

import org.junit.*;

public class PecaTest {

	@Test
	public void testaValorDePeca() {
		try {
			Peca peca = new Peca(6, 6);
			Assert.assertEquals(12, peca.valorDePeca());
			Peca peca2 = new Peca(0, 0);
			Assert.assertEquals(0, peca2.valorDePeca());
			Peca peca3 = new Peca(7, -1);
			Assert.assertEquals(6, peca3.valorDePeca()); // Essa linha nao seria executada pois a linha anterior entra na excessao lancada pelo construtor da classe Peca.
		} catch (Exception e) {
			Assert.assertEquals("Uma peca de domino nao possui um lado de valor maior que 6 ou menor que 0.", e.getMessage());
		}
	}

	@Test
	public void testaEquals() throws Exception {
		Peca peca = new Peca(6, 6);
		Peca peca2 = new Peca(6, 6);
		Assert.assertTrue(peca.equals(peca2));
	}

	@Test
	public void testaToString() throws Exception {
		Peca peca = new Peca(6, 6);
		Assert.assertTrue(peca.toString().equals("|6 - 6|"));
	}

	@Test
	public void testaCompareTo() throws Exception {
		Peca peca = new Peca(0, 0);
		Peca peca2 = new Peca(2, 0);
		Assert.assertTrue(peca.compareTo(new Peca(6, 6)) < 0);
		Assert.assertTrue(peca2.compareTo(new Peca(1, 0)) > 0);
		Assert.assertTrue(peca2.compareTo(new Peca(1, 1)) == 0);
		
	}
	
	@Test
	public void testaCompativelCom() throws Exception {
		Peca peca = new Peca(6, 6);
		Assert.assertTrue(peca.compativelCom(new Peca(3, 6)));
		Assert.assertFalse(peca.compativelCom(new Peca(3, 3)));
	}

}
