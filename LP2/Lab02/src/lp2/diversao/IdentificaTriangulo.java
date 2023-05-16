package lp2.diversao;

import java.util.*;

public class IdentificaTriangulo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2, n3;
		
		System.out.println("Entre com o primeiro inteiro:");
		n1 = sc.nextInt();
		System.out.println("Entre com o segundo inteiro:");
		n2 = sc.nextInt();
		System.out.println("Entre com o terceiro inteiro:");
		n3 = sc.nextInt();
		
		if ((n3 < n1 + n2) && (n2 < n3 + n1) && (n1 < n3 + n2)) {
			if (n1 == n2 && n2 == n3) {
				System.out.println("Eh Triangulo.\nEQUILATERO.");
			}
			else if (n1 != n2 && n2 != n3 && n1 != n3) {
				System.out.println("Eh Triangulo.\nESCALENO.");
			}
			else {
				System.out.println("Eh Triangulo.\nISOSCELES.");
			}
		}
		else {
			System.out.println("Nao eh triangulo.");
		}
	}
}
