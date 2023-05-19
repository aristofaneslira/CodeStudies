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

public class PanelTabelaVertices3D extends JPanel {
	
	private JTable tabelaDeVertices;
	private int x;
	private int y;
	private int z;
	private int w;
	
	/**
	 * Create the panel.
	 */
	public PanelTabelaVertices3D() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);
		
		// Adiciona a tabela de vertices
		tabelaDeVertices = new JTable();
		tabelaDeVertices.setFont(Config.FONTE_TABELA);
		tabelaDeVertices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaDeVertices.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"X", "Y", "Z", "W"
			}
		));
		tabelaDeVertices.setFillsViewportHeight(true);
		
		// Adiciona o evento do teclado 
		tabelaDeVertices.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					if (tabelaDeVertices.getRowCount() != 0) {
						x = Integer.parseInt(""+tabelaDeVertices.getValueAt(getLinhaSelecionada(), 0));
						y = Integer.parseInt(""+tabelaDeVertices.getValueAt(getLinhaSelecionada(), 1));
						z = Integer.parseInt(""+tabelaDeVertices.getValueAt(getLinhaSelecionada(), 2));
						w = Integer.parseInt(""+tabelaDeVertices.getValueAt(getLinhaSelecionada(), 3));
						
						// Remove a linha da tabela de vertices
						//removeLinha();
						
						// Atualiza a tela
						updateUI();
						
					}
					
				}
			}
		});
		
		scrollPane.setViewportView(tabelaDeVertices);
		
	}
	
	/**
	 * Retorna a tabela de Vertices
	 * @return
	 */
	public JTable getTabela() {
		return tabelaDeVertices;
	}
	
	/**
	 * Retorna o valor do campo X da linha selecionada
	 * @return
	 */
	public int getValorX() {
		return x;
	}
	
	/**
	 * Retorna o valor do campo Y da linha selecionada
	 * @return
	 */
	public int getValorY() {
		return y;
	}

	/**
	 * Retorna o valor do campo Z da linha selecionada
	 * @return
	 */
	public int getValorZ() {
		return z;
	}
	
	/**
	 * Retorna o valor do campo W da linha selecionada
	 * @return
	 */
	public int getValorW() {
		return w;
	}
	
	/**
	 * Retorna a linha selecionada
	 * @return 
	 */
	public int getLinhaSelecionada() {
		return tabelaDeVertices.getSelectedRow();
	}
	
	/**
	 * Adiciona um novo linha na JTable com os valores dos vertices X e Y
	 * @param x
	 * @param y
	 */
	public void adicionaLinha(int x, int y, int z, int w) {
		// Obtem o modelo da JTable
		DefaultTableModel modelo = (DefaultTableModel)getTabela().getModel();
		
		// Adiciona uma nova linha em branco no modelo  
		modelo.addRow(new String[] {""+ x, ""+ y, ""+ z, ""+ w});
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
		DefaultTableModel modeloTabela =(DefaultTableModel) tabelaDeVertices.getModel();  
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