package Visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class FrameRotacao extends javax.swing.JFrame {
	
	private JLabel jLabelAngulo;
	private JTextField jTextFieldAngulo;
	private JPanel jPanelPrincipal;
	private JButton jButtonAdicionar;

	/**
	 * Retorna Botão Adicionar
	 * @return
	 */
	public JButton getJButtonAdicionar(){
		return this.jButtonAdicionar;
	}
	
	/**
	 * Retorna TextField do Angulo de rotação
	 * @return
	 */
	public JTextField getJTextFieldAngulo(){
		return this.jTextFieldAngulo;
	}
	
	
	public FrameRotacao() {
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
			setTitle("Rotação");
			this.setSize(235, 145);
			
			{
				jPanelPrincipal = new JPanel();
				getContentPane().add(jPanelPrincipal);
				jPanelPrincipal.setBounds(0, 0, 232, 122);
				jPanelPrincipal.setBackground(new java.awt.Color(255,255,255));
				jPanelPrincipal.setLayout(null);
			}
			{
				jLabelAngulo = new JLabel("Ângulo:");
				jLabelAngulo.setBounds(57, 28, 52, 14);
				jLabelAngulo.setFont(new java.awt.Font("Segoe UI",1,11));
				jPanelPrincipal.add(jLabelAngulo);
			}
			{
				jTextFieldAngulo = new JTextField();
				jTextFieldAngulo.setBounds(110, 24, 60, 22);
				jTextFieldAngulo.setToolTipText("Adicione o Ângulo de Rotação");
				jTextFieldAngulo.setBackground(new java.awt.Color(213,232,253));
				jTextFieldAngulo.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jPanelPrincipal.add(jTextFieldAngulo);
			}
			{
				jButtonAdicionar = new JButton();
				jPanelPrincipal.add(jButtonAdicionar);
				jButtonAdicionar.setText("Adicionar");
				jButtonAdicionar.setBackground(new java.awt.Color(255,255,255));
				jButtonAdicionar.setBorder(new LineBorder(new java.awt.Color(0,0,0),1,false));
				jButtonAdicionar.setBounds(69, 70, 88, 18);
			}

			
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Limpa campo do angulo
	 */
	public void clearCampos(){
		this.jTextFieldAngulo.setText("");
	}

}
