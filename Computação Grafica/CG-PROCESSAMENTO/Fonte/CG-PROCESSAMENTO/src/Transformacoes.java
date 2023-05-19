import java.util.ArrayList;

public class Transformacoes {
	private ArrayList<Integer> imagemNegativo = new ArrayList<>();
	private ArrayList<Integer> imagemGamma = new ArrayList<>();
	private ArrayList<Integer> imagemLogaritmica = new ArrayList<>();

	
	/**
	 * Aplica a transforma��o "Negativo" no ArrayList de pixels recebido
	 * por meio da fun��o "S = 255-r" onde "r" � o n�vel de cinza da imagem
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
	 * Aplica a transforma��o "Gamma" no ArrayList de pixels da imagem passada
	 * por meio da fun��o "c*r elevado a y" onde c = 1, r � o n�vel de cinza do pixel
	 * e y � um fator que varia de 0 a 1.
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
		
		//outra implementa��o...
		//imagemGamma.add((int)(Math.round(255/Math.pow(255, y))*Math.pow(pixel, y)));
		}
		return this.imagemGamma;
	}
	
	/**
	 * Aplica a transforma��o "Logaritmica" no ArrayList de pixels da imagem passada
	 * por meio da fun��o aLog(r + 1) onde a � uma constante definida por (255/log(256)
	 * e r � o n�vel de cinza dos pixels.
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
