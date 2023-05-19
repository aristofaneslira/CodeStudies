import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



public class FramePrincipal extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JMenu jMenuOpcoes;
	private JMenuItem jMenuItemGamma;
	private JMenu jMenuGato;
	private JMenu jMenuHistograma;
	private JMenu jMenuTransformacoes;
	private JMenu jMenuOperações;
	private JMenu jMenuFiltros;
	private JMenuBar jMenuBar;
	private PanelGatoDeArnold panelGato = new PanelGatoDeArnold();
	private JMenuItem jMenuItemSair;
	private JMenuItem jMenuItemPrincipal;
	private PanelPrincipal panelPrincipal = new PanelPrincipal();
	private JMenu jMenuOpGeometricas;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FramePrincipal inst = new FramePrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FramePrincipal() {
		super();
		initGUI();
	}
	
	/**
	 * Construtor
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			getContentPane().setLayout(null);
			this.setContentPane(panelPrincipal);
			panelPrincipal.setBounds(0, 21, 600, 400);
			this.setResizable(false);
			this.setTitle("CG");
			this.setBackground(Color.WHITE);
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jMenuOpcoes = new JMenu();
//					jMenuBar.add(jMenuOpcoes);
//					jMenuOpcoes.setText("Opções");
					{
						jMenuItemPrincipal = new JMenuItem();
						jMenuOpcoes.add(jMenuItemPrincipal);
						jMenuItemPrincipal.setText("Principal");
						jMenuItemPrincipal.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemPrincipalActionPerformed(evt);
							}
						});
					}
					{
						jMenuItemSair = new JMenuItem();
						jMenuOpcoes.add(jMenuItemSair);
						jMenuItemSair.setText("Sair");
						jMenuItemSair.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
//								jMenuItemSairActionPerformed(evt);
							}
						});
					}
				}
				{
					jMenuFiltros = new JMenu();
					jMenuBar.add(jMenuFiltros);
					jMenuFiltros.setText("FILTROS DE IMAGEM");
					jMenuFiltros.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jMenuFiltrosMouseClicked(evt);
						}
					});
				}
				{
					jMenuOperações = new JMenu();
					jMenuBar.add(jMenuOperações);
					jMenuOperações.setText("OPERADORES");
					jMenuOperações.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jMenuOperaçõesMouseClicked(evt);
						}
					});
				}
				{
					jMenuTransformacoes = new JMenu();
					jMenuBar.add(jMenuTransformacoes);
					jMenuTransformacoes.setText("TRANSFORMACOES");
					jMenuTransformacoes.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jMenuTransformacoesMouseClicked(evt);
						}
					});
				}
				{
					jMenuHistograma = new JMenu();
					jMenuBar.add(jMenuHistograma);
					jMenuHistograma.setText("EQ DE HISTOGRAMA");
					jMenuHistograma.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jMenuHistogramaMouseClicked(evt);
						}
					});
				}
				{
					jMenuGato = new JMenu();
					jMenuBar.add(jMenuGato);
					jMenuGato.setText("GATO ARNOLD");
					jMenuGato.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jMenuGatoMouseClicked(evt);
						}
					});
				}
				{
					jMenuOpGeometricas = new JMenu();
					jMenuBar.add(jMenuOpGeometricas);
					jMenuOpGeometricas.setText("OPERACOES GEOMETRICAS");
					jMenuOpGeometricas.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jMenuOpGeometricasMouseClicked(evt);
						}
					});
				}
				{
					this.addWindowListener(new WindowAdapter(){  
			            public void windowClosing(WindowEvent e) {  
//			                int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja sair?", "Sair",JOptionPane.YES_NO_OPTION);  
//			                if (i == JOptionPane.YES_OPTION) {  
			                	closeThreads();
			                    System.exit(0);  
//			                } else {  
//			                    repaint();  
//			                }  
			            }  
			        });
				}
			}
			{
		
		
				
			}
			pack();
			this.setSize(900, 679);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/**
	 * Fecha threads do gato de arnold
	 */
	@SuppressWarnings("deprecation")
	public void closeThreads(){
		//Threads do gato de arnold
		try {
			panelGato.t.interrupt();
			panelGato.time.interrupt();
			panelGato.miau.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

	/**
	 * Menu superior "Filtros"
	 * @param evt
	 */
	private void jMenuFiltrosMouseClicked(MouseEvent evt) {
		PanelFiltros panelMedia = new PanelFiltros();
		this.setContentPane(panelMedia);
		panelMedia.setBounds(0, 21, 900, 700);
		this.setTitle("FILTROS DE IMAGEM");
	}
	
	/**
	 * Menu superior "Operadores"
	 * @param evt
	 */
	private void jMenuOperaçõesMouseClicked(MouseEvent evt) {
		PanelOperadores panelOperacoes = new PanelOperadores();
		this.setContentPane(panelOperacoes);
		panelOperacoes.setBounds(0, 21, 900, 700);
		this.setTitle("OPERADORES");
	}
	
	/**
	 * Menu Superior "Histograma"
	 * @param evt
	 */
	private void jMenuHistogramaMouseClicked(MouseEvent evt) {
		PanelHistograma panelHistograma = new PanelHistograma();
		this.setContentPane(panelHistograma);
		panelHistograma.setBounds(0, 21, 900, 700);
		this.setTitle("EQ DE HISTOGRAMA");

	}
	
	/**
	 * Menu Superior "Transformações"
	 * @param evt
	 */
	private void jMenuTransformacoesMouseClicked(MouseEvent evt) {
		PanelTransformacoes panelTransformacoes = new PanelTransformacoes();
		this.setContentPane(panelTransformacoes);
		panelTransformacoes.setBounds(0, 21, 900, 700);
		this.setTitle("TRANSFORMACOES");
	}
	
	/**
	 * Menu Superior "Gato de Arnold"
	 * @param evt
	 */
	private void jMenuGatoMouseClicked(MouseEvent evt) {
		this.setContentPane(panelGato);
		panelGato.setBounds(0, 21, 900, 700);
		this.setTitle("Gato de Arnold");
		
	}
	
	/**
	 * Menu Superior "Operações Geométricas"
	 * @param evt
	 */
	private void jMenuOpGeometricasMouseClicked(MouseEvent evt) {
		PanelOperadoresGeometricos panelOpGeometricos = new PanelOperadoresGeometricos();
		this.setContentPane(panelOpGeometricos);
		panelOpGeometricos.setBounds(0, 21, 900, 700);
		this.setTitle("OPERACOES GEOMETRICAS");
	}
	
	/**
	 * SubMenu Principal do Menu Opções que muda para a tela principal do sistema
	 * @param evt
	 */
	private void jMenuItemPrincipalActionPerformed(ActionEvent evt) {
		this.setContentPane(panelPrincipal);
		panelPrincipal.setBounds(0, 21, 900, 700);
		this.setTitle("COMPUTACAO GRAFICA");
	}
	
	/**
	 * Submenu Sair do Menu Opções, que finaliza o sistema 
	 * @param evt
	 */
	private void jMenuItemSairActionPerformed(ActionEvent evt) {
//		int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja sair?", "Sair",JOptionPane.YES_NO_OPTION);  
//    	if (i == JOptionPane.YES_OPTION) {  
    		closeThreads();
    		System.exit(0);  
    		
//        } 
	}

}
