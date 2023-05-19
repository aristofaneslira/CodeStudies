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
import javax.swing.DefaultComboBoxModel;

public class PanelCisalhamento3D extends JPanel {
	
	private String nome;
	private JComboBox<String> comboBoxCisalhamento;
	private JTextField textFieldShX;
	private JTextField textFieldShY;
	private JButton btnADD;
	
	/**
	 * Create the panel.
	 */
	public PanelCisalhamento3D() {
		setBackground(Config.COR_BACKGROUND_PANEL);
		
		// Adicionando o nome da transformação
		nome = "Cisalhamento";
		
		comboBoxCisalhamento = new JComboBox<String>();
		comboBoxCisalhamento.setModel(new DefaultComboBoxModel<String>(new String[] {"Em X", "Em Y", "Em Z"}));
		comboBoxCisalhamento.setFont(Config.FONTE_COMBO_BOX);
		comboBoxCisalhamento.setBorder(new EmptyBorder(1, 1, 1, 1));
		comboBoxCisalhamento.setBackground(Config.COR_BACKGROUND_COMBO_BOX);
		add(comboBoxCisalhamento);
		
		// Adicionando Campo de Texto de Escala em X
		textFieldShX = new JTextField();
		textFieldShX.setOpaque(false);
		textFieldShX.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShX.setColumns(4);
		textFieldShX.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ShX", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldShX);

		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldShX.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
		// Adicionando Campo de Texto de Escala em Y
		textFieldShY = new JTextField();
		textFieldShY.setOpaque(false);
		textFieldShY.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldShY.setColumns(4);
		textFieldShY.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ShY", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldShY);

		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldShY.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
		// Adicionando Botão ok
		btnADD = new JButton("Add");
		btnADD.setBackground(Config.COR_BOTAO_BACKGROUND2);
		btnADD.setFont(Config.FONTE_BOTAO);
		btnADD.setMargin(new Insets(2, 5, 2, 5));
		add(btnADD);
		
	}
	
	public JComboBox<String> getComboBoxCisalhamento() {
		return comboBoxCisalhamento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public JTextField getTextFieldShX() {
		return textFieldShX;
	}

	public JTextField getTextFieldShY() {
		return textFieldShY;
	}

	public JButton getBtnADD() {
		return btnADD;
	}
	
}
