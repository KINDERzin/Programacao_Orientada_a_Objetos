package app;

import Utils.ComparadorPorPreco;
import model.Disponibilidade;
import model.Hotel;
import model.Quarto;
import model.Tipo;

public class Main {
	public static void main(String[] args) {
		// Declaração dos quartos
		Quarto q1 = new Quarto(101, 180.0, Tipo.SIMPLES, Disponibilidade.DISPONIVEL);
		Quarto q2 = new Quarto(102, 120.0, Tipo.DUPLO, Disponibilidade.MANUTENCAO);
		Quarto q3 = new Quarto(103, 500.0, Tipo.COBERTURA, Disponibilidade.OCUPADO);
		// Desclaração do hotel
		Hotel hotel = new Hotel();
		// Adiciona os quartos ao ArrayList
		hotel.adicionarQuarto(q1);
		hotel.adicionarQuarto(q2);
		hotel.adicionarQuarto(q3);
		// Ordena os valores dos quartos
//		hotel.getQuartos().sort(new ComparadorPorPreco());
		// Função lambda
		hotel.getQuartos().sort((qu1, qu2) -> Double.compare(qu1.getValorDiaria(), qu2.getValorDiaria()));

		for(Quarto q : hotel.getQuartos())
			System.out.println(q.getValorDiaria());		
	}
}
