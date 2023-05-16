/* Rodrigo Santos Salviano
 *  20921474
 */

package lp2.lab04;

import java.util.*;
import p1.aplic.cartas.*;

public class SeteeMeioJogo {
	public static void main(String[] args) {
		
		String outraPartida;
		
		do {
			Scanner sc = new Scanner(System.in);
			Baralho baralho = new Baralho();
			Mao maoJogador = new Mao();
			Mao maoMesa = new Mao();
			String maisCarta;
			Carta carta; // Variavel que sera atualizada frequentemente durante a execucao.
			double valorDaMaoJogador = 0, valorDaMaoMesa = 0; // Guardarao o valor de maoJogador e maoMesa.
			
			baralho.baralhar();
			
			// Primeira carta entregue ao jogador.
			carta = distribuiCarta(baralho);
			maoJogador.adicionar(carta);
			valorDaMaoJogador = mudaValor(carta);
			System.out.println("Mao do Jogador: " + maoJogador + "\nPontuacao do Jogador: " + valorDaMaoJogador + "\n");
			
			// Primeira carta entregue a mesa.
			carta = distribuiCarta(baralho);
			maoMesa.adicionar(carta);
			valorDaMaoMesa = mudaValor(carta);
			System.out.println("Mao da Mesa: " + maoMesa + "\nPontuacao da Mesa: " + valorDaMaoMesa + "\n");
			
			// Jogador decidira se que ou nao mais cartas.
			System.out.println("Jogador, deseja outra carta ('s' - sim, 'n' - nao)? ");
			maisCarta = sc.next();
			
			while (maisCarta.equals("s")) {
				carta = distribuiCarta(baralho);
				maoJogador.adicionar(carta);
				valorDaMaoJogador += mudaValor(carta);
				
				System.out.println("Mao do Jogador: " + maoJogador + "\nPontuacao do Jogador: " + valorDaMaoJogador + "\n");
				
				if (valorDaMaoJogador >= 7.5) { // Para de receber se chegar ou passar o valor 7.5
					break;
				}
				else {
					System.out.println("Jogador, deseja outra carta ('s' - sim, 'n' - nao)? ");
					maisCarta = sc.next();
				}
			}
			if (valorDaMaoJogador > 7.5) { // Declara a mesa como vencedora se o jogador passar de 7.5.
				System.out.println("VITORIA DA MESA!\nO Jogador estourou o valor de 7.5.");
				
			}
			else {
				// Mesa recebera as cartas.
				while (valorDaMaoMesa < 6) {
					System.out.println("Mesa saca nova carta.\n");
					carta = distribuiCarta(baralho);
					maoMesa.adicionar(carta);
					valorDaMaoMesa += mudaValor(carta);
				
					System.out.println("Mao da Mesa: " + maoMesa + "\nPontuacao da Mesa: " + valorDaMaoMesa + "\n");
				}
				
				if (valorDaMaoMesa > 7.5) { // Declara o jogador como vencedor se a mesa passar de 7.5
					System.out.println("VITORIA DO JOGADOR!\nA Mesa estourou o valor de 7.5.");
				}
				else { // Caso nenhum dos dois estoure os 7.5 pontos, a pontuacao dos dois serao comparadas.
					decideVencedor(maoJogador, maoMesa, valorDaMaoJogador, valorDaMaoMesa);
				}
			}
			
			System.out.println("Outra partida ('nova' - para jogar novamente ou 'sair' - para encerrar)?");
			outraPartida = sc.next();
		
		}while (outraPartida.equals("nova"));
	}
	
	
	// Metodo para comparar maoJogador e maoMesa declarando o vencedor.
	private static void decideVencedor(Mao maoJogador, Mao maoMesa, double valorDaMaoJogador, double valorDaMaoMesa) {
		if (valorDaMaoJogador > valorDaMaoMesa) {
			System.out.println("VITORIA DO JOGADOR!\nMao do Jogador: " + maoJogador + "\nPontuacao do Jogador: " + valorDaMaoJogador + " pontos\n" + 
								"\nMao da Mesa: " + maoMesa + "\nPontuacao da Mesa: " + valorDaMaoMesa + " pontos\n");
		}
		else if (valorDaMaoJogador < valorDaMaoMesa) {
			System.out.println("VITORIA DA MESA!\nMao da Mesa: " + maoMesa + "\nPontuacao da Mesa: " + valorDaMaoMesa + " pontos\n" + 
								"\nMao do Jogador: " + maoJogador + "\nPontuacao do Jogador: " + valorDaMaoJogador + " pontos\n");
		}
		else {
			System.out.println("Houve EMPATE em pontos. VITORIA DA MESA!\nMao da Mesa: " + maoMesa + "\nPontuacao da Mesa: " + valorDaMaoMesa + " pontos\n" + 
								"\nMao do Jogador: " + maoJogador + "\nPontuacao do Jogador: " + valorDaMaoJogador + " pontos\n");
		}
	}
	
	
	// Metodo que retorna uma carta valida para o jogo Sete E Meio.
	private static Carta distribuiCarta (Baralho baralho) {
		Carta carta = baralho.pegaCarta();
		while (carta.getValor() > 7 && carta.getValor() < 11) {
			carta = baralho.pegaCarta();
		}
		return carta;
	}
	
	
	// Metodo que muda o valor das cartas REI, DAMA e VALETE.
	private static double mudaValor (Carta carta) {
		double valor;
		if (carta.getValor() >= 11)
			valor = 0.5;
		else
			valor = carta.getValor();
		return valor;
	}

}