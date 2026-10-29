package model;

public class Moto extends Veiculo{
	
	public Moto(String placa, String modelo) {
		super(placa, modelo);
	}

	@Override
	public Double calcularPedagio() {
		return 6.25;
	}
	
}
