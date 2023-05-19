package Grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Visao.PanelGraficos;

import Algoritmos.AlgoritmosCircunferencia;

public class GraficoPizza {
	
	private ArrayList<DadosGrafico> dados;
	private int quantidadeItens;
	
	private double duploPI = 2*Math.PI;
	private Graphics graphics;
	private ArrayList<CorRGB> cores = new ArrayList<>();
	private CorRGB corRGB;
	private PanelGraficos panelGrafico;

	/**
	 * Construtor, recebe Arraylist de dados para criação do grafico e o panel da interface para 
	 * referenciar o método de criação de legendas
	 * @param dados
	 * @param largura
	 * @param altura
	 * @param panelGrafico
	 */
	public GraficoPizza(ArrayList<DadosGrafico> dados, PanelGraficos panelGrafico) {
		this.dados = dados;
		this.quantidadeItens = dados.size();
		
		this.panelGrafico = panelGrafico;

		
	}
	
	/**
	 * Desenha o as fatia do gráfico de pizza, sua borda e a legenda do gráfico
	 * @param bufferedImage
	 */
	public void desenharGrafico(BufferedImage bi) {
		//limpa arraylist de cores rgb
		cores.clear();
		
		//Ponto central da tela
		int origemX = 250;
		int origemY = 200;
		
		graphics = bi.createGraphics();
		
		int raio = 150;
		double anguloFatia = 0.0;
		double anguloFatiaAnterior = 0.0;

		for (int i = 0; i < quantidadeItens; i++) {
			// Calcula o angulo da Fatia
			anguloFatia = duploPI * dados.get(i).getPorcentagem() / 100.0 + anguloFatiaAnterior;
			
			//Passando os angulos de radiano pra grau
			int anguloGrausAtual = (int)Math.toDegrees(anguloFatia);
			int anguloGrausAnterior = (int)Math.toDegrees(anguloFatiaAnterior);
		
			
			//gerando cor randomica
			int redRandom = (int)(Math.random()*255);
			int greenRandom = (int)(Math.random()*255);
			int blueRandom = (int)(Math.random()*255);
			Color color = new Color(redRandom, greenRandom, blueRandom);
			//salvando a cor em um arraylist para representação da legenda
			corRGB = new CorRGB(redRandom, greenRandom, blueRandom);
			cores.add(corRGB);
			
			//Correção de GAP-----------------
			if (anguloGrausAtual == 359) {	  //
				anguloGrausAtual= 360;	      //
			}								  //
			//--------------------------------
			
			//pintando a pizza ------------------------------------------------------------
			graphics.setColor(color);
			graphics.fillArc(100, 50, 2*raio, 2*raio, anguloGrausAnterior, anguloGrausAtual-anguloGrausAnterior);
			//------------------------------------------------------------------------------
			
			anguloFatiaAnterior = anguloFatia;
			
		}
		
		//desenhando borda da pizza
		AlgoritmosCircunferencia circunferencia = new AlgoritmosCircunferencia();
		circunferencia.CircPontoMedio(origemX, origemY, raio, bi);
		
		//passando array de cores para a pintura das legendas
		panelGrafico.gerarLegendas(this.cores);
	}
	
}
