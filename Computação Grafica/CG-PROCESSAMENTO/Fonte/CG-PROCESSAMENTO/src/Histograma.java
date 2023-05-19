import java.awt.Color;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Histograma {
	private ArrayList<Double> rK = new ArrayList<>();
	private ArrayList<Double> sK = new ArrayList<>();
	private ArrayList<Integer> nK = new ArrayList<>();
	private ArrayList<Double> probRK = new ArrayList<>();
	private ArrayList<Integer> novoK = new ArrayList<>();
	private ArrayList<Integer> novoNK = new ArrayList<>();
	private ArrayList<Integer> imagemEqualizada = new ArrayList<>();
	private double totalPixels;
	private Graphics graphics;
	
	/**
	 * Construtor que recebe ArrayList de pixels da imagem
	 * @param dadosImagem
	 */
	public Histograma(ArrayList<Integer> dadosImagem){
		preencherNiveis(dadosImagem);
		preencherRK();
		calculandoPrRK(this.nK);
	}
	
	/**
	 * Preenche a frequencia de pixels no ArrayList nK cujos níveis variam de 0 a 255
	 */
	public void preencherNiveis(ArrayList<Integer> pixels) {
		totalPixels = 0;
		for (int i = 0; i < 256; i++) {
			int quantidadePixels = 0;
			for (Integer pixel : pixels) {
				if (pixel.equals(i)){
					quantidadePixels += 1;
					totalPixels +=1;
				}
			}
			nK.add(quantidadePixels);
		}
	}
	
	/**
	 * Preenche os valores de RK no ArrayList rK
	 */
	public void preencherRK(){
		double valor;
		for (int i = 0; i < 256; i++) {
			valor = i/255;
			rK.add(valor);
		}
	}
	
	/**
	 * Calcula as probabilidades de existencia de cada pixel (ou nivel) 
	 * @param nk
	 */
	public void calculandoPrRK(ArrayList<Integer> nk){
		double probabilidade;
		for (Integer numeroPixels : nk) {
			probabilidade = numeroPixels/totalPixels;
			probRK.add((double)(probabilidade));
		}
	}
	
	/**
	 * Cálculo da distribuição acumulada (SK)
	 */
	public void calcularSK(){
		sK.clear();
		double rK = 0;
		for (Double probabilidade : probRK) {
			sK.add(probabilidade + rK);		
			rK += probabilidade;	
		}
	}
	
	/**
	 * Cria novos níveis e associa os valores dos píxels aos seus novos níveis
	 */
	public void determinarNovosNiveis(){
		novoK.clear();
		novoNK.clear();
		int novoNivel = 0;
		for (int i = 0; i < sK.size(); i++) {
			novoNivel = (int)Math.round(255*sK.get(i));
			novoK.add(novoNivel);
		}
		
		
		for (int i = 0; i < 256; i++) {
			int novoValorNK = 0;
			for (int j = 0; j < novoK.size(); j++) {
				if (novoK.get(j).equals(i)) {
					novoValorNK += nK.get(j);
				}
			}
			novoNK.add(novoValorNK);
		}
		
		
	}
	/**
	 * Recebe o valor de um Pixel e o normaliza de acordo com os novos níveis
	 * @param Pixel
	 * @return
	 */
	public int normalizarPixel (int Pixel){
		return novoK.get(Pixel);
	}
	
	/**
	 * Atualiza o nivel dos pixels da imagem original para os níveis equalizados
	 * @param pixels
	 * @return
	 */
	public ArrayList<Integer> equalizarImagem(ArrayList<Integer> pixels) {
		for (Integer pixel : pixels) {
			imagemEqualizada.add(normalizarPixel(pixel));
		}
		return this.imagemEqualizada;
	}
	
	/**
	 * Desenha os níveis na tela do gráfico do Histograma passado
	 * @param bi
	 */
	public void desenharNiveisImagemInicial(BufferedImage bi){
		java.awt.Color corA = Color.BLACK;
		java.awt.Color corB = SystemColor.activeCaption;
		
		
		graphics = bi.createGraphics();
		int nivel = 42; //init
		int aux = 0;
		for (Integer niveis : nK) {
			if (aux % 2 == 0){
				graphics.setColor(corA);
			}
			else {
				graphics.setColor(corB);
			}
			graphics.drawLine(nivel, 224, nivel, 224 - (int)Math.round(niveis/4.5));
			nivel++;
			aux ++;
		}
	}
		
	/**
	 * Desenha os niveis equalizados na tela do gráfico do Histograma passado
	 * @param bi
	 */
	public void desenharNiveisImagemFinal(BufferedImage bi){
		java.awt.Color corA = Color.BLACK;
		java.awt.Color corB = SystemColor.activeCaption;
			
			
		graphics = bi.createGraphics();
		int nivel = 42; //init
		int aux = 0;
		for (Integer niveis : novoNK) {
			if (aux % 2 == 0){
				graphics.setColor(corA);
			}
			else {
				graphics.setColor(corB);
				
			}
			graphics.drawLine(nivel, 224, nivel, 224 - (int)Math.round(niveis/4.5));
			nivel++;
			aux ++;
		}
		
	}
		
	
}


