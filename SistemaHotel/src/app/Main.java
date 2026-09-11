package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

import model.Disponibilidade;
import model.FormaPagamento;
import model.Hospede;
import model.Hotel;
import model.Quarto;
import model.Reserva;
import model.StatusReserva;
import model.Tipo;
import model.CategoriaHospede;
import utils.ComparadorPorNumero;
import utils.ComparadorPorPreco;
import utils.FiltroPorDisponibilidade;

public class Main {

	public static void main(String[] args) {
		// Exercício 9
		List<String> nomes = new ArrayList<String>();
		
		nomes.add("Francisco");
		nomes.add("Daniel");
		nomes.add("Heleonora");
		nomes.add("Carlos");
		nomes.add("Britney");

		for(String s : nomes) {
			System.out.println(s);
		}
		
		// Exercício 11
		Quarto q1 = new Quarto(101, 180.0, Tipo.SIMPLES, Disponibilidade.DISPONIVEL);
		Quarto q2 = new Quarto(105, 110.0, Tipo.DUPLO, Disponibilidade.OCUPADO);
		Quarto q3 = new Quarto(103, 500.0, Tipo.COBERTURA, Disponibilidade.DISPONIVEL);
		Quarto q4 = new Quarto(104, 280.0, Tipo.SUITE, Disponibilidade.DISPONIVEL);
		Quarto q5 = new Quarto(102, 250.0, Tipo.SIMPLES, Disponibilidade.MANUTENCAO);

		Hotel hotel = new Hotel();
		
		hotel.adicionarQuarto(q1);
		hotel.adicionarQuarto(q2);
		hotel.adicionarQuarto(q3);
		hotel.adicionarQuarto(q4);
		hotel.adicionarQuarto(q5);
		
		for(Quarto q : hotel.getQuartos()) {
			System.out.println(q.toString());
		}
		
		Random r = new Random();
		
		hotel.getQuartos().remove(r.nextInt(0, hotel.getQuartos().size()));
		
		for(Quarto q : hotel.getQuartos()) {
			System.out.println(q.toString());
		}
		
		Tipo t = Tipo.DUPLO;
		
		for(Quarto q : hotel.filtrar(q -> q.getTipo() == t && q.getValorDiaria() < 200.0)) {
			System.out.println(q);
		}

		// Exercício 12
		Double media = 0.0;
		
		for(Quarto q : hotel.getQuartos()) {
			media += q.getValorDiaria();
		}
		
		media /= hotel.getQuartos().size();
		
		System.out.println("Média do preço dos quartos: " + media);
		
		// Exercício 13 - continuação
		
		hotel.servicos.add("Wi-Fi");
		hotel.servicos.add("Piscina");
		hotel.servicos.add("Academia");
		hotel.servicos.add("Wi-Fi");
		
		// O Set não permite duplicatas
		System.out.println(hotel.servicos);
		
		// Exercício 14 
		Map<Integer, String> relacao = new HashMap<Integer, String>();

		for(int i = 0; i < 5; i++) {
			int index_q = r.nextInt(0, hotel.getQuartos().size() - 1);
			int index_p = r.nextInt(0, nomes.size() - 1);
			
			Quarto q = hotel.getQuartos().get(index_q);
			
			relacao.put(q.getNumero(), nomes.get(index_p));
		}
		
		// Exercício 15
		Map<Integer, Quarto> relacao2 = new HashMap<Integer, Quarto>();
		
		for(Quarto q : hotel.getQuartos())
			relacao2.put(q.getNumero(), q);

		System.out.println("Buscando o quarto 102");
		Quarto quartoAlvo = relacao2.get(102); // (chave, resultado)
		System.out.println(quartoAlvo.toString());
			
		// Exercício 16
		List lista; // Genérico
		List<Quarto> lista_q; // Apenas Quarto
		
		// Exercício 24
		//compare(q1, q2) < 0 - q1 é mais caro que q2
		//compare(q1, q2) == 0 q1 e q2 tem o mesmo preço
		//compare(q1, q2) > 0 q1 é mais barato que q2
		
		hotel.getQuartos().sort((n1,n2) ->
        	Integer.compare(n1.getNumero(), n2.getNumero())
        );
	}
}
