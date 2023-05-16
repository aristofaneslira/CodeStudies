package projeto;

import java.io.Serializable;

/**
 * Classe abstrata que representar um telefone.
 * 
 *  
 * @author Demétrio Góis - demetrio.gois@gmail.com
 * @author Rodrigo Santos - ccc.rodrigo@gmail.com
 * @author Bernard Lenin - bernard.lenin4@gmail.com
 * @author Alisson Carlos - alissonccsufcg@gmail.com
 * 
 * @version 1.0
 * 
 * 			Copyright (C) 2011 Universidade Federal de Campina Grande.
 *
 */

public class Telefone implements Serializable, FormaDeContato {
	private static final long serialVersionUID = 1L;
	private String numero;
	
	/**
	 * Contrutor de Telefone.
	 * 
	 * @param numResidencial
	 * 				O numero do telefone.
	 */
	
	public Telefone(String numTelefone) throws TelefoneInvalidoException {
		if (numTelefone == null || numTelefone.isEmpty() || (!numTelefone.matches("^[0-9]*$")))
			throw new TelefoneInvalidoException();
			
		this.numero = numTelefone;
	}
	
	/**
	 * Metodo para acessar o numero do Telefone.
	 * 
	 * @return
	 * 			Retorna o numero do Telefone.
	 */
	
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Metodo para alterar o numero do Telefone.
	 * 
	 * @param numero
	 * 				O novo numero do telefone
	 */
	
	public void setNumero(String novoNumero) throws TelefoneInvalidoException {
		if (novoNumero == null || novoNumero.isEmpty() || (!novoNumero.matches("^[0-9]*$")))
			throw new TelefoneInvalidoException();
		this.numero = novoNumero;
	}
	
	/**
	 * Retorna o Telefone em forma de String
	 */
	
	@Override
	public String toString() {
		return "Numero: " + getNumero();
	}
	
}