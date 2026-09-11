package model;

public class Reserva {
	private Quarto quarto;
	private Hospede hospede;
	// Exercício 18 - pt1
	private StatusReserva status;
	private FormaPagamento formaPagamento;
	
	public Reserva(Quarto quarto, 
					Hospede hospede, 
					StatusReserva status,
					FormaPagamento formaPagamento) {
		this.quarto = quarto;
		this.hospede = hospede;
		this.status = status;
		this.formaPagamento = formaPagamento;
	}

	// Exercício 18 - pt2
	@Override
	public String toString() {
		return "Quarto: " + quarto + ", hospede: " + hospede;
	}
	
	
	
	
	
}
