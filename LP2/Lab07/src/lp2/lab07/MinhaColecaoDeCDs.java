//Rodrigo Santos Salviano

package lp2.lab07;

import java.util.*;

/**
 * Classe que representa uma colecao de CDs.
 * 
 * @author Rodrigo
 *
 */

public class MinhaColecaoDeCDs {

	List<CDEspecial> colecaoDeCDs;
	
	/**
	 * Contrutor de uma colecao de CDs.
	 */
	
	public MinhaColecaoDeCDs() {
		this.colecaoDeCDs = new ArrayList<CDEspecial>();
	}
	
	/**
	 * Adiciona um CD a colecao
	 * 
	 * @param cd
	 * 			CD a ser adicionado a colecao.
	 * @throws Exception
	 */
	
	public void adicionaCD(CDEspecial cd) throws Exception {
		if (cd == null)
			throw new Exception("Nao e um objeto CDEspecial valido.");
		this.colecaoDeCDs.add(cd);
	}
	
	/**
	 * Remove um CD da colecao identificado atraves do titulo.
	 * 
	 * @param titulo
	 * 				titulo do CD.
	 * @return
	 * 				Retorna o CD removido ou null caso o CD nao seja da colecao.
	 * @throws Exception
	 */
	
	public CDEspecial removeCD(String titulo) throws Exception {
		if (titulo == null || titulo.equals(""))
			throw new Exception("Titulo nao pode ser null ou vazio.");
		for (CDEspecial cd : this.colecaoDeCDs) {
			if (cd.getTitulo().equals(titulo)) {
				colecaoDeCDs.remove(cd);
				return cd;
			}
		}
		return null;
	}
	
	/**
	 * Verifica se um CD existe na colecao.
	 * 
	 * @param titulo
	 * 				Titulo do CD.
	 * @return
	 * 				Retorna o CD ou null caso o null caso o CD nao seja da colecao.
	 * @throws Exception
	 */
	
	public CDEspecial pesquisaCD(String titulo) throws Exception {
		if (titulo == null || titulo.equals(""))
			throw new Exception("Titulo nao pode ser null ou vazio.");
		for (CDEspecial cd : this.colecaoDeCDs) {
			if (cd.getTitulo().equals(titulo))
				return cd;
		}
		return null;
	}
	
	/**
	 * Verifica quantos CDs existem na colecao.
	 * 
	 * @return
	 * 			Retorna o numero de CDs existentes na colecao.
	 */
	
	public int numeroDeCDs() {
		return this.colecaoDeCDs.size();
	}
	
	/**
	 * Retorna informações da colecao numa String.
	 */
	
	@Override
	public String toString() {
		String infoColecaoDeCDs = "CDs na colecao:\n";
		for (CDEspecial cd : this.colecaoDeCDs) {
			infoColecaoDeCDs += cd + "\n";
		}
		return infoColecaoDeCDs;
	}
	
	/**
	 * Compara duas colecoes e verifica se possuem os mesmos cds.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof MinhaColecaoDeCDs))
			return false;
		MinhaColecaoDeCDs colecao = (MinhaColecaoDeCDs) obj;
		for (CDEspecial cd : colecao.getColecaoDeCDs()) {
			for (CDEspecial cd2 : this.colecaoDeCDs) {
				if (! (cd.equals(cd2)))
					return false;
				else
					continue;
			}
		}
		return true;
	}
	
	/**
	 * @return Retorna uma lista de CDs.
	 */
	
	public List<CDEspecial> getColecaoDeCDs() {
		return colecaoDeCDs;
	}
}
