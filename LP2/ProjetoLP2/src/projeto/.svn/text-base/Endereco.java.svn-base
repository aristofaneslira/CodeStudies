package projeto;

import java.io.Serializable;
import java.util.InputMismatchException;

/**
 * Classe para representar um endereço.
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


public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	private String lagradouro, bairro = "", cidadeEEstado = "", CEP = "", numeroDaResidencia;
	
	/**
	 * Construtor de um endereco.
	 * 
	 * @param lagradouro
	 * 				Rua, avenida, etc.
	 * @param bairro
	 * @param cidadeEEstado
	 * @param CEP
	 * @throws CEPInvalidoException 
	 */
	
	public Endereco(String lagradouro, String bairro, String cidadeEEstado, String CEP, String numeroDaResidencia) throws InputMismatchException {
		if (CEP != null && (!CEP.isEmpty()))
			if (!CEP.matches("^[0-9]*$"))
				throw new InputMismatchException();
		
		if (numeroDaResidencia != null && (!numeroDaResidencia.isEmpty()))
			if (!numeroDaResidencia.matches("^[0-9]*$"))
				throw new InputMismatchException();
		
		this.lagradouro = lagradouro;
		this.bairro = bairro;
		this.cidadeEEstado = cidadeEEstado;
		this.CEP = CEP;
		this.numeroDaResidencia = numeroDaResidencia;
	}
	
	/**
	 * Metodo para acessar a rua, avenida, etc.
	 * 
	 * @return
	 * 			Retorna rua, avenida, etc.
	 */

	public String getLagradouro() {
		return lagradouro;
	}
	
	/**
	 * Metodo para modificar o lagradouro.
	 * 
	 * @param novoLagradouro
	 */

	public void setLagradouro(String novoLagradouro) {
		this.lagradouro = novoLagradouro;
	}
	
	/**
	 * Metodo para acessar o bairro.
	 * 
	 * @return
	 * 			Retorna o bairro.
	 */

	public String getBairro() {
		return bairro;
	}
	
	/**
	 * Metodo para modificar o bairro.
	 * 
	 * @param novoBairro
	 */

	public void setBairro(String novoBairro) {
		this.bairro = novoBairro;
	}
	
	/**
	 * Metodo para acessar cidade e/ou estado.
	 * 
	 * @return
	 * 			cidade e/ou estado.
	 */

	public String getCidadeEEstado() {
		return cidadeEEstado;
	}
	
	/**
	 * Metodo para midocar cidade e/ou estado.
	 * 
	 * @param novoCidadeEEstado
	 */

	public void setCidadeEEstado(String novoCidadeEEstado) {
		this.cidadeEEstado = novoCidadeEEstado;
	}
	
	/**
	 * Metodo para acessar o cep
	 * 
	 * @return
	 * 			Retorna o cep.
	 */

	public String getCEP() {
		return CEP;
	}
	
	/**
	 * Metodo para modificar o cep.
	 * 
	 * @param novoCEP
	 */

	public void setCEP(String novoCEP) throws InputMismatchException {
		if (CEP != null && (!CEP.isEmpty()))
			if (!CEP.matches("^[0-9]*$"))
				throw new InputMismatchException();
		
		this.CEP = novoCEP;
	}
	
	/**
	 * Metodo para acessar o numero da residencia.
	 * 
	 * @return
	 * 			numero da residencia.
	 */
	
	public String getNumeroDaResidencia() {
		return numeroDaResidencia;
	}
	
	/**
	 * Metodo para modificar o numero da residencia.
	 * 
	 * @param numeroDaResidencia
	 */

	public void setNumeroDaResidencia(String numeroDaResidencia) throws InputMismatchException {
		if (numeroDaResidencia != null && (!numeroDaResidencia.isEmpty()))
			if (!numeroDaResidencia.matches("^[0-9]*$"))
				throw new InputMismatchException();
		
		this.numeroDaResidencia = numeroDaResidencia;
	}
	
	/**
	 * Endereco no formato de string.
	 */

	@Override
	public String toString() {
		return "Lagradouro: " + getLagradouro() + "\nNumero: " + getNumeroDaResidencia() + "\nBairro: " + getBairro() + "\nCidade/UF: " + getCidadeEEstado() + "\nCEP: " + getCEP();
	}
	
	/**
	 * Metodo que retorna o hash code do objeto.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CEP == null) ? 0 : CEP.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result
				+ ((cidadeEEstado == null) ? 0 : cidadeEEstado.hashCode());
		result = prime * result
				+ ((lagradouro == null) ? 0 : lagradouro.hashCode());
		result = prime
				* result
				+ ((numeroDaResidencia == null) ? 0 : numeroDaResidencia
						.hashCode());
		return result;
	}
	
	/**
	 *  Verifica se dois enderecos sao iguais.
	 */

	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Endereco))
			return false;
		Endereco end = (Endereco) obj;
		return getBairro().equals(end.getBairro()) && getCEP().equals(end.getCEP()) && getCidadeEEstado().equals(end.getCidadeEEstado())
				&& getLagradouro().equals(end.getLagradouro()) && getNumeroDaResidencia() == end.getNumeroDaResidencia();
	}
}