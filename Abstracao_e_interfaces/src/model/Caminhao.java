package model;

import interfaces.Rastreavel;
import interfaces.Tributavel;

public class Caminhao extends Veiculo implements Rastreavel, Tributavel{
	
	private Integer qtdEixo;
	
	public Caminhao(String placa, String modelo, int eixo) {
		super(placa, modelo);
		this.qtdEixo = eixo;
	} 
	
	@Override
	public Double calcularPedagio() {
		return qtdEixo * 9.5;
	}
	
	@Override
	public void getResumo() {
		System.out.println("Placa: " + this.getPlaca() + " | Modelo: " + getModelo() + " | Eixo: " + this.qtdEixo);
	}
	
	@Override
	public double getValorImposto() { return 200.0; }

	@Override
	public String getPosicaoAtual() { return "-23.571935, -51.424905"; }
	
}
