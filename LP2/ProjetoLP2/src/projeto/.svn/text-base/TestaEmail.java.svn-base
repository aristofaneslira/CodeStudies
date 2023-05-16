package projeto;

import org.junit.*;

public class TestaEmail {
	@Test public void TestaConstrutorEmail()throws Exception{
		
		try{
			new Email("fulano@gmail.com");
		}catch(Exception excessao){
			System.err.printf("O email parece nao ser valido.");
		}
		
		try{
			new Email("fulanogmail.com");
		}catch(Exception excessao){
			System.err.printf("O email parece nao ser valido.");
		}
	}
	
	@Test public void TestagetEnderecoEmail() throws Exception{
		Email emailTeste = new Email("fulano@gmail.com");
		Assert.assertEquals("erro na captura do email","fulano@gmail.com", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email","fulano@yahoo.com.br", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email","", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email",123, emailTeste.getEnderecoEmail());
				
	}
	
	@Test public void TestaSetEmail() throws Exception{
		Email emailTeste = new Email("fulano@gmail.com");
		Assert.assertEquals("erro na captura do email","fulano@gmail.com", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email","fulano@yahoo.com.br", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email","", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email",123, emailTeste.getEnderecoEmail());
		
		emailTeste.setEmail("Sicrano@gmail.com");
		Assert.assertEquals("erro na captura do email","Sicrano@gmail.com", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email","fulano@yahoo.com.br", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email","", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro na captura do email",123, emailTeste.getEnderecoEmail());
	}
	
	@Test public void TestaToString() throws Exception{
		Email emailTeste = new Email("fulano@gmail.com");
		Assert.assertEquals("erro no toString","Email: " + "fulano@gmail.com", emailTeste.toString());
		Assert.assertNotSame("erro no toString","Email: " + "fulano@yahoo.com.br", emailTeste.getEnderecoEmail());
		Assert.assertNotSame("erro no toString","Email: " + 123, emailTeste.getEnderecoEmail());
	}
	@Test public void TestaEquals() throws Exception{
		Email emailTeste = new Email("fulano@gmail.com");
		Email emailTeste2 = new Email("fulano@gmail.com");
		Email emailTeste3 = new Email("Sicrano@gmail.com");
		Assert.assertTrue("erro no equals objetos diferentes",emailTeste.equals(emailTeste2));
		Assert.assertTrue("erro no equals objetos diferentes",emailTeste2.equals(emailTeste));
		Assert.assertFalse("erro no equals objetos iguais",emailTeste.equals(emailTeste3));
	}

}
