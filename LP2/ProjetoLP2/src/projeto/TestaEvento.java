package projeto;
import org.junit.*;

/**
 * 
 * @author Demetrio Gois - demetrio.gois@gmail.com
 * @author Rodrigo Santos - ccc.rodrigo@gmail.com
 * @author Bernard Lenin - bernard.lenin4@gmail.com
 * @author Alisson Carlos - alissonccsufcg@gmail.com
 * 
 * @version 1.0
 * 
 * 			Copyright (C) 2011 Universidade Federal de Campina Grande.
 *
 */

public class TestaEvento{
	private Evento evento, evento1, evento2, evento3;
	
	@Before public void CriaEvento() throws Exception {
		evento = new Evento("Aula de LP2", "04/11/2011", "12:00:00", "03:00:00", "a");
		evento1 = new Evento("Aula de P2", "04/11/2011", "09:00:00", "03:01:00", "a");
		evento2 = new Evento("Aula de Vetorial", "04/11/2011", "15:00:00", "02:00:00", "Aula de Vetorial sobre Transla��o de eixos");
		evento3 = new Evento("Aula de Vetorial", "05/11/2011", "15:00:00", "02:00:00", "Aula de Vetorial sobre Transla��o de eixos");
	}
	
	@Test public void TestaConstrutorDeEvento() throws Exception{
		try {
			Evento evento10 = new Evento("Aula P2", "04/11/2011", "10:00:00", "02:00:00", " ");
			Assert.assertEquals("Aula P2", evento10.getNome());
			
		}
		catch(Exception e){
			System.err.printf("erro no construtor");
		}
			
		}
		
		@Test public void TestaGetNome() {
			Assert.assertEquals("Erro na captura do nome","Aula de LP2", evento.getNome());
			Assert.assertNotSame("erro na captura do nome","fulan", evento.getNome());
			Assert.assertNotSame("erro na captura do nome","", evento.getNome());
			Assert.assertNotSame("erro na captura do nome",123, evento.getNome());
		}
			@Test public void TestaSetNome() throws Exception{
			evento1.setNome("Aula de Laboratorio de Programacao 2");
			Assert.assertEquals("Erro na mudanca do nome","Aula de Laboratorio de Programacao 2", evento1.getNome());
			evento1.setNome("AULA");
			Assert.assertEquals("Erro na mudanca do nome","AULA", evento1.getNome());
	//		Assert.assertEquals("Erro na mudanca do nome","Nome do contato deve ser inserido.", evento1.setNome(""));
			
			}
			
			@Test public void TestaIntercedeCom() {
				Assert.assertTrue(evento1.intercedeCom(evento));
				Assert.assertTrue(evento.intercedeCom(evento1));
				
				Assert.assertFalse(evento.intercedeCom(evento2));
				Assert.assertFalse(evento2.intercedeCom(evento));
				Assert.assertFalse(evento1.intercedeCom(evento2));
				Assert.assertFalse(evento2.intercedeCom(evento3));
				
			}
			
			@Test public void TestegetEsetData() {
				Assert.assertEquals("04/11/2011", evento.getData());
				Assert.assertEquals("04/11/2011", evento1.getData());
				Assert.assertEquals("05/11/2011", evento3.getData());
				evento3.setData("23/10/2011");
				Assert.assertEquals("23/10/2011", evento3.getData());
				
			}
			@Test public void TestegetEsetHorario() {
				Assert.assertEquals("12:00:00", evento.getHorario());
				Assert.assertEquals("09:00:00", evento1.getHorario());
				evento1.setHorario("13:00:00");
				Assert.assertEquals("13:00:00", evento1.getHorario());
				Assert.assertEquals("15:00:00", evento2.getHorario());
				
			}
			@Test public void TestegetEsetDuracao(){
				Assert.assertEquals("03:00:00", evento.getDuracao());
				Assert.assertEquals("03:01:00", evento1.getDuracao());
				Assert.assertEquals("02:00:00", evento2.getDuracao());
				evento2.setDuracao("02:30:00");
				Assert.assertEquals("02:30:00", evento2.getDuracao());
				}
			
			@Test public void TesteEquals(){
				evento3.setData("04/11/2011");
				Assert.assertTrue(evento2.equals(evento3));
				Assert.assertFalse(evento1.equals(evento3));
			}
			
			@Test public void TestegetEsetDescricao(){
				Assert.assertEquals("a", evento.getDescricao());
				evento.setDescricao("descricao mudou");
				Assert.assertEquals("descricao mudou", evento.getDescricao());
			}
			

			
}
		
		


