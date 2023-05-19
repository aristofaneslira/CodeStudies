package Algoritmos;

public class AlgoritmoCohenSutherland {
	private int bit1A;
	private int bit2A;
	private int bit3A;
	private int bit4A;
	private int bit1B;
	private int bit2B;
	private int bit3B;
	private int bit4B;
	private String bitsA;
	private String bitsB;
	private boolean intersecaoXminA = false;
	private boolean intersecaoXmaxA = false;
	private boolean intersecaoYminA = false;
	private boolean intersecaoYmaxA = false;
	private boolean intersecaoXminB = false;
	private boolean intersecaoXmaxB = false;
	private boolean intersecaoYminB = false;
	private boolean intersecaoYmaxB = false;
	private double newX1;
	private double newY1;
	private double newX2;
	private double newY2;
	private double valorX1;
	private double valorX2;
	private double valorY1;
	private double valorY2;

	/**
	 * Retorna nova coordenada X1
	 * @return
	 */
	public double getNewX1() {
		return newX1;
	}
	
	/**
	 * Retorna nova coordenada Y1
	 * @return
	 */
	public double getNewY1() {
		return newY1;
	}
	
	/**
	 * Retorna nova coordenada X2
	 * @return
	 */
	public double getNewX2() {
		return newX2;
	}
	
	/**
	 * Retorna nova coordenada Y2
	 * @return
	 */
	public double getNewY2() {
		return newY2;
	}
	
	/**
	 * Recebe as coordenadas dos pontos extremos da reta e os valores da janela de recorte, realizando o recorte da reta.
	 * @param X1
	 * @param Y1
	 * @param X2
	 * @param Y2
	 * @param Xmin
	 * @param Xmax
	 * @param Ymin
	 * @param Ymax
	 * @return
	 */
	public void recorte(double X1, double Y1, double X2, double Y2, double Xmin, double Xmax, double Ymin, double Ymax){
		this.newX1 = X1;
		this.newX2 = X2;
		this.newY1 = Y1;
		this.newY2 = Y2;
		this.valorX1 = X1;
		this.valorX2 = X2;
		this.valorY1 = Y1;
		this.valorY2 = Y2;
		
		while (checkCandidatoRecorte(valorX1, valorY1, valorX2, valorY2, Xmin, Xmax, Ymin, Ymax)){
				recorteA(valorX1, valorY1, valorX2, valorY2, Xmin, Xmax, Ymin, Ymax);
				recorteB(valorX1, valorY1, valorX2, valorY2, Xmin, Xmax, Ymin, Ymax);
				
		}
		
	}
	/**
	 * Recorte do Ponto A da Reta
	 * @param X1
	 * @param Y1
	 * @param X2
	 * @param Y2
	 * @param Xmin
	 * @param Xmax
	 * @param Ymin
	 * @param Ymax
	 */
	public void recorteA(double X1, double Y1, double X2, double Y2, double Xmin, double Xmax, double Ymin, double Ymax){
		
		double T;
		//RECORTANDO A--------------------------------------
		if (intersecaoYmaxA){//Interseção na Horizontal - YMax A
			T = (Ymax-valorY1)/(valorY2-valorY1);
			newX1 = valorX1 + (T*(valorX2-valorX1));
			newY1 = Ymax;
			valorY1 = newY1;
			valorX1 = newX1;
		}
		
		else if (intersecaoYminA){//Interseção na Horizontal - YMin A
			T = (Ymin-valorY1)/(valorY2-valorY1);
			newX1 = valorX1 + (T*(valorX2-valorX1));
			newY1 = Ymin;
			valorX1 = newX1;
			valorY1 = newY1;
		}
		
		else if (intersecaoXmaxA){//Interseção na Vertical - XMax A
			T = (Xmax-valorX1)/(valorX2-valorX1);
			newY1 = valorY1 + (T*(valorY2-valorY1));
			newX1 = Xmax;
			valorY1 = newY1;
			valorX1 = newX1;
		}
		
		else if(intersecaoXminA){//Interseção na Vertical - Xmin A
			T = ((Xmin-valorX1)/(valorX2-valorX1));
			newY1 = valorY1 + (T*(valorY2-valorY1));
			newX1 = Xmin;
			valorY1 = newY1;
			valorX1 = newX1;
		}
		
	}
	
