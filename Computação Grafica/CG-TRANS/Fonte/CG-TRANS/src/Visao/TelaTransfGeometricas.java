package Visao;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import Algoritmos.Vertice;
import Operadores.OperacaoCisalhamento;
import Operadores.OperacaoEscala;
import Operadores.OperacaoReflexao;
import Operadores.OperacaoReflexaoRetaYMXB;
import Operadores.OperacaoRotacao;
import Operadores.OperacaoTranslacao;
import Operadores.OperacoesMatriz;
import Operadores.Operador;


@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class TelaTransfGeometricas extends javax.swing.JPanel implements ActionListener{
	private JPanel jPanelMenuLateral;
	private TelaDesenho jPanelDesenho;
	private static JLabel coordX;
	private static JLabel coordY;
	private JButton jButtonEscolher;
	private JScrollPane jScrollPane;
	private JButton jButtonAplicar;
	private JScrollPane jScrollPaneTransf;
	private JLabel jLabelTransformacoes;
	private JComboBox jComboBoxOperacoes;
	private JTable jTableVertices;
	private JTable jTableTransformacoes;
	private JLabel jLabelOperacao;
	private JButton jButtonDesenhar;
	private JButton jButtonLimpar;
	private JSeparator jSeparator1;
	private JLabel jLabelDDA;
	private int CoordenadaX;
	private int CoordenadaY;
	private int Xinit = 300;
	private int Yinit = 300;
	private OperacoesMatriz OPMatriz = new OperacoesMatriz();
	private DefaultTableModel model;
	private DefaultTableModel modelTransformacoes;
	private JLabel jLabelVertice;
	private JButton jButtonAdd;
	private JButton jButtonRemover;
	private JSeparator jSeparator2;
	private JSeparator jSeparator3;
	private JPanel panelTrans;
	private FrameAddVertice addVertice = new FrameAddVertice();
	private FrameTranslacao addTranslacao = new FrameTranslacao();
	private FrameRotacao addRotacao = new FrameRotacao();
	private FrameEscala addEscala = new FrameEscala();
	private FrameCisalhamento addCisalhamento = new FrameCisalhamento();
	private FrameReflexao addReflexao = new FrameReflexao();
	private int incrementoPontoFixoX = 0;
	private int incrementoPontoFixoY = 0;
	private int pontoFixoX;
	private int pontoFixoY;
	private double m;
	private double b;


	/**
	 * Construtor da Janela TelaTransfGeometricas
	 */
	public TelaTransfGeometricas() {
		super();
		initGUI();
	}
	
	/**
	 * Sub-Construtor da Janela TelaTransfGeometricas (By Jigloo)
	 */
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
					coordX = new JLabel();
					jPanelMenuLateral.add(coordX);
					coordX.setBounds(180, 572, 40, 16);
					coordX.setForeground(new java.awt.Color(60,60,60));
					coordX.setFont(new java.awt.Font("Segoe UI",0,10));
					coordX.setText("X:");
				}
				{
					coordY = new JLabel();
					jPanelMenuLateral.add(coordY);
					coordY.setBounds(220, 572, 40, 16);
					coordY.setForeground(new java.awt.Color(60,60,60));
					coordY.setFont(new java.awt.Font("Segoe UI",0,10));
					coordY.setText("Y:");
				}
				{
					jLabelDDA = new JLabel();
					jPanelMenuLateral.add(jLabelDDA);
					jLabelDDA.setText("Transformações Geométricas - 2D");
					jLabelDDA.setBounds(31, 15, 227, 20);
					jLabelDDA.setFont(new java.awt.Font("Segoe UI",1,13));
				}
				{
					jSeparator1 = new JSeparator();
					jPanelMenuLateral.add(jSeparator1);
					jSeparator1.setBounds(9, 36, 256, 6);
				}
				{
					
					jSeparator2 = new JSeparator();
					jPanelMenuLateral.add(jSeparator2);
					jSeparator2.setBounds(9, 256, 256, 8);
					
				}
				{
					
					jSeparator3 = new JSeparator();
					jPanelMenuLateral.add(jSeparator3);
					jSeparator3.setBounds(9, 327, 256, 8);
					
				}
				{
					jButtonLimpar = new JButton();
					jPanelMenuLateral.add(jButtonLimpar);
					jButtonLimpar.setText("Limpar");
					jButtonLimpar.setBackground(new java.awt.Color(255,255,255));
					jButtonLimpar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonLimpar.setBounds(136, 220, 72, 17);
					jButtonLimpar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonLimparActionPerformed(evt);
						}
					});
				}
				{
					jButtonEscolher = new JButton();
					jPanelMenuLateral.add(jButtonEscolher);
					jButtonEscolher.setText("Escolher");
					jButtonEscolher.setBackground(new java.awt.Color(255,255,255));
					jButtonEscolher.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonEscolher.setBounds(100, 294, 72, 17);
					jButtonEscolher.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonEscolherActionPerformed(evt);
						}
					});
				}
				{
					jButtonDesenhar = new JButton();
					jPanelMenuLateral.add(jButtonDesenhar);
					jButtonDesenhar.setText("Desenhar");
					jButtonDesenhar.setBackground(new java.awt.Color(255,255,255));
					jButtonDesenhar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonDesenhar.setBounds(58, 220, 72, 17);
					jButtonDesenhar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							try {
								jButtonDesenharActionPerformed(evt);
							} catch (Exception e) {
							
							}
						}
					});
				}
				{
					jButtonRemover = new JButton();
					jPanelMenuLateral.add(jButtonRemover);
					jButtonRemover.setText("Remover");
					jButtonRemover.setBackground(new java.awt.Color(255,255,255));
					jButtonRemover.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonRemover.setBounds(136, 197, 72, 17);
					jPanelMenuLateral.add(jButtonRemover);
					jButtonRemover.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							try {
								jButtonRemoverActionPerformed(evt);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e);
							}
						}
					});

				}
				{
					jButtonAdd = new JButton();
					jPanelMenuLateral.add(jButtonAdd);
					jButtonAdd.setText("Adicionar");
					jButtonAdd.setBackground(new java.awt.Color(255,255,255));
					jButtonAdd.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonAdd.setBounds(58, 197, 72, 17);
					jButtonAdd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonAddActionPerformed(evt);
						}
					});

				}
				{
					jLabelOperacao = new JLabel();
					jPanelMenuLateral.add(jLabelOperacao);
					jLabelOperacao.setText("Operação:");
					jLabelOperacao.setFont(new java.awt.Font("Tahoma",1,12));
					jLabelOperacao.setBounds(34, 267, 64, 21);
				}
				{
				
					String[] colunas =  {"X", "Y"};	
					String[][] dados = {};
					model = new DefaultTableModel(dados, colunas); 
					jTableVertices = new JTable(model);
					jTableVertices.setBounds(73, 200, 142, 112);
					jTableVertices.setLayout(null);
					jTableVertices.setFillsViewportHeight(true);
					jPanelMenuLateral.add(jTableVertices);
					//jTableVertices.setOpaque(false);

				}

				{
					jScrollPane = new JScrollPane(jTableVertices);
					jScrollPane.setBackground(new java.awt.Color(255,255,255));
					jPanelMenuLateral.add(jScrollPane);
					jScrollPane.setBounds(46, 69, 181, 120);
				}
				{
					jLabelVertice = new JLabel();
					jPanelMenuLateral.add(jLabelVertice);
					jLabelVertice.setText("Vértices");
					jLabelVertice.setFont(new java.awt.Font("Tahoma",1,12));
					jLabelVertice.setBounds(108, 45, 54, 21);
				}
				{
					ComboBoxModel jComboBoxOperacoesModel = 
							new DefaultComboBoxModel(
									new String[] { "Translação", "Rotação","Escala" , "Cisalhamento", "Reflexão" });
					jComboBoxOperacoes = new JComboBox();
					jPanelMenuLateral.add(jComboBoxOperacoes);
					jComboBoxOperacoes.setModel(jComboBoxOperacoesModel);
					jComboBoxOperacoes.setBounds(100, 269, 133, 19);
					jComboBoxOperacoes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					jComboBoxOperacoes.setForeground(new java.awt.Color(0,0,0));
					jComboBoxOperacoes.setBackground(new java.awt.Color(255,255,255));
				}
				{
					panelTrans = new JPanel();
					jPanelMenuLateral.add(panelTrans);
				}
				{
					jLabelTransformacoes = new JLabel();
					jPanelMenuLateral.add(jLabelTransformacoes);
					jLabelTransformacoes.setText("Transformações");
					jLabelTransformacoes.setFont(new java.awt.Font("Tahoma",1,12));
					jLabelTransformacoes.setBounds(87, 340, 109, 21);
				}
				{
					String[] colunasT =  {"Operação", "Valores"};	
					String[][] dadosT = {};
					modelTransformacoes = new DefaultTableModel(dadosT, colunasT); 
					jTableTransformacoes = new JTable(modelTransformacoes);
					jPanelMenuLateral.add(jTableTransformacoes);
					jTableTransformacoes.setBounds(25, 380, 200, 1);
					jTableTransformacoes.setLayout(null);
					jTableTransformacoes.setFillsViewportHeight(true);
					jTableTransformacoes.setPreferredSize(new java.awt.Dimension(221, 126));
					//jTableTransformacoes.setOpaque(false);

				}
				{
					jScrollPaneTransf = new JScrollPane(jTableTransformacoes);
					jScrollPaneTransf.setBackground(new java.awt.Color(255,255,255));
					jPanelMenuLateral.add(jScrollPaneTransf);
					jScrollPaneTransf.setBounds(25, 365, 224, 150);
				}
				{
					jButtonAplicar = new JButton();
					jPanelMenuLateral.add(jButtonAplicar);
					jButtonAplicar.setText("Aplicar");
					jButtonAplicar.setBackground(new java.awt.Color(255,255,255));
					jButtonAplicar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonAplicar.setBounds(96, 522, 72, 17);
					jButtonAplicar.addActionListener(this);
					
				}
				{
				
					//ADICIONA ESSA CLASSE COMO OUVINTE DO BOTAO "Add" DA JANELA "FrameAddVertice"
					addVertice.getJButtonAdicionar().addActionListener(this);
					//ADICIONA ESSA CLASSE COMO OUVINTE DO BOTAO "Add" DA JANELA "FrameTranslacao"
					addTranslacao.getJButtonAdicionar().addActionListener(this);
					//ADICIONA ESSA CLASSE COMO OUVINTE DO BOTAO "Add" DA JANELA "FrameRotacao"
					addRotacao.getJButtonAdicionar().addActionListener(this);
					//ADICIONA ESSA CLASSE COMO OUVINTE DO BOTAO "Add" DA JANELA "FrameEscala"
					addEscala.getJButtonAdicionar().addActionListener(this);
					//ADICIONA ESSA CLASSE COMO OUVINTE DO BOTAO "Add" DA JANELA "FrameCisalhamento"
					addCisalhamento.getJButtonAdicionar().addActionListener(this);
					//ADICIONA ESSA CLASSE COMO OUVINTE DO BOTAO "Add" DA JANELA "FrameReflexao"
					addReflexao.getJButtonAdicionar().addActionListener(this);
				}

			} 

			{	//criando tela de desenho
				jPanelDesenho = new TelaDesenho();
				this.add(jPanelDesenho);
				jPanelDesenho.setBounds(279, 5, 602, 602);
				jPanelDesenho.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				jPanelDesenho.setBackground(new java.awt.Color(255,255,255));
				jPanelDesenho.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jPanelDesenhoMouseClicked(evt);
					}
				});

			}
			
			{	//evento das coordenadas da tela de desenho
				jPanelDesenho.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseMoved(MouseEvent event){
						coordX.setText("X: "+ (event.getX()-Xinit));
						coordY.setText("Y: "+(Yinit - event.getY()));
					}});
				
			}
		 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adiciona linha de valores dos Vértices na tabela de Vértices
	 * @param x Coordenada X
	 * @param y Coordenada Y
	 */
	public void adicionaLinhaVertice(int x, int y) {  
		 // Obtem o modelo da JTable  
		 model = (DefaultTableModel)jTableVertices.getModel();  
		 // Adiciona uma nova linha em branco no modelo  
		 model.addRow( new String [] {""+x, ""+y} );  
		} 
	
	
	/**
	 * Adiciona linha de transformação na Tabela de Transformações
	 * @param operacao Nome da Operação a ser realizada
	 * @param valores Valores da Operação a ser realizada
	 */
	public void adicionaLinhaTransformacoes(String operacao, String valores) {  
		 // Obtem o modelo da JTable  
		 model = (DefaultTableModel)jTableTransformacoes.getModel();  
		 // Adiciona uma nova linha em branco no modelo  
		 model.addRow( new String [] {operacao, valores} );  
		} 
	
	/**
	 * Remove linhas da tabela de Vértices
	 */
	public void removeLinhasVertices(){
		 model = (DefaultTableModel)jTableVertices.getModel();
		 
		 int count = model.getRowCount();
		 
		 for (int i=0; i < count; i++){
			 model.removeRow(0);
		 }
		
	}
	
	/**
	 * Remove linhas da tabela de Transformações
	 */
	public void removeLinhasTransformacoes(){
		 model = (DefaultTableModel)jTableTransformacoes.getModel();
		 
		 int count = model.getRowCount();
		 
		 for (int i=0; i < count; i++){
			 model.removeRow(0);
		 }
		
	}
	
	/**
	 * Remove linhas da tabela de Vértices e adiciona as novas linhas (caso haja)
	 */
	public void atualizaLinhasVertices(){
		removeLinhasVertices();
		model = (DefaultTableModel)jTableVertices.getModel();
		
		for (Vertice coords: OPMatriz.getCoordsPontos()){
			 
			model.addRow(new String [] {""+coords.getCoordX(), ""+coords.getCoordY()});
		}
		
		
	}
	
	/**
	 * Evento do Botão Desenhar
	 * Interliga os Vértices através do algoritmo da reta DDA
	 * @param evt
	 * @throws Exception
	 */
	private void jButtonDesenharActionPerformed(ActionEvent evt) throws Exception {
		
		jPanelDesenho.printObjeto(this.OPMatriz);
		
	}
	
	/**
	 * Evento do Botão Limpar (Vértices)
	 * Remove vértices e limpa tela de desenho
	 * @param evt
	 */
	private void jButtonLimparActionPerformed(ActionEvent evt) {
		//LIMPA TELA DE DESENHO E ARRAY DE COORDENADAS
		jPanelDesenho.limparTransfGeometricas(this.OPMatriz);
		
		//REMOVE LINHAS DA TABELA DE COORDENADAS
		removeLinhasVertices();
		
		//REMOVE OPERAÇÕES
		OPMatriz.limpaArrayOperacoes();	
		
		//REMOVE LINHAS DA TABELA DE TRANSFORMAÇÕES
		removeLinhasTransformacoes();
		
		//ZERA O PONTO FIXO PARA NOVAS OPERAÇÕES
		incrementoPontoFixoX = 0;
		incrementoPontoFixoY = 0;
		
		
	}
	
	/**
	 * Escolhe Operação de Transformação a ser realizada e mostra a janela apropriada
	 * @param evt
	 */
	private void jButtonEscolherActionPerformed(ActionEvent evt) {
		//translação
		if (jComboBoxOperacoes.getSelectedItem().equals("Translação")){
			addTranslacao.setVisible(true);
			
		}
		//escala
		else if (jComboBoxOperacoes.getSelectedItem().equals("Escala")){
			
			addEscala.setVisible(true);
			
		}
		//rotação
		else if (jComboBoxOperacoes.getSelectedItem().equals("Rotação")){
			
			addRotacao.setVisible(true);
	
		}
		//cisalhamento
		else if (jComboBoxOperacoes.getSelectedItem().equals("Cisalhamento")){
			
			addCisalhamento.setVisible(true);
			
		}
		//reflexao
		else if (jComboBoxOperacoes.getSelectedItem().equals("Reflexão")){
			
			addReflexao.setVisible(true);
			
		}
		
	}
	
	/**
	 * Evento de adição de Vértices ao clicar na tela
	 * @param evt 
	 */
	private void jPanelDesenhoMouseClicked(MouseEvent evt) {
		//ADICIONA A COORDENADA DO CLICK NAS VARIAVEIS
		CoordenadaX = evt.getX() - Xinit;
		CoordenadaY = Yinit - evt.getY();
		
		//ADICIONA AS COORDENADAS A LISTA DE VERTICES
		adicionaLinhaVertice(CoordenadaX, CoordenadaY);
		
		//CRIA UM OBJETO DO TIPO COORDENADAS
		Vertice Coords = new Vertice(CoordenadaX, CoordenadaY);
		
		//ADICIONA O OBJETO EM UM ARRAYLIST
		OPMatriz.addCoordsPontos(Coords);
		
		//PINTA O PONTO DO CLICK
		jPanelDesenho.plotDot(CoordenadaX, CoordenadaY);
	}
	
	/**
	 * Evento de Remoção de Vértice do Botão Remover
	 * @param evt 
	 * @throws Exception Caso não tenha selecionado um Vértice para remoção gerar erro.
	 */
	private void jButtonRemoverActionPerformed(ActionEvent evt) throws Exception {
		
		
		model = (DefaultTableModel)jTableVertices.getModel(); 
	
		try {
			//REMOVE COORDENADA DO ARRAYLIST
			OPMatriz.removeCoordsPontos(jTableVertices.getSelectedRow());
			
			//REMOVE COORDENADA DO JTABLE
			model.removeRow(jTableVertices.getSelectedRow());
			
			//RE-DESENHA O OBJETO ALTERADO
			jPanelDesenho.limpar();
			jPanelDesenho.printObjeto(this.OPMatriz);
			
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Selecione um Vértice!");
		}
	
			 
	}
	
	/**
	 * Evento de abertura de Janela de Adição de Vértice manualmente
	 * @param evt
	 */
	private void jButtonAddActionPerformed(ActionEvent evt) {
		addVertice.setVisible(true);		
	}



	@Override
	/**
	 * Lista de Eventos dos Botões 
	 */
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * Se o evento disparado for o Botão Add da janela FrameAddVertice
		 * 
		 */
		if (e.getSource() == addVertice.getJButtonAdicionar()){
			
		try {
				
			int x = Integer.parseInt(addVertice.getJTextFieldX().getText());
			int y = Integer.parseInt(addVertice.getJTextFieldY().getText());
				
				//ADICIONA AS COORDENADAS NA LISTA DE VERTICES
				adicionaLinhaVertice(x, y);
						
				//CRIA UM OBJETO DO TIPO COORDENADAS
				Vertice Coords = new Vertice(x, y);
					
				//ADICIONA O OBJETO EM UM ARRAYLIST
				OPMatriz.addCoordsPontos(Coords);
					
				//PINTA O PONTO DO VERTICE ADICIONADO
				jPanelDesenho.plotDot(x, y);
				
				//LIMPA CAMPOS
				addVertice.clearCampos();
					
				//FECHA JANELA "addVertice"
				addVertice.dispose();	
			
					
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
		}
	}
		
	
		/**
		 * Se o evento disparado for o Botão Adicionar da janela FrameTranslacao
		 */
		else if (e.getSource() == addTranslacao.getJButtonAdicionar()){

			try {
				
				int tx = Integer.parseInt(addTranslacao.getJTextFieldX().getText());
				int ty = Integer.parseInt(addTranslacao.getJTextFieldY().getText());
				
				//CRIA UM OBJETO DO TIPO "OperaçãoTranslacao"
				OperacaoTranslacao opTranslacao = new OperacaoTranslacao(tx, ty);
				
				//ADICIONA TRANSFORMAÇÃO NO ARRAY DE OPERAÇÕES
				OPMatriz.adicionaOperacao(opTranslacao);
				
				//ADICIONA OPERAÇÃO NA LISTA DE TRANSFORMAÇÕES
				adicionaLinhaTransformacoes(opTranslacao.getNomeOperacao(), opTranslacao.getValores());
				
				//LIMPA OS CAMPOS
				addTranslacao.clearCampos();
				
				//FECHA JANELA "addTranslacao"
				addTranslacao.dispose();
				
				//INCREMENTA O PONTOFIXO 
				incrementoPontoFixoX += tx;
				incrementoPontoFixoY += ty;
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			}
				
		}
		
		/**
		 * Se o evento disparado for o Botão Aplicar (Transformações)
		 */
		else if (e.getSource() == this.jButtonAplicar){	
			
					
			//CASO TENHA UMA OU MAIS TRANSFORMAÇÕES A SEREM REALIZADAS
			if (!OPMatriz.getOperacoes().isEmpty()){

			
				//PASSA VALORES DO ARRAYLIST DE COORDENADAS PARA UMA MATRIZ
				OPMatriz.preencheMatrizObjeto();
			
				//REALIZA MULTIPLICAÇÃO DAS TRANSFORMAÇÕES
				OPMatriz.multiplicarMatriz();
			
				//ATUALIZA ARRAYLIST DE COORDENADAS COM OS NOVOS VALORES
				OPMatriz.atualizaArraylistCoordenadas();
			
				//ATUALIZA LINHAS DE COORDENADAS DO JTABLE DE VÉRTICES
				atualizaLinhasVertices();
			
				try {
					//desenha o objeto
					jPanelDesenho.printObjeto(this.OPMatriz);
					
					//desenha a reta Y=X caso necessário
					for (Operador op : OPMatriz.getOperacoes()){
						if (op.getNomeOperacao() == "Reflexão"){
							if (op.getValores() == "Y=X"){
								jPanelDesenho.retaYEqualX();
							}
						}
						
						//desenha a reta Y=mx+b caso necessário
						else if (op.getNomeOperacao() == "Reflex. Y=mx+b"){
							jPanelDesenho.retaYEqualMXB((int)m, (int)b);
						}
					}
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Objeto indefinido!");
				}
			}
			
		}
		
		/**
		 * Se o evento disparado for o Botão Adicionar da janela FrameRotacao
		 */
		else if (e.getSource() == addRotacao.getJButtonAdicionar()){
			
			pontoFixoX = OPMatriz.getCoordsPontos().get(0).getCoordX();
			pontoFixoY = OPMatriz.getCoordsPontos().get(0).getCoordY();
			
			int x = pontoFixoX + incrementoPontoFixoX;
			int y = pontoFixoY + incrementoPontoFixoY;
			
			try {
				
				//PEGA ANGULO DE ROTACAO
				double angulo = Integer.parseInt((addRotacao.getJTextFieldAngulo().getText()));
				
				//CRIA OPERAÇÃO DE ROTACAO
				OperacaoRotacao opRotacao = new OperacaoRotacao(angulo, x, y);
				
				//ADICIONA TRANSFORMAÇÃO NO ARRAY DE OPERAÇÕES
				OPMatriz.adicionaOperacao(opRotacao);
				
				//ADICIONA TRANSFORMAÇÃO NA LISTA DE TRANSFORMAÇÕES (JTable)
				adicionaLinhaTransformacoes(opRotacao.getNomeOperacao(), opRotacao.getValores());
				
				//LIMPA OS CAMPOS
				addRotacao.clearCampos();
				
				//FECHA JANELA "addRotacao"
				addRotacao.dispose();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Objeto indefinido!");
			}
			
			
		}
		/**
		 * Se o evento disparado for o Botão Adicionar da janela FrameEscala
		 */
		else if (e.getSource() == addEscala.getJButtonAdicionar()){
			
			pontoFixoX = OPMatriz.getCoordsPontos().get(0).getCoordX();
			pontoFixoY = OPMatriz.getCoordsPontos().get(0).getCoordY();
			
			int x = pontoFixoX + incrementoPontoFixoX;
			int y = pontoFixoY + incrementoPontoFixoY;
			
			System.out.println("X =" + x);
			System.out.println("Y =" + y);
			try {

			double Sx = Double.parseDouble(addEscala.getJTextFieldX().getText());
			
			double Sy = Double.parseDouble(addEscala.getJTextFieldY().getText());
			
			OperacaoEscala opEscala = new OperacaoEscala(Sx, Sy, x, y);
			
			OPMatriz.adicionaOperacao(opEscala);
			
			adicionaLinhaTransformacoes(opEscala.getNomeOperacao(), opEscala.getValores());
			
			addEscala.clearCampos();
			
			addEscala.dispose();
			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Objeto indefinido!");
			}
			
			
		}
		
		/**
		 * Se o evento disparado for o Botão Adicionar da janela FrameCisalhamento
		 */
		else if (e.getSource() == addCisalhamento.getJButtonAdicionar()){
			
			pontoFixoX = OPMatriz.getCoordsPontos().get(0).getCoordX();
			pontoFixoY = OPMatriz.getCoordsPontos().get(0).getCoordY();
			
			int x = pontoFixoX + incrementoPontoFixoX;
			int y = pontoFixoY + incrementoPontoFixoY;
			
			try {
							
			double CisX = Integer.parseInt(addCisalhamento.getJTextFieldX().getText());
			double CisY = Integer.parseInt(addCisalhamento.getJTextFieldY().getText());
			
			OperacaoCisalhamento opCisalhamento = new OperacaoCisalhamento(CisX, CisY, x, y);
			
			OPMatriz.adicionaOperacao(opCisalhamento);
			
			adicionaLinhaTransformacoes(opCisalhamento.getNomeOperacao(), opCisalhamento.getValores());
			
			addCisalhamento.clearCampos();
			
			addCisalhamento.dispose();
			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Objeto indefinido!");
			}
			
		}
		
		/**
		 * Se o evento disparado for o Botão Adicionar da janela FrameReflexao
		 */
		else if (e.getSource() == addReflexao.getJButtonAdicionar()){
			
			double x = 1;
			double y = 1;
			double a = 0;
			double b = 0;
			
			String operacao = "";
			
			//Operação de Reflexão em X
			if (addReflexao.getJRadioButtonX().isSelected()){
				y = -1;
				operacao = "X";
				
				OperacaoReflexao opReflexao = new OperacaoReflexao(x, y, a, b, operacao);
				
				OPMatriz.adicionaOperacao(opReflexao);
				
				adicionaLinhaTransformacoes(opReflexao.getNomeOperacao(), opReflexao.getValores());
				
				
				addReflexao.clearCampos();
				
				addReflexao.dispose();
					
			}
			
			//Reflexão em Y
			else if (addReflexao.getJRadioButtonY().isSelected()){
				x = -1;
				operacao = "Y";
				
				OperacaoReflexao opReflexao = new OperacaoReflexao(x, y, a, b, operacao);
				
				OPMatriz.adicionaOperacao(opReflexao);
				
				adicionaLinhaTransformacoes(opReflexao.getNomeOperacao(), opReflexao.getValores());
				
				
				addReflexao.clearCampos();
				
				addReflexao.dispose();
			}
			
			//Reflexão em torno da Origem
			else if (addReflexao.getJRadioButtonOrigem().isSelected()){
				x = -1;
				y = -1;	
				operacao = "Origem";
				
				OperacaoReflexao opReflexao = new OperacaoReflexao(x, y, a, b, operacao);
				
				OPMatriz.adicionaOperacao(opReflexao);
				
				adicionaLinhaTransformacoes(opReflexao.getNomeOperacao(), opReflexao.getValores());
				
				
				addReflexao.clearCampos();
				
				addReflexao.dispose();
				
			}
			//Reflexão em torno da reta Y=X
			else if (addReflexao.getJRadioButtonReta().isSelected()){
				x = 0;
				y = 0;
				a = 1;
				b = 1;
				operacao = "Y=X";
				
				OperacaoReflexao opReflexao = new OperacaoReflexao(x, y, a, b, operacao);
				
				OPMatriz.adicionaOperacao(opReflexao);
				
				adicionaLinhaTransformacoes(opReflexao.getNomeOperacao(), opReflexao.getValores());
				
				
				addReflexao.clearCampos();
				
				addReflexao.dispose();
			}
			//Reflexão em torno da reta Y=Mx+B
			else if (addReflexao.getJRadioButtonReta2().isSelected()){
				double varM = Integer.parseInt(addReflexao.getjTextFieldm().getText());
				double varB = Integer.parseInt(addReflexao.getjTextFieldb().getText());
				
				this.m = varM;
				this.b = varB;
			   
			    	OperacaoReflexaoRetaYMXB opReflexaoYMXB = new OperacaoReflexaoRetaYMXB(varM, varB);
			    	OPMatriz.adicionaOperacao(opReflexaoYMXB);
			    	adicionaLinhaTransformacoes(opReflexaoYMXB.getNomeOperacao(), opReflexaoYMXB.getValores());
			
			    	addReflexao.clearCampos();
					
					addReflexao.dispose();
			}
		}
		
		
	}
	

}
