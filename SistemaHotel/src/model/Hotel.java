package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
public class Hotel {
	// Exercício 10 - List<Quarto>
	private List<Quarto> quartos;
	private List<Reserva> reservas;
	// Exercício 13
	public Set<String> servicos;
	
	public Hotel() {
		this.quartos = new ArrayList<Quarto>();
		this.reservas = new ArrayList<Reserva>();
		this.servicos = new HashSet<String>();
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}	
	
	public void adicionarQuarto(int numero, 
								double valorDiaria,
								Tipo tipo,
								Disponibilidade disponibilidade) {
	
		Quarto quarto = new Quarto(numero,
								   valorDiaria,
								   tipo,
								   disponibilidade);
		this.quartos.add(quarto);
	}
	
	public void adicionarQuarto(Quarto quarto) {
		this.quartos.add(quarto);
	}
	
	public void listarQuartos() {
		for(Quarto q : this.quartos) {
			System.out.println(q.toString());
		}
	}
	
	public List<Quarto> 
		filtrar(Predicate<Quarto> criterio){
		
		//List<Quarto> resultado = new ArrayList<Quarto>();
		
		//for(Quarto q : this.quartos) {
			//if(criterio.test(q)) {
				//resultado.add(q);
			//}
		//}
		
		return quartos.stream().filter(criterio).toList();
	}
	
	// Exercício 5 - sobrecarga do método pois tem parâmetros diferentes
	public void reservar(int quarto) {
		
	}
	
	public void reservar(int quarto, int dias) {
		
	}
	
	// Exercício 7 - sobrecarga do método buscarQuarto
	public Optional<Quarto> buscarQuarto(int numero) {
		return quartos.stream().filter(q -> q.getNumero() == numero).findFirst();
	}
	
	public List<Quarto> buscarQuarto(Tipo tipo) {
		return quartos.stream().filter(q -> q.getTipo() == tipo).toList();
	}
	
	public List<Quarto> buscarQuarto(Disponibilidade disp) {
		return quartos.stream().filter(q -> q.getDisponibilidade() == disp).toList();
	}
}
