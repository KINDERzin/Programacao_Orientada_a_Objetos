package model;

public enum Tipo {
	SIMPLES(1),
	DUPLO(2),
	SUITE(4),
	COBERTURA(2);
	
	private Integer capacidade;
	
	private Tipo(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public int getCapacidade() { return this.capacidade; }
}