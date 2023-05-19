package View;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

import Model.Config;

public class PanelTabelaTransformacoes3D extends JPanel {
	
	private JTable tabelaDeTransformacoes;
	private String nomeTransformacao;
	private Double x;
	private Double y;
	private Double z;
	
	/**
	 * Create the panel.
	 */
	public PanelTabelaTransformacoes3D() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);
		
		// Adiciona a tabela de vertices
		tabelaDeTransformacoes = new JTable();
		tabelaDeTransformacoes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Transformação", "X", "Y", "Z"
			}
		));
		tabelaDeTransformacoes.setFont(Config.FONTE_TABELA);
		tabelaDeTransformacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaDeTransformacoes.setFillsViewportHeight(true);
		
		// Adiciona o evento do teclado 
		tabelaDeTransformacoes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					if (tabelaDeTransformacoes.getRowCount() != 0) {
						nomeTransformacao = "" + tabelaDeTransformacoes.getValueAt(getLinhaSelecionada(), 0);
						x = Double.parseDouble(""+tabelaDeTransformacoes.getValueAt(getLinhaSelecionada(), 1));
						if (!tabelaDeTransformacoes.getValueAt(getLinhaSelecionada(), 2).equals("-")) {
							y = Double.parseDouble(""+tabelaDeTransformacoes.getValueAt(getLinhaSelecionada(), 2));
							
						} else {
							y = 0.0;
						}
						if (!tabelaDeTransformacoes.getValueAt(getLinhaSelecionada(), 3).equals("-")) {
							z = Double.parseDouble(""+tabelaDeTransformacoes.getValueAt(getLinhaSelecionada(), 3));
							
						} else {
							z = 0.0;
						}
						
						// Remove a linha da tabela de vertices
						removeLinha();
						
						// Atualiza a tela
						updateUI();
						
					}
					
				}
			}

		});
		
		scrollPane.setViewportView(tabelaDeTransformacoes);
		
	}
	
	/**
	 * Retorna a tabela de Vertices
	 * @return
	 */
	public JTable getTabela() {
		return tabelaDeTransformacoes;
	}
	
	/**
	 * Retorna o valor do campo Transformacoes da linha selecionada
	 * @return
	 */
	public String getNomeTransformacao() {
		return nomeTransformacao;
	}

	/**
	 * Retorna o valor do campo X da linha selecionada
	 * @return
	 */
	public Double getValorX() {
		return x;
	}
	
	/**
	 * Retorna o valor do campo Y da linha selecionada
	 * @return
	 */
	public Double getValorY() {
		return y;
	}

	/**
	 * Retorna o valor do campo Z da linha selecionada
	 * @return
	 */
	public Double getValorZ() {
		return z;
	}
	
	/**
	 * Retorna a linha selecionada
	 * @return 
	 */
	public int getLinhaSelecionada() {
		return tabelaDeTransformacoes.getSelectedRow();
	}
	
	/**
	 * Adiciona um novo linha na JTable com os valores dos vertices X e Y
	 * @param x
	 * @param y
	 */
	public void adicionaLinha(String t, double x, double y, double z) {
		// Obtem o modelo da JTable
		DefaultTableModel modelo = (DefaultTableModel)getTabela().getModel();
		
		if (y == 0.0) {
			if (z == 0.0) {
				// Adiciona uma nova linha em branco no modelo  
				modelo.addRow(new String[] {""+ t, ""+ x, "-", "-"});
			} else if (z != 0.0) {
				// Adiciona uma nova linha em branco no modelo  
				modelo.addRow(new String[] {""+ t, ""+ x, "-", ""+ z});
			}
			
		} else {
			// Adiciona uma nova linha em branco no modelo  
			modelo.addRow(new String[] {""+ t, ""+ x, ""+ y, ""+ z});
			
		}
		
	}

	/**
	 * Adiciona um novo linha na JTable com os valores dos vertices X e Y
	 * @param x
	 * @param y
	 */
	public void adicionaLinha(String t, double x) {
		// Obtem o modelo da JTable
		DefaultTableModel modelo = (DefaultTableModel)getTabela().getModel();
		
		modelo.addRow(new String[] {""+ t, ""+ x, "-", "-"});
		
		
	}
	
	/** 
	 * Remove a linha da tabela de vertices. 
	 * @param linha 
	 */  
	public void removeLinha(int linha){  
		// Obtem o modelo da JTable  
		DefaultTableModel modelo = (DefaultTableModel)getTabela().getModel();  
		
		// Remove a linha   
		modelo.removeRow(linha);  
		
	}  
	
	/** 
	 * Obtem a linha selecionada e chama o método para remover do modelo
	 */  
	public void removeLinha(){  
		
		// Obtem a linha selecionada na tabela e chama o método para excluir a linha  
		int linhaSelecionada = getTabela().getSelectedRow();
		
		// Verificamos se existe realmente alguma linha selecionada  
		if( linhaSelecionada < 0 ){  
			return;  
		} else {
			// Remove a linha do modelo  
			removeLinha(linhaSelecionada);  
		}  
		
	}
	
	/**
	 * Limpa a tabela de vertices
	 */
	public void limparTabela() {
		// Limpa a tabela de vertices
		DefaultTableModel modeloTabela =(DefaultTableModel) tabelaDeTransformacoes.getModel();  
		modeloTabela.setNumRows(0);
	}
	
	/** 
	 * Método para subtituir um valor por outro em uma determinada coluna. 
	 * @param oldValue 
	 * @param newValue 
	 * @param column 
	 * @return Numero de substituições 
	 */  
	public int substituirValor(String oldValue, String newValue, int column){  
		// Flag para saber se algum valor foi  
		int total = 0;  
		
		// Obtem o modelo da JTable  
		DefaultTableModel modelo = (DefaultTableModel)getTabela().getModel();  
		
		// Faz um looping em cima das linhas do modelo  
		for( int linha=0; linha<modelo.getRowCount(); linha++){  
			// Obtem o valor atual na coluna  
			String valorAtual = (String)modelo.getValueAt(linha, column);  
			if( valorAtual.equals(oldValue) ){  
				// Substitui pelo novo valor na linha e coluna  
				modelo.setValueAt(newValue, linha, column);  
				
				// Adiciona mais um no numero de linhas atualizadas           
				total++;  
			}  
		}  
		return total;  
	}
	
}