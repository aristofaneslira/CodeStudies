package Visao;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import Algoritmos.AlgoritmoCohenSutherland;
import Algoritmos.RetasRecorte;


@SuppressWarnings("serial")
public class PanelRecorte extends javax.swing.JPanel {
	private JPanel jPanelMenuLateral;
	private TelaDesenho jPanelDesenho;
	private JTextField jTextFieldY1;
	private JButton jButtonLimpar;
	private JButton jButtonDesenhar;
	private JTextField jTextFieldY2;
	private JLabel jLabelY2;
	private JLabel jLabelY1;
	private JTextField jTextFieldX2;
	private JLabel jLabelX2;
	private JLabel jLabelX1;
	private JTextField jTextFieldX1;
	private JLabel jLabelCoordenadas;
	private static JLabel coordX;
	private static JLabel coordY;
	private JSeparator jSeparator1;
	private JLabel jLabelDDA;
	private int CoordenadaX;
	private int CoordenadaY;
	private JButton jButtonRecortar;
	private JButton jButtonDesenharJanelaRecorte;
	private JTextField jTextFieldYmax;
	private JTextField jTextFieldYmin;
	private JTextField jTextFieldXmax;
	private JTextField jTextFieldXmin;
	private JLabel jLabelYmax;
	private JLabel jLabelYmin;
	private JLabel jLabelXmax;
	private JLabel jLabelXmin;
	private JSeparator jSeparator3;
	private JSeparator jSeparator2;
	private JLabel jLabel1;
	private int Xinit = 300;
	private int Yinit = 300;
	private int Xmin;
	private int Xmax;
	private int Ymin;
	private int Ymax;
	private RetasRecorte retasRecorte;
	private ArrayList<RetasRecorte> retas = new ArrayList<>();

	public PanelRecorte() {
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
					jLabelCoordenadas.setText("Retas:");
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
					jButtonDesenhar.setBounds(76, 151, 115, 23);
					jButtonDesenhar.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jButtonDesenhar.setBackground(new java.awt.Color(255,255,255));
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
					jButtonLimpar.setBackground(new java.awt.Color(255,255,255));
					jButtonLimpar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonLimpar.setBounds(76, 180, 115, 23);
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
					jLabelDDA = new JLabel();
					jPanelMenuLateral.add(jLabelDDA);
					jLabelDDA.setText("Recorte");
					jLabelDDA.setBounds(110, 14, 60, 20);
					jLabelDDA.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					jSeparator1 = new JSeparator();
					jPanelMenuLateral.add(jSeparator1);
					jSeparator1.setBounds(9, 36, 256, 6);
				}

