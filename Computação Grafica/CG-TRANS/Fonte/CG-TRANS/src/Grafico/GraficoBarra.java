package Grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GraficoBarra {
	
	private ArrayList<DadosGrafico> dados;

	/**
	 * Construtor, recebe ArrayList de dados para a criação do grafico
	 * @param dados
	 */
	public GraficoBarra(ArrayList<DadosGrafico> dados) {
		this.dados = dados;
	}
	
	/**
	 * Desenha o Gráfico de Barras na tela recebida
	 * @param bi
	 */
	public void desenharGrafico(BufferedImage bi) {
		int altura = 30;
		int xmin = 60;
		int ymin = 310;
		int porcentagem;
		
		int yInitTxt = 302;
		
		Retangulo retangulo = new Retangulo();
		
		porcentagem = 0;
		//Desenhando as Barras
		for (int i = 0; i < dados.size(); i++) {
			porcentagem = (int) (dados.get(i).getPorcentagem()*3);
			retangulo.desenharRetangulo(xmin , xmin+porcentagem, ymin, ymin-altura, bi);
			ymin = (ymin - altura)-20;//distancia para a proxima barra
			
		}
		//Desenhando o nome dos dados
		for (int i = 0; i < dados.size(); i++) {
			for (int j = 3*i; j < 3*i + 3; j++) {
				desenharNome(dados.get(i).getDado(), 20, yInitTxt, Color.BLACK, bi);
			}
			//Adiciona espaço para o próximo nome
			yInitTxt = (yInitTxt-altura)-20;
		}
		
	}
	
	/**
	 * Desenha um String no bufferedImage de acordo com a coordenada recebida
	 * @param nome
	 * @param x
	 * @param y
	 * @param cor
	 * @param bi
	 */
	public void desenharNome(String nome, int x, int y, Color cor, BufferedImage bi) {
		
		Graphics graphics = bi.createGraphics();
		graphics.setColor(cor);
		graphics.drawString(nome, x , y);
		
	}
	
}
