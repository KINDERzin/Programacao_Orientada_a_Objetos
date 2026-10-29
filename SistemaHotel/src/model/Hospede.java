package model;

public class Hospede {
	private String cpf;
	private String nome;
	
	// Sobrecarga do construtor, mudando apenas os parâmetros
	public Hospede(String c, String n) {
		setNome(n);
		setCpf(c);
	}
	
	public Hospede(String c) {
		setCpf(c);
	}
	
	public void setNome(String nome) {
		if(nome.trim().isBlank())
			System.out.println("Nome inválido!");
		else
			this.nome = nome; 
	}
	public String getNome() { return this.nome; }

	public void setCpf(String cpf) {
		if(cpf.trim().isBlank() || cpf.trim().length() != 11)
			System.out.println("Cpf inválido");
		else
			this.cpf = cpf;
	}
	public String getCpf() { return this.cpf; }
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " | Cpf: " + this.cpf; 
	}
}
