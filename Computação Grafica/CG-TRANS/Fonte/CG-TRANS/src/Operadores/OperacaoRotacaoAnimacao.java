package Operadores;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Visao.PanelRotacaoAnimacao;
import Visao.TelaDesenho;
import Algoritmos.AlgoritmoDDA;
import Algoritmos.Vertice;

public class OperacaoRotacaoAnimacao implements Runnable{
	private ArrayList<Vertice> CoordsPontos = new ArrayList<>();
	private ArrayList<Vertice> CoordsPontosOriginal = new ArrayList<>();
	private double[][] MatrizObjeto;
	private double [][] MatrizResultado;
	private int pivoX = 0;
	private int pivoY = 0;
	private TelaDesenho panelDesenho;
	private double[][] operadorRotacao = new double[3][3];
	private double[][] operadorTranslacaoOrigem = new double[3][3];
	private double[][] operadorTranslacaoDeVolta = new double[3][3];
	private AlgoritmoDDA dda = new AlgoritmoDDA();
	private int iteracoes = 0;
	private boolean run = true;
	

	/**
	 * Multiplica operadores de translação e rotação pelo objeto, pinta a tela, adiciona um delay e repete o processo N vezes
	 */
	@SuppressWarnings("unchecked")
	public void processar(){
		
		//Copia valores iniciais para um arraylist auxiliar
		//A cada revolução, o objeto original será retomado 
		CoordsPontosOriginal = (ArrayList<Vertice>) CoordsPontos.clone();
		
		//preenche a matriz de coordenadas do objeto por meio de um arraylist de vertices
		preencheMatrizObjeto(CoordsPontos);
		while (run) {
			//multiplica a matriz translação para a origem pela matriz do objeto e atualiza os novos pontos
			atualizaArraylistCoordenadas(multiplicarMatriz(operadorTranslacaoOrigem));
			preencheMatrizObjeto(CoordsPontos);
			
			//multiplica a matriz de rotação pela matriz do objeto e atualiza os novos pontos
			atualizaArraylistCoordenadas(multiplicarMatriz(operadorRotacao));
			preencheMatrizObjeto(CoordsPontos);
			
			//multiplica a matriz de translação de volta para o ponto inicial pela matriz do objeto e atualiza os novos pontos
			atualizaArraylistCoordenadas(multiplicarMatriz(operadorTranslacaoDeVolta));
			preencheMatrizObjeto(CoordsPontos);
			
			//pinta a tela
			try {
				panelDesenho.printObjeto(this);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//atualiza as coordenadas no JTable
			//atualizaLinhasVertices();
			
			//adiciona delay entre processos
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//itera um loop
			iteracoes++;
			
			//completando revolução... objeto original retomado
			if (iteracoes == 359) {
				preencheMatrizObjeto(CoordsPontosOriginal);
				iteracoes = 0;
			}
			
		}
	
		
	}
	
	/**
	 * Multiplica o operador recebido pela matriz do objeto
	 * @param operador
	 * @return
	 */
	public double[][] multiplicarMatriz(double[][] operador){
		double valor;
		int numeroColunas = MatrizObjeto[0].length;
		// CRIA MATRIZ RESULTADO PROPORCIONAL AO TAMANHO DA MATRIZ DO OBJETO
		MatrizResultado = new double[3][numeroColunas];
		
		//MULTIPLICAÇÃO DA MATRIZ OPERADORA PELA MATRIZ DO OBJETO
		for (int i = 0; i < 3; i++){
			
			for (int j = 0; j < numeroColunas; j++){
				valor = 0;
				
				for (int k = 0; k < 3; k++){
					valor += Math.round(operador[i][k]*MatrizObjeto[k][j]);
				}
				
				MatrizResultado[i][j] = valor;
			}	
		}
		
		MatrizObjeto = MatrizResultado;
		
		return MatrizResultado;
	}
	
	/**
	 * Monta a matriz do objeto de acordo com as coordenadas do objeto recebidas
	 * @param CoordsPontos
	 */
	public void preencheMatrizObjeto(ArrayList<Vertice> CoordsPontos){
		
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
	 * Atualiza o ArrayList de coordenadas de acordo com a matriz de objetos recebido
	 * @param MatrizObjeto
	 */
	public void atualizaArraylistCoordenadas(double[][] MatrizObjeto){
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
	 * Desenha o objeto de acordo com as coordenadas do ArrayList CoordsPontos na tela recebida
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
	 * Adiciona objeto Vertice no ArrayList "CoordsPontos"
	 * @param Coords
	 */
	public void addCoordsPontos(Vertice Coords){
		CoordsPontos.add(Coords);
		
	}
	
	/**
	 * Muda o pivo X de 0 para o valor recebido
	 * @param newPivoX
	 */
	public void setPivoX(int newPivoX){
		this.pivoX = newPivoX;
	}
	
	/**
	 * Muda o pivo Y de 0 para o valor recebido
	 * @param newPivoY
	 */
	public void setPivoY(int newPivoY){
		this.pivoY = newPivoY;
	}
	
	/**
	 * Remove o objeto Vertice do ArrayList "CoordsPontos"
	 * @param indice
	 */
	public void removeCoordsPontos(int indice){
		CoordsPontos.remove(indice);
	}
	
	/**
	 * Seta a tela de desenho para realizar a pintura do objeto
	 * @param panelDesenho
	 */
	public void setPanelDesenho(TelaDesenho panelDesenho) {
		this.panelDesenho = panelDesenho;
	}
	
	/**
	 * Limpa oa arraylist de vertices
	 */
	public void limpaArrayCoordenadas(){
		CoordsPontos.clear();
	}
	
	/**
	 * Retorna ArrayList de vértices
	 * @return
	 */
	public ArrayList<Vertice> getCoordsPontos(){
		return this.CoordsPontos;
	}
	
	/**
	 * Remove linhas da tabela de Vértices
	 */
	public void removeLinhasVertices(){
		 PanelRotacaoAnimacao.model = (DefaultTableModel)PanelRotacaoAnimacao.jTableVertices.getModel();
		 
		 int count = PanelRotacaoAnimacao.model.getRowCount();
		 
		 for (int i=0; i < count; i++){
			 PanelRotacaoAnimacao.model.removeRow(0);
		 }
		
	}
	
	/**
	 * Remove linhas da tabela de Vértices e adiciona as novas linhas (caso haja)
	 */
	public void atualizaLinhasVertices(){
		removeLinhasVertices();
		PanelRotacaoAnimacao.model = (DefaultTableModel)PanelRotacaoAnimacao.jTableVertices.getModel();
		
		if (iteracoes == 359) {
			for (Vertice coords: CoordsPontosOriginal){	 
				PanelRotacaoAnimacao.model.addRow(new String [] {""+coords.getCoordX(), ""+coords.getCoordY()});
			}
		}
		
		for (Vertice coords: CoordsPontos){	 
			PanelRotacaoAnimacao.model.addRow(new String [] {""+coords.getCoordX(), ""+coords.getCoordY()});
		}
		
		
	}
	
	/**
	 * Preenche operadores de rotação e translação de acordo com os parâmetros setados pela interface
	 */
	public void preencheOperadores() {
		double angulo = Math.toRadians(1);
		double senAngulo = Math.sin(angulo);
		double cosAngulo = Math.cos(angulo);
		
		//PREENCHE OPERADOR DE ROTAÇÃO
		operadorRotacao[0][0] = cosAngulo;
		operadorRotacao[0][1] = -senAngulo;
		operadorRotacao[0][2] = 0;
		operadorRotacao[1][0] = senAngulo;
		operadorRotacao[1][1] = cosAngulo;
		operadorRotacao[1][2] = 0; 
		operadorRotacao[2][0] = 0;
		operadorRotacao[2][1] = 0;
		operadorRotacao[2][2] = 1;
		
		//PREENCHE OPERADOR DE TRANSLAÇÃO PARA ORIGEM

		operadorTranslacaoOrigem[0][0] = 1;
		operadorTranslacaoOrigem[0][1] = 0;
		operadorTranslacaoOrigem[0][2] = -pivoX; //tx
		operadorTranslacaoOrigem[1][0] = 0;
		operadorTranslacaoOrigem[1][1] = 1;
		operadorTranslacaoOrigem[1][2] = -pivoY; //ty
		operadorTranslacaoOrigem[2][0] = 0;
		operadorTranslacaoOrigem[2][1] = 0;
		operadorTranslacaoOrigem[2][2] = 1;
				
		//PREENCHE OPERADOR DE TRANSLAÇÃO DE VOLTA AO PONTO INICIAL

		operadorTranslacaoDeVolta[0][0] = 1;
		operadorTranslacaoDeVolta[0][1] = 0;
		operadorTranslacaoDeVolta[0][2] = pivoX; //tx
		operadorTranslacaoDeVolta[1][0] = 0;
		operadorTranslacaoDeVolta[1][1] = 1;
		operadorTranslacaoDeVolta[1][2] = pivoY; //ty
		operadorTranslacaoDeVolta[2][0] = 0;
		operadorTranslacaoDeVolta[2][1] = 0;
		operadorTranslacaoDeVolta[2][2] = 1;
		
	}
	
	public void setRun(boolean status){
		this.run = status;
	}
	
	/**
	 * Preenche os operadores e executa o processo ao iniciar a Thread
	 */
	@Override
	public void run() {
		preencheOperadores();
		processar();
		
	}

}
