package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Classe que representa uma agenda armazenavel. A agenda guarda informacoes de contatos e eventos.
 * 
 * @author Demetrio Gois - demetrio.gois@gmail.com
 * @author Rodrigo Santos - ccc.rodrigo@gmail.com
 * @author Bernard Lenin - bernard.lenin4@gmail.com
 * @author Alisson Carlos - alissonccsufcg@gmail.com
 * 
 * @version 1.0
 * 
 * 			Copyright (C) 2011 Universidade Federal de Campina Grande.
 */
public class Agenda implements Serializable {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contatos == null) ? 0 : contatos.hashCode());
		result = prime * result + ((eventos == null) ? 0 : eventos.hashCode());
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
		Agenda other = (Agenda) obj;
		if (contatos == null) {
			if (other.contatos != null)
				return false;
		} else if (!contatos.equals(other.contatos))
			return false;
		if (eventos == null) {
			if (other.eventos != null)
				return false;
		} else if (!eventos.equals(other.eventos))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;
	List<Contato> contatos;
	List<Evento> eventos;
	
	/**
	 * Construtor default de uma agenda.
	 * 	
	 */
	public Agenda(){
		
		contatos = new ArrayList<Contato>();
		eventos = new ArrayList<Evento>();
	}
	

	/**
	 * Adiciona um evento a agenda.
	 * 
	 * @param evento
	 * 		Evento a ser adicionado.
	 */
	public void addEvento(Evento evento){
		eventos.add(evento);
	}
	
	/**
	 * Recupera a lista de eventos cadastrados na agenda.
	 * @return
	 * 		Lista de eventos.
	 */
	public List<Evento> getEventos(){
		return eventos;
	}
	
	
	/**
	 * Recupera a lista de contatos cadastrados na agenda.
	 * @return
	 * 		Lista de contatos.
	 */
	public List<Contato> getContatos(){
		return contatos;
	}
	/**
	 * Adiciona um contato a agenda.
	 * 
	 * @param contato
	 * 		Contato a ser adicionado.
	 */
	public void addContato(Contato contato){
		contatos.add(contato);
	}
	
	/**
	 * Apaga todos os contatos da agenda.
	 * 
	 */
	public void limparContatos(){
			contatos.clear();
	}
	
	/**
	 * Cria um iterador para a lista de eventos cadastrados.
	 * 
	 * @return
	 * 		Um iterator de eventos.
	 */
	public Iterator<Evento> iteratorDeEventos() {
		return eventos.iterator();
	}
	/**
	 * Cria um iterador para a lista de contatos cadastrados.
	 * 
	 * @return
	 * 		Um iterator de contatos.
	 */
	public Iterator<Contato> iteratorDeContatos() {
		return contatos.iterator();
	}
	
	/**
	 * Remove um dado evento da agenda.
	 *
	 * @param evento
	 * 		Evento a ser removido.
	 */
	public void removeEvento(Evento evento) {
		eventos.remove(evento);
	}
	
	/**
	 * Remove um dado contato da agenda.
	 * 
	 * @param contato
	 * 		Contato a ser removido.
	 */	
	public void removeContato(Contato contato) {
		eventos.remove(contato);
	}
	
	/**
	 * Retorna um inteiro que indica o numero de eventos cadastrados na agenda.
	 * 
	 * @return
	 * 		O numero de eventos.
	 */
	public int numeroDeEventos() {
		return eventos.size();
	}
	
	/**
	 * Retorna um inteiro que indica o numero de cadastros cadastrados na agenda.
	 * 
	 * @return
	 * 		O numero de contatos.
	 */
	public int numeroDeContatos() {
		return contatos.size();
	}
	
	/**
	 * Pesquisa a agenda em busca do evento passado como argumento.
	 * 
	 * @param nome
	 * 		Nome do evento a ser pesquisado.
	 * @return
	 * 		True se existir o evento.
	 * 		False se não existir o evento.
	 */
	public boolean contemEvento(String nome) {
		Iterator<Evento> it = eventos.iterator();
		while (it.hasNext()) {
			Evento e = (Evento) it.next();
			if (e.getNome().toLowerCase().equals(nome.toLowerCase()))
					return true;
		}
		return false;
	}
	
	/**
	 * Pesquisa a agenda em busca do contato passado como argumento.
	 * 
	 * @param nome
	 * 		Nome do contato a ser pesquisado.
	 * @return
	 * 		True se existir o contato.
	 * 		False se não existir o contato.
	 */
	public boolean contemContato(String nome) {
		Iterator<Contato> it = contatos.iterator();
		while (it.hasNext()) {
			Contato c = (Contato) it.next();
			if (c.getNome().toLowerCase().equals(nome.toLowerCase()))
					return true;
		}
		return false;
	}
	
	/**
	 * Pesquisa todos os contatos que tiverem o nome passado como argumento.
	 * 
	 * @param nomeContato
	 * 		Nome do contato a ser buscado.
	 * @return
	 * 		Lista de contatos que contiverem o nome passado.
	 */
	public List<Contato> pesquisaContatos(String nomeContato) {
		Iterator<Contato> it = contatos.iterator();
		List<Contato> contatosEncontrados = new ArrayList<Contato>();
		while (it.hasNext()) {
			Contato contato = (Contato) it.next();
			if (contato.getNome().toLowerCase().contains(nomeContato.toLowerCase()))
				contatosEncontrados.add(contato);
		}
		return contatosEncontrados;
	}
	
	public List<Evento> pesquisaEventos(String nome) {
		Iterator<Evento> it = eventos.iterator();
		List<Evento> eventosEncontrados = new ArrayList<Evento>();
		while (it.hasNext()) {
			Evento evento = (Evento) it.next();
			if (evento.getNome().toLowerCase().contains(nome.toLowerCase()))
				eventosEncontrados.add(evento);
		}
		return eventosEncontrados;
	}
	
	/**
	 * Pesquisa todos os eventos que tiverem o nome passado como argumento.
	 * 
	 * @param nomeEvento
	 * 		Nome do evento a ser buscado.
	 * @return
	 * 		Lista de eventos que contiverem o nome passado.
	 */
	public Evento pesquisaEvento(String nomeEvento) {
		Iterator<Evento> it = eventos.iterator();
		while (it.hasNext()) {
			Evento evento = (Evento) it.next();
			if (evento.getNome().toLowerCase().equals(nomeEvento.toLowerCase()))
				return evento;
		}
		return null;
	}
	
	/**
	 * Retorna a lista de eventos passados.
	 * @return
	 * Lista contendo os eventos passados
	 */
	public List<Evento> eventosPassados(){
		List<Evento> eventosPassados = new ArrayList<Evento>();
		Iterator<Evento> it = eventos.iterator();
		while(it.hasNext()){
			Evento evento = (Evento) it.next();
			if(evento.getStatusEvento() < 0)
				eventosPassados.add(evento);
		}
		return eventosPassados;
	}
	/**
	 * Retorna os eventos futuros
	 * @return
	 * Lista de eventos contendo os eventos futuros.
	 */
	public List<Evento> eventosFuturos(){
		List<Evento> eventosFuturos = new ArrayList<Evento>();
		Iterator<Evento> it = eventos.iterator();
		while(it.hasNext()){
			Evento evento = (Evento) it.next();
			if(evento.getStatusEvento() > 0)
				eventosFuturos.add(evento);
		}
		return eventosFuturos;
	}
	
	/**
	 * Pesquisa determinados eventos que contenham o contato passado como argumento.
	 * 
	 * @param contato
	 * 		Contato a ser pesquisa na lista de Eventos.
	 * @return
	 * 		Lista de eventos que possui aquele contato.
	 */
	public List<Evento> pesquisaEventosPorContato(Contato contato){
		
		Iterator<Evento> it = eventos.iterator();
		List<Evento> eventosEncontrados = new ArrayList<Evento>();
		
		while(it.hasNext()){
			Evento evento = (Evento) it.next();
			ArrayList<Contato> contatosDoEvento = (ArrayList<Contato>) evento.getContatosDoEvento();
			Iterator<Contato> it2 = contatosDoEvento.iterator();
			
			//Laço que varre a lista de contatos do evento da vez.
			while(it2.hasNext()){
				Contato contatoDaVez = (Contato) it2.next();
				if(contatoDaVez.equals(contato)){
					eventosEncontrados.add(evento);
				}// Fim do laço.
				
			}
		}
		return eventosEncontrados;
	}


	/**
	 * Representa em forma de String uma agenda.
	 */
	@Override
	public String toString() {
		return "Agenda [contatos=" + contatos + ", eventos=" + eventos + "]";
	}

}