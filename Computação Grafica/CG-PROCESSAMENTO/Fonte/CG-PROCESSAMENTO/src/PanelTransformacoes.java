

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
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
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PanelTransformacoes extends javax.swing.JPanel implements ActionListener {
	private JLabel jLabelImagemInit;
	private JPanel jPanelImagemInicial;
	private JPanel jPanelImagemResultado;
	private BufferedImage telaDePintura;
	private ImageIcon imageIcon, imageIconResultado;
	private JLabel labelImage, labelImageResultado;
	public static ArrayList<Integer> dadosImagemResultado, dadosImagemOriginal = new ArrayList<>();
	private JLabel jLabelTransformacoes;
	private JTextField jTextFieldFator;
	private JLabel jLabelImagemFinal;
	public static int largura = 256;
	public static int altura = 256;
	private BufferedImage telaDePinturaResultado;
	private JSlider jSliderLevel;
	private JComboBox jComboBoxTransformacoes;
	private JLabel jLabelImagens;
	private JComboBox jComboBoxImagem;
	private Graphics graphics;
	private Transformacoes transformacoes = new Transformacoes();
	

	
	public PanelTransformacoes() {
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
				jLabelTransformacoes = new JLabel();
				this.add(jLabelTransformacoes);
				jLabelTransformacoes.setText("Transformação:");
				jLabelTransformacoes.setBounds(359, 141, 110, 16);
				jLabelTransformacoes.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jLabelImagemFinal = new JLabel();
				this.add(jLabelImagemFinal);
				jLabelImagemFinal.setText("Imagem Final");
				jLabelImagemFinal.setBounds(689, 42, 90, 16);
				jLabelImagemFinal.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				ComboBoxModel jComboBoxImagemModel = 
						new DefaultComboBoxModel(
								new String[] {"", "lena.pgm", "airplane.pgm" });
				jComboBoxImagem = new JComboBox();
				this.add(jComboBoxImagem);
				jComboBoxImagem.setModel(jComboBoxImagemModel);
				jComboBoxImagem.setBounds(359, 95, 170, 20);
			}
			{
				jLabelImagens = new JLabel();
				this.add(jLabelImagens);
				jLabelImagens.setText("Imagem:");
				jLabelImagens.setBounds(359, 73, 65, 16);
				jLabelImagens.setFont(new java.awt.Font("Segoe UI",1,12));
			}

			{
				jTextFieldFator = new JTextField();
				this.add(jTextFieldFator);
				jTextFieldFator.setBounds(440, 187, 30, 20);
				jTextFieldFator.setVisible(false);
			}
			{
				ComboBoxModel jComboBoxTransformacoesModel = 
						new DefaultComboBoxModel(
								new String[] { "", "Negativo", "Gamma", "Logaritmo" });
				jComboBoxTransformacoes = new JComboBox();
				this.add(jComboBoxTransformacoes);
				jComboBoxTransformacoes.setModel(jComboBoxTransformacoesModel);
				jComboBoxTransformacoes.setBounds(359, 163, 170, 20);
			}
			{
				jSliderLevel = new JSlider(JSlider.HORIZONTAL, 0, 20, 10);
				this.add(jSliderLevel);
				jSliderLevel.setBounds(349, 195, 190, 43);
				jSliderLevel.setBackground(new java.awt.Color(255,255,255));
				jSliderLevel.setMajorTickSpacing(5);
				jSliderLevel.setMinorTickSpacing(1);
				jSliderLevel.setPaintTicks(true);
				jSliderLevel.setVisible(false);
				jSliderLevel.setPaintLabels(true);
				Hashtable<Integer, JLabel> table = new Hashtable<>();
				table.put (0, new JLabel("0"));
				table.put (5, new JLabel("0.5"));
				table.put (10, new JLabel("1.0"));
				table.put (15, new JLabel("1.5"));
				table.put (20, new JLabel("2.0"));
				jSliderLevel.setLabelTable(table);
				jSliderLevel.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent evt) {
						jSliderLevelStateChanged(evt);
					}
				});

			}
			{
				jComboBoxImagem.addActionListener(this);
				jComboBoxTransformacoes.addActionListener(this);
			
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
	 * Método para o tratamento de eventos
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == jComboBoxImagem) {
			if (jComboBoxImagem.getSelectedItem().equals("lena.pgm")) {
				carregaImagem("img/lena.pgm");
				jComboBoxTransformacoes.setSelectedIndex(0);
				jSliderLevel.setValue(10);
				jSliderLevel.setVisible(false);
			}
			else if (jComboBoxImagem.getSelectedItem().equals("airplane.pgm")) {
				carregaImagem("img/airplane.pgm");
				jComboBoxTransformacoes.setSelectedIndex(0);
				jSliderLevel.setValue(10);
				jSliderLevel.setVisible(false);
			} 
		}
		
		else if (evento.getSource() == jComboBoxTransformacoes) {
			
			if (jComboBoxTransformacoes.getSelectedItem().equals("Negativo")) {	
				jSliderLevel.setValue(10);
				jSliderLevel.setVisible(false);
				gerarTelaResultado();
				retornarImagem(telaDePinturaResultado, transformacoes.transformacaoNegativo(dadosImagemOriginal));
				
			}
			
			else if (jComboBoxTransformacoes.getSelectedItem().equals("Gamma")) {
				gerarTelaResultado();
				retornarImagem(telaDePinturaResultado, transformacoes.transformacaoGamma(dadosImagemOriginal, 1.0));
				jSliderLevel.setVisible(true);
			}
			
			else if (jComboBoxTransformacoes.getSelectedItem().equals("Logaritmo")) {
				jSliderLevel.setValue(10);
				jSliderLevel.setVisible(false);
				gerarTelaResultado();
				retornarImagem(telaDePinturaResultado, transformacoes.transformacaoLogaritmica(dadosImagemOriginal));
				updateUI();
			}
		}
		
	}
	
	/**
	 * Evento para JSlide da operação Gamma o qual alteram-se os valores do
	 * fator Y
	 * @param evt
	 */
	private void jSliderLevelStateChanged(ChangeEvent evt) {
		double valorY = jSliderLevel.getValue()/10.0;
		gerarTelaResultado();
		retornarImagem(telaDePinturaResultado, transformacoes.transformacaoGamma(dadosImagemOriginal, valorY));
		
	}

}
