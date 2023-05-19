package Visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class FrameCisalhamento extends javax.swing.JFrame {
	
	private JButton jButtonAdicionar;
	private JTextField jTextFieldX;
	private JLabel jLabelX;
	private JPanel jPanelPrincipal;
	private JLabel jLabelY;
	private JTextField jTextFieldY;
		
	/**
	 * Retorna Botão Adicionar
	 * @return
	 */
	public JButton getJButtonAdicionar(){
		return this.jButtonAdicionar;
	}
	
	/**
	 * Retorna TextField do fator CisX
	 * @return
	 */
	public JTextField getJTextFieldX(){
		return this.jTextFieldX;
	}
	
	/**
	 * Retorna TextField do fator CisY
	 * @return
	 */
	public JTextField getJTextFieldY(){
		return this.jTextFieldY;
	}

	
	public FrameCisalhamento() {
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
			setTitle("Cisalhamento");
			this.setSize(230, 185);
			
			{
				jPanelPrincipal = new JPanel();
				getContentPane().add(jPanelPrincipal);
				jPanelPrincipal.setBounds(0, 0, 224, 195);
				jPanelPrincipal.setBackground(new java.awt.Color(255,255,255));
				jPanelPrincipal.setLayout(null);
			}
			
			
			{
				jLabelX = new JLabel();
				jPanelPrincipal.add(jLabelX);
				jLabelX.setText("Cisalhamento em X:");
				jLabelX.setFont(new java.awt.Font("Segoe UI",1,11));
				jLabelX.setBounds(23, 33, 120, 15);
			}
			{
				
				{
					jButtonAdicionar = new JButton();
					jPanelPrincipal.add(jButtonAdicionar);		
					jButtonAdicionar.setText("Adicionar");
					jButtonAdicionar.setBackground(new java.awt.Color(255,255,255));
					jButtonAdicionar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jButtonAdicionar.setBounds(67, 114, 88, 18);
				}
				{
					jTextFieldX = new JTextField();
					jPanelPrincipal.add(jTextFieldX);
					jTextFieldX.setBackground(new java.awt.Color(213,232,253));
					jTextFieldX.setToolTipText("Adicione o valor de Cisalhamento");
					jTextFieldX.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldX.setBounds(144, 31, 52, 18);
				}
				{
					jLabelY = new JLabel();
					jPanelPrincipal.add(jLabelY);
					jLabelY.setText("Cisalhamento em Y:");
					jLabelY.setFont(new java.awt.Font("Segoe UI",1,11));
					jLabelY.setBounds(23, 63, 120, 15);
				}
				{
					jTextFieldY = new JTextField();
					jPanelPrincipal.add(jTextFieldY);
					jTextFieldY.setBackground(new java.awt.Color(213,232,253));
					jTextFieldY.setToolTipText("Adicione o valor de Cisalhamento");
					jTextFieldY.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
					jTextFieldY.setBounds(144, 61, 52, 18);
				}

			}
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/**
	 * Limpa os Campos de Texto
	 */
	public void clearCampos(){
		this.jTextFieldX.setText("");
		this.jTextFieldY.setText("");
	}

}
