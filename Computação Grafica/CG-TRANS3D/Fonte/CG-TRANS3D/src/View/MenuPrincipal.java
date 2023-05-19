package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.Config;
import javax.swing.JButton;

public class MenuPrincipal extends JPanel implements ActionListener{
	
	private Dimension resolucaoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
	
	private JFrame frmComputaoGrafica;
	private JPanel panelConteudo;
	private JPanel panelConteudo2;
	private JMenuItem menuItemTransformacoes3D;
	
	private JLabel lblProjetoDeComputao;
	
	private JButton btnPrincipal;
	private JPanel panelCreditos;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmComputaoGrafica.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Cria a janela
		frmComputaoGrafica = new JFrame();
		frmComputaoGrafica.setTitle("Computação Gráfica");
		frmComputaoGrafica.setBounds(100, 100, 980, 690);
		int largura = 980;
		int altura = 690;
		int x = Math.round(resolucaoDaTela.width/2 - largura/2);
		int y = Math.round(resolucaoDaTela.height/2 - altura/2);
		frmComputaoGrafica.setBounds(x, y, largura, altura);
		
		frmComputaoGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Cria e adiciona a Barra de Menus
		JMenuBar menuBar = new JMenuBar();
		frmComputaoGrafica.setJMenuBar(menuBar);
		
//		btnPrincipal = new JButton("Principal");
//		btnPrincipal.setFont(Config.FONTE_MENU);
//		btnPrincipal.setBorderPainted(false);
//		btnPrincipal.setContentAreaFilled(false);
//		btnPrincipal.setFocusPainted(false);
//		btnPrincipal.addActionListener(this);
//		menuBar.add(btnPrincipal);
		
		// Menu 3D
		JMenu menu3D = new JMenu("3D");
		menu3D.setFont(Config.FONTE_MENU);
		menuBar.add(menu3D);
		
		// Menu 3D - Item 1 - Transformações
		menuItemTransformacoes3D = new JMenuItem("Transformaçães");
		menuItemTransformacoes3D.setFont(Config.FONTE_MENU);
		menuItemTransformacoes3D.addActionListener(this);
		menu3D.add(menuItemTransformacoes3D);
		
		// Panel de conteudo da janela
		panelConteudo = new JPanel();
		panelConteudo.setBackground(Config.COR_BACKGROUND_TELA);
		panelConteudo.setBorder(new EmptyBorder(1, 1, 1, 1));
		panelConteudo.setLayout(new BorderLayout(0, 0));
		frmComputaoGrafica.getContentPane().add(panelConteudo, BorderLayout.CENTER);
		
		addLabelPrincipal();
		
	}
	
	/**
	 * Adiciona o Label de Apresentação
	 */
	private void addLabelPrincipal() {
		
	}
	
	/**
	 * Limpa o Panel de Conteudos
	 */
	private void limparPanelConteudo() {
		if (panelConteudo.getComponentCount() != 0) {
			// Remove todos os objetos do Panel Conteudo
			panelConteudo.removeAll();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		// Retira o panel presente dentro do panel de conteudo se houver 
		limparPanelConteudo();
		
		if (evento.getSource() == btnPrincipal) {
			// Atualiza o titulo da Janela
			frmComputaoGrafica.setTitle("Computação Gráfica");
			
			// Adiciona o label Computação Grafica
			addLabelPrincipal();
			
		} else if (evento.getSource() == menuItemTransformacoes3D) {
			// Atualiza o titulo da Janela
			frmComputaoGrafica.setTitle("Computação Gráfica - Transformações 3D");
			
			// Instancia o panel de Transformações 3D
			panelConteudo2 = new PanelTransformacoes3D();
			
		}
		
		if (evento.getSource() != btnPrincipal) {
			// Adiciona o panel de Transformações 3D dentro do panel de Conteudo
			panelConteudo.add(panelConteudo2, BorderLayout.CENTER);
			
		}
		
		// Atualiza a tela
		panelConteudo.updateUI();
		
	}

}
