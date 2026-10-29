package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	// List<> -> Generics, é o "tipo" da lista
	private List<Quarto> quartos;
	
	public Hotel() {
		this.quartos = new ArrayList<Quarto>();
	}
	
	public List<Quarto> getQuartos() { return this.quartos; }
	
	public void adicionarQuarto(int numeroQuarto, double valorDiaria,
								Tipo tipo, Disponibilidade disponibilidade) {
		Quarto quarto = new Quarto(numeroQuarto, valorDiaria, tipo, disponibilidade);
		
		this.quartos.add(quarto);
	}

	public void adicionarQuarto(Quarto quarto) {
		this.quartos.add(quarto);		
	}
	// Sobrecarga
	// Pode ser usado para reservar para um dia 
	public void reservar(int numeroQuarto) {
		
	}
	// Pode ser usado para reservar por diversos dias
	public void reservar(int numeroQuarto, int dias) {
		
	}
}
