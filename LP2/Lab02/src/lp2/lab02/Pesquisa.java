// Rodrigo Santos Salviano
// 20921474

package lp2.lab02;

import java.util.*;

public class Pesquisa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int REGULAR = 0, BOM = 1, OTIMO = 2;
		int voto, votosRegular = 0, votosBom = 0, votosOtimo = 0;
		String menosVotado = null, medio = null, maisVotado = null;


		System.out.println("Numero de votantes: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("O que achou do produto (REGULAR - 0, BOM - 1, OTIMO - 2)? ");
			voto = sc.nextInt();			

			if (voto == REGULAR) {
				votosRegular += 1;
			}
			else if (voto == BOM) {
				votosBom += 1;
			}
			else if (voto == OTIMO) {
				votosOtimo += 1;
			}
		}

		if (votosRegular <= votosBom && votosRegular <= votosOtimo) {
			menosVotado = "REGULAR = " + votosRegular;  
		}
		else if (votosRegular >= votosBom && votosRegular >= votosOtimo) {
			maisVotado = "REGULAR = " + votosRegular;
		}
		else {
			medio = "REGULAR = " + votosRegular;
		}

		if (votosBom >= votosRegular && votosBom >= votosOtimo) {
			maisVotado = "BOM = " + votosBom;
		} else if (votosBom <= votosRegular && votosBom <= votosOtimo) {
			menosVotado = "BOM = " + votosBom;
		}
		else {
			medio = "BOM = " + votosBom; 
		}

		if (votosOtimo >= votosRegular && votosOtimo >= votosBom) {
			maisVotado = "OTIMO = " + votosOtimo;
		}  
		else if( votosOtimo <= votosRegular && votosOtimo <= votosBom) {
			menosVotado = "OTIMO = " + votosOtimo;
		}
		else {
			medio = "OTIMO = " + votosOtimo;
		}
		System.out.println("Resultado na opniao de " + n + " pessoa(s).");
		System.out.println(maisVotado + "\n" + medio + "\n" + menosVotado);
	}
}