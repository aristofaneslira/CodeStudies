package Visao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Algoritmos.AlgoritmoDDA;
import Algoritmos.AlgoritmoElipse;
import Algoritmos.AlgoritmosCircunferencia;
import Algoritmos.AlgoritmoPontoMedioReta;
import Algoritmos.Paint;
import Operadores.OperacaoRotacaoAnimacao;
import Operadores.OperacoesMatriz;

@SuppressWarnings("serial")
public class TelaDesenho extends JPanel{
	
	private JLabel label;
	private BufferedImage bi;
	private ImageIcon ii;
	public Graphics2D g2d;
	private AlgoritmoDDA algDda;
	private AlgoritmoPontoMedioReta algPMReta;
	
	/**
	 * Construtor
	 */
	public TelaDesenho(){
		
		this.setLayout(null);
		
		//CRIANDO PAINEL DE DESENHO
	 	bi = new BufferedImage(602, 602, BufferedImage.TYPE_INT_RGB);
		ii = new ImageIcon(bi);
		label = new JLabel(ii);
		g2d = bi.createGraphics();
		
		//ADICIONANDO EIXOS X E Y
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, 602, 602);
		g2d.setColor(SystemColor.activeCaption);
		g2d.drawLine(0, 300, 600, 300);
		g2d.drawLine(300, 0, 300, 600);
		
		
		this.add(label);
		label.setBounds(0, 0, 602, 602);
		label.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		
	}

	/**
	 * Rasterização da Reta DDA
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void DDA(int x1, int y1, int x2, int y2){	
		algDda = new AlgoritmoDDA();
		algDda.DDA(x1, y1, x2, y2, this.bi);
		this.repaint();
	}
	
	/**
	 * Retorna as coordenadas X da reta DDA
	 * @return
	 */
	public ArrayList<Integer> getDDAPontosX(){
		return algDda.getPontosX();
	}
	
	/**
	 * Retorna as coordenadas Y da reta DDA
	 * @return
	 */
	public ArrayList<Integer> getDDAPontosY(){
		return algDda.getPontosY();
	}
	
	/**
	 * Retorna as coordenadas X da reta Ponto Médio
	 * @return
	 */
	public ArrayList<Integer> getPontoMedioPontosX(){
		return algPMReta.getPontosX();
	}
	
	/**
	 * Retorna as coordenadas Y da reta Ponto Médio
	 * @return
	 */
	public ArrayList<Integer> getPontoMedioPontosY(){
		return algPMReta.getPontosY();
	}
	
	/**
	 * Rasterização da reta Ponto Médio
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void MidPointReta(int x1, int y1, int x2, int y2){
		algPMReta = new AlgoritmoPontoMedioReta();
		algPMReta.MidPointReta(x1, y1, x2, y2, this.bi);
		this.repaint();
	}
	
	/**
	 * Gera circunferencia pelo ponto médio
	 * @param raio
	 */
	public void MidPointCirc(int coordX, int coordY, int raio){
		AlgoritmosCircunferencia algCirc = new AlgoritmosCircunferencia();
		algCirc.CircPontoMedio(coordX, coordY, raio, this.bi);
		this.repaint();
		
	}
	
	/**
	 * Gera circunferencia pela equação explicita
	 * @param raio
	 */
	public void EqExplicitaCirc(int raio){
		AlgoritmosCircunferencia algCirc = new AlgoritmosCircunferencia();
		algCirc.CircEquacaoExplicita(raio, bi);
		this.repaint();
		
	}
	/**
	 * Gera circunferencia pelo método trigonométrico
	 * @param raio
	 */
	public void CircMetodoTrigonometrico(int coordX, int coordY, int raio) {
		AlgoritmosCircunferencia algCirc = new AlgoritmosCircunferencia();
		algCirc.CircMetodoTrigonometrico(coordX, coordY, raio, bi);
		this.repaint();
	}
	
	/**
	 * Gera Elipse pelo método do ponto medio
	 * @param largura
	 * @param altura
	 */
	public void Elipse(int largura, int altura) {
		AlgoritmoElipse algElipse = new AlgoritmoElipse();
		algElipse.elipsePM(largura, altura, this.bi);
		this.repaint();
	}
	
	/**
	 * Desenha área de recorte do algoritmo de Cohen-Sutherland
	 * @param xmin
	 * @param xmax
	 * @param ymin
	 * @param ymax
	 */
	public void desenhaTelaRecorte(int xmin, int xmax, int ymin, int ymax, Color cor){
		int Xinit = 300;
		int Yinit = 300;
		g2d.setColor(cor);
		g2d.drawLine(xmin+Xinit, Yinit-ymin, xmax+Xinit, Yinit-ymin);
		g2d.drawLine(xmin+Xinit, Yinit-ymin, xmin+Xinit, Yinit-ymax);
		g2d.drawLine(xmin+Xinit, Yinit-ymax, xmax+Xinit, Yinit-ymax);
		g2d.drawLine(xmax+Xinit, Yinit-ymax, xmax+Xinit, Yinit-ymin);
		this.repaint();
		
	}
	
	/**
	 * Pinta ponto na tela ao adicionar vértice
	 * @param x
	 * @param y
	 */
	public void plotDot(int x, int y){
		Paint paint = new Paint();
		paint.plotPixel(x, y, this.bi);
		this.repaint();
	}
	
	/**
	 * Limpa tela e Desenha o Objeto
	 * @param OPMatriz
	 * @throws Exception
	 */
	public void printObjeto(OperacoesMatriz OPMatriz) throws Exception{
		limpar();
		OPMatriz.desenhaObjeto(this.bi);
		this.repaint();
	}
	
	/**
	 * Limpa tela e Desenha o Objeto
	 * @param OPRotacao
	 * @throws Exception
	 */
	public void printObjeto(OperacaoRotacaoAnimacao OPRotacao) throws Exception{
		limpar();
		OPRotacao.desenhaObjeto(this.bi);
		this.repaint();
	}
	
	/**
	 * Desenha a reta Y = X
	 */
	public void retaYEqualX(){
		DDA(-300, -300, 300, 300);
	}
	
	/**
	 * Desenha a reta Y = mX + b
	 * @param m
	 * @param b
	 */
	public void retaYEqualMXB(int m, int b){
		int x1 = 300;
		int x2 = -300;
		int y1 = m*x1 + b;
		int y2 = m*x2 + b;
		
		DDA(x1, y1, x2, y2);
	}
	
	/**
	 * Limpa tela de desenho
	 */
	public void limpar(){

		//Repintar a tela com as coordenadas X e Y
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, 602, 602);
		g2d.setColor(SystemColor.activeCaption);
		g2d.drawLine(0, 300, 600, 300);
		g2d.drawLine(300, 0, 300, 600);
		repaint();
		
	}
	/**
	 * Limpa tela de desenho e Array de vertices da janela de Transformações Geométricas
	 * @param opMatriz
	 */
	public void limparTransfGeometricas(OperacoesMatriz opMatriz){
		
		//Limpa array de Coordenadas
		opMatriz.limpaArrayCoordenadas();
		
		//Repintar a tela com as coordenadas X e Y
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, 602, 602);
		g2d.setColor(SystemColor.activeCaption);
		g2d.drawLine(0, 300, 600, 300);
		g2d.drawLine(300, 0, 300, 600);
		repaint();
	}




}