				{
					jLabel1 = new JLabel();
					jPanelMenuLateral.add(jLabel1);
					jLabel1.setText("Janela de Recorte");
					jLabel1.setFont(new java.awt.Font("Segoe UI",1,12));
					jLabel1.setBounds(82, 221, 115, 20);
				}
				{
					jSeparator2 = new JSeparator();
					jPanelMenuLateral.add(jSeparator2);
					jSeparator2.setBounds(9, 36, 256, 6);
				}
				{
					jSeparator3 = new JSeparator();
					jPanelMenuLateral.add(jSeparator3);
					jSeparator3.setBounds(9, 247, 256, 12);
				}
				{
					jLabelXmin = new JLabel();
					jPanelMenuLateral.add(jLabelXmin);
					jLabelXmin.setText("Xmin:");
					jLabelXmin.setBounds(29, 274, 37, 16);
					jLabelXmin.setFont(new java.awt.Font("Segoe UI",1,11));
				}
				{
					jLabelXmax = new JLabel();
					jPanelMenuLateral.add(jLabelXmax);
					jLabelXmax.setText("Xmax:");
					jLabelXmax.setBounds(137, 274, 38, 16);
					jLabelXmax.setFont(new java.awt.Font("Segoe UI",1,11));
				}
				{
					jLabelYmin = new JLabel();
					jPanelMenuLateral.add(jLabelYmin);
					jLabelYmin.setText("Ymin:");
					jLabelYmin.setBounds(29, 313, 37, 16);
					jLabelYmin.setFont(new java.awt.Font("Segoe UI",1,11));
				}
				{
					jLabelYmax = new JLabel();
					jPanelMenuLateral.add(jLabelYmax);
					jLabelYmax.setText("Ymax:");
					jLabelYmax.setBounds(137, 313, 38, 16);
					jLabelYmax.setFont(new java.awt.Font("Segoe UI",1,11));
				}
				{
					jTextFieldXmin = new JTextField();
					jTextFieldXmin.setBackground(new java.awt.Color(213,232,253));
					jPanelMenuLateral.add(jTextFieldXmin);
					jTextFieldXmin.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldXmin.setBounds(67, 273, 53, 20);
					jTextFieldXmin.setToolTipText("Adicione o Xmin");
				}
				{
					jTextFieldXmax = new JTextField();
					jPanelMenuLateral.add(jTextFieldXmax);
					jTextFieldXmax.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldXmax.setBackground(new java.awt.Color(213,232,253));
					jTextFieldXmax.setBounds(178, 273, 53, 20);
					jTextFieldXmax.setToolTipText("Adicione o Xmax");
				}
				{
					jTextFieldYmin = new JTextField();
					jPanelMenuLateral.add(jTextFieldYmin);
					jTextFieldYmin.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldYmin.setBackground(new java.awt.Color(213,232,253));
					jTextFieldYmin.setBounds(67, 312, 53, 20);
					jTextFieldYmin.setToolTipText("Adicione o Ymin");
				}
				{
					jTextFieldYmax = new JTextField();
					jPanelMenuLateral.add(jTextFieldYmax);
					jTextFieldYmax.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldYmax.setBackground(new java.awt.Color(213,232,253));
					jTextFieldYmax.setBounds(178, 312, 53, 20);
					jTextFieldYmax.setToolTipText("Adicione o Ymax");
				}
				{
					jButtonDesenharJanelaRecorte = new JButton();
					jPanelMenuLateral.add(jButtonDesenharJanelaRecorte);
					jButtonDesenharJanelaRecorte.setText("Desenhar");
					jButtonDesenharJanelaRecorte.setBackground(new java.awt.Color(255,255,255));
					jButtonDesenharJanelaRecorte.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonDesenharJanelaRecorte.setBounds(79, 351, 115, 23);
					jButtonDesenharJanelaRecorte.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonDesenharJanelaRecorteActionPerformed(evt);
						}
					});
				}
				{
					jButtonRecortar = new JButton();
					jPanelMenuLateral.add(jButtonRecortar);
					jButtonRecortar.setText("Recortar");
					jButtonRecortar.setBackground(new java.awt.Color(255,255,255));
					jButtonRecortar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonRecortar.setBounds(79, 380, 115, 23);
					jButtonRecortar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonRecortarActionPerformed(evt);
						}
					});
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
				//evento de coordenadas da tela
				jPanelDesenho.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseMoved(MouseEvent event){
						coordX.setText("X: "+(event.getX()-300));
						coordY.setText("Y: "+(event.getY()-300)*(-1));
					}});
			}
		 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Evento que desenha a reta de acordo com as coordenadas dos TextFields
	 * @param evt
	 */
	private void jButtonDesenharActionPerformed(ActionEvent evt) {
		int X1 = Integer.parseInt(jTextFieldX1.getText());
		int X2 = Integer.parseInt(jTextFieldX2.getText());
		int Y1 = Integer.parseInt(jTextFieldY1.getText());
		int Y2 = Integer.parseInt(jTextFieldY2.getText());
		
			jPanelDesenho.DDA(X1, Y1, X2, Y2);
			retasRecorte = new RetasRecorte(X1, Y1, X2, Y2);
			retas.add(retasRecorte);	
	}
	/**
	 * Evento que limpa a tela de desenho e os TextFields
	 * @param evt
	 */
	private void jButtonLimparActionPerformed(ActionEvent evt) {

		jPanelDesenho.limpar();
		jTextFieldX1.setText("");
		jTextFieldY1.setText("");
		jTextFieldX2.setText("");
		jTextFieldY2.setText("");
	}
	/**
	 * Evento para adicionar coordenadas nos TextFields de acordo com o click
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
	
	/**
	 * Evento do botao Desenhar que pinta a tela de recorte na tela de acordo
	 * com os valores passados pelo usuario
	 * @param evt
	 */
	private void jButtonDesenharJanelaRecorteActionPerformed(ActionEvent evt) {
		Xmin = Integer.parseInt(jTextFieldXmin.getText());
		Xmax = Integer.parseInt(jTextFieldXmax.getText());
		Ymin = Integer.parseInt(jTextFieldYmin.getText());
		Ymax = Integer.parseInt(jTextFieldYmax.getText());
		
		jPanelDesenho.desenhaTelaRecorte(Xmin, Xmax, Ymin, Ymax, Color.RED);
		
	}
	
	/**
	 * Evento do botão Recortar, que executa o algoritmo de recorte
	 * @param evt
	 */
	private void jButtonRecortarActionPerformed(ActionEvent evt) {
		
		AlgoritmoCohenSutherland algRecorte = new AlgoritmoCohenSutherland();
		
		//LIMPA A TELA DE DESENHO
		jPanelDesenho.limpar();
		
		//CHECAR CANDIDATOS A RECORTE E RECORTÁ-LOS
		for (RetasRecorte reta: retas){
				//RECORTANDO OS PONTOS
				algRecorte.recorte(reta.getX1(), reta.getY1(), reta.getX2(), reta.getY2(), Xmin, Xmax, Ymin, Ymax);
				
				//caso a reta esteja fora da zona de recorte...
				if (algRecorte.getNewX1() == 0.0 && algRecorte.getNewY1() == 0.0 && algRecorte.getNewX2() == 0 && algRecorte.getNewY2() == 0){
					//nao faz nada
				}
				else{
					//Atualizar os pontos
					reta.setX1((int)Math.round(algRecorte.getNewX1()));
					reta.setY1((int)Math.round(algRecorte.getNewY1()));
					reta.setX2((int)Math.round(algRecorte.getNewX2()));
					reta.setY2((int)Math.round(algRecorte.getNewY2()));
					
					//Desenha reta atualizada
					jPanelDesenho.DDA(reta.getX1(), reta.getY1(), reta.getX2(), reta.getY2());
				}
		}	
		

		
		//RE-DESENHAR A TELA DE RECORTE
		jPanelDesenho.desenhaTelaRecorte(Xmin, Xmax, Ymin, Ymax, Color.GREEN);
	}

}
