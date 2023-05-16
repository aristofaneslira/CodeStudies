/*
 * Enio Abrantes 21121658
 * Aristofanes Santos de Lira 21121396
 * 
 */

package lp2.lab08;

public class DominoAutomatico {
	final static int PECAS_PARA_CADA_JOGADOR = 7;
	
	public static void main(String[] args) throws Exception {
		
		
		Domino domino = new Domino();
		Mesa mesa = new Mesa();
		
		Jogador jogador1 = new Jogador("Rodrigo", 0);
		Jogador jogador2 = new Jogador("Bernard", 0);
		Jogador jogador3 = new Jogador("Demetrio", 1);
		Jogador jogador4 = new Jogador("Rafael", 1);
		
		domino.baralhar();
		
		distribuiPecas(domino, jogador1);
		distribuiPecas(domino, jogador2);
		distribuiPecas(domino, jogador3);
		distribuiPecas(domino, jogador4);
		
		boolean passaJogador1 = true, passaJogador2 = true, passaJogador3 = true, passaJogador4 = true;
		
		while (! (passaJogador1 == false && passaJogador2 == false && passaJogador3 == false && passaJogador4 == false)) {
			if (! (temPeca(jogador1)))
				break;
			else if (! (temPeca(jogador2)))
				break;
			else if (! (temPeca(jogador3)))
				break;
			else if (! (temPeca(jogador4)))
				break;
			
			if (jogador1.joga(mesa)) {
				System.out.println(mesa);
				System.out.println(jogador1.getNome() + " jogou.");
				passaJogador1 = true;

			}else {
				System.out.println(jogador1.getNome() + " passou a vez.");
				passaJogador1 = false;
			}
			
			if (jogador2.joga(mesa)) {
				System.out.println(mesa);
				System.out.println(jogador2.getNome() + " jogou.");
				passaJogador2 = true;
			}else {
				System.out.println(jogador2.getNome() + " passou a vez.");
				passaJogador2 = false;
			}
			
			if (jogador3.joga(mesa)) {
				System.out.println(mesa);
				System.out.println(jogador3.getNome() + " jogou.");
				passaJogador3 = true;
			}else {
				System.out.println(jogador3.getNome() + " passou a vez.");
				passaJogador3 = false;
			}
			
			if (jogador4.joga(mesa)) {
				System.out.println(mesa);
				System.out.println(jogador4.getNome() + " jogou.");
				passaJogador4 = true;
			}else {
				System.out.println(jogador4.getNome() + " passou a vez.");
				passaJogador4 = false;
			}
			
			if (passaJogador1 == false && passaJogador2 == false && passaJogador3 == false && passaJogador4 == false)
				System.out.println("Fim de Partida. Houve empate.");
		}
	}
	
	public static void distribuiPecas(Domino domino, Jogador jogador) {
		for (int i = 0; i < PECAS_PARA_CADA_JOGADOR; i++) {
			jogador.adicionaPeca(domino.pegaPeca());
		}
	}
	
	public static boolean temPeca(Jogador jogador) {
		if (jogador.pecasNaMao() > 0)
			return true;
		System.out.println(jogador.getNome() + " venceu a partida.");
		return false;
	}
}
