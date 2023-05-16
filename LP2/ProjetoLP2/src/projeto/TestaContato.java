package projeto;

import org.junit.*;
import java.util.*;

public class TestaContato {
	private Contato contato;
	private List<FormaDeContato> formasDeContato = new ArrayList<FormaDeContato>();
	private Endereco endereco = new Endereco("aprigio veloso", "bodocongo", "Campina grande", "123456789", "123");
	
	@Test public void TestaConstrutorContato()throws Exception{
		try{
			contato = new Contato("fulano",endereco, "07/08/1999", formasDeContato,"teste de classe");
		}catch(Exception exception){
			System.err.printf("Erro no construtor");
		}
		
		try{
			contato = new Contato("fulano",null, null, formasDeContato,"teste de classe");
		}catch(Exception exception){
			System.err.printf("Erro no construtor");
		}
		try{
			contato = new Contato("fulano",null, null, null,null);
		}catch(Exception exception){
			System.err.printf("Erro no construtor");
		}
		try{
			contato = new Contato(null,null, null, null,null);
		}catch(Exception e){
			Assert.assertEquals("Mensagem de erro do construtor errada.", "Nome do contato deve ser inserido.", e.getMessage());
		}
	}
	
	@Test public void TestaGetComentario() throws Exception{
		contato = new Contato("fulano",endereco, "07/08/1999", formasDeContato,"teste de classe");
		Assert.assertEquals("erro na captura do comentario","teste de classe",contato.getComentario());
		Assert.assertNotSame("erro na captura do comentario objeto invalido","teste classe",contato.getComentario());
		Assert.assertNotSame("erro na captura do comentario objeto invalido",123,contato.getComentario());
		Assert.assertNotSame("erro na captura do comentario objeto invalido",null,contato.getComentario());
		Contato contato2 = new Contato("sicrano", endereco, "05/05/5555", formasDeContato, null);
		Assert.assertEquals("erro na captura do comentario",null,contato2.getComentario());
		Assert.assertNotSame("erro na captura do comentario objeto invalido","",contato2.getComentario());
		Assert.assertNotSame("erro na captura do comentario objeto invalido","null",contato2.getComentario());
	}
	@Test public void TestaSetComentario() throws Exception{
		Contato contato2 = new Contato("sicrano", endereco, "05/05/5555", formasDeContato, null);
		Assert.assertEquals("erro na captura do comentario",null,contato2.getComentario());
		Assert.assertNotSame("erro na captura do comentario objeto invalido","",contato2.getComentario());
		Assert.assertNotSame("erro na captura do comentario objeto invalido","null",contato2.getComentario());
		contato2.setComentario("mais um teste");
		Assert.assertEquals("erro na captura do comentario","mais um teste",contato2.getComentario());
		Assert.assertNotSame("erro na captura do comentario objeto invalido",null,contato2.getComentario());
				
	}
	@Test public void TestaGetNome() throws Exception{
		contato = new Contato("fulano",endereco, "07/08/1999", formasDeContato,"teste de classe");
		Assert.assertEquals("erro na captura do nome","fulano",contato.getNome());
		Assert.assertNotSame("erro na captura do nome objeto invalido","",contato.getNome());
		Assert.assertNotSame("erro na captura do nome objeto invalido",null,contato.getNome());
		Assert.assertNotSame("erro na captura do nome objeto invalido",123,contato.getNome());
		
	}
	@Test public void TestaSetNome() throws Exception{
		contato = new Contato("fulano",endereco, "07/08/1999", formasDeContato,"teste de classe");
		Assert.assertEquals("erro na captura do nome","fulano",contato.getNome());
		contato.setNome("sicrano");
		Assert.assertEquals("erro na captura do nome","sicrano",contato.getNome());
		Assert.assertNotSame("erro na captura do nome objeto invalido","fulano",contato.getNome());
		
	}
	@Test public void TestaGetAniversario() throws Exception{
		contato = new Contato("fulano",endereco, "07/08/1999", formasDeContato,"teste de classe");
		Assert.assertEquals("erro na captura do aniverssario","07/08/1999",contato.getAniversario());
		Assert.assertNotSame("erro na captura do aniverssario objeto invalido","",contato.getAniversario());
		Assert.assertNotSame("erro na captura do aniverssario objeto invalido",null,contato.getAniversario());
		Assert.assertNotSame("erro na captura do aniverssario objeto invalido",123,contato.getAniversario());
	}
	@Test public void TestaSetAniversario() throws Exception{
		contato = new Contato("fulano",endereco, "07/08/1999", formasDeContato,"teste de classe");
		Assert.assertEquals("erro na captura do aniverssario","07/08/1999",contato.getAniversario());
		contato.setAniversario("09/08/1999");
		Assert.assertEquals("erro na captura do aniverssario","09/08/1999",contato.getAniversario());
		contato.setAniversario("");
		Assert.assertEquals("erro na captura do aniverssario","",contato.getAniversario());
		contato.setAniversario(null);
		Assert.assertEquals("erro na captura do aniverssario",null,contato.getAniversario());		
		
	}
	@Test public void TestaEquals() throws Exception{
		contato = new Contato("fulano",endereco, "07/08/1999", formasDeContato,"teste de classe");
		Contato contato2 = new Contato("sicrano", endereco, "05/05/5555", formasDeContato, null);
		Contato contato3 = new Contato("sicrano", endereco, "05/05/5555", formasDeContato, null);
		Assert.assertTrue("objeto eram pra ser iguais",contato2.equals(contato3));
		Assert.assertTrue("objeto eram pra ser iguais",contato3.equals(contato2));
		Assert.assertFalse("objeto eram pra ser iguais",contato.equals(contato3));
		
	}
	
	

}
