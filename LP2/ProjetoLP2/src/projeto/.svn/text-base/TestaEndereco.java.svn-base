package projeto;

import org.junit.*;

public class TestaEndereco {
	private Endereco endereco;
	
	
	@Test public void TestaConstrutorEndereco()throws Exception{
		try{
			endereco = new Endereco("floripedes coutinho","bodocongo", "campina grande", "12345678","123");
		}catch(Exception erroConstrutor){
			System.err.printf("Erro no construtor");
		}
		try{
			endereco = new Endereco("floripedes coutinho","", "", "","123");
			
		}catch(Exception erroConstrutor){
			System.err.printf("Erro no construtor");
		}
		try{
			endereco = new Endereco("","", "", "","123");
			
		}catch(Exception erroConstrutor){
			System.err.printf("Erro no construtor");
		}
		try{
			endereco = new Endereco("floripedes coutinho","", "", "","");
			
		}catch(Exception erroConstrutor){
			System.err.printf("Erro no construtor");
		}
	}
	
	@Test public void TestaGetLogradouro(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura do endereco","Sao jose", endereco.getLagradouro());
		Assert.assertNotSame("erro na captura do endereco","centro", endereco.getLagradouro());
		Assert.assertNotSame("erro na captura do endereco","", endereco.getLagradouro());
		Assert.assertNotSame("erro na captura do endereco",123, endereco.getLagradouro());
	}
	@Test public void TestaGetBairro(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura do bairro","malvinas", endereco.getBairro());
		Assert.assertNotSame("erro na captura do bairro","centro", endereco.getBairro());
		Assert.assertNotSame("erro na captura do bairro","", endereco.getBairro());
		Assert.assertNotSame("erro na captura do bairro",123, endereco.getBairro());
	}
	@Test public void TestaGetCidadeEEstado(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura da CidadeEstado","Campina grande", endereco.getCidadeEEstado());
		Assert.assertNotSame("erro na captura da CidadeEstado","joao pessoa", endereco.getCidadeEEstado());
		Assert.assertNotSame("erro na captura da CidadeEstado","", endereco.getCidadeEEstado());
		Assert.assertNotSame("erro na captura da CidadeEstado",123,endereco.getCidadeEEstado());
	}
	@Test public void TestaGetCep(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura do cep","123456789", endereco.getCEP());
		Assert.assertNotSame("erro na captura do cep","12343214567", endereco.getCEP());
		Assert.assertNotSame("erro na captura do cep","", endereco.getCEP());
		Assert.assertNotSame("erro na captura do cep",123,endereco.getCEP());
	}
	@Test public void TestaGetNumeroResidencia(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura do numero da residencia","123", endereco.getNumeroDaResidencia());
		Assert.assertNotSame("erro na captura do numero da residencia","321", endereco.getNumeroDaResidencia());
		Assert.assertNotSame("erro na captura do numero da residencia","", endereco.getNumeroDaResidencia());
		Assert.assertNotSame("erro na captura do numero da residencia",123,endereco.getNumeroDaResidencia());
	}
	
	@Test public void TestaSetLogradouro(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura do endereco","Sao jose", endereco.getLagradouro());
		endereco.setLagradouro("aprigio veloso");
		Assert.assertNotSame("erro na captura do endereco","Sao jose", endereco.getLagradouro());
		Assert.assertEquals("erro na captura do endereco","aprigio veloso", endereco.getLagradouro());
		Assert.assertNotSame("erro na captura do endereco","", endereco.getLagradouro());
		Assert.assertNotSame("erro na captura do endereco",123, endereco.getLagradouro());
	}
	@Test public void TestaSetBairro(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura do bairro","malvinas", endereco.getBairro());
		endereco.setBairro("bodocongo");
		Assert.assertNotSame("erro na captura do bairro","malvinas", endereco.getBairro());
		Assert.assertEquals("erro na captura do bairro","bodocongo", endereco.getBairro());
		Assert.assertNotSame("erro na captura do bairro","", endereco.getBairro());
		Assert.assertNotSame("erro na captura do bairro",123, endereco.getBairro());
	}
	
