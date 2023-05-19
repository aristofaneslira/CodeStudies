

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class PanelOperadores extends javax.swing.JPanel implements ActionListener {
	private JLabel jLabelImagemA;
	private JPanel jPanelImagemA;
	private JPanel jPanelImagemB;
	private BufferedImage telaDePinturaA;
	private BufferedImage telaDePinturaB;
	private BufferedImage teladePinturaResultado;
	private ImageIcon imageIconA, imageIconB, imageIconResultado;
	private JLabel labelImageA, labelImageB, labelImageResultado;
	public static ArrayList<Integer> dadosImagemA = new ArrayList<>();
	public static ArrayList<Integer> dadosImagemB = new ArrayList<>();
	public static ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
	private JLabel jLabelImagemB;
	private JComboBox jComboBoxOperacao;
	private JLabel jLabelOperacao;
	private JLabel jLabelImagensB;
	private JLabel jLabelImagensA;
	private JLabel jLabelResultado;
	private JPanel jPanelResultado;
	public static int largura = 256;
	public static int altura = 256;
	private JComboBox jComboBoxImagemA;
	private JComboBox jComboBoxImagemB;
	private Operadores operadores = new Operadores();
	
	
	public PanelOperadores() {
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
				jLabelImagemA = new JLabel();
				this.add(jLabelImagemA);
				jLabelImagemA.setText("Imagem A");
				jLabelImagemA.setBounds(127, 41, 90, 16);
				jLabelImagemA.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jPanelImagemA = new JPanel();
				CardLayout jPanelImagemInicialLayout = new CardLayout();
				this.add(jPanelImagemA);
				jPanelImagemA.setBounds(30, 63, 258, 258);
				jPanelImagemA.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelImagemA.setLayout(jPanelImagemInicialLayout);
			}
			{
				jPanelImagemB = new JPanel();
				CardLayout jPanelImagemResultadoLayout = new CardLayout();
				this.add(jPanelImagemB);
				jPanelImagemB.setBounds(318, 63, 258, 258);
				jPanelImagemB.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelImagemB.setLayout(jPanelImagemResultadoLayout);
				
			}

			{
				jLabelImagemB = new JLabel();
				this.add(jLabelImagemB);
				jLabelImagemB.setText("Imagem B");
				jLabelImagemB.setBounds(417, 42, 90, 16);
				jLabelImagemB.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				ComboBoxModel jComboBoxImagemModelA = 
						new DefaultComboBoxModel(
								new String[] {"", "lena.pgm", "airplane.pgm" });
				jComboBoxImagemA = new JComboBox();
				this.add(jComboBoxImagemA);
				jComboBoxImagemA.setModel(jComboBoxImagemModelA);
				jComboBoxImagemA.setBounds(76, 360, 170, 20);

			}
			{
				ComboBoxModel jComboBoxImagemModelB = 
						new DefaultComboBoxModel(
								new String[] {"", "lena.pgm", "airplane.pgm" });
				jComboBoxImagemB = new JComboBox();
				this.add(jComboBoxImagemB);
				jComboBoxImagemB.setModel(jComboBoxImagemModelB);
				jComboBoxImagemB.setBounds(361, 360, 170, 20);

			}
			{
				jPanelResultado = new JPanel();
				this.add(jPanelResultado);
				jPanelResultado.setLayout(null);
				jPanelResultado.setBounds(606, 63, 258, 258);
				jPanelResultado.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				jLabelResultado = new JLabel();
				this.add(jLabelResultado);
				jLabelResultado.setText("Imagem Final");
				jLabelResultado.setBounds(700, 42, 96, 16);
				jLabelResultado.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jLabelImagensA = new JLabel();
				this.add(jLabelImagensA);
				jLabelImagensA.setText("Imagem:");
				jLabelImagensA.setBounds(79, 341, 68, 16);
			}
			{
				jLabelImagensB = new JLabel();
				this.add(jLabelImagensB);
				jLabelImagensB.setText("Imagem:");
				jLabelImagensB.setBounds(364, 341, 71, 16);
			}
			{
				jLabelOperacao = new JLabel();
				this.add(jLabelOperacao);
				jLabelOperacao.setText("Operação:");
				jLabelOperacao.setBounds(652, 341, 77, 16);
			}
			{
				ComboBoxModel jComboBoxOperacaoModel = 
						new DefaultComboBoxModel(
								new String[] { "","Adição", "Subtração", "Multiplicação", "Divisão", "AND Lógico", "OR Lógico", "XOR Lógico" });
				jComboBoxOperacao = new JComboBox();
				this.add(jComboBoxOperacao);
				jComboBoxOperacao.setModel(jComboBoxOperacaoModel);
				jComboBoxOperacao.setBounds(649, 360, 170, 20);
			}
			{
				jComboBoxImagemA.addActionListener(this);
				jComboBoxImagemB.addActionListener(this);
				jComboBoxOperacao.addActionListener(this);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Carrega o arquivo de Imagem PGM (cujo caminho foi recebido)e 
	 * copia os pixels para o ArrayList recebido.
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
	 * Cria tela de desenho para a imagem resultado de acordo com o tamanho das imagens 
	 * carregadas inicialmente
	 */
	public void gerarTelaResultado(){
		jPanelResultado.removeAll();
		teladePinturaResultado = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		imageIconResultado = new ImageIcon(teladePinturaResultado);
		labelImageResultado = new JLabel(imageIconResultado);
		labelImageResultado.setLayout(null);
		jPanelResultado.add(labelImageResultado);
		labelImageResultado.setBounds(1, 1, largura, altura);
		jPanelResultado.add(labelImageResultado, "labelImageResultado");
		labelImageResultado.setPreferredSize(new java.awt.Dimension(256, 256));
		updateUI();
		
	}
	
	/**
	 * Cria tela de desenho para a imagem A de acordo com o tamanho da imagem
	 * e em seguida pinta a imagem carregada.
	 * @param caminhoImagem
	 */
	public void carregaImagemA(String caminhoImagem) {
		
		
		try {
			
			lerPixelsImagem(dadosImagemA, caminhoImagem);
			jPanelImagemA.removeAll();
			telaDePinturaA = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			imageIconA = new ImageIcon(telaDePinturaA);
			labelImageA = new JLabel(imageIconA);
			jPanelImagemA.add(labelImageA);
			labelImageA.setBounds(1, 1, largura, altura);
			jPanelImagemA.add(labelImageA, "labelImage");
			
			
			retornarImagem(telaDePinturaA, dadosImagemA);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Caminho inválido ou nulo!");
		}
		
	}
	
	/**
	 * Cria tela de desenho para a imagem B de acordo com o tamanho da imagem
	 * e em seguida pinta a imagem carregada.
	 * @param caminhoImagem
	 */
	public void carregaImagemB(String caminhoImagem) {
		
		
		try {
			
			lerPixelsImagem(dadosImagemB, caminhoImagem);
			jPanelImagemB.removeAll();
			telaDePinturaB = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			imageIconB = new ImageIcon(telaDePinturaB);
			labelImageB = new JLabel(imageIconB);
			jPanelImagemB.add(labelImageB);
			labelImageB.setBounds(1, 1, largura, altura);
			jPanelImagemB.add(labelImageB, "labelImage");
			
			
			retornarImagem(telaDePinturaB, dadosImagemB);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Caminho inválido ou nulo!");
			
		}
		
	}
	
	
	/**
	 * Método para o tratamento de eventos
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		//Evento do ComboBox da Imagem A
		if (evento.getSource() == jComboBoxImagemA){
			if(jComboBoxImagemA.getSelectedItem().equals("lena.pgm")){
				carregaImagemA("img//lena.pgm");
			
			}
			else if(jComboBoxImagemA.getSelectedItem().equals("airplane.pgm")){
				carregaImagemA("img//airplane.pgm");
			}
		}
		
		//Evento do ComboBox da Imagem B
		else if (evento.getSource() == jComboBoxImagemB){
			if(jComboBoxImagemB.getSelectedItem().equals("lena.pgm")){
				carregaImagemB("img//lena.pgm");
			
			}
			else if(jComboBoxImagemB.getSelectedItem().equals("airplane.pgm")){
				carregaImagemB("img//airplane.pgm");
			}
		}
		
		//Evento do ComboBox das Operações
		else if (evento.getSource() == jComboBoxOperacao){
			try {
				
				if (jComboBoxOperacao.getSelectedItem().equals("Adição")){
					operadores.processar("operador_adicao",dadosImagemA, dadosImagemB, dadosImagemResultado);
				}
			
				else if (jComboBoxOperacao.getSelectedItem().equals("Subtração")){
					operadores.processar("operador_subtracao",dadosImagemA, dadosImagemB, dadosImagemResultado);
				}
			
				else if (jComboBoxOperacao.getSelectedItem().equals("Divisão")){
					operadores.processar("operador_divisao",dadosImagemA, dadosImagemB, dadosImagemResultado);
				}
			
				else if (jComboBoxOperacao.getSelectedItem().equals("Multiplicação")){
					operadores.processar("operador_multiplicacao",dadosImagemA, dadosImagemB, dadosImagemResultado);
				}
			
				else if (jComboBoxOperacao.getSelectedItem().equals("XOR Lógico")){
					operadores.processar("operador_logico_xor",dadosImagemA, dadosImagemB, dadosImagemResultado);
				}
			
				else if (jComboBoxOperacao.getSelectedItem().equals("OR Lógico")){
					operadores.processar("operador_logico_or",dadosImagemA, dadosImagemB, dadosImagemResultado);
				}
			
				else if (jComboBoxOperacao.getSelectedItem().equals("AND Lógico")){
					operadores.processar("operador_logico_and",dadosImagemA, dadosImagemB, dadosImagemResultado);
				}
					gerarTelaResultado();
					retornarImagem(teladePinturaResultado, dadosImagemResultado);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Selecione as Imagens!");
			}
		}
	

	}
	
}
