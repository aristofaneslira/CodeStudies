package Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.border.LineBorder;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


@SuppressWarnings({"serial","rawtypes"})
public class PanelCircunferencias extends javax.swing.JPanel {
	private JPanel jPanelMenuLateral;
	private TelaDesenho jPanelDesenho;
	private JButton jButtonLimpar;
	private JButton jButtonDesenhar;
	private JLabel jLabelRaio1;
	private JTextField jTextFieldElipseLargura;
	private JTextField jTextFieldElipseAltura;
	private JLabel jLabelElipseLargura;
	private JLabel jLabelElipseAltura;
	private JComboBox jComboBoxTipoCirc;
	private static JLabel coordX;
	private static JLabel coordY;
	private JSeparator jSeparator1;
	private JLabel jLabelDDA;
	private JTextField jTextFieldRaio;
	private JSeparator jSeparator3;
	private JSeparator jSeparator2;


	public PanelCircunferencias() {
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
					jLabelRaio1 = new JLabel();
					jPanelMenuLateral.add(jLabelRaio1);
					jLabelRaio1.setText("Raio:");
					jLabelRaio1.setBounds(85, 66, 28, 16);
					jLabelRaio1.setFont(new java.awt.Font("Segoe UI",1,11));
				}
				{
					jButtonDesenhar = new JButton();
					jPanelMenuLateral.add(jButtonDesenhar);
					jButtonDesenhar.setText("Desenhar");
					jButtonDesenhar.setBounds(78, 207, 115, 23);
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
					jButtonLimpar.setBounds(78, 236, 115, 23);
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
					jLabelDDA.setText("Circunferência/Elipse");
					jLabelDDA.setBounds(80, 14, 137, 20);
					jLabelDDA.setFont(new java.awt.Font("Segoe UI",1,12));
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
					jSeparator3.setBounds(9, 189, 256, 12);
				}
				{
					jTextFieldRaio = new JTextField();
					jPanelMenuLateral.add(jTextFieldRaio);
					jTextFieldRaio.setText("");
					jTextFieldRaio.setBackground(new java.awt.Color(213,232,253));
					jTextFieldRaio.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldRaio.setToolTipText("Digite o Raio");
					jTextFieldRaio.setBounds(119, 65, 53, 20);
				}
				{
					ComboBoxModel jComboBoxTipoCircModel = 
							new DefaultComboBoxModel(
									new String[] { "","Ponto Médio", "Equação Explícita", "Método Trigonométrico", "Elipse" });
					jComboBoxTipoCirc = new JComboBox();
					jPanelMenuLateral.add(jComboBoxTipoCirc);
					jComboBoxTipoCirc.setModel(jComboBoxTipoCircModel);
					jComboBoxTipoCirc.setBounds(53, 105, 167, 23);
					jComboBoxTipoCirc.setBackground(new java.awt.Color(255,255,255));
					jComboBoxTipoCirc.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jComboBoxTipoCircActionPerformed(evt);
						}
					});
				}
				{
					jLabelElipseAltura = new JLabel();
					jPanelMenuLateral.add(jLabelElipseAltura);
					jLabelElipseAltura.setText("Altura:");
					jLabelElipseAltura.setBounds(148, 149, 39, 16);
					jLabelElipseAltura.setVisible(false);
				}
				{
					jTextFieldElipseAltura = new JTextField();
					jPanelMenuLateral.add(jTextFieldElipseAltura);
					jTextFieldElipseAltura.setBounds(186, 147, 29, 20);
					jTextFieldElipseAltura.setVisible(false);
				}
				{
					jLabelElipseLargura = new JLabel();
					jPanelMenuLateral.add(jLabelElipseLargura);
					jLabelElipseLargura.setText("Largura: ");
					jLabelElipseLargura.setBounds(56, 149, 46, 16);
					jLabelElipseLargura.setVisible(false);
				}
				{
					jTextFieldElipseLargura = new JTextField();
					jPanelMenuLateral.add(jTextFieldElipseLargura);
					jTextFieldElipseLargura.setBounds(103, 147, 29, 20);
					jTextFieldElipseLargura.setVisible(false);
				}

			}
			{
				jPanelDesenho = new TelaDesenho();
				this.add(jPanelDesenho);
				jPanelDesenho.setBounds(279, 5, 602, 602);
				jPanelDesenho.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				jPanelDesenho.setBackground(new java.awt.Color(255,255,255));
				
			}
			
			{

				
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
	 * Ativa componentes referente ao algoritmo da elipse
	 */
	public void ativarComponentesElipse(){
		jLabelElipseAltura.setVisible(true);
		jLabelElipseLargura.setVisible(true);
		jTextFieldElipseAltura.setVisible(true);
		jTextFieldElipseLargura.setVisible(true);
	}
	
	/**
	 * Desativa as componentes referente ao algoritmo da elipse
	 */
	public void desativarComponentesElipse(){
		jLabelElipseAltura.setVisible(false);
		jLabelElipseLargura.setVisible(false);
		jTextFieldElipseAltura.setVisible(false);
		jTextFieldElipseAltura.setText("");
		jTextFieldElipseLargura.setVisible(false);
		jTextFieldElipseLargura.setText("");
	}
	
	
	/**
	 * Evento que desenha a circunferencia de acordo com o algoritmo escolhido
	 * @param evt
	 */
	private void jButtonDesenharActionPerformed(ActionEvent evt) {
		
		int raio;
		//Ponto Medio
		if (jComboBoxTipoCirc.getSelectedItem().equals("Ponto Médio")){
			raio = Integer.parseInt(jTextFieldRaio.getText());
			jPanelDesenho.MidPointCirc(300, 300, raio);
			

		}
		//Equação Explícita
		else if (jComboBoxTipoCirc.getSelectedItem().equals("Equação Explícita")){
			raio = Integer.parseInt(jTextFieldRaio.getText());
			jPanelDesenho.EqExplicitaCirc(raio);
		}
		//Método Trigonométrico
		else if (jComboBoxTipoCirc.getSelectedItem().equals("Método Trigonométrico")){
			raio = Integer.parseInt(jTextFieldRaio.getText());
			jPanelDesenho.CircMetodoTrigonometrico(300, 300, raio);
		}
		//Elipse
		else if (jComboBoxTipoCirc.getSelectedItem().equals("Elipse")){
			int largura = Integer.parseInt(jTextFieldElipseLargura.getText());
			int altura = Integer.parseInt(jTextFieldElipseAltura.getText());
			jPanelDesenho.Elipse(largura, altura);
		}
	}
	/**
	 * Evento que limpa a tela de desenho e o TextField
	 * @param evt
	 */
	private void jButtonLimparActionPerformed(ActionEvent evt) {

		jPanelDesenho.limpar();
		jTextFieldRaio.setText("");

	}
	
	/**
	 * Evento do JComboBox que ativa/desativa as componentes da Elipse
	 * @param evt
	 */
	private void jComboBoxTipoCircActionPerformed(ActionEvent evt) {
		if (jComboBoxTipoCirc.getSelectedItem().equals("Elipse")) {
			ativarComponentesElipse();
		}
		else {
			desativarComponentesElipse();
		}
	}

}
