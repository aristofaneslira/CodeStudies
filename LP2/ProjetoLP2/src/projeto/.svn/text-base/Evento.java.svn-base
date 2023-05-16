package projeto;

import java.util.*;
import java.io.Serializable;
import java.text.*;

/**
 * Classe que representa um evento.
 * 
 *  
 * @author Demetrio Gois - demetrio.gois@gmail.com
 * @author Rodrigo Santos - ccc.rodrigo@gmail.com
 * @author Bernard Lenin - bernard.lenin4@gmail.com
 * @author Alisson Carlos - alissonccsufcg@gmail.com
 * 
 * @version 1.0
 * 
 * 			Copyright (C) 2011 Universidade Federal de Campina Grande.
 *
 */
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome, descricao = "";
	private List<Contato> contatosDoEvento = null;
	private Date  dataeHorarioEvento;
	private Date  duracaoEvento;
	private Date  horarioDeTermino;
	private SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm:ss");
	private SimpleDateFormat formatadorDataeHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/**
	 * Construtor de Evento
	 * 
	 * @param nome
	 * O nome do evento
	 * @param data1
	 * A Data do Evento no formato DD/MM/YYYY
	 * @param hora1
	 * A Hora do evento no formato hh:mm:ss
	 * @param duracao
	 * A Duracao do evento no formato hh:mm:ss
	 * @param descricao
	 * Descricao do Evento
	 * @throws Exception
	 * Caso o nome do evento seja passado em branco eh lancado excessao
	 */
	public Evento(String nome, String data1, String hora1, String duracao, String descricao) throws Exception {
		if (nome.isEmpty() || nome == null)
			throw new Exception("Nome invalido.");

		this.nome = nome;
		this.descricao = descricao;

		setDataeHorario(data1 + " " + hora1);
		setDuracao(duracao);
		setHoraDeTermino();

		contatosDoEvento = new ArrayList<Contato>();
	}

	/**
	 * Metodo que adiciona contato ao evento
	 * @param contato
	 * Objeto do tipo contato que deve ser passado como parameto
	 * @return
	 * Retorna true caso com objeto seja inserido com sucesso
	 */

	public void adicionaContato(ArrayList<Contato> contato) {
		this.contatosDoEvento.addAll(contato);

	}
	/**
	 * Retorna a lista de contatos do evento
	 * @return
	 */
	public List<Contato> getContatosDoEvento() {
		return contatosDoEvento;
	}

	/**
	 * Retorna o nome do evento
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Modificia o nome do evento
	 * @param nome
	 * Retorna excessï¿½o caso o seja em branco ou null
	 * @throws Exception
	 */
	public void setNome(String nome) throws Exception {
		if (nome.isEmpty() || nome == null)
			throw new Exception("Nome do contato deve ser inserido.");

		this.nome = nome;
	}

	/**
	 * Retorna um String no formato DD/MM/YYYY representando a data do evento.
	 * @return
	 */
	public String getData() {
		return formatadorData.format(dataeHorarioEvento);
	}

	/**
	 * Modifica a data do Evento
	 * @param data1
	 */
	public void setDataeHorario(String data1) {
		try {
			dataeHorarioEvento = formatadorDataeHora.parse(data1);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Retorna um string no formato hh:mm:ss representando o horï¿½rio do evento
	 * @return
	 */
	public String getHorario() {
		return formatadorHora.format(dataeHorarioEvento);
	}

	/**
	 * Modifica o horario do evento
	 * @param hora1
	 */
	public void setHorario(String hora1){
		try {
			dataeHorarioEvento = formatadorDataeHora.parse(getData() + " " + hora1);
			setHoraDeTermino();
		} 
		catch (ParseException ex) {
			ex.printStackTrace();
		}

	}
	
	public void setData(String data){
		try {
			dataeHorarioEvento = formatadorDataeHora.parse(data + " " + getHorario());
			setHoraDeTermino();
		} 
		catch (ParseException ex) {
			ex.printStackTrace();
		}
		
	}
	/**
	 * Retorna um string no formato hh:mm:ss representando a duracao do evento
	 * @return
	 */
	public void setDuracao(String hora1){
		try {
			duracaoEvento = formatadorHora.parse(hora1);
			} catch (ParseException ex) {
			ex.printStackTrace();
		}

	}
	/**
	 * Retorna um String que representa a duracao do evento
	 * @return
	 */
	public String getDuracao() {
		return formatadorHora.format(duracaoEvento);
	}

	/**
	 * Apartir da hora de do evento e de sua duraï¿½ï¿½o esse metï¿½do gera a hora de termino.
	 */
	@SuppressWarnings("deprecation")
	public void setHoraDeTermino(){
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(dataeHorarioEvento);
		g.add(Calendar.HOUR ,duracaoEvento.getHours());
		g.add(Calendar.MINUTE ,duracaoEvento.getMinutes());
		g.add(Calendar.SECOND ,duracaoEvento.getSeconds());
		horarioDeTermino = g.getTime();
		
	}
	
	
	/**
	 * Retorna a descricao do evento
	 * @return
	 */
	

	public String getDescricao() {
		return descricao;
	}
	
	

	/**
	 * Retorna a descricao do evento
	 * @param descricao
	 */
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Metodo para acessar a hora do evento
	 * 
	 * @return
	 * 			Retorna a hora do evento.
	 */
	public long getHoraDeTerminoEmMilisegundos() {
		return horarioDeTermino.getTime();
	}

	public long getHoraEmMilisegundos(){
		return dataeHorarioEvento.getTime();

	}

	/**
	 * Metodo retorna um inteiro menor que zero caso o evento ja tenha ocorrido de acordo com a data atual, zero caso o evento esteja ocorrendo no momento em que o metodo foi chamado, e retorna um inteiro
	 * positivo caso o evento seja futuro em relação a data atual.
	 * @return
	 */
	public int getStatusEvento() {
		Date d = new Date();
		return dataeHorarioEvento.compareTo(d);
		
	}
	
	/**
	 * Metodo que verifica se um objeto do tipo evento tem intersecao de horario com outro do mesmo tipo.
	 * @param evento
	 * @return
	 */
	public boolean intercedeCom(Evento evento) {
		
		if(getHoraEmMilisegundos() >= evento.getHoraEmMilisegundos() && getHoraEmMilisegundos() < evento.getHoraDeTerminoEmMilisegundos() && getData().equals(evento.getData())){
			return true;
			}
		
		if(evento.getHoraEmMilisegundos() >= getHoraEmMilisegundos() && evento.getHoraEmMilisegundos() < getHoraDeTerminoEmMilisegundos() && getData().equals(evento.getData())){
			return true;
			}
		
		return false;

	}

	/**
	 * Representacao do evento numa String.
	 */
	
	@Override
	public String toString() {
		return "Evento: " + getNome() + "\n" + "Data: " + getData() + "\n" 
				+ "Hora: " + getHorario() + "\n" + "Duracao: " + getDuracao() + "\n"
				+ "Descricao: " + getDescricao();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataeHorarioEvento == null) ? 0 : dataeHorarioEvento
						.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (dataeHorarioEvento == null) {
			if (other.dataeHorarioEvento != null)
				return false;
		} else if (!dataeHorarioEvento.equals(other.dataeHorarioEvento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
