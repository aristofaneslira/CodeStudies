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

public class PanelTranslacao3D extends JPanel {
	
	private String nome;
	private JTextField textFieldTx;
	private JTextField textFieldTy;
	private JButton btnADD;
	private JTextField textFieldTz;
	
	/**
	 * Create the panel.
	 */
	public PanelTranslacao3D() {
		//setBorder(new TitledBorder(new LineBorder(Config.COR_BORDA_PANEL, 3), "Transla\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Config.COR_BACKGROUND_PANEL);
		
		// Adicionando o nome da transformação
		nome = "Translação";
		
		// Adicionando Campo de Texto de Escala em X
		textFieldTx = new JTextField();
		textFieldTx.setOpaque(false);
		textFieldTx.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTx.setColumns(4);
		textFieldTx.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tx", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldTx);

		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldTx.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
		// Adicionando Campo de Texto de Escala em Y
		textFieldTy = new JTextField();
		textFieldTy.setOpaque(false);
		textFieldTy.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTy.setColumns(4);
		textFieldTy.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ty", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldTy);
		
		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldTy.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
		textFieldTz = new JTextField();
		textFieldTz.setOpaque(false);
		textFieldTz.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTz.setColumns(4);
		textFieldTz.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tz", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldTz);
		
		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldTz.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
		// Adicionando Botão ok
		btnADD = new JButton("Add");
		btnADD.setBackground(Config.COR_BACKGROUND_TELA);
		btnADD.setFont(Config.FONTE_BOTAO);
		btnADD.setMargin(new Insets(2, 5, 2, 5));
		add(btnADD);
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public JTextField getTextFieldTx() {
		return textFieldTx;
	}

	public JTextField getTextFieldTy() {
		return textFieldTy;
	}
	
	public JTextField getTextFieldTz() {
		return textFieldTz;
	}
	
	public JButton getBtnADD() {
		return btnADD;
	}
	
}
