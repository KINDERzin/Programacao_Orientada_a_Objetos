package controller;

import java.util.List;

import interfaces.Autenticavel;
import model.Caminhao;
import model.Carro;
import model.FornecedorParceiro;
import model.Moto;
import model.OperadorPedagio;
import model.Veiculo;

public class Main {
	
	public static double processarPedagio(Veiculo v) {
		System.out.println("O valor do pedágio é: " + v.calcularPedagio());
		return v.calcularPedagio();
	}
	
	public static void Main(String[] args) {
		FornecedorParceiro fornecedor = new FornecedorParceiro("Sem parar", "aaaa00");
		OperadorPedagio operador = new OperadorPedagio("EPR", "casa123");
		Autenticavel[] usuarios = {fornecedor, operador};
		
		for(Autenticavel a : usuarios) {
			System.out.println(a.autenticar("aaa00"));
		}
	}
}
