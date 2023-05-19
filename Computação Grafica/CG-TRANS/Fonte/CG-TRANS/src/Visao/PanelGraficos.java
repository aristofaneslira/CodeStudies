package Visao;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import Grafico.CorRGB;
import Grafico.DadosGrafico;
import Grafico.GraficoBarra;
import Grafico.GraficoColuna;
import Grafico.GraficoPizza;




@SuppressWarnings({"serial", "rawtypes"})
public class PanelGraficos extends javax.swing.JPanel {
	private JPanel jPanelMenuLateral;
	private JLabel jLabelValorDado;
	private JLabel jLabelNomeDado;
	private JLabel jLabelCoordenadas;
	private JSeparator jSeparator1;
	private JLabel jLabelGraficos;
	private DefaultTableModel model;
	private JLabel jLabelTipoGrafico;
	private JComboBox jComboBoxGrafico;
	private JTextField jTextFieldNomeDado;
	private JTable jTableDados;
	private JPanel jPanelDesenho;
	private JTextField jTextFieldValorDado;
	private JButton jButtonAdicionar;
	private JSeparator jSeparator3;
	private JSeparator jSeparator2;
	private JLabel labelDesenho;
	private ImageIcon iconDesenho;
	private BufferedImage bi;
	private Graphics graphics;
	private JScrollPane jScrollPane;
	private JButton jButtonLimpar;
	private JButton jButtonDesenhar;
	private ArrayList<Integer> dados = new ArrayList<>();
	private ArrayList<String> nomeDado = new ArrayList<>();
	private ArrayList<Double> porcentagem = new ArrayList<>();
	private JPanel jPanelLegenda;
	private JLabel jLabelNomeGráfico;
	private DadosGrafico dadosGrafico;
	private GraficoColuna graficoColuna;
	private GraficoBarra graficoBarra;
	private ArrayList<DadosGrafico> dataGrafico = new ArrayList<>();
	private GraficoPizza graficoPizza;

	public PanelGraficos() {
		super();
		initGUI();
	}
	
