import java.util.ArrayList;
import java.util.Collections;

public class Operadores {
	private ArrayList<Integer> dadosTemporarios = new ArrayList<>();

	/**
	 * Recebe a operação que se deseja realizar, os ArrayLists das imagens A e B 
	 * realiza a operação, normaliza os resultados e copia para o ArrayList da imagem resultado.
	 * @param operador
	 * @param dadosImagemA
	 * @param dadosImagemB
	 * @param dadosImagemResultado
	 */
	public void processar(String operador, ArrayList<Integer> dadosImagemA, ArrayList<Integer> dadosImagemB, ArrayList<Integer> dadosImagemResultado){
		dadosImagemResultado.clear();
		int total = dadosImagemA.size();
		for (int i = 0; i < total; i++){
			//pego os dados da imagem
			int pixelA = dadosImagemA.get(i);
			int pixelB = dadosImagemB.get(i);
			double valor = 0;
			
			switch (operador) {
			case "operador_adicao":
				valor = pixelA + pixelB;
				break;

			case "operador_subtracao":
				valor = pixelA - pixelB;
				break;
			
			case "operador_divisao":
				if (pixelB == 0){
					valor = 0;
				}
				else {
					valor = (double)pixelA/(double)pixelB;
				}
				valor *= 255;
				break;
			
			case "operador_multiplicacao":
				valor = pixelA * pixelB;
				break;
				
			case "operador_logico_and":
				valor = opAND(pixelA, pixelB);
				//System.out.println(valor);
				break;
			
			case "operador_logico_or":
				valor = opOR(pixelA, pixelB);
				break;
			
			case "operador_logico_xor":
				valor = opXOR(pixelA, pixelB);
				break;
			default:
				break;
			}
			
			//saida
			dadosImagemResultado.add((int)Math.round(valor));
		}

		
		//normalizaçao dos pixels
		dadosTemporarios = (ArrayList<Integer>) dadosImagemResultado.clone();
		Collections.sort(dadosTemporarios);
		int Fmin = dadosTemporarios.get(0);
		int Fmax = dadosTemporarios.get(dadosTemporarios.size()-1);
		if (Fmax > 255 || Fmin < 0){
			for (int i = 0; i < total; i++){
				dadosImagemResultado.set(i, (int)Math.round(normalizar(dadosImagemResultado.get(i), Fmin, Fmax)));
			}
		}
		
		dadosImagemA = dadosImagemResultado;
	
		
	}
	
	/**
	 * Normaliza o valor dos pixels caso ultrapassem 255 e sejam inferiores a 0
	 * @param pixel
	 * @param Fmin
	 * @param Fmax
	 * @return
	 */
	private double normalizar(Integer pixel, int Fmin, int Fmax) {
		double a = ((255 / (double)(Fmax - Fmin)) * (double)(pixel - Fmin));
		return a;
	}

	/**
	 * Recebe os Pixels A e B, transforma em Binário, realiza a Operação "OU Exclusivo" e retorna para a forma decimal.
	 * @param pixelA
	 * @param pixelB
	 * @return
	 */
	public int opXOR(int pixelA, int pixelB){
		//decimal -> binario
		String a = Integer.toBinaryString(pixelA);
		String b = Integer.toBinaryString(pixelB);
		
		int tamanhoA = a.length();
		int tamanhoB = b.length();
		
		int tamanho = (tamanhoA > tamanhoB ? tamanhoA : tamanhoB);
		
		if (tamanhoA < tamanho){
            a = preencheZeros(a, tamanho);
		}
        if (tamanhoB < tamanho){
            b = preencheZeros(b, tamanho);
        }
        
        String s = "";
        
        for (int i = 0; i < tamanho; i++){
        	if(a.charAt(i)!= b.charAt(i)){
        		s += "1";
        	}
        	else{
        		s += "0";
        	}
        }
        //binario -> decimal
        return Integer.parseInt(s, 2);
	}
	
	/**
	 * Preenche com zeros as Strings binárias que forem menores que seus pares para realização de operações lógicas.
	 * @param str
	 * @param maior
	 * @return
	 */
	public String preencheZeros(String str, int maior){
		int spaces = maior - ((str.trim()).length());
		
		for (int i = 0; i < spaces; i++){
			str = "0"+str;
		}
		return str;
	}
	
	/**
	 * Recebe os Pixels A e B, transforma em Binário, realiza a Operação "AND Lógico" e retorna para a forma decimal. 
	 * @param pixelA
	 * @param pixelB
	 * @return
	 */
	public int opAND (int pixelA, int pixelB){
		//decimal -> binario
		String a = Integer.toBinaryString(pixelA);
		String b = Integer.toBinaryString(pixelB);
		
		int tamanhoA = a.length();
		int tamanhoB = b.length();
		
		int tamanho = (tamanhoA > tamanhoB ? tamanhoA : tamanhoB);
		
		//igualando tamanho dos valores binarios
		if (tamanhoA < tamanho){
            a = preencheZeros(a, tamanho);
		}
        if (tamanhoB < tamanho){
            b = preencheZeros(b, tamanho);
        }
        
        String s = "";
     
        for (int i = 0; i < tamanho; i++){
        	if (a.charAt(i) == '1' && b.charAt(i) == '1'){
        		s += "1";
        	}
        	else {
        		s += "0";
        		
        	}
        }
        //binario -> decimal
        
        return Integer.parseInt(s, 2);
	}
	
	/**
	 * Recebe os Pixels A e B, transforma em Binário, realiza a Operação "OU Lógico" e retorna para a forma decimal.
	 * @param pixelA
	 * @param pixelB
	 * @return
	 */
	public int opOR(int pixelA, int pixelB){
		//decimal -> binario
		String a = Integer.toBinaryString(pixelA);
		String b = Integer.toBinaryString(pixelB);
		
		int tamanhoA = a.length();
		int tamanhoB = b.length();
		
		int tamanho = (tamanhoA > tamanhoB ? tamanhoA : tamanhoB);
		
		if (tamanhoA < tamanho){
            a = preencheZeros(a, tamanho);
		}
        if (tamanhoB < tamanho){
            b = preencheZeros(b, tamanho);
        }
        String s = "";
        
        for (int i = 0; i < tamanho; i++){
        	if (a.charAt(i) != b.charAt(i) || (a.charAt(i) == '1' && b.charAt(i) == '1')){
        		s += "1";
        	}
        	else {
				s += "0";
			}
        }
        //binario -> decimal
        return Integer.parseInt(s, 2);
	}
	
}
