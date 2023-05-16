/* Rodrigo Santos Salviano
 *  20921474
 */

package lp2.lab04;

import java.util.*;
import p1.aplic.cartas.*;

public class SeteeMeioPreparacao {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Baralho baralho = new Baralho();
		Mao maoJogador = new Mao();
		final int OITO = 8, NOVE = 9, DEZ = 10;
		String maisCarta;

		baralho.baralhar(); // Traca o baralho.

		System.out.println("Mao: " + maoJogador); // Mao vazia.
		System.out.println("Valor da mao: " + maoJogador.valor()); // Valor da mao vazia

		System.out.println("Pegar carta (digite 't' para nao pegar)? ");
		maisCarta = sc.next();

		while (!maisCarta.equals("t")) {
			if (baralho.númeroDeCartas() > 0) {
				Carta carta = baralho.pegaCarta();
				if (carta.getValor() == OITO || carta.getValor() == NOVE || carta.getValor() == DEZ) {
					continue;
				}
				else {
					maoJogador.adicionar(carta);
					System.out.println("Nova mao: " + maoJogador);
					System.out.println("Valor da mao: " + maoJogador.valor());
				}
			}
			else {
				System.out.println("Todas as cartas foram entregues. Saindo do programa.");
				System.exit(0);
			}
			System.out.println("Pegar carta (digite 't' para nao pegar)? ");
			maisCarta = sc.next();
		}
	}
}
