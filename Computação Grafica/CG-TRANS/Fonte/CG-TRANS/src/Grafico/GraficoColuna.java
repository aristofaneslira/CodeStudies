package Grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GraficoColuna {
	
	private ArrayList<DadosGrafico> dados;

	/**
	 * Construtor, recebe ArrayList de dados para a criação do grafico
	 * @param dados
	 */
	public GraficoColuna(ArrayList<DadosGrafico> dados) {
		this.dados = dados;		
	}
	
	/**
	 * Desenha o Gráfico de Colunas na tela recebida
	 * @param bi
	 */
	public void desenharGrafico(BufferedImage bi) {
		int largura = 30;
		int xmin = 90;
		int ymin = 340;
		int porcentagem;
		
		int xInitTxt = 100;
		//criador de retangulos
		Retangulo retangulo = new Retangulo();
		
		porcentagem = 0;
		
		//Desenhando as Colunas
		for (int i = 0; i < dados.size(); i++) {
			porcentagem = (int) (dados.get(i).getPorcentagem()*3);
			retangulo.desenharRetangulo(xmin, xmin+largura, ymin, ymin-porcentagem, bi);
			
			//distancia para a proxima coluna
			xmin+=largura+20;
			
		}
		//Desenhando o nome dos dados
		for (int i = 0; i < dados.size(); i++) {
			for (int j = 3*i; j < 3*i + 3; j++) {
				desenharNome(dados.get(i).getDado(), xInitTxt, 355, Color.BLACK, bi);
			}
			
			xInitTxt += largura+20;
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
		
		Graphics g2d = bi.createGraphics();
		g2d.setColor(cor);
		g2d.drawString(nome, x , y);
		
	}
	
}
