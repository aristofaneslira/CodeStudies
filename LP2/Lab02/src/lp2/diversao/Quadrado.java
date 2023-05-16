package lp2.diversao;

import java.util.Scanner;

public class Quadrado {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho;
		
		System.out.println("Tamanho do quadrado (entre 1 e 20): ");
		tamanho = sc.nextInt();
		
		for (int i = 1; i <= tamanho; i++) {
			System.out.print("*");
		}
		System.out.print("\n");
		String lados2e3 = "*";
		for (int i = 1; i <= tamanho - 2; i++) {
			lados2e3 += " ";
		}
		for (int i = 1; i <= tamanho - 2; i++) {
			System.out.println(lados2e3 + "*");
		}
		if (tamanho > 1) {
			for (int i = 1; i <= tamanho; i++) {
				System.out.print("*");
			}
		}
	}

}