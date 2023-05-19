

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelHistograma extends javax.swing.JPanel {
	private JLabel jLabelImagemInitTxt;
	private JPanel jPanelImagemInicial;
	private BufferedImage telaDePinturaInicial;
	private BufferedImage telaHistogramaInit;
	private JLabel jLabelHistogramaEqTxt;
	private JPanel jPanelHistogramaEq;
	private JPanel jPanelHistogramaInit;
	private BufferedImage teladePinturaResultado;
	private BufferedImage telaHistogramaFinal;
	private ImageIcon imageIconInicial, imageIconHistogramaInit, imageIconResultado, imageIconHistogramaFinal;
	private JLabel labelImageInicial, labelImageResultado;
	public static ArrayList<Integer> dadosImagemInicial = new ArrayList<>();
	public static ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
	private JLabel jLabelImagemResultado;
	private JLabel jLabelImageHistogramaInit;
	private JLabel jLabelImgEq;
	private JPanel jPanelImgResultado;
	private JLabel jLabelImageHistogramaFinal;
	public static int largura = 256;
	public static int altura = 256;
	private Graphics graphics;
	private Histograma histograma;
	private JButton jButtonCarregar;
	private JButton jButtonArquivo;
	private JTextField jTextFieldCaminho;
	private JButton jButtonEqualizar;

	
	public PanelHistograma() {
		super();
		initGUI();
	}
	
	/**
	 * Construtor
	 */
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(900, 700));
			this.setLayout(null);
			this.setBackground(new java.awt.Color(255,255,255));
			{
				jLabelImagemInitTxt = new JLabel();
				this.add(jLabelImagemInitTxt);
				jLabelImagemInitTxt.setText("Imagem Inicial");
				jLabelImagemInitTxt.setBounds(123, 24, 101, 16);
				jLabelImagemInitTxt.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jPanelImagemInicial = new JPanel();
				CardLayout jPanelImagemInicialLayout = new CardLayout();
				this.add(jPanelImagemInicial);
				jPanelImagemInicial.setBounds(22, 47, 257, 257);
				jPanelImagemInicial.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelImagemInicial.setLayout(jPanelImagemInicialLayout);
			}

			{
				jLabelImagemResultado = new JLabel();
				this.add(jLabelImagemResultado);
				jLabelImagemResultado.setText("Histograma Inicial");
				jLabelImagemResultado.setBounds(408, 24, 139, 16);
				jLabelImagemResultado.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jPanelImgResultado = new JPanel();
				this.add(jPanelImgResultado);
				CardLayout jPanel1Layout = new CardLayout();
				jPanelImgResultado.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jPanelImgResultado.setLayout(jPanel1Layout);
				jPanelImgResultado.setBounds(22, 342, 258, 258);
				{
					jLabelImagemResultado = new JLabel();
					jPanelImgResultado.add(jLabelImagemResultado, "labelImage");
					jLabelImagemResultado.setIcon(imageIconInicial);
					jLabelImagemResultado.setBounds(1, 1, largura, altura);
					jLabelImagemResultado.setPreferredSize(new java.awt.Dimension(256, 256));
				}
			}
			{
				jLabelImgEq = new JLabel();
				this.add(jLabelImgEq);
				jLabelImgEq.setText("Imagem Equalizada");
				jLabelImgEq.setFont(new java.awt.Font("Segoe UI",1,12));
				jLabelImgEq.setBounds(111, 320, 121, 16);
			}
			{
				jPanelHistogramaInit = new JPanel();
				this.add(jPanelHistogramaInit);
				jPanelHistogramaInit.setBounds(290, 47, 342, 258);
				jPanelHistogramaInit.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelHistogramaInit.setLayout(null);
				criaTelaHistogramaInit();
				
				

			}
			{
				jPanelHistogramaEq = new JPanel();
				this.add(jPanelHistogramaEq);
				jPanelHistogramaEq.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jPanelHistogramaEq.setBounds(290, 342, 342, 258);
				jPanelHistogramaEq.setLayout(null);
				criaTelaHistogramaEqualizado();

			}
			{
				jLabelHistogramaEqTxt = new JLabel();
				this.add(jLabelHistogramaEqTxt);
				jLabelHistogramaEqTxt.setText("Histograma Equalizado");
				jLabelHistogramaEqTxt.setFont(new java.awt.Font("Segoe UI",1,12));
				jLabelHistogramaEqTxt.setBounds(394, 320, 139, 16);
			}
			{
				jButtonEqualizar = new JButton();
				this.add(jButtonEqualizar);
				jButtonEqualizar.setText("Equalizar");
				jButtonEqualizar.setBounds(709, 176, 100, 23);
				jButtonEqualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonEqualizarActionPerformed(evt);
					}
				});
			}
			{
				jTextFieldCaminho = new JTextField();
				this.add(jTextFieldCaminho);
				jTextFieldCaminho.setBounds(657, 97, 207, 39);
				jTextFieldCaminho.setBorder(BorderFactory.createTitledBorder("Diretório"));
			}
			{
				jButtonArquivo = new JButton();
				this.add(jButtonArquivo);
				jButtonArquivo.setText("Arquivo");
				jButtonArquivo.setBounds(659, 142, 100, 23);
				jButtonArquivo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonArquivoActionPerformed(evt);
					}
				});
			}
			{
				jButtonCarregar = new JButton();
				this.add(jButtonCarregar);
				jButtonCarregar.setText("Carregar");
				jButtonCarregar.setBounds(762, 142, 100, 23);
				jButtonCarregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonCarregarActionPerformed(evt);
					}
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cria tela de desenho para o histograma da imagem inicial
	 */
	public void criaTelaHistogramaInit(){
		
		telaHistogramaInit = new BufferedImage(339, 258, BufferedImage.TYPE_INT_RGB);
		imageIconHistogramaInit = new ImageIcon(telaHistogramaInit);
		jLabelImageHistogramaInit = new JLabel(imageIconHistogramaInit);
		jPanelHistogramaInit.add(jLabelImageHistogramaInit);
		jLabelImageHistogramaInit.setBounds(0, 0, 339, 257);
		graphics = telaHistogramaInit.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(1, 2, 339, 258);
		graphics.setColor(Color.BLACK);
		//eixo Y
		graphics.drawLine(38, 20, 38, 225);
		//eixo X
		graphics.drawLine(38, 225, 310, 225);
		
		//niveis - 0-255
		graphics.drawString("0", 38, 240);
		graphics.drawString("50", 88, 240);
		graphics.drawString("100", 138, 240);
		graphics.drawString("150", 188, 240);
		graphics.drawString("200", 238, 240);
		graphics.drawString("255", 292, 240);
		
		//repetições
		graphics.drawString("0", 26, 225);
		graphics.drawString("150", 12, 180);
		graphics.drawString("300", 12, 135);
		graphics.drawString("450", 12, 90);
		graphics.drawString("600", 12, 45);
	}
	
	/**
	 * Cria tela de desenho para o histograma equalizado
	 */
	public void criaTelaHistogramaEqualizado(){
		telaHistogramaFinal = new BufferedImage(339, 258, BufferedImage.TYPE_INT_RGB);
		imageIconHistogramaFinal = new ImageIcon(telaHistogramaFinal);
		jLabelImageHistogramaFinal = new JLabel(imageIconHistogramaFinal);
		jPanelHistogramaEq.add(jLabelImageHistogramaFinal);
		jLabelImageHistogramaFinal.setBounds(0, 0, 339, 257);

		graphics = telaHistogramaFinal.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(1, 2, 339, 258);
		graphics.setColor(Color.BLACK);
		//eixo Y
		graphics.drawLine(38, 20, 38, 225);
		//eixo X
		graphics.drawLine(38, 225, 310, 225);
		
		//niveis - 0-255
		graphics.drawString("0", 38, 240);
		graphics.drawString("50", 88, 240);
		graphics.drawString("100", 138, 240);
		graphics.drawString("150", 188, 240);
		graphics.drawString("200", 238, 240);
		graphics.drawString("255", 292, 240);
		
		//repetições
		graphics.drawString("0", 26, 225);
		graphics.drawString("150", 12, 180);
		graphics.drawString("300", 12, 135);
		graphics.drawString("450", 12, 90);
		graphics.drawString("600", 12, 45);
	}
	/**
	 * Carrega o arquivo de Imagem PGM e copia os pixels para o ArrayList recebido.
	 * @param caminho
	 * @throws IOException
	 */
	public void lerPixelsImagem(ArrayList<Integer> dadosImagem, String caminho) throws IOException{
		dadosImagem.clear();
		
		BufferedReader dados = new BufferedReader(new FileReader(caminho));
		
		String tipo = dados.readLine();
		String dimensao = dados.readLine();
		String profundidade = dados.readLine();
		
		StringTokenizer stk = new StringTokenizer(dimensao," ");
		largura = Integer.parseInt(stk.nextToken());
		altura = Integer.parseInt(stk.nextToken());
		
		String linha;
		StringTokenizer valorPixel;
		
		for (int i = 0; i < altura; i++){
			 linha = dados.readLine();
			 valorPixel = new StringTokenizer(linha," ");
			 for (int j = 0; j < largura; j++) {
				  dadosImagem.add(Integer.parseInt(valorPixel.nextToken()));
			}				
		}	
	}
	
	/**
	 * Recebe tela de pintura e ArrayList de pixels para pintar a imagem 
	 * @param telaDePintura
	 * @param dadosImagem
	 */
	public void retornarImagem(BufferedImage telaDePintura, ArrayList<Integer> dadosImagem){
		
		try {
			if (!dadosImagem.isEmpty()){
				int valorPixel;
				int posicaoPixel;
				int corPixel;
				for (int x = 0; x < largura; x++) {
					for (int y = 0; y < altura; y++) {
						posicaoPixel = (y * largura) + x;
						valorPixel = dadosImagem.get(posicaoPixel);
						corPixel = new Color(valorPixel, valorPixel, valorPixel).getRGB();
						telaDePintura.setRGB(x, y, corPixel);
					}
				}
				updateUI();
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Dados da imagem inexistentes!");
			
		}
		
		
		
	}
	/**
	 * Cria tela de desenho para a imagem resultado de acordo com o tamanho da imagem 
	 * carregada inicialmente
	 */
	public void gerarTelaResultado(){
		jPanelImgResultado.removeAll();
		teladePinturaResultado = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		imageIconResultado = new ImageIcon(teladePinturaResultado);
		labelImageResultado = new JLabel(imageIconResultado);
		jPanelImgResultado.add(labelImageResultado);
		
		updateUI();
		
	}
	
	
	/**
	 * Cria tela de desenho para a imagem Inicial de acordo com o tamanho da imagem
	 * e em seguida pinta a imagem carregada.
	 * @param caminhoImagem
	 */
	public void carregaImagem(String caminhoImagem) {
		
		
		try {
			
			lerPixelsImagem(dadosImagemInicial, caminhoImagem);
			jPanelImagemInicial.removeAll();
			telaDePinturaInicial = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			imageIconInicial = new ImageIcon(telaDePinturaInicial);
			labelImageInicial = new JLabel(imageIconInicial);
			jPanelImagemInicial.add(labelImageInicial);
			labelImageInicial.setBounds(1, 1, largura, altura);
			jPanelImagemInicial.add(labelImageInicial, "labelImage");
			
			
			retornarImagem(telaDePinturaInicial, dadosImagemInicial);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Caminho inválido ou nulo!");
		}
		
	}

	
	/**
	 * Evento do botão Equalizar que gera a imagem equalizada e o gráfico da imagem equalizada
	 * @param evt
	 */
	private void jButtonEqualizarActionPerformed(ActionEvent evt) {
		try {
			histograma.calcularSK();
			histograma.determinarNovosNiveis();
			dadosImagemResultado = histograma.equalizarImagem(dadosImagemInicial);
			
			jPanelHistogramaEq.removeAll();
			criaTelaHistogramaEqualizado();
			gerarTelaResultado();
			retornarImagem(teladePinturaResultado, dadosImagemResultado);
			histograma.desenharNiveisImagemFinal(telaHistogramaFinal);
			updateUI();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Carregue uma imagem!");
		}
		
		
	}
	 
	/**
	 * Evento do botão arquivo que abre um JFileChooser para a escolha do arquivo a ser carregado
	 * @param evt
	 */
	 private void jButtonArquivoActionPerformed(ActionEvent evt) {
		 	JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File arquivo = chooser.getSelectedFile();
			
			try {
				String caminhoArquivo = arquivo.getAbsolutePath();
				jTextFieldCaminho.setText(caminhoArquivo);
			} catch (Exception e) {
				//não faz nada
			}
			
			
	 }
	 
	 /**
	  * Evento do botão Carregar que carrega a imagem para a tela de desenho inicial e seu
	  * respectivo histograma para a tela do histograma inicial
	  * @param evt
	  */
	 private void jButtonCarregarActionPerformed(ActionEvent evt) {
		 
		 	String caminho = jTextFieldCaminho.getText();
		 	carregaImagem(caminho);
			histograma = new Histograma(dadosImagemInicial);
			jPanelHistogramaInit.removeAll();
			criaTelaHistogramaInit();
			histograma.desenharNiveisImagemInicial(telaHistogramaInit);
			updateUI();
	 }

}
