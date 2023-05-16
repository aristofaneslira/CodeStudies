//Rodrigo Santos Salviano

package lp2.lab07;

import java.util.*;

/**
 * Classe que representa um CD de faixas musicais.
 * 
 * @author Rodrigo
 *
 */

public class CDEspecial {
	private String autor, titulo, carroChefe;
	private int m;
	private List<String> cd;
	
	/**
	 * Construtor de um CD.
	 * 
	 * @param titulo
	 * 				Titulo do CD
	 * @param autor
	 * 				Autor do CD.
	 * @param m
	 * 				Numero de faixas do album.
	 * @throws Exception
	 * 				Lanca excessao para strings vazias ou null.
	 */
	
	public CDEspecial(String titulo, String autor, int m) throws Exception {
		if (titulo.equals("") || titulo == null || autor.equals("") || autor == null)
			throw new Exception("Titulo ou autor sao invalidos.");
		if (m <= 0)
			throw new Exception("Valor invalido para a quantidade de faixas.");

		this.titulo = titulo;
		this.autor = autor;
		this.m = m;
		this.carroChefe = null;
		this.cd = new ArrayList<String>(m);
	}
	
	/**
	 * Construtor de um CD.
	 * 
	 * @param titulo
	 * 				Titulo do CD.
	 * @param autor
	 * 				Autor do CD.
	 * @param m
	 * 				Numero de faixas do album.
	 * @param carroChefe
	 * 				Principal musica do album.
	 * @throws Exception
	 * 				Lanca excessao para strings vazias ou null.
	 */

	public CDEspecial(String titulo, String autor, int m, String carroChefe) throws Exception {
		if (titulo.equals("") || titulo == null || autor.equals("") || autor == null)
			throw new Exception("Titulo ou autor sao invalidos.");
		if (m <= 0)
			throw new Exception("Valor invalido para a quantidade de faixas.");
		
		this.titulo = titulo;
		this.autor = autor;
		this.m = m;
		this.carroChefe = carroChefe;
		this.cd = new ArrayList<String>(m);
	}
	
	/**
	 * @return Retorna a faixa principal do CD.
	 */

	public String getCarroChefe() {
		return carroChefe;
	}
	
	/**
	 * Altera a faixa principal do CD.
	 * 
	 * @param carroChefe
	 * 				Principal musica do CD.
	 */

	public void setCarroChefe(String carroChefe) {
		this.carroChefe = carroChefe;
	}
	
	/**
	 * @return Retorna o autor do CD.
	 */

	public String getAutor() {
		return autor;
	}
	
	/**
	 * @return Retorna o titulo do CD.
	 */

	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Verfica se existe uma musica na i-esima posicao do CD.
	 * 
	 * @param i
	 * 			Int para retornar se existe uma musica.
	 * @return Retorna o nome da faixa caso exista ou retorna null.
	 */

	public String retornarFaixa(int i) {
		if (i < 0 || i > this.cd.size())
			return null;
		return this.cd.get(i);
	}
	
	/**
	 * Metodo para cadastrar uma musica no CD.
	 * 
	 * @param faixa
	 * 				Faixa a ser adicionada.
	 * @return Retorna true se o cadastro for realizado e false caso nao seja realizado.
	 * @throws Exception
	 * 				Lanca excessao para strings vazias ou null.
	 */
	
	public boolean cadastrarFaixa(String faixa) throws Exception {
		if (faixa == null || faixa.equals(""))
			throw new Exception("Faixa nao pode ser null ou vazia.");
		if (this.cd.size() >= this.m)
			return false;
		return this.cd.add(faixa);
	}
	
	/**
	 * Retorna as informacoes do CD numa String.
	 */
	
	@Override
	public String toString() {
		String informacoesDoCD =  "Autor: " + getAutor() + " Titulo: " + getTitulo() + " Carro Chefe: " + getCarroChefe() + " Musicas: ";
		for (String musica : this.cd) {
			informacoesDoCD += (this.cd.lastIndexOf(musica) + 1) +  " - " + musica + "/ ";
		}
		return informacoesDoCD;
	}
	
	/**
	 * Compara se dois DCs sao iguais atravas do titulo e do autor.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof CDEspecial))
			return false;
		CDEspecial cd = (CDEspecial) obj;
		if (getAutor().equals(cd.getAutor()) && getTitulo().equals(cd.getTitulo()))
			return true;
		return false;
	}
}