	/**
	 * Construtor
	 */
	@SuppressWarnings("unchecked")
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(880, 610));
			this.setBackground(new java.awt.Color(192,192,192));
			this.setLayout(null);
			{
							
				jPanelMenuLateral = new JPanel();
				this.add(jPanelMenuLateral);
				jPanelMenuLateral.setBounds(4, 5, 273, 602);
				jPanelMenuLateral.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelMenuLateral.setBackground(new java.awt.Color(255,255,255));
				jPanelMenuLateral.setLayout(null);
				{
					jLabelCoordenadas = new JLabel();
					jPanelMenuLateral.add(jLabelCoordenadas);
					jLabelCoordenadas.setText("Dados");
					jLabelCoordenadas.setBounds(13, 47, 119, 14);
					jLabelCoordenadas.setFont(new java.awt.Font("Tahoma",1,12));
				}
				{
					jLabelNomeDado = new JLabel();
					jPanelMenuLateral.add(jLabelNomeDado);
					jLabelNomeDado.setText("Nome:");
					jLabelNomeDado.setBounds(40, 82, 42, 16);
					jLabelNomeDado.setFont(new java.awt.Font("Segoe UI",1,11));
				}
				{
					jLabelValorDado = new JLabel();
					jPanelMenuLateral.add(jLabelValorDado);
					jLabelValorDado.setText("Valor:");
					jLabelValorDado.setFont(new java.awt.Font("Segoe UI",1,11));
					jLabelValorDado.setBounds(146, 82, 38, 16);
				}
				{
					jLabelGraficos = new JLabel();
					jPanelMenuLateral.add(jLabelGraficos);
					jLabelGraficos.setText("Gráficos");
					jLabelGraficos.setBounds(109, 14, 64, 20);
					jLabelGraficos.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					jSeparator1 = new JSeparator();
					jPanelMenuLateral.add(jSeparator1);
					jSeparator1.setBounds(9, 36, 256, 6);
				}

				{
					jSeparator2 = new JSeparator();
					jPanelMenuLateral.add(jSeparator2);
					jSeparator2.setBounds(9, 36, 256, 6);
				}
				{
					jSeparator3 = new JSeparator();
					jPanelMenuLateral.add(jSeparator3);
					jSeparator3.setBounds(9, 167, 256, 12);
				}
				{
					jButtonAdicionar = new JButton();
					jPanelMenuLateral.add(jButtonAdicionar);
					jButtonAdicionar.setText("Adicionar");
					jButtonAdicionar.setBounds(95, 132, 78, 20);
					jButtonAdicionar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonAdicionarActionPerformed(evt);
						}
					});
				}
				{
					jTextFieldNomeDado = new JTextField();
					jPanelMenuLateral.add(jTextFieldNomeDado);
					jTextFieldNomeDado.setBounds(80, 81, 47, 20);
				}
				{
					jTextFieldValorDado = new JTextField();
					jPanelMenuLateral.add(jTextFieldValorDado);
					jTextFieldValorDado.setBounds(182, 81, 47, 20);
				}
				{
					String[] colunas =  {"Nome", "Dados", "%"};	
					String[][] dados = {};
					model = new DefaultTableModel(dados, colunas); 
					jTableDados = new JTable(model);
					jTableDados.setBounds(73, 200, 142, 112);
					jTableDados.setLayout(null);
					jTableDados.setFillsViewportHeight(true);
					jPanelMenuLateral.add(jTableDados);
					jTableDados.setBounds(60, 191, 154, 103);
					jTableDados.setEnabled(false);
				}
				{
					{
						jScrollPane = new JScrollPane(jTableDados);
						jScrollPane.setBackground(new java.awt.Color(255,255,255));
						jPanelMenuLateral.add(jScrollPane);
						jScrollPane.setBounds(44, 191, 182, 120);
					}
					{
						jButtonDesenhar = new JButton();
						jPanelMenuLateral.add(jButtonDesenhar);
						jButtonDesenhar.setText("Desenhar");
						jButtonDesenhar.setBounds(53, 389, 78, 20);
						jButtonDesenhar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonDesenharActionPerformed(evt);
							}
						});
					}
					{
						jButtonLimpar = new JButton();
						jPanelMenuLateral.add(jButtonLimpar);
						jButtonLimpar.setText("Limpar");
						jButtonLimpar.setBounds(133, 389, 78, 20);
						jButtonLimpar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonLimparActionPerformed(evt);
							}
						});
					}
					{
						ComboBoxModel jComboBoxGraficoModel = 
								new DefaultComboBoxModel(
										new String[] { "", "Colunas", "Barras", "Pizza" });
						jComboBoxGrafico = new JComboBox();
						jPanelMenuLateral.add(jComboBoxGrafico);
						jComboBoxGrafico.setModel(jComboBoxGraficoModel);
						jComboBoxGrafico.setBounds(47, 341, 172, 20);
						jComboBoxGrafico.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jComboBoxGraficoActionPerformed(evt);
							}
						});
					}
					{
						jLabelTipoGrafico = new JLabel();
						jPanelMenuLateral.add(jLabelTipoGrafico);
						jLabelTipoGrafico.setText("Gráfico:");
						jLabelTipoGrafico.setBounds(47, 323, 48, 16);
					}
				}
			}
			{
				//adicionando tela de desenho
				jPanelDesenho = new JPanel();
				this.add(jPanelDesenho);
				jPanelDesenho.setBounds(280, 5, 600, 602);
				jPanelDesenho.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelDesenho.setLayout(null);
				jPanelDesenho.setBackground(new java.awt.Color(255,255,255));
				
			}
			{	
				//adicionando tela de legenda
				jPanelLegenda = new JPanel();
				FlowLayout jPanelLegendaLayout = new FlowLayout();
				jPanelDesenho.add(jPanelLegenda);
				jPanelLegenda.setBounds(50, 456, 500, 133);
				jPanelLegenda.setBackground(new java.awt.Color(255,255,255));
				jPanelLegenda.setBorder(BorderFactory.createTitledBorder("Legenda"));
				jPanelLegenda.setLayout(jPanelLegendaLayout);
				jPanelLegenda.setVisible(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Retorna a soma de todos os dados para o calculo da porcentagem
	 * @return
	 */
	public double somaDados(){
		int total = 0;
		for (Integer dado : dados) {
			total += dado;
		}
		return total;
	}
	
	/**
	 * Limpa as linhas da JTable de dados
	 */
	public void clearRows(){
		model = (DefaultTableModel)jTableDados.getModel();  
		int count = model.getRowCount();
		 
		 for (int i=0; i < count; i++){
			 model.removeRow(0);
		 }
	}

	public void desenharTelaColunas(){
		//definindo janela de desenho de Colunas
		bi = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
		iconDesenho = new ImageIcon(bi);
		labelDesenho = new JLabel(iconDesenho);
		jPanelDesenho.add(labelDesenho);
		labelDesenho.setPreferredSize(new java.awt.Dimension(400, 400));
		labelDesenho.setBounds(50, 50, 500, 400);
		labelDesenho.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		{
			jLabelNomeGráfico = new JLabel();
			jPanelDesenho.add(jLabelNomeGráfico);
			jLabelNomeGráfico.setText("Gráfico de Colunas");
			jLabelNomeGráfico.setBounds(243, 29, 134, 16);
			jLabelNomeGráfico.setFont(new java.awt.Font("Segoe UI",1,12));
		}

		//pintando tela de desenho
		graphics = bi.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 500, 400);
		graphics.setColor(Color.BLACK);
		//pintando eixos X Y
		graphics.drawLine(60, 340, 470, 340);
		graphics.drawLine(60, 340, 60, 40);
		
		//desenhando marcas
		graphics.drawLine(56,40,60,40); //100%
		graphics.drawLine(56, 115, 60, 115); //75%
		graphics.drawLine(56, 190, 60, 190); //50%
		graphics.drawLine(56, 265, 60, 265); //25%
		graphics.drawLine(56, 340, 60, 340);//0%
		
		//desenhando porcentagens
		graphics.drawString("100%", 20, 43);
		graphics.drawString("75%", 27, 118);
		graphics.drawString("50%", 27, 193);
		graphics.drawString("25%", 27, 268);
		graphics.drawString("0%", 34, 341);
		
		//desativando panel de legendas
		jPanelLegenda.setVisible(false);
	}
	
	public void desenharTelaBarras(){
		//definindo janela de desenho de Colunas
		bi = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
		iconDesenho = new ImageIcon(bi);
		labelDesenho = new JLabel(iconDesenho);
		jPanelDesenho.add(labelDesenho);
		labelDesenho.setPreferredSize(new java.awt.Dimension(400, 400));
		labelDesenho.setBounds(50, 50, 500, 400);
		labelDesenho.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		{
			jLabelNomeGráfico = new JLabel();
			jPanelDesenho.add(jLabelNomeGráfico);
			jLabelNomeGráfico.setText("Gráfico de Barras");
			jLabelNomeGráfico.setBounds(243, 29, 134, 16);
			jLabelNomeGráfico.setFont(new java.awt.Font("Segoe UI",1,12));
		}

		//pintando tela de desenho
		graphics = bi.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 500, 400);
		graphics.setColor(Color.BLACK);
		//pintando eixos X Y
		graphics.drawLine(60, 340, 360, 340);
		graphics.drawLine(60, 340, 60, 40);
			
		//desenhando marcas
		graphics.drawLine(360, 340, 360, 344); //100%
		graphics.drawLine(285, 340, 285, 344); //75%
		graphics.drawLine(210, 340, 210, 344); //50%
		graphics.drawLine(135, 340, 135, 344); //25%
		graphics.drawLine(60, 340, 60, 344);//0%
				
		//desenhando porcentagens
		graphics.drawString("100%", 351, 360);
		graphics.drawString("75%", 281, 360);
		graphics.drawString("50%", 206, 360);
		graphics.drawString("25%", 131, 360);
		graphics.drawString("0%", 56, 360);
		
		//desativando panel de legendas
		jPanelLegenda.setVisible(false);
	}
	
	public void desenharTelaPizza(){
		{
			//definindo janela de desenho de Colunas
			bi = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
			iconDesenho = new ImageIcon(bi);
			labelDesenho = new JLabel(iconDesenho);
			jPanelDesenho.add(labelDesenho);
			labelDesenho.setPreferredSize(new java.awt.Dimension(400, 400));
			labelDesenho.setBounds(50, 50, 500, 400);
			labelDesenho.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		}
		{
			jLabelNomeGráfico = new JLabel();
			jPanelDesenho.add(jLabelNomeGráfico);
			jLabelNomeGráfico.setText("Gráfico de Pizza");
			jLabelNomeGráfico.setBounds(243, 29, 134, 16);
			jLabelNomeGráfico.setFont(new java.awt.Font("Segoe UI",1,12));	
			
		}
		{
			//pintando tela de desenho
			graphics = bi.createGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, 500, 400);
			graphics.setColor(Color.BLACK);
		}

		{
			
			//adicionando tela de legenda
			jPanelLegenda = new JPanel();
			FlowLayout jPanelLegendaLayout = new FlowLayout();
			jPanelDesenho.add(jPanelLegenda);
			jPanelLegenda.setBounds(50, 456, 500, 133);
			jPanelLegenda.setBackground(new java.awt.Color(255,255,255));
			jPanelLegenda.setBorder(BorderFactory.createTitledBorder("Legenda"));
			jPanelLegenda.setLayout(jPanelLegendaLayout);
		
			
		}
	}
	/**
	 * Cria Label para representar a cor na legenda
	 * @return
	 */
	public JLabel createLabel(){
		JLabel label = new JLabel();
		return label;
	}
	
	/**
	 * Cria Label para representar o nome do dado na legenda
	 * @param nome
	 * @return
	 */
	public JLabel createLabel(String nome){
		JLabel labelNome = new JLabel(nome);
		return labelNome;
	}
	
	/**
	 * Cria Icone com a cor representante de cada dado e um Label com o nome
	 * do dado no painel de legendas
	 * @param cor
	 * @param label
	 * @param nome
	 */
	public void addLegenda(Color cor, JLabel label, JLabel nome){
		{
			//adiciona label do icone e de texto na janela de legendas
			jPanelLegenda.add(label);
			jPanelLegenda.add(nome);
			nome.setBounds(225, 20, 62, 16);
			label.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			label.setBounds(205, 23, 15, 11);
			label.setOpaque(true);
			label.setBackground(cor);
			label.setPreferredSize(new java.awt.Dimension(15, 13));

		}
	}
	
	/**
	 * Adiciona todas as legendas referente aos dados da tabela (ou gráfico)
	 * @param cores
	 */
	public void gerarLegendas(ArrayList<CorRGB> cores){
		//formata texto para assumir dois digitos após a virigula
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		Color cor;
		String nomeDoDado;
		for (int i = 0; i < cores.size(); i++) {
			cor = cores.get(i).getCor();
			nomeDoDado = nomeDado.get(i)+" ["+ df.format(porcentagem.get(i))+"%] ";
			
			addLegenda(cor, createLabel(), createLabel(nomeDoDado));
		}
	}
	
	/**
	 * Adiciona dados na JTable e recalcula as porcentagens
	 * @param evt
	 */
	private void jButtonAdicionarActionPerformed(ActionEvent evt) {
		//limpa JTable
		clearRows();
		//limpa lista de porcentagens
		porcentagem.clear();
		//recebe valor dos campos
		String nome = jTextFieldNomeDado.getText();
		int valor = Integer.parseInt(jTextFieldValorDado.getText());
		
		//associa valor dos campos a Arraylists
		dados.add(valor);
		nomeDado.add(nome);
		
		//atualizando valores na JTable com as novas porcentagens
		DecimalFormat df = new DecimalFormat("#,###.00"); //2 casas depois da virgula
		for (int i = 0; i < dados.size(); i++){
			String nameDado = nomeDado.get(i);
			double valorPorcentagem = (dados.get(i)/somaDados())*100;
			//adiciona nova porcentagem na lista
			porcentagem.add(valorPorcentagem);
			 // Obtem o modelo da JTable  
			 model = (DefaultTableModel)jTableDados.getModel();  
			 // Adiciona uma nova linha em branco no modelo  
			 model.addRow( new String [] {""+nameDado, ""+dados.get(i), ""+df.format(valorPorcentagem)} );  
		}
	}
	
	/**
	 * Desenha os dados adicionados na tabela no gráfico do tipo escolhido no
	 * combobox
	 * @param evt
	 */
	private void jButtonDesenharActionPerformed(ActionEvent evt) {
		dataGrafico.clear();
		
		//apaga tela de legenda
		jPanelLegenda.removeAll();
	
		//Desenhando gráfico de Colunas
		if (jComboBoxGrafico.getSelectedItem().equals("Colunas")) {
			for (int i = 0; i < dados.size(); i++) {
				dadosGrafico = new DadosGrafico(nomeDado.get(i), dados.get(i), porcentagem.get(i));
				dataGrafico.add(dadosGrafico);
			}
			
			graficoColuna = new GraficoColuna(dataGrafico);
			
			graficoColuna.desenharGrafico(this.bi);
			updateUI();
		}
		//Desenhando gráfico de Barras
		else if (jComboBoxGrafico.getSelectedItem().equals("Barras")) {
			for (int i = 0; i < dados.size(); i++) {
				dadosGrafico = new DadosGrafico(nomeDado.get(i), dados.get(i), porcentagem.get(i));
				dataGrafico.add(dadosGrafico);
			}
			
			graficoBarra = new GraficoBarra(dataGrafico);
			
			graficoBarra.desenharGrafico(this.bi);
			updateUI();
		}
		//Desenhado gráfico de Pizza
		else if (jComboBoxGrafico.getSelectedItem().equals("Pizza")) {
			for (int i = 0; i < dados.size(); i++) {
				dadosGrafico = new DadosGrafico(nomeDado.get(i), dados.get(i), porcentagem.get(i));
				dataGrafico.add(dadosGrafico);
			}
			
			graficoPizza = new GraficoPizza(dataGrafico, this);
			graficoPizza.desenharGrafico(this.bi);
			
			updateUI();
		}
	}
	
	/**
	 * Evento para desenhar a tabela apropriada de acordo com a escolha do
	 * combobox
	 * @param evt
	 */
	private void jComboBoxGraficoActionPerformed(ActionEvent evt) {
		jPanelDesenho.removeAll();
		updateUI();
		//desenhando tela do grafico de colunas
		if (jComboBoxGrafico.getSelectedItem().equals("Colunas")) {
			desenharTelaColunas();
		}
		//desenhando tela do grafico de barras
		else if (jComboBoxGrafico.getSelectedItem().equals("Barras")) {
			desenharTelaBarras();
		}
		//desenhando tela do grafico de pizza
		else if (jComboBoxGrafico.getSelectedItem().equals("Pizza")) {
			desenharTelaPizza();
			//ativando panel de legendas
			jPanelLegenda.setVisible(true);
			
		}
	}
	 
	/**
	 * Evento do botao limpar - limpa a tela de desenho e os dados
	 * @param evt
	 */
	 private void jButtonLimparActionPerformed(ActionEvent evt) {
		 //limpa JTable
		 clearRows();
		 //linha tela de desenho e legendas
		 jPanelDesenho.removeAll();
		 jPanelLegenda.removeAll();
		 //limpa arraylist de dados, porcentagem e nome dos dados
		 dados.clear();
		 porcentagem.clear();
		 nomeDado.clear();
		 //reseta combobox dos tipos de grafico
		 jComboBoxGrafico.setSelectedIndex(0);
		 //limpa campos de texto
		 jTextFieldNomeDado.setText("");
		 jTextFieldValorDado.setText("");
		 //atualiza a tela
		 updateUI();
	 }

}
