import java.util.ArrayList;

public class Transformacoes {
	private ArrayList<Integer> imagemNegativo = new ArrayList<>();
	private ArrayList<Integer> imagemGamma = new ArrayList<>();
	private ArrayList<Integer> imagemLogaritmica = new ArrayList<>();

	
	/**
	 * Aplica a transformação "Negativo" no ArrayList de pixels recebido
	 * por meio da função "S = 255-r" onde "r" é o nível de cinza da imagem
	 * @param pixels
	 */
	public ArrayList<Integer> transformacaoNegativo(ArrayList<Integer> pixels) {
		imagemNegativo.clear();
		int s;
		for (int i = 0; i < pixels.size(); i++) {
			s = Math.abs(255 - pixels.get(i));
			imagemNegativo.add(s);
		}
		return this.imagemNegativo;
	}
	
	/**
	 * Aplica a transformação "Gamma" no ArrayList de pixels da imagem passada
	 * por meio da função "c*r elevado a y" onde c = 1, r é o nível de cinza do pixel
	 * e y é um fator que varia de 0 a 1.
	 * @param pixels
	 * @param y
	 * @return
	 */
	public ArrayList<Integer> transformacaoGamma(ArrayList<Integer> pixels, double y) {
		imagemGamma.clear();
		int c = 1;
		int valorPixel;
		for (Integer pixel : pixels) {
		valorPixel = (int)Math.round(Math.pow(c*pixel, y));
		valorPixel = valorPixel > 255? 255 : valorPixel;
		imagemGamma.add(valorPixel);
		
		//outra implementação...
		//imagemGamma.add((int)(Math.round(255/Math.pow(255, y))*Math.pow(pixel, y)));
		}
		return this.imagemGamma;
	}
	
	/**
	 * Aplica a transformação "Logaritmica" no ArrayList de pixels da imagem passada
	 * por meio da função aLog(r + 1) onde a é uma constante definida por (255/log(256)
	 * e r é o nível de cinza dos pixels.
	 * @param pixels
	 * @return
	 */
	public ArrayList<Integer> transformacaoLogaritmica(ArrayList<Integer> pixels) {
		imagemLogaritmica.clear();
		double c = 20;
		for (Integer pixel : pixels) {
			imagemLogaritmica.add((int)Math.round(c*(Math.log(pixel+1))));
		}
		return this.imagemLogaritmica;

	}
}
