package projeto;

import java.io.Serializable;

/**
 * Classe para representar um E-mail.
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

public class Email implements Serializable, FormaDeContato {
	private static final long serialVersionUID = 1L;
	private String email;
	
	/**
	 * Construtor da Classe Email.
	 * 
	 * @param email
	 * 				Endereco de Email.
	 * @throws Exception
	 * 				Lanca excecao caso o email seja invalido.
	 */
	
	public Email(String email) throws EmailInvalidoException {
		if (! (ValidadorDeCampos.validaEmail(email))){
			throw new EmailInvalidoException();
		}
		this.email = email;
	}
	
	/**
	 * Metodo para acessar o email.
	 * 
	 * @return
	 * 			Retorna o endereco do email.
	 */
	
	public String getEnderecoEmail() {
		return email;
	}
	
	/**
	 * Metodo para alterar o endereco do email.
	 * 
	 * @param novoEmail
	 * 				Endereco de Email.
	 * @throws Exception
	 * 				Lanca excecao caso o email seja invalido.
	 */
	
	public void setEmail(String novoEmail) throws EmailInvalidoException {
		if (! (ValidadorDeCampos.validaEmail(novoEmail))){
			throw new EmailInvalidoException();
		}
		this.email = novoEmail;
	}
	
	/**
	 * Retorna o email na forma de String
	 */
	
	@Override
	public String toString() {
		return "Email: " + getEnderecoEmail();
	}
	
	/**
	 * Retorna o valor do hash code do objeto.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	
	/**
	 * Verifica se outro email e igual a este email.
	 */

	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Email))
			return false;
		Email outroEmail = (Email) obj;
		return getEnderecoEmail().equals(outroEmail.getEnderecoEmail());
	}
}