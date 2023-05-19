package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import Model.AlgoritmoReta;
import Model.Matriz;
import Model.Vertice;

import java.util.ArrayList;

public class PanelTela3D extends JPanel {
	
	// Define as configurações da tela
	private static int larguraTela = 803; // 463 ou 1203 ou 803
	private static int alturaTela = 603; // 463 ou 903 ou 603
	private int tipoCor = BufferedImage.TYPE_INT_ARGB;
	
	// Define as coordenadas Iniciais
	public static int xInit = larguraTela/2;
	public static int yInit = alturaTela/2;
	private int zInit = 0;

	double angulo = 120;
	
	private double d = Math.round(100 / (2*Math.tan(angulo/2)));
	
	// Define a cor do pixel
	public static int corPixel;
	
	// Cria uma imagem transparente
	private BufferedImage bufferedImage = new BufferedImage(larguraTela, alturaTela, tipoCor);
	// Cria um imageIcon com a bufferedImage como parametro
	private ImageIcon imageIcon = new ImageIcon(bufferedImage);
	private JLabel label = new JLabel(imageIcon);
	
	// Lista dos Vertices do Objeto
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	
	// Lista dos Vertices do Objeto
	private ArrayList<Vertice> vertices3D = new ArrayList<Vertice>();
	
	// Matriz Homogenea do objeto
	private Matriz matrizObjeto;
	
	// Matriz Homogenea do Objeto em 3D
	private Matriz matrizObjeto3D;
	
	// Lista de Matrizes Operações que serão aplicadas ao Objeto
	private ArrayList<Matriz> matrizesOperacoes = new ArrayList<Matriz>();
	
	// Matriz Operadora
	private Matriz matrizOperadora = new Matriz(4, 4);
	
	// Variaveis de Controle da Translação
	private int controleTranslacaoX = 0;
	private int controleTranslacaoY = 0;
	private int controleTranslacaoZ = 0;
	
	
	/**
	 * Create the panel.
	 */
	public PanelTela3D() {
		
		// Define a cor de background e layout do panel
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		corPixel = Color.BLACK.getRGB();
		
		// Adiciona o label ao panel
		label.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(label);
		
		// Obtemos o contexto gráfico dessa imagem
		Graphics2D g2d = bufferedImage.createGraphics();
		
		// Desenha os eixos X E Y 
		adicionarEixosCoordenadas(g2d);
		
	}
	
	public int getLarguraTela() {
		return larguraTela;
	}

	public int getAlturaTela() {
		return alturaTela;
	}
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
	public ArrayList<Vertice> getVertices3D() {
		return vertices3D;
	}

	public void setVertices3D(ArrayList<Vertice> vertices3D) {
		this.vertices3D = vertices3D;
	}

	public Matriz getMatrizHomogenea() {
		return matrizObjeto;
	}
	
	public ArrayList<Matriz> getMatrizesOperacoes() {
		return matrizesOperacoes;
	}
	
	/**
	 * Adiciona os eixos das coordenadas X e Y
	 * @param g2d
	 */
	public void adicionarEixosCoordenadas(Graphics2D g2d) {
		// Desenha os eixos X E Y 
		g2d.setColor(Color.BLUE);
		g2d.drawLine(0, yInit, larguraTela, yInit);
		g2d.drawLine(xInit, 0, xInit, alturaTela);
		
	}
	
	/**
	 * Limpa a tela de desenho
	 */
	public void limparTela() {
		// Obtemos o contexto gráfico dessa imagem
		Graphics2D g2d = bufferedImage.createGraphics();
		
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, larguraTela, alturaTela);
		
