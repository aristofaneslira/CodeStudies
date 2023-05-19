package Visao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class MainFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar jMenuBar;
	private JMenu jMenuPrincipal;
	private JMenu jMenuOpcoes;
	private JMenuItem jMenuDDA;
	private JMenuItem jMenuItemPrinc;
	private JMenuItem jMenuItemGraficos;
	private JMenuItem jMenuItemProc;
	private JMenuItem jMenuPontoMedio;
	private JMenuItem jMenuItemAnimacao;
	private JMenuItem jMenuItemRecorte;
	private JMenuItem jMenuItemCirc;
	private JMenuItem jMenuTransfGeo;
	private JMenuItem jMenuSair;
	private PanelRotacaoAnimacao panelAnimacao = new PanelRotacaoAnimacao();
	private PanelDDA panelDDA = new PanelDDA();
	private PanelPontoMedio panelPontoMedio = new PanelPontoMedio();
	private PanelRecorte panelRecorte = new PanelRecorte();
	private PanelCircunferencias panelCirc = new PanelCircunferencias();
	private TelaTransfGeometricas transfGeo = new TelaTransfGeometricas();
	private PanelGraficos panelGraficos = new PanelGraficos();
	private PanelCreditos panelPrincipal = new PanelCreditos();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	/**
	 * Construtor
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			this.setTitle("CG");
			
			//CONFIRMAÇÃO DE CLOSE OPERATION
			this.addWindowListener(new WindowAdapter(){  
		            public void windowClosing(WindowEvent e) {  
//		                int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja sair?", "Sair",JOptionPane.YES_NO_OPTION);  
//		                if (i == JOptionPane.YES_OPTION) {  
		                    System.exit(0);  
//		                } else {  
		                    repaint();  
//		                }  
		            }  
		        });
			
			{		
				this.setContentPane(panelPrincipal);
				panelPrincipal.setBounds(0,	23,	884, 608);
			}
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				jMenuBar.setBackground(new java.awt.Color(192,192,192));
					{
					jMenuPrincipal = new JMenu();
					jMenuBar.add(jMenuPrincipal);
//					jMenuPrincipal.setText("Principal");
//					{
//						jMenuItemPrinc = new JMenuItem();
//						jMenuPrincipal.add(jMenuItemPrinc);
//						jMenuItemPrinc.setText("Inicio");
//						jMenuItemPrinc.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent evt) {
//								jMenuItemPrincActionPerformed(evt);
//							}
//						});
//					}
//					
//					{
//						jMenuSair = new JMenuItem();
//						jMenuPrincipal.add(jMenuSair);
//						jMenuSair.setText("Sair");
//						jMenuSair.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent evt) {
//								jMenuSairActionPerformed(evt);
//							}
//						});
//					}
					
				}
				{
					jMenuOpcoes = new JMenu();
					jMenuBar.add(jMenuOpcoes);
					jMenuOpcoes.setText("OPCAO");
					{
						jMenuDDA = new JMenuItem();
						jMenuOpcoes.add(jMenuDDA);
						jMenuDDA.setText("RETA DDA");
						jMenuDDA.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuDDAActionPerformed(evt);
							}
						});
					}
					{
						jMenuPontoMedio = new JMenuItem();
						jMenuOpcoes.add(jMenuPontoMedio);
						jMenuPontoMedio.setText("RETA PONTO MEDIO");
						jMenuPontoMedio.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuPontoMedioActionPerformed(evt);
							}
						});
				
				}
					{
						jMenuItemCirc = new JMenuItem();
						jMenuOpcoes.add(jMenuItemCirc);
						jMenuItemCirc.setText("CIRCUNFERENCIA");
						jMenuItemCirc.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemCircActionPerformed(evt);
							}
						});
					}
					{
						jMenuTransfGeo = new JMenuItem();
						jMenuOpcoes.add(jMenuTransfGeo);
						jMenuTransfGeo.setText("TRANS GEOMETRICA - 2D");
						jMenuTransfGeo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuTransfGeiActionPerformed(evt);
							}
						});
					}
					{
						jMenuItemRecorte = new JMenuItem();
						jMenuOpcoes.add(jMenuItemRecorte);
						jMenuItemRecorte.setText("RECORTE");
						jMenuItemRecorte.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemRecorteActionPerformed(evt);
							}
						});
					}
					{
						jMenuItemAnimacao = new JMenuItem();
						jMenuOpcoes.add(jMenuItemAnimacao);
						jMenuItemAnimacao.setText("ANIMACAO ROTACAO");
						jMenuItemAnimacao.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemAnimacaoActionPerformed(evt);
							}
						});
					}
					{
						jMenuItemGraficos = new JMenuItem();
						jMenuOpcoes.add(jMenuItemGraficos);
						jMenuItemGraficos.setText("GRAFICOS");
						jMenuItemGraficos.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItemGraficosActionPerformed(evt);
							}
						});
					}

				}
			}
			pack();
			this.setSize(890, 662);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/**
	 * Abre o Panel da operação Reta DDA
	 * @param evt
	 */
	private void jMenuDDAActionPerformed(ActionEvent evt) {
		closeThread();
		this.setContentPane(panelDDA);
		panelDDA.setBounds(0, 23, 884, 608);
	}
	/**
	 * Abre o panel da operação Reta Ponto Médio
	 * @param evt
	 */
	private void jMenuPontoMedioActionPerformed(ActionEvent evt) {
		closeThread();
		this.setContentPane(panelPontoMedio);
		panelPontoMedio.setBounds(0, 23, 884, 608);
	}
	
	/**
	 * Menu de Saída do Sistema
	 * @param evt
	 */
	private void jMenuSairActionPerformed(ActionEvent evt) {	
//		int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja sair?", "Sair",JOptionPane.YES_NO_OPTION);  
//        	if (i == JOptionPane.YES_OPTION) { 
        		closeThread();
        		System.exit(0);  
//            } 
             
       
	} 
	/**
	 * Abre Panel de operações 2D
	 * @param evt
	 */
	private void jMenuTransfGeiActionPerformed(ActionEvent evt) {
		closeThread();
		this.setContentPane(transfGeo);
		transfGeo.setBounds(0, 23, 884, 608);
				
	}
	
	/**
	 * Abre panel da operação com Circunferencias e Elipse
	 * @param evt
	 */
	private void jMenuItemCircActionPerformed(ActionEvent evt) {
		closeThread();
		this.setContentPane(panelCirc);
		panelCirc.setBounds(0, 23, 884, 608);
	}
	
	/**
	 * Abre Operação de Recorte (Cohen-Sutherland)
	 * @param evt
	 */
	private void jMenuItemRecorteActionPerformed(ActionEvent evt) {
		closeThread();
		this.setContentPane(panelRecorte);
		panelRecorte.setBounds(0, 23, 884, 608);
	}
	/**
	 * Flag de finalização do processo de animação da rotação bidimensional
	 */
	public void closeThread(){
		panelAnimacao.opRotacaoAnimacao.setRun(false);
	}
	
	/**
	 * Abre panel de graficos
	 * @param evt
	 */
	private void jMenuItemGraficosActionPerformed(ActionEvent evt) {
		closeThread();
		this.setContentPane(panelGraficos);
		panelGraficos.setBounds(0, 23, 884, 608);
	}
	
	/**
	 * Abre panel de Animacao
	 * @param evt
	 */
	private void jMenuItemAnimacaoActionPerformed(ActionEvent evt) {
		closeThread();
		this.setContentPane(panelAnimacao);
		panelAnimacao.setBounds(0, 23, 884, 608);
	}

}
