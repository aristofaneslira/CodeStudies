//Rodrigo Santos Salviano

package lp2.lab07;

import org.junit.*;

public class MinhaColecaoDeCDsTest {
	
	CDEspecial cd, cd2;
	MinhaColecaoDeCDs colecao, colecao2;

	@Before
	public void setUp() throws Exception {
		cd = new CDEspecial("Minutes to Midnight", "Linkin Park", 12);
		
		String[] faixas = {"musica1", "musica2", "musica3", "musica4", "musica5", "musica6", "musica7", "musica8", "musica9", "musica10", "musica11", "musica12"};
		for (int i = 0; i < faixas.length; i++) {
			cd.cadastrarFaixa(faixas[i]);
			
		colecao = new MinhaColecaoDeCDs();
		colecao2 = new MinhaColecaoDeCDs();
		
		cd2 = new CDEspecial("Ao Vivo", "Paula Fernandes", 17, "Nao Precisa");
		}
	}

	@Test
	public void testaAdicionaCD() throws Exception {
		colecao.adicionaCD(cd);
		Assert.assertEquals(cd, colecao.pesquisaCD("Minutes to Midnight"));
	}
	
	@Test
	public void testaRemoveCD() throws Exception {
		colecao.adicionaCD(cd);
		colecao.adicionaCD(cd2);
		Assert.assertEquals(2, colecao.numeroDeCDs());
		colecao.removeCD("Minutes to Midnight");
		Assert.assertEquals(1, colecao.numeroDeCDs());
	}
	
	@Test
	public void testaPesquisaCD() throws Exception {
		colecao.adicionaCD(cd2);
		Assert.assertEquals(cd2, colecao.pesquisaCD("Ao Vivo"));
	}
	
	@Test
	public void testaNumeroDeCDs() throws Exception {
		Assert.assertEquals(0, colecao.numeroDeCDs());
		colecao.adicionaCD(cd);
		Assert.assertEquals(1, colecao.numeroDeCDs());
	}
	
	@Test
	public void testaEquals() throws Exception {
		colecao.adicionaCD(cd);
		colecao.adicionaCD(cd2);
		Assert.assertTrue(colecao.equals(colecao2));
		colecao2.adicionaCD(cd);
		colecao2.adicionaCD(cd2);
		Assert.assertFalse(colecao.equals(colecao2));
	}

}
