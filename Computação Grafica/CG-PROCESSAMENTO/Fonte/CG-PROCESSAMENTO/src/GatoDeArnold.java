import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.SwingWorker;


public class GatoDeArnold implements Runnable{
	private ArrayList<Integer> dadosImagemResultado = new ArrayList<>();
	private ArrayList<Integer> dadosImagemResultadoAux = new ArrayList<>();
	private int iteracoes;
	private JPanel panelGato;
	private BufferedImage telaDePintura;
	private ArrayList<Integer> dadosImagem;
	private int largura;
	private int altura;

	

	/**
	 * Construtor
	 * @param panelGato
	 * @param telaDePintura
	 * @param dadosImagem
	 * @param largura
	 * @param altura
	 */
	public GatoDeArnold (JPanel panelGato, BufferedImage telaDePintura, ArrayList<Integer> dadosImagem, int largura, int altura) {
		this.panelGato = panelGato;
		this.telaDePintura = telaDePintura;
		this.dadosImagem = dadosImagem;
		this.largura = largura;
		this.altura = altura;
		
	}
	/**
	 * Método de iniciação da transformação do Gato de Arnold
	 */
	public void processar() {
		iteracoes = 1;
		dadosImagemResultado = (ArrayList<Integer>) dadosImagem.clone();
		executar(panelGato, telaDePintura, dadosImagem, largura, altura);
	}
	
	/**
	 * Método de execução da transformação do Gato de Arnold
	 * @param panelGato
	 * @param telaDePintura
	 * @param dadosImagem
	 * @param largura
	 * @param altura
	 */
	@SuppressWarnings("unchecked")
	public void executar(JPanel panelGato, BufferedImage telaDePintura, ArrayList<Integer> dadosImagem, int largura, int altura) {
		dadosImagemResultadoAux = (ArrayList<Integer>) dadosImagem.clone();
		
		int a;
		int b;
		int xx;
		int yy;	
		
		for (int x = 0; x < largura; x++) {
			for (int y = 0; y < altura; y++) {
				
				//indice atual
				a = (y*largura) + x;
				//cisalhamento e normalização
                xx = mod((x + y), largura);
                yy = mod((x + (2 * y)), altura);
                
                //proximo indice
                b = (yy * largura) + xx;
                // setar novo valor do indice
                dadosImagemResultadoAux.set(b, dadosImagemResultado.get(a));
                
			}
		}
		dadosImagemResultado = (ArrayList<Integer>) dadosImagemResultadoAux.clone();
		 
		//pinta a imagem
		retornarImagem(panelGato, telaDePintura, dadosImagemResultado, largura, altura);
		
		try {
			//Adiciona delay de 0,2 segundos à cada transformação
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
		}
		 
		//Contador de erros entre os pixels
		int contadorPixelDiferente = 0;
		
		for (int j = 0; j < dadosImagem.size(); j++) {
			if (dadosImagemResultado.get(j) != dadosImagem.get(j)) {
				contadorPixelDiferente++;
			}
		}
	
		if (contadorPixelDiferente != 0) {
			PanelGatoDeArnold.jLabelIteracoes.setText("Iterações: "+iteracoes);
			iteracoes++;
			executar(panelGato, telaDePintura, dadosImagem, largura, altura);
			
		} 
		
	}
	
	/**
	 * Cálculo do resto da divisão de a por b
	 * @param a
	 * @param b
	 * @return
	 */
	public int mod(int a, int b) {
		return a%b;
	}
	
	
	/**
	 * Recebe tela de pintura e ArrayList de pixels para pintar a imagem 
	 * @param telaDePintura
	 * @param dadosImagem
	 */
	public void retornarImagem(JPanel panelGato, BufferedImage telaDePintura, ArrayList<Integer> dadosImagem, int largura, int altura){
		
		try {
			
			if (!dadosImagem.isEmpty()){
				int valorPixel;
				int posicaoPixel;
				int corPixel;
				for (int x = 0; x < largura; x++) {
					for (int y = 0; y < altura; y++) {
						posicaoPixel = (y * largura) + x;
						valorPixel = dadosImagem.get(posicaoPixel);
						corPixel = new Color(valorPixel, valorPixel, valorPixel).getRGB();
						telaDePintura.setRGB(x, y, corPixel);
					}
				}
				panelGato.updateUI();
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao pintar a imagem!");
			
		}
	}

	/**
	 * Inicia thread com a execução da transformação do Gato de Arnold
	 */
	@Override
	public void run() {
		processar();
		
	}
	

}
