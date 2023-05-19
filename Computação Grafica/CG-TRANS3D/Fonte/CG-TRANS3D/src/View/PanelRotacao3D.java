package View;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument;

import Model.Config;
import Model.ValidaTextfieldNumeros;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class PanelRotacao3D extends JPanel {
	
	private String nome;
	private JTextField textFieldAngulo;
	private JButton btnADD;
	private JComboBox<String> comboBoxRotacao;
	
	/**
	 * Create the panel.
	 */
	public PanelRotacao3D() {
		setBackground(Config.COR_BACKGROUND_PANEL);
		
		// Adicionando o nome da transformação
		nome = "Rotação";
		
		// Adicionando Campo de Texto de Escala em X
		textFieldAngulo = new JTextField();
		textFieldAngulo.setMargin(new Insets(2, 3, 2, 3));
		textFieldAngulo.setOpaque(false);
		textFieldAngulo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAngulo.setColumns(3);
		textFieldAngulo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0398", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldAngulo);
		
		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldAngulo.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
		comboBoxRotacao = new JComboBox<String>();
		comboBoxRotacao.setModel(new DefaultComboBoxModel<String>(new String[] {"Em Torno de X", "Em Torno de Y", "Em Torno de Z"}));
		comboBoxRotacao.setPreferredSize(new Dimension(118, 30));
		comboBoxRotacao.setFont(Config.FONTE_COMBO_BOX_REFLEXAO);
		comboBoxRotacao.setBorder(new EmptyBorder(1, 1, 1, 1));
		comboBoxRotacao.setBackground(Config.COR_BACKGROUND_COMBO_BOX);
		add(comboBoxRotacao);
		
		// Adicionando Botão ok
		btnADD = new JButton("Add");
		btnADD.setBackground(Config.COR_BOTAO_BACKGROUND2);
		btnADD.setFont(Config.FONTE_BOTAO);
		btnADD.setMargin(new Insets(2, 5, 2, 5));
		add(btnADD);
		
	}

	public String getNome() {
		return nome;
	}
	
	public JComboBox<String> getComboBoxRotacao() {
		return comboBoxRotacao;
	}

	public JTextField getTextFieldAngulo() {
		return textFieldAngulo;
	}
	
	public JButton getBtnADD() {
		return btnADD;
	}
	
}
