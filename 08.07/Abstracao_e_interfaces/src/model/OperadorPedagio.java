package model;

import interfaces.Autenticavel;

public class OperadorPedagio implements Autenticavel {
	private String nome;
	private String senha;
	
	public OperadorPedagio(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	
	@Override
	public boolean autenticar(String credencial) {
		return senha.equals(credencial);
	}
}
