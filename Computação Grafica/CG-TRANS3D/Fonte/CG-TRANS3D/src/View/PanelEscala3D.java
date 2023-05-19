package View;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import Model.Config;
import Model.ValidaTextfieldNumeros;

import java.awt.Insets;

public class PanelEscala3D extends JPanel {
	
	private String nome;
	private JTextField textFieldSx;
	private JTextField textFieldSy;
	private JTextField textFieldSz;
	private JButton btnADD;
	
	/**
	 * Create the panel.
	 */
	public PanelEscala3D() {
		setBackground(Config.COR_BACKGROUND_PANEL);
		
		// Adicionando o nome da transformação
		nome = "Escala";
		
		// Adicionando Campo de Texto de Escala em X
		textFieldSx = new JTextField();
		textFieldSx.setOpaque(false);
		textFieldSx.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSx.setColumns(4);
		textFieldSx.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sx", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldSx);
		
		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldSx.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
		// Adicionando Campo de Texto de Escala em Y
		textFieldSy = new JTextField();
		textFieldSy.setOpaque(false);
		textFieldSy.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSy.setColumns(4);
		textFieldSy.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sy", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldSy);
		
		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldSy.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
		textFieldSz = new JTextField();
		textFieldSz.setOpaque(false);
		textFieldSz.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSz.setColumns(4);
		textFieldSz.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sz", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textFieldSz);
		
		// Define que o textfield só poderar digitar numeros, hifem e virgula 
		((AbstractDocument) textFieldSz.getDocument()).setDocumentFilter(new ValidaTextfieldNumeros(Config.NUM_MAX_CARACTERES, true, false, false, false, ',', '.', '-'));
		
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
	
	public JTextField getTextFieldSx() {
		return textFieldSx;
	}
	
	public JTextField getTextFieldSy() {
		return textFieldSy;
	}
	
	public JTextField getTextFieldSz() {
		return textFieldSz;
	}
	
	public JButton getBtnADD() {
		return btnADD;
	}
	
}
