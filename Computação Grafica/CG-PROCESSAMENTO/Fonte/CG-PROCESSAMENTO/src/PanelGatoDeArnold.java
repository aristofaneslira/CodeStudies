

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
import java.sql.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Timer;

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
import javax.swing.JSlider;
import javax.swing.JTextField;
import Sound.ThreadCatSound;



public class PanelGatoDeArnold extends javax.swing.JPanel {
	private JLabel jLabelImagemInit;
	private JPanel jPanelImagemInicial;
	public static JPanel jPanelImagemResultado;
	private BufferedImage telaDePintura;
	private ImageIcon imageIcon, imageIconResultado;
	private JLabel labelImage, labelImageResultado;
	public static ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
	public static ArrayList<Integer> dadosImagemOriginal = new ArrayList<>();
	private JTextField jTextFieldFator;
	private JLabel jLabelImagemFinal;
	public static int largura = 256;
	public static int altura = 256;
	private BufferedImage telaDePinturaResultado;
	private JLabel jLabelTimer;
	public static JLabel jLabelIteracoes;
	private JButton jButtonIniciar;
	private JPanel jPanelStatus;
	private JButton jButtonCarregar;
	private JButton jButtonArquivo;
	private JTextField jTextFieldCaminho;
	private GatoDeArnold gatoDeArnold;
	private CountThread contador;
	private ThreadCatSound soundCat;
	public Thread t;
	public Thread time;
	public Thread miau;


	public PanelGatoDeArnold() {
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
				jLabelImagemInit = new JLabel();
				this.add(jLabelImagemInit);
				jLabelImagemInit.setText("Imagem Inicial");
				jLabelImagemInit.setBounds(113, 41, 90, 16);
				jLabelImagemInit.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jPanelImagemInicial = new JPanel();
				CardLayout jPanelImagemInicialLayout = new CardLayout();
				this.add(jPanelImagemInicial);
				jPanelImagemInicial.setBounds(30, 63, 258, 258);
				jPanelImagemInicial.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelImagemInicial.setLayout(jPanelImagemInicialLayout);
			}
			{
				jPanelImagemResultado = new JPanel();
				CardLayout jPanelImagemResultadoLayout = new CardLayout();
				this.add(jPanelImagemResultado);
				jPanelImagemResultado.setBounds(600, 63, 258, 258);
				jPanelImagemResultado.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelImagemResultado.setLayout(jPanelImagemResultadoLayout);
				
			}
			{
				jLabelImagemFinal = new JLabel();
				this.add(jLabelImagemFinal);
				jLabelImagemFinal.setText("Imagem Final");
				jLabelImagemFinal.setBounds(689, 42, 90, 16);
				jLabelImagemFinal.setFont(new java.awt.Font("Segoe UI",1,12));
			}
	


