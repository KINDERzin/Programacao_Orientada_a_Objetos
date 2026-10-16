package model;

import java.time.LocalDate;

public class ReciboPedagio {
	private final String idVeiculo;
	private final Double valor;
	private final LocalDate data;
	
	public ReciboPedagio(String id, double valor, LocalDate data) {
		this.idVeiculo = id;
		this.valor = valor;
		this.data = data;
	}
	
	public String getIdVeiculo() { return idVeiculo; }
	
	public Double getVlaor() { return this.valor; }
	
	public LocalDate getData() { return this.data; }
	
	@Override
	public String toString() { return ("Recibo\n\nVeículo: " + this.idVeiculo + "\nValor: " + this.valor); }
}
