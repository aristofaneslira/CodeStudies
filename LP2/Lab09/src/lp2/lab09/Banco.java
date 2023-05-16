package lp2.lab09;

import java.util.*;

public class Banco {
	private List<Usuario> usuarios;
	
	public Banco() {
		usuarios =  new ArrayList<Usuario>();
	}
	
	public void addUsuario(String nome, int matricula) throws Exception {
		Usuario usuario = new Usuario(nome, matricula);
		
		if (usuarios.contains(usuario))
			throw new Exception("Usuario ja esta cadastrado.");
		usuarios.add(usuario);
	}
	
	public void novoEmprestimo(int matriculaCredor, int matriculaDevedor, float valor) throws Exception {
		Usuario credor = verificaCadastro(matriculaCredor);
		Usuario devedor = verificaCadastro(matriculaDevedor);
		if (credor.equals(null) || devedor.equals(null))
			throw new Exception("Credor ou devedor nao existem.");
		if (valor < 0)
			throw new Exception("Valor menos que zero nao e valido");
		
		devedor.setSaldo(devedor.getSaldo() - valor);
		credor.setSaldo(credor.getSaldo() + valor);
		credor.addDevedor(devedor, valor);	
	}
	
	public void novoPagamento(int matriculaPagador, int matriculaBeneficiario, float valor) {
		Usuario pagador = verificaCadastro(matriculaPagador);
		Usuario beneficiario = verificaCadastro(matriculaBeneficiario);
		if (pagador.equals(null) || beneficiario.equals(null))
			throw new IllegalArgumentException("Credor ou devedor nao existem.");
		if (valor < 0)
			throw new IllegalArgumentException("Valor menos que zero nao e valido");
		
		pagador.setSaldo(pagador.getSaldo() + valor);
		beneficiario.setSaldo(beneficiario.getSaldo() - valor);
		beneficiario.removerDevedor(pagador, valor);
	}
	
	public float getSaldoEntre(int matriculaCredor, int matriculaDevedor) {
		Usuario credor = verificaCadastro(matriculaCredor);
		Usuario devedor = verificaCadastro(matriculaDevedor);
		if (credor.equals(null) || devedor.equals(null))
			throw new IllegalArgumentException("Credor ou devedor nao existem.");
		
		return credor.getSaldoEntre(devedor);
	}
	
	public void simplificaContas() {
		System.out.println("metodo nao implementado");
	}
	
	private Usuario verificaCadastro(int matricula) {
		for (Usuario u : usuarios) {
			if (u.getMatricula() == matricula)
				return u;
		}
		return null;
	}
		
		
}
