package model;

public abstract class Veiculo {
	
	private final String placa;
	private String modelo;
	
	public Veiculo(String placa, String modelo) {
		this.placa = placa;
		setModelo(modelo);
	}
	
	public String getPlaca() { return placa; }

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) { this.modelo = modelo; }

	public abstract Double calcularPedagio();
	
	public void getResumo() {
		System.out.println("Placa: " + this.placa + " | Modelo: " + this.modelo);
	}
}
