package model;
// Exercício 6 - Hospede foi herdado de Pessoa e o método teve sobrescrita de assinatura
public class Hospede extends Pessoa{
	// Exercício 1 - cpf e nome
	private String nome;
	private String cpf;
	private CategoriaHospede tipo;
	
	// Exercício 2 - sobrecarga de construtor
	public Hospede(String nome, String cpf, CategoriaHospede tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}
	
	
	public Hospede(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Hóspede: " + nome + " - CPF: " + cpf;
	}
	
	public void setTipoHospede(CategoriaHospede tipo) {
		this.tipo = tipo;
	}
	// Exercício 6 - sobrescrita do método
	@Override
	void identificar() {
		System.out.println("Hóspede: " + this.nome);
	}
}
