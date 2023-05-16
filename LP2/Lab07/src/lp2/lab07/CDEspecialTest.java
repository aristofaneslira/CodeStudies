//Rodrigo Santos Salviano

package lp2.lab07;

import org.junit.*;

public class CDEspecialTest {
	
	CDEspecial cd, cd2;

	@Before
	public void setUp() throws Exception {
		cd = new CDEspecial("Minutes to Midnight", "Linkin Park", 12);
		cd2 = new CDEspecial("Ao Vivo", "Paula Fernandes", 17, "Nao Precisa");
		
		String[] faixas = {"musica1", "musica2", "musica3", "musica4", "musica5", "musica6", "musica7", "musica8", "musica9", "musica10", "musica11", "musica12"};
		for (int i = 0; i < faixas.length; i++) {
			cd.cadastrarFaixa(faixas[i]);
		}
	}
	
	@Test
	public void testaCadastrarFaixa() throws Exception {
		Assert.assertFalse(cd.cadastrarFaixa("Bleed it Out"));
		Assert.assertTrue(cd2.cadastrarFaixa("Passaro de Fogo"));
	}

	@Test
	public void testaRetornarFaixa() {
		Assert.assertEquals("musica2", cd.retornarFaixa(1));
		Assert.assertNull(cd.retornarFaixa(13));
		Assert.assertNull(cd.retornarFaixa(-1));
	}
	
	@Test
	public void testaEquals() throws Exception {
		Assert.assertFalse(cd.equals(cd2));
		CDEspecial cd3 = new CDEspecial("Minutes to Midnight", "Linkin Park", 12);
		
		Assert.assertTrue(cd.equals(cd3));
	}
	
	@Test
	public void testaMetodosAcessors() {
		Assert.assertEquals("Minutes to Midnight", cd.getTitulo());
		Assert.assertEquals("Linkin Park", cd.getAutor());
		
		Assert.assertEquals("Nao Precisa", cd2.getCarroChefe());
	}
	
	@Test
	public void testaMetodosMutators() {
		Assert.assertEquals("Nao Precisa", cd2.getCarroChefe());
		cd2.setCarroChefe("Pra Voce");
		Assert.assertEquals("Pra Voce", cd2.getCarroChefe());
	}
}