// Rodrigo Santos Salviano

package lp2.lab06;

import java.util.*;

/**
 * Classe que representa uma urna eletronica.
 * 
 * @author Rodrigo
 *
 */

public class UrnaEletronica {
	private int votosAReceber, votoAtual, votosValidos, numeroDoDepartamento;
	private String departamento;
	private List<Candidato> candidatos = new ArrayList<Candidato>();
	private Candidato branco, nulo;
	private String[] departamentos = {"", "DSC", "DF", "DME", "UAL", "DEE"};
	private List<Integer> votos;
	private Resultado[] resultados;
	
	/**
	 * Construtor de uma UrnaEletronica.
	 * 
	 * @param votosAReceber
	 * 						Numero de votos que a urna estara apta a receber.
	 * @param numeroDoDepartamento
	 * 						Numero representando o departamento onde a urna estara disponivel.
	 */
	
	public UrnaEletronica(int votosAReceber, int numeroDoDepartamento) {
		this.votosAReceber = votosAReceber;
		this.numeroDoDepartamento = numeroDoDepartamento;
		this.departamento = departamentos[numeroDoDepartamento];
	}
	
	/**
	 * Metodo para cadastrar Candidatos.
	 * 
	 * @param candidatos
	 * 					Array de Candidatos.
	 * @throws Exception
	 * 					Lanca excessao caso haja a tentativa de cadastrar candidatos iguais.
	 */
	
	public void cadastrarCandidato(Candidato[] candidatos) throws Exception {
		for (Candidato candidato : candidatos) {
			if (this.candidatos.contains(candidato))
				throw new Exception("Tentativa de cadastrar um candidato ja cadastrado.");
			else
				this.candidatos.add(candidato);
		}
		this.branco = new Candidato("Branco", "0");
		this.nulo = new Candidato("Nulo", "99");
		this.candidatos.add(branco);
		this.candidatos.add(nulo);
	}
	
	/**
	 * Inicializa a contagem de votos de todos os candidatos.
	 */
	
	public void zerarVotos() {
		this.votos = new ArrayList<Integer>(this.candidatos.size());
		for (int i = 0; i < this.candidatos.size(); i++) {
			this.votos.add(i, 0);
		}
	}
	
	/**
	 * Habilitar a urna para receber voto.
	 * 
	 * @return Retorna true se for habilitada e false caso contrario.
	 */
	
	public boolean habilitarVoto() {
		if (this.votoAtual <= votosAReceber)
			return true;
		return false;
	}
	
	/**
	 * Metodo que permite votar.
	 * 
	 * @param eleitor
	 * 					Tipo de eleitor (aluno, funcionario e professor).
	 * @param candidato
	 * 					Candidato que recebera o voto.
	 * @return Retorna true se o voto for realizado com sucesso e false caso contrario.
	 * 
	 */
	
	public boolean votar(String eleitor, Candidato candidato) {
		this.votoAtual += 1;

		if (habilitarVoto()) {
			if (eleitor.equals("aluno")) {
				this.votos.add(this.candidatos.indexOf(candidato), 1 + this.candidatos.indexOf(candidato));
				return true;
			}
			else if (eleitor.equals("funcionario")) {
				this.votos.add(this.candidatos.indexOf(candidato), 3 + this.candidatos.indexOf(candidato));
				return true;
			}
			else {
				this.votos.add(this.candidatos.indexOf(candidato), 5 + this.candidatos.indexOf(candidato));
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que apura a contagem de votos da urna.
	 * 
	 * @return Retorna um Array de Resultado.
	 */
	
	public Resultado[] apurar() {
		resultados = new Resultado[this.candidatos.size()];
		for (int i = 0; i < resultados.length; i++) {
			resultados[i] = new Resultado(this.candidatos.get(i), this.votos.get(i));
		}
		return resultados;
	}
	
	/**
	 * finaliza a votacao caso seja extrapolado o horario ou a quantidade de votos que a urna estara apta a receber.
	 * 
	 * @return Retorna true para finalizar a urna e false caso a urna nao seja finalizada ainda.
	 */
	
	public boolean finalizar() {
		if (votoAtual >= votosAReceber || getHora() >= 17)
			return true;
		return false;
	}
	
	/**
	 * Metodo para acessar a quantidade de votos nulos.
	 * 
	 * @return Retorna a quantidade de votos nulos.
	 */
	
	public int getVotosNulo() {
		return this.votos.get(this.candidatos.indexOf(nulo));
	}
	
	/**
	 * Metodo para acessar a quantidade de votos brancos.
	 * 
	 * @return Retorna a quantidade de votos brancos.
	 */
	
	public int getVotosBranco() {
		return this.votos.get(this.candidatos.indexOf(branco));
	}
	
	/**
	 * Metodo para acessar a quantidade de votos validos.
	 * 
	 * @return Retorna a quantidade de votos validos.
	 */
	
	public int getVotosValidos() {
		for (Candidato candidato : this.candidatos) {
			votosValidos += this.votos.get(this.candidatos.indexOf(candidato));
		}
		votosValidos -= this.votos.get(this.candidatos.indexOf(branco));
		votosValidos -= this.votos.get(this.candidatos.indexOf(branco));
		
		return votosValidos;
	}
	
	/**
	 * Metodo para acessar o departamento onde a urna esta disponivel.
	 * 
	 * @return Retorna o departamento onde a urna esta disponivel.
	 */
	
	public String getDepartamento() {
		return departamento;
	}
	
	/**
	 * Retorna informacoes da urna numa String.
	 */
	
	@Override
	public String toString() {
		return "Urna Eletronica n.: " + this.numeroDoDepartamento + "\nDisponivel em: " + getDepartamento();
	}
	
	/**
	 * Compara se duas urnas sao iguais atraves do departamento. 
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof UrnaEletronica))
			return false;
		UrnaEletronica urna = (UrnaEletronica) obj;
		return getDepartamento().equals(urna.getDepartamento());
	}
	
	/**
	 * Metodo para acessar a hora atual do sistema.
	 * 
	 * @return Retorna a hora no memento e que o metodo foi chamado.
	 */
	
	private int getHora() {
		GregorianCalendar hora = new GregorianCalendar();
		return hora.get(GregorianCalendar.HOUR_OF_DAY);
	}
}
