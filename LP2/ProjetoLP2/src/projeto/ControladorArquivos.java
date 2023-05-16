package projeto;

import java.io.*;
/**
 * Controlador de arquivos do sistema, facilita o uso de arquivos externos para armazenamento de objetos.
 * 
 * O Controlador permite escrever e ler de arquivos, objetos completos.
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

public class ControladorArquivos {
	
	
	/**
	 * Construtor de um Controlador de Arquivos
	 */
	public ControladorArquivos(){
		
	}
	
	
	/**
	 * Escreve no arquivo passado como primeiro argumento o objeto passado como segundo argumento.
	 * 
	 * @param nomeDoArquivo
	 * 			O nome do arquivo que será gerado para armazenamento.
	 * @param o
	 * 			O Objeto que será armazenado.
	 * @throws IOException
	 * 
	 */
	public void escreveObjetoNoArquivo(String nomeDoArquivo, Object o) throws IOException{
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomeDoArquivo)));
			out.writeObject(o);
		} catch (IOException e){
			System.err.println(e.getMessage());
		} finally {
			out.close();
		}
	}
	
	/**
	 * Lê do arquivo passado como parâmetro um objeto armazenado.
	 * 
	 * @param nomeDoArquivo
	 * 			Nome do arquivo a ser lido.
	 * @return
	 * 			Um objeto do arquivo. 
	 * @throws IOException
	 */
	public Object leObjetoNoArquivo(String nomeDoArquivo) throws IOException{
		ObjectInputStream in = null;
		Object objeto = null;
		
		try{
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomeDoArquivo)));
			objeto = (Object) in.readObject();
		}catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
		}catch(IOException e){
			System.err.println(e.getMessage());
		}finally{
			in.close();
		}
		return objeto;
	}
}
