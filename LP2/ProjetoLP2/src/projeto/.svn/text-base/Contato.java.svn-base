package projeto;

import java.io.Serializable;
import java.util.*;

/**
 * Classe para representar um contato.
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

public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome, comentario = "";
	private Endereco endereco = null;
	private String aniversario = null;
	private List<FormaDeContato> formasDeContato;
	
	/**
	 * Construtor de um contato.
	 * 
	 * @param nome
	 * 				Nome do contato.
	 * @param celular
	 * 				Telefone Celular do contato.
	 * @param residencial
	 * 				Telefone residencial do contato.
	 * @param endereco
	 * 				Endereco do contato.
	 * @param email
	 * 				Email do contato.
	 * @param aniversario
	 * 				Data de aniversari/nascimento do contato.
	 * @throws Exception
	 */
	
	public Contato(String nome, Endereco endereco, String aniversario, List<FormaDeContato> formasDeContato, String comentario) throws NomeInvalidoException {
		if (nome == null || nome.isEmpty())
			throw new NomeInvalidoException();
		
		this.nome = nome;
		this.endereco = endereco;
		this.aniversario = aniversario;
		this.formasDeContato = formasDeContato;
		this.comentario = comentario;
	}
	
	/**
	 * Metodo para acessar um comentario sobre o contato.
	 * 
	 * @return
	 * 			Retorna um comentario sobre o contato.
	 */
	
	public String getComentario() {
		return comentario;
	}
	
	/**
	 * Modifica o comentario sobre o contato.
	 * 
	 * @param comentario
	 */

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * Metodo acessador do nome do contato.
	 * 
	 * @return
	 * 			o nome do contato.
	 */

	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo modificador do nome do contato.
	 * 
	 * @param nome
	 * 				Novo nome do contato.
	 * @throws Exception
	 * 				Excecao caso haja a tentativa de inserir nomes como null ou strings vazias.
	 */

	public void setNome(String nome) throws NomeInvalidoException {
		if (nome == null || nome.isEmpty())
			throw new NomeInvalidoException();
		
		this.nome = nome;
	}
	
	/**
	 * Metodo acessador da data de aniversario.
	 * 
	 * @return
	 * 			Retorna a data de aniversario/nascimento.
	 */

	public String getAniversario() {
		return aniversario;
	}

	/**
	 * Metodo modificador para a data de aniversario/nascimento.
	 * 
	 * @param aniversario
	 * @throws Exception
	 */

	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	/**
	 * Metodo modificador do endereco.
	 * 
	 * @param endereco
	 * 				Novo endereco do contato.
	 */

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * Metodo para acessar as formas de contato.
	 * 
	 * @return
	 * 			Lista com as formas de contato.
	 */

	public List<FormaDeContato> getFormasDeContato() {
		return formasDeContato;
	}
	
	
	public void setFormasDeContato(List<FormaDeContato> formasDeContato) throws Exception {
		if (formasDeContato.isEmpty())
			throw new Exception("Deve haver pelo menos umas formas de contato.");
		this.formasDeContato = formasDeContato;
	}

	/**
	 * Adiciona uma forma de contato.
	 */
	
	public boolean addFormaDeContato(FormaDeContato f) {
		if (formasDeContato.size() < 6)
			return formasDeContato.add(f);
		return false;
	}
	
	/**
	 * Representacao do contato na forma de String.
	 */
	
	@Override
	public String toString() {
		Iterator<FormaDeContato> it = formasDeContato.iterator();
		String fdc = "";
		while (it.hasNext()) {
			FormaDeContato f = (FormaDeContato) it.next();
			fdc += f.toString() + "\n";
		}
		return "Informacoes do contato\nNome: " + getNome() + "\nEndereco\n" + getEndereco().toString() + "\n" + fdc + "Data de aniversario/nascimento: " + getAniversario() + "\nComentario: " + getComentario();
	}
	
	/**
	 * Retorna o valor do hash code do objeto.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Verifica se dois contatos s�o iguais.
	 */

	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Contato))
			return false;
		Contato contato = (Contato) obj;
		return getNome().equals(contato.getNome()) && getAniversario().equals(contato.getAniversario());
	}
}