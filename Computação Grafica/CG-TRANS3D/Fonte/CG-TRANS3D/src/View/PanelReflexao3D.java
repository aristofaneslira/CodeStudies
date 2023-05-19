package View;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;

import Model.Config;

public class PanelReflexao3D extends JPanel {
	
	private String nome;
	private JComboBox<String> comboBoxReflexao;
	private JButton btnADD;
	
	/**
	 * Create the panel.
	 */
	public PanelReflexao3D() {
		setBackground(Config.COR_BACKGROUND_PANEL);
		
		// Adicionando o nome da transformação
		nome = "Reflexão";
		
		// Adicionando ComboBox
		comboBoxReflexao = new JComboBox<String>();
		comboBoxReflexao.setBackground(Config.COR_BACKGROUND_COMBO_BOX);
		comboBoxReflexao.setBorder(new EmptyBorder(1, 1, 1, 1));
		comboBoxReflexao.setFont(Config.FONTE_COMBO_BOX_REFLEXAO);
		comboBoxReflexao.setModel(new DefaultComboBoxModel<String>(new String[] {"Em torno do plano XY", "Em torno do plano YZ", "Em Torno do plano ZX"}));
		add(comboBoxReflexao);
		
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
	
	public JComboBox<String> getComboBoxReflexao() {
		return comboBoxReflexao;
	}
	
	public JButton getBtnADD() {
		return btnADD;
	}
	
}
