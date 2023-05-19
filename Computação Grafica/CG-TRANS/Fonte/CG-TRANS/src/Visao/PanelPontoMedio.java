package Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelPontoMedio extends javax.swing.JPanel {
	private TelaDesenho jPanelDesenho;
	private JSeparator jSeparator3;
	private JLabel jLabel1;
	private JSeparator jSeparator1;
	private JLabel jLabelPMReta;
	private JTextField jTextFieldY1;
	private JTextField jTextFieldY2;
	private JTextField jTextFieldX2;
	private JTextField jTextFieldX1;
	private static JLabel coordX;
	private static JLabel coordY;
	private JPanel jPanelMenuLateral;
	private JButton jButtonLimpar;
	private JButton jButtonDesenhar;
	private JLabel jLabelX1;
	private JLabel jLabelX2;
	private JLabel jLabelY1;
	private JLabel jLabelY2;
	private JLabel jLabelCoordenadas;
	private JTable jTablePontos;
	private JScrollPane jScrollPanePontos;
	private DefaultTableModel model;
	private int Xinit = 300;
	private int Yinit = 300;
	private int CoordenadaX;
	private int CoordenadaY;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PanelDDA());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public PanelPontoMedio() {
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
					jLabelCoordenadas = new JLabel();
					jPanelMenuLateral.add(jLabelCoordenadas);
					jLabelCoordenadas.setText("Coordenadas:");
					jLabelCoordenadas.setBounds(13, 47, 119, 14);
					jLabelCoordenadas.setFont(new java.awt.Font("Tahoma",1,12));
				}
				{
					jTextFieldX1 = new JTextField();
					jPanelMenuLateral.add(jTextFieldX1);
					jTextFieldX1.setBounds(66, 78, 53, 20);
					jTextFieldX1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jTextFieldX1.setBackground(new java.awt.Color(213,232,253));
					jTextFieldX1.setToolTipText("Adicione a coordenada X1");
				}
				{
					jLabelX1 = new JLabel();
					jPanelMenuLateral.add(jLabelX1);
					jLabelX1.setText("X1:");
					jLabelX1.setBounds(43, 80, 16, 16);
					jLabelX1.setFont(new java.awt.Font("Segoe UI",1,11));
				}
				{
					jLabelX2 = new JLabel();
					jPanelMenuLateral.add(jLabelX2);
					jLabelX2.setText("X2:");
					jLabelX2.setFont(new java.awt.Font("Segoe UI",1,11));
					jLabelX2.setBounds(43, 114, 16, 16);
				}
				{
					jTextFieldX2 = new JTextField();
					jPanelMenuLateral.add(jTextFieldX2);
					jTextFieldX2.setBackground(new java.awt.Color(213,232,253));
					jTextFieldX2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jTextFieldX2.setBounds(66, 112, 53, 20);
					jTextFieldX2.setToolTipText("Adicione a coordenada X2");
				}
				{
					jLabelY1 = new JLabel();
					jPanelMenuLateral.add(jLabelY1);
					jLabelY1.setText("Y1:");
					jLabelY1.setFont(new java.awt.Font("Segoe UI",1,11));
					jLabelY1.setBounds(137, 80, 16, 16);
				}
				{
					jLabelY2 = new JLabel();
					jPanelMenuLateral.add(jLabelY2);
					jLabelY2.setText("Y2:");
					jLabelY2.setFont(new java.awt.Font("Segoe UI",1,11));
					jLabelY2.setBounds(137, 114, 16, 16);
				}
				{
					jTextFieldY1 = new JTextField();
					jPanelMenuLateral.add(jTextFieldY1);
					jTextFieldY1.setBackground(new java.awt.Color(213,232,253));
					jTextFieldY1.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldY1.setBounds(160, 78, 53, 20);
					jTextFieldY1.setToolTipText("Adicione a coordenada Y1");
				}
				{
					jTextFieldY2 = new JTextField();
					jPanelMenuLateral.add(jTextFieldY2);
					jTextFieldY2.setBackground(new java.awt.Color(213,232,253));
					jTextFieldY2.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldY2.setBounds(160, 112, 53, 20);
					jTextFieldY2.setToolTipText("Adicione a coordenada Y2");
				}
				{
					jButtonDesenhar = new JButton();
					jPanelMenuLateral.add(jButtonDesenhar);
					jButtonDesenhar.setText("Desenhar");
					jButtonDesenhar.setBounds(76, 162, 115, 23);
					jButtonDesenhar.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jButtonDesenhar.setBackground(new java.awt.Color(255,255,255));
					jButtonDesenhar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonDesenharActionPerformed(evt);
						}
					});

				{
					jButtonLimpar = new JButton();
					jPanelMenuLateral.add(jButtonLimpar);
					jButtonLimpar.setText("Limpar");
					jButtonLimpar.setBackground(new java.awt.Color(255,255,255));
					jButtonLimpar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonLimpar.setBounds(76, 191, 115, 23);
					jButtonLimpar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonLimparActionPerformed(evt);
						}
					});

				}	
				
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
					jLabelPMReta = new JLabel();
					jPanelMenuLateral.add(jLabelPMReta);
					jLabelPMReta.setText("Ponto Médio - Reta");
					jLabelPMReta.setFont(new java.awt.Font("Segoe UI",1,12));
					jLabelPMReta.setBounds(80, 15, 111, 20);
				}
				{
					{
						jSeparator1 = new JSeparator();
						jPanelMenuLateral.add(jSeparator1);
						jSeparator1.setBounds(9, 36, 256, 10);
					}
					{
						jSeparator3 = new JSeparator();
						jPanelMenuLateral.add(jSeparator3);
						jSeparator3.setBounds(9, 264, 256, 12);
					}
					
					{
						String[] colunas =  {"X", "Y"};	
						String[][] dados = {};
						model = new DefaultTableModel(dados, colunas); 
						jTablePontos = new JTable(model);
						jTablePontos.setBounds(25, 380, 200, 100);
						jTablePontos.setLayout(null);
						jTablePontos.setFillsViewportHeight(true);
						jPanelMenuLateral.add(jTablePontos);
						
					}
					{
						jScrollPanePontos = new JScrollPane(jTablePontos);
						jScrollPanePontos.setBackground(new java.awt.Color(255,255,255));
						jPanelMenuLateral.add(jScrollPanePontos);
						jScrollPanePontos.setBounds(25, 286, 224, 150);

					}
					{
						jLabel1 = new JLabel();
						jPanelMenuLateral.add(jLabel1);
						jLabel1.setText("Pontos");
						jLabel1.setFont(new java.awt.Font("Segoe UI",1,12));
						jLabel1.setBounds(115, 238, 62, 20);
					}
				}

			{
				jPanelDesenho = new TelaDesenho();
				this.add(jPanelDesenho);
				jPanelDesenho.setBounds(279, 5, 602, 602);
				jPanelDesenho.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelDesenho.setBackground(new java.awt.Color(255,255,255));
				jPanelDesenho.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jPanelDesenhoMouseClicked(evt);
					}
				});

			}

			{
				//Evento das coordenadas da tela
				jPanelDesenho.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseMoved(MouseEvent event){
						coordX.setText("X: "+(event.getX()-300));
						coordY.setText("Y: "+(event.getY()-300)*(-1));
					}});
				
			}
			}
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	/**
	 * Remove os Pontos(coordenadas) do JTable de Pontos
	 */
	public void removePontos(){
		 model = (DefaultTableModel)jTablePontos.getModel();
		 
		 int count = model.getRowCount();
		 
		 for (int i=0; i < count; i++){
			 model.removeRow(0);
		 }
		
	}
	/**
	 * Adiciona linha com coordenadas dos pontos no JTable de Pontos
	 */
	public void adicionaLinhaPontos() {  
		//REMOVE OS PONTOS DO JTABLE
		removePontos();
		 // OBTEM O MODELO DO JTABLE
		model = (DefaultTableModel)jTablePontos.getModel(); 
		 //ADICIONA PONTOS PM NA JTablePontos
		for(int i = 0; i < jPanelDesenho.getPontoMedioPontosX().size(); i++){
			 model.addRow( new String [] {""+jPanelDesenho.getPontoMedioPontosX().get(i), ""+jPanelDesenho.getPontoMedioPontosY().get(i)} );  
		} 
	} 
	
	/**
	 * Evento do Botão Desenhar, desenha a reta de acordo com as coordenadas passadas
	 * @param evt
	 */
	private void jButtonDesenharActionPerformed(ActionEvent evt) {
		jPanelDesenho.limpar();
		jPanelDesenho.MidPointReta(Integer.parseInt(jTextFieldX1.getText()), Integer.parseInt(jTextFieldY1.getText()), Integer.parseInt(jTextFieldX2.getText()), Integer.parseInt(jTextFieldY2.getText()));
		adicionaLinhaPontos();
	}
	
	/**
	 * Evento do Botão Limpar, limpa a tela e os campos
	 * @param evt
	 */
	private void jButtonLimparActionPerformed(ActionEvent evt) {
		removePontos();
		jPanelDesenho.limpar();
		jTextFieldX1.setText("");
		jTextFieldY1.setText("");
		jTextFieldX2.setText("");
		jTextFieldY2.setText("");
	}
	
	/**
	 * Evento que preenche os campos de coordenadas com o click do mouse
	 * @param evt
	 */
	private void jPanelDesenhoMouseClicked(MouseEvent evt) {
		//ADICIONA A COORDENADA DO CLICK NOS TEXTFIELDS
		CoordenadaX = evt.getX() - Xinit;
		CoordenadaY = Yinit - evt.getY();

		
		
		//SE X1 E Y1 ESTIVEREM VAZIOS, PREENCHE 
		//COM COORDENADAS DO CLICK
		if (jTextFieldX1.getText().equals("")){
			jTextFieldX1.setText(""+CoordenadaX);
			jTextFieldY1.setText(""+CoordenadaY);
		}
		//SE X2 E Y2 ESTIVEREM VAZIOS, PREENCHE
		//COM COORDENADAS DO CLICK
		else if (jTextFieldX2.getText().equals("")){
			jTextFieldX2.setText(""+CoordenadaX);
			jTextFieldY2.setText(""+CoordenadaY);
		}
		//SE TODOS OS TEXTFIELDS ESTIVEREM PREENCHIDOS,
		//X1 = X2   Y1 = Y2  E COPIA A NOVA COORDENADA PARA X2 E Y2
		else if (!jTextFieldX1.getText().equals("")){
			if (!jTextFieldX2.getText().equals("")){
				jTextFieldX1.setText(jTextFieldX2.getText());
				jTextFieldY1.setText(jTextFieldY2.getText());
				
				jTextFieldX2.setText(""+CoordenadaX);
				jTextFieldY2.setText(""+CoordenadaY);
			}
		}
	}

}
