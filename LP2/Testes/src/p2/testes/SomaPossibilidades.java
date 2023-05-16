package p2.testes;

public class SomaPossibilidades {
	public static void main(String[] args) {
		String[] possibilidades = {"", "", "DOIS", "TRES", "QUATRO", "CINCO", "SEIS", "SETE", "OITO", "NOVE", "DEZ", "ONZE", "DOZE"};
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				int soma = i + j;
				
				System.out.println(possibilidades[soma] + " " + paridade(soma));
			}
		}
	
		System.out.println("" + (3/0));	
	}
	
	private static String paridade(int soma) {
		if (soma % 2 == 0) {return "par";}
		else {return "impar";}
	}
}
