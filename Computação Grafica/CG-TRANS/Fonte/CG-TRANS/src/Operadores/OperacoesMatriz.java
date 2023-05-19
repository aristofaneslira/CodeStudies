package Operadores;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Algoritmos.AlgoritmoDDA;
import Algoritmos.Vertice;

public class OperacoesMatriz {
	
	
	private ArrayList<Vertice> CoordsPontos = new ArrayList<>();
	private double[][] MatrizObjeto;
	private double[][] OperadorFinal;
	private double [][] MatrizResultado;
	private ArrayList<Operador> Operacoes = new ArrayList<>();	

	
	AlgoritmoDDA dda = new AlgoritmoDDA();
	
	/**
	 * Retorna ArrayList de vértices
	 * @return
	 */
	public ArrayList<Vertice> getCoordsPontos(){
		return this.CoordsPontos;
	}
	
	/**
	 * Multiplica Operadores, gerando o operador final e em seguida multiplica com a matriz do Objeto
	 */
	public void multiplicarMatriz(){
		
		double valor;
		int numeroColunas = MatrizObjeto[0].length;
			
		// CRIA MATRIZ RESULTADO PROPORCIONAL AO TAMANHO DA MATRIZ DO OBJETO
		MatrizResultado = new double[3][numeroColunas];
		
		//CRIA MATRIZ OPERADOR RESULTADO FINAL 3X3
		OperadorFinal = new double[3][3];
		
		//OPERADOR INICIA NA OPERAÇÃO INICIAL - "Para uso com apenas uma operação!"
		OperadorFinal = Operacoes.get(0).getOperador();
		
		//CASO HAJA MAIS DE UMA TRANSFORMAÇÃO... MULTIPLICA
		if (Operacoes.size() > 1){
			
			double MatrizAux[][] = new double[3][3];
				
			//DEFINE UMA MATRIZ AUXILIAR COMEÇANDO PELA ULTIMA POSICAO DO ARRAY DE OPERAÇÕES (interface)
			MatrizAux = Operacoes.get(Operacoes.size()-1).getOperador();
			
			//VARRE O ARRAYLIST DE OPERAÇÕES DE FORMA INVERSA PARA MULTIPLICAÇÃO
			for (int w = Operacoes.size()-1; w > 0; w--){
				
				//MULTIPLICA AS MATRIZES 
				OperadorFinal = multiplicacaoOperadores(MatrizAux, Operacoes.get(w-1).getOperador());
				
				//IGUALA "MatrizAux" AO RESULTADO DA MULTIPLICAÇÃO ANTERIOR
				MatrizAux = OperadorFinal.clone();
			}
						
		}
		
		//imprimeMatriz(OperadorFinal);
		
		//MULTIPLICAÇÃO DA MATRIZ OPERADORA PELA MATRIZ DO OBJETO
		for (int i = 0; i < 3; i++){
			
			for (int j = 0; j < numeroColunas; j++){
				valor = 0;
				
				for (int k = 0; k < 3; k++){
					valor += Math.round(OperadorFinal[i][k]*MatrizObjeto[k][j]);
				}
				
				MatrizResultado[i][j] = valor;
			}	
		}
		
		//ATUALIZA AS COORDENADAS DO OBJETO
		MatrizObjeto = MatrizResultado;

		
	}
	
	/**
	 * Multiplica duas matrizes 3x3 (Operadores)
	 * @param matrizA
	 * @param matrizB
	 * @return
	 */
	public double[][] multiplicacaoOperadores(double[][] matrizA, double[][] matrizB){
		
		double[][] matrizResultado = new double[3][3];
	
		double valor;
		for (int i = 0; i < 3; i++){
			
			for (int j = 0; j < 3; j++){
				valor = 0;
				
				for (int k = 0; k < 3; k++){
					valor += matrizA[i][k]* matrizB[k][j];
				}
				
				matrizResultado[i][j] = valor;					
			}	
		}
		return matrizResultado;
	}
	
