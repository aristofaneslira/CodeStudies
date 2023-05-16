//Rodrigo Santos Salviano

package lp2.lab06;

/**
 * Classe que representa um Candidato.
 * 
 * @author Rodrigo
 *
 */

public class Candidato {
	private String nome, codigo;
	
	/** 
	 * Construtor de um Candidato,
	 * 
	 * @param nome
	 * 				Nome do Candidato.
	 * @param codigo
	 * 				Codigo do Condidato.
	 */
	
	public Candidato(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	/**
	 * Metodo para acessar o nome do candidato.
	 * 
	 * @return Retorna o nome do Candidato.
	 */

	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo para acessar o codigo do Candidato.
	 * 
	 * @return Retorna o codigo do Candidato.
	 */

	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Retorna informacoes deum Candidato numa String.
	 */
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + " Codigo: " + getCodigo();
	}
	
	/**
	 * Verifica se dois Candidatos sao iguais atraves do codigo.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Candidato))
			return false;
		Candidato candidato = (Candidato) obj;
		return getCodigo().equals(candidato.getCodigo());
	}

}
