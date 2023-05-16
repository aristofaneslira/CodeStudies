package lp2.lab09;

import java.util.*;

public class Usuario {
	private String nome;
	private final int MATRICULA;
	private float saldo;
	private List<Usuario> devedores;
	private List<Float> dividas;

	public Usuario(String nome, int matricula) {
		this.nome = nome;
		this.MATRICULA = matricula;
		devedores = new ArrayList<Usuario>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getMatricula() {
		return MATRICULA;
	}
	
	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void addDevedor(Usuario usuario, float divida) {
		devedores.add(usuario);
		dividas.add(divida);
	}
	
	public void removerDevedor(Usuario usuario, float valor) {
		if (valor == dividas.get(devedores.indexOf(usuario))) {
			dividas.remove(devedores.indexOf(usuario));
			devedores.remove(usuario);
		}	
		else if (valor < dividas.get(devedores.indexOf(usuario)))
			dividas.add(devedores.indexOf(usuario), usuario.getSaldo() - valor);
	}
	
	public float getSaldoEntre(Usuario devedor) {
		if (! (devedores.contains(devedor)))
			return 0;
		return dividas.get(devedores.indexOf(devedor));
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nMatricula: " + getMatricula();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Usuario))
			return false;
		Usuario usuario = (Usuario) obj;
		return getMatricula() == usuario.getMatricula();
	}
}
