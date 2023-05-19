package Visao;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class FrameTranslacao extends javax.swing.JFrame {
	
	private JLabel jLabelX;
	private JLabel jLabelY;
	private JLabel jLabelCoordenadas;
	private JTextField jTextFieldX;
	private JTextField jTextFieldY;
	private JButton jButtonAdicionar;
	private JPanel jPanelPrincipal;

	
	/**
	 * Retorna Bot�o Adicionar
	 * @return
	 */
	public JButton getJButtonAdicionar(){
		return this.jButtonAdicionar;
	}
	
	/**
	 * Retorna TextField do fator Tx
	 * @return
	 */
	public JTextField getJTextFieldX(){
		return this.jTextFieldX;
	}
	/**
	 * Retorna TextField do fator Ty
	 * @return
	 */
	public JTextField getJTextFieldY(){
		return this.jTextFieldY;
	}
	
	public FrameTranslacao() {
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
			setTitle("Transla��o");
			this.setSize(235, 175);
			
			
			{
				jPanelPrincipal = new JPanel();
				getContentPane().add(jPanelPrincipal);
				jPanelPrincipal.setBounds(0, 0, 223, 153);
				jPanelPrincipal.setBackground(new java.awt.Color(255,255,255));
				jPanelPrincipal.setLayout(null);
			}
			{
				jLabelX = new JLabel("X:");
				jPanelPrincipal.add(jLabelX);
				jLabelX.setFont(new java.awt.Font("Segoe UI",1,11));
				jLabelX.setBounds(27, 64, 16, 16);
			}
			{
				jTextFieldX = new JTextField();
				jPanelPrincipal.add(jTextFieldX);
				jTextFieldX.setBackground(new java.awt.Color(213,232,253));
				jTextFieldX.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jTextFieldX.setToolTipText("Valor de Transla��o em X");
				jTextFieldX.setBounds(44, 61, 60, 22);	
			}
			{
				jLabelY = new JLabel();
				jPanelPrincipal.add(jLabelY);
				jLabelY.setText("Y:");
				jLabelY.setFont(new java.awt.Font("Segoe UI",1,11));
				jLabelY.setBounds(121, 64, 16, 16);
			}
			{
				jTextFieldY = new JTextField();
				jPanelPrincipal.add(jTextFieldY);
				jTextFieldY.setBackground(new java.awt.Color(213,232,253));
				jTextFieldY.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jTextFieldY.setToolTipText("Valor de Transla��o em Y");
				jTextFieldY.setBounds(137, 61, 60, 22);
			}
			{
				jLabelCoordenadas = new JLabel();
				jPanelPrincipal.add(jLabelCoordenadas);
				jLabelCoordenadas.setText("Coordenadas:");
				jLabelCoordenadas.setFont(new java.awt.Font("Tahoma",1,12));
				jLabelCoordenadas.setBounds(12, 26, 119, 14);
			}
			{
				jButtonAdicionar = new JButton();
				jPanelPrincipal.add(jButtonAdicionar);
				jButtonAdicionar.setText("Adicionar");
				jButtonAdicionar.setBackground(new java.awt.Color(255,255,255));
				jButtonAdicionar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jButtonAdicionar.setBounds(70, 109, 88, 18);
			}
			

			
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/**
	 * Limpa Campos dos fatores Tx e Ty
	 */
	public void clearCampos(){
		this.jTextFieldX.setText("");
		this.jTextFieldY.setText("");
	}

}
