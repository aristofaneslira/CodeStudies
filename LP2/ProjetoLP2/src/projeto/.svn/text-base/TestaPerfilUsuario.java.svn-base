package projeto;

import org.junit.*;

/**
 * Perfil de um usu�rio da Agenda Multitudo.
 * 
 * Perfil de usu�rio contendo nome, email e descri��o.
 * 
 * @author Dem�trio G�is - demetrio.gois@gmail.com
 * @author Rodrigo Santos - ccc.rodrigo@gmail.com
 * @author Bernard Lenin - bernard.lenin4@gmail.com
 * @author Alisson Carlos - alissonccsufcg@gmail.com
 * 
 * @version 1.0
 * 
 * 			Copyright (C) 2011 Universidade Federal de Campina Grande.
 *
 */

public class TestaPerfilUsuario {
	
	@Before public void CriaPerfil() {
		new PerfilUsuario("Alisson C Calixto", "alissonccsufcg@gmail.com", "I'm a Student of Computer Science");
	}
	@Test public void ConstrutorCriaPerfil()throws Exception{
		try{
			PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
			Assert.assertEquals("fulano", perfil2.getNome());
		}catch(Exception e){
			System.err.printf("erro no construtor");
		}
	}
	
	@Test public void TestaGetNome(){
		PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		Assert.assertEquals("erro na captura do nome","fulano", perfil2.getNome());
		Assert.assertNotSame("erro na captura do nome","fulan", perfil2.getNome());
		Assert.assertNotSame("erro na captura do nome","", perfil2.getNome());
		Assert.assertNotSame("erro na captura do nome",123, perfil2.getNome());
		
	}
	@Test public void TestaGetEmail(){
		PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		Assert.assertEquals("erro na captura do email","fulano@gmail.com", perfil2.getEmail());
		Assert.assertNotSame("erro na captura do email","fulano@yahoo.com.br", perfil2.getEmail());
		Assert.assertNotSame("erro na captura do email","", perfil2.getEmail());
		Assert.assertNotSame("erro na captura do email",123, perfil2.getEmail());
	}
	@Test public void TestaGetDescricao(){
		PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		Assert.assertEquals("erro na captura da descricao","um teste", perfil2.getDescricao());
		Assert.assertNotSame("erro na captura da descricao","esse teste deu errado", perfil2.getDescricao());
		Assert.assertNotSame("erro na captura da descricao","", perfil2.getDescricao());
		Assert.assertNotSame("erro na captura da descricao",123, perfil2.getDescricao());
	}
	@Test public void TestaSetNome(){
		PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		Assert.assertEquals("erro na captura do nome","fulano", perfil2.getNome());
		perfil2.setNome("Sicrano");
		Assert.assertEquals("erro na captura do nome","Sicrano", perfil2.getNome());
		Assert.assertNotSame("erro na captura do nome","fulano", perfil2.getNome());
		perfil2.setNome("Professor Nazareno");
		Assert.assertEquals("erro na captura do nome","Professor Nazareno", perfil2.getNome());
		Assert.assertNotSame("erro na captura do nome","Professora Raquel", perfil2.getNome());
	}
	@Test public void TestaSetEmail(){
		PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		Assert.assertEquals("erro na captura do email","fulano@gmail.com", perfil2.getEmail());
		perfil2.setEmail("fulano123@hotmail.com");
		Assert.assertEquals("erro na captura do email","fulano123@hotmail.com", perfil2.getEmail());
		Assert.assertNotSame("erro na captura do email","fulano@yahoo.com.br", perfil2.getEmail());
		Assert.assertNotSame("erro na captura do email",123, perfil2.getEmail());
	}
	@Test public void TestaSetDescricao(){
		PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		Assert.assertEquals("erro na captura da descricao","um teste", perfil2.getDescricao());
		perfil2.setDescricao("mais um teste");
		Assert.assertEquals("erro na captura da descricao","mais um teste", perfil2.getDescricao());
		Assert.assertNotSame("erro na captura da descricao","teste", perfil2.getDescricao());
		Assert.assertNotSame("erro na captura da descricao",123, perfil2.getDescricao());
		
	}
	@Test public void TestaToString(){
		PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		Assert.assertEquals("erro no tostring","Nome: " + "fulano" + "\nEmail: " + "fulano@gmail.com" + "\nDescricao: " + "um teste", perfil2.toString());
		Assert.assertNotSame("erro no tostring","Nome: " + "Sicrano" + "\nEmail: " + "Sicrano@gmail.com" + "\nDescricao: " + "um teste", perfil2.toString());
		
	}
	@Test public void TestaEquals(){
		PerfilUsuario  perfil2 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		PerfilUsuario  perfil3 = new PerfilUsuario("fulano","fulano@gmail.com","um teste");
		PerfilUsuario  perfil4 = new PerfilUsuario("Sicrano","Sicrano123@gmail.com","mais um teste");
		Assert.assertTrue("objetos diferente erro no equals", perfil2.equals(perfil3));
		Assert.assertTrue("objetos diferente erro no equals", perfil3.equals(perfil2));
		Assert.assertFalse("objetos iguais erro no equals", perfil2.equals(perfil4));
		
	}
	

}
