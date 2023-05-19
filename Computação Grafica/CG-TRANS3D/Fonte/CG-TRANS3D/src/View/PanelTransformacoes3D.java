package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Model.Config;
import Model.Vertice;

import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyEvent;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.SystemColor;

public class PanelTransformacoes3D extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	
	private PanelTabelaVertices3D panelTabelaVertices;
	private JButton btnDesenhar;
	private JButton btnLimparTela;
	
	// Panel Tela
	private JScrollPane scrollPaneTela;
	private JPanel panelBorda;
	private JPanel panelBackground;
	
	private PanelTela3D panelTelaDePintura;
	
	// Panel Transformações
	private JPanel panelTransformacoes;
	
	private PanelTranslacao3D panelTranslacao;
	private PanelEscala3D panelEscala;
	private PanelRotacao3D panelRotacao;
	private PanelReflexao3D panelReflexao;
	private PanelCisalhamento3D panelCisalhamento;
	
	private PanelTabelaTransformacoes3D panelTabelaTransformacoes;
	private JButton btnAplicarTransformacoes;
	private JButton btn2D;
	private JButton btn3D;
	private JButton btnTranslacao;
	private JButton btnEscala;
	private JButton btnRotacao;
	private JButton btnReflexao;
	private JButton btnCisalhamento;
	private JPanel panelE5;
	
	private String visao = "2D";
	private ArrayList<Vertice> vertices;
	private JPanel panelT1;
	private JPanel panelT2;
	private JPanel panelT3;
	private JPanel panelT4;
	private JPanel panelE4;
	private JPanel panelE1;
	private JPanel panelE2;
	private JPanel panelE3;
	
	
	/**
	 * Create the panel.
	 */
	public PanelTransformacoes3D() {
		// Definindo as configurações do Panel
		setLayout(new BorderLayout(0, 0));
		setBounds(0, 0, 800, 500);
		
		/*
		 * Panel de Propriedades
		 */
		
		// Criando Painel propriedades
		JPanel panelPropriedades = new JPanel();
		panelPropriedades.setPreferredSize(new Dimension(150, 10));
		panelPropriedades.setBackground(Config.COR_BACKGROUND_PRINCIPAL);
		panelPropriedades.setBorder(new EmptyBorder(1, 1, 1, 1));
		this.add(panelPropriedades, BorderLayout.WEST);
		panelPropriedades.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelT1 = new JPanel();
		panelT1.setPreferredSize(new Dimension(153, 35));
		panelT1.setBorder(new LineBorder(SystemColor.activeCaption));
		panelT1.setBackground(Color.WHITE);
		panelPropriedades.add(panelT1);
		panelT1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		
		/// Adicionando itens no Painel Propriedades 
		
		// Adiciona Label Objeto
		JLabel lblDesenhaObjeto = new JLabel("Desenha Objeto");
		lblDesenhaObjeto.setPreferredSize(new Dimension(140, 25));
		lblDesenhaObjeto.setToolTipText("");
		lblDesenhaObjeto.setForeground(Config.COR_LABEL);
		lblDesenhaObjeto.setFont(Config.FONTE_LABEL);
		panelT1.add(lblDesenhaObjeto);
		
		// Adicionando Botão OK
		btnDesenhar = new JButton("Desenhar Cubo");
		btnDesenhar.setPreferredSize(new Dimension(130, 25));
		btnDesenhar.setBackground(Config.COR_BOTAO_BACKGROUND);
		btnDesenhar.setFont(Config.FONTE_BOTAO);
		btnDesenhar.addActionListener(this);
		panelPropriedades.add(btnDesenhar);
		
		// Adiciona Botão que Limpa a tela
		btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.setPreferredSize(new Dimension(130, 25));
		btnLimparTela.setBackground(Config.COR_BOTAO_BACKGROUND);
		btnLimparTela.setFont(Config.FONTE_BOTAO);
		btnLimparTela.addActionListener(this);
		panelPropriedades.add(btnLimparTela);
		
		panelE1 = new JPanel();
		panelE1.setPreferredSize(new Dimension(135, 20));
		panelPropriedades.add(panelE1);
		
		panelT2 = new JPanel();
		panelT2.setPreferredSize(new Dimension(158, 35));
		panelT2.setBorder(new LineBorder(SystemColor.activeCaption));
		panelT2.setBackground(Color.WHITE);
		panelT2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		panelPropriedades.add(panelT2);
		
		// Criando Label Coordenadas 
		JLabel lblVisao = new JLabel("Vis\u00E3o");
		lblVisao.setPreferredSize(new Dimension(140, 25));
		lblVisao.setForeground(Config.COR_LABEL);
		lblVisao.setFont(Config.FONTE_LABEL);
		lblVisao.setToolTipText("");
		panelT2.add(lblVisao);
		
		btn2D = new JButton("2D");
		btn2D.setPreferredSize(new Dimension(55, 40));
		btn2D.setMargin(new Insets(2, 5, 2, 5));
		btn2D.setFont(Config.FONTE_BOTAO);
		btn2D.setBackground(Config.COR_BOTAO_BACKGROUND);
		btn2D.addActionListener(this);
		panelPropriedades.add(btn2D);
		
		btn3D = new JButton("3D");
		btn3D.setPreferredSize(new Dimension(55, 40));
		btn3D.setMargin(new Insets(2, 5, 2, 5));
		btn3D.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn3D.setBackground(Color.WHITE);
		panelPropriedades.add(btn3D);
		btn3D.addActionListener(this);
		
		panelE2 = new JPanel();
		panelE2.setPreferredSize(new Dimension(135, 20));
		panelPropriedades.add(panelE2);
		
		panelT3 = new JPanel();
		panelT3.setPreferredSize(new Dimension(153, 35));
		panelT3.setBorder(new LineBorder(SystemColor.activeCaption));
		panelT3.setBackground(Color.WHITE);
		panelPropriedades.add(panelT3);
		panelT3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		
		// Adicionando Label de Coordenadas dos vertices
		JLabel lblVertices = new JLabel("Vertices");
		panelT3.add(lblVertices);
		lblVertices.setPreferredSize(new Dimension(140, 25));
		lblVertices.setForeground(Config.COR_LABEL);
		lblVertices.setToolTipText("Coordenadas dos vertices do objeto mostrado na tela");
		lblVertices.setFont(Config.FONTE_LABEL);
		
		// Adicionando a tabela de vertices
		panelTabelaVertices = new PanelTabelaVertices3D();
		panelTabelaVertices.setPreferredSize(new Dimension(130, 140));
		panelTabelaVertices.setBorder(new EmptyBorder(1, 1, 1, 1));
		panelPropriedades.add(panelTabelaVertices);
		panelTabelaVertices.getTabela().addKeyListener(this);
		
		panelE3 = new JPanel();
		panelE3.setPreferredSize(new Dimension(135, 150));
		panelPropriedades.add(panelE3);
		
		/*
		 * Panel da Tela de Pintura
		 */
		
		// Adicionando um painel de rolagem
		scrollPaneTela = new JScrollPane();
		scrollPaneTela.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneTela.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.add(scrollPaneTela);
		
		// Adiciona um painel de Background
		panelBackground = new JPanel();
		panelBackground.setBackground(Config.COR_BACKGROUND_TELA);
		scrollPaneTela.setViewportView(panelBackground);
		
		// Adiciona um painel de borda da Tela de Pintura
		panelBorda = new JPanel();
		panelBorda.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBorda.setBackground(Config.COR_BORDA_TELA);
		panelBackground.add(panelBorda);
		
		// Adicionando a tela de pintura
		panelTelaDePintura = new PanelTela3D();
		panelTelaDePintura.setToolTipText("");
		panelBorda.add(panelTelaDePintura);
		panelTelaDePintura.addMouseListener(this);
		panelTelaDePintura.addMouseMotionListener(this);
		
		/*
		 * Panel de Transformações
		 */
		
		panelTransformacoes = new JPanel();
		panelTransformacoes.setPreferredSize(new Dimension(232, 10));
		panelTransformacoes.setBackground(Config.COR_BACKGROUND_PRINCIPAL);
		panelTransformacoes.setBorder(new EmptyBorder(1, 1, 1, 1));
		add(panelTransformacoes, BorderLayout.EAST);
		panelTransformacoes.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));

		// Adiciona Botão Translação
		btnTranslacao = new JButton("Translação");
		btnTranslacao.setPreferredSize(new Dimension(213, 30));
		btnTranslacao.setFont(Config.FONTE_BOTAO);
		btnTranslacao.setBackground(Config.COR_BOTAO_BACKGROUND);
		btnTranslacao.addActionListener(this);
		
		panelT4 = new JPanel();
		panelT4.setPreferredSize(new Dimension(238, 35));
		panelT4.setBorder(new LineBorder(SystemColor.activeCaption));
		panelT4.setBackground(Color.WHITE);
		panelTransformacoes.add(panelT4);
		panelT4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		
		// Adiciona label Transformações
		JLabel lblTransformacoes = new JLabel("Transformações");
		panelT4.add(lblTransformacoes);
		lblTransformacoes.setPreferredSize(new Dimension(212, 25));
		lblTransformacoes.setForeground(Config.COR_LABEL);
		lblTransformacoes.setFont(Config.FONTE_LABEL);
		
		panelE4 = new JPanel();
		panelE4.setPreferredSize(new Dimension(212, 7));
		panelTransformacoes.add(panelE4);
		panelTransformacoes.add(btnTranslacao);
		
		// Adiciona Panel de Translação no Panel de Operações
		panelTranslacao = new PanelTranslacao3D();
		FlowLayout flowLayout = (FlowLayout) panelTranslacao.getLayout();
		flowLayout.setHgap(1);
		panelTranslacao.setPreferredSize(new Dimension(212, 50));
		panelTranslacao.getBtnADD().addActionListener(this);
		panelTranslacao.setVisible(false);
		panelTransformacoes.add(panelTranslacao);
		
		// Adiciona Botão Escala
		btnEscala = new JButton("Escala");
		btnEscala.setPreferredSize(new Dimension(213, 30));
		btnEscala.setFont(Config.FONTE_BOTAO);
		btnEscala.setBackground(Config.COR_BOTAO_BACKGROUND);
		btnEscala.addActionListener(this);
		panelTransformacoes.add(btnEscala);
		
		// Adiciona Panel de Escala no Panel de Operações
		panelEscala = new PanelEscala3D();
		FlowLayout flowLayout_1 = (FlowLayout) panelEscala.getLayout();
		flowLayout_1.setHgap(1);
		panelEscala.setPreferredSize(new Dimension(212, 50));
		panelEscala.getBtnADD().addActionListener(this);
		panelEscala.setVisible(false);
		panelTransformacoes.add(panelEscala);
		
		// Adiciona Botão Rotação
		btnRotacao = new JButton("Rota\u00E7\u00E3o");
		btnRotacao.setPreferredSize(new Dimension(213, 30));
		btnRotacao.setFont(Config.FONTE_BOTAO);
		btnRotacao.setBackground(Config.COR_BOTAO_BACKGROUND);
		btnRotacao.addActionListener(this);
		panelTransformacoes.add(btnRotacao);
		
		// Adiciona Panel de Rotação no Panel de Operações
		panelRotacao = new PanelRotacao3D();
		FlowLayout flowLayout_2 = (FlowLayout) panelRotacao.getLayout();
		flowLayout_2.setHgap(1);
		panelRotacao.setPreferredSize(new Dimension(212, 50));
		panelRotacao.setVisible(false);
		panelRotacao.getBtnADD().addActionListener(this);
		panelTransformacoes.add(panelRotacao);
		
		// Adiciona Botão Reflexão
		btnReflexao = new JButton("Reflex\u00E3o");
		btnReflexao.setPreferredSize(new Dimension(213, 30));
		btnReflexao.setFont(Config.FONTE_BOTAO);
		btnReflexao.setBackground(Config.COR_BOTAO_BACKGROUND);
		btnReflexao.addActionListener(this);
		panelTransformacoes.add(btnReflexao);
		
		// Adiciona Panel de Reflexão no Panel de Operações
		panelReflexao = new PanelReflexao3D();
		FlowLayout flowLayout_3 = (FlowLayout) panelReflexao.getLayout();
		flowLayout_3.setHgap(1);
		panelReflexao.setPreferredSize(new Dimension(212, 40));
		panelReflexao.setVisible(false);
		panelReflexao.getBtnADD().addActionListener(this);
		panelReflexao.getComboBoxReflexao().addActionListener(this);
		panelTransformacoes.add(panelReflexao);
		
		// Adiciona Botão Cisalhamento
		btnCisalhamento = new JButton("Cisalhamento");
		btnCisalhamento.setPreferredSize(new Dimension(213, 30));
		btnCisalhamento.setFont(Config.FONTE_BOTAO);
		btnCisalhamento.setBackground(Config.COR_BOTAO_BACKGROUND);
		btnCisalhamento.addActionListener(this);
		panelTransformacoes.add(btnCisalhamento);
		
		// Adiciona Panel de Cisalhamento no Panel de Operações
		panelCisalhamento = new PanelCisalhamento3D();
		FlowLayout flowLayout_4 = (FlowLayout) panelCisalhamento.getLayout();
		flowLayout_4.setHgap(1);
		panelCisalhamento.setPreferredSize(new Dimension(212, 50));
		panelCisalhamento.setVisible(false);
		panelCisalhamento.getBtnADD().addActionListener(this);
		panelTransformacoes.add(panelCisalhamento);
		
		// Adiciona um panel para dar um espaçamento entre as operações e a tabela de Transformações
		panelE5 = new JPanel();
		panelE5.setPreferredSize(new Dimension(212, 7));
		panelTransformacoes.add(panelE5);
		
		// Adiciona tabela de Transformações
		panelTabelaTransformacoes = new PanelTabelaTransformacoes3D();
		panelTabelaTransformacoes.setPreferredSize(new Dimension(212, 140));
		panelTransformacoes.add(panelTabelaTransformacoes);
		panelTabelaTransformacoes.setBorder(new EmptyBorder(1, 1, 1, 1));
		panelTabelaTransformacoes.getTabela().addKeyListener(this);
		
		// Adiciona Botão de Multiplas transformações
		btnAplicarTransformacoes = new JButton("Aplicar Transformações");
		btnAplicarTransformacoes.setBackground(Config.COR_BOTAO_BACKGROUND);
		btnAplicarTransformacoes.setFont(Config.FONTE_BOTAO);
		btnAplicarTransformacoes.setMargin(new Insets(2, 5, 2, 5));
		panelTransformacoes.add(btnAplicarTransformacoes);
		btnAplicarTransformacoes.addActionListener(this);
		
		/*
		 * Adiciona Vertices do Objeto 3D na Origem
		 */
		/*panelTelaDePintura.desenharVertice(  0,   0, 100);
		panelTelaDePintura.desenharVertice(100,   0, 100);
		panelTelaDePintura.desenharVertice(100, 100, 100);
		panelTelaDePintura.desenharVertice(  0, 100, 100);
		
		panelTelaDePintura.desenharVertice(  0,   0,  0);
		panelTelaDePintura.desenharVertice(100,   0,  0);
		panelTelaDePintura.desenharVertice(100, 100,  0);
		panelTelaDePintura.desenharVertice(  0, 100,  0);
		*/
	}
	
	/**
	 * Valida campo de texto para inteiro
	 * @param campo
	 * @return 
	 */
	public int validarCampoInt(JTextField campo){
		String nome = campo.getText();
		if (nome.contains(",")) {
			nome = nome.replaceAll(",", ".");
		}
		if (nome.equals("")) {
			return 0;
		}
		return Integer.parseInt(campo.getText());
	}
	
	/**
	 * Valida o campo de texto para Double
	 * @param campo
	 * @return
	 */
	public double validarCampoDouble(JTextField campo){
		String nome = campo.getText();
		if (nome.contains(",")) {
			nome = nome.replaceAll(",", ".");
		}
		if (nome.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(nome);
	}
	
	/**
	 * Atualiza os valores da lista de vertices
	 */
	private void atualizarTabelaDeVertices() {
		panelTabelaVertices.limparTabela();
		
		for (Vertice v : vertices) {
			panelTabelaVertices.adicionaLinha(v.getCoordenadaX(), v.getCoordenadaY(), v.getCoordenadaZ(), v.getCoordenadaW());
		}
	}
	
	/**
	 * Define Panel Visivel ou não Visivel
	 * @param panel
	 */
	private void exibirPanel(JPanel panel) {
		if (panel.isVisible()) {
			panel.setVisible(false);
			
		} else {
			panel.setVisible(true);
			
		}
	}
	
	/**
	 * Aplica reflexão no objeto
	 * @param indice
	 */
	public void adicionarReflexao(int indice) {
		if (indice == 0) {
			// Reflexão em XY
			panelTelaDePintura.addReflexaoEmTornoDoPlanoXY();
			
			// Atualiza tabela de Transformações
			panelTabelaTransformacoes.adicionaLinha("Reflexão em XY", 1, 1, -1);
			
		} else if (indice == 1) {
			// Reflexão em YZ
			panelTelaDePintura.addReflexaoEmTornoDoPlanoYZ();
			
			// Atualiza tabela de Transformações
			panelTabelaTransformacoes.adicionaLinha("Reflexão em YZ", -1, 1, 1);
			
		} else if (indice == 2) {
			// Reflexão em ZX 
			panelTelaDePintura.addReflexaoEmTornoDoPlanoZX();
			
			// Atualiza tabela de Transformações
			panelTabelaTransformacoes.adicionaLinha("Reflexão em ZX", 1, -1, 1);
			
		}
		
	}
	
	/**
	 * Define se os vertices são 3D ou 2D
	 */
	private void definirVertices() {
		
		if (visao.equals("2D")) {
			vertices = panelTelaDePintura.getVertices();
			
		} else if (visao.equals("3D")) {
			vertices = panelTelaDePintura.getVertices3D();
			
		}
		
	}
	
	/**
	 * Trata os Eventos dos Componentes do Panel
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		// Determina a Visão 2D
		if (evento.getSource() == btn2D) {
			
			visao = "2D";
			
			definirVertices();
			
			if (vertices.size() != 0) {
				// Limpa a Tela
				panelTelaDePintura.limparTela();
				
				// Desenha Objeto 2D na Tela
				panelTelaDePintura.desenharObjeto3D(vertices);
				
			}
			
			// Atualiza os valores da tabela de Vertices
			atualizarTabelaDeVertices();
			
			updateUI();
		}
		
		// Determina a Visão 3D
		if (evento.getSource() == btn3D) {
			
			visao = "3D";
			
			definirVertices();
			
			if (vertices.size() != 0) {
				// Limpa a Tela
				panelTelaDePintura.limparTela();
				
				// Desenha Objeto 3D na Tela
				panelTelaDePintura.desenharObjeto3D(vertices);
				
			}
			
			// Atualiza os valores da tabela de Vertices
			atualizarTabelaDeVertices();
			
			updateUI();
			
		}
		
		// Trata o evento quando o botão Desenhar é Clicado
		if (evento.getSource() == btnDesenhar) {
			
			definirVertices();
			
			// Verifica se a tela de Pintura ja possui os vertices do desenho
			if (vertices.size() == 0) {
				
				panelTelaDePintura.desenharVertice(  0,   0, 100);
				panelTelaDePintura.desenharVertice(100,   0, 100);
				panelTelaDePintura.desenharVertice(100, 100, 100);
				panelTelaDePintura.desenharVertice(  0, 100, 100);
				
				panelTelaDePintura.desenharVertice(  0,   0,  0);
				panelTelaDePintura.desenharVertice(100,   0,  0);
				panelTelaDePintura.desenharVertice(100, 100,  0);
				panelTelaDePintura.desenharVertice(  0, 100,  0);
				
			}
			
			// Aplica a Perspectiva no Objeto
			panelTelaDePintura.aplicarTransformacaoDeProjecaoEmPerspectiva3D();
			
			// Desenha o objeto interligando os vertices
			panelTelaDePintura.desenharObjeto3D(vertices);
			
			// Atualiza os valores da tabela de Vertices
			atualizarTabelaDeVertices();
			
			// Atualiza a Tela
			updateUI();
			
		}
		
		// Trata o evento quando o botão Limpar Tela é Clicado
		if (evento.getSource() == btnLimparTela) {
			
			// Limpa a tabela de vertices
			panelTabelaVertices.limparTabela();
			
			// Limpa a tabela de Transformações
			panelTabelaTransformacoes.limparTabela();
			
			// Limpa a lista de vertices
			panelTelaDePintura.limparListaVertices();
			panelTelaDePintura.limparListaVertices3D();
			
			// Limpa a tela
			panelTelaDePintura.limparTela();
			
			// Atualiza a Tela
			updateUI();
		}
		
		/*
		 * Torna Visivel ou Não-Visivel os Panels das tranfomações
		 */
		if (evento.getSource() == btnTranslacao) {
			exibirPanel(panelTranslacao);
			
		}
		if (evento.getSource() == btnEscala) {
			exibirPanel(panelEscala);
			
		}
		if (evento.getSource() == btnRotacao) {
			exibirPanel(panelRotacao);
			
		}
		if (evento.getSource() == btnReflexao) {
			exibirPanel(panelReflexao);
			
		}
		if (evento.getSource() == btnCisalhamento) {
			exibirPanel(panelCisalhamento);
			
		}
		
		// Trata o evento quando o botão ok de Translação é clicado
		if (evento.getSource() == panelTranslacao.getBtnADD()) {
			// Aplica a translação no Objeto Desenhado
			panelTelaDePintura.addTranslacao(validarCampoInt(panelTranslacao.getTextFieldTx()), validarCampoInt(panelTranslacao.getTextFieldTy()), validarCampoInt(panelTranslacao.getTextFieldTz()));
			
			// Atualiza tabela de Transformações
			panelTabelaTransformacoes.adicionaLinha("Translação", validarCampoInt(panelTranslacao.getTextFieldTx()), validarCampoInt(panelTranslacao.getTextFieldTy()), validarCampoInt(panelTranslacao.getTextFieldTz()));
			
			// Atualiza a Tela
			updateUI();
		}
		
		// Trata o evento quando o botão ok de Escala é clicado
		if (evento.getSource() == panelEscala.getBtnADD()) {
			// Aplica a escala no Objeto Desenhado
			panelTelaDePintura.addEscala(validarCampoDouble(panelEscala.getTextFieldSx()), validarCampoDouble(panelEscala.getTextFieldSy()), validarCampoDouble(panelEscala.getTextFieldSz()));
			
			// Atualiza tabela de Transformações
			panelTabelaTransformacoes.adicionaLinha("Escala", validarCampoDouble(panelEscala.getTextFieldSx()), validarCampoDouble(panelEscala.getTextFieldSy()), validarCampoDouble(panelEscala.getTextFieldSz()));
			
			// Atualiza a Tela
			updateUI();
		}
		
		// Trata o evento quando o botão ok de Rotação é clicado
		if (evento.getSource() == panelRotacao.getBtnADD()) {
			
			if (panelRotacao.getComboBoxRotacao().getSelectedIndex() == 0) {
				// Aplica a Rotação em X
				panelTelaDePintura.addRotacaoEmTornoDoEixoX(validarCampoDouble(panelRotacao.getTextFieldAngulo()));
				
				// Atualiza tabela de Transformações
				panelTabelaTransformacoes.adicionaLinha("Rotação em X", validarCampoDouble(panelRotacao.getTextFieldAngulo()), 0, 0);
				
			} else if (panelRotacao.getComboBoxRotacao().getSelectedIndex() == 1) {
				// Aplica a Rotação no Objeto Desenhado
				panelTelaDePintura.addRotacaoEmTornoDoEixoY(validarCampoDouble(panelRotacao.getTextFieldAngulo()));
				
				// Atualiza tabela de Transformações
				panelTabelaTransformacoes.adicionaLinha("Rotação em Y", 0, validarCampoDouble(panelRotacao.getTextFieldAngulo()), 0);
				
			} else if (panelRotacao.getComboBoxRotacao().getSelectedIndex() == 2) {
				// Aplica a Rotação no Objeto Desenhado
				panelTelaDePintura.addRotacaoEmTornoDoEixoZ(validarCampoDouble(panelRotacao.getTextFieldAngulo()));
				
				// Atualiza tabela de Transformações
				panelTabelaTransformacoes.adicionaLinha("Rotação em Y", 0, 0, validarCampoDouble(panelRotacao.getTextFieldAngulo()));
				
			}
			
			// Atualiza a Tela
			updateUI();
		}
		
		// Trata o evento quando o botão ok de Reflexão é clicado
		if (evento.getSource() == panelReflexao.getBtnADD()) {
			// Aplica a Reflexão no Objeto Desenhado
			adicionarReflexao(panelReflexao.getComboBoxReflexao().getSelectedIndex());
			
			// Atualiza a Tela
			updateUI();
		}
		
		// Trata o evento quando o botão ok de Cisalhamento é clicado
		if (evento.getSource() == panelCisalhamento.getBtnADD()) {
			// Aplica a Cisalhamento no Objeto Desenhado
			try {
				panelTelaDePintura.addCisalhamento(panelCisalhamento.getComboBoxCisalhamento().getSelectedItem().toString(), validarCampoDouble(panelCisalhamento.getTextFieldShX()), validarCampoDouble(panelCisalhamento.getTextFieldShY()));
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			
			// Atualiza tabela de Transformações
			panelTabelaTransformacoes.adicionaLinha("Cisalhamento", validarCampoDouble(panelCisalhamento.getTextFieldShX()), validarCampoDouble(panelCisalhamento.getTextFieldShY()), 0);
			
			// Atualiza a Tela
			updateUI();
		}
		
		// Trata o evento quando o botão Aplicar Transformações é clicado
		if (evento.getSource() == btnAplicarTransformacoes) {
			if (panelTelaDePintura.verificarMatrizesOperações()) {
				
				// Aplica a transformação
				panelTelaDePintura.aplicarTransformacao();
				
				// Atualiza a tabela de vertices
				atualizarTabelaDeVertices();
				
				// Atualiza a Tela
				updateUI();
				
			} else {
				JOptionPane.showMessageDialog(this, "Erro! Adicione uma nova operação na tabela de transformação!");
			}
			
		}
	}
	
	/*
	 * Trata os Eventos do Teclado
	 */
	
	/**
	 * Trata os Eventos Quando uma Tecla é Pressionada
	 */
	@Override
	public void keyPressed(KeyEvent ke) {
		
		// Trata o evento da Tabela de Vertices
		if (ke.getSource() == panelTabelaVertices.getTabela()) {
			if (ke.getKeyCode() == KeyEvent.VK_DELETE) {
				if (panelTabelaTransformacoes.getTabela().getRowCount() != 0) {
					// Remove o vertice da tela
					panelTelaDePintura.removerVertice(panelTabelaVertices.getTabela().getSelectedRow());
					
					// Remove a linha da tabela de vertices
					panelTabelaVertices.removeLinha();
					
					// Atualiza a tela
					updateUI();
					
				} else {
					JOptionPane.showMessageDialog(this, "Erro! Não possuem vertices para Serem Removidos!");
				}
				
			}
		}
		
		// Trata o evento da Tabela de Transformações
		if (ke.getSource() == panelTabelaTransformacoes.getTabela()) {
			
			// Trata o evento quando o a tecla Delete for pressionada com um item da tabela selecionado
			if (ke.getKeyCode() == KeyEvent.VK_DELETE) {
				
				// variavel que testa se foi aplicada tranformacao ou nao
				// caso true: nao foi aplicada
				// caso false: foi aplicada
				boolean teste = true;
				if (panelTabelaTransformacoes.getTabela().getRowCount() == 0) {
					teste = false;
				}
				
				// Caso não exista transformações
				if (!teste) {
					JOptionPane.showMessageDialog(this, "Erro! Não existem Transformações para serem Removidas!");
					return;
				}
				
				// Desfaz a translação apagada da tabela
				if (panelTabelaTransformacoes.getNomeTransformacao().equals("Translação")) {
					panelTelaDePintura.addTranslacao(-panelTabelaTransformacoes.getValorX(), -panelTabelaTransformacoes.getValorY(), -panelTabelaTransformacoes.getValorZ());
					
				}
				
				// Desfaz a Escala Apagada da Tabela
				if (panelTabelaTransformacoes.getNomeTransformacao().equals("Escala")) {
					panelTelaDePintura.addEscala(1/panelTabelaTransformacoes.getValorX(), 1/panelTabelaTransformacoes.getValorY(), 1/-panelTabelaTransformacoes.getValorZ());
					
				}
				
				// Desfaz a Rotação Apagada da Tabela
				if (panelTabelaTransformacoes.getNomeTransformacao().equals("Rotação")) {
					//panelTelaDePintura.addRotacao(-panelTabelaTransformacoes.getValorX());
					
				}
				
				// Desfaz a Reflexão em Torno do Eixo XY
				if (panelTabelaTransformacoes.getNomeTransformacao().equals("Reflexão em XY")) {
					panelTelaDePintura.addReflexaoEmTornoDoPlanoXY();
					
				}
				
				// Desfaz a Reflexão em Y
				if (panelTabelaTransformacoes.getNomeTransformacao().equals("Reflexão em YZ")) {
					panelTelaDePintura.addReflexaoEmTornoDoPlanoYZ();
					
				} 
				
				// Desfaz a Reflexão na Origem
				if (panelTabelaTransformacoes.getNomeTransformacao().equals("Reflexão em ZX")) {
					panelTelaDePintura.addReflexaoEmTornoDoPlanoZX();
					
				} 
				
				// Desfaz o cisalhamento apagado da tabela
				if (panelTabelaTransformacoes.getNomeTransformacao().equals("Cisalhamento")) {
					panelTelaDePintura.addCisalhamento(-panelTabelaTransformacoes.getValorX(), -panelTabelaTransformacoes.getValorY(), 0, 0, 0, 0);
					
				}
				
				if (teste) {
					// Aplica a transformacao inversa
					panelTelaDePintura.aplicarTransformacao();
					
				}
				
				// Remove a linha da tabela de Transformações
				panelTabelaTransformacoes.removeLinha();
				
				// Atualiza a tabela de vertices
				atualizarTabelaDeVertices();
				
				// Atualiza a tela
				updateUI();
			}
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Trata os Eventos de Clique do Mouse 
	 */
	
	/**
	 * Trata os Eventos do mouse quando o Mouse é Clicado
	 */
	@Override
	public void mouseClicked(MouseEvent me) {
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Trata os Eventos de Movimento do Mouse
	 */
	
	/**
	 * Trata o evento do mouse quando ele é clicado e arrastado
	 */
	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Trata o evento do Mouse quando ele é movimentado
	 */
	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
}