		adicionarEixosCoordenadas(g2d);
		
	}
	
	/**
	 * Desenha um Pixel na Tela
	 * @param x
	 * @param y
	 */
	public void setPixel(int x, int y){
		try {
			// Define o pixel nas coordenadas x e y na cor preta
			bufferedImage.setRGB(xInit + x, yInit - y, corPixel);
			
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * Define a cor do Pixel que irá desenhar em seguida
	 * @param cor
	 */
	public void definirCor(Color cor) {
		corPixel = cor.getRGB();
		
	}
	
	/**
	 * Desenha um vertice na Tela e Adiciona um Objeto do tipo Vertice no Arraylist de Vertices
	 * @param x
	 * @param y
	 * @param z
	 */
	public void desenharVertice(int x, int y, int z) {
		
		vertices.add(new Vertice(x, y, z, 1));
		
	}
	
	/**
	 * Redesenha na Tela todos os Vertices existentes no Arraylist de Vertices
	 */
	public void redesenharVertices() {
		// Remove todos os itens da tela
		limparTela();
		
		// redesenha os vertices restantes
		for (Vertice v : vertices) {
			setPixel(v.getCoordenadaX(), v.getCoordenadaY());
		}
		
	}
	
	/**
	 * Remove o vertice da tela
	 * @param numeroVertice
	 */
	public void removerVertice(int numeroVertice) {
		// remove o vertice do arraylist de vertices
		vertices.remove(numeroVertice);
		
		redesenharVertices();
		
	}
	
	/**
	 * Remove todos os vertices do arraylist de vertices
	 */
	public void limparListaVertices() {
		vertices.clear();
	}
	
	/**
	 * Remove todos os vertices do arraylist de vertices3D
	 */
	public void limparListaVertices3D() {
		vertices3D.clear();
	}
	
	/**
	 * Desenha figura geometrica de acordo com os vertices Com perspectiva 3D
	 * @param vertices
	 */
	public void desenharObjeto3D(ArrayList<Vertice> vertices) {
		
		limparTela();
		
		if (vertices.size() > 1) {
			for (int i = 1; i < 4; i++) {
				
				/*
				 * Desenha a Face Frontal do Cubo
				 */
				desenharRetaDDA(vertices.get(i-1).getCoordenadaX(), vertices.get(i-1).getCoordenadaY(), vertices.get(i).getCoordenadaX(), vertices.get(i).getCoordenadaY());
				
				// Interliga com o ultimo Ponto
				if (i == 3) {
					desenharRetaDDA(vertices.get(i).getCoordenadaX(), vertices.get(i).getCoordenadaY(), vertices.get(0).getCoordenadaX(), vertices.get(0).getCoordenadaY());
				}
				
				/*
				 * Desenha a Face Traseira do Cubo
				 */
				desenharRetaDDA(vertices.get(i+3).getCoordenadaX(),	vertices.get(i+3).getCoordenadaY(), vertices.get(i+4).getCoordenadaX(), vertices.get(i+4).getCoordenadaY());
				
				// Interliga com o ultimo Ponto
				if (i == 3) {
					desenharRetaDDA(vertices.get(i+4).getCoordenadaX(),	vertices.get(i+4).getCoordenadaY(), vertices.get(4).getCoordenadaX(), vertices.get(4).getCoordenadaY());
				}

				/*
				 * Interliga a Face Frontal com a Face Traseira
				 */
				desenharRetaDDA(vertices.get(i-1).getCoordenadaX(), vertices.get(i-1).getCoordenadaY(), vertices.get(i+3).getCoordenadaX(), vertices.get(i+3).getCoordenadaY());
				
				// Interliga com o ultimo Ponto
				if (i == 3) {
					desenharRetaDDA(vertices.get(i+4).getCoordenadaX(), vertices.get(i+4).getCoordenadaY(), vertices.get(3).getCoordenadaX(), vertices.get(3).getCoordenadaY());
				}
			}
		}
	}
	
	/**
	 * Aplica a Transformação de Projeção em Perespectiva 3D no Objeto 
	 */
	public void aplicarTransformacaoDeProjecaoEmPerspectiva3D() {
		
		transformarParaMatrizHomogenia(vertices);
		
		matrizObjeto3D = matrizObjeto;
		
		// Cria e adiciona os valores na matriz de Projeção
		Matriz matrizProjecao = new Matriz(4, 4);
		
		// Adiciona a coluna 1 da matriz de Projeção
		matrizProjecao.adicionarNumero(d, 0, 0);
		matrizProjecao.adicionarNumero(0, 1, 0);
		matrizProjecao.adicionarNumero(0, 2, 0);
		matrizProjecao.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Projeção
		matrizProjecao.adicionarNumero(0, 0, 1);
		matrizProjecao.adicionarNumero(d, 1, 1);
		matrizProjecao.adicionarNumero(0, 2, 1);
		matrizProjecao.adicionarNumero(0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Projeção
		matrizProjecao.adicionarNumero(0, 0, 2);
		matrizProjecao.adicionarNumero(0, 1, 2);
		matrizProjecao.adicionarNumero(0, 2, 2);
		matrizProjecao.adicionarNumero(1, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Projeção
		matrizProjecao.adicionarNumero(0, 0, 3);
		matrizProjecao.adicionarNumero(0, 1, 3);
		matrizProjecao.adicionarNumero(0, 2, 3);
		matrizProjecao.adicionarNumero(d, 3, 3);
		
		// Multiplica a Matriz Homogenea do Objeto 3D pela matriz de Projeção em Perspectiva
		matrizObjeto3D.multiplicarMatrizPor(matrizProjecao);
		
		transformarParaVertices(matrizObjeto3D, vertices3D);
		
		// Divide a coordenada X e Y pelo valor da coordenada W
		for (int i = 0; i < vertices3D.size(); i++) {
			vertices3D.set(i, new Vertice(vertices3D.get(i).getCoordenadaX()/vertices3D.get(i).getCoordenadaW(), vertices3D.get(i).getCoordenadaY()/vertices3D.get(i).getCoordenadaW(), 0, 1));
		}
		
		transformarParaMatrizHomogenia(vertices);
		
		exibirMatrizConsole(matrizObjeto, "Objeto");
		exibirMatrizConsole(matrizObjeto3D, "Objeto 3D");
		
	}
	
	/**
	 * Redesenha o objeto na tela de pintura
	 */
	public void atualizarObjetoTela() {
		// Limpa a tela de pintura
		limparTela();
		
		// Desenha o objeto na tela
		desenharObjeto3D(vertices3D);
		
	}
	
	/**
	 * Converte os vertices para matriz homogenea
	 * @param vertices
	 */
	public void transformarParaMatrizHomogenia(ArrayList<Vertice> vertices) {
		int linhas = 4;
		int colunas = vertices.size();
		
		Matriz matrizHomogenea = new Matriz(linhas, colunas);
		
		// Adicionando os vertices na matriz Homogenea
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				if (i == 0) {
					// Se estiver na Primeira Linha (Linha 0), adiciona as coordenadas X
					matrizHomogenea.adicionarNumero(vertices.get(j).getCoordenadaX(), i, j);
					
				} else if (i == 1) {
					// Se estiver na Segunda Linha (Linha 1), adiciona as coordenadas Y
					matrizHomogenea.adicionarNumero(vertices.get(j).getCoordenadaY(), i, j);
					
				} else if (i == 2) {
					// Se estiver na Terceira Linha (Linha 2), adiciona as coordenadas Z
					matrizHomogenea.adicionarNumero(vertices.get(j).getCoordenadaZ(), i, j);
					
				} else {
					// Se estiver na Quarta Linha (Linha 3), adiciona as coordenadas W
					matrizHomogenea.adicionarNumero(vertices.get(j).getCoordenadaW(), i, j);
					
				}
			}
		}
		
		// Salva a Matriz Homogenea
		matrizObjeto = matrizHomogenea;
		
		// Exibe a Matriz no Console
		exibirMatrizConsole(matrizObjeto, "Objeto");
		
	}
	
	/**
	 * Converte uma matriz para vertices e desenha os vertices
	 * @param matrizHomogenea
	 */
	public void transformarParaVertices(Matriz matrizHomogenea, ArrayList<Vertice> vertices) {
		vertices.clear();
		
		// Pega as Linhas X, Y e Z adicionando-os em arrays separados
		double[] linhaX = matrizHomogenea.getLinha(0);
		double[] linhaY = matrizHomogenea.getLinha(1);
		double[] linhaZ = matrizHomogenea.getLinha(2);
		double[] linhaW = matrizHomogenea.getLinha(3);
		
		System.out.println("------------ Vertices Convertidos---------------");
		// Pega os valores das linhas X e Y e os Adiciona no Arraylist de Vertices
		for (int i = 0; i < matrizHomogenea.getNumeroColunas(); i++) {
			//desenharVertice((int) Math.round(linhaX[i]), (int) Math.round(linhaY[i]));
			vertices.add(new Vertice((int) Math.round(linhaX[i]), (int) Math.round(linhaY[i]), (int) Math.round(linhaZ[i]), (int) Math.round(linhaW[i])));
			
			System.out.println("X:"+(int) Math.round(linhaX[i]) +" Y:"+ (int) Math.round(linhaY[i]) +" Z:"+ (int) Math.round(linhaZ[i]) +" W:"+ (int) Math.round(linhaW[i]));
			
		}
		
	}
	
	/**
	 * Aplica a Transformação no Objeto
	 */
	public void aplicarTransformacao() {
		// Calcula a Matriz Operadora
		calcularMatrizOperadora(matrizesOperacoes);
		
		// Multiplica a Matriz do Objeto pela Matriz Operadora
		matrizObjeto.multiplicarMatrizPor(matrizOperadora);
		
		// Converte a Matriz do Objeto para Vertices
		transformarParaVertices(matrizObjeto, vertices);
		
		aplicarTransformacaoDeProjecaoEmPerspectiva3D();
		
		// Atualiza objeto na tela de pintura
		atualizarObjetoTela();
		
	}
	
	/**
	 * Calcula a Matriz Operadora multiplicando as Matrizes de operações
	 */
	public void calcularMatrizOperadora(ArrayList<Matriz> matrizesOperacoes) {
		
		System.out.println("Quantidade de Matrizes Operadoras: " + matrizesOperacoes.size());
		
		// Define o primeiro elemento
		matrizOperadora = matrizesOperacoes.get(matrizesOperacoes.size()-1);
		
		for (int i = matrizesOperacoes.size()-2; i >= 0; i--) {
			// Multiplica a matriz "i" pela matriz "i+1"
			matrizesOperacoes.get(i).multiplicarMatrizPor(matrizesOperacoes.get(i+1));
			
			matrizOperadora = matrizesOperacoes.get(i);
			
		}
		
		// Zera as variaveis de Controle
		controleTranslacaoX = 0;
		controleTranslacaoY = 0;
		controleTranslacaoZ = 0;
		
		// Limpa o Arraylist de Operações
		limparMatrizesOperacoes();
		
		// Exibe a Matriz Operadora
		exibirMatrizConsole(matrizOperadora, "Operadora");
		
	}
	
	/**
	 * Limpa a lista de matrizes operações
	 */
	public void limparMatrizesOperacoes() {
		matrizesOperacoes.clear();
		
	}
	
	/**
	 * Verifica se contém alguma matriz no arraylist de matrizes Operações
	 * @return True (Caso possua alguma operação) e False (Caso não possua nenhuma operação)
	 */
	public boolean verificarMatrizesOperações() {
		if (matrizesOperacoes.size() != 0) {
			return true;
			
		}
		return false;
		
	}
	
	/**
	 * Remove a Operacao do arraylist de operacoes
	 * @param index
	 */
	public void removerMatrizOperacao(int index) {
		// remove a matriz do arraylist de matrizOperacao
		matrizesOperacoes.remove(index);
		
	}
	
	/**
	 * Adiciona uma Matriz de Translação no Arraylist de Operações
	 * @param tX
	 * @param tY
	 * @param tZ
	 */
	public void addTranslacao(double tX, double tY, double tZ) {
		
		// Cria e adiciona os valores na matriz de translação
		Matriz matrizTranslacao = new Matriz(4, 4);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizTranslacao.adicionarNumero(1, 0, 0);
		matrizTranslacao.adicionarNumero(0, 1, 0);
		matrizTranslacao.adicionarNumero(0, 2, 0);
		matrizTranslacao.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizTranslacao.adicionarNumero(0, 0, 1);
		matrizTranslacao.adicionarNumero(1, 1, 1);
		matrizTranslacao.adicionarNumero(0, 2, 1);
		matrizTranslacao.adicionarNumero(0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizTranslacao.adicionarNumero(0, 0, 2);
		matrizTranslacao.adicionarNumero(0, 1, 2);
		matrizTranslacao.adicionarNumero(1, 2, 2);
		matrizTranslacao.adicionarNumero(0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizTranslacao.adicionarNumero(tX, 0, 3);
		matrizTranslacao.adicionarNumero(tY, 1, 3);
		matrizTranslacao.adicionarNumero(tZ, 2, 3);
		matrizTranslacao.adicionarNumero( 1, 3, 3);
		
		// Adiciona o valor da Translação nas variaveis de Controle
		controleTranslacaoX += tX;
		controleTranslacaoY += tY;
		controleTranslacaoZ += tZ;
		
		// Adiciona a matriz de Translação na lista de Operações
		matrizesOperacoes.add(matrizTranslacao);
		
		// Exibe a Matriz no Console
		exibirMatrizConsole(matrizTranslacao, "Translação");
		
	}
	
	/**
	 * Adiciona uma Matriz de Escala no Arraylist de Operações
	 * @param sX
	 * @param sY
	 */
	public void addEscala(double sX, double sY, double sZ) {

		// Cria e adiciona os valores na matriz de translação
		Matriz matrizEscala = new Matriz(4, 4);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizEscala.adicionarNumero(sX, 0, 0);
		matrizEscala.adicionarNumero( 0, 1, 0);
		matrizEscala.adicionarNumero( 0, 2, 0);
		matrizEscala.adicionarNumero( 0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizEscala.adicionarNumero( 0, 0, 1);
		matrizEscala.adicionarNumero(sY, 1, 1);
		matrizEscala.adicionarNumero( 0, 2, 1);
		matrizEscala.adicionarNumero( 0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizEscala.adicionarNumero( 0, 0, 2);
		matrizEscala.adicionarNumero( 0, 1, 2);
		matrizEscala.adicionarNumero(sZ, 2, 2);
		matrizEscala.adicionarNumero( 0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizEscala.adicionarNumero(0, 0, 3);
		matrizEscala.adicionarNumero(0, 1, 3);
		matrizEscala.adicionarNumero(0, 2, 3);
		matrizEscala.adicionarNumero(1, 3, 3);
		
		// Calcula a diferença do Primeiro Vertice com a Origem e soma com as Variaveis de controle
		double x = matrizObjeto.getLinha(0)[4] + controleTranslacaoX;
		double y = matrizObjeto.getLinha(1)[4] + controleTranslacaoY;
		double z = matrizObjeto.getLinha(2)[4] + controleTranslacaoZ;
		
		// Zera as variaveis de Controle
		controleTranslacaoX = 0;
		controleTranslacaoY = 0;
		controleTranslacaoZ = 0;
		
		// Adiciona uma translação para Origem na lista de Operações
		addTranslacao(-x, -y, -z);
		
		// Adiciona a matriz de Escala na lista de Operações
		matrizesOperacoes.add(matrizEscala);
		
		// Adiciona uma translação para o ponto original na lista de Operações
		addTranslacao(x, y, z);
		
		// Exibe a Matriz no Console
		exibirMatrizConsole(matrizEscala, "Escala");
		
	}
	
	/**
	 * Adiciona uma Matriz de Rotação em Torno do Eixo X
	 * @param angulo
	 */
	public void addRotacaoEmTornoDoEixoX(double angulo) {

		// Cria e adiciona os valores na matriz de translação
		Matriz matrizRotacao = new Matriz(4, 4);
		
		// Converte o angulo de Graus para Radiano
		angulo = Math.toRadians(angulo);
		
		// Calcula o Seno e o Cosseno do Angulo convertido em Radianos
		double senO = Math.sin(angulo);
		double cosO = Math.cos(angulo);
		
		System.out.println("s: "+ senO +" c:"+ cosO);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizRotacao.adicionarNumero(1, 0, 0);
		matrizRotacao.adicionarNumero(0, 1, 0);
		matrizRotacao.adicionarNumero(0, 2, 0);
		matrizRotacao.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizRotacao.adicionarNumero(   0, 0, 1);
		matrizRotacao.adicionarNumero(cosO, 1, 1);
		matrizRotacao.adicionarNumero(senO, 2, 1);
		matrizRotacao.adicionarNumero(   0, 3, 1);

		// Adiciona a coluna 3 da matriz de Translação
		matrizRotacao.adicionarNumero(    0, 0, 2);
		matrizRotacao.adicionarNumero(-senO, 1, 2);
		matrizRotacao.adicionarNumero( cosO, 2, 2);
		matrizRotacao.adicionarNumero(    0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 3);
		matrizRotacao.adicionarNumero(0, 1, 3);
		matrizRotacao.adicionarNumero(0, 2, 3);
		matrizRotacao.adicionarNumero(1, 3, 3);
		
		// Exibe a matriz no Console
		System.out.println("----------- Matriz Rotação em Torno do Eixo X --------------");
		
		// Adiciona a rotação 
		addRotacao(matrizRotacao);
		
	}

	/**
	 * Adiciona uma Matriz de Rotação em Torno do Eixo Y
	 * @param angulo
	 */
	public void addRotacaoEmTornoDoEixoY(double angulo) {

		// Cria e adiciona os valores na matriz de translação
		Matriz matrizRotacao = new Matriz(4, 4);
		
		// Converte o angulo de Graus para Radiano
		angulo = Math.toRadians(angulo);
		
		// Calcula o Seno e o Cosseno do Angulo convertido em Radianos
		double senO = Math.sin(angulo);
		double cosO = Math.cos(angulo);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizRotacao.adicionarNumero( cosO, 0, 0);
		matrizRotacao.adicionarNumero(    0, 1, 0);
		matrizRotacao.adicionarNumero(-senO, 2, 0);
		matrizRotacao.adicionarNumero(    0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 1);
		matrizRotacao.adicionarNumero(1, 1, 1);
		matrizRotacao.adicionarNumero(0, 2, 1);
		matrizRotacao.adicionarNumero(0, 3, 1);

		// Adiciona a coluna 3 da matriz de Translação
		matrizRotacao.adicionarNumero(senO, 0, 2);
		matrizRotacao.adicionarNumero(   0, 1, 2);
		matrizRotacao.adicionarNumero(cosO, 2, 2);
		matrizRotacao.adicionarNumero(   0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 3);
		matrizRotacao.adicionarNumero(0, 1, 3);
		matrizRotacao.adicionarNumero(0, 2, 3);
		matrizRotacao.adicionarNumero(1, 3, 3);
		
		// Exibe a matriz no Console
		System.out.println("----------- Matriz Rotação em Torno do Eixo Y --------------");
		
		// Adiciona a rotação 
		addRotacao(matrizRotacao);
		
	}
	
	/**
	 * Adiciona uma Matriz de Rotação em Torno do Eixo Z
	 * @param angulo
	 */
	public void addRotacaoEmTornoDoEixoZ(double angulo) {

		// Cria e adiciona os valores na matriz de translação
		Matriz matrizRotacao = new Matriz(4, 4);
		
		// Converte o angulo de Graus para Radiano
		angulo = Math.toRadians(angulo);
		
		// Calcula o Seno e o Cosseno do Angulo convertido em Radianos
		double senO = Math.sin(angulo);
		double cosO = Math.cos(angulo);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizRotacao.adicionarNumero(cosO, 0, 0);
		matrizRotacao.adicionarNumero(senO, 1, 0);
		matrizRotacao.adicionarNumero(   0, 2, 0);
		matrizRotacao.adicionarNumero(   0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizRotacao.adicionarNumero(-senO, 0, 1);
		matrizRotacao.adicionarNumero( cosO, 1, 1);
		matrizRotacao.adicionarNumero(    0, 2, 1);
		matrizRotacao.adicionarNumero(    0, 3, 1);

		// Adiciona a coluna 3 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 2);
		matrizRotacao.adicionarNumero(0, 1, 2);
		matrizRotacao.adicionarNumero(1, 2, 2);
		matrizRotacao.adicionarNumero(0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizRotacao.adicionarNumero(0, 0, 3);
		matrizRotacao.adicionarNumero(0, 1, 3);
		matrizRotacao.adicionarNumero(0, 2, 3);
		matrizRotacao.adicionarNumero(1, 3, 3);
		
		// Exibe a matriz no Console
		System.out.println("----------- Matriz Rotação em Torno do Eixo Z --------------");
		
		// Adiciona a rotação 
		addRotacao(matrizRotacao);
		
	}
	
	/**
	 * Adiciona uma Matriz de Rotação no Arraylist de Operações
	 * @param angulo
	 */
	public void addRotacao(Matriz matrizRotacao) {
		
		// Calcula a diferença do Primeiro Vertice com a Origem e soma com as Variaveis de controle
		double x = matrizObjeto.getLinha(0)[4] + controleTranslacaoX;
		double y = matrizObjeto.getLinha(1)[4] + controleTranslacaoY;
		double z = matrizObjeto.getLinha(2)[4] + controleTranslacaoZ;
		
		// Zera as variaveis de Controle
		controleTranslacaoX = 0;
		controleTranslacaoY = 0;
		controleTranslacaoZ = 0;
		
		// Adiciona uma translação para Origem na lista de Operações
		addTranslacao(-x, -y, -z);
		
		// Adiciona a matriz de Rotação na lista de Operações
		matrizesOperacoes.add(matrizRotacao);
		
		// Adiciona uma translação para o ponto original na lista de Operações
		addTranslacao(x, y, z);
		
		// Exibe a Matriz no Console
		exibirMatrizConsole(matrizRotacao, "Rotação");
		
	}
	
	/**
	 * Adiciona uma Matriz de Reflexão em Torno do Plano XY no Arraylist de Operações
	 */
	public void addReflexaoEmTornoDoPlanoXY() {
		System.out.println("------------- Matriz Reflexão em torno de XY ----------------");
		addReflexao(1, 1, -1);
		
	}
	
	/**
	 * Adiciona uma Matriz de Reflexão em Torno do Plano ZX no Arraylist de Operações
	 */
	public void addReflexaoEmTornoDoPlanoZX() {
		System.out.println("------------- Matriz Reflexão em torno de ZX ----------------");
		addReflexao(1, -1, 1);
		
	}
	
	/**
	 * Adiciona uma Matriz de Reflexão em Torno do Plano YZ no Arraylist de Operações
	 */
	public void addReflexaoEmTornoDoPlanoYZ() {
		System.out.println("------------- Matriz Reflexão em torno de YZ ----------------");
		addReflexao(-1, 1, 1);
		
	}
	
	/**
	 * Adiciona uma Matriz de Reflexão no Arraylist de Operações
	 * @param a
	 * @param b
	 * @param c
	 */
	public void addReflexao(int a, int b, int c) {
		
		// Cria e adiciona os valores na matriz de translação
		Matriz matrizReflexao = new Matriz(4, 4);

		// Adiciona a coluna 1 da matriz de Translação
		matrizReflexao.adicionarNumero(a, 0, 0);
		matrizReflexao.adicionarNumero(0, 1, 0);
		matrizReflexao.adicionarNumero(0, 2, 0);
		matrizReflexao.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizReflexao.adicionarNumero(0, 0, 1);
		matrizReflexao.adicionarNumero(b, 1, 1);
		matrizReflexao.adicionarNumero(0, 2, 1);
		matrizReflexao.adicionarNumero(0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizReflexao.adicionarNumero(0, 0, 2);
		matrizReflexao.adicionarNumero(0, 1, 2);
		matrizReflexao.adicionarNumero(c, 2, 2);
		matrizReflexao.adicionarNumero(0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizReflexao.adicionarNumero(0, 0, 3);
		matrizReflexao.adicionarNumero(0, 1, 3);
		matrizReflexao.adicionarNumero(0, 2, 3);
		matrizReflexao.adicionarNumero(1, 3, 3);
		
		// Adiciona a matriz de Reflexão na lista de Operações
		matrizesOperacoes.add(matrizReflexao);
		
		// Exibe a matriz no Console
		exibirMatrizConsole(matrizReflexao, "Reflexão");
		
	}
	
	/**
	 * Adiciona um Cizalhamento 
	 * @param eixo
	 * @param shX
	 * @param shY
	 * @throws Exception 
	 */
	public void addCisalhamento(String eixo, double shX, double shY) throws Exception {
		
		switch (eixo) {
		case "Em X":
			addCisalhamentoEmX(shX, shY);
			break;
		case "Em Y":
			addCisalhamentoEmY(shX, shY);
			break;
		case "Em Z":
			addCisalhamentoEmZ(shX, shY);
			break;
		
		default:
			throw new Exception("Selecione o Eixo de Cisalhamento");
		}
		
	}
	
	/**
	 * Adiciona Cisalhamento em X
	 * @param a
	 * @param b
	 */
	public void addCisalhamentoEmX(double a, double b) {
		
		addCisalhamento(a, b, 0, 0, 0, 0);
		
	}
	
	/**
	 * Adiciona Cisalhamento em Y
	 * @param c
	 * @param d
	 */
	public void addCisalhamentoEmY(double c, double d) {
		
		addCisalhamento(0, 0, c, d, 0, 0);
		
	}
	
	/**
	 * Adiciona Cisalhamento em Z
	 * @param e
	 * @param f
	 */
	public void addCisalhamentoEmZ(double e, double f) {
		
		addCisalhamento(0, 0, 0, 0, e, f);
		
	}
	
	/**
	 * Adiciona uma Matriz de Cisalhamento no Arraylist de Operações
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 */
	public void addCisalhamento(double a, double b, double c, double d, double e, double f) {
		
		// Cria e adiciona os valores na matriz de translação
		Matriz matrizCisalhamento = new Matriz(4, 4);
		
		// Adiciona a coluna 1 da matriz de Translação
		matrizCisalhamento.adicionarNumero(1, 0, 0);
		matrizCisalhamento.adicionarNumero(a, 1, 0);
		matrizCisalhamento.adicionarNumero(b, 2, 0);
		matrizCisalhamento.adicionarNumero(0, 3, 0);
		
		// Adiciona a coluna 2 da matriz de Translação
		matrizCisalhamento.adicionarNumero(c, 0, 1);
		matrizCisalhamento.adicionarNumero(1, 1, 1);
		matrizCisalhamento.adicionarNumero(d, 2, 1);
		matrizCisalhamento.adicionarNumero(0, 3, 1);
		
		// Adiciona a coluna 3 da matriz de Translação
		matrizCisalhamento.adicionarNumero(e, 0, 2);
		matrizCisalhamento.adicionarNumero(f, 1, 2);
		matrizCisalhamento.adicionarNumero(1, 2, 2);
		matrizCisalhamento.adicionarNumero(0, 3, 2);
		
		// Adiciona a coluna 4 da matriz de Translação
		matrizCisalhamento.adicionarNumero(0, 0, 3);
		matrizCisalhamento.adicionarNumero(0, 1, 3);
		matrizCisalhamento.adicionarNumero(0, 2, 3);
		matrizCisalhamento.adicionarNumero(1, 3, 3);
		
		// Calcula a diferença do Primeiro Vertice com a Origem e soma com as Variaveis de controle
		double x = matrizObjeto.getLinha(0)[4] + controleTranslacaoX;
		double y = matrizObjeto.getLinha(1)[4] + controleTranslacaoY;
		double z = matrizObjeto.getLinha(2)[4] + controleTranslacaoZ;
		
		// Zera as variaveis de Controle
		controleTranslacaoX = 0;
		controleTranslacaoY = 0;
		controleTranslacaoZ = 0;
		
		// Adiciona uma translação para Origem na lista de Operações
		addTranslacao(-x, -y, -z);
		
		// Adiciona a matriz de Cisalhamento na lista de Operações
		matrizesOperacoes.add(matrizCisalhamento);
		
		// Adiciona uma translação para o ponto original na lista de Operações
		addTranslacao(x, y, z);
		
		// Exibe a Matriz no Console
		exibirMatrizConsole(matrizCisalhamento, "Cisalhamento");
		
	}
	
	/**
	 * Exibe a matriz no Console
	 * @param matriz
	 * @param nomeTransformacao
	 */
	private void exibirMatrizConsole(Matriz matriz, String nomeTransformacao) {
		System.out.println("----------- Matriz "+ nomeTransformacao +" -----------------");
		for (int i = 0; i < matriz.getNumeroLinhas(); i++) {
			for (int j = 0; j < matriz.getNumeroColunas(); j++) {
				if (i == 0) {
					System.out.print("x: "+ matriz.getMatriz()[i][j] +" ");
				} else if (i == 1) {
					System.out.print("y: "+ matriz.getMatriz()[i][j] +" ");
				} else if (i == 2) {
					System.out.print("z: "+ matriz.getMatriz()[i][j] +" ");
				} else {
					System.out.print("w: "+ matriz.getMatriz()[i][j] +" ");
				}
			}
			System.out.println();
		}
		System.out.println("------------ Fim "+ nomeTransformacao +" -------------------");
		System.out.println();
		
	}
	
	/**
	 * Desenha uma reta usando o Algoritmo do Declive (DDA)
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void desenharRetaDDA(int x1, int y1, int x2, int y2){
		AlgoritmoReta reta = new AlgoritmoReta();
		
		reta.desenharDDA(x1, y1, x2, y2, bufferedImage);
		
	}
	
	/**
	 * Desenha uma reta usando o Algoritmo do Ponto Medio
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void desenharRetaPontoMedio(int x1, int y1, int x2, int y2){
		AlgoritmoReta reta = new AlgoritmoReta();
		
		reta.desenharPontoMedio(x1, y1, x2, y2, bufferedImage);
		
	}
	
}
