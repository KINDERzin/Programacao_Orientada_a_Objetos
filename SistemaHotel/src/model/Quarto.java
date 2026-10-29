package model;

public class Quarto {
	private Integer numero;
	private Double valorDiaria;
	private Tipo tipo;
	private Disponibilidade disponibilidade;
	
	public Quarto(int n, double valor, Tipo t, Disponibilidade disp) {
		setNumero(n);
		setValorDiaria(valor);
		this.tipo = t;
		this.disponibilidade = disp;
	}
	
	public Integer getNumero() { return numero; }
	public void setNumero(Integer numero) {
		if(numero < 0)
			System.out.println("Número de quarto inválido!");
		else
			this.numero = numero;
	}
	
	public Double getValorDiaria() { return this.valorDiaria; }
	public void setValorDiaria(Double valorDiaria) {
		if(valorDiaria == null)
			this.valorDiaria = 0.0; 
		if(valorDiaria < 0.0)
			System.out.println("Vai paga o cliente para dormir???");
		else if(valorDiaria == 0.0)
			System.out.println("Hotel gratuito?");
		else
			this.valorDiaria = valorDiaria;
	}
	
	public Disponibilidade getDisponibilidade() { return this.disponibilidade; }
	public Tipo getTipo() { return this.tipo; }
	
	@Override
	public String toString() {
		return "Quarto " + getNumero() + " | " + getValorDiaria() + " reais.";
	}
	
}
