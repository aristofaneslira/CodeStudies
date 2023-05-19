package Visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class FrameReflexao extends javax.swing.JFrame {
	
	private JButton jButtonAdicionar;
	private JRadioButton jRadioButtonX;
	private JLabel jLabelb;
	private JLabel jLabelM;
	private JTextField jTextFieldb;
	private JTextField jTextFieldm;
	private JRadioButton jRadioButtonY;
	private JRadioButton jRadioButtonOrigem;
	private JRadioButton jRadioButtonReta;
	private JRadioButton jRadioButtonReta2;
	private ButtonGroup bGroup;
	private JLabel jLabelReflexao;
	private JPanel jPanelPrincipal;
		

	/**
	 * Retorna TextField do fator B (Y = Mx+B)
	 * @return
	 */
	public JTextField getjTextFieldb() {
		return jTextFieldb;
	}
	
	/**
	 * Retorna TextField do fator M (Y = Mx+B)
	 * @return
	 */
	public JTextField getjTextFieldm() {
		return jTextFieldm;
	}
	/**
	 * Retorna Botão Adicionar
	 * @return
	 */
	public JButton getJButtonAdicionar(){
		return this.jButtonAdicionar;
	}
	
	/**
	 * Retorna RadioButton 'Reflexão em X'
	 * @return
	 */
	public JRadioButton getJRadioButtonX(){
		return this.jRadioButtonX;
	}
	
	/**
	 * Retorna RadioButton 'Reflexão em Y'
	 * @return
	 */
	public JRadioButton getJRadioButtonY(){
		return this.jRadioButtonY;
	}
	
	/**
	 * Retorna RadioButton 'Reflexão em torno da Origem'
	 * @return
	 */
	public JRadioButton getJRadioButtonOrigem(){
		return this.jRadioButtonOrigem;
	}
	
	/**
	 * Retorna RadioButton 'Reflexão em torno da reta Y=X'
	 * @return
	 */
	public JRadioButton getJRadioButtonReta(){
		return this.jRadioButtonReta;
	}
	
	/**
	 * Retorna RadioButton 'Reflexão em torno da reta Y = Mx+B'
	 * @return
	 */
	public JRadioButton getJRadioButtonReta2(){
		return this.jRadioButtonReta2;
	}
	
	
	public FrameReflexao() {
		super();
		initGUI();
	}
	
	/**
	 * Construtor
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			getContentPane().setLayout(null);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			setTitle("Reflexão");
			this.setSize(235, 314);
			
			{
				jPanelPrincipal = new JPanel();
				getContentPane().add(jPanelPrincipal);
				jPanelPrincipal.setBounds(0, 0, 212, 239);
				jPanelPrincipal.setBackground(new java.awt.Color(255,255,255));
				jPanelPrincipal.setLayout(null);
			}
			{
				jButtonAdicionar = new JButton();
				getContentPane().add(jButtonAdicionar);
				jButtonAdicionar.setText("Adicionar");
				jButtonAdicionar.setBackground(new java.awt.Color(255,255,255));
				jButtonAdicionar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jButtonAdicionar.setBounds(60, 249, 115, 17);
			}
			
			
			{
				jRadioButtonX = new JRadioButton();
				jPanelPrincipal.add(jRadioButtonX);
				jRadioButtonX.setText("X");
				jRadioButtonX.setBounds(31, 40, 164, 20);
				jRadioButtonX.setFont(new java.awt.Font("Segoe UI",0,11));
				jRadioButtonX.setToolTipText("Reflexão em torno do eixo X");
				jRadioButtonX.setBackground(new java.awt.Color(255,255,255));
				jRadioButtonX.setSelected(true);
			}
			{
				jRadioButtonY = new JRadioButton();
				jPanelPrincipal.add(jRadioButtonY);
				jRadioButtonY.setText("Y");
				jRadioButtonY.setBounds(31, 67, 164, 20);
				jRadioButtonY.setToolTipText("Reflexão em torno do eixo Y");
				jRadioButtonY.setFont(new java.awt.Font("Segoe UI",0,11));
				jRadioButtonY.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jRadioButtonOrigem =  new JRadioButton();
				jPanelPrincipal.add(jRadioButtonOrigem);
				jRadioButtonOrigem.setText("Origem");
				jRadioButtonOrigem.setToolTipText("Reflexão em torno da Origem");
				jRadioButtonOrigem.setBounds(31, 94, 164, 20);
				jRadioButtonOrigem.setFont(new java.awt.Font("Segoe UI",0,11));
				jRadioButtonOrigem.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jRadioButtonReta =  new JRadioButton();
				jPanelPrincipal.add(jRadioButtonReta);
				jRadioButtonReta.setText("Y = X");
				jRadioButtonReta.setToolTipText("Reflexão em torno da Reta Y = X");
				jRadioButtonReta.setBounds(31, 121, 164, 20);
				jRadioButtonReta.setFont(new java.awt.Font("Segoe UI",0,11));
				jRadioButtonReta.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jRadioButtonReta2 =  new JRadioButton();
				jPanelPrincipal.add(jRadioButtonReta2);
				jRadioButtonReta2.setText("Y = mx + b");
				jRadioButtonReta2.setToolTipText("Reflexão em torno da Reta Y = mx + b");
				jRadioButtonReta2.setBounds(31, 148, 164, 20);
				jRadioButtonReta2.setFont(new java.awt.Font("Segoe UI",0,11));
				jRadioButtonReta2.setBackground(new java.awt.Color(255,255,255));
			}
			{	bGroup = new ButtonGroup();
				bGroup.add(jRadioButtonX);
				jRadioButtonX.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRadioButtonXActionPerformed(evt);
					}
				});
				bGroup.add(jRadioButtonY);
				jRadioButtonY.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRadioButtonYActionPerformed(evt);
					}
				});
				bGroup.add(jRadioButtonOrigem);
				jRadioButtonOrigem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRadioButtonOrigemActionPerformed(evt);
					}
				});
				bGroup.add(jRadioButtonReta);
				jRadioButtonReta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRadioButtonRetaActionPerformed(evt);
					}
				});
				bGroup.add(jRadioButtonReta2);
				jRadioButtonReta2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRadioButtonReta2ActionPerformed(evt);
					}
				});
			}
			{
				jLabelReflexao = new JLabel();
				jPanelPrincipal.add(jLabelReflexao);
				jLabelReflexao.setText("Tipos de Reflexão");
				jLabelReflexao.setFont(new java.awt.Font("Tahoma",1,12));
				jLabelReflexao.setBounds(13, 15, 145, 14);
			}
			{
				jTextFieldm = new JTextField();
				jPanelPrincipal.add(jTextFieldm);
				jTextFieldm.setText("");
				jTextFieldm.setToolTipText("Valor de Escala em X");
				jTextFieldm.setBackground(new java.awt.Color(240,240,240));
				jTextFieldm.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jTextFieldm.setBounds(84, 181, 60, 20);
				jTextFieldm.setEnabled(false);
			}
			{
				jTextFieldb = new JTextField();
				jPanelPrincipal.add(jTextFieldb);
				jTextFieldb.setText("");
				jTextFieldb.setToolTipText("Valor de Escala em X");
				jTextFieldb.setBackground(new java.awt.Color(240,240,240));
				jTextFieldb.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jTextFieldb.setBounds(84, 207, 60, 20);
				jTextFieldb.setEnabled(false);
			}
			{
				jLabelM = new JLabel();
				jPanelPrincipal.add(jLabelM);
				jLabelM.setText("m:");
				jLabelM.setBounds(63, 182, 14, 16);
				jLabelM.setEnabled(false);
			}
			{
				jLabelb = new JLabel();
				jPanelPrincipal.add(jLabelb);
				jLabelb.setText("b:");
				jLabelb.setBounds(67, 210, 14, 16);
				jLabelb.setEnabled(false);
			}

		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/**
	 * Limpa Campos de Texto
	 */
	public void clearCampos(){
		jTextFieldm.setText("");
		jTextFieldb.setText("");
	}
	
	/**
	 * Desabilita campos da reflexão em torno da reta Y=Mx+B
	 */
	public void desabilitarCampos(){
		jLabelM.setEnabled(false);
		jLabelb.setEnabled(false);
		jTextFieldm.setEnabled(false);
		jTextFieldm.setBackground(new java.awt.Color(240,240,240));
		jTextFieldb.setEnabled(false);
		jTextFieldb.setBackground(new java.awt.Color(240,240,240));
	}
	
	/**
	 * Habilita campos da reflexão em torno da reta Y=Mx+B
	 */
	public void habilitarCampos(){
		jLabelM.setEnabled(true);
		jLabelb.setEnabled(true);
		jTextFieldm.setEnabled(true);
		jTextFieldm.setBackground(new java.awt.Color(213,232,253));
		jTextFieldb.setEnabled(true);
		jTextFieldb.setBackground(new java.awt.Color(213,232,253));
	}
	
	/**
	 * Evento do RadioButton 'Y=Mx+B' que habilita campos de fatores M e B
	 * @param evt
	 */
	private void jRadioButtonReta2ActionPerformed(ActionEvent evt) {
		habilitarCampos();
		
	}
	
	/**
	 * Evento do RadioButton 'X' que desabilita campos de fatores da reflexão 'Y=Mx+B'
	 * @param evt
	 */
	private void jRadioButtonXActionPerformed(ActionEvent evt) {
		desabilitarCampos();
	}
	
	/**
	 *  Evento do RadioButton 'Y' que desabilita campos de fatores da reflexão 'Y=Mx+B'
	 * @param evt
	 */
	private void jRadioButtonYActionPerformed(ActionEvent evt) {
		desabilitarCampos();
	}
	
	/**
	 *  Evento do RadioButton 'Origem' que desabilita campos de fatores da reflexão 'Y=Mx+B'
	 * @param evt
	 */
	private void jRadioButtonOrigemActionPerformed(ActionEvent evt) {
		desabilitarCampos();
	}
	
	/**
	 *  Evento do RadioButton 'Y=X' que desabilita campos de fatores da reflexão 'Y=Mx+B'
	 * @param evt
	 */
	private void jRadioButtonRetaActionPerformed(ActionEvent evt) {
		desabilitarCampos();
	}
	
	

}
