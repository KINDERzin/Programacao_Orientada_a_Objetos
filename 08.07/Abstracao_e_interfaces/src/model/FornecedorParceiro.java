package model;

import interfaces.Autenticavel;

public class FornecedorParceiro implements Autenticavel {
	private String empresa;
	private String token;
	
	public FornecedorParceiro(String empresa, String token) {
		super();
		this.empresa = empresa;
		this.token = token;
	}
	
	@Override
	public boolean autenticar(String credencial) {
		return token.equals(credencial);
	}
}
