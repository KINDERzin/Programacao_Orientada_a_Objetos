package model;

public enum Tipo {
	SIMPLES,
	DUPLO(2),
	SUITE(4),
	COBERTURA(2),
	SUPER_PREMIUM(4);
	
	private int capacidade;

	private Tipo(int capacidade) {
		this.capacidade = capacidade;
	}
	
	private Tipo() {
		
	}
	
	public int getCapacidade() {
		return this.capacidade;
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
}
