package lp2.lab09;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Banco banco = new Banco();
		String opcao;
		final String MENU = "MENU:\n 1 - Adicionar novo usuario.\n 2 - Nova divida.\n 3 - Novo pagamento.\n 4 - Simplificar.\n 5 - Sair.\nDigite o numero de sua opcao:";
		final String ADD_USUARIO = "1", NOVA_DIVIDA = "2", NOVO_PAGAMENTO = "3", SIMPLIFICAR = "4", SAIR = "5";
		
		System.out.println(MENU);
		opcao = sc.next();
		
		while (! (opcao.equals(ADD_USUARIO) || opcao.equals(NOVA_DIVIDA) || opcao.equals(NOVO_PAGAMENTO) || opcao.equals(SIMPLIFICAR) || opcao.equals(SAIR))) {
			System.out.println("Opcao invalida.");
			System.out.println(MENU);
			opcao = sc.next();
		}
		
		do {
			if (opcao.equals(ADD_USUARIO)) {
				System.out.println("Digite o nome:");
				String nome = sc.next();
				System.out.println("Digite a matricula:");
				int matricula = sc.nextInt();
				
				try {
					banco.addUsuario(nome, matricula);
				} catch (Exception e) {
					System.out.println(e.getMessage());;
				}
				
			}
			else if (opcao.equals(NOVA_DIVIDA)) {
				System.out.println("Digite a matricula do credor:");
				int matriculaCredor = sc.nextInt();
				System.out.println("digite a matricula do devedor:");
				int matriculaDevedor = sc.nextInt();
				System.out.println("Digite o valor do emprestimo:");
				float valor = sc.nextFloat();
				
				try {
					banco.novoEmprestimo(matriculaCredor, matriculaDevedor, valor);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else if (opcao.equals(NOVO_PAGAMENTO)) {
				System.out.println("Digite a matricula do pagador:");
				int matriculaPagador = sc.nextInt();
				System.out.println("digite a matricula do beneficiario:");
				int matriculaBeneficiario = sc.nextInt();
				System.out.println("Digite o valor do pagamento:");
				float valor = sc.nextFloat();
				
				try {
					banco.novoPagamento(matriculaPagador, matriculaBeneficiario, valor);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			else if (opcao.equals(SIMPLIFICAR)) {
				banco.simplificaContas();
			}
			
			System.out.println(MENU);
			opcao = sc.next();
			while (! (opcao.equals(ADD_USUARIO) || opcao.equals(NOVA_DIVIDA) || opcao.equals(NOVO_PAGAMENTO) || opcao.equals(SIMPLIFICAR) || opcao.equals(SAIR))) {
				System.out.println("Opcao invalida.");
				System.out.println(MENU);
				opcao = sc.next();
			}
		} while (! (opcao.equals(SAIR)));
	}

}