			{
				jTextFieldFator = new JTextField();
				this.add(jTextFieldFator);
				jTextFieldFator.setBounds(440, 187, 30, 20);
				jTextFieldFator.setVisible(false);
			}
			{
				jTextFieldCaminho = new JTextField();
				this.add(jTextFieldCaminho);
				jTextFieldCaminho.setBounds(320, 70, 249, 39);
				jTextFieldCaminho.setBorder(BorderFactory.createTitledBorder("Diretório"));
			}
			{
				jButtonArquivo = new JButton();
				this.add(jButtonArquivo);
				jButtonArquivo.setText("Arquivo");
				jButtonArquivo.setBounds(325, 117, 114, 23);
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
				jButtonCarregar.setBounds(448, 117, 114, 23);
				jButtonCarregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonCarregarActionPerformed(evt);
					}

					
				});
			}
			{
				jPanelStatus = new JPanel();
				this.add(jPanelStatus);
				jPanelStatus.setBounds(320, 158, 249, 75);
				jPanelStatus.setBackground(new java.awt.Color(255,255,255));
				jPanelStatus.setBorder(BorderFactory.createTitledBorder("Status"));
				jPanelStatus.setLayout(null);
				{
					jLabelIteracoes = new JLabel();
					jPanelStatus.add(jLabelIteracoes);
					jLabelIteracoes.setText("Iterações: 0");
					jLabelIteracoes.setBounds(17, 22, 161, 16);
				}
				{
					jLabelTimer = new JLabel();
					jPanelStatus.add(jLabelTimer);
					jLabelTimer.setText("Tempo Decorrido: 0 s");
					jLabelTimer.setBounds(17, 44, 207, 16);
				}
				
			}
			{
				jButtonIniciar = new JButton();
				this.add(jButtonIniciar);
				jButtonIniciar.setText("Iniciar");
				jButtonIniciar.setBounds(386, 242, 114, 23);
				jButtonIniciar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonIniciarActionPerformed(evt);
					}
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Carrega o arquivo de Imagem PGM e copia os pixels para o ArrayList dadosImagemOriginal
	 * @param caminho
	 * @throws IOException
	 */
	public void lerPixelsImagem(String caminho) throws IOException{
		dadosImagemOriginal.clear();
		
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
				  dadosImagemOriginal.add(Integer.parseInt(valorPixel.nextToken()));
			}				
		}	
	}
	
	/**
	 * Recebe tela de pintura e ArrayList de pixels para pintar a imagem 
	 * @param telaDePintura
	 * @param dadosImagem
	 */
	public  void retornarImagem(BufferedImage telaDePintura, ArrayList<Integer> dadosImagem){
		
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
		jPanelImagemResultado.removeAll();
		telaDePinturaResultado = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		imageIconResultado = new ImageIcon(telaDePinturaResultado);
		labelImageResultado = new JLabel(imageIconResultado);
		labelImageResultado.setLayout(null);
		jPanelImagemResultado.add(labelImageResultado);
		labelImageResultado.setBounds(1, 1, largura, altura);
		jPanelImagemResultado.add(labelImageResultado, "labelImageResultado");
		updateUI();
		
	}
	
	/**
	 * Cria tela de desenho para a imagem inicial de acordo com o tamanho da imagem
	 * e em seguida pinta a imagem carregada.
	 * @param caminhoImagem
	 */
	public void carregaImagem(String caminhoImagem) {
		
		
		try {
			
			lerPixelsImagem(caminhoImagem);
			jPanelImagemInicial.removeAll();
			telaDePintura = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			imageIcon = new ImageIcon(telaDePintura);
			labelImage = new JLabel(imageIcon);
			jPanelImagemInicial.add(labelImage);
			labelImage.setBounds(1, 1, largura, altura);
			jPanelImagemInicial.add(labelImage, "labelImage");
			
			
			retornarImagem(telaDePintura, dadosImagemOriginal);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Caminho inválido ou nulo!");
		}
		
	}
	
	/**
	 * Evento do Botão Arquivo que abre o diretório para escolha da imagem a ser aberta
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
	 * Evento do Botão Carregar que pinta a imagem escolhida na tela da Imagem Inicial
	 * @param evt
	 */
	private void jButtonCarregarActionPerformed(ActionEvent evt) {
		String caminho = jTextFieldCaminho.getText();
	 	carregaImagem(caminho);
		updateUI();
		
	}
	
	/**
	 * Evento do Botão Iniciar, que executa o algoritmo do Gato de Arnold e as Threads
	 * de Iterações realizadas a cada loop do algoritmo e o Timer referente ao tempo 
	 * desde o inicio do processo
	 * @param evt
	 */
	private void jButtonIniciarActionPerformed(ActionEvent evt) {
		
		gerarTelaResultado();
		
		//thread do processo do gato de arnold
		gatoDeArnold = new GatoDeArnold(this, telaDePinturaResultado, dadosImagemOriginal, largura, altura);
		t = new Thread(gatoDeArnold);
		t.start();
			
		//thread do timer do processo
		contador = new CountThread(t, this.jLabelTimer);
		time = new Thread(contador);
		time.start();
		
		//Som após término do processo
		soundCat = new ThreadCatSound(t);
		miau = new Thread(soundCat);
		miau.start();		

	}
	
	
}
