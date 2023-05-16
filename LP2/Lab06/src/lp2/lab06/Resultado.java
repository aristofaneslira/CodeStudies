// Rodrigo Santos Salviano

package lp2.lab06;

/**
 * Classe que representa um resultado.
 * 
 * @author Rodrigo
 *
 */

public class Resultado {
	private Candidato candidato;
	private int numeroDeVotos;
	
	/**
	 * Construtor de um resultado.
	 * 
	 * @param candidato
	 * 					Um objto Candidato.
	 * @param numeroDeVotos
	 * 					Numero de votos de um Candidato.
	 */
	
	public Resultado(Candidato candidato, int numeroDeVotos) {
		this.candidato = candidato;
		this.numeroDeVotos = numeroDeVotos;
	}
	
	/**
	 * Metodo para acessar o candidato.
	 * 
	 * @return Retorna um Candidato.
	 */

	public Candidato getCandidato() {
		return candidato;
	}
	
	/**
	 * Metodo para acessar o numero de votos de um Candidato.
	 * 
	 * @return Retorna o numero de votos.
	 */

	public int getNumeroDeVotos() {
		return numeroDeVotos;
	}
	
	/**
	 * Retorna as informacoes de um Resultado numa String.
	 */
	
	@Override
	public String toString() {
		return "Candidato: " + candidato + "\nVotos recebidos: " + getNumeroDeVotos();
	}
}