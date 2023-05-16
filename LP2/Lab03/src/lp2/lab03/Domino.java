//Rodrigo Santos Salviano
//20921474

package lp2.lab03;

import java.util.*;

public class Domino {
	public static void main(String[] args) {
		int jogadores = Integer.parseInt(args[0]),  numeroDePecas = Integer.parseInt(args[1]);

		if (jogadores * numeroDePecas > 28) {
			System.out.println("Parametros insuficientes.\nModo de usar: java lp2.lab03.Domino <jogadores> <pecas-por-jogador>");
			System.exit(1);
		}

		String[] domino = { "0-0", "0-1", "0-2", "0-3", "0-4", "0-5", "0-6",
							"1-1", "1-2", "1-3", "1-4", "1-5", "1-6",
							"2-2", "2-3", "2-4", "2-5", "2-6",
							"3-3", "3-4", "3-5", "3-6",
							"4-4", "4-5", "4-6",
							"5-5", "5-6",
							"6-6" };

		baralhar(domino);

		String[][] maos = new String[jogadores][numeroDePecas]; // Cria Arrays de maos de jogadores.
		int contador = 0;

		for (int i = 0; i < maos.length; i++) {
			for (int j = 0; j < maos[i].length; j++) {
				maos[i][j] = domino[contador]; // Distribui as pecas as maos dos jogadores.
				contador++;
			}
		}
		for (int j = 0; j < maos.length; j++) {
			String saida = "Jogador " + (j + 1) + ": ";
			for (int y = 0; y < maos[j].length; y++) {
				saida += maos[j][y] + ", ";
			}
			System.out.println(saida.substring(0, saida.length() - 2) );
		}
	}

	private static void baralhar(String[] domino){
		Random ran = new Random();

		for(int i = 0; i < domino.length; i++){
			int posicao = ran.nextInt(domino.length);
			String temp = domino[i];
			domino[i] = domino[posicao];
			domino[posicao] = temp;
		}
	}
}