package model;

// Exercício 4 - sobrescrita de processar()
public class PagamentoCartao extends Pagamento{
	@Override
	void processar() {
		System.out.println("Pagamento com cartão");
	}
}