	@Test public void TestaSetCidadeEEstado(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura da CidadeEstado","Campina grande", endereco.getCidadeEEstado());
		endereco.setCidadeEEstado("Sousa");
		Assert.assertNotSame("erro na captura da CidadeEstado","Campina grande", endereco.getCidadeEEstado());
		Assert.assertEquals("erro na captura da CidadeEstado","Sousa", endereco.getCidadeEEstado());
		Assert.assertNotSame("erro na captura da CidadeEstado","", endereco.getCidadeEEstado());
		Assert.assertNotSame("erro na captura da CidadeEstado",123,endereco.getCidadeEEstado());
	}
	
	@Test public void TestaSetCep(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura do cep","123456789", endereco.getCEP());
		endereco.setCEP("345678912");
		Assert.assertNotSame("erro na captura do cep","12343214567", endereco.getCEP());
		Assert.assertEquals("erro na captura do cep","345678912", endereco.getCEP());
		Assert.assertNotSame("erro na captura do cep","", endereco.getCEP());
		Assert.assertNotSame("erro na captura do cep",123,endereco.getCEP());
	}
	
	@Test public void TestaSetNumeroResidencia(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro na captura do numero da residencia","123", endereco.getNumeroDaResidencia());
		endereco.setNumeroDaResidencia("456");
		Assert.assertNotSame("erro na captura do numero da residencia","321", endereco.getNumeroDaResidencia());
		Assert.assertEquals("erro na captura do numero da residencia","456", endereco.getNumeroDaResidencia());
		Assert.assertNotSame("erro na captura do numero da residencia","", endereco.getNumeroDaResidencia());
		Assert.assertNotSame("erro na captura do numero da residencia",123,endereco.getNumeroDaResidencia());
	}
	
	@Test public void TestaToString(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Assert.assertEquals("erro no to string","Lagradouro: " + "Sao jose" + "\nNumero: " + "123" + "\nBairro: " + "malvinas" + "\nCidade/UF: " + "Campina grande" + "\nCEP: " + "123456789", endereco.toString());
		Assert.assertNotSame("erro no to string","Lagradouro: " + "floripedes" + "\nNumero: " + "123" + "\nBairro: " + "malvinas" + "\nCidade/UF: " + "Campina grande" + "\nCEP: " + "123456789", endereco.toString());
	}
	@Test public void TestaEquals(){
		endereco = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Endereco endereco2 = new Endereco("Sao jose", "malvinas","Campina grande", "123456789", "123");
		Endereco endereco3 = new Endereco("floripedes", "malvinas","Campina grande", "123456789", "123");
		Endereco endereco4 = new Endereco("floripedes", "bodocongo","Campina grande", "123456789", "123");
		Endereco endereco5 = new Endereco("floripedes", "malvinas","Campina grande", "123456789", "456");
		Endereco endereco6 = new Endereco("floripedes", "malvinas","Sousa", "123456789", "123");
		
		Assert.assertTrue("erro no equals objetos diferentes",endereco.equals(endereco2));
		Assert.assertFalse("erro no equals objetos iguais",endereco.equals(endereco3));
		Assert.assertFalse("erro no equals objetos iguais",endereco.equals(endereco4));
		Assert.assertFalse("erro no equals objetos iguais",endereco2.equals(endereco5));
		Assert.assertFalse("erro no equals objetos iguais",endereco4.equals(endereco5));
		Assert.assertFalse("erro no equals objetos iguais",endereco6.equals(endereco5));
		Assert.assertFalse("erro no equals objetos iguais",endereco3.equals(endereco4));
		Assert.assertFalse("erro no equals objetos iguais",endereco2.equals(endereco3));
	}

}
