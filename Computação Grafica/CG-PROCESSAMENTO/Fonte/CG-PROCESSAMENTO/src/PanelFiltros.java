

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelFiltros extends javax.swing.JPanel implements ActionListener {
	private JLabel jLabelImagemInit;
	private JPanel jPanelImagemInicial;
	private JPanel jPanelImagemResultado;
	private BufferedImage telaDePintura;
	private ImageIcon imageIcon, imageIconResultado;
	private JLabel labelImage, labelImageResultado;
	public static ArrayList<Integer> dadosImagemResultado, dadosImagemOriginal = new ArrayList<>();
	private JComboBox jComboBoxFiltros;
	private JLabel jLabelFiltros;
	private JButton jButtonResetar;
	private JTextField jTextFieldFator;
	private JLabel jLabelFator;
	private JLabel jLabelOperador;
	private JTable jTableOperador;
	private JButton jButtonAplicar;
	private JPanel jPanelOperador;
	private JLabel jLabelImagemFinal;
	private JLabel jLabelRealce;
	private JComboBox jComboBoxRealce;
	public static int largura = 256;
	public static int altura = 256;
	private BufferedImage telaDePinturaResultado;
	private JLabel jLabelOperacoes;
	private JComboBox jComboBoxSobel;
	private JComboBox jComboBoxPrewitt;
	private JComboBox jComboBoxRoberts;
	private JComboBox jComboBoxRobertsCruzado;
	private JLabel jLabelImgRealce;
	private JComboBox jComboBoxImagem;
	private String imagem;

	
	public PanelFiltros() {
		super();
		initGUI();
	}
	
	/**
	 * Construtor
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
				ComboBoxModel jComboBoxFiltrosModel = 
						new DefaultComboBoxModel(
								new String[] { "","Media", "Mediana", "Realce" });
				jComboBoxFiltros = new JComboBox();
				this.add(jComboBoxFiltros);
				jComboBoxFiltros.setModel(jComboBoxFiltrosModel);
				jComboBoxFiltros.setBounds(359, 85, 167, 20);
		
			}
			{
				jLabelFiltros = new JLabel();
				this.add(jLabelFiltros);
				jLabelFiltros.setText("Filtros");
				jLabelFiltros.setBounds(359, 66, 70, 16);
				jLabelFiltros.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				ComboBoxModel jComboBoxRealceModel = 
						new DefaultComboBoxModel(
								new String[] {"", "Alto Reforço", "Passa Alta Básico", "Sobel", "Prewitt", "Roberts", "Roberts Cruzado" });
				jComboBoxRealce = new JComboBox();
				this.add(jComboBoxRealce);
				jComboBoxRealce.setModel(jComboBoxRealceModel);
				jComboBoxRealce.setBounds(359, 140, 167, 20);
				jComboBoxRealce.setVisible(false);
			}
			{
				jLabelRealce = new JLabel();
				this.add(jLabelRealce);
				jLabelRealce.setText("Operadores de Realce");
				jLabelRealce.setFont(new java.awt.Font("Segoe UI",1,12));
				jLabelRealce.setBounds(359, 121, 131, 16);
				jLabelRealce.setVisible(false);
			}
			{
				jLabelImagemFinal = new JLabel();
				this.add(jLabelImagemFinal);
				jLabelImagemFinal.setText("Imagem Final");
				jLabelImagemFinal.setBounds(689, 42, 90, 16);
				jLabelImagemFinal.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jPanelOperador = new JPanel();
				this.add(jPanelOperador);
				jPanelOperador.setBounds(382, 264, 117, 96);
				jPanelOperador.setLayout(null);
				jPanelOperador.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelOperador.setBackground(new java.awt.Color(192,192,192));
				{
					TableModel jTableOperadorModel = 
							new DefaultTableModel(
									new String[][] { { "a11", "a12", "a13" }, {"a21", "a22", "a23"}, {"a31", "a32", "a33"}},
									new String[] { "Column 1", "Column 2", "Column 3"});
					jTableOperador = new JTable();
					jPanelOperador.add(jTableOperador);
					jTableOperador.setModel(jTableOperadorModel);
					jTableOperador.setBounds(4, 4, 109, 88);
					jTableOperador.setFont(new java.awt.Font("Segoe UI",0,14));
					jTableOperador.setEnabled(false);
					jTableOperador.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jTableOperador.setGridColor(new java.awt.Color(0,0,0));
					jTableOperador.setRowHeight(30);
					
					TableCellRenderer centerRenderer = new CenterRenderer();  
					TableColumn column = jTableOperador.getColumnModel().getColumn(0);  
					column.setCellRenderer(centerRenderer);  
					TableColumn column2 = jTableOperador.getColumnModel().getColumn(1);
					column2.setCellRenderer(centerRenderer); 
					TableColumn column3 = jTableOperador.getColumnModel().getColumn(2);
					column3.setCellRenderer(centerRenderer);
								
				}
				
			}
			{
				jButtonAplicar = new JButton();
				this.add(jButtonAplicar);
				jButtonAplicar.setText("Aplicar");
				jButtonAplicar.setBounds(359, 379, 79, 23);
				jButtonAplicar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonAplicarActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel jComboBoxImagemModel = 
						new DefaultComboBoxModel(
								new String[] { "lena.pgm", "airplane.pgm" });
				jComboBoxImagem = new JComboBox();
				this.add(jComboBoxImagem);
				jComboBoxImagem.setModel(jComboBoxImagemModel);
				jComboBoxImagem.setBounds(77, 360, 170, 20);
				jComboBoxImagem.setVisible(false);
			}
			{
				jLabelImgRealce = new JLabel();
				this.add(jLabelImgRealce);
				jLabelImgRealce.setText("Imagem:");
				jLabelImgRealce.setBounds(77, 339, 65, 16);
				jLabelImgRealce.setVisible(false);
			}
			{
				
				ComboBoxModel jComboBoxSobelModel = 
						new DefaultComboBoxModel(
								new String[] { " ", "Sobel em X", "Sobel em Y", "Sobel Magnitude" });
				jComboBoxSobel = new JComboBox();
				this.add(jComboBoxSobel);
				jComboBoxSobel.setModel(jComboBoxSobelModel);
				jComboBoxSobel.setBounds(359, 195, 167, 20);
				jComboBoxSobel.setVisible(false);
			}
			{
				ComboBoxModel jComboBoxPrewittModel = 
						new DefaultComboBoxModel(
								new String[] { " ", "Prewitt em X", "Prewitt em Y", "Prewitt Magnitude" });
				jComboBoxPrewitt = new JComboBox();
				this.add(jComboBoxPrewitt);
				jComboBoxPrewitt.setModel(jComboBoxPrewittModel);
				jComboBoxPrewitt.setBounds(359, 195, 167, 20);
				jComboBoxPrewitt.setVisible(false);
			}
			{
				ComboBoxModel jComboBoxRobertsModel = 
						new DefaultComboBoxModel(
								new String[] { " ", "Roberts em X", "Roberts em Y", "Roberts Magnitude" });
				jComboBoxRoberts = new JComboBox();
				this.add(jComboBoxRoberts);
				jComboBoxRoberts.setModel(jComboBoxRobertsModel);
				jComboBoxRoberts.setBounds(359, 195, 167, 20);
				jComboBoxRoberts.setVisible(false);
			}
			{
				ComboBoxModel jComboBoxRobertsCruzadoModel = 
						new DefaultComboBoxModel(
								new String[] { " ", "Roberts Cruzado em X", "Roberts Cruzado em Y", "Roberts Cruzado Magnitude" });
				jComboBoxRobertsCruzado = new JComboBox();
				this.add(jComboBoxRobertsCruzado);
				jComboBoxRobertsCruzado.setModel(jComboBoxRobertsCruzadoModel);
				jComboBoxRobertsCruzado.setBounds(359, 195, 167, 20);
				jComboBoxRobertsCruzado.setVisible(false);
			}
			{
				jLabelOperacoes = new JLabel();
				this.add(jLabelOperacoes);
				jLabelOperacoes.setText("Operações:");
				jLabelOperacoes.setBounds(359, 176, 77, 16);
				jLabelOperacoes.setFont(new java.awt.Font("Segoe UI",1,12));
				jLabelOperacoes.setVisible(false);
			}
			{
				jLabelOperador = new JLabel();
				this.add(jLabelOperador);
				jLabelOperador.setText("Operador");
				jLabelOperador.setBounds(413, 243, 67, 16);
				jLabelOperador.setFont(new java.awt.Font("Tahoma",1,11));
			}
			{
				jLabelFator = new JLabel();
				this.add(jLabelFator);
				jLabelFator.setText("Fator A:");
				jLabelFator.setBounds(385, 190, 61, 14);
				jLabelFator.setFont(new java.awt.Font("Tahoma",1,11));
				jLabelFator.setVisible(false);
			}
			{
				jTextFieldFator = new JTextField();
				this.add(jTextFieldFator);
				jTextFieldFator.setBounds(440, 187, 30, 20);
				jTextFieldFator.setVisible(false);
			}
			{
				jButtonResetar = new JButton();
				this.add(jButtonResetar);
				jButtonResetar.setText("Resetar");
				jButtonResetar.setBounds(443, 379, 79, 23);
				jButtonResetar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonResetarActionPerformed(evt);
					}
				});
			}
			{
				jComboBoxFiltros.addActionListener(this);
				jComboBoxImagem.addActionListener(this);
				jComboBoxRealce.addActionListener(this);
				jComboBoxPrewitt.addActionListener(this);
				jComboBoxSobel.addActionListener(this);
				jComboBoxRoberts.addActionListener(this);
				jComboBoxRobertsCruzado.addActionListener(this);
			}
			{
			
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
	@SuppressWarnings({ "resource", "unused" })
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
	 * Aplica a transformação escolhida na Imagem Inicial, gerando a Imagem Final
	 * @param evt
	 */
	private void jButtonAplicarActionPerformed(ActionEvent evt) {
		double fator;
		gerarTelaResultado();
		Filtros filtros = new Filtros();
		dadosImagemResultado = dadosImagemOriginal;
			//Media
		if (jComboBoxFiltros.getSelectedItem().equals("Media")){
			filtros.setFiltro("media");
			
			
		}
			//Mediana
		else if (jComboBoxFiltros.getSelectedItem().equals("Mediana")){
			filtros.setFiltro("mediana");
		}
		
		//Realce
		else if (jComboBoxFiltros.getSelectedItem().equals("Realce")){
			//Alto Reforço
			if (jComboBoxRealce.getSelectedItem().equals("Alto Reforço")){
				try {
					fator = Double.parseDouble(jTextFieldFator.getText());
					filtros.setFiltro("alto reforco", fator);
				} catch (Exception e) {
				}
				
			}
			
			//Passa Alta
			else if (jComboBoxRealce.getSelectedItem().equals("Passa Alta Básico")){
				filtros.setFiltro("passa alta basico");
			}
			
			//Sobel
			else if (jComboBoxRealce.getSelectedItem().equals("Sobel")){
				if (jComboBoxSobel.getSelectedItem().equals("Sobel em X")){
					filtros.setFiltro("sobel x");
					
				}
				else if (jComboBoxSobel.getSelectedItem().equals("Sobel em Y")){
					filtros.setFiltro("sobel y");
				}
				else if (jComboBoxSobel.getSelectedItem().equals("Sobel Magnitude")){
					filtros.setFiltro("sobel magnitude");
					
				}
			}
			
			//Prewitt
			else if (jComboBoxRealce.getSelectedItem().equals("Prewitt")){
				if (jComboBoxPrewitt.getSelectedItem().equals("Prewitt em X")){
					filtros.setFiltro("prewitt x");
				}
				else if (jComboBoxPrewitt.getSelectedItem().equals("Prewitt em Y")){
					filtros.setFiltro("prewitt y");
				}
				else if (jComboBoxPrewitt.getSelectedItem().equals("Prewitt Magnitude")){
					filtros.setFiltro("prewitt magnitude");
				}
			}
			
			//Roberts
			else if (jComboBoxRealce.getSelectedItem().equals("Roberts")){
				if (jComboBoxRoberts.getSelectedItem().equals("Roberts em X")){
					filtros.setFiltro("roberts x");
				}
				else if (jComboBoxRoberts.getSelectedItem().equals("Roberts em Y")){
					filtros.setFiltro("roberts y");
				}
				else if (jComboBoxRoberts.getSelectedItem().equals("Roberts Magnitude")){
					filtros.setFiltro("roberts magnitude");
				}
			}
			
			//Roberts Cruzado
			else if (jComboBoxRealce.getSelectedItem().equals("Roberts Cruzado")){
				if (jComboBoxRobertsCruzado.getSelectedItem().equals("Roberts Cruzado em X")){
					filtros.setFiltro("roberts cruzado x");
				}
				else if (jComboBoxRobertsCruzado.getSelectedItem().equals("Roberts Cruzado em Y")){
					filtros.setFiltro("roberts cruzado y");
				}
				else if (jComboBoxRobertsCruzado.getSelectedItem().equals("Roberts Cruzado Magnitude")){
					filtros.setFiltro("roberts cruzado magnitude");
				}
			}
			
		}
		
		retornarImagem(telaDePinturaResultado, dadosImagemResultado);
	}
	
	/**
	 * Método para o tratamento de eventos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent evento) {
		String select;
		
		//Evento do ComboBox de Filtros
		if (evento.getSource() == jComboBoxFiltros){
	
			select = (String)jComboBoxFiltros.getSelectedItem();
			if (select.equals("Media")){
				desativaTodasComponentes();
				carregaImagem("img//lenag.pgm");
				imagem = "img//lenag.pgm";
				setMatrizOperador("media");
				
				//Esconde componentes
				jLabelImgRealce.setVisible(false);
				jComboBoxImagem.setVisible(false);
				jComboBoxRealce.setVisible(false);
				jLabelRealce.setVisible(false);
			}
			else if (select.equals("Mediana")){
				desativaTodasComponentes();
				carregaImagem("img//lenasalp.pgm");
				imagem = "img//lenasalp.pgm";
				setMatrizOperador("mediana");
				
				//Esconde componentes
				jLabelImgRealce.setVisible(false);
				jComboBoxImagem.setVisible(false);
				jComboBoxRealce.setVisible(false);
				jLabelRealce.setVisible(false);
			}
			else if (select.equals("Realce")){
				jComboBoxImagem.setSelectedIndex(0);
				setMatrizOperador("realce");
				//Ativa componentes de realce
				jLabelRealce.setVisible(true);
				jComboBoxRealce.setVisible(true);
				jLabelImgRealce.setVisible(true);
				jComboBoxImagem.setVisible(true);
			}
		}
		
		//Evento do ComboBox de Realce
		else if (evento.getSource() == jComboBoxRealce){
			select = (String)jComboBoxRealce.getSelectedItem();
			desativaTodasComponentes();
			if (select.equals("Sobel")){
				ativaComponentes(jLabelOperacoes, jComboBoxSobel);
				setMatrizOperador("sobel");
			}
			else if (select.equals("Prewitt")){
				ativaComponentes(jLabelOperacoes, jComboBoxPrewitt);
				setMatrizOperador("prewitt");
			}
			else if (select.equals("Roberts")){
				ativaComponentes(jLabelOperacoes, jComboBoxRoberts);
				setMatrizOperador("roberts");
			}
			else if (select.equals("Roberts Cruzado")){
				ativaComponentes(jLabelOperacoes, jComboBoxRobertsCruzado);
				setMatrizOperador("roberts cruzado");
			}
			else if (select.equals("Alto Reforço")){
				ativaComponentes(jLabelFator, jTextFieldFator );
				setMatrizOperador("alto reforco");
			}
			else if (select.equals("Passa Alta Básico")){
				setMatrizOperador("passa alta");
			}
		
		}
		
		//Evento do ComboBox do Filtro de Prewitt
		else if (evento.getSource() == jComboBoxPrewitt){
			select = (String)jComboBoxPrewitt.getSelectedItem();
			if (select.equals("Prewitt em X")){
				setMatrizOperador("prewitt x");
			}
			
			else if (select.equals("Prewitt em Y")){
				setMatrizOperador("prewitt y");
			}
			
			else if (select.equals("Prewitt Magnitude")){
				setMatrizOperador("prewitt magnitude");
			}
		}
		//Evento do ComboBox do Filtro de Sobel
		else if (evento.getSource() == jComboBoxSobel){
			select = (String)jComboBoxSobel.getSelectedItem();
			if (select.equals("Sobel em X")){
				setMatrizOperador("sobel x");
			}
			
			else if (select.equals("Sobel em Y")){
				setMatrizOperador("sobel y");
			}
			
			else if (select.equals("Sobel Magnitude")){
				setMatrizOperador("sobel magnitude");
			}
		}
		
		//Evento do ComboBox do Filtro de Roberts
		else if (evento.getSource() == jComboBoxRoberts){
			select = (String)jComboBoxRoberts.getSelectedItem();
			if (select.equals("Roberts em X")){
				setMatrizOperador("roberts x");
			}
			
			else if (select.equals("Roberts em Y")){
				setMatrizOperador("roberts y");
			}
			
			else if (select.equals("Roberts Magnitude")){
				setMatrizOperador("roberts magnitude");
			}
		}
		
		//Evento do ComboBox do Filtro de Roberts Cruzado
		else if (evento.getSource() == jComboBoxRobertsCruzado){
			select = (String)jComboBoxRobertsCruzado.getSelectedItem();
			if (select.equals("Roberts Cruzado em X")){
				setMatrizOperador("roberts cruzado x");
			}
			
			else if (select.equals("Roberts Cruzado em Y")){
				setMatrizOperador("roberts cruzado y");
			}
			
			else if (select.equals("Roberts Cruzado Magnitude")){
				setMatrizOperador("roberts cruzado magnitude");
			}
		}
		
		//Evento do ComboBox de Imagens
		else if (evento.getSource() == jComboBoxImagem){
			select = (String)jComboBoxImagem.getSelectedItem();
			if (select.equals("lena.pgm")){
				carregaImagem("img//lena.pgm");
				imagem = "img//lena.pgm";
			}
			
			else if (select.equals("airplane.pgm")){
				carregaImagem("img//airplane.pgm");
				imagem = "img//airplane.pgm";
			}
		}
		
		
	}
	
	/**
	 * Ativa Componentes da Operação Selecionada
	 * @param label
	 * @param jTextField
	 */
	public void ativaComponentes(JLabel label, JComboBox<String> jComboBox){
		label.setVisible(true);
		jComboBox.setVisible(true);
	}
	
	/**
	 * Ativa Componentes da Operação Selecionada (Alto Reforço)
	 * @param label
	 * @param jTextField
	 */
	public void ativaComponentes(JLabel label, JTextField jTextField){
		label.setVisible(true);
		jTextField.setVisible(true);
	}
	
	/**
	 * Desativa Componentes da Operação Selecionada
	 * @param label
	 * @param jComboBox
	 */
	public void desativaComponentes(JLabel label, JComboBox<String> jComboBox){
		label.setVisible(false);
		jComboBox.setVisible(false);
	}
	
	/**
	 * Desativa Componentes da Operação Selecionada (Alto Reforço)
	 * @param label
	 * @param jTextField
	 */
	public void desativaComponentes(JLabel label, JTextField jTextField){
		label.setVisible(false);
		jTextField.setVisible(false);
	}
	
	/**
	 * Desativa todas as Componentes das Operações Sobel, Prewitt, Roberts, Roberts Cruzado e Alto Reforço
	 * @param label
	 * @param jTextField
	 */
	@SuppressWarnings("unchecked")
	public void desativaTodasComponentes(){
		desativaComponentes(jLabelOperacoes, jComboBoxSobel);
		desativaComponentes(jLabelOperacoes, jComboBoxPrewitt);
		desativaComponentes(jLabelOperacoes, jComboBoxRoberts);
		desativaComponentes(jLabelOperacoes, jComboBoxRobertsCruzado);
		desativaComponentes(jLabelFator, jTextFieldFator );
	}
	
	/**
	 * Modifica a Matriz de Operação no JTable
	 * @param operador
	 */
	public void setMatrizOperador(String operador){
		switch (operador) {
		case "media":
			editarCelulas("1/9", "1/9", "1/9", "1/9", "1/9", "1/9", "1/9", "1/9", "1/9");
			break;
		case "alto reforco":
			editarCelulas("-1", "-1", "-1", "-1", "W", "-1", "-1", "-1", "-1");
			break;
		case "passa alta":
			editarCelulas("-1", "-1", "-1", "-1", "8", "-1", "-1", "-1", "-1");
			break;
		case "sobel x":
			editarCelulas("-1", "-2", "-1", "0", "0", "0", "1", "2", "1");
			break;
		case "sobel y":
			editarCelulas("-1", "0", "1", "-2", "0", "2", "-1", "0", "1");
			break;
		case "sobel magnitude":
			editarCelulas("-2", "-2", "0", "-2", "0", "2", "0", "2", "2");
			break;
		case "prewitt x":
			editarCelulas("-1", "-1", "-1", "0", "0", "0", "1", "1", "1");
			break;
		case "prewitt y":
			editarCelulas("-1", "0", "1", "-1", "0", "1", "-1", "0", "1");
			break;	
		case "prewitt magnitude":
			editarCelulas("-2", "-1", "0", "-1", "0", "1", "0", "1", "2");
			break;
		case "roberts x":
			editarCelulas("0", "0", "0", "0", "1", "0", "0", "-1", "0");
			break;
		case "roberts y":
			editarCelulas("0", "0", "0", "0", "1", "-1", "0", "0", "0");
			break;
		case "roberts magnitude":
			editarCelulas("0", "0", "0", "0", "2" , "-1", "0", "-1", "0");
			break;
		case "roberts cruzado x":
			editarCelulas("0", "0", "0", "0", "1", "0", "0", "0", "-1");
			break;
		case "roberts cruzado y":
			editarCelulas("0", "0", "0", "0", "0", "1", "0", "-1", "0");
			break;
		case "roberts cruzado magnitude":
			editarCelulas("0", "0", "0", "0", "1" , "1", "0", "-1", "-1");
			break;
		default:
			editarCelulas("?", "?", "?", "?", "?", "?", "?", "?", "?");
			break;
		}
	}
	
	/**
	 * Edita os campos do JTable do Operador
	 * @param a11
	 * @param a12
	 * @param a13
	 * @param a21
	 * @param a22
	 * @param a23
	 * @param a31
	 * @param a32
	 * @param a33
	 */
	public void editarCelulas(String a11, String a12, String a13, String a21, String a22, String a23, String a31, String a32, String a33){
		jTableOperador.setValueAt(a11, 0, 0);
		jTableOperador.setValueAt(a12, 0, 1);
		jTableOperador.setValueAt(a13, 0, 2);
		jTableOperador.setValueAt(a21, 1, 0);
		jTableOperador.setValueAt(a22, 1, 1);
		jTableOperador.setValueAt(a23, 1, 2);
		jTableOperador.setValueAt(a31, 2, 0);
		jTableOperador.setValueAt(a32, 2, 1);
		jTableOperador.setValueAt(a33, 2, 2);
	}
	
	/**
	 * Reseta as transformações realizadas
	 * @param evt
	 */
	private void jButtonResetarActionPerformed(ActionEvent evt) {
		carregaImagem(imagem);
		jPanelImagemResultado.removeAll();
	}

	/**
	 * Propriedade para alinhar texto no JTable
	 */
	@SuppressWarnings("serial")
	class CenterRenderer extends DefaultTableCellRenderer {  
		 public CenterRenderer() {  
		 setHorizontalAlignment(CENTER);  
	
		 }  
	}  
	
}
