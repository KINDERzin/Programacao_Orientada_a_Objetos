package model;

public class Quarto {
	private int numero;
	private double valorDiaria;
	private Tipo tipo;
	private Disponibilidade disponibilidade;
	
	public Quarto(int numero, double valorDiaria) {
		this.numero = numero;
		this.valorDiaria = valorDiaria;
	}
	
	public Quarto(int numero) {
		this.numero = numero;
	}
	
	public Quarto(int numero, 
			double valorDiaria, 
			Tipo tipo,
			Disponibilidade disponibilidade) {
		this.numero = numero;
		this.valorDiaria = valorDiaria;
		this.tipo = tipo;
		this.disponibilidade = disponibilidade;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	@Override
	public String toString() {
		return "Quarto " 
					+ this.numero 
					+ " - R$ " + this.valorDiaria ;
	}

	public Tipo getTipo() {
		return tipo;
	}
}
