

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class PanelOperadoresGeometricos extends javax.swing.JPanel implements ActionListener {
	private JLabel jLabelImagemInit;
	private JPanel jPanelImagemInicial;
	public JPanel jPanelImagemResultado;
	private BufferedImage telaDePintura;
	private ImageIcon imageIcon, imageIconResultado;
	private JLabel labelImage, labelImageResultado;
	private  ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
	private  ArrayList<Integer> dadosImagemOriginal = new ArrayList<>();
	private JLabel jLabelImagemFinal;
	public static int largura = 256;
	public static int altura = 256;
	public static int larguraOriginal;
	public static int alturaOriginal;
	private BufferedImage telaDePinturaResultado;
	private JRadioButton jRadioButtonX;
	private JRadioButton jRadioButtonXY;
	private JRadioButton jRadioButtonY;
	private JSeparator jSeparator;
	private JTextField jTextFieldCisY;
	private JTextField jTextFieldCisX;
	private JLabel jLabelCisYJSlide;
	private JLabel jLabelCisXJSlide;
	private JPanel jPanelResult;
	private JTextField jTextFieldAngulo;
	private JTextField jTextFieldFator;
	private JLabel jLabelAngulo;
	private JLabel jLabelFator;
	private JSlider jSliderAnguloRotacao;
	private JSlider jSliderValorEscala;
	private JSlider jSliderCisX;
	private JSlider jSliderCisY;
	private JComboBox jComboBoxOperacao;
	private JPanel jPanelOperacoes;
	private JButton jButtonCarregar;
	private JButton jButtonArquivo;
	private JTextField jTextFieldCaminho;
	OperacoesGeometricas opGeometricas = new OperacoesGeometricas();
	private ButtonGroup bGroup;


	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PanelOperadoresGeometricos());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public PanelOperadoresGeometricos() {
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
				jLabelImagemInit.setBounds(103, 11, 90, 16);
				jLabelImagemInit.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jPanelImagemInicial = new JPanel();
				CardLayout jPanelImagemInicialLayout = new CardLayout();
				this.add(jPanelImagemInicial);
				jPanelImagemInicial.setBounds(19, 33, 258, 258);
				jPanelImagemInicial.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelImagemInicial.setLayout(jPanelImagemInicialLayout);
			}
			{
				jPanelResult = new JPanel();
				this.add(jPanelResult);
				jPanelResult.setBounds(289, 33, 597, 533);
				jPanelResult.setBorder(new LineBorder(new java.awt.Color(192,192,192), 1, false));
				jPanelResult.setBackground(new java.awt.Color(255,255,255));
				jPanelResult.setLayout(null);
				jPanelResult.setForeground(new java.awt.Color(0,0,0));
			}
			{
				jPanelImagemResultado = new JPanel();
				jPanelResult.add(jPanelImagemResultado);
				jPanelImagemResultado.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				jPanelImagemResultado.setLayout(null);
				jPanelImagemResultado.setBackground(new java.awt.Color(255,255,255));
				jPanelImagemResultado.setBounds(4, 4, 587, 503);

			}
			{
				jLabelImagemFinal = new JLabel();
				this.add(jLabelImagemFinal);
				jLabelImagemFinal.setText("Imagem Final");
				jLabelImagemFinal.setBounds(541, 11, 90, 16);
				jLabelImagemFinal.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jTextFieldCaminho = new JTextField();
				this.add(jTextFieldCaminho);
				jTextFieldCaminho.setBounds(19, 297, 258, 40);
				jTextFieldCaminho.setBorder(BorderFactory.createTitledBorder("Diretório"));
			}
			{
				jButtonArquivo = new JButton();
				this.add(jButtonArquivo);
				jButtonArquivo.setText("Arquivo");
				jButtonArquivo.setBounds(21, 338, 125, 23);
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
				jButtonCarregar.setBounds(149, 338, 125, 23);
				jButtonCarregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonCarregarActionPerformed(evt);
					}
				});
			}
			{
				jPanelOperacoes = new JPanel();
				this.add(jPanelOperacoes);
				jPanelOperacoes.setBounds(21, 367, 253, 201);
				jPanelOperacoes.setBorder(BorderFactory.createTitledBorder("Operações"));
				jPanelOperacoes.setBackground(new java.awt.Color(255,255,255));
				jPanelOperacoes.setLayout(null);
				{
					ComboBoxModel jComboBoxOperacaoModel = 
							new DefaultComboBoxModel(
									new String[] { "", "Rotação", "Escala", "Cisalhamento", "Reflexão" });
					jComboBoxOperacao = new JComboBox();
					jPanelOperacoes.add(jComboBoxOperacao);
					jComboBoxOperacao.setModel(jComboBoxOperacaoModel);
					jComboBoxOperacao.setBounds(35, 27, 176, 20);
				}
				{
					jSliderAnguloRotacao = new JSlider(JSlider.HORIZONTAL, -360, 360, 0);
					jPanelOperacoes.add(jSliderAnguloRotacao);
					jSliderAnguloRotacao.setBounds(35, 56, 176, 43);
					jSliderAnguloRotacao.setBackground(new java.awt.Color(255,255,255));
					jSliderAnguloRotacao.setMinorTickSpacing(45);
					jSliderAnguloRotacao.setMajorTickSpacing(90);
					jSliderAnguloRotacao.setPaintTicks(true);
					jSliderAnguloRotacao.setPaintLabels(true);
					Hashtable<Integer, JLabel> table = new Hashtable<>();
					table.put (-360, new JLabel("-360"));
					table.put (0, new JLabel("0"));
					table.put (360, new JLabel("360"));
				
					jSliderAnguloRotacao.setLabelTable(table);
					jSliderAnguloRotacao.setVisible(false);
					jSliderAnguloRotacao.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent evt) {
							jSliderAnguloRotacaoStateChanged(evt);
						}
					});
				}
				{
					jSliderValorEscala = new JSlider(JSlider.HORIZONTAL, 1, 20, 10);
					jPanelOperacoes.add(jSliderValorEscala);
					jSliderValorEscala.setBounds(35, 56, 176, 43);
					jSliderValorEscala.setBackground(new java.awt.Color(255,255,255));
					jSliderValorEscala.setMinorTickSpacing(1);
					jSliderValorEscala.setMajorTickSpacing(19);
					jSliderValorEscala.setPaintTicks(true);
					jSliderValorEscala.setPaintLabels(true);
					Hashtable<Integer, JLabel> table = new Hashtable<>();
					table.put (1, new JLabel("0.1"));
					table.put (10, new JLabel("1.0"));
					table.put (20, new JLabel("2.0"));
				
					jSliderValorEscala.setLabelTable(table);
					jSliderValorEscala.setVisible(false);
					jSliderValorEscala.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent evt) {
							jSliderValorEscalaStateChanged(evt);
						}
					});
				}
				
				{
					jSliderCisX = new JSlider(JSlider.HORIZONTAL, -10, 10, 0);
					jPanelOperacoes.add(jSliderCisX);
					jSliderCisX.setBounds(55, 56, 176, 43);
					jSliderCisX.setBackground(new java.awt.Color(255,255,255));
					jSliderCisX.setMinorTickSpacing(1);
					jSliderCisX.setMajorTickSpacing(10);
					jSliderCisX.setPaintTicks(true);
					jSliderCisX.setPaintLabels(true);
					Hashtable<Integer, JLabel> table = new Hashtable<>();
					table.put (-10, new JLabel("-1.0"));
					table.put (0, new JLabel("0"));
					table.put (10, new JLabel("1.0"));
				
					jSliderCisX.setLabelTable(table);
					jSliderCisX.setVisible(false);
					//jSliderCisX.setVisible(false);
					jSliderCisX.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent evt) {
							jSliderCisXStateChanged(evt);
						}
					});
				}
				
				{
					jSliderCisY = new JSlider(JSlider.HORIZONTAL, -10, 10, 0);
					jPanelOperacoes.add(jSliderCisY);
					jSliderCisY.setBounds(55, 134, 176, 43);
					jSliderCisY.setBackground(new java.awt.Color(255,255,255));
					jSliderCisY.setMinorTickSpacing(1);
					jSliderCisY.setMajorTickSpacing(10);
					jSliderCisY.setPaintTicks(true);
					jSliderCisY.setPaintLabels(true);
					Hashtable<Integer, JLabel> table = new Hashtable<>();
					table.put (-10, new JLabel("-1.0"));
					table.put (0, new JLabel("0"));
					table.put (10, new JLabel("1.0"));
				
					jSliderCisY.setLabelTable(table);
					jSliderCisY.setVisible(false);
					//jSliderCisX.setVisible(false);
					jSliderCisY.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent evt) {
							jSliderCisYStateChanged(evt);
						}
					});
				}
				
				{
					jLabelAngulo = new JLabel();
					jPanelOperacoes.add(jLabelAngulo);
					jLabelAngulo.setText("Angulo:");
					jLabelAngulo.setBounds(77, 117, 42, 16);
					jLabelAngulo.setVisible(false);
				}
				{
					jTextFieldAngulo = new JTextField();
					jPanelOperacoes.add(jTextFieldAngulo);
					jTextFieldAngulo.setBounds(124, 116, 31, 20);
					jTextFieldAngulo.setEditable(false);
					jTextFieldAngulo.setVisible(false);

				}
				{
					jLabelFator = new JLabel();
					jPanelOperacoes.add(jLabelFator);
					jLabelFator.setText("Fator:");
					jLabelFator.setBounds(88, 117, 42, 16);
					jLabelFator.setVisible(false);
				}
				{
					jTextFieldFator = new JTextField();
					jPanelOperacoes.add(jTextFieldFator);
					jTextFieldFator.setBounds(124, 116, 31, 20);
					jTextFieldFator.setEditable(false);
					jTextFieldFator.setVisible(false);

				}
				{
					jLabelCisXJSlide = new JLabel();
					jPanelOperacoes.add(jLabelCisXJSlide);
					jLabelCisXJSlide.setText("CisX:");
					jLabelCisXJSlide.setBounds(15, 58, 35, 16);
					jLabelCisXJSlide.setVisible(false);
				}
				{
					jLabelCisYJSlide = new JLabel();
					jPanelOperacoes.add(jLabelCisYJSlide);
					jLabelCisYJSlide.setText("CisY:");
					jLabelCisYJSlide.setBounds(17, 137, 26, 16);
					jLabelCisYJSlide.setVisible(false);
				}
				{
					jTextFieldCisX = new JTextField();
					jPanelOperacoes.add(jTextFieldCisX);
					jTextFieldCisX.setBounds(15, 80, 29, 20);
					jTextFieldCisX.setEditable(false);
					jTextFieldCisX.setVisible(false);
				}
				{
					jTextFieldCisY = new JTextField();
					jPanelOperacoes.add(jTextFieldCisY);
					jTextFieldCisY.setBounds(15, 158, 29, 20);
					jTextFieldCisY.setEditable(false);
					jTextFieldCisY.setVisible(false);
				}
				{
					jSeparator = new JSeparator();
					jPanelOperacoes.add(jSeparator);
					jSeparator.setBounds(17, 116, 219, 10);
					jSeparator.setVisible(false);
				}
				{
					jRadioButtonX = new JRadioButton();
					jPanelOperacoes.add(jRadioButtonX);
					jRadioButtonX.setText("X");
					jRadioButtonX.setBounds(44, 74, 40, 20);
					jRadioButtonX.setBackground(new java.awt.Color(255,255,255));
					jRadioButtonX.setVisible(false);
					jRadioButtonX.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRadioButtonXActionPerformed(evt);
						}
					});
				}
				{
					jRadioButtonY = new JRadioButton();
					jPanelOperacoes.add(jRadioButtonY);
					jRadioButtonY.setText("Y");
					jRadioButtonY.setBounds(100, 74, 38, 20);
					jRadioButtonY.setVisible(false);
					jRadioButtonY.setBackground(new java.awt.Color(255,255,255));
					jRadioButtonY.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRadioButtonYActionPerformed(evt);
						}
					});
				}
				{
					jRadioButtonXY = new JRadioButton();
					jPanelOperacoes.add(jRadioButtonXY);
					jRadioButtonXY.setText("XY");
					jRadioButtonXY.setBounds(153, 74, 50, 20);
					jRadioButtonXY.setVisible(false);
					jRadioButtonXY.setBackground(new java.awt.Color(255,255,255));
					jRadioButtonXY.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRadioButtonXYActionPerformed(evt);
						}
					});
				}
				{
					ButtonGroup bGroup = new ButtonGroup();
					bGroup.add(jRadioButtonX);
					bGroup.add(jRadioButtonY);
					bGroup.add(jRadioButtonXY);
				}
			}
			{
				jComboBoxOperacao.addActionListener(this);
			
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
		
		larguraOriginal = largura;
		alturaOriginal = altura;
		
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
	public  void retornarImagem(BufferedImage telaDePintura, ArrayList<Integer> dadosImagem, int largura, int altura){
		
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
	public void gerarTelaResultado(int largura, int altura){
		jPanelImagemResultado.removeAll();
		telaDePinturaResultado = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		imageIconResultado = new ImageIcon(telaDePinturaResultado);
		labelImageResultado = new JLabel(imageIconResultado);
		labelImageResultado.setLayout(null);
		jPanelImagemResultado.add(labelImageResultado);
		labelImageResultado.setBounds(10, 6, 570, 536);
		jPanelImagemResultado.add(labelImageResultado);
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
			labelImage.setPreferredSize(new java.awt.Dimension(256, 256));

			retornarImagem(telaDePintura, dadosImagemOriginal, altura, largura);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Caminho inválido ou nulo!");
		}
		
	}
	
	/**
	 * Ativa componentes da operação de rotação
	 */
	public void ativaComponentesRotacao(){
		jSliderAnguloRotacao.setVisible(true);
		jLabelAngulo.setVisible(true);
		jTextFieldAngulo.setVisible(true);
	}
	
	/**
	 * Desativa componentes da operação de rotação
	 */
	public void desativaComponentesRotacao(){
		jSliderAnguloRotacao.setVisible(false);
		jLabelAngulo.setVisible(false);
		jTextFieldAngulo.setVisible(false);
	}
	
	/**
	 * Ativa componentes da operação de escala
	 */
	public void ativaComponentesEscala(){
		jSliderValorEscala.setVisible(true);
		jLabelFator.setVisible(true);
		jTextFieldFator.setVisible(true);
	}
	
	/**
	 * Desativa componentes da operação de escala
	 */
	public void desativaComponentesEscala(){
		jSliderValorEscala.setVisible(false);
		jLabelFator.setVisible(false);
		jTextFieldFator.setVisible(false);
	}
	
	/**
	 * Ativa componentes da operação de cisalhamento
	 */
	public void ativaComponentesCisalhamento(){
		jSliderCisX.setVisible(true);
		jSliderCisY.setVisible(true);
		jTextFieldCisX.setVisible(true);
		jTextFieldCisY.setVisible(true);
		jLabelCisXJSlide.setVisible(true);
		jLabelCisYJSlide.setVisible(true);
		jSeparator.setVisible(true);
	}
	
	/**
	 * Desativa componentes da operação de cisalhamento
	 */
	public void desativaComponentesCisalhamento(){
		jSliderCisX.setVisible(false);
		jSliderCisY.setVisible(false);
		jTextFieldCisX.setVisible(false);
		jTextFieldCisY.setVisible(false);
		jLabelCisXJSlide.setVisible(false);
		jLabelCisYJSlide.setVisible(false);
		jSeparator.setVisible(false);
	}
	
	public void ativaComponentesReflexao(){
		jRadioButtonX.setVisible(true);
		jRadioButtonY.setVisible(true);
		jRadioButtonXY.setVisible(true);
	}
	
	public void desativaComponentesReflexao(){
		jRadioButtonX.setVisible(false);
		jRadioButtonY.setVisible(false);
		jRadioButtonXY.setVisible(false);
	}
	/**
	 * Desativa todas as componentes de operações
	 */
	public void desativaComponentes(){
		desativaComponentesEscala();
		desativaComponentesRotacao();
		desativaComponentesCisalhamento();
		desativaComponentesReflexao();
	}
	
	/**
	 * Método para o tratamento de eventos
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == jComboBoxOperacao) {
			desativaComponentes();
			if (jComboBoxOperacao.getSelectedItem().equals("Rotação")) {
				ativaComponentesRotacao();
			}
			else if (jComboBoxOperacao.getSelectedItem().equals("Cisalhamento")) {
				ativaComponentesCisalhamento();
				
			}
			else if (jComboBoxOperacao.getSelectedItem().equals("Escala")) {
				ativaComponentesEscala();
			}
			else if (jComboBoxOperacao.getSelectedItem().equals("Reflexão")) {
				ativaComponentesReflexao();
			}
		}
	
		
	}
	
	/**
	 * Evento do botão Arquivo que abre diretório para a escolha de uma imagem
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
	 * Evento do botão Carregar que carrega a imagem escolhida para um array de pixels
	 * e pinta a imagem na tela
	 * @param evt
	 */
	private void jButtonCarregarActionPerformed(ActionEvent evt) {
	 	String caminho = jTextFieldCaminho.getText();
	 	carregaImagem(caminho);
		updateUI();
	}
	
	/**
	 * Evento do JSlider de Rotação que executa a operação de rotação com a imagem
	 * de acordo com o angulo selecionado no JSlider
	 * @param evt
	 */
	private void jSliderAnguloRotacaoStateChanged(ChangeEvent evt) {
	
		dadosImagemResultado = opGeometricas.opRotacao(dadosImagemOriginal, jSliderAnguloRotacao.getValue(), larguraOriginal, alturaOriginal);
		jTextFieldAngulo.setText(""+jSliderAnguloRotacao.getValue());
		altura = OperacoesGeometricas.novaAltura;
		largura = OperacoesGeometricas.novaLargura;
		gerarTelaResultado(largura, altura);
		
		retornarImagem(telaDePinturaResultado, dadosImagemResultado, largura, altura);
		
	}
	
	/**
	 * Evento do JSlider de Escala que executa a operação de escala com a imagem
	 * de acordo com o fator de escala selecionado no JSlider
	 * @param evt
	 */
	private void jSliderValorEscalaStateChanged(ChangeEvent evt){
		double fatorEscala = (jSliderValorEscala.getValue()/10.0);
		dadosImagemResultado = opGeometricas.opEscala(dadosImagemOriginal, fatorEscala, larguraOriginal, alturaOriginal);
		jTextFieldFator.setText(""+fatorEscala);
		altura = OperacoesGeometricas.novaAltura;
		largura = OperacoesGeometricas.novaLargura;
		gerarTelaResultado(largura, altura);
		retornarImagem(telaDePinturaResultado, dadosImagemResultado, largura, altura);
		
	}
	/**
	 * Evento do JSlider de Cisalhamento em X que executa a operação de cisalhamento
	 * com a imagem de acordo com o valor de cisalhamento em X e em Y
	 * @param evt
	 */
	private void jSliderCisXStateChanged(ChangeEvent evt){
		double valorCisX = -(jSliderCisX.getValue()/10.0);
		double valorCisY = -(jSliderCisY.getValue()/10.0);
		dadosImagemResultado = opGeometricas.opCisalhamento(dadosImagemOriginal, valorCisX, valorCisY, larguraOriginal, alturaOriginal);
		jTextFieldCisX.setText(""+valorCisX);
		altura = OperacoesGeometricas.novaAltura;
		largura = OperacoesGeometricas.novaLargura;
		gerarTelaResultado(largura, altura);
		retornarImagem(telaDePinturaResultado, dadosImagemResultado, largura, altura);
	}
	
	/**
	 * Evento do JSlider de Cisalhamento em Y que executa a operação de cisalhamento
	 * com a imagem de acordo com o valor de cisalhamento em X e em Y
	 * @param evt
	 */
	private void jSliderCisYStateChanged(ChangeEvent evt){
		double valorCisX = -(jSliderCisX.getValue()/10.0);
		double valorCisY = -(jSliderCisY.getValue()/10.0);
		dadosImagemResultado = opGeometricas.opCisalhamento(dadosImagemOriginal, valorCisX, valorCisY, larguraOriginal, alturaOriginal);
		jTextFieldCisY.setText(""+valorCisY);
		altura = OperacoesGeometricas.novaAltura;
		largura = OperacoesGeometricas.novaLargura;
		gerarTelaResultado(largura, altura);
		retornarImagem(telaDePinturaResultado, dadosImagemResultado, largura, altura);
	}
	 
	/**
	 * Evento do JRadioButton X - Reflexão em torno de X com a imagem
	 * @param evt
	 */
	 private void jRadioButtonXActionPerformed(ActionEvent evt) {
		
			dadosImagemResultado = opGeometricas.opReflexao(dadosImagemOriginal, "x", larguraOriginal, alturaOriginal);
			gerarTelaResultado(larguraOriginal, alturaOriginal);
			retornarImagem(telaDePinturaResultado, dadosImagemResultado, larguraOriginal, alturaOriginal);
	 }
	 
	 /**
	  * Evento do JRadioButton Y - Reflexão em torno de Y com a imagem
	  * @param evt
	  */
	 private void jRadioButtonYActionPerformed(ActionEvent evt) {
			
			dadosImagemResultado = opGeometricas.opReflexao(dadosImagemOriginal, "y", larguraOriginal, alturaOriginal);
			gerarTelaResultado(larguraOriginal, alturaOriginal);
			retornarImagem(telaDePinturaResultado, dadosImagemResultado, larguraOriginal, alturaOriginal);
	 }
	 
	 /**
	  * Evento do JRadioButton XY - Reflexão em torno de X e Y com a imagem
	  * @param evt
	  */
	 private void jRadioButtonXYActionPerformed(ActionEvent evt) {
			
			dadosImagemResultado = opGeometricas.opReflexao(dadosImagemOriginal, "xy", larguraOriginal, alturaOriginal);
			gerarTelaResultado(larguraOriginal, alturaOriginal);
			retornarImagem(telaDePinturaResultado, dadosImagemResultado, larguraOriginal, alturaOriginal);
	 }

}
