package projeto;

import org.junit.*; 
import projeto.Telefone;
/**
 * 
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
public class TestaTelefone {
	private Telefone telefone;
	
	@Test public void TestaConstrutorTelefone()throws Exception{
		try{
			telefone = new Telefone(33334444) {
			}; 
			
		}catch(Exception exception){
			System.err.printf("erro no construtor parametro invalido");
		}
		
	}
	
	@Test public void TestaGetNumero(){
		telefone = new Telefone(33334444) {
		}; 
		Assert.assertEquals("numero errado",33334444,telefone.getNumero());
		Assert.assertNotSame("numero errado",33334445,telefone.getNumero());
		Assert.assertNotSame("numero errado","33334444",telefone.getNumero());
		Assert.assertNotSame("numero errado","",telefone.getNumero());
	}
	
	@Test public void TestaSetNumero(){
		telefone = new Telefone(33334444) {
		}; 
		Assert.assertEquals("numero errado",33334444,telefone.getNumero());
		Assert.assertNotSame("numero errado",33334445,telefone.getNumero());
		Assert.assertNotSame("numero errado","33334444",telefone.getNumero());
		Assert.assertNotSame("numero errado","",telefone.getNumero());
		telefone.setNumero(22223333);
		Assert.assertNotSame("numero errado",33334444,telefone.getNumero());
		Assert.assertEquals("numero errado",22223333,telefone.getNumero());
		Assert.assertNotSame("numero errado","22223333",telefone.getNumero());
	}
	
	@Test public void TestaToString(){
		telefone = new Telefone(33334444) {
		};
		Assert.assertEquals("erro na captura do toString","Numero: " + 33334444,telefone.toString());
	}
	

}