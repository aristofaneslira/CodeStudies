// Rodrigo Santos Salviano
// 20921474

package lp2.lab02;

import java.util.*;

public class Calcula {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double massaInicial, massaFinal;
		final double PESO_LIMITE = 0.5;
		int tempo = 0;
		
		System.out.print("Digite a massa (em gramas): ");
		massaInicial = sc.nextInt();
		massaFinal = massaInicial;
		
		while (massaFinal > PESO_LIMITE) {
			tempo += 50;
			massaFinal = massaFinal / 2;
		}
		System.out.println("Massa inicial: " + massaInicial + " gramas");
		System.out.println("Tempo = " + tempo + " segundos");
	}
}
