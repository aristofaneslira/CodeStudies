package projeto;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que representa um validador de campos.
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

public class ValidadorDeCampos implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor default de um validador de campos.
	 */
	ValidadorDeCampos(){
		
	}
	
	/**
	 * Metodo para veficar se uma opcao eh valida para o menu principal
	 * 
	 * @param opcao
	 * @return
	 */
	public boolean ehOpcaoValidaDoMenuPrincipal(String opcao) {
		if(! (Integer.parseInt(opcao) >= 1 && Integer.parseInt(opcao) <= 9)) {
			System.out.println("\nOPCAO INVALIDA.\n");
			return false;
		}
		return true;
	}
	
	/**
	 * Verifica se a opcao eh valida para um menu de decisao.
	 * 
	 * @param opcao
	 * @return
	 */
	
	public boolean ehUmOuDois(String opcao) {
		if(! (Integer.parseInt(opcao) >= 1 && Integer.parseInt(opcao) <= 2)) {
			System.out.println("\nOPCAO INVALIDA.\n");
			return false;
		}
		return true;
	}
	
	/**
	 * Verifica se um dado email é valido.
	 * @param email
	 * 		E-mail a ser validado.
	 * @return
	 * 		True para e-mail válido. False para e-mail inválido.
	 */
	public static boolean validaEmail(String email){
		String emailAvalidar = email;  
		Pattern p = Pattern.compile("[a-z]+[a-z0-9_.-]+@.+\\.[a-z]+");  
		Matcher m = p.matcher(emailAvalidar);
		
		return m.matches();
	}
}
