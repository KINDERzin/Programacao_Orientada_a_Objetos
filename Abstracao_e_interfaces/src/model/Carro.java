package model;

public class Carro extends Veiculo {
	
	public Carro(String modelo, String placa) {
		super(placa, modelo);
	}
	
	@Override
	public Double calcularPedagio() {
		return 9.90;
	}
}
