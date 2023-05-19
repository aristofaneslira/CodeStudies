package Visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class FrameAddVertice extends javax.swing.JFrame {
	
	private JLabel jLabelX;
	private JLabel jLabelY;
	private JTextField jTextFieldX;
	private JTextField jTextFieldY;
	private JButton jButtonAdicionar;
	private JPanel jPanelPrincipal;

	/**
	 * Retorna o botão de adição
	 * @return
	 */
	public JButton getJButtonAdicionar(){
		return this.jButtonAdicionar;
	}
	
	/**
	 * Retorna o TextField da coordenada X
	 * @return
	 */
	public JTextField getJTextFieldX(){
		return this.jTextFieldX;
	}
	
	/**
	 * Retorna o TextField da coordenada Y
	 * @return
	 */
	public JTextField getJTextFieldY(){
		return this.jTextFieldY;
	}
	
	
	public FrameAddVertice() {
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
			setTitle("Vértice");
			this.setSize(220, 130);
			
			{
				jPanelPrincipal = new JPanel();
				getContentPane().add(jPanelPrincipal);
				jPanelPrincipal.setBounds(0, 0, 211, 102);
				jPanelPrincipal.setBackground(new java.awt.Color(255,255,255));
				jPanelPrincipal.setLayout(null);
			}
			{
				jLabelX = new JLabel("X:");
				jPanelPrincipal.add(jLabelX);
				jLabelX.setFont(new java.awt.Font("Segoe UI",1,11));
				jLabelX.setBounds(20, 23, 16, 16);
			}
			{
				jTextFieldX = new JTextField();
				jPanelPrincipal.add(jTextFieldX);
				jTextFieldX.setBackground(new java.awt.Color(213,232,253));
				jTextFieldX.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jTextFieldX.setToolTipText("Coordenada do Vértice no eixo X");
				jTextFieldX.setBounds(36, 21, 60, 22);	
			}
			{
				jLabelY = new JLabel();
				jPanelPrincipal.add(jLabelY);
				jLabelY.setText("Y:");
				jLabelY.setFont(new java.awt.Font("Segoe UI",1,11));
				jLabelY.setBounds(114, 24, 16, 16);
			}
			{
				jTextFieldY = new JTextField();
				jPanelPrincipal.add(jTextFieldY);
				jTextFieldY.setBackground(new java.awt.Color(213,232,253));
				jTextFieldY.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jTextFieldY.setToolTipText("Coordenada do Vértice no eixo Y");
				jTextFieldY.setBounds(130, 21, 60, 22);
			}
			{
				jButtonAdicionar = new JButton();
				jPanelPrincipal.add(jButtonAdicionar);
				jButtonAdicionar.setText("Add");
				jButtonAdicionar.setBackground(new java.awt.Color(255,255,255));
				jButtonAdicionar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jButtonAdicionar.setBounds(130, 65, 60, 18);
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
		this.jTextFieldX.setText("");
		this.jTextFieldY.setText("");
	}

}
