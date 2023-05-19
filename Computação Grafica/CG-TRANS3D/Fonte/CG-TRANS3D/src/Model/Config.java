package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.UIManager;

public class Config {
	
	// Menu
	public static Font FONTE_MENU = new Font("Segoe UI", Font.PLAIN, 13);
	
	// Labels
	public static Color COR_LABEL = Color.BLACK; // Color.BLACK
	public static Font FONTE_LABEL_TITULO = new Font("Segoe Print", Font.BOLD, 20);
	public static Font FONTE_LABEL = new Font("Segoe UI", Font.BOLD, 13);
	
	// Panels
	public static Color COR_BACKGROUND_PRINCIPAL = UIManager.getColor("InternalFrame.inactiveTitleGradient"); // UIManager.getColor("InternalFrame.inactiveTitleGradient")
	public static Color COR_BACKGROUND_PANEL = Color.WHITE;
	public static Color COR_BACKGROUND_TELA = SystemColor.inactiveCaptionBorder;
	public static Color COR_BACKGROUND_TELA_PINTURA = Color.WHITE;
	public static Color COR_BORDA_TELA = Color.LIGHT_GRAY;
	public static Color COR_BORDA_PANEL = new Color(130, 135, 144);
	//public static Dimension DIMENSAO_PANELS_DE_TRANSFORMACOES = new Dimension(180, 65);
	public static int LARGURA_PANEL_OPERACOES = 170;
	
	// ComboBox
	public static Color COR_BACKGROUND_COMBO_BOX = Color.WHITE;
	public static Font FONTE_COMBO_BOX = new Font("Segoe UI", Font.PLAIN, 12);
	public static Font FONTE_COMBO_BOX_REFLEXAO = new Font("Segoe UI", Font.PLAIN, 11);
	
	// TextField
	public static Color COR_TEXTFIELD_FONTES = Color.BLACK;
	public static Color COR_TEXTFIELD_DESATIVADO = Color.DARK_GRAY;
	public static Font FONTE_TEXTFIELD = new Font("Segoe UI", Font.BOLD, 12);
	
	// Botão
	public static Color COR_BOTAO_BACKGROUND = Color.WHITE;
	public static Color COR_BOTAO_BACKGROUND2 = SystemColor.inactiveCaptionBorder;
	public static Font FONTE_BOTAO = new Font("Segoe UI", Font.BOLD, 12);
	
	// Tabela
	public static Font FONTE_TABELA = new Font("Segoe UI", Font.PLAIN, 12);
	
	// Imagem
	public static Font FONTE_IMAGEM = new Font("Segoe UI", Font.BOLD, 14);
	public static Font FONTE_IMAGEM_PIZZA = new Font("Segoe UI", Font.BOLD, 14);
	
	
	// Config
	public static int NUM_MAX_CARACTERES = 5;
	
}