	/**
	 * Método para imprimir a matriz recebida no console (Test Only!)
	 * @param matriz
	 */
	public void imprimeMatriz(double[][] matriz){
		for (int i = 0; i < 3; i++){
			System.out.println("");
			for (int j = 0; j < 3; j++){
				System.out.print(matriz[i][j] + " ");
			}
		}
		
	
	}
	
	/**
	 * Adiciona objeto do tipo Operador no arraylist de transformações
	 * @param operacao
	 */
	public void adicionaOperacao(Operador operacao){
		this.Operacoes.add(operacao);
	}
	
	/**
	 * Remove Operador do arraylist de transformações
	 * @param operacao
	 */
	public void removeOperacao(Operador operacao){
		this.Operacoes.remove(operacao);
	}
	
	/**
	 * Adiciona vertice ao arraylist de vertices
	 * @param Coords
	 */
	public void addCoordsPontos(Vertice Coords){
		CoordsPontos.add(Coords);
		
	}
	
	/**
	 * Ler o arraylist de vertices e cria uma matriz do Objeto referente aos vertices do objeto
	 */
	public void preencheMatrizObjeto(){
		
		//CRIA UMA MATRIZ "3 X n" ONDE "n" TEM A MESMA PROPORÇÃO DO ARRAYLIST "CoordsPontos" (QUANTIDADE DE VERTICES)
		MatrizObjeto = new double[3][CoordsPontos.size()];
		
		//VARRE O ARRAYLIST E PREENCHE A MATRIZ DE OBJETOS COM AS COORDENADAS
		for (int i = 0; i < CoordsPontos.size(); i++){
			
			MatrizObjeto[0][i] = CoordsPontos.get(i).getCoordX();
			MatrizObjeto[1][i] = CoordsPontos.get(i).getCoordY();
			MatrizObjeto[2][i] = CoordsPontos.get(i).getCoordW();
				
		}	
		
	}
		

	
	/**
	 * Remove vertice do arraylist de vertices
	 * @param indice
	 */
	public void removeCoordsPontos(int indice){
		CoordsPontos.remove(indice);
	}
	
	/**
	 * Desenha o objeto na tela de desenho recebida
	 * @param bi
	 * @throws Exception
	 */
	public void desenhaObjeto(BufferedImage bi) throws Exception{
	
		if (CoordsPontos.size() > 1){
			int k = 0;
			
			for (int i = 1; i < CoordsPontos.size(); i++){
				
				dda.DDA(CoordsPontos.get(i-1).getCoordX(), CoordsPontos.get(i-1).getCoordY(), CoordsPontos.get(i).getCoordX(), CoordsPontos.get(i).getCoordY(), bi);
				k++;	
			}
			
			//LIGA O ULTIMO VÉRTICE AO PRIMEIRO VÉRTICE
			dda.DDA(CoordsPontos.get(k).getCoordX(), CoordsPontos.get(k).getCoordY(), CoordsPontos.get(0).getCoordX(), CoordsPontos.get(0).getCoordY(), bi);
		}
		
		else {
			throw new Exception("Adicione 2 ou mais Pontos!");
		}
		
	}
	
	/**
	 * Atualiza os vertices de acordo com o resultado obtido com as transformações
	 */
	public void atualizaArraylistCoordenadas(){
		double x, y;
		CoordsPontos.clear();
		for (int i = 0; i < MatrizObjeto[0].length; i++){
			x = 0;
			y = 0;
			for (int j = 0; j < 2 ; j++){
				if (j == 0){
					x = MatrizResultado[j][i];
				}
				else if (j == 1){
					y = MatrizResultado[j][i];
					CoordsPontos.add(new Vertice((int)x, (int)y));
					
				}
			}
		}
	}
	
	/**
	 * Limpa oa arraylist de vertices
	 */
	public void limpaArrayCoordenadas(){
		CoordsPontos.clear();
	}
	
	/**
	 * Limpa o Array de Operacoes (Transformações)
	 */
	public void limpaArrayOperacoes(){
		Operacoes.clear();
	}
	
	/**
	 * Retorna ArrayList de Operações
	 * @return
	 */
	public ArrayList<Operador> getOperacoes(){
		return this.Operacoes;
	}		
		

}
