package Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import Algoritmos.Vertice;
import Operadores.OperacaoRotacaoAnimacao;



@SuppressWarnings("serial")
public class PanelRotacaoAnimacao extends javax.swing.JPanel implements ActionListener{
	private JPanel jPanelMenuLateral;
	private TelaDesenho jPanelDesenho;
	private static JLabel coordX;
	private static JLabel coordY;
	private JScrollPane jScrollPane;
	private JButton jButtonParar;
	public static JTable jTableVertices;
	private JButton jButtonDesenhar;
	private JButton jButtonLimpar;
	private JSeparator jSeparator1;
	private JLabel jLabelDDA;
	private int CoordenadaX;
	private int CoordenadaY;
	private int Xinit = 300;
	private int Yinit = 300;
	public static DefaultTableModel model;
	private JLabel jLabelVertice;
	private JButton jButtonAdd;
	private JButton jButtonRemover;
	private JPanel panelTrans;
	private FrameAddVertice addVertice = new FrameAddVertice();
	private JButton jButtonIniciar;
	private JTextField jTextFieldCoordenadaY;
	private JTextField jTextFieldCoordenadaX;
	private JLabel jLabelY;
	private JLabel jLabelX;
	private JLabel jLabel1;
	private JSeparator jSeparator2;
	private int pivoX;
	private int pivoY;
	public OperacaoRotacaoAnimacao opRotacaoAnimacao = new OperacaoRotacaoAnimacao();
	public Thread threadOperacao;

	public PanelRotacaoAnimacao() {
		super();
		initGUI();
	}
	
	/**
	 * Construtor
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
					jLabelDDA.setText("Animação - Rotação Bidimensional");
					jLabelDDA.setBounds(26, 13, 227, 20);
					jLabelDDA.setFont(new java.awt.Font("Segoe UI",1,13));
				}
				{
					jSeparator1 = new JSeparator();
					jPanelMenuLateral.add(jSeparator1);
					jSeparator1.setBounds(9, 36, 256, 6);
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
				
					String[] colunas =  {"X", "Y"};	
					String[][] dados = {};
					model = new DefaultTableModel(dados, colunas); 
					jTableVertices = new JTable(model);
					jTableVertices.setBounds(73, 200, 142, 112);
					jTableVertices.setLayout(null);
					jTableVertices.setFillsViewportHeight(true);
					jPanelMenuLateral.add(jTableVertices);

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
					panelTrans = new JPanel();
					jPanelMenuLateral.add(panelTrans);
				}
				{
					jSeparator2 = new JSeparator();
					jPanelMenuLateral.add(jSeparator2);
					jSeparator2.setBounds(9, 291, 256, 10);
				}
				{
					jLabel1 = new JLabel();
					jPanelMenuLateral.add(jLabel1);
					jLabel1.setText("Pivô");
					jLabel1.setFont(new java.awt.Font("Tahoma",1,12));
					jLabel1.setBounds(119, 268, 54, 21);
				}
				{
					jLabelX = new JLabel();
					jPanelMenuLateral.add(jLabelX);
					jLabelX.setText("Coordenada X:");
					jLabelX.setBounds(46, 313, 96, 16);
				}
				{
					jLabelY = new JLabel();
					jPanelMenuLateral.add(jLabelY);
					jLabelY.setText("Coordenada Y:");
					jLabelY.setBounds(46, 350, 96, 16);
				}
				{
					jTextFieldCoordenadaX = new JTextField();
					jTextFieldCoordenadaX.setBackground(new java.awt.Color(213,232,253));
					jPanelMenuLateral.add(jTextFieldCoordenadaX);
					jTextFieldCoordenadaX.setBounds(135, 311, 53, 20);
					jTextFieldCoordenadaX.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					jTextFieldCoordenadaY = new JTextField();
					jPanelMenuLateral.add(jTextFieldCoordenadaY);
					jTextFieldCoordenadaY.setBounds(135, 348, 53, 20);
					jTextFieldCoordenadaY.setBackground(new java.awt.Color(213,232,253));
					jTextFieldCoordenadaY.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					jButtonIniciar = new JButton();
					jPanelMenuLateral.add(jButtonIniciar);
					jButtonIniciar.setText("Iniciar");
					jButtonIniciar.setBounds(56, 400, 77, 19);
					jButtonIniciar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonIniciarActionPerformed(evt);
						}
					});
				}
				{
					jButtonParar = new JButton();
					jPanelMenuLateral.add(jButtonParar);
					jButtonParar.setText("Parar");
					jButtonParar.setBounds(137, 400, 77, 19);
					jButtonParar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonPararActionPerformed(evt);
						}
					});
				}

			} 
		


			{
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
			
			{
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
	 * Evento do Botão Desenhar
	 * Interliga os Vértices através do algoritmo da reta DDA
	 * @param evt
	 * @throws Exception
	 */
	private void jButtonDesenharActionPerformed(ActionEvent evt) throws Exception {
		
		jPanelDesenho.printObjeto(this.opRotacaoAnimacao);
		
	}
	
	/**
	 * Evento do Botão Limpar (Vértices)
	 * Remove vértices e limpa tela de desenho
	 * @param evt
	 */
	private void jButtonLimparActionPerformed(ActionEvent evt) {
		
		//REMOVE LINHAS DA TABELA DE COORDENADAS
		removeLinhasVertices();
		
		//limpa a tela
		jPanelDesenho.limpar();
		
		//remove vertices
		opRotacaoAnimacao.limpaArrayCoordenadas();
		
		
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
		opRotacaoAnimacao.addCoordsPontos(Coords);
		
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
			opRotacaoAnimacao.removeCoordsPontos(jTableVertices.getSelectedRow());
			
			//REMOVE COORDENADA DO JTABLE
			model.removeRow(jTableVertices.getSelectedRow());
			
			//RE-DESENHA O OBJETO ALTERADO
			jPanelDesenho.limpar();
			jPanelDesenho.printObjeto(this.opRotacaoAnimacao);
			
			
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
				opRotacaoAnimacao.addCoordsPontos(Coords);
					
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
		
	}
	
	/**
	 * Evento do botão iniciar que inicia animação de rotação
	 * @param evt
	 */
	private void jButtonIniciarActionPerformed(ActionEvent evt) {
	
		pivoX = Integer.parseInt(jTextFieldCoordenadaX.getText());
		pivoY = Integer.parseInt(jTextFieldCoordenadaY.getText());
		opRotacaoAnimacao.setPivoX(pivoX);
		opRotacaoAnimacao.setPivoY(pivoY);
		opRotacaoAnimacao.setPanelDesenho(this.jPanelDesenho);
		
		threadOperacao = new Thread(opRotacaoAnimacao);
		threadOperacao.start();
		opRotacaoAnimacao.setRun(true);
		
		

		
	}
	 
	/**
	 * Para a animação
	 * @param evt
	 */
	private void jButtonPararActionPerformed(ActionEvent evt) {
		opRotacaoAnimacao.setRun(false);
	 }

}
