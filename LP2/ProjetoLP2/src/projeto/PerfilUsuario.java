package projeto;

import java.io.Serializable;

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
public class PerfilUsuario implements Serializable {

	private static final  long  serialVersionUID = 1L;
	private String nome = null;
	private String email = null;
	private String descricao = null;

	/**
	 * Cria um perfil de usu�rio a partir do seu nome, e-mail e descricao.
	 * 
	 * @param nome
	 * 		O nome do usu�rio que ser� colocado no perfil.
	 * @param email
	 * 		O e-mail do usu�rio.
	 * @param descricao
	 * 		Uma descri��o para o usu�rio.
	 * @throws NomeInvalidoException 
	 * @throws EmailInvalidoException 
	 */
	public PerfilUsuario(String nome, String email, String descricao) throws NomeInvalidoException, EmailInvalidoException {
		if (nome == null || nome.isEmpty())
			throw new NomeInvalidoException();
		
		if (email == null || email.isEmpty())
			throw new EmailInvalidoException();
		
		if (!(ValidadorDeCampos.validaEmail(email)))
			throw new EmailInvalidoException();

		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}
	/**
	 * Recupera o nome do perfil.
	 * @return O nome do perfil.
	 * 
	 */
	public String getNome(){
		return nome;
	}
	/**
	 * Modifica o nome do perfil.
	 * @param novoNome
	 * 			O nome a ser modificado.
	 */
	public void setNome(String novoNome){
		nome = novoNome;
	}
	/**
	 * Recupera a descri��o do perfil.
	 * @return	A descri��o do perfil.
	 */
	public String getDescricao(){
		return descricao;
	}
	/**
	 * Modifica a descri��o do perfil.
	 * @param novaDescricao
	 * 			A descri��o a ser modificada.
	 */
	public void setDescricao(String novaDescricao){
		descricao = novaDescricao;
	}
	/**
	 * Recupera o e-mail do perfil.
	 * @return O e-mail do perfil.
	 */
	public String getEmail(){
		return email;
	}
	/**
	 * Modifica o e-mail do perfil.
	 * @param novoEmail
	 * 			O e-mail a ser modificado.
	 * @throws EmailInvalidoException 
	 */
	public void setEmail(String novoEmail) throws EmailInvalidoException{
		if (email == null || email.isEmpty())
			throw new EmailInvalidoException();
		
		if (!(ValidadorDeCampos.validaEmail(email)))
			throw new EmailInvalidoException();
		
		email = novoEmail;
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nEmail: " + getEmail() + "\nDescricao: " + getDescricao();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof PerfilUsuario))
			return false;
		PerfilUsuario perfil = (PerfilUsuario) obj;
		return getNome().equals(perfil.getNome()) && getEmail().equals(getEmail()) && getDescricao().equals(perfil.getDescricao());
	}

}