	/**
	 * Recorte do Ponto B da Reta
	 * @param X1
	 * @param Y1
	 * @param X2
	 * @param Y2
	 * @param Xmin
	 * @param Xmax
	 * @param Ymin
	 * @param Ymax
	 */
	public void recorteB(double X1, double Y1, double X2, double Y2, double Xmin, double Xmax, double Ymin, double Ymax){
		double T;
		
		//RECORTANDO B -------------------------------------
		if (intersecaoYmaxB){//Interseção na Horizontal - YMax B
			T = (Ymax-valorY1)/(valorY2-valorY1);
			newX2 = valorX1 + (T*(valorX2-valorX1));
			newY2 = Ymax;
			valorX2 = newX2;
			valorY2 = newY2;
			
		}
		else if (intersecaoYminB){//Interseção na Horizontal - YMin B
			T = (Ymin-valorY1)/(valorY2-valorY1);
			newX2 = valorX1 + (T*(valorX2-valorX1));
			newY2 = Ymin;
			valorX2 = newX2;
			valorY2 = newY2;
		}
		else if(intersecaoXmaxB){//Interseção na Vertical - XMax B
			T = (Xmax-valorX1)/(valorX2-valorX1);
			newY2 = valorY1 + (T*(valorY2-valorY1));
			newX2 = Xmax;
			valorY2 = newY2;
			valorX2 = newX2;
		}
		else if(intersecaoXminB){//Interseção na Vertical - Xmin B
			T = (Xmin-valorX1)/(valorX2-valorX1);
			newY2 = valorY1 + (T*(valorY2-valorY1));
			newX2 = Xmin;
			valorY2 = newY2;
			valorX2 = newX2;
		}
		
		
	}
	/**
	 * Verifica se o ponto dado é candidato a recorte
	 * @param Xa
	 * @param Ya
	 * @param Xmin
	 * @param Xmax
	 * @param Ymin
	 * @param Ymax
	 */
	public boolean checkCandidatoRecorte(double X1, double Y1, double X2, double Y2, double Xmin, double Xmax, double Ymin, double Ymax){
		intersecaoXmaxA = false;
		intersecaoXminA = false;
		intersecaoYmaxA = false;
		intersecaoYminA = false;
		intersecaoXmaxB = false;
		intersecaoXminB = false;
		intersecaoYmaxB = false;
		intersecaoYminB = false;
		
		//TESTANDO A
		bit1A = SignalBit(Y1-Ymax);
		bit2A = SignalBit(Ymin-Y1);
		bit3A = SignalBit(X1-Xmax);
		bit4A = SignalBit(Xmin - X1);
		
		//VERIFICANDO INTERSEÇÃO HORIZONTAL OU VERTICAL EM A
		if (bit1A == 1){
			intersecaoYmaxA = true;
		}
		if (bit2A == 1){
			intersecaoYminA = true;
		}
		if (bit3A == 1){
			intersecaoXmaxA = true;
		}
		if (bit4A == 1){
			intersecaoXminA = true;
		}
		
		//TESTANDO B
		bit1B = SignalBit(Y2-Ymax);
		bit2B = SignalBit(Ymin-Y2);
		bit3B = SignalBit(X2-Xmax);
		bit4B = SignalBit(Xmin - X2);
		
		//VERIFICANDO INTERSEÇÃO HORIZONTAL OU VERTICAL EM B
		if (bit1B == 1){
			intersecaoYmaxB = true;
		}
		if (bit2B == 1){
			intersecaoYminB = true;
		}
		if (bit3B == 1){
			intersecaoXmaxB = true;
		}
		if (bit4B == 1){
			intersecaoXminB = true;
		}
		
		//Bits do Ponto A
		bitsA = ""+bit1A+""+bit2A+""+bit3A+""+bit4A;
		//Bits do Ponto B
		bitsB = ""+bit1B+""+bit2B+""+bit3B+""+bit4B;	
		
		//Bits do AND logico entre A e B
		String intersecaoBits = ""+andLogico(bit1A, bit1B)+ ""+andLogico(bit2A, bit2B)+""+andLogico(bit3A, bit3B)+""+andLogico(bit4A, bit4B);

		//Se ambos os pontos forem iguais a 0000, aceitação trivial
		if(bitsA.equals("0000") & bitsB.equals("0000")){
			return false;
			
		}
		else{
			//Se igual a 0000 é candidato, senão rejeita-se
			if (intersecaoBits.equals("0000")){
				return true;
			}
			else{
				//fora da tela de recorte
				newX1 = 0.0;
				newX2 = 0.0;
				newY1 = 0.0;
				newY2 = 0.0;
			}
		}
		
		return false;
		
		
	}
	/**
	 * Checa o sinal do numero
	 * @param bit
	 * @return
	 */
	public int SignalBit(double bit){
		if (bit > 0){
			return 1;
		}
		else {
			return 0;
		}
	}
	/**
	 * Realiza a interseção entre os bits 
	 */
	public int andLogico(double bitA, double bitB){
		if (bitA == 1 && bitB == 1){
			return 1;
		}
		return 0;
	}
}
