package p2.testes;

import java.util.Scanner;

public class ContadorDeCaracteres {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o texto:");
		String texto = sc.nextLine();
		
		System.out.println("O texto possui: " + texto.length() + " caracteres.");
	}
